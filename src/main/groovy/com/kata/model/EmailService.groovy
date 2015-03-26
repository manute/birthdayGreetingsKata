package com.kata.model


class EmailService {

  def mailSender

  def sendNow(employee) {
    if (employee) {
      mailSender.to = employee.email
      mailSender.subject = "Happy birthday!"
      mailSender.body = "Happy birthday, dear ${employee.first_name}!"
      mailSender.send()
    }
  }

}