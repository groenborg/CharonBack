##Ferry Backend mock

[![Stories in Ready](https://badge.waffle.io/groenborg/CharonBack.svg?label=ready&title=Ready)](http://waffle.io/groenborg/CharonBack)


##Setup

When launching the application in your local development environment, your first need to set an
environment variable called `BE_SERVER_PORT` which you assign your port with eg. 8000

To do this open your .zshrc and add `export BE_SERVER_PORT=8000` and restart the terminal
or just add the environment variable to your intellij launch job 



##Docker containers

###Building the image

to build the image run the command `docker build -t gradle-image .` 
