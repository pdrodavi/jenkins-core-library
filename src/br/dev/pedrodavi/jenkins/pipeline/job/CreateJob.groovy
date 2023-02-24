package br.dev.pedrodavi.jenkins.pipeline.job

class CreateJob {

    static ant(dslFactory, jobName, antTargets) {
        dslFactory.job(jobName) {
            steps {
                ant(antTargets)
            }
        }
    }

}
