Module description: 
=======================
AWS vs Azure vs Google: Cloud Services Comparison

Module agenda:
=======================
* Cloud concepts
* Compute options
* Storage services
* Cloud databases

Courses: 
=======================
* [Google Cloud Product Fundamentals](https://www.coursera.org/learn/google-cloud-product-fundamentals)
* [Developing Applications with Google Cloud Platform Specialization](https://www.coursera.org/specializations/developing-apps-gcp)
* [AWS Fundamentals Specialization](https://www.coursera.org/specializations/aws-fundamentals)
* [Building Containerized Applications on AWS](https://www.coursera.org/learn/containerized-apps-on-aws)

Videos: 
=======================
* [GCP vs AWS. Computing Services](https://videoportal.epam.com/video/WY4eERJj)

### Main Types of Cloud Computing Services

#### Infrastructure as a Service (IaaS)
> Infrastructure as a service (IaaS) provides raw computing resources like servers, storage and networking to users who run and manage their own platform and application software. 

#### Platform as a Service (PaaS)
> Platform as a service (PaaS) is a form of cloud computing where hardware and an application software platform are provided by another party. 
> The PaaS model allows end users to develop, manage and continuously run their own apps, and the platform provider manages the infrastructure (hardware) everything runs on.

#### Software as a Service (SaaS)
> Software as a service (SaaS) delivers application software from the cloud. SaaS offers ongoing development, updates and maintenance of the software, and all of the infrastructure and platforms necessary to support and run the software.

#### Container as a Service (CaaS)
> Containers as a service (CaaS) is a cloud service model that allows users to upload, organize, start, stop, scale and otherwise manage containers, applications and clusters.

#### Kubernetes-as-a-Service (KaaS)
> Kubernetes-as-a-Service (KaaS) is a cloud-based approach to container orchestration. 

#### Function as a Service (FaaS)
> Function as a service (FaaS) is a service for users who need cloud computing only for individual functions or components of their applications. Using FaaS, the client’s physical hardware, virtual machine operating system, and web server software management are all handled automatically by the service provider.


### Compute options overview

|       | IaaS           | PaaS              | Serverless   CaaS | CaaS / KaaS              | FaaS            |
|-------|----------------|-------------------|-------------------|--------------------------|-----------------|
| AWS   | EC2            | Elastic Beanstalk | Fargate           | AWS EKS                  | AWS Lambda      |
| GCP   | Compute Engine | App Engine        | Cloud Run         | Google Kubernetes Engine | Cloud Functions |
| Azure |                |                   |                   |                          |                 |

### Storage services overview

|       | Object storage | Archive object storage     | Block Storage             | File storage             |
|-------|----------------|----------------------------|---------------------------|--------------------------|
| AWS   | S3             | S3 Glacier                 | Elastic Block Store (EBS) | Elastic File Store (EFS) |
| GCP   | Cloud Storage  | Coldline & Archive Storage | Persistent Disk           | Cloud Filestore          |
| Azure |                |                            |                           |                          |

### Cloud databases overview

|       | SQL           | NoSQL(document)  | NoSQL(table)   | Data Warehouse            | File storage             | Bigdata processing      | Data orchestration |
|-------|---------------|------------------|----------------|---------------------------|--------------------------|-------------------------|--------------------|
| AWS   | RDS / Aurora  | DynamoDB         | SimpleDB       | Elastic Block Store (EBS) | Elastic File Store (EFS) | Elastic MapReduce (EMR) | Data Pipeline      |
| GCP   | Cloud Spanner | Cloud Datastore  | Cloud Bigtable | Redshift                  | BigQuery                 | Cloud Dataproc          | Cloud Dataflow     |
| Azure |               |                  |                |                           |                          |                         |                    |


References: 
=======================
* [Cloud Market Share](https://kinsta.com/blog/cloud-market-share/)
* [AWS vs Azure vs Google: Cloud Services Comparison](https://www.varonis.com/blog/aws-vs-azure-vs-google/)
* [AWS Vs Azure Vs Google: Cloud Services Comparison](https://www.whizlabs.com/blog/aws-vs-azure-vs-google/)

#### Infrastructure as a Service (IaaS)
* [Google Cloud for AWS Professionals: Compute](https://cloud.google.com/docs/compare/aws/compute#iaas_comparison)
* [EC2 vs Google Compute Engine: Comparing the Big Players in IaaS](https://cloudacademy.com/blog/ec2-vs-google-compute-engine/)
* [Comparing Compute Engine and Amazon EC2. IaaS](https://www.coursera.org/lecture/gcp-fundamentals-aws/comparing-compute-engine-and-amazon-ec2-8RxoO)

#### Platform as a Service (PaaS)
* [Comparing Compute Engine and Amazon EC2. PaaS](https://cloud.google.com/docs/compare/aws/compute#paas_comparison)
* [How App Engine differs from Amazon Elastic Beanstalk](https://www.coursera.org/lecture/gcp-fundamentals-aws/how-app-engine-differs-from-amazon-elastic-beanstalk-P74oG)
* [Battle of the PaaS. AWS vs Google Cloud Platform](https://foghornconsulting.com/2017/05/12/battle-of-the-paas-aws-vs-gcp/)
* [Comparisons for Elastic Beanstalk, App Engine, and heroku](https://medium.com/@at_ishikawa/comparisons-for-elastic-beanstalk-app-engine-and-heroku-2129d9c827bc)

#### Function as a Service (FaaS)
* [Comparing Compute Engine and Amazon EC2. FaaS](https://cloud.google.com/docs/compare/aws/compute#faas_comparison)
* [Serverless Platform Comparison: Google Cloud Function vs. AWS Lambda](https://medium.com/@manus.can/serverless-platform-comparison-google-cloud-function-vs-aws-lambda-8e060bcc93b4)
* [Google Cloud Functions vs. AWS Lambda: The Fight for Serverless Cloud Domination](https://cloudacademy.com/blog/google-cloud-functions-vs-aws-lambda-the-fight-for-serverless-cloud-domination/)

#### Container as a Service (CaaS)
* [Comparing Compute Engine and Amazon EC2. CaaS](https://cloud.google.com/docs/compare/aws/compute#caas_comparison)
* [Google Cloud Run (GCR) vs Azure Container Instances (ACI) vs AWS ECS with Fargate](https://technologyconversations.com/2020/08/04/google-cloud-run-gcr-vs-azure-container-instances-aci-vs-aws-ecs-with-fargate/)
* [Comparison: AWS Fargate vs. Google Cloud Run vs. Azure Container Instances](https://thenewstack.io/comparison-aws-fargate-vs-google-cloud-run-vs-azure-container-instances/)

