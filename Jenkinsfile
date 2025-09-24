pipeline {
  agent any
  triggers {
    pollSCM('* * * * *') // Poll every minute for changes
  }
  stages {
    stage('Compile') {
      steps {
        sh './mvnw compile'
      }
    }
    stage('Test') {
      steps {
        sh './mvnw test'
      }
    }
    stage('Package') {
      steps {
        sh './mvnw package'
      }
    }
    stage('Sonar') {
      steps {
        withSonarQubeEnv('SonarQube') {
          sh './mvnw sonar:sonar'
        }
      }
    }
    stage('Blue Ocean') {
      steps {
        echo 'Visualize pipeline in Blue Ocean'
      }
    }
  }
}