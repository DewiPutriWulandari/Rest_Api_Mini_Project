@Authentication
Feature: Authentication
	
  @tag1
  Scenario: User register with valid data
    Given User set method post and endpoint register
    When User input http body
    Then User received respon message 400
	
	@tag2
  Scenario: User register without email
    Given User set method post and endpoint register
    When User input http body
    Then User received respon message 400

	@tag3
  Scenario: User register without password
    Given User set method post and endpoint register
    When User input http body
    Then User received respon message 400

  @tag4
  Scenario: User register without fullname
    Given User set method post and endpoint register
    When User input http body
    Then User received respon message 400

  @tag5
  Scenario: User register with invalid email
    Given User set method post and endpoint register
    When User input http body
    Then User received respon message 400

  @tag6
  Scenario: User login with valid data
    Given User set method post and endpoint login
    When User input http body
    Then User received response code 200

  @tag7
  Scenario: User login with invalid password
    Given User set method post and endpoint login
    When User input http body
    Then User received response code 400

  @tag8
  Scenario: Get user information with token
    Given User set method get and endpoint get user information
    When User input token
    Then User received respon code 200
