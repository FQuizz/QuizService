pipeline {
    agent any

    tools {
        maven '3.9.11'
    }

    environment {
        REGISTRY = 'https://registry.hub.docker.com'
        IMAGE_NAME = 'khoa47245/quizz-service'
        TAG = 'latest'
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
                script {
                    withDockerRegistry(credentialsId: '957b531b-32e7-44b2-8260-6ef47e62fd70', url: 'https://index.docker.io/v1/') {
                        sh "docker build -t ${IMAGE_NAME}:${TAG} ."
                        sh "docker push ${IMAGE_NAME}:${TAG}"
                    }
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
