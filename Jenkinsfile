pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps { checkout scm }
        }
        stage('Build and Test') {
            steps { sh 'mvn -B clean verify' }
            post { always { junit 'target/surefire-reports/*.xml' } }
        }
        stage('Code Inspection - SonarQube') {
            steps {
                withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {
                    sh 'mvn -B org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.1.2184:sonar -Dsonar.projectKey=leave-service-<BITSID> -Dsonar.host.url=http://localhost:9000 -Dsonar.login=$SONAR_TOKEN'
                }
            }
        }
    }
}
