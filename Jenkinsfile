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

        stage('Build image') {
            steps {
                sh 'docker build -t khoanguyen47245/quizz-service:latest .'
            }
        }

        stage('Login') {
            steps {
               withCredentials([usernamePassword(credentialsId: 'khoanguyen-dockerhub', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh '''
                        echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                    '''
                }
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
            sh 'docker rmi khoanguyen47245/quizz-service'
            sh 'docker logout'
            cleanWs()
        }
    }
}
