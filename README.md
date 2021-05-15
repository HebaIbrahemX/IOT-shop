# IOT-

# Environment Prerequisite
- Java 11 JDK installed
- MySQL Server service running on port 3306
- Maven buildtool installed
- git installed and configured

# Installation Guide
- open terminal in the desired directory to save the project
- git clone https://github.com/HebaIbrahemX/IOT-shop.git
- cd ./IOT-shop
- execute follwing >> " mvn clean insatll"
- to run the project please execute the following command after replacing first "root" word  with mysql valid user and 2nd "root" word with this user password
-  mvn spring-boot:run -Dspring-boot.run.arguments="--db.user=root --db.pass=root"
- open browser and go to http://localhost:8080/swagger-ui/index.html

