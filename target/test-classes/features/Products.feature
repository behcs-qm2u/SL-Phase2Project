@ProductsFeature @AllTest
Feature: This feature will verify the products add-to-cart functionality of SWABLABS application

  Background: User login successfully and landed at Product page
    Given User launchs the SWAGLABS application
    And User landed at Product page after logged in with standard_user

  @SOSingleProduct
  Scenario Outline: Verify that user able to add single product to the cart
    When User click on ADD TO CART button of '<Product>'
    Then User should be able to notice the Shopping Cart icon badge changed
    And User should be able examine the item in Shopping cart

    Examples: 
      | Product                 |
      | Sauce Labs Bolt T-Shirt |
      | Sauce Labs Onesie       |

  @DTMultipleProduct
  Scenario: Verify that user able to add multiple product to the cart
    When User selects the following product by clicking their ADD TO CART button
      | Sauce Labs Fleece Jacket |
      | Sauce Labs Backpack      |
      | Sauce Labs Bike Light    |
    Then User should be able to notice the Shopping Cart icon badge changed
    And User should be able examine the item in Shopping cart