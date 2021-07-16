Feature: 6- As a user, I should be able to log
  work hours with time reporting"

  1. users  (hr, marketing and helpdesk) start time tracking with ""Clock in"" button
  2. users stop tracking with ""CLOCK OUT"" button when work hour is end
  3. users create a new task for daily plan
  4. users add an event with starting and ending time
  5. users edit work day starting and ending time.

  Scenario:  Hr user start time tracking with ""Clock in"" button
    Given hr user is login in to the hr account
    When hr user click on the clock out
    And hr user click on continue working day
    Then hr user should see the Clocked out changed to Working

