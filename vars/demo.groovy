import br.dev.pedrodavi.jenkins.pipeline.Demo
import br.dev.pedrodavi.jenkins.pipeline.utils.logging.Logger

void call() {
    Logger log = new Logger(this)
    log.info("Direto do objeto")

    Demo demo = new Demo()
    demo.sayHello()
}
