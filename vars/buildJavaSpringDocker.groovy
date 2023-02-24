def call(Map args) {
    node {

        stage("Checkout") {
            gitCheckout(args.repo)
        }

        stage("Analysis SonarQube") {
            scanSonar()
        }

        stage("Package") {
            packageArtifact()
        }

        stage("Build Image") {
            buildImageDocker()
        }

        stage("Publish to Registry") {
            publishToRegistry()
        }

        stage("Deploying") {
            startContainer()
        }

    }
}