def call() {
//    container('maven') {
        println("Realizando construção do artefato")
        println("Artifact: " + readMavenPom().getArtifactId())
        println("Version: " + readMavenPom().getVersion())
        sh "mvn -Dmaven.test.skip=true -Dmaven.test.failure.ignore clean package"
//    }
}