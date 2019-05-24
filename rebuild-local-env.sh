#!/bin/bash

function _compose_down () {
    docker-compose down
}
function _delete_docker_image () {
    echo "Deleting last docker image..."
    docker rmi field-statistics_app
}

function _build_application () {
    echo "Building Application..."
    chmod +x gradlew
    ./gradlew assemble
}

function _compose_up () {
    cp build/libs/*.jar docker/
    docker-compose up
}

time(_compose_down)
time(_delete_docker_image)
time(_build_application)
time(_compose_up)
