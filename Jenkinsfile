@Library('TheSharedOne@main') _

pipeline {
    agent any
    stages {
        stage("Debug Stage") {
            steps {
                script {
                    def envs = readYaml(text: libraryResource('environments.yml'))
                    println(envs.buildImage)
                }
            }
        }
        stage("Clean Up") {
            steps {
                cleanWs()
            }
        }
        stage('Get SCM') {
            steps {
                git 'https://github.com/RedSponge/simple-webapp-nodejs'
                runCommand "cat Jenkinsfile"
            }
        }
        stage('Build') {
            steps {
                runCommand "docker build -t nodewebapp ."
                runCommand "docker images"
            }
        }
        stage('Deploy') {
            steps {
                runCommand "docker kill nodewebapp"
                runCommand "docker rm nodewebapp"
                runCommand "docker run -itd --name nodewebapp -p 8081:3000 nodewebapp:latest"
            }
        }
    }
}
 