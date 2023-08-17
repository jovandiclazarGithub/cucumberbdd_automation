Feature: test first attempt

  Scenario: some test
    Given Start Browser with google.com
    When click on Search Button 1 time
    Then click on Search Button

 Scenario: test web element
   Given go to web page
   When pass user name and pass
   Then click on Login

  Scenario: login to swag labs
    Given go to site
    When enter user name
    And enter password
    Then click on Login button

  Scenario: Search article in Amazon
    Given land on amazon page
    When click on the cart
    Then go back to home page

  Scenario: Navigate back and foreward
    Given open web page
    And maximize browser
    When click on the element
    And go backward
    Then go forward
    And refresh page

  Scenario: get page, enter value, delete and go back
    Given open google
    When enter something in the search box
    Then delete text
    And go back

  Scenario: QA_demo site practice
      Given land on the site and maximaze window
      When select section
      And select check box section
      Then mark home check box

  Scenario: Radio button test
    Given go to URL
    When check is round trip displayed
    Then select Round trip

  Scenario: One-way Radio button interactability
    Given go to URL
    When check one way radio button
    Then select one way radio button

  Scenario: log in as 190 //failed
    Given land on the login page
    When insert credentials
    Then log in

  Scenario: Smoothcopm dropdown select
    Given get page
    When select dropdown
    Then choose dropdown option

  Scenario: validatig text QAdemo
    Given web site landing
    When check expacted text
    Then get home page

  Scenario:
    Given get to buyatoyota.com
    When see offers
    Then enter zip code and wait for dealer
    And find dealer

  Scenario:
    Given web page
    When request a quote
    Then validate text

  Scenario: try to login on dev.reg   @toyotaLogin
    Given land on dev.reg
    When send user and pass
    Then log in succes







