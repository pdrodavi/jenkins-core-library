import br.dev.pedrodavi.Constants

def call(){

    inputNameRepo = input([
            message: 'Name Project Repository',
            parameters: [
                    string(name: 'Input a name for repository')
            ]
    ])

    dir('/var/lib/jenkins/workspace/create-project/') {
        sh "ls"
        sh "pwd"
        sh "mvn archetype:generate -DarchetypeGroupId=br.com.srvex -DarchetypeArtifactId=backend-archetype -DarchetypeVersion=1.0-SNAPSHOT -DgroupId=br.com.srvex.api -DartifactId=${inputNameRepo} -Dversion=1.0-SNAPSHOT -Dpackage=br.com.srvex.api"
        sh "ls"
    }

    dir("/var/lib/jenkins/workspace/create-project/${inputNameRepo}") {
        sh "ls"
        sh "pwd"
        withCredentials([gitUsernamePassword(credentialsId: Constants.JENKINS_GITLAB_CREDENTIALS_ID, gitToolName: 'Default')]) {
            sh "git init"
            sh "git branch -m main"
            sh "git add ."
            sh "git config --global user.email 'infrarq@srvex.com.br'"
            sh "git config --global user.name 'Srvex Technology'"
            sh "git commit -m 'repo auto'"
            sh "git remote add origin https://gitlab.com/srvextechnology/${inputNameRepo}.git"
            sh "git push --set-upstream https://gitlab.com/srvextechnology/${inputNameRepo}.git main"
        }

        cleanWs()

        dir('/var/lib/jenkins/workspace/create-project/') {
            sh "rm -r ${inputNameRepo}@tmp"
        }
    }

}


