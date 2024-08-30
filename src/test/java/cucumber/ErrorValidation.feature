
@tag
Feature: Validation login error
  I want to use this template for my feature file

  @invalidLogin
  Scenario Outline: negative login Test
    Given landed on Ecommerce page
    Given Log in to the Ecommerce website with name <name> and password <password>
    Then "Incorrect email or password." msg is displayed
    

    Examples: 
       Examples: 
      | name               | password        |
      | naveen30@gmail.com | Naveen@selenium2|
