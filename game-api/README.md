# Getting Started

## Docker

To run this project in docker you need to do 2 steps:

1) Build docker image:

`docker build -t challenge_game .`

3) Run container(you can also specify path to you env-file):

`docker run -d -p 8080:8080 --name challenge_api challenge_game`