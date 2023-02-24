def call() {

    inputEnvironment = input([
            message: 'Environment for Deploy',
            parameters: [
                    choice(name: 'Environment', choices: ['DEV', 'PRE', 'PROD OCULTO', 'PROD REAL'], description: 'Environment to deploy the application')
            ]
    ])

    Boolean executeStageDeployDev = false
    Boolean executeStageDeployPre = false
    Boolean executeStageDeployProdOc = false
    Boolean executeStageDeployProdReal = false

    if ("${inputEnvironment}" == 'DEV') {
        executeStageDeployDev = true
    } else if ("${inputEnvironment}" == 'PRE') {
        executeStageDeployPre = true
    } else if ("${inputEnvironment}" == 'PROD OCULTO') {
        executeStageDeployProdOc = true
    } else if ("${inputEnvironment}" == 'PROD REAL') {
        executeStageDeployProdReal = true
    }

    conditionalStage("Deploy DEV", executeStageDeployDev) {
        startContainer()
    }

    conditionalStage("Deploy PRE", executeStageDeployPre) {
        startContainer()
    }

    conditionalStage("Deploy PROD Oculto", executeStageDeployProdOc) {
        startContainer()
    }

    conditionalStage("Deploy PROD Real", executeStageDeployProdReal) {
        startContainer()
    }


}
