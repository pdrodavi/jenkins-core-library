def call() {
    def props = readJSON file: 'dev.json'
    echo props['ambiente']
    echo readMavenPom().getArtifactId()
    echo readMavenPom().getVersion()
    echo "Realizando construção do artefato"
    sh "mvn -Dmaven.test.skip=true -Dmaven.test.failure.ignore clean package"
}