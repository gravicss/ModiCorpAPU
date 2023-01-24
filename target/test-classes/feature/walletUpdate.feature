Feature: Wallet amount update

Scenario Outline: Update amount in wallet 
Given using  user <emailID> update the <WalletAmount> from the metioned  <source>
When user call WalletUpdate API with emailID, Payment Source and Wallet amount Post http request
Then User should get the 200 status code with amount added successfully <message>

Examples:
|emailID			|WalletAmount			|source			|Message			|
|"test99@gmail.com"			|"1000"			|"Mastercard"	|"amount updated"|