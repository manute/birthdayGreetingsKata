package com.kata.infraestructure


class EmployeeFileReader {

  File file


  def parseFromFile() {
    checkFileExists()
    def dataEmployees = collectData()
    removeTitleFrom(dataEmployees)
  }

  private checkFileExists(){
    assert file.getText() != null
  }

  private collectData() {
    file.collect { line ->
      def dataOfEmployee = line.split(",")

      [dataOfEmployee[0].trim(), dataOfEmployee[1].trim(),
       dataOfEmployee[2].trim(), dataOfEmployee[3].trim()]
    }
  }

  private removeTitleFrom(dataEmployees){
    dataEmployees.tail()
  }

}
