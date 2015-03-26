Kata Birthday Greetings
=======================

Problem: write a program that

  1. Loads a set of employee records from a flat file
  2. Sends a greetings email to all employees whose birthday is today


Execute
--------

  - Dependencies:
    * java >= 1.7
    * groovy >= 2.4.1
    * gradle >= 2.3.6

  - Tests :
    ```bash
      gradle test

      gradle -Dtest.single=BirthdayServiceSpec test #One test
    ````
  - Process:
    ```
      gradle run
    ```