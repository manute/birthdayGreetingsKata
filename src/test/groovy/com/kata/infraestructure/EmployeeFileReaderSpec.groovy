package com.kata.infraestructure


import spock.lang.*


class EmployeeFileReaderSpec extends Specification {

  static final BASE_DIR = "/Users/manu/myprojects/kataBirthdayGreeting/src/test/groovy/com/kata/config/"
  static final FILE_NAME = "employees.txt"


  def "should throw an exception if the file doesn´t exist"(){

    given: def employeeReader = new EmployeeFileReader(file: new File("",""))

    when: employeeReader.parseFromFile()

    then: thrown(FileNotFoundException)
  }

  def "can parse each line of file into data of employees"() {

    given:

      def employeeReader = new EmployeeFileReader(file: new File(BASE_DIR, FILE_NAME))

    when:
      def dataEmployees = employeeReader.parseFromFile()

      def employeeOne = dataEmployees[0]
      def employeeTwo = dataEmployees[1]


    then:
      employeeOne[0] == "Doe"
      employeeOne[1] == "John"
      employeeOne[2] == "1982/10/08"
      employeeOne[3] == "john.doe@foobar.com"

      employeeTwo[0] == "Ann"
      employeeTwo[1] == "Mary"
      employeeTwo[2] == "1975/09/11"  |
      employeeTwo[3] == "mary.ann@foobar.com"
  }
}