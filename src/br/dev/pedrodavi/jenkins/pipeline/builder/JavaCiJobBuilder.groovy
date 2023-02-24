package br.dev.pedrodavi.jenkins.pipeline.builder

import groovy.transform.builder.Builder
import groovy.transform.builder.SimpleStrategy
import javaposse.jobdsl.dsl.DslFactory
import javaposse.jobdsl.dsl.Job

@Builder(builderStrategy = SimpleStrategy, prefix = '')
class JavaCiJobBuilder {

    DslFactory dslFactory
    String pipelineId
    String pipelineName
    String gitRemoteURL
    String credentialsId

    Job build() {
        this.dslFactory.job(this.pipelineId) {
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
