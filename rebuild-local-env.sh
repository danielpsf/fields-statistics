#!/bin/bash

function _down_compose () {
    docker-compose down
}
function _delete_docker_image () {
    echo "Deleting last docker image..."
    docker rmi field-statistics:sql-db
}

function _build_docker_image () {
    echo "Building docker image..."
    gradle buildDockerImage
}

function _up_compose () {
    echo "Docker componse uping!"
    docker-compose up
}

time(_down_compose)
time(_delete_docker_image)
time(_build_docker_image)
time(_up_compose)



