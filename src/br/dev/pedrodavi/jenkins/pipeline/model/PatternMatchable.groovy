package br.dev.pedrodavi.jenkins.pipeline.model

abstract class PatternMatchable implements Serializable {

    private static final long serialVersionUID = 1L

    String pattern = ""

    String id = ""

    /**
     * Constructor
     *
     * @param pattern The pattern to match against
     * @param id The id of the matchable item
     */
    PatternMatchable(String pattern, String id) {
        this.pattern = pattern
        this.id = id
    }

}
