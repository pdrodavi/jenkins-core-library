def call(Map args) {
    node {

        stage("Checkout") {
            gitCheckout(args.repo)
        }

        scanSonar()

//        stage("Analysis SonarQube") {
//            scanSonar()
//        }

        stage("Package") {
            packageArtifact()
        }

        stage("Build Image") {
            buildImageDocker()
        }

//        stage("Publish to Registry") {
//            publishToRegistry()
//        }

        publishToRegistry()

        stage("Deploying") {
            startContainer()
        }

    }
}