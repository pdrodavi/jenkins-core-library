package br.dev.pedrodavi.jenkins.pipeline.environment

class ReadMavenPom {

    static def pv() {
        return readMavenPom().getVersion()
    }

}
