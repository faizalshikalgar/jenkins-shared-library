#!/usr/bin/env groovy
package com.example

class Docker implements Serializable {

    def  script

    Docker(script){
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo "Building the docker image..."
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-hubrepo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh 'docker build -t $script.imageName .'
            script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
            script.sh 'docker push $script.imageName'
        }
    }

}
