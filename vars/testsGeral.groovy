import br.dev.pedrodavi.jenkins.pipeline.managedfiles.ManagedFileConstants
import br.dev.pedrodavi.jenkins.pipeline.utils.logging.Logger

def call() {

    node {

        Logger.init(this, LogLevel.INFO)
        Logger log = new Logger(this)

        stage("ManagedFileConstants") {
          ManagedFileConstants managedFileConstants = new ManagedFileConstants()
          log.info(ManagedFileConstants.GLOBAL_MAVEN_SETTINGS_PATH, ManagedFileConstants.GLOBAL_MAVEN_SETTINGS_PATH)
          log.info(ManagedFileConstants.GLOBAL_MAVEN__SETTINGS_ENV, ManagedFileConstants.GLOBAL_MAVEN__SETTINGS_ENV)
          log.info(ManagedFileConstants.MAVEN_SETTINGS_PATH, ManagedFileConstants.MAVEN_SETTINGS_PATH)
          log.info(ManagedFileConstants.MAVEN_SETTING_ENV, ManagedFileConstants.MAVEN_SETTING_ENV)
          log.info(ManagedFileConstants.NPM_CONFIG_USERCONFIG_PATH, ManagedFileConstants.NPM_CONFIG_USERCONFIG_PATH)
          log.info(ManagedFileConstants.NPM_CONFIG_USERCONFIG_ENV, ManagedFileConstants.NPM_CONFIG_USERCONFIG_ENV)
          log.info(ManagedFileConstants.BUNDLE_CONFIG_ENV, ManagedFileConstants.BUNDLE_CONFIG_ENV)
          log.info(ManagedFileConstants.BUNDLE_CONFIG_PATH, ManagedFileConstants.BUNDLE_CONFIG_PATH)
        }

    }
}