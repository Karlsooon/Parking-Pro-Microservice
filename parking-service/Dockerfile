FROM openjdk:17

#creats app directory in container
WORKDIR /app

#copy file from our computer to container
COPY target/parking-service-0.0.1-SNAPSHOT.jar /app/parkingservice.jar

EXPOSE 8081



#runs zsh sreda in docker
RUN sh -c "$(wget -O- https://github.com/deluan/zsh-in-docker/releases/download/v1.2.0/zsh-in-docker.sh)" -- \
    -t robbyrussell \
    -p https://github.com/zsh-users/zsh-autosuggestions

ENV ZSH_AUROSUGGESTIONS_STYLE="fg=#dedede,bg=#9c9c9c,bold,underline"

CMD ["java", "-jar", "studentservice.jar"]
ENTRYPOINT ["zsh"]



##installs to container vim git and curl
RUN apt-get update && apt-get install vim wget curl git
#
##creats file hello.sh and returns 'Hello from container' and this text puts to hello.sh file
#RUN touch hello.sh && echo "echo 'Hello from container'">hello.sh


#run automatically when building container

#here we can give argument, run some file automatically with zsh
#ENTRYPOINT ["zsh"]

#here we can not give argument, run some file automatically with zsh
#CMD ["zsh"]
#