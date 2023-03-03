package br.dev.pedrodavi.jenkins.pipeline.rest

class Download implements Serializable {

    static def downFile(String remoteUrl) {
        sh "curl -# -O ${remoteUrl}"
    }

}
