Build tools & CI/CD task 

 

**Part 1. Build tools** 

Download archive with sources of multi module project with the following structure: 

 

jar<--admin\ 

			|----services --- utils 

war<-- web/ 

 

Create Ant+Ivy (Optional), Maven and Gradle build scripts to build the project. Two artifacts – war (for web module) and jar (for admin module) should be generated as a result of script running. Also you need to create README file with build instructions. 

Task details: 

- Only one project should be in your repository. Build scripts for different build tools should be in the root directory of the project. 

- Repository MUST not contain result artifacts (jar, war).  

- README file should contain instructions to build project via Ant, Maven, Gradle tools. Instructions must contain command line to start build project. 

- Build script should allow test running. Details about how to run tests should be written in README. 

 

You can get 100 points for this part  

 

Task will not be accepted if you generate scripts by any generation tools (for example, Ant and Gradle from Maven script). 

 

**Part 2 (Optional). CI/CD using Jenkins Home Work** 

Setup Jenkins locally 

For CI/CD you should use project from build tools home work 

Use names for job described in brackets (name: $nameOfJob) 

Create continuous Job (name: continuous)

Should build when SCM has changes 

Should build every night at 2:00 AM  

Job should be parameterized with maven or grade (user should be able to choose it in job parameter)   

Use promotion plugin. Should be available two promo stars  

First stars should be applied automatically to successful build (QA) 

Second stars should be applied manually (Prod) 

Create Deploy Job (name: deploy)

Should be parameterized with artifacts prompted with QA star 

 Use Container Deploy plugin  

Setup machine on cloud.epam.com

Setup additional user for Jenkins  

Setup tomcat 

Setup cloud machine as slave on Jenkins 

Create deploy job (name: deploy_cloud)

Should deploy on clod machine 

Should be parameterized with artifacts promoted with Prod star 

Use Container Deploy plugin 

Create PipeLine (delivery_pipeline)

 Job should be parameterized with maven or grade (user should be able to choose it in job parameter)   

 Step Build according to parameter (continuous) 

 Step Deploy on test (deploy job)    

 Check using curl that deployment is successful  (https://curl.haxx.se/download.html) 

 If deployment is successful  deploy on cloud (deploy_cloud) 

