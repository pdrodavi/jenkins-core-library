def call() {
    sh "docker rm -f ${readMavenPom().getArtifactId()}"
    sh "docker container create --name=${readMavenPom().getArtifactId()} --memory=256MB --memory-reservation=256MB --network=bridge --env-file=${env.WORKSPACE}/.env --restart=always --publish-all ${readMavenPom().getArtifactId()}:${readMavenPom().getVersion()}"
    sh "docker container start ${readMavenPom().getArtifactId()}"
    cleanWs()
}