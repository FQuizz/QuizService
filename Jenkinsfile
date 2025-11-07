pipeline {
    agent { dockerfile true }

    tools {
        maven '3.9.11'
    }

    environment {
        REGISTRY = 'https://registry.hub.docker.com'
        IMAGE_NAME = "khoa47245/quizz-service"
        TAG = "latest"
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

        stage('Build Docker Image') {
            steps {
               docker.build("${IMAGE_NAME}:${TAG}")
            }
        }

        stage('Push Docker Image') {
            steps {
                docker.withDockerRegistry(credentialsId: '957b531b-32e7-44b2-8260-6ef47e62fd70', url: 'https://index.docker.io/v1/') {
                    docker.push("${IMAGE_NAME}:${TAG}")
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
