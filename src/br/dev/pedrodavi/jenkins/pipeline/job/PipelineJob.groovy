package br.dev.pedrodavi.jenkins.pipeline.job

import groovy.transform.builder.Builder
import groovy.transform.builder.SimpleStrategy
import javaposse.jobdsl.dsl.DslFactory
import javaposse.jobdsl.dsl.Job

@Builder(builderStrategy = SimpleStrategy, prefix = '')
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

    Job build(DslFactory dslFactory) {
        dslFactory.freeStyleJob(this.pipelineId) {
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
