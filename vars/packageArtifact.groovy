import static br.dev.pedrodavi.jenkins.pipeline.utils.Cmds.*

def call() {
//    echo readMavenPom().getArtifactId()
//    echo readMavenPom().getVersion()
//    echo "Realizando construção do artefato"
    runPrint("Realizando construção do artefato")
//    runPrint(readMavenPom().getArtifactId())
//    runPrint(readMavenPom().getVersion())
    runSh("mvn -Dmaven.test.skip=true -Dmaven.test.failure.ignore clean package")
//    sh "mvn -Dmaven.test.skip=true -Dmaven.test.failure.ignore clean package"
}