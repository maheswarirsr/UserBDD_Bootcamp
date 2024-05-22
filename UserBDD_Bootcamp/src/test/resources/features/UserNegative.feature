 Feature: Validating negative scenarios for user
 
 #post - invalid
  #Scenario: Check if user able to create with validendpoint and requestbody without Authorization
    #Given create user with valid payload without authorization
    #When user send HTTPS Request and  request Body with endpoint
    #Then user receives "401" with error message "Unauthorized"

  Scenario: Check if user able to create with invalidendpoint
    Given user with an invalid endpoint
    When user send post Request and request Body with invalidendpoint
    Then user receives "404" with error message "Not Found" 

  Scenario: Check if user able to create without mandatory fields payload
    Given user without mandatory fields
    When user send post Request and request Body without mandatory fields
    Then user receives "400 BAD_REQUEST" with message "user FirstName is mandatory and should contains alphabets only"

  Scenario: Check if user able to create with invalidmethod
    Given user with invalidmethod
    When user send post Request and request Body with invalidmethod
    Then user receives "405" with error message "Method Not Allowed"

  Scenario: Check if user able to create with invalidrequestbody
    Given user with Invalid payload
    When user send post Request and request Body with invalid data
    Then user receives "400 BAD_REQUEST" with message "Phone Number is required and should contains 10 numeric values only"  

 
    
    #get - invalid
    #Scenario: Check if user able to get with validendpoint  without Authorization
    #Given get users  without authorization
    #When user send "get" Request  with validendpoint
    #Then user receives "401" with error message "Unauthorized"
    
    Scenario: Check if user able to get with invaliduserId
    Given get with Invalid userId
    When user send "get" Request with invaliduserId
    Then user receives "404 NOT_FOUND" with message "User with userId 1233444 not found!"  
    
    Scenario: Check if user able to get with invaliduserName
    Given get with Invalid userName
    When user send "get" Request with invaliduserName
    Then user receives "400" with error message "Bad Request"  
    
    #delete - invalid
    #Scenario: Check if user able to delete with invalidendpoint  without Authorization
    #Given delete users  without authorization
    #When user send "delete" Request  with validendpoint
    #Then user receives "401" with error message "Unauthorized"
    
    #Scenario: Check if user able to delete with invaliduserId
    #Given delete with Invalid userId
    #When user send "delete" Request with invaliduserId
    #Then user receives "404 NOT_FOUND" with message "User with userId 1233444 not found!"  
    #
    #Scenario: Check if user able to get with invaliduserName
    #Given delete with Invalid userName
    #When user send "delete" Request with invaliduserName
    #Then user receives "400" with error message "Bad Request"   
    #
    