Steps to launch application
1. import project as maven project
2. right-click-> run as -> maven intall (it will download all dependies)
3.  run (com.demo.SpringApp) as java application

4. copy below url in browser, if its showing Student Controller and Employee Controller Information then app is running
http://localhost:8080/swagger-ui.html

5. Copy below url for in memory DB instance
http://localhost:8080/h2-console

6. change jdbc url as below and connect
jdbc:h2:mem:TEST

change db url, driver class, username as per    
src/main/resources/application.properties if required
Note : don't enter password for db


Code Reference : https://github.com/iamvickyav/Spring-boot-data-H2-embedded.git
