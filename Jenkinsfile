@Library('TheSharedOne@latest') _

pipeline {
    agent any
    stages {
        stage("Clean Up") {
            steps {
                cleanWs()
            }
        }
        stage('Get SCM') {
            steps {
                git scm
                call "cat Jenkinsfile"
            }
        }
        stage('Build') {
            steps {
                call "docker build -t nodewebapp ."
                call "docker images"
            }
        }
        stage('Deploy') {
            steps {
                call "docker kill nodewebapp"
                call "docker rm nodewebapp"
                call "docker run -itd --name nodewebapp -p 8081:3000 nodewebapp:latest"
            }
        }
    }
}
 