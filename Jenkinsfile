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
                git "https://github.com/RedSPonge/simple-webapp-nodejs.git"
            }
        }

        stage("Build") {
            steps {
                nodejs("Node 19") {
                    sh "npm install"
                }
            }
        }

        stage("Test") {
            steps {
                nodejs("Node 19") {
                    sh "npm test"
                }
            }
        }
    }
}

// pipeline {
//     agent any
//     stages {
//         stage("Initialize") {
//             steps {
//                 cleanWs()
//             }
//         }
//         stage('Get SCM') {
//             steps {
//                 git "https://github.com/ranazrad/simple-webapp-nodejs.git"
//                 sh "cat Jenkinsfile"
//             }
//         }
//         stage('Build') {
//             steps {
//                 sh "docker build -t nodewebapp ."
//                 sh "docker images"
//             }
//         }
//         stage('Deploy') {
//             steps {
//                 sh "docker kill nodewebapp"
//                 sh "docker rm nodewebapp"
//                 sh "docker run -itd --name nodewebapp -p 8081:3000 nodewebapp:latest &"
//             }
//         }
//     }
// }
 