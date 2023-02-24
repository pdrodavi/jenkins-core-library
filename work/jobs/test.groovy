pipelineJob("app-job-deploy-sb") {
    description()
    keepDependencies(false)
    definition {
        cpsScm {
            """@Library('pipeline-library') pipelineLibrary

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
}"""		}
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
