import br.dev.pedrodavi.jenkins.pipeline.Constants

def call(String repo){

    def lst = [];

    withCredentials([string(credentialsId: Constants.JENKINS_GITHUB_REST_CREDENTIALS_ID, variable: 'GITHUBRESTJWT')]) {

        //httpRequest consoleLogResponseBody: true, customHeaders: [[maskValue: false, name: 'Accept', value: 'application/vnd.github+json'], [maskValue: false, name: 'Authorization', value: "Bearer ${GITHUBRESTJWT}"], [maskValue: false, name: 'X-GitHub-Api-Version', value: '2022-11-28']], responseHandle: 'NONE', url: 'https://api.github.com/repos/Srvex/example-auth-jwt/branches', wrapAsMultipart: false
        httpRequest consoleLogResponseBody: true, customHeaders: [[maskValue: false, name: 'Accept', value: 'application/vnd.github+json'], [maskValue: false, name: 'Authorization', value: "Bearer ${GITHUBRESTJWT}"], [maskValue: false, name: 'X-GitHub-Api-Version', value: '2022-11-28']], outputFile: 'branches.json', url: 'https://api.github.com/repos/Srvex/example-auth-jwt/branches', wrapAsMultipart: false

//        def props = readJSON file: "${env.WORKSPACE}/branches.json"
        def props = readJSON file: "${env.WORKSPACE}/branches.json", returnPojo: true
        props.each { key, value ->
//            println(lst);
            lst.add("$key.name")
            println(lst);
//            echo "$key.name"
        }

    }

    inputBranch = input([
            message: 'Choose Branch',
            parameters: [
                    choice(name: 'Branches', choices: ['Yes', 'No'], description: 'Select branch for deploy')
            ]
    ])


    inputBranch = input([
            message: 'Input branch',
            parameters: [
                    string(name: 'Input branch')
            ]
    ])

    echo "Branch selecionada: ${inputBranch}"

    git branch: "${inputBranch}", credentialsId: Constants.JENKINS_GITHUB_CREDENTIALS_ID, url: "https://github.com/pdrodavi/${repo}.git"

}
