# ToDo

The framework is based on Java(1.8) + Selenium(4.3.0) + Junit. Reporting is handled by cucumber native itself

Pre-requisites
##############
1. Java 1.8 should be installed and ensure that its path is added into environment variables list

2. Any recent version of MAVEN should be installed and ensure that its path is added into environment variables list

3. Eclipse is optional

4. You should have internet inorder to downloda the dependencies


Clone this code base and put it in any folder
Use commnad prompt and go to its directory by using cd
run below command

**mvn clean verify**

This will validate the todo features like
  creating a todo
  deleteing a todo
  completeing a todo

Tests will run on Google Chrome and driver is already part of this code base

Below Cucumber Report gets generated 

![image](https://user-images.githubusercontent.com/17289805/180501524-8ac47d00-d16a-4993-bcc5-27ce83363227.png)

