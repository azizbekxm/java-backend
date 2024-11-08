Task 1 - SQS/SNS
================
Implement a subscription feature in your web application:
* Create a standard SQS queue named <ProjectName>-uploads-notification-queue.
* Create an SNS topic named <ProjectName>-uploads-notification-topic.
* Add two new endpoints in your web-applications
  * subscribe an email for notifications
  * unsubscribe an email from notifications
* After a user visits the subscription endpoint, the specified email should receive a confirmation message.
* Whenever a user visits the unsubscription endpoint, AWS should stop sending the email notifications.
* Whenever an image is uploaded using your web application, a message describing that event should be published to the SQS queue.
* Update your web-application to run a scheduled background process which extracts the SQS messages in batch and sends them to the SNS topic.
* The SNS notifications should be in plain text which includes:
  * an explanation that an image has been uploaded
  * the image metadata (size, name, extension)
  * a link to the web application endpoint for downloading the image

  Optional: add an additional attribute to the message your app will send to the SNS topic (such as an image extension) and configure the filtering policy for subscriptions to accept messages with a specific attribute value (such as .png).
* It’s unlikely that you’ll hit SNS free tier limits, but keep them in mind:
  ![img.png](images/img.png)
* Think what are the other ways of receiving SNS notifications for the image uploads (not necessarily in a human-readable form).

Task 2 – create a Lambda for batching upload notifications
==========================================================
1. Create a Lambda function named \<ProjectName>-uploads-batch-notifier:
   1. use any preferred programming language
   2. grant the function the basic Lambda permissions as well as permissions for pulling from the \<ProjectName>-uploads-notification-queue
   3. configure the Lambda to run the code that you wrote for module 7 for transferring SQS messages to SNS (DO NOT FORGET to remove that code from the web-application to avoid functionality duplication)
   4. **important:** make sure your Lambda tries polling N messages for a limited period of time (timeout) of 2-3 seconds and does nothing in case no messages found
2. Publish the \<ProjectName>-uploads-batch-notifier.
3. Make 2 or more image uploads using your web application and trigger your Lambda manually. Ensure you got exactly one email with all the publications you’ve just made.

Task 3 – add Lambda triggers
============================
1. Create an API Gateway endpoint which would allow access only from your IP address and simply trigger the \<ProjectName>-uploads-batch-notifier Lambda.
2. Create an endpoint in your web application which would do the same – simply trigger the \<ProjectName>-uploads-batch-notifier Lambda.
3. Follow [this tutorial](https://docs.aws.amazon.com/AmazonCloudWatch/latest/events/RunLambdaSchedule.html) to make your Lambda run periodically (let’s say, every 5 minutes).
4. Make your Lambda logs scheduled/API Gateway/web application calls in such a way that it’s possible to distinguish them in the CloudWatch logs. Hint – the tutorial from step 3 makes the Lambda receive messages which have a detail-type field, so it’s possible to fill that field differently for the calls made from the web application and API Gateway endpoint.
5. Make sure you can see all 3 (scheduled/API Gateway/web application) kinds of Lambda calls in the CloudWatch logs.
6. Create a separate Lambda function which simply takes in an S3 object creation event and logs the S3 object name. Configure your S3 image bucket to send object creation events to that Lambda.
   1. Tip: Since the Lambda handler code is extremely simple, you may code it directly in the AWS Console using any of the available scripting language options.
7. Upload an image to your S3 bucket and ensure you can see the Lambda reacts to this in CloudWatch logs.
