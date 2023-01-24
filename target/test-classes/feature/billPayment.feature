Feature: bill Payment 

Background:

Given enter user <emailID>
When user call billDetails API with  GET http request
Then response comes with unpaid bill 

Scenario Outline: bill Payment using user email id and wallet
 Given user bill details <billID> and <emailID>
 When user call payBill API with Bill ID Post http request, with response code <Code>
 Then  status code <Code> is  and response should be <Message> 
 
Examples:
|emailID			|billID			|Code			|Message			|
|"test99@gmail.com"			|"11250"			|"200"	|"bill paid"|
|"test99@gmail.com"			|"11254"			|"200"	|"Funds not enough"|

 
