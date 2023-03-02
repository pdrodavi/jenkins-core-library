package br.dev.pedrodavi.jenkins.pipeline

import com.cloudbees.groovy.cps.NonCPS

class Commands implements Serializable {

    @NonCPS
    static String getProjectVersion() {
        return readMavenPom()
    }

}
