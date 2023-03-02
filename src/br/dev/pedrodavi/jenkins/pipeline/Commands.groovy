package br.dev.pedrodavi.jenkins.pipeline

import com.cloudbees.groovy.cps.NonCPS

class Commands implements Serializable {

    @NonCPS
    static String getProjectVersion() {
        def file = readFile('pom.xml')
        def project = new XmlSlurper().parseText(file)
        return project.version.text()
    }

}
