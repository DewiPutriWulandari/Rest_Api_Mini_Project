@ProductCategories
Feature: Products Categories

  @tag19
  Scenario: User create a category
    Given User set method post and endpoint create a category
    And I set http body
    Then User receive valid http response code 200

	@tag20
  Scenario: User get all categories
    Given User set method get and endpoint get all categories
    Then User received valid response code 200
