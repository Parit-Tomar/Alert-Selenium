Feature: Application Login

Scenario: Alert Rule Addition and Validation
Given User logged in with username "parit" and password "Cavisson@123"
And User switched to Alert Rule UI
When Added rules from excel details 
Then Validate added rules
And Logout from UI