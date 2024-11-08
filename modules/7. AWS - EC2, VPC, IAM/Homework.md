Task 1 – allocate EC2 resources
===============================
1. Create Linux EC2 instance (choose any free-tier eligible AMI)
2. Configure security group for the EC2 instance so that:\
   1. allow access over HTTP/HTTPS from anywhere\
   2. allows SSH connection from your IP address only\
      **Note:** below you can find a script which would update the security group based on your
      current IP address (very useful in case you don’t have a static IP address)\
      **A script example for Windows:**
      ```
      rem .\task-3-auth-win.bat <your-profile-name> <security-group-id> <region>
      for /f %%a in ('powershell Invoke-RestMethod api.ipify.org') do set PublicIP=%%a
      aws ec2 authorize-security-group-ingress --group-id %2 --protocol tcp --port 22 --cidr %PublicIP%/32 --profile %1 --region %3
      ```
      **A script example for Unix:**
      ```
      #!/usr/bin/env bash
      # sh .\task-3-auth-unix.sh <your-profile-name> <security-group-id> <region>
      profile=$1
      groupId=$2
      region=$3
      dig @resolver1.opendns.com ANY myip.opendns.com +short | aws ec2 authorize-security-group-ingress --group-id $groupId --protocol tcp --port 22 --cidr $1/32 --profile $profile --region $region
      ```
   3. known pitfall – Windows might block connections with its firewall by default
3. Make sure Apache HTTP server is installed and running on the instance. Make sure that it starts
   whenever the instance boot/reboot.
4. Download the static web site created in module 3 on the instance.
5. Make sure you can view the site by accessing your EC2 instance over HTTP.

Task 2 – automate EC2 configuration
===================================
1. Create a new EC2 instance based on any free-tier Linux AMI and assign it the S3 readonly IAM role
   from module 2.
2. Configure the new EC2 instance so that it does the following steps automatically upon startup (tip –
   use cloud [init directives and user data](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/user-data.html#user-data-cloud-init)):
   a. install Apache HTTP server
   b. download the static web site created in module 3 from S3
3. Ensure that you can access the static web site on the EC2 instance over HTTP.
4. Create a custom AMI based on the EC2 instance.
5. Delete the EC2 instance and create another one based on the custom AMI.
6. Make sure the web site is still available over HTTP.

Task 3 – introducing EBS basics
===============================
1. Create EBS volume and attach it to the EC2 instance from the first sub-task.
2. Write any file to it and detach from the instance.
3. Attach it to the instance from the second sub-task and make sure the file is visible and accessible.

Task 4 – create a load-balanced application
===========================================
1. Create a simple project using your preferred language/frameworks/build tools. Feel free to customize it as you wish, but keep it simple and keep in mind the following points:
   1. any code must be hosted on [EPAM’s GitLab](https://git.epam.com/)
   2. automate creation of deployable artifacts
   3. right now, there will be just one artifact – a very simple web-application (the details are below)
   4. throughout the subsequent modules, you will have to produce another artifact which will share some code with the web-application
   5. so, use something like Gradle multi-module project for Java or multi-package project for Python/NodeJS
2. In your project, create a simple web-application with one endpoint (UI page, REST API endpoint, or else) which would return the name of the region and AZ the application is running in (use [this API](https://docs.aws.amazon.com/AWSJavaSDK/latest/javadoc/com/amazonaws/util/EC2MetadataUtils.html)).
3. Build your application and upload the resulting artifact (JAR, ZIP, TAR, or else) to S3.
4. Create another custom AMI based on one created in the task 2:
   1. install a runtime for your web-application (Tomcat for Spring MVC, or JVM for Spring Boot, or NodeJS, or Python packages, or else)
   2. remove the Apache HTTP server in case your runtime of choice already provides an HTTP server
   3. download and deploy your web-application artifact from S3
5. Create an auto-scaling group which scales between 2-3 instances running the custom AMI. Scale out when CPU usage is more than 50%.

   **Note:** useful tools/articles how to reproduce high CPU load:
   - https://superuser.com/questions/443406/how-can-i-produce-high-cpu-load-on-a-linux-server
   - https://superuser.com/questions/396501/how-can-i-produce-high-cpu-load-on-windows
   - https://linux.die.net/man/1/stress
6. Attach an elastic load balancer to the auto-scaling group.
![img.png](images/img.png)

Task 5 - VPC
============
Create a VPC which fulfills the following architecture (AWS diagram notation):
![img.png](images/img2.png)
1. The VPC should have a name following this convention <ProjectName>-Network and a CIDR block of 10.0.0.0/16.
2. Create an internet gateway named <ProjectName>-IGW and attach it to the VPC.
3. Create two public subnets in the VPC:
   a. <ProjectName>-PublicSubnet-A in the first AZ with a CIDR block of 10.0.11.0/24.
   b. <ProjectName>-PublicSubnet-B in the second AZ with a CIDR block of 10.0.21.0/24.
   c. Make them public and choose Auto-Assign Public IP.
   d. Create a new route table named <ProjectName>-PublicRouteTable. Add a 10.0.0.0/16 – Local route and a route to the <ProjectName> IGW to it.
   e. Associate the subnets with the new route table.
4. Create private subnet in the VPC:
   a. <ProjectName>-PrivateSubnet-A in the first AZ with a CIDR block of 10.0.12.0/24.
   b. Create new route table named <ProjectName>-PrivateRouteTable-A. Add a 10.0.0.0/16 – Local route to it.
   c. Associate private subnet with the new route table.
5. Create DB subnet in the VPC:
   a. <ProjectName>-DbSubnet-A in the first AZ with a CIDR block of 10.0.13.0/24.
   b. Create a new route table named <ProjectName>-DbRouteTable. Add a 10.0.0.0/16 – Local route to it.
   c. Associate DB subnet with the new route table.
6. Create NAT gateway for the private subnet:
   a. <ProjectName>-NatGateway-A with an elastic IP for the subnet <ProjectName>-PrivateSubnet-A.
   b. Add the gateway A the route table <ProjectName>-PrivateRouteTable-A.
7. Create a bastion host in the public subnet in the second AZ.
8. Create EC2 instance in the public subnet in the first AZ. Install the application developed in module 3 on the public instance.
9. Create one EC2 instance in the private subnet and one EC2 instance in the DB subnet. The instances do not have to have any special contents.
10. Create security groups:
    a. To allow inbound SSH traffic only from your IP address. Apply security group to the bastion host.
    b. To allow inbound HTTP/S traffic from anywhere. Apply security group to the public instance.
    c. To allow all inbound traffic from other instances associated with this security group. The security group should specify itself as a source security group in its inbound rules. Apply security group to all the instances.
11. Ensure:
    a. the application on the public instance is available from anywhere
    b. the private and DB instances are available from the bastion ONLY when you’re connected to it over SSH (use the ping command or also ssh them)
    c. the bastion host and public instance have access to the Internet (ping Google, for example)
    d. the private instance has access to the Internet (ping Google, for example)
    e. the private and public instances have access to the DB instance (ping again)
    f. the DB instance doesn’t have Internet access
