# SpringBoot AWS Lambda Boilerplate
I started this project because I wanted to learn more about AWS Lambda.
Here are the projects that helped me:

* [Serverless Spring example](https://github.com/serverless-guru/aws-serverless-java-container/tree/master/samples/spring/pet-store)
* [Use Spring Boot 2 with AWS Lambda](https://github.com/cloudurable/spring-boot-2-aws-lambda)



## Requirements
    
* Install AWS Serverless development tools [here](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-install.html) : Installing this tools allows you to easily test locally and to test via AWS Lambda.

## Generate zipFile

To work, AWS Lambda needs a zip file of the application. To generate this file, simply build the project.
Le fichier généré se trouve dans le dossier ```/build/distributions```.


## Test the app 
 * Start the app : ```sam local start-api --template sam.yaml```
 * test call : ```curl -s http://127.0.0.1:3000/ping```

## Deploy the app
### Requirement
* Create an s3 bucket to store the app : ```aws s3 mb s3://springboot2-aws-lambda```
* Create cloudformation to deploy our app : ```aws --region eu-west-3 cloudformation package --template-file sam.yaml --output-template-file output-sam.yaml --s3-bucket springboot2-aws-lambda```
* Run : ```aws --region eu-west-3 cloudformation deploy --template-file output-sam.yaml --stack-name springboot2AwsLambda --capabilities CAPABILITY_IAM```
* View configuration: ```aws --region eu-west-3 cloudformation describe-stacks --stack-name springboot2AwsLambda```