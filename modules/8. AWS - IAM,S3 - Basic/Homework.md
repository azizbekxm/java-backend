Task 1 – Create 3 User Groups
=============================
Let’s imagine that we have created AWS Account that will use all members of our AWS
program (Coordinator, Mentees, Mentors (Experts)). For all these users it will be better create different
groups with different permissions because, for example: Coordinator has more permissions that Mentee.
Please create 3 user groups:
1. CoordinatorsGroup
2. MentorsGroup
3. MenteesGroup

Task 2 – Create policies and roles
==================================
1. Create a policy named FullAccessPolicyEC2.
2. Configure the FullAccessPolicyEC2 to allow any actions on the EC2 resources.
3. Similarly, create policies for S3:
   a. FullAccessPolicyS3 – everything’s allowed.
   b. ReadAccessPolicyS3 – only get and list actions.
4. Create one role per each policy configured so far (note – these roles won’t be used right now, but
   might be reused in upcoming modules like EC2 or Lambda):
   a. FullAccessRoleEC2
   b. FullAccessRoleS3
   c. ReadAccessRoleS3
5. Create one group per each policy configured so far:
   a. FullAccessGroupEC2
   b. FullAccessGroupS3
   c. ReadAccessGroupS3
6. Create 1 user from the 1st group, 1 user from the 2nd group, and 1 user from the 3rd group.
7. Configure named profiles for each user from the previous step to be used with AWS CLI in the
   subsequent modules

Task 3 – Create a static website
================================
1. Create a static web site. Feel free to do anything you like, but keep in mind that the main goal is to have a lightweight folder with multiple files in it:
   1. a couple if interlinked HTMLs or an HTML page with some CSS styles is enough
   2. the site should not require any additional runtime environment like JVM or Node
   3. no backend is required
   4. you’ll have several other tasks dedicated to creation of a fully functioning web-application in the modules 3-8
   5. no heavy media resources (like large images/animations/videos) are recommended – you’ll have to upload the site to AWS multiple times
2. Create an S3 bucket which name doesn’t include uppercase characters, includes your full name, and begins with a letter. Recommendation – choose a name generic enough so that the bucket may be reused for developing a web application later.
3. Copy the static website from step 1 to the bucket from step 2 using AWS CLI and named profile with appropriate permissions from the previous module.
4. Enable static website hosting on your S3 bucket and make sure that the content of your site is available via website endpoint of the bucket.
5. Enable cross-region replication for the bucket from step 2.

Task 4 – Play with versioning
=============================
1. Create another S3 bucket which name doesn’t include uppercase characters, includes your full name + “task2”, and begins with a letter.
2. Enable versioning for the bucket from step 1.
3. Upload 2-3 files to the bucket. Make some changes to these files so that the bucket contains 2 (or more) versions of at least one file.
4. Using AWS CLI, get the latest version of a specific file.
5. Optional: write a script to get the latest version of a specific file no newer than a given date. You are free to use Bash or BAT or use the AWS SDK for any programming language.

Task 5 – Practice more AWS CLI hacking and play with permissions
================================================================
1. Using AWS CLI list all the objects in the S3 bucket from the first sub-task of this module. In the response, you'll see a lot of additional data for each object, play with the "--query" parameter to filter out only S3 object keys from the response.
2. Using different users from module 2, try to execute the following commands via AWS CLI:
   1. upload new file to the S3 bucket
   2. list all the objects in the S3 bucket
3. Observe the results.
4. Optional: play with the "--output" parameter and list all the objects in the S3 bucket with their size in a "human-readable" format as a table.


Task 6 – Think a little bit
===========================
1. Describe all the use cases for S3 you’ve seen on past/current projects.
2. Describe any other S3 use cases you see reasonable.
3. Optionally, visualize some of the use cases using any preferred notation (UML, BPMN, AWS diagrams, etc).
