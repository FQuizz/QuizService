pipeline {
    agent {
          docker {
              image 'docker:27.0.2-dind'
              args '--privileged -v /var/run/docker.sock:/var/run/docker.sock'
          }
     }

    tools {
        maven '3.9.11'
    }

    environment {
        REGISTRY = 'https://index.docker.io/v1/'
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

        stage('Build Docker Image') {
            steps {
                script {
                    dockerImage = docker.build("${IMAGE_NAME}:${TAG}")
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                    // Use the same variable name (DOCKER_CREDENTIAL_ID) here
                    docker.withRegistry("${REGISTRY}", "${DOCKER_CREDENTIAL_ID}") {
                        dockerImage.push()
                    }
                }
            }
        }

        stage('Clean Up Local Images') {
            steps {
                script {
                    sh "docker rmi ${IMAGE_NAME}:${TAG} || true"
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
