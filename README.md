##Ferry Backend mock

[![Stories in Ready](https://badge.waffle.io/groenborg/CharonBack.svg?label=ready&title=Ready)](http://waffle.io/groenborg/CharonBack)


##Setup

When launching the application in your local development environment, your first need to set an
environment variable called `BE_SERVER_PORT` which you assign your port with eg. 8000

To do this open your .zshrc and add `export BE_SERVER_PORT=8000` and restart the terminal
or just add the environment variable to your intellij launch job 



##Docker containers

Throughout the pipeline we have used env variables to configure the port. The standard portis 8000, 
to change this you have to pass an argument to the `docker run`command and change it in distelli



###Building the image

To build the image run the command `docker build -t gradle-image .` 


###Building the image 

To build the image run the command `docker run -d -p 8000:8000 --name charon gradle-image`

the image is also on dockerhub under `groenborg/charon-backend`