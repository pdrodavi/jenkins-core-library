package br.dev.pedrodavi.jenkins.pipeline.config

class GenericConfigConstants implements Serializable {
    private static final long serialVersionUID = 1L
    static final String NOTIFY_MAIL_CONFIG_PATH = "jenkins-core-library/config/notify/mail.yaml"
    static final String NOTIFY_MATTERMOST_CONFIG_PATH = "jenkins-core-library/config/notify/mattermost.yaml"
    static final String NOTIFY_MQTT_CONFIG_PATH = "jenkins-core-library/config/notify/mqtt.yaml"
    static final String NOTIFY_TEAMS_CONFIG_PATH = "jenkins-core-library/config/notify/teams.yaml"
}
