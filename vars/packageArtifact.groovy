import org.jenkinsci.plugins.pipeline.modeldefinition.Utils
import br.dev.pedrodavi.jenkins.pipeline.utils.logging.*

def call() {

//    Logger.init(this, LogLevel.INFO)
    Logger log = new Logger(this)

    log.info(readMavenPom().getArtifactId())
    log.info("Realizando construção do artefato")
//    echo readMavenPom().getArtifactId()
//    echo readMavenPom().getVersion()
//    echo "Realizando construção do artefato"
    sh "mvn -Dmaven.test.skip=true -Dmaven.test.failure.ignore clean package"
}