# Poller Project
The polling project is a project used to poll other servers to find the performance of them. It uses a Poller to send the requests, a poller orchestrator 
to tell the pollers who has responsibility over which endpoint monitoring. Finally a frontend to visually see the data

## Other repos in this project:
- [Poller](https://github.com/christophperrins/polling-poller)
- [Poller Orchestrator](https://github.com/christophperrins/polling-orchestrator)
- [Frontend](https://github.com/christophperrins/polling-frontend)

## Poller Orchestrator
This orchestrator communicates with the pollers indirectly through the database. This reduces complexity in the amount of moving parts.

### Installation
The project is built using java and maven

To install run the following steps
```sh
sudo apt update
sudo apt install -y openjdk-u-jdk maven
sudo apt install -y mysql-server
```

Next install and run the actual project
```sh
git clone https://github.com/christophperrins/polling-orchestrator
cd polling-orchestrator
```

Configure the file "application.properties" found in src/resources/

**Run the schema.sql inside the mysql server.**

Then run the project

```sh
mvn spring-boot:run
```