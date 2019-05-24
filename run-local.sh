#!/bin/bash

function _buildApplication () {
    echo "Building Application..."
    chmod +x gradlew
    ./gradlew assemble
}

function _composeUp () {
    echo "Building Docker image..."
    cp build/libs/*.jar docker/
    docker-compose up
}

time(_buildApplication)
time(_composeUp)
