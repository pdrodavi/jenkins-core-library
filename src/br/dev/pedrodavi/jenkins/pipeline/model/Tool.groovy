package br.dev.pedrodavi.jenkins.pipeline.model

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings

@SuppressFBWarnings('ME_ENUM_FIELD_SETTER')
enum Tool {

    MAVEN("MAVEN_HOME"),
    JDK("JAVA_HOME"),
    ANSIBLE("ANSIBLE_HOME"),
    GIT("GIT_HOME"),
    GROOVY("GROOVY_HOME"),
    MSBUILD("MSBUILD_HOME"),
    ANT("ANT_HOME"),
    PYTHON("PYTHON_HOME"),
    DOCKER("DOCKER_HOME"),
    NODEJS("NPM_HOME")

    String envVar

    Tool(String envVar) {
        this.envVar = envVar
    }

}