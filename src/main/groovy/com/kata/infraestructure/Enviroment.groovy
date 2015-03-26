package com.kata.infraestructure

class Enviroment {

  static notExecuteInTest(closure) {
    def env = System.properties.env
    if (env != 'test') closure()
  }
}