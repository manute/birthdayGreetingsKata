package com.kata.infraestructure

import com.kata.model.Employee

class EmployeeRepository {

  def fromConnection

  def findAllEmployees(){
    fromConnection.parseFromFile().collect { dataEmployee ->
      Employee.createFrom(dataEmployee)
    }
  }

  def findEmployeesTodayBirthday() {
    findAllEmployees().findAll { it.isBirthday() }
  }
}