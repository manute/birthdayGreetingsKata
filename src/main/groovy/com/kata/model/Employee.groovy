package com.kata.model


class Employee {

  String last_name
  String first_name
  Date date_of_birth
  String email

  static createFrom(dataAsArray){
    def birth_day = formatBirthday(dataAsArray[2])
    new Employee(last_name: dataAsArray[0], first_name: dataAsArray[1],
                 date_of_birth: birth_day , email: dataAsArray[3])
  }

  def isBirthday() {
    date_of_birth.clearTime().compareTo(new Date().clearTime()) == 0
  }

  private static formatBirthday(dateString) {
    new Date().parse("yyyy/MM/d", dateString)
  }

}