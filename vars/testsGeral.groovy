import br.dev.pedrodavi.jenkins.pipeline.utils.logging.Logger

def call() {

    node {

        stage("Logger") {
              Logger test = new Logger(this)
      // call all logger init functions
              Logger.init(this, [:])
              Logger.init(this, "info")
              Logger.init(this, 0)
              Logger.setLevel(LogLevel.ALL)
              Logger.setLevel(LogLevel.DEBUG)
              Logger.setLevel(LogLevel.WARN)
              Logger.setLevel(LogLevel.ERROR)
              Logger.setLevel(LogLevel.DEPRECATED)
              Logger.setLevel(LogLevel.FATAL)
              Logger.setLevel(LogLevel.INFO)
              Logger.setLevel(LogLevel.NONE)
              Logger.setLevel(LogLevel.TRACE)
              // set loglevel to all
              Logger.setLevel(LogLevel.ALL)

              test.trace("trace")
              test.debug("debug")
              test.info("info")
              test.warn("warn")
              test.error("error")
              test.fatal("fatal")

              test.trace("trace", this)
              test.debug("debug", this)
              test.deprecated("deprecatedItem", "deprecatedMessage")
              test.info("info", this)
              test.warn("warn", this)
              test.error("error", this)
              test.fatal("fatal", this)
        }

    }
}