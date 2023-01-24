Feature: Add user and pay bill

Scenario Outline: Creating User account using Add user API
Given create user using <emailID> 
When user call addUser API with <emailID> Post http request 
Then status code is <ErrorCode> and response should be <Message>

 
Examples:
|emailID			|Message			|<ErrorCode>|
|"test99@gmail.com"	|"wallet is created and registered for the customer"|"201"|
|"test99@gmail.com"	|"wallet is already registered"|"401"|
|"failegmailcom"	|"ID is not valid"|"401"|
