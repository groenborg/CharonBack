FROM openjdk:8
MAINTAINER groenborg27@gmail.com

RUN apt-get update
RUN apt-get install -y wget

# Install Gradle
RUN wget https://services.gradle.org/distributions/gradle-2.0-bin.zip
RUN unzip gradle-2.0-bin.zip
RUN mv gradle-2.0 /opt/
RUN rm gradle-2.0-bin.zip


ENV INSTALL_PATH /home/app
ENV GRADLE_HOME /opt/gradle-2.0
ENV PATH $PATH:$GRADLE_HOME/bin

RUN apt-get clean

WORKDIR $INSTALL_PATH

ADD . .

CMD gradle test