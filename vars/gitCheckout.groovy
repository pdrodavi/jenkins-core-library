import br.dev.pedrodavi.jenkins.pipeline.Constants

def call(String repo){

    def lst = [];

    withCredentials([string(name: 'CREDGH', credentialsId: Constants.JENKINS_GITHUB_REST_CREDENTIALS_ID, variable: 'GITHUBRESTJWT')]) {

        httpRequest consoleLogResponseBody: true, customHeaders: [[maskValue: false, name: 'Accept', value: 'application/vnd.github+json'], [maskValue: false, name: 'Authorization', value: "Bearer ${GITHUBRESTJWT}"], [maskValue: false, name: 'X-GitHub-Api-Version', value: '2022-11-28']], outputFile: 'branches.json', url: "https://api.github.com/repos/pdrodavi/${repo}/branches", wrapAsMultipart: false

        def props = readJSON file: "${env.WORKSPACE}/branches.json", returnPojo: true
        props.each { key, value ->
            lst.add("$key.name")
        }

        inputBranch = input([
                message: 'Choose Branch',
                parameters: [
                        choice(name: 'Branches', choices: lst, description: 'Select branch for deploy')
                ]
        ])

        println("Listando após chamada de branches")
        sh "ls -a"

        println("Deletando diretorio & .git")
        deleteDir()
//        sh "rm -r ${env.WORKSPACE}/${repo}"
//        sh "rm -r ${env.WORKSPACE}/.git"

//        println("Listando após remoção de diretorio anterior")
//        sh "ls -a"

        echo "Branch selecionada: ${inputBranch}"

//        sh "git clone https://github.com/pdrodavi/${repo}.git"
        sh 'git clone -b ' + "${inputBranch}" + ' https://pdrodavi:' + "${GITHUBRESTJWT}" + '@github.com/pdrodavi/' + "${repo}" + '.git'
//        sh "git clone https://pdrodavi:${GITHUBRESTJWT}@github.com/pdrodavi/${repo}.git"

        sh "ls -a"
//        sh "rm ${env.WORKSPACE}/branches.json"
//        sh "ls -a"

    }


//    git branch: "main", credentialsId: Constants.JENKINS_GITHUB_CREDENTIALS_ID, url: "https://github.com/pdrodavi/${repo}.git"
//    git url: "https://github.com/pdrodavi/${repo}.git", branch: "${inputBranch}", credentialsId: Constants.JENKINS_GITHUB_REST_CREDENTIALS_ID
//    git url: "https://github.com/pdrodavi/${repo}.git", branch: "${inputBranch}"

//    git branch: "${inputBranch}", credentialsId: "${GITHUBCRED}", url: "https://github.com/pdrodavi/${repo}.git"

//    git branch: "${inputBranch}", credentialsId: Constants.JENKINS_GITHUB_CREDENTIALS_ID, url: "https://github.com/pdrodavi/${repo}.git"

    /*
    withCredentials([string(credentialsId: Constants.JENKINS_GITHUB_REST_CREDENTIALS_ID, variable: 'GITHUBCRED')]) {
//        git branch: "${inputBranch}", credentialsId: '%GITHUBCRED%', url: "https://github.com/pdrodavi/${repo}.git"

    }*/

//    git branch: "${inputBranch}", credentialsId: Constants.JENKINS_GITHUB_CREDENTIALS_ID, url: "https://github.com/pdrodavi/${repo}.git"

}
