package com.kata.model

import spock.lang.*
import com.kata.infraestructure.EmployeeRepository


class BirthdayServiceSpec extends Specification {

  def mockEmployeeRepository = Mock(EmployeeRepository)
  def mockEmailService = Mock(EmailService)

  def birthdayService = new BirthdayService(employeeRepository: mockEmployeeRepository,
                                            emailService: mockEmailService)

  def "can send greetings to all employee's birthday"() {

    given: mockEmployeeRepository.findEmployeesTodayBirthday() >> fixtureEmployeesTodayBirthday()

    when: birthdayService.sendGreetings()

    then: 2 *  mockEmailService.sendNow(_)
  }




  def fixtureEmployeesTodayBirthday() {
    def today = new Date()
    [new Employee(last_name: "Norris", first_name: "Chuck", date_of_birth: today, email: "dummy@d.es"),
     new Employee(last_name: "Lee", first_name: "Bruce", date_of_birth: today, email: "bruce@d.es")]
  }

}