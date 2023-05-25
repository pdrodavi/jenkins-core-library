import br.dev.pedrodavi.jenkins.pipeline.model.Tool
import static br.dev.pedrodavi.jenkins.pipeline.utils.ConfigConstants.*

def call(Map args) {

    Map config = [
            (TOOLS): [
                    [ (TOOL_NAME): 'M3', (TOOL_TYPE): Tool.MAVEN ]
            ]
    ]

    node {

        setupTools(config)

        stage("Checkout") {
            gitCheckout(args.repo)

            script {
                inputAnalysis = input([
                                message: 'Analysis SonarQube?',
                                parameters: [
                                        choice(name: 'Analysis', choices: ['Yes', 'No'], description: 'Run on specific analysis')
                                ]
                        ])

                        if ("${inputAnalysis}" == 'Yes') {
                            env.SONARSKIP = true
                        } else {
                            env.SONARSKIP = false
                        }
            }

        }

        dir("${env.WORKSPACE}/${args.repo}") {

            stage("Analysis") {
                when {
                    environment name: 'SONARSKIP', value: 'true'
                }
                steps {
                    script {

                        withSonarQubeEnv('sonarqube') {
                                    sh "mvn -B clean verify sonar:sonar"
                                }
                                def qualitygate = waitForQualityGate()
                                if (qualitygate.status != "OK") {
                                    cleanWs()
                                    error "Pipeline aborted due to quality gate failure: ${qualitygate.status}"
                                }
                    }
                }
            }

            stage("Package") {
                packageArtifact()
            }

            stage("Build Image") {
                buildImageDocker()
            }

            publishToRegistry()

            stage("Prepare for Deploy") {
                prepareDeploy()
            }

        }

    }
}