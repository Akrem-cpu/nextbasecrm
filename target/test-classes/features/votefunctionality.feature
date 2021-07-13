@regression
Feature:As a user, I should be able to vote for a poll


  Scenario:users hr can select an answer to vote a poll.
    Given User is on nextbase login page
    When hr user is login in to the hr account
    And hr user navigate to poll post for vote
    And hr user check the box that user like to vote for
    And hr user click on the vote button
    Then hr user should see "VOTE AGAIN" text

  Scenario:users helpdesk can select an answer to vote a poll.
    Given User is on nextbase login page
    When helpdesk user is login in to the helpdesk account
    And helpdesk user navigate to poll post for vote
    And helpdesk user check the box that user like to vote for
    And helpdesk user click on the vote button
    Then helpdesk user should see "VOTE AGAIN" text

  Scenario:users Marketing can select an answer to vote a poll.
    Given User is on nextbase login page
    When marketing user is login in to the marketing account
    And marketing  user navigate to poll post for vote
    And marketing  user check the box that user like to vote for
    And marketing  user click on the vote button
    Then marketing  user should see "VOTE AGAIN" text

  Scenario:users Marketing can select an answer to vote a poll.
    Given User is on nextbase login page
    When marketing user is login in to the marketing account
    And marketing  user navigate to poll post for vote
    And marketing  user check the box that user like to vote for
    And marketing  user click on the vote button
    And marketing user click on vote again button
    Then marketing user should be able to vote again

  Scenario:users Marketing can select an answer to vote a poll.
    Given User is on nextbase login page
    When marketing user is login in to the marketing account
    And marketing  user navigate to poll post the user created
   Then marketing user should see stop button