# Course Assignment System - Spring "SWC3TECH2"

## Problem Description 
At our university, each semester students are assigned to courses (mandatory
or electives). At the moment the process of presenting and assigning to these
courses is not digital. We are to create a web-app that will digitalize this
system.

## SWC

SWC3TECH2 repository contains the source code of the Spring project. Packages as models, repositories, controllers etc. are in java.com.example.demo. All the views are found in resources package.
Security part was done with Spring Security, using WebSecurityConfig class. At this point application has 3 roles which are Role_Student, Role_Teacher and Role_Admin.

## Deployment:

  In order to be in the range of AWS free-tier we did not create an internet gateway, and are using only one EC2 instance.


	*   Launched EC2 instance with IAM role which has an AmazoneRDSFullAccess policy attached to it. 
	This was done so that the application running on the EC2 would have access to the RDS. 
	also added a security group and in Inbound section allowed ports 8080(to access tomcat), 
	22(to ssh in CLI into ec2). We are using the SSH protocol to log in to the ec2 via an encrypted connection.
	*   Launched a publicly accessible RDS using MySQL engine to save the project database there,
	in the same VPC, and attached a security group (Inbound: 22; 3306(mysql), Outbound: All) to control the traffic.
	*   SSHed to the ec2 instance and ran updates, downloaded tomcat8(tomcat8-admin-webapps -y),
	added tomcat user in tomcat-users.xml and commented Valve in order to access (tomcat)/manager/html.
	*   Made it possible to access RDS db through cli using ssh.
	*   In tomcat manager added <application>.war
	*   Application is deployed and can be accessed at (ec2ip):8080/(application)
	
## Built With

* [Spring](https://spring.io/projects) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management



## Authors
  * **Eduards Sergeyev** - *Student* - [EduardsDev](https://github.com/EduardsDEV)
  * **Gerli Poopuu** - *Student* - [GerliP](https://github.com/GerliP)
  * **Sigita Rekute** - *Student* - [SigitaR](https://github.com/SigitaR)
  
## Acknowledgments
  Considering to deploy using jenkins to make process simpler and faster taking into account that there are a lot of things that could be added to the application in the future.

  
