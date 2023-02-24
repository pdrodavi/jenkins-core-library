def call(Map args) {
    node {

        stage("Checkout") {
            gitCheckout(args.repo)
        }

        scanSonar()

        stage("Package") {
            packageArtifact()
        }

        stage("Build Image") {
            buildImageDocker()
        }

        publishToRegistry()

        stage("Prepare for Deploy") {
            prepareDeploy()
        }

//        stage("Deploying") {
//            startContainer()
//        }

    }
}