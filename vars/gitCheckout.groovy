import br.dev.pedrodavi.jenkins.pipeline.Constants
import br.dev.pedrodavi.jenkins.pipeline.utils.logging.*
import static br.dev.pedrodavi.jenkins.pipeline.utils.ConfigConstants.*

def call(String repo){

    inputBranch = input([
            message: 'Input branch',
            parameters: [
                    string(name: 'Input branch')
            ]
    ])

    Map config = [ (LOGLEVEL) : LogLevel.TRACE ]

    // initialize the logger
    Logger.init(this, config)
    Logger log = new Logger(this)

    ansiColor('xterm') {
        log.trace("trace logging")
        log.debug("debug logging")
        log.info("info logging")
        log.deprecated("deprecated logging")
        log.warn("warn logging")
        log.error("error logging")
        log.fatal("fatal logging")
    }

    echo "Branch selecionada: ${inputBranch}"

    git branch: "${inputBranch}", credentialsId: Constants.JENKINS_GITHUB_CREDENTIALS_ID, url: "https://github.com/pdrodavi/${repo}.git"

}
