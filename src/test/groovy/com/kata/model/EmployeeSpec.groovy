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
}