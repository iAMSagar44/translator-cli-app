# CLI App using Spring Shell and OpenAI's Translate text API
This is a CLI that lets you to translate text to either German, French or English. It was written in Java using

- Spring Boot 3
- Spring Shell
- GraalVM
- Maven
- Java 17

## Prerequisites

You need to sign up for an OpenAI account and create an API key. Refer to the OpenAI documentation for setting up an account and retrieving the API key: https://platform.openai.com/docs/api-reference.
Once you have your API key, update the application.properties file with the API key.

## GraalVM (optional)

I have included GraalVM as a dependency in the pom.xml to build a native image. 
If you want to create a native image, run ./mvnw -Pnative native:compile -DskipTests=true. The native image will be created in the /target folder along with the jar.
You will need to install GraalVM on your machine and update JAVA_HOME environment variable before you run this. 