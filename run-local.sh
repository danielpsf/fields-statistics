#!/bin/bash

function _buildApplication () {
    echo "Building Application..."
    chmod +x gradlew
    ./gradlew createDockerfile
}

function _composeUp () {
    echo "Building Docker image..."
    docker-compose up
}

time(_buildApplication)
time(_composeUp)
