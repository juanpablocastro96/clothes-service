# clothes-service
This service will be responsible to expose all the clothes for Sasha Store.
It's using GitHub Actions in order to build and package the code.
The actions are login into dockerhub and pushing the image to it.
## Useful command for building the image locally.
1. docker login -u juancastro96

2. docker pull juancastro96/personal-repo:{commit_sha}

3. docker run -it -p 8080:8080 juancastro96/personal-repo:{commit_sha}
4. docker stop IMAGE_ID

5. docker image rm -f IMAGE_ID

