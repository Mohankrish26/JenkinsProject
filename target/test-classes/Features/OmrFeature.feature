Feature: To verify Login,Add User Address,Update User Address, Get Address and Delete Address


Scenario: User need to verify the login Functionality and get Bearer Token
Given User add Headers Key "Content-Type" , Value "application/json"
When User add Authorization body for login Endpoint
And User sent POST Request for login and its Endpoint
Then User verify the response code 200
And User verify the Message "Login successfully"


Scenario: User need to verify the Add User Address Functionality
Given User add Headers Key "Content-Type" , Value "application/json" and Token Header
When User add request body for Add User Address Endpoint
And User sent POST Request for add address and its Endpoint
Then User verify the response code 200
And User verify the Message "Address added successfully" and get Order Id

Scenario: User need to verify the Update User Address Functionality
Given User add Headers Key "Content-Type" , Value "application/json" and Token Header
When User add request body for Update User Address Endpoint
And User sent PUT Request for Update address and its Endpoint
Then User verify the response code 200
And User verify the Message "Address updated successfully" for Confirmation


Scenario: User need to verify the Get User Address Functionality
Given User add Headers Key "Content-Type" , Value "application/json" and Token Header
When User sent GET Request for Update  address and its Endpoint
Then User verify the response code 200
And User verify the Message "OK" for Confirmation of Get Address


Scenario: User need to verify the Delete Address Functionality
Given User add Headers Key "Content-Type" , Value "application/json" and Token Header
When User add request body for Delete User Address Endpoint
And User sent DELETE Request for Delete address and its Endpoint
Then User verify the response code 200
And User verify the Message "Address deleted successfully" for Confirmation of Delete Address