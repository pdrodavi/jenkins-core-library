import br.dev.pedrodavi.jenkins.pipeline.Constants

def call(String repo){

    timeout(time: 30, unit: 'SECONDS') {
        script {
            // Show the select input modal
            def INPUT_PARAMS = input message: 'Please Provide Parameters', ok: 'Next',
                    parameters: [
                            choice(name: 'ENVIRONMENT', choices: ['dev','prod'].join('\n'), description: 'Please select the Environment'),
                            choice(name: 'DEPLOY', choices: ['yes', 'no'], description: 'Deploy?')]
            env.ENVIRONMENT = INPUT_PARAMS.ENVIRONMENT
            env.IMAGE_TAG = INPUT_PARAMS.DEPLOY
        }
    }



def lst = [];

    withCredentials([string(credentialsId: Constants.JENKINS_GITHUB_REST_CREDENTIALS_ID, variable: 'GITHUBRESTJWT')]) {

        httpRequest consoleLogResponseBody: true, customHeaders: [[maskValue: false, name: 'Accept', value: 'application/vnd.github+json'], [maskValue: false, name: 'Authorization', value: "Bearer ${GITHUBRESTJWT}"], [maskValue: false, name: 'X-GitHub-Api-Version', value: '2022-11-28']], outputFile: 'branches.json', url: "https://api.github.com/repos/pdrodavi/${repo}/branches", wrapAsMultipart: false

        def props = readJSON file: "${env.WORKSPACE}/branches.json", returnPojo: true
        props.each { key, value ->
            lst.add("$key.name")
        }

    }

    sh 'ls -a'
    sh 'rm -r .git'
    sh 'ls -a'

    inputBranch = input([
            message: 'Choose Branch',
            parameters: [
                    choice(name: 'Branches', choices: lst, description: 'Select branch for deploy')
            ]
    ])

    echo "Branch selecionada: ${inputBranch}"

//    git branch: "main", credentialsId: Constants.JENKINS_GITHUB_CREDENTIALS_ID, url: "https://github.com/pdrodavi/${repo}.git"
    git url: "https://github.com/pdrodavi/${repo}.git", branch: "${inputBranch}", credentialsId: Constants.JENKINS_GITHUB_REST_CREDENTIALS_ID

//    git branch: "${inputBranch}", credentialsId: "${GITHUBCRED}", url: "https://github.com/pdrodavi/${repo}.git"

//    git branch: "${inputBranch}", credentialsId: Constants.JENKINS_GITHUB_CREDENTIALS_ID, url: "https://github.com/pdrodavi/${repo}.git"

    /*
    withCredentials([string(credentialsId: Constants.JENKINS_GITHUB_REST_CREDENTIALS_ID, variable: 'GITHUBCRED')]) {
//        git branch: "${inputBranch}", credentialsId: '%GITHUBCRED%', url: "https://github.com/pdrodavi/${repo}.git"

    }*/

//    git branch: "${inputBranch}", credentialsId: Constants.JENKINS_GITHUB_CREDENTIALS_ID, url: "https://github.com/pdrodavi/${repo}.git"

}
