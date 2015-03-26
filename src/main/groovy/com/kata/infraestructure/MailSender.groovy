package com.kata.infraestructure

import static com.kata.infraestructure.Enviroment.*

class MailSender {

  static DUMMY_FROM = "dumy@dumy.com"

  def to
  def subject
  def body


  def send() {
    return notExecuteInTest {
      genericSend()
    }
  }

}