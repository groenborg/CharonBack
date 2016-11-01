FROM openjdk:8
MAINTAINER groenborg27

RUN apt-get update
RUN apt-get install -y wget

# Install Gradle
RUN wget https://services.gradle.org/distributions/gradle-3.1-bin.zip
RUN unzip gradle-3.1-bin.zip
RUN mv gradle-3.1 /opt/
RUN rm gradle-3.1-bin.zip


ENV INSTALL_PATH /home/app
ENV GRADLE_HOME /opt/gradle-3.1
ENV PATH $PATH:$GRADLE_HOME/bin

RUN apt-get clean

WORKDIR $INSTALL_PATH

ADD . .

ENTRYPOINT ["/bin/bash","-c"]
CMD ["gradle test"]