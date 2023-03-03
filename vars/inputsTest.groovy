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

        stage("Pass") {

            script {
                input message: 'Test', parameters: [password(defaultValue: 'pass', name: 'Pass')]
            }

        }

        stage("Input Common") {

            script {
                // This step pauses Pipeline execution and allows the user to interact and control the flow of the build.
                // Only a basic "process" or "abort" option is provided in the stage view
                input message: 'Common', ok: 'Proceed',
                        parameters: [
                                string(name: 'Common', description: 'Input Common', defaultValue: 'text'),
                        ]
            }

        }

        stage("Input Checkbox Boolean") {

            script {
                def userInputResult = input(
                        id: "userInput",
                        submitter: 'administrator',
                        submitterParameter: 'submitter',
                        message: "Are you sure to proceed?",
                        parameters: [
                                [$class: 'BooleanParameterDefinition',
                                 name: 'customBoolean',
                                 defaultValue: false,
                                 description: 'Are you sure what are you doing?']
                        ])
                echo "It was `${userInputResult.submitter}` who submitted the dialog."
                echo "Received `${userInputResult.customBoolean}` as submitted custom boolean parameter."
            }

        }

        stage("Input Checkbox Boolean Params") {

            script {
                def userInputResult = input(
                        id: "userInput",
                        submitter: 'administrator',
                        submitterParameter: 'submitter',
                        message: "Are you sure to proceed?",
                        parameters: [
                                [$class: 'BooleanParameterDefinition',
                                 name: 'valor1',
                                 defaultValue: false,
                                 description: 'Are you sure what are you doing?'],
                                [$class: 'BooleanParameterDefinition',
                                 name: 'valor2',
                                 defaultValue: false,
                                 description: 'Are you sure what are you doing 2?']
                        ])
//                echo "It was `${userInputResult.submitter}` who submitted the dialog."
//                echo "Received `${userInputResult.customBoolean}` as submitted custom boolean parameter."
            }

        }

        stage("Input Parâmetro de sequência de caracteres sem Trim") {

            script {
                input message: 'Test', parameters: [string(defaultValue: 'default', description: 'Parâmetro de sequência de caracteres', name: 'Parâmetro de sequência de caracteres')]
            }

        }

        stage("Input Parâmetro de sequência de caracteres com Trim") {

            script {
                input message: 'Test', parameters: [string(defaultValue: 'default', description: 'Parâmetro de sequência de caracteres', name: 'Parâmetro de sequência de caracteres', trim: true)]
            }

        }

        stage("Input Parâmetro de texto") {

            script {
                input message: 'Test', parameters: [text(defaultValue: 'default', description: 'Parâmetro de texto', name: 'Text')]
            }

        }

        stage("Input Text Area & Checkbox") {

            script {
                    def userInputResult = input(
                            id: "userInput",
                            submitter: 'administrator,jon,daenerys',
                            submitterParameter: 'submitter',
                            message: "Are you sure to proceed?",
                            parameters: [
                                    [$class: 'TextParameterDefinition',
                                     name: 'customText',
                                     defaultValue: "What's on your mind?",
                                     description: "What's on your mind?"],
                                    [$class: 'BooleanParameterDefinition',
                                     name: 'customBoolean',
                                     defaultValue: false,
                                     description: 'Are you sure what are you doing?']
                            ])
                    echo "It was `${userInputResult.submitter}` who submitted the dialog."
                    echo "Received `${userInputResult.customText}` as submitted custom text parameter."
                    echo "Received `${userInputResult.customBoolean}` as submitted custom boolean parameter."
            }

        }

    }

}
