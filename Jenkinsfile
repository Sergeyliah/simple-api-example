pipeline {
    agent any

    tools {
        gradle 'Gradle_8'  // Must be configured in Jenkins > Global Tool Configuration
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Sergeyliah/simple-api-example'
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
            junit 'build/test-results/test/*.xml'
            archiveArtifacts artifacts: 'build/reports/tests/test/**', fingerprint: true
        }
    }
}
