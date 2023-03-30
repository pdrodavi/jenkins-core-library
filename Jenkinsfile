library identifier: 'jenkins-core-library@kubernetes/1.0.0', retriever: modernSCM(
  [$class: 'GitSCMSource',
    remote: 'https://github.com/pdrodavi/jenkins-core-library.git'
  ])

pipeline {

  agent any
  
  tools {
    maven "M3"
  }

  stages {

    stage('Initialize') {
      steps {
        cleanWs()
        buildJavaSpringDocker(repo: "app-job-deploy-sb")
      }
    }


  }
}
