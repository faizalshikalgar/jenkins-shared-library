#!/usr/bin/env groovy

def call(String $BRANCH_NAME) {
    echo "Building the application for branch $BRANCH_NAME"
    sh 'mvn package'
}
