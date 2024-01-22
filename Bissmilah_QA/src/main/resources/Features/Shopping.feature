@All@Shopping
Feature: Shopping
  @TC_SHOP_B_01
  Scenario: Product are shown up
    Given User is already succesfully login on Product page
    And User clicking login button
    Then The products must shown up
  @TC_SHOP_B_02
  Scenario: Check the shopping feature functionality
    Given User is already succesfully login on Product page
    And User clicking login button
    Then The products must shown up
    When User click Add button
    And The cart badge pops up
    And User click the cart
    Then User redirected to Your Cart page
    And User click remove button
    Then The cart are being empty
   @TC_SHOP_B_03
   Scenario: Check the user can do checkout products
     Given User is already succesfully login on Product page
     And User clicking login button
     Then The products must shown up
     When User click Add button
     And The cart badge pops up
     And User click the cart
     Then User redirected to Your Cart page
     And User click checkout button
     And User fill the user data
     And User click Finish button
     Then The page will show order invoice
  @TC_SHOP_B_04 @Negative
  Scenario: Check the user can not checkout products
    Given User is already succesfully login on Product page
    And User clicking login button
    Then The products must shown up
    When User click Add button
    And The cart badge pops up
    And User click the cart
    Then User redirected to Your Cart page
    And User click remove button
    Then The cart are empty
    And User click checkout button
    Then User cannot doing chekout and errormessage are showed



