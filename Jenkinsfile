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
                // Archive test result XMLs
                junit 'build/test-results/test/*.xml'

                // Archive full HTML report
                archiveArtifacts artifacts: 'build/reports/tests/test/**', allowEmptyArchive: true

                // Publish HTML report (requires HTML Publisher Plugin)
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'build/reports/tests/test',
                    reportFiles: 'index.html',
                    reportName: 'JUnit HTML Report'
                ])
            }
    }
}
