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
                 sh './gradlew allureReport'
            }
        }
    }

    post {
            always {
                publishHTML(target: [
                     reportDir: 'build/reports/allure-report/allureReport',
                     reportFiles: 'index.html',
                     reportName: 'Allure HTML Report',
                     keepAll: true,
                     alwaysLinkToLastBuild: true,
                     allowMissing: true
                ])
            }
    }
}