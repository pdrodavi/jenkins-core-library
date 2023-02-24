import javaposse.jobdsl.dsl.DslFactory

def call(String pipelineId, String pipelineName, String gitRemoteURL, String credentialsId) {

    DslFactory.newInstance().pipelineJob(pipelineId) {
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
