import com.cloudbees.groovy.cps.NonCPS
import javaposse.jobdsl.dsl.DslFactory

@NonCPS
def call(DslFactory dslFactory, String pipelineId, String pipelineName, String gitRemoteURL, String credentialsId) {

    Boolean executeStage = true

    conditionalStage("createJob", executeStage) {
        dslFactory.freeStyleJob(pipelineId) {
            description("test")
            displayName(pipelineName)
            keepDependencies(false)
            scm {
                git {
                    remote {
                        name('origin')
                        url(gitRemoteURL)
                        credentials(credentialsId)
                    }
                    branch('main')
                }
            }
        }
    }

}
