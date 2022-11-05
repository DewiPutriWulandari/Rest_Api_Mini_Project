Feature: Products

  @tag9
  Scenario: User get all products
    Given User set method get and endpoint get all products
    Then User receive valid HTTP response code 200

  @tag10
  Scenario: User get all products with invalid endpoint
    Given User set method get and endpoint get all products
    Then User receive valid HTTP response code 404

  @tag11
  Scenario: User create new products
    Given User set method post and endpoint create new product
    And User input HTTP body
    Then User receive HTTP response code 200

  @tag12
  Scenario: User create new product with invalid data
    Given User set method post and endpoint create new product
    And User input HTTP body
    Then User receive HTTP response code 400

  @tag13
  Scenario: User assign a product rating without token
    Given User set method post and endpoint assign a product rating
    And User input valid HTTP body
    Then User receive valid respon code 401

  @tag14
  Scenario: User assign a product rating without token
    Given User set method post and endpoint assign a product rating
    And User input valid HTTP body
    Then User receive valid respon code 200

  @tag15
  Scenario: User see product rating with invalid endpoint
    Given User set method post and endpoint see product rating
    Then User receive valid HTTP respon code 200

  @tag16
  Scenario: User see product rating
    Given User set method post and endpoint see product rating
    Then User receive valid HTTP respon code 404

  @tag17
  Scenario: User see product comments
    Given User set method post and endpoint see products comments
    Then User received valid HTTP response code 200

  @tag18
  Scenario: User see product comments with invalid endpoint
    Given User set method post and endpoint see products comments
    Then User received valid HTTP response code 404
