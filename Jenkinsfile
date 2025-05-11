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

        stage('Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'build/allure-results']]
            }
        }
    }

    post {
            always {
                // Generate Allure report
                sh './gradlew allureReport'

                // Archive Allure HTML report
                archiveArtifacts artifacts: 'build/reports/allure-report/**', allowEmptyArchive: true

                // Optional: publish in Jenkins if Allure plugin is installed
                allure includeProperties: false, jdk: '', results: [[path: 'build/allure-results']]
            }
    }
}