@wip
Feature:7) As a user, I should be able to do
  see posts from homepage.
  "1. users  (hr, marketing and helpdesk)  click ""Like"" button for any post
  2. users are able to fllow a post by clicking ""Follow"" button
  3. users can see who are the people viewed a post with eye icon
  4. users click star icon to save a post as favorite
  5. users can write a comment to a post
  6. users cancel a comment with ""Cancle"" button
  "

   Scenario: hr users click Like button for any post
     Given hr user is login in to the hr account
     When hr user click on like button for the first post user see
     Then hr user should be able to see a thumps up with "You" text

  Scenario: marketing users click Like button for any post
    Given marketing user is login in to the marketing account
    When marketing user click on like button for the first post user see
    Then marketing user should be able to see a thumps up with "You" text

  @wip
  Scenario: helpdesk users click Like button for any post
    Given helpdesk user is login in to the helpdesk account
    When helpdesk user click on like button for the first post user see
    Then helpdesk user should be able to see a thumps up with "You" text

