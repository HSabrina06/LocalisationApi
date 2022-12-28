pipeline {
  environment {
    imagename = "localisation.jar"
    registryCredential = 'hsabrina'
    dockerImage = ''
  }
  agent any
  stages {
    stage('Cloning Git') {
      steps {
        git([url: 'https://github.com/HSabrina06/LocalisationApi.git', branch: 'main', credentialsId: ''])

      }
    }
    stage('Building image') {
      steps{
        script {
          dockerImage = docker.build imagename
       //   	sh 'docker build -t shanem/localisation-0.0.1-SNAPSHOT:latest .'
        }
      }
    }
    stage('Deploy Image') {
      steps{
        script {
       //   docker.withRegistry( 'https://hub.docker.com/', registryCredential ) {
       withDockerRegistry([ credentialsId: registryCredential, url: "" ]) {

               dockerImage.push()


       //    dockerImage.push("$BUILD_NUMBER")
          // dockerImage.push('latest')


          }
        }
      }
    }
    stage('Remove Unused docker image') {
      steps{
        sh "docker rmi $imagename:$BUILD_NUMBER"
         sh "docker rmi $imagename:latest"

      }
    }
  }
}