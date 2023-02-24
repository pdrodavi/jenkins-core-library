package br.dev.pedrodavi.jenkins.pipeline.job

import com.cloudbees.groovy.cps.NonCPS
import javaposse.jobdsl.dsl.DslFactory

class PipelineJob {

    private DslFactory dslFactory
    private String pipelineId
    private String pipelineName
    private String gitRemoteURL
    private String credentialsId

    PipelineJob(DslFactory dslFactory, String id, String displayName, String gitURL, String credentialsId) {
        this.dslFactory = dslFactory
        this.pipelineId = id
        this.pipelineName = displayName
        this.gitRemoteURL = gitURL
        this.credentialsId = credentialsId
    }

    @NonCPS
    def createJob() {
        this.dslFactory.freeStyleJob(this.pipelineId) {
            description("test")
            displayName(this.pipelineName)
            keepDependencies(false)
            scm {
                git {
                    remote {
                        name('origin')
                        url(this.gitRemoteURL)
                        credentials(this.credentialsId)
                    }
                    branch('main')
                }
            }
        }
    }
}
