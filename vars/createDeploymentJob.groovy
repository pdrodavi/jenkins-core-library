import br.dev.pedrodavi.jenkins.pipeline.job.CreateJob

def call() {

    CreateJob.ant(this, "test", "clean")

//    jobDsl scriptText: '''pipelineJob("job-test") {
//        definition {
//            cpsScm {
//                scm {
//                    git {
//                        remote {
//                            url("https://github.com/pdrodavi/app-quarkus-job-deploy.git")
//                        }
//                        branches(\'main\')
//                        extensions {
//                            cleanBeforeCheckout()
//                        }
//                    }
//                }
//                scriptPath("jobs/deploy.groovy")
//            }
//        }
//    }'''

}