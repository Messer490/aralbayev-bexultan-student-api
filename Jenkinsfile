pipeline {
    agent any

    environment {
        IMAGE_NAME = 'aralbayev-bexultan-student-api:v1.0-aralbayev'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                echo 'Bexultan Aralbayev: Checkout completed'
            }
        }

        stage('Build') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew --no-daemon assemble'
            }
        }

        stage('Test') {
            steps {
                sh './gradlew --no-daemon test'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t "$IMAGE_NAME" .'
            }
        }

        stage('Verify') {
            steps {
                sh 'docker image inspect "$IMAGE_NAME"'
                echo 'Bexultan Aralbayev: Docker image verified'
            }
        }
    }
}
