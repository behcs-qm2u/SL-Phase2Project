@LoginFeature @AllTest
Feature: This feature will verify the login functionality of SWAGLABS

  @PositiveLogin 
  Scenario Outline: Verify login functionality to SWAGLABS using correct username and password
    Given User launchs the SWAGLABS application
    When User enters login info '<UserName>' '<Password>'
    And User clicks the LOGIN button
    Then User should be landed on the Products Page

    Examples: 
      | UserName      | Password     |
      | standard_user | secret_sauce |

  @NegativeLogin 
  Scenario Outline: Verify login functionality to SWAGLABS using incorrect username and password
    Given User launchs the SWAGLABS application
    When User enters login info '<UserName>' '<Password>'
    And User clicks the LOGIN button
    Then User should be getting the '<ErrorMsg>'

    Examples: 
      | UserName        | Password     | ErrorMsg                                                                  |
      | unknown789      | wrongpa$$123!| Epic sadface: Username and password do not match any user in this service |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |
