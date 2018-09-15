# pdncoTestProject
This project has been complete for pdnco.ir company. 
To test the project you should install rabbitmq and docker in your system. after installation run rabbitmq.
After that you run rabbitmq you should run the server and then run client.
This client project send a message as a spring request to server at blow url:
localhost:8080/?from=1&to=1000
you should set from & to, in server after received message, server will sleep 1ms from counting 1 to 1000 and the client is waiting until server job done.
after that the server will response and client see the message.
