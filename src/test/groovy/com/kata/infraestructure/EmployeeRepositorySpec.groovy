package com.kata.infraestructure


import spock.lang.*


class EmployeeRepositorySpec extends Specification {

  def mockFromConnection = Mock(EmployeeFileReader)
  def repository = new EmployeeRepository(fromConnection: mockFromConnection)

  def "can retrieve all employees from connection db"(){

    given: mockFromConnection.parseFromFile() >> [["Doe", "Jhon","1982/10/08", "john.doe@foobar.com"]]

    when: def employees = repository.findAllEmployees()
          def employeeMocked = employees[0]

    then: employeeMocked.last_name == "Doe"
          employeeMocked.first_name == "Jhon"
          employeeMocked.date_of_birth == new Date().parse("yyyy/MM/d", "1982/10/08")
          employeeMocked.email == "john.doe@foobar.com"
  }

  def "can retrieve the employees that today is their birthday"() {
    given:
          def todayNoTime = new Date().clearTime()

          mockFromConnection.parseFromFile() >> [["Doe", "Jhon",fixtureTodayBirthEmployeeAsString(), "john.doe@foobar.com"],
                                                 ["Ann", "Mary","2011/03/26", "mary.ann@foobar.com"],
                                                 ["Manson", "Helen",fixtureTodayBirthEmployeeAsString(), "helen.manson@foobar.com"]]

    when: def employees = repository.findEmployeesTodayBirthday()

    then:
          employees[0].first_name == "Jhon"
          employees[0].date_of_birth.clearTime().compareTo(todayNoTime) == 0

          employees[1].first_name == "Helen"
          employees[1].date_of_birth.clearTime().compareTo(todayNoTime) == 0
  }


  private fixtureTodayBirthEmployeeAsString(){
    new Date().format("yyyy/MM/d")
  }


}

