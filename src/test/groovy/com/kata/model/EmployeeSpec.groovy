package com.kata.model


import spock.lang.*


class EmployeeSpec extends Specification {

  def "can create a silly employee"(){

      given: def today = new Date()

      when: def employee = new Employee(last_name: "Norris", first_name: "Chuck",
                                         date_of_birth: today, email: "dummy@d.es")

      then: employee.last_name == "Norris"
            employee.first_name == "Chuck"
            employee.date_of_birth == today
            employee.email == "dummy@d.es"

  }

  def "can create a employee from a data list"(){

    given:
          def birthDateString = "1982/10/08"
          def dataEmployee = ["Doe", "Jhon", birthDateString, "john.doe@foobar.com"]

    when: def employee = Employee.createFrom(dataEmployee)

    then: employee.last_name == "Doe"
          employee.first_name == "Jhon"
          employee.date_of_birth == new Date().parse("yyyy/MM/d", birthDateString)
          employee.email == "john.doe@foobar.com"
  }
}