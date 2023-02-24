import br.dev.pedrodavi.jenkins.pipeline.model.Tool
import br.dev.pedrodavi.jenkins.pipeline.utils.logging.*
import static br.dev.pedrodavi.jenkins.pipeline.utils.ConfigConstants.*

def call(Map args) {

    Map config = [
            (TOOLS): [
                    [ (TOOL_NAME): 'M3', (TOOL_TYPE): Tool.MAVEN ]
            ],
            (LOGLEVEL): LogLevel.INFO
    ]

    Logger.init(this, config)

    node {

        setupTools(config)

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

    }
}