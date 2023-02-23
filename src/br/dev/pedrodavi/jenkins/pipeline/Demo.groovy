package br.dev.pedrodavi.jenkins.pipeline

import br.dev.pedrodavi.jenkins.pipeline.utils.logging.Logger

class Demo {

    Logger log

    Demo() {
        this.log = new Logger(this)
    }

    void sayHello() {
        log.info("Hello! Pela Classe")
    }
}
