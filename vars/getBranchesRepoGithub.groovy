import br.dev.pedrodavi.jenkins.pipeline.Constants

def call() {

    withCredentials([string(credentialsId: Constants.JENKINS_GITHUB_REST_CREDENTIALS_ID, variable: 'GITHUBRESTJWT')]) {

        sh "curl -L \\\n" +
                "  -H \"Accept: application/vnd.github+json\" \\\n" +
                "  -H \"Authorization: Bearer ${GITHUBRESTJWT}\"\\\n" +
                "  -H \"X-GitHub-Api-Version: 2022-11-28\" \\\n" +
                "  https://api.github.com/repos/Srvex/example-auth-jwt/branches"

    }

}
