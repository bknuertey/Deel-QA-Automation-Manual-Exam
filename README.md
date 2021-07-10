# Deel-QA-Automation-Manual-Exam

The flow of creating a fixed rate contract was automated in this exam. The flow is as follows:
 1. Contractor's start date
 2. Define rate - how much (1000.00), currency (GBP - British Pound), per (week)
 3. Add any special clause
 4. Contractor's tax residence - USA/Colorado

All the tests are located in the FixedContractTest.java class.

The code will generate a test report with the results upon completion of the tests. Allure is the reporter and the results can be found in the allure-results directory.

Note: This is a Maven project with TestNG Framework. All dependencies for the project are located in pom.xml. 
