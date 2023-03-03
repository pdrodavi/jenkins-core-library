package br.dev.pedrodavi.jenkins.pipeline.rest

import javaposse.jobdsl.dsl.helpers.step.XShellContext

class Download implements Serializable {

    static def downFile(String remoteUrl) {
        def instance = XShellContext.newInstance()
        instance.commandLine("curl -# -O ${remoteUrl}")
    }

}
