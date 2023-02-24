def createDeploymentJob(jobName, repoUrl) {
    pipelineJob(jobName) {
        definition {
            cpsScm {
                scm {
                    git {
                        remote {
                            url(repoUrl)
                        }
                        branches('master')
                        extensions {
                            cleanBeforeCheckout()
                        }
                    }
                }
                scriptPath("jobs/deploy.groovy")
            }
        }
    }
}

createDeploymentJob("job-test", "https://github.com/pdrodavi/app-quarkus-job-deploy.git")