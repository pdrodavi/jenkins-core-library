import br.dev.pedrodavi.jenkins.pipeline.Constants
import br.dev.pedrodavi.jenkins.pipeline.utils.ConfigConstants
//import br.dev.pedrodavi.jenkins.pipeline.utils.logging.Logger

def call(String repo){

//    Logger log = new Logger("checkoutStage")

    inputBranch = input([
            message: 'Input branch',
            parameters: [
                    string(name: 'Input branch')
            ]
    ])

    checkoutScm(
            (SCM) : [
                    (SCM_URL) : "https://github.com/pdrodavi/${repo}.git",
                    (SCM_CREDENTIALS_ID) : Constants.JENKINS_GITHUB_CREDENTIALS_ID,
                    (SCM_BRANCHES) : [[name: '*/main'], [name: '*/develop']],
            ]
    )

    echo "Branch selecionada: ${inputBranch}"
//    log.info("Branch selecionada: ${inputBranch}")

    git branch: "${inputBranch}", credentialsId: Constants.JENKINS_GITHUB_CREDENTIALS_ID, url: "https://github.com/pdrodavi/${repo}.git"

}
