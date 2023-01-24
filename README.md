Assumption:
1. There is no authentication required to access the user account
2. There are 4 different APIs at work here.
3. baseURL="modiCorppayment.com"
4. API endpoints  taken under assumption are /addUser,/payBill,/getBill,/walletUpdate
5. if there is no bill to pay, /getBill will return null in response
6. customer will pay bill will billID
7. /getBill will return with bill id and bill amount
8. if need in future the response can be updated in json response instead of static string response

Automation Tool and libraries: RestAssured, Cucumber, Junit, Tidy Gherkins, Maven, Git, extent reports
Programming Language: Java, Gherkins

Framework structure

1. TestRunner class with use junit to run the test cases
2. with multiple feature file and multiple step defination file we can control which test to run
3. using hook we will initalize the report creation using extent reports
4. we can further update the reporting with listners 
5. we are using pojo classes to create the request , serlization is done by using object mapper class
