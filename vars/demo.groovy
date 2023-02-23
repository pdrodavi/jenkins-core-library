import br.dev.pedrodavi.jenkins.pipeline.Demo
import org.codehaus.groovy.tools.shell.util.Logger

void call() {
    Logger log = new Logger(this)
    log.printf("Direto do objeto")

    Demo demo = new Demo()
    demo.sayHello()
}
