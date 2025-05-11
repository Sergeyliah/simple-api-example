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
    }

    post {
            always {
                // Generate Allure report
                sh './gradlew allureReport'

                // Archive the HTML report for browser viewing
                archiveArtifacts artifacts: 'build/reports/allure-report/**', allowEmptyArchive: true
            }
    }
}