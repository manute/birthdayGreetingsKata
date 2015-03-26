package com.kata.model


import spock.lang.*
import com.kata.infraestructure.MailSender


class EmailServiceSpec extends Specification {

  def mailSender = Mock(MailSender)
  def emailService

  def setup() {
    emailService = new EmailService(mailSender: mailSender)
  }

  def "no send when data are empty"(){
    when: emailService.sendNow([])

    then: 0 * mailSender.send(_)
  }


  def "send email when are data"(){
    when: emailService.sendNow([first_name:"Manu", last_name: "Alonso", email:"test@t.es"])

    then: 1 * mailSender.send()
  }

}