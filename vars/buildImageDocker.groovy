def call() {
//    container('docker') {
        println("Criando a imagem Docker")
        sh "docker build -t ${readMavenPom().getArtifactId()}:${readMavenPom().getVersion()} ."
//    }
}