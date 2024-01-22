@All@Login
  Feature: Login
    @TC_LOG_A_01
    Scenario: Login
      Given User is on login page
      When User fill username and password
      And User click login button
      Then User verify login result
    @TC_LOG_A_02
    Scenario: Login invalid username
      Given User is on login page
      When User fill password but invalid username
      And User click login button
      Then User get error username password not match
    @TC_LOG_A_03
    Scenario: Login invalid password
      Given User is on login page
      When User fill valid username and invalid password
      And User click login button
      Then User get error  password not match
    @TC_LOG_A_04
    Scenario: Login invalid username and password
      Given User is on login page
      When User fill invalid username and invalid password
      And User click login button
      Then User get error  usernam and password not match
