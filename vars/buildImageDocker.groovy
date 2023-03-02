import static br.dev.pedrodavi.jenkins.pipeline.Commands.getProjectVersion

def call() {
    echo "Criando a imagem Docker"
    def version = getProjectVersion()
    echo version
    sh "docker build -t ${readMavenPom().getArtifactId()}:${readMavenPom().getVersion()} ."
}