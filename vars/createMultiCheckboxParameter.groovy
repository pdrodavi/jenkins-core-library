import br.dev.pedrodavi.jenkins.pipeline.job.BuildParameterFactory
import br.dev.pedrodavi.jenkins.pipeline.utils.logging.Logger

void call(String stageName) {
    Logger log = new Logger("checkBox")
    stage(stageName) {
        BuildParameterFactory buildParameterFactory = new BuildParameterFactory(this)
        def checkboxParam = buildParameterFactory.createMultiCheckboxParameter("multiCheckboxParam", "select multiple values", ["val11", "val12", "val13"], ["val11", "val12", "val13"])
    }
}
