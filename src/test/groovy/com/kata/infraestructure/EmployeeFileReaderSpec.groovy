package com.kata.infraestructure


import spock.lang.*


class EmployeeFileReaderSpec extends Specification {

  static final BASE_DIR = "/Users/manu/myprojects/kataBirthdayGreeting/src/test/groovy/com/kata/config/"
  static final FILE_NAME = "employees.txt"


  def "can throw an exception if the file doesn´t exist"(){

    given: def employeeReader = new EmployeeFileReader(file: new File("",""))

    when: employeeReader.fromFile()

    then: thrown(FileNotFoundException)
  }


}
