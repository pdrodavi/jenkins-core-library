package br.dev.pedrodavi.jenkins.pipeline.credentials

import br.dev.pedrodavi.jenkins.pipeline.model.PatternMatchable
import com.cloudbees.groovy.cps.NonCPS

class Credential extends PatternMatchable implements Serializable {

    private static final long serialVersionUID = 1L

    String comment

    String userName

    /**
     * @param pattern The pattern which will be matched against the scm url
     * @param id The id of the credential stored in the Jenkins instance
     * @param comment Additional comment for debug purposes
     * @param user user name to use, used during sshagent steps
     */
    Credential(String pattern, String id, String comment = null, String userName = null) {
        super(pattern, id)
        this.comment = comment
        this.userName = userName
    }

    @NonCPS
    boolean isValid() {
        return (pattern != null && id != null)
    }

}
