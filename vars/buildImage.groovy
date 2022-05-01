#!/usr/bin/env groovy

def call() {
    echo "Building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hubrepo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t faizalshikalgar/demo-app:jma-1.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push faizalshikalgar/demo-app:jma-1.0'
    }
}