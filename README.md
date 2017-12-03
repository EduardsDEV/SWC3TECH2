"# SWC3TECH2"

SWC3TECH2 repository contains the source code of the Spring project. Packages as models, repositories, controllers etc. are in java.com.example.demo. All the views are found in resources package.

Security part was done with Spring Security, using WebSecurityConfig class. At this point application has 3 roles which are Role_Student, Role_Teacher and Role_Admin.

Deployment:

  In order to be in the range of AWS free-tier we did not create an internet gateway, and are using only one EC2 instance.


	*   Launched EC2 instance with IAM role which has an AmazoneRDSFullAccess policy attached to it, also added a security group and in Inbound section allowed ports 8080(to access tomcat), 22(to ssh in CLI into ec2), 80(HTTP).
	*   Launched a publicly accessible RDS in the same VPC and attached a security group(Inbound: 22; 3306, Outbound: All) to control the traffic.
	*   SSHed to the ec2 instance and ran updates, downloaded tomcat8(tomcat8-admin-webapps -y), added tomcat user in tomcat-users.xml and commented Valve in order to access (tomcat)/manager/html.
	*   Made it possible to access RDS db through cli using ssh.
	*   In tomcat manager added <application>.war
	*   Application is deployed and can be accessed at (ec2ip):8080/(application)

  
  Considering to deploy using jenkins to make process simpler and faster taking into account that there are a lot of things that could be added to the application in the future.

  
