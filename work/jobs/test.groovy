pipelineJob("app-job-deploy-sb-2") {
    description()
    keepDependencies(false)
    definition {
        cps {
            script("""@Library('pipeline-library') pipelineLibrary

pipeline {

  agent any

  stages {

    stage('Initialize') {
      steps {
        cleanWs()
        buildJavaSpringDocker(repo: "app-job-deploy-sb")
      }
    }


  }
}""")		}
    }
    disabled(false)
    configure {
        it / 'properties' / 'jenkins.model.BuildDiscarderProperty' {
            strategy {
                'daysToKeep'('1')
                'numToKeep'('2')
                'artifactDaysToKeep'('-1')
                'artifactNumToKeep'('-1')
            }
        }
    }
}