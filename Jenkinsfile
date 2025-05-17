pipeline {
    agent any

    tools {
        gradle 'Gradle_8'  // Must be configured in Jenkins > Global Tool Configuration
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Test') {
            steps {
                sh 'chmod +x ./gradlew && ./gradlew clean test'
            }
        }

        stage('Generate Allure Report') {
                    steps {
                        allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
                    }
                }
    }

    post {
            always {
                archiveArtifacts artifacts: 'allure-results/**', allowEmptyArchive: true
            }
            success {
                echo 'Build succeeded. Allure report is available.'
            }
            failure {
                echo 'Build failed. Check the test results and logs.'
            }
        }
}