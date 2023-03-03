package br.dev.pedrodavi.jenkins.pipeline.environment

class ReadMavenPom {

    static def pv() {
        return readMavenPom().getVersion()
    }

    static def pv2() {
        script {
            readMavenPom().getVersion()
        }
    }

}
