package br.dev.pedrodavi.jenkins.pipeline.config

import br.dev.pedrodavi.jenkins.pipeline.utils.TypeUtils
import br.dev.pedrodavi.jenkins.pipeline.utils.logging.Logger
import com.cloudbees.groovy.cps.NonCPS
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings

class GenericConfigParser implements Serializable {

    private static final long serialVersionUID = 1L

    Logger log = new Logger(this)
    TypeUtils typeUtils = new TypeUtils()

    /**
     * Parses a yaml object containing a list of generic config objects a list of GenericConfig
     * Only valid GenericConfig objects are added to the returned list
     *
     * @param configContent The yaml content loaded via YamlLibraryResource
     * @return The parsed list of valid GenericConfig objects
     */
    @NonCPS
    @SuppressFBWarnings('SE_NO_SERIALVERSIONID')
    List<GenericConfig> parse(Object yamlContent) {
        List<GenericConfig> parsedItems = []
        // Walk through entries, try to parse them as GenericConfig object and add it to the returned list
        yamlContent.each { Object entry ->
            String id = entry.id ?: null
            String pattern = entry.pattern ?: null
            List patterns = entry.patterns ?: null
            Object config = entry.config ?: null
            if (typeUtils.isList(patterns)) {
                for (String patternItem in patterns) {
                    parsedItems.push(new GenericConfig(patternItem, id, config))
                }
            } else if (pattern != null) {
                parsedItems.push(new GenericConfig(pattern, id, config))
            }
        }

        return parsedItems
    }

}
