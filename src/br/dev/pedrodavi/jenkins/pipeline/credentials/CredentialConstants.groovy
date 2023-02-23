package br.dev.pedrodavi.jenkins.pipeline.credentials

class CredentialConstants implements Serializable {

    private static final long serialVersionUID = 1L
    final static SCM_CREDENTIALS_PATH = "credentials/scm/credentials.json"
    final static SSH_CREDENTIALS_PATH = "credentials/ssh/credentials.json"
    final static HTTP_CREDENTIALS_PATH = "credentials/http/credentials.json"

}
