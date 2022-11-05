@Orders
Feature: Orders

	@tag21
  Scenario: User create a new order without token
    Given User set method post and endpoint create a new order
    And User set HTTP body
    Then User receive response code 401

  @tag22
  Scenario: User create a new order with token
    Given User set method post and endpoint create a new order
    And User set HTTP body
    Then User receive response valid code 200

  @tag23
  Scenario: User get all orders with token
    Given User set method post and endpoint get all orders
    Then User receive respon valid code 200

  @tag24
  Scenario: User get all orders without token
    Given User set method post and endpoint get all orders
    Then User receive respon valid code 401

  @tag25
  Scenario: User get order by id with token
    Given User set method post and endpoint get order by id
    Then User receive response code 200

  @tag26
  Scenario: User get order by id without token
    Given User set method post and endpoint get order by id
    Then User receive response valid code 401
