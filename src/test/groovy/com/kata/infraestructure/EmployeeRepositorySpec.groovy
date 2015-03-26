package com.kata.infraestructure


import spock.lang.*


class EmployeeRepositorySpec extends Specification {

  def mockFromConnection = Mock(EmployeeFileReader)
  def repository = new EmployeeRepository(fromConnection: mockFromConnection)

  def "can retrieve all employees from connection db"(){

    given: mockFromConnection.parseFromFile() >> [["Doe", "Jhon","1982/10/08", "john.doe@foobar.com"]]

    when: def employees = repository.findAllEmployees()
          def employeeMocked = employees[0]

    then: employeeMocked[0] == "Doe"
          employeeMocked[1] == "Jhon"
          employeeMocked[2] == "1982/10/08"
          employeeMocked[3] == "john.doe@foobar.com"
  }
}

