# 10. Clouds - EPAM, Google Cloud, Amazon Web Services

## Google Cloud

1. Check VMs on your personal account by the command `gcloud compute instances list`
1. Check available images by the command `gcloud compute images list`
1. Create Compute Engine VM instance given necessary image `gcloud compute instances create jmp --image-family [preferable image family] --image-project [image project]`
1. Connect to VM instance via SSH
1. Copy via SCP `event-service`  (attached as a zip to HW)  REST API application and run it.
1. Configure public access to web application (use external IP and open port)
1. Send simple REST request outside of VM instance
1. Kill VM instance to cleanup resources

## AWS Cloud

1. Create EC2 instance (use Amazon Linux AMI, configure inbound rules)
1. Connect to EC2 instance via SSH
1. Copy via SCP `event-service`  (attached as a zip to HW)  REST API application and run it.
1. Configure public access to web application by opening TCP port
1. Create S3 bucket
1. Upload `event-service` REST API application to S3 bucket
1. Create EC2 launch configuration (use user data to upload and deploy application)
1. Create EC2 load balancer (use public scheme, configure inbound rules)
1. Create EC2 auto scaling group
1. Create CloudWatch alarm (scale when more than 10 requests per minute happened)
1. Create Lambda that sends requests to EC2 load balancer and prints responses
1. [Optional] Create CloudFormation template for above operations

## Practical task evaluation rules:

* Google Cloud: 50 points
* AWS Cloud: 50 points

## References

* [Personal Projects](https://kb.epam.com/display/EPMCITFAQ/Personal+Projects) in EPAM Cloud
* [Maestro CLI Commands](https://cloud.epam.com/site/learn/documentation)
* [AWS Technical Essentials](https://aws.amazon.com/training/course-descriptions/essentials/)
* [Building Scalable Java Microservices with Spring Boot and Spring Cloud](https://www.coursera.org/learn/google-cloud-java-spring)
* [EPAM Cloud Expertise Appreciation](https://kb.epam.com/display/EPMCITFAQ/EPAM+Cloud+Expertise+Appreciation)
