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


