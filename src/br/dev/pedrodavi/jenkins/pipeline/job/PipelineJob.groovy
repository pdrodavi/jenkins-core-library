package br.dev.pedrodavi.jenkins.pipeline.job

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

    def createJob() {
        this.dslFactory.pipelineJob(this.pipelineId) {
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
