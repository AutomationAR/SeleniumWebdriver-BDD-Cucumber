Feature: Attendanywhere User Login Test

  Scenario: URL is leading us into the correct page
    Given user opens the browser 
    When user enters the URL
    Then validate User is on sign in page

  Scenario: display hints for the username and password fields
    Given the user nevigate to login url
    When the user checks username text field
    And the user checks password text field
    Then username displays hint as email
    And  password displays hint as password
    
  Scenario: validate that checkbox 'Keep me signed in' is positioned between password field and sign in button
    Given the user nevigate to url
    When the user reaches Keep me Signed in checkbox
    Then Validate 'keep me signed in' checbox is between password and sign button
    
  Scenario: validate that forgot your password? link is displayed below Sign in button
    Given the user nevigate to url
    When the user reaches Forgot your password link
    Then Validate Forgot your password link is below sign in button 
    
  Scenario: validate that all fields are visible and fields should not overlap when 
    Given the user nevigate to url
    When the user reduced the browser to minimum width
    Then validate that all fields are visible and clickable 
    
  Scenario: Enter invalid Email address and Password, an error message should be displayed
    Given the user nevigate to url
    When the user enters invalid email
    And the user enters invalid password 
    Then display the error message
    
  Scenario: Enter valid Email address and Password in the respective fields 
    Given the user nevigate to url
    When the user enters the valid email
    And the user enters the valid password 
    Then validate that User can enter the details as expected
    
  Scenario: user can sign into the application when entered correct credentials
    Given the user nevigate to url
    When the user enters valid email
    And the user enters valid password 
    Then validate that user is into the homepage
    