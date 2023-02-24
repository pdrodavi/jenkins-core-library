import br.dev.pedrodavi.jenkins.pipeline.builder.GradleCiJobBuilder
import br.dev.pedrodavi.jenkins.pipeline.job.PipelineJob
import javaposse.jobdsl.dsl.DslFactory
import br.dev.pedrodavi.jenkins.pipeline.Constants
import javaposse.jobdsl.dsl.Job
import javaposse.jobdsl.dsl.JobParent

def call() {

    node {

//        stage("PipelineJob") {
//            PipelineJob job = new PipelineJob(this as DslFactory, '1', 'test',
//                    'https://github.com/pdrodavi/app-quarkus-job-deploy.git', Constants.JENKINS_GITHUB_CREDENTIALS_ID)
//            job.createJob()
//        }

        stage("PipelineJob2") {
            GradleCiJobBuilder builder = new GradleCiJobBuilder()
                    .name('test-job')
                    .description('testing')
                    .ownerAndProject('pdrodavi/app-quarkus-job-deploy')
                    .tasks('clean')
            JobParent jobParent = new JobParent() {
                @Override
                Object run() {
                    Job job = builder.build(jobParent)
                    return job
                }
            }
        }

//        createJob(this as DslFactory, "EXAMPLE_JOB_ID", "EXAMPLE_JOB_NAME", "https://github.com/pdrodavi/app-quarkus-job-deploy.git", Constants.JENKINS_GITHUB_CREDENTIALS_ID)

    }

//    def myJob = job('example')
//    CreateJob.addMyFeature(myJob)

//    CreateJob.ant(this, "test", "clean")

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