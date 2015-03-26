package com.kata.infraestructure


class EmployeeRepository {

  def fromConnection

  def findAllEmployees(){
    fromConnection.parseFromFile()
  }
}