import br.dev.pedrodavi.jenkins.pipeline.Constants

def call() {

    inputPublish = input([
            message: 'Publish to Registry?',
            parameters: [
                    choice(name: 'Publish', choices: ['Yes', 'No'], description: 'Publish image to artifactory')
            ]
    ])

    Boolean executeStage = false

    if ("${inputPublish}" == 'Yes') {
        executeStage = true
    }

    conditionalStage("Publish", executeStage) {
        withDockerRegistry(credentialsId: Constants.JENKINS_JFROG_CREDENTIALS_ID, url: Constants.JENKINS_JFROG_URL_REGISTRY) {
            sh "docker tag ${env.JOB_BASE_NAME} srvextechnology.jfrog.io/registry-docker/${env.JOB_BASE_NAME}:latest"
            sh "docker push srvextechnology.jfrog.io/registry-docker/${env.JOB_BASE_NAME}:latest"
        }
    }

//    if ("${inputPublish}" == 'Yes') {
//
//    } else {
//        echo 'Step Skipped'
//    }

}
