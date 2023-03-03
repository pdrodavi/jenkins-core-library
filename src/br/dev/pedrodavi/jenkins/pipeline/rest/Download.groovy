package br.dev.pedrodavi.jenkins.pipeline.rest

class Download implements Serializable {

    static def downFile(String remoteUrl, String localUrl) {
        new File("$localUrl").withOutputStream { out ->
            new URL(remoteUrl).withInputStream { from ->  out << from; }
        }
    }

}
