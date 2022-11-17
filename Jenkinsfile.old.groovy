pipeline {
    agent any
    stages {
        stage("Clean") {
            steps {
                cleanWs()
            }
        }

        stage("Clone") {
            steps {
                git "https://github.com/RedSponge/simple-webapp-nodejs.git"
            }
        }

        stage("Build") {
            steps {
                nodejs("NodeJS 19") {
                    sh "npm install"
                }
            }
        }

        stage("Test") {
            steps {
                nodejs("NodeJS 19") {
                    sh "npm test"
                }
            }
        }
    }
}
