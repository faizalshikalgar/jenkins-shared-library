#!/usr/bin/env groovy

def call() {
    echo "Building the application for branch"
    sh 'mvn package'
}
