# pomPoc
This is proof of concept for automating website using page object model design pattern

This Project navigates to Google search page and search a keyword.Post this it navigates to pages whose url contains
that keyword

It includes below features
1. Page object model design pattern.
2. Maven Project.
3. TestNG testing framework
4. Capture screenshot after particular navigation


## Steps to clone the project 
In your workspace
Run below commands from git terminal

```
git clone https://github.com/aditigarg0120/pomPoc.git
cd pomPoc
cd GoogleAdaptavistProject
mvn clean install
```

This will execute all test cases of both scenarios.

- Screenshots will be updated in **GoogleAdaptavistProject/screenshots/<Todays_date>/** folder
- Report will be generated in **GoogleAdaptavistProject/target/surefire-reports/index.html**
- Below is the screenshot of generated report


![Alt text](https://github.com/aditigarg0120/pomPoc/blob/master/TestExecutedReport.png "Test Report")



- Additionally we can implement logging mechanism in this.
