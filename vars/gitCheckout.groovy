import br.dev.pedrodavi.jenkins.pipeline.Constants

def call(String repo){

    inputBranch = input([
            message: 'Input branch',
            parameters: [
                    string(name: 'Input branch')
            ]
    ])

    echo "Branch selecionada: ${inputBranch}"

    git branch: "${inputBranch}", credentialsId: Constants.JENKINS_GITHUB_CREDENTIALS_ID, url: "https://github.com/pdrodavi/${repo}.git"

}
