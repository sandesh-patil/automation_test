@envall @homepage @priority @myStore11
Feature: Homepage Tests

  As a user
  I can see and use homepage functions to search and purchase items of My interest

  Background:
    Given I land on my store homepage

  @myStore11
  Scenario Outline: As a non registered user, I want to be able to add 2 items to the cart and place an order
    And I select any "<itemCount>" items from the display on homepage
    And I proceed to checkout
    And I sign in and register as a new user
    And I click on proceed to checkout after registering
    And I select payment method as "<payType>"
    When I click on confirm order
    Then I should see my order successfully placed

    Examples:
      | itemCount | payType  |
      | 2         | bankwire |

  @myStore11
  Scenario Outline: As a already registered user, I want to be able to add 2 items to the cart and place an order
    And I select any "<itemCount>" items from the display on homepage
    And I proceed to checkout
    And I sign in as already registered user
    And I click on proceed to checkout after registering
    And I select payment method as "<payType>"
    When I click on confirm order
    Then I should see my order successfully placed

    Examples:
      | itemCount | payType |
      | 2         | cheque  |
