1. Install Jenkins, create Jenkins pipeline (30 points)
    1.1. You can choose any installation method from official website (https://www.jenkins.io/doc/book/installing/)
    1.2. Create a git repository or use an existing one with any application. Application should contain Dockerfile (to build application) and Jenkinsfile.
    1.3. Implement one stage with name 'Build' in Jenkinsfile with one statement: echo 'Hello, World'
    1.4. Create Jenkins pipeline, which will connect to your git repository and use Jenkinsfile as source of pipeline stages
    1.5. Make sure that pipeline reacts on every new commit into repository on the master branch
    1.6 Make sure that pipeline finished successfully and you can see 'Hello, World' in results

2. Build and Publish Docker image (30 points)
    2.1. First of all you need to create your docker registry (you can use https://hub.docker.com)
    2.2. Add credentials for dockerhub in Jenkins (Manage Credentials) and install Docker Pipeline plugin
    2.3. Implement stage 'Build' with following steps 
        2.3.1. checkout repository
        2.3.2. build docker image, assign tag which is equal to Jenkins build (env.BUILD_ID)
    2.4. Implement stage 'Push' with following steps:
        2.4.1. push docker image to repository using defined credentials to dockerhub
    2.5. Verify that Jenkins job is still successfully finished and docker hub contains latest built docker image

3. Install local k8s cluster using minikube (40 points)
    3.1. Install minikube (https://minikube.sigs.k8s.io/docs/start/) and run k8s cluster ()
    3.2. Add to project kubernetes manifest with Deployment and Service of application
    3.3. Install Kubernetes Continuous Deploy plugin, Kubernetes Credentials Provider
    3.4. Add Kubernetes configuration in Jenkins Credentials using content of .kube/config file
        3.4.5. Make sure that you paste flatten data from .kube/config
    3.5. Implement 'Publish' stage with the following steps:
        3.5.1. Use kubernetesDeploy where specify created manifest and name of Credentials for kubernetes
    3.6. Verify that Jenkins job is still successfully finished and pod is up and running in minikube k8s cluster and accessible via browser


