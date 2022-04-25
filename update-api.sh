image_name=${1:-challenge_game}
container_name=${2:-challenge_game_api}

git pull origin main

docker rm -f $container_name
docker rmi -f $image_name
docker image rm -f "$(docker images -f dangling=true -q)"

cd ./game-api || exit

docker build -t challenge_game .
docker run -d -p 8080:8080 --name challenge_game_api challenge_game
