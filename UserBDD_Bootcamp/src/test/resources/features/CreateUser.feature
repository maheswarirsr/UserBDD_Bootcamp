Feature: Validating User API's

#post
Scenario: Verify if user is being successfully created using CreateUserAPI
 Given Create user with valid payload
 When user calls "CreateUserAPI" with "post" request
 Then user created with status code 201


#get
Scenario: Verify if user is being successfully retrieved using GetallUsersAPI
  Given Get user  with valid data
  When user calls "GetallUsersAPI" with "get" request
  Then the API call is success with status code 200
  
  Scenario: Verify if user is being successfully retrieved using GetUserbyIdAPI
  Given Get user  with valid data
  When user calls "GetUserbyIdAPI" with "get" request
  Then the API call is success with status code 200
  
  Scenario: Verify if user is being successfully retrieved using GetUserbyNameAPI
  Given Get user  with valid data
  When user calls "GetUserbyNameAPI" with "get" request
  Then the API call is success with status code 200
 
 