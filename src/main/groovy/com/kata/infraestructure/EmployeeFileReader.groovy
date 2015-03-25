package com.kata.infraestructure


class EmployeeFileReader {

  File file


  def fromFile() {
    checkFileExists()
  }

  private checkFileExists(){
    assert file.getText() != null
  }
}
