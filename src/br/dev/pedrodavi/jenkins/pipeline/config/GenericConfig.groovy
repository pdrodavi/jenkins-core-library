package br.dev.pedrodavi.jenkins.pipeline.config

import br.dev.pedrodavi.jenkins.pipeline.model.PatternMatchable

class GenericConfig extends PatternMatchable implements Serializable {

    private static final long serialVersionUID = 1L

    Object config = null

    GenericConfig(String pattern, String id, Object config) {
        super(pattern, id)
        // set config to empty map when necessary
        if (config == null) {
            config = [:]
        }
        this.config = config
    }

    /**
     * Helper function to get a item from the config identified by its key
     *
     * @param key The key to retrieve
     * @param defaultValue The default value when the configuration has no item for key
     *
     * @return The found value or defaultValue
     */
    Object get(String key, Object defaultValue = null) {
        Object ret = defaultValue
        if (this.config != null && this.config[key] != null) {
            ret = this.config[key]
        }
        return ret
    }

}
