Feature: Validating User API

  #post
  Scenario: Verify if user is being successfully created using CreateUserAPI
    Given Create user with valid payload
    When user calls "CreateUserAPI" with "post" request
    Then user created with status code 201

  #
  #put
  Scenario: Verify if user is being successfully updated using UpdateUserbyIdAPI
    Given Update user with valid payload
    When user calls "UpdateUserbyIdAPI" with "put" request
    Then API call is success with status code 200

  #
  #get
  Scenario: Verify if user is being successfully retrieved using GetallUsersAPI
    Given Get user  with valid data
    When user calls "GetallUsersAPI" with "getusers" request
    Then the API call is success with status code 200

  #get
  Scenario: Verify if user is being successfully retrieved using GetUserbyIdAPI
    Given Get user  with valid data
    When user calls "GetUserbyIdAPI" with "getbyuserId" request
    Then the API call is success with status code 200

  #delete
  Scenario: Verify if user is being successfully deleted using DeleteUserbyIdAPI
    Given Delete user with valid userId
    When user calls "DeleteUserbyIdAPI" with "deletebyuserId" request
    Then the API call is success with status code 200

  #
  #getname
  Scenario: Verify if user is being successfully retrieved using GetUserbyNameAPI
    Given Get user  with valid data
    When user calls "GetUserbyNameAPI" with "getbyusername" request
    Then the API call is success with status code 200

  #
  #deletename
  Scenario: Verify if user is being successfully deleted using DeleteUserbyNameAPI
    Given Delete user with valid userName
    When user calls "DeleteUserbyNameAPI" with "deletebyusername" request
    Then the API call is success with status code 200

  #post - invalid
  Scenario: Check if user able to create with invalidendpoint
    Given user with an invalid endpoint
    When user send post Request and request Body with invalidendpoint
    Then user receives "404" with error message "Not Found"

  Scenario: Check if user able to create without mandatory fields payload
    Given user without mandatory fields
    When user send post Request and request Body without mandatory fields
    Then user got "400 BAD_REQUEST" with message "User First Name is mandatory and should contains alphabets only"

  Scenario: Check if user able to create with invalidmethod
    Given user with invalidmethod
    When user send post Request and request Body with invalidmethod
    Then user receives "405" with error message "Method Not Allowed"

  Scenario: Check if user able to create with invalidrequestbody
    Given user with Invalid request body
    When user send post Request and request Body with invalid data
    Then user receives "409 CONFLICT" with message "User already exist with same contact number"

  #put - invalid
  Scenario: Check if user able to update with invalidendpoint
    Given user with an invalid endpoint
    When user send HTTPS Request and request Body with invalidendpoint
    Then user receives "404" with error message "Not Found"

  #Scenario: Check if user able to update with already existing phonenumber
  #Given user update with existing phonenumber
  #When user send HTTPS Request and  request Body with existing phonenumber
  #Then user receives "400 BAD_REQUEST" with message
  
  
  Scenario: Check if user able to update with invalidmethod
    Given user with invalidmethod
    When user send HTTPS Request and request Body with invalidmethod
    Then user receives "405" with error message "Method Not Allowed"

  Scenario: Check if user able to update with invalidrequestbody
    Given user with Invalid payload
    When user send HTTPS Request and request Body with invalid data
    Then user receives "400 BAD_REQUEST" with message "Contact number is already in use by another user"

  Scenario: Check if user able to update with missing values in the requestbody
    Given user with missing payload
    When user send HTTPS Request and request Body with missing data
    Then user receives "400 BAD_REQUEST" with message "User First Name is mandatory and should contains alphabets only"

  #get - invalid
  #
  Scenario: Check if user able to get with invaliduserId
    Given get with Invalid userId
    When user send "get" Request with invaliduserId
    Then user receives "404 NOT_FOUND" with message "User with userId 1233444 not found!"

  Scenario: Check if user able to get with invaliduserName
    Given get with Invalid userName
    When user send "get" Request with invaliduserName
    Then user receives "400" with error message "Bad Request"

  #delete - invalid
  Scenario: Check if user able to delete with invaliduserId
    Given delete with Invalid userId
    When user send "delete" Request with invaliduserId
    Then user receives "404 NOT_FOUND" with message "User with userId 1233444 not found!"

  Scenario: Check if user able to get with invaliduserName
    Given delete with Invalid userName
    When user send "delete" Request with invaliduserName
    Then user receives "400" with error message "Bad Request"


  #unauthorized
  Scenario: Check if user able to create with validendpoint and requestbody without Authorization
    Given create user with valid payload without authorization
    When user send HTTPS Request and  request Body with endpoint
    Then user receives "401" with error message "Unauthorized"

  Scenario: Check if user able to update with validendpoint and requestbody without Authorization
    Given Update user with valid payload without authorization
    When user send HTTPS Request and  request Body with endpoint
    Then user receives "401" with error message "Unauthorized"

  Scenario: Check if user able to get with validendpoint  without Authorization
    Given get users  without authorization
    When user send "get" Request  with validendpoint
    Then user receives "401" with error message "Unauthorized"

  Scenario: Check if user able to delete with invalidendpoint  without Authorization
    Given delete users  without authorization
    When user send "delete" Request  with validendpoint
    Then user receives "401" with error message "Unauthorized"
