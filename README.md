# IOT-

# Environment Prerequisite
- Java 11 JDK installed
- MySQL Server service version 8 or higher running on port 3306
- Maven version 3.x.x buildtool installed
- git installed and configured

# Installation Guide
- open bash terminal in the desired directory to save the project
- git clone https://github.com/HebaIbrahemX/IOT-shop.git
- cd ./IOT-shop
- run following 
```bash 
mvn clean install 
```
- to run the project please execute the following command after replacing first "root" word  with mysql valid user and 2nd "root" word with this user password
-  mvn spring-boot:run -Dspring-boot.run.arguments="--db.user=root --db.pass=root"
- open browser and go to http://localhost:8080/swagger-ui/index.html  or import https://www.getpostman.com/collections/bd8fdecca7ca7ddec005 collection in postman to test endpoints

# Unit and Integration tests
- in the project directory run " mvn test "


