
### IMPORTANT 
This project includes two simple user story to implement Jenkins
and Selenium Grid together in one framework.
In recording examples are related with ETSY but it prevents 
automation and gives some verification based on different countries 
S**o that PROJECT is updated** with cydeo practice website
- It will not make any **DIFFERENCE** in terms of implementation 


# selenium-grid-demo
Basic cucumber framework used for running automation tests on Jenkins.

## Running locally
1- Run From CukesRunner : 
  - Click RUN button
  - Executions will happen SEQUENTIALLY 

2- Run From Maven :
    ```
    mvn test
    ``` 
  - Executions will happen PARALLEL

## Jenkins
  - Install Cucumber Report Plugin 
  - Create a simple job and use this repository in the repository url field. 
  - In the post build actions, select option Cucumber reports and point to the location of the cucumber json report. 
  - Run the project as a maven goal *test*.

  ```
    mvn test
  ``` 

## Tags
You can pass a custom tag using terminal. Available tags are **@smoke**, **@regression**. 

```
mvn test -Dcucumber.filter.tags="@smoke"
```
## Browsers
You can pass change using command line argument BROWSER
```
mvn test -DBROWSER=firefox

```
