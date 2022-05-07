#!/bin/bash

image_name=${1:-challenge_game/api}
container_name=${2:-challenge_game_api}

git pull origin main

docker rm -f $container_name
docker rmi -f $image_name
docker image rm -f "$(docker images -f dangling=true -q)"

docker-compose up -d
