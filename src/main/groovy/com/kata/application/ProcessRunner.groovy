package com.kata.application

import com.kata.infraestructure.EmployeeRepository
import com.kata.infraestructure.EmployeeFileReader
import com.kata.infraestructure.MailSender

import com.kata.model.EmailService
import com.kata.model.BirthdayService


class ProcessRunner {

  static final BASE_DIR = "/Users/manu/myprojects/kataBirthdayGreeting/src/test/groovy/com/kata/config/"
  static final FILE_NAME = "employees.txt"


  public static void main(String[] args) {

    def employeeFileReader = new EmployeeFileReader(file: new File(BASE_DIR, FILE_NAME))
    def employeeRepository = new EmployeeRepository(fromConnection: employeeFileReader)

    def emailService = new EmailService(mailSender: new MailSender())

    BirthdayService birthdayService = new BirthdayService(emailService:emailService ,employeeRepository: employeeRepository)

    birthdayService.sendGreetings()
  }

}