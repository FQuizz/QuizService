pipeline {
    agent any
    tools{
        maven '3.9.11'
    }
     environment {
            DOCKER_CREDENTIALS = credentials('49b31a3c-d742-4e5a-a1ba-540573b9ecb8')
            IMAGE_NAME = "khoa47245/quizz-service"
       }
    stages {
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Build Docker Image') {
            steps {
                echo "Building Docker image using the JAR from target/"
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKER_CREDENTIALS) {
                        def image = docker.build("${IMAGE_NAME}")
                        image.push()
                        image.push('latest')
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