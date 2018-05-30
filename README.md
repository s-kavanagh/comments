# # ‘Comment on the news article’ Exercise Assignment

## Assumptions

The test framework assumes that Google Chrome is installed on the machine running the tests.  It also requires chromedriver to be in a folder that is referenced in the $PATH variable.

You can download the most recent chromedriver [here](https://chromedriver.storage.googleapis.com/index.html?path=2.39/)

## Running the tests

To run the tests, navigate to the folder containing the pom.xml file in a command prompt and run this command:

`mvn test -Dcucumber.options="--tags @automated"`
