package br.dev.pedrodavi.jenkins.pipeline.credentials

import br.dev.pedrodavi.jenkins.pipeline.utils.logging.Logger
import com.cloudbees.groovy.cps.NonCPS
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings
import net.sf.json.JSON
import net.sf.json.JSONObject

class CredentialParser implements Serializable {

    private static final long serialVersionUID = 1L

    Logger log = new Logger(this)

    /**
     * Parses a json object containing a list of credential objects into a list of Credential
     * Only valid Credential objects are added to the returned list
     *
     * @param jsonContent The json content loaded via JsonLibraryResource
     * @return The parsed list of valid Credential objects
     */
    @NonCPS
    @SuppressFBWarnings('SE_NO_SERIALVERSIONID')
    List<Credential> parse(JSON jsonContent) {
        Credential credential = null
        List<Credential> parsedCredentials = []
        // Walk through entries, try to parse them as Credential object and add it to the returned list
        jsonContent.each { JSONObject entry ->
            String comment = entry.comment ?: null
            String id = entry.id ?: null
            String pattern = entry.pattern ?: null
            String username = entry.username ?: null
            credential = new Credential(pattern, id, comment, username)
            log.trace("parsed credential file: ", credential)
            if (credential.isValid()) {
                parsedCredentials.push(credential)
            } else {
                log.debug("credential is invalid because id and/or pattern is missing")
            }
            log.trace("entry: ", entry)
        }

        return parsedCredentials
    }

}
