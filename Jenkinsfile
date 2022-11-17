pipeline {
    agent any
    triggers {
        cron("* * * * *")
    }
    stages {
        stage("Clean Up") {
            steps {
                cleanWs()
            }
        }
        stage('Get SCM') {
            steps {
                git scm
                sh "cat Jenkinsfile"
            }
        }
        stage('Build') {
            steps {
                sh "docker build -t nodewebapp ."
                sh "docker images"
            }
        }
        stage('Deploy') {
            steps {
                sh "docker kill nodewebapp"
                sh "docker rm nodewebapp"
                sh "docker run -itd --name nodewebapp -p 8081:3000 nodewebapp:latest"
            }
        }
    }
}
 