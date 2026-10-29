pipeline {
  agent any
  stages {
    stage('Checkout') { steps { checkout scm } }
    stage('Build') { steps { sh 'gradle --no-daemon assemble' } }
    stage('Test') { steps { sh 'gradle --no-daemon test' } }
    stage('Docker Build') { steps { sh 'docker build -t aralbayev-bexultan-student-api:v1.0-aralbayev .' } }
    stage('Verify') { steps { sh 'docker image inspect aralbayev-bexultan-student-api:v1.0-aralbayev'; echo 'Bexultan Aralbayev: image verified' } }
  }
}
