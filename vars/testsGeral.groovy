import br.dev.pedrodavi.jenkins.pipeline.scm.GitRepository
import br.dev.pedrodavi.jenkins.pipeline.utils.logging.Logger

def call() {

    node {

        stage("GitRepository") {
                  GitRepository gitRepo = new GitRepository(this, "https://github.com/wcm-io-devops/jenkins-pipeline-library.git")
//                  integrationTestUtils.assertEquals(GitRepository.PROTOCOL_HTTPS, gitRepo.getProtocol())
//                  integrationTestUtils.assertNotEquals(GitRepository.PROTOCOL_HTTP, gitRepo.getProtocol())
//                  integrationTestUtils.assertNotEquals(GitRepository.PROTOCOL_SSH, gitRepo.getProtocol())

                  gitRepo.getGroup()
                  gitRepo.getProject()
                  gitRepo.getProjectName()
                  gitRepo.getProtocolPrefix()
                  gitRepo.getServer()
                  gitRepo.getUsername()
                  gitRepo.isSsh()
                  gitRepo.isHttp()
                  gitRepo.isHttps()
                  gitRepo.getUrl()
                  gitRepo.isValid()
        }

    }
}