# clothes-service
This service will be responsible to expose all the clothes for Sasha Store.
It's using GitHub Actions in order to build and package the code.
The actions are login into dockerhub and pushing the image to it.
## Useful command for building the image locally.
docker login -u juancastro96
docker pull juancastro96/personal-repo:{commit_sha}
docker run -it -p 8080:8080 juancastro96/personal-repo:{commit_sha}
docker stop IMAGE_ID
docker image rm -f IMAGE_ID

