def call(){

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

    script {
        input id: 'Btn', message: 'Test', ok: 'OK', submitter: 'approve', submitterParameter: 'store'
    }

    /*
    script {

        input {
            id 'deploy-approval'
            message 'Would you like to deploy?'
            ok 'Deploy'
            submitterParameter 'deploy-approved-by'
            parameters {
                agentParameter('TARGET_NAME')
            }
        }

    }*/

}
