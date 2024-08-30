
@tag
Feature: Purchase a order
  I want to use this template for my feature file

 Background:
     Given landed on Ecommerce page
 

  @submitOrder
  Scenario Outline: Positive test for submitting the order
    Given Log in to the Ecommerce website with name <name> and password <password>
    When Add product <product> to cart
    Then checkout product <product> and submit the order
    And verify the msg "THANKYOU FOR THE ORDER." in confirmation page

    Examples: 
      | name               | password          | product     |
      | naveen30@gmail.com | Naveen@selenium24 | ZARA COAT 3 |
      
