package br.dev.pedrodavi.jenkins.pipeline.utils.maps

enum MapMergeMode implements Serializable {

    MERGE(),
    SKIP(),
    REPLACE()

    private static final long serialVersionUID = 1L

    MapMergeMode() {
    }

}