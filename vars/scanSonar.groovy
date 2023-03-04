def call() {

    inputAnalysis = input([
            message: 'Analysis SonarQube?',
            parameters: [
                    choice(name: 'Analysis', choices: ['Yes', 'No'], description: 'Run on specific analysis')
            ]
    ])

    Boolean executeStage = false

    if ("${inputAnalysis}" == 'Yes') {
        executeStage = true
    }

    conditionalStage("Analysis SonarQube", executeStage) {

        if ("${inputAnalysis}" == 'Yes') {
            withSonarQubeEnv('sonarqube') {
                sh "mvn -B clean verify sonar:sonar"
            }
            def qualitygate = waitForQualityGate()
            if (qualitygate.status != "OK") {
                cleanWs()
                error "Pipeline aborted due to quality gate failure: ${qualitygate.status}"
            }
        } else {
            println("Step Skipped")
        }

    }



}