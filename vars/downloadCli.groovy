def call() {

    echo "http://host.docker.internal:8080/jnlpJars/jenkins-cli.jar"
    sh "curl -# -O http://host.docker.internal:8080/jnlpJars/jenkins-cli.jar"
    sh "pwd"
    sh "ls -la"

}

