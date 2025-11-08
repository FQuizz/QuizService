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
    }

    post {
        always {
            echo "Cleaning workspace..."
            cleanWs()
        }
    }
}
