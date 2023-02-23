package br.dev.pedrodavi.jenkins.pipeline

import org.codehaus.groovy.tools.shell.util.Logger

class Demo {

    Logger log

    Demo() {
        this.log = new Logger(this)
    }

    void sayHello() {
        log.printf("Hello! Pela Classe")
    }
}
