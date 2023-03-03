package br.dev.pedrodavi.jenkins.pipeline.environment

import com.cloudbees.groovy.cps.NonCPS

class ReadMavenPom {

    static def pv() {
        return readMavenPom().getVersion()
    }

    @NonCPS
    static def pv2() {
        script {
            readMavenPom().getVersion()
        }
    }

}
