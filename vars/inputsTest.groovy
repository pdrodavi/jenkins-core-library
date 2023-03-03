def call(){

    node {

        stage("Multiples Choice") {

            script {
                // Show the select input modal
                def INPUT_PARAMS = input message: 'Please Provide Parameters', ok: 'Next',
                        parameters: [
                                choice(name: 'ENVIRONMENT', choices: ['dev','prod'].join('\n'), description: 'Please select the Environment'),
                                choice(name: 'DEPLOY', choices: ['yes', 'no'], description: 'Deploy?')]
                env.ENVIRONMENT = INPUT_PARAMS.ENVIRONMENT
                env.IMAGE_TAG = INPUT_PARAMS.DEPLOY

                echo "All parameters have been set as Environment Variables"
                echo "Selected Environment: ${env.ENVIRONMENT}"
                echo "Selected Tag: ${env.IMAGE_TAG}"
            }

        }

        stage("Approve or Abort") {

            script {
                input id: 'Btn', message: 'Test', ok: 'OK', submitter: 'approve', submitterParameter: 'store'
            }

        }

        stage("Run Execution") {

            script {
                input message: 'Test', parameters: [run(filter: 'STABLE', name: 'Parâmetro de execução', projectName: 'http://localhost:8080/job/core-fw/job/INPUTS-TESTS/')]
            }

        }

    }

}
