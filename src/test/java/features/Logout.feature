@LogoutFeature @AllTest
Feature: This feature will verify the logout functionality of SWAGLABS

  Background: User login successfully and landed at Product page
    Given User launchs the SWAGLABS application
    And User landed at Product page after logged in with standard_user

  @ProductLogout
  Scenario: Verify logout function from product page
    When User click on the top-left burger menu
    And User click on the LOGOUT
    Then User should be logged out and redirect to login page

  @CartLogout
  Scenario: Verify logout function from cart page
    And User accessed the Shopping Cart
    When User click on the top-left burger menu
    And User click on the LOGOUT
    Then User should be logged out and redirect to login page
