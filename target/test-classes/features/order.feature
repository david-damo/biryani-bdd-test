Feature: Biryani Order Placement
  As a customer
  I want to place an order for Biryani
  So that I can receive the order status

  Scenario: Place an order for Chicken Biryani
    Given I am on the Biryani Order page
    When I enter my name as "John Doe"
    And I select "Chicken" Biryani
    And I enter quantity as "2"
    And I place the order
    Then I should see the order status as "Order Status"