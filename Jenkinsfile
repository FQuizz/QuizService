pipeline {
    agent any

    tools {
        maven '3.9.11'
    }

    environment {
        REGISTRY = 'https://registry.hub.docker.com'
        DOCKER_CREDENTIAL_ID = '49b31a3c-d742-4e5a-a1ba-540573b9ecb8'  // Must match ID in Jenkins credentials
        IMAGE_NAME = "khoa47245/quizz-service"
        TAG = "latest"  // You forgot to define TAG before using it
    }

    stages {
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build JAR') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }

        stage('Build and Push Docker Image') {
            steps {
                withDockerRegistry(credentialsId: '957b531b-32e7-44b2-8260-6ef47e62fd70', url: 'https://index.docker.io/v1/') {
                    sh 'docker build -t  khoanguyen47245/quizz-server:lastest .'
                    sh 'docker push khoanguyen47245/quizz-server:lastest'
                    sh 'docker rmi khoanguyen47245/quizz-server:lastest'
                }
            }
        }
    }

    post {
        always {
            echo "Cleaning workspace..."
            cleanWs()
        }
    }
}
