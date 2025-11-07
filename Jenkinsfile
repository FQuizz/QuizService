pipeline {
    agent any

    tools {
        maven '3.9.11'
    }

    environment {
        DOCKER_CREDENTIALS = credentials('957b531b-32e7-44b2-8260-6ef47e62fd70')
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

        stage('Build Docker Image'){
            steps {
                sh 'docker build -t khoanguyen47245/quizz-service:latest .'
            }
        }

        stage('Login Docker'){
            steps {
                sh 'echo $DOCKER_CREDENTIALS_PSW | docker login -u $DOCKER_CREDENTIALS_USR --password-stdin'
            }
        }
        stage('Push Docker Image'){
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
