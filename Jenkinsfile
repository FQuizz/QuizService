pipeline {
    agent any

    tools {
        maven '3.9.11'
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
