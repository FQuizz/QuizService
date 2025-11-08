pipeline {
    agent any

    tools {
        maven '3.9.11'
    }
    environment {
        DOCKERHUB_CREDENTIALS = credentials('khoanguyen-dockerhub')
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

        stage('Build image') {
            steps {
                sh 'docker build -t khoanguyen47245/quizz-service:latest .'
            }
        }

        stage('Login') {
            steps {
                sh '''
                    echo "$DOCKERHUB_CREDENTIALS_PSW" | docker login -u "$DOCKERHUB_CREDENTIALS_USR" --password-stdin
                '''
            }
        }


        stage('Push image') {
            steps {
                sh 'docker push khoanguyen47245/quizz-service:latest'
            }
        }
    }

    post {
        always {
            echo "Cleaning workspace..."
            sh 'docker logout'
            cleanWs()
        }
    }
}
