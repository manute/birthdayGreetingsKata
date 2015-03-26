package com.kata.model


class BirthdayService {

  def emailService
  def employeeRepository


  def sendGreetings() {
    def employeesBirthday = employeeRepository.findEmployeesTodayBirthday()
    employeesBirthday.each { employee ->
      emailService.sendNow(employee)
    }
  }
}

