def call() {
    echo "Criando a imagem Docker"
    sh "docker build -t ${readMavenPom().getArtifactId()}:${readMavenPom().getVersion()} ."
}