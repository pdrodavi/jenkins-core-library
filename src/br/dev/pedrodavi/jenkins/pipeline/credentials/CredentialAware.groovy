package br.dev.pedrodavi.jenkins.pipeline.credentials

import com.cloudbees.groovy.cps.NonCPS

interface CredentialAware {

    /**
     * Used to set the username based on a Credential found by auto lookup
     *
     * @param credential The credential object to use the username from (if set)
     */
    @NonCPS
    void setCredential(Credential credential)

    /**
     * Getter function for credentials
     *
     * @return The stored credentials
     */
    @NonCPS
    Credential getCredential()

}
