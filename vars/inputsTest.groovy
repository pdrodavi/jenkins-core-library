def call(){

//    timeout(time: 1, unit: 'DAY') {
        script {
            // Show the select input modal
            def INPUT_PARAMS = input message: 'Please Provide Parameters', ok: 'Next',
                    parameters: [
                            choice(name: 'ENVIRONMENT', choices: ['dev','prod'].join('\n'), description: 'Please select the Environment'),
                            choice(name: 'DEPLOY', choices: ['yes', 'no'], description: 'Deploy?')]
            env.ENVIRONMENT = INPUT_PARAMS.ENVIRONMENT
            env.IMAGE_TAG = INPUT_PARAMS.DEPLOY
        }
//    }

    echo ${env.ENVIRONMENT}
    echo ${env.IMAGE_TAG}

}
