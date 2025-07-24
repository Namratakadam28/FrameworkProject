Feature:Application Login

Scenario:Login with valid credentials
Given Open any Browser
And Navigate to Login page
When User enters email as "knamratasanjay@gmail.com" and password as "Namrata@123" into the field
And User clicks on Login button
Then Verify user is able to successfully login


