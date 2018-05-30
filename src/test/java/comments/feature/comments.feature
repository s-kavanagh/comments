Feature: Comments Page Feature
	
	@automated
  Scenario: I can add a comment
    Given I am on a blog page
    And I login as a user who can comment
    When I write a comment
    Then My comment should be displayed at the top of the list
    
  @automated  
  Scenario: If I have not verified my email I see resend email prompt
  	Given I am on a blog page
  	And I login as an unverified user
  	Then I should see a resend email prompt
  
  @manual	
  Scenario: I can upvote a comment
    Given I am on a blog page
    And I login as a user who can comment
    When I upvote a comment
    Then that comment's votes increase by 1

  @manual	
  Scenario: I can only upvote a comment once
    Given I am on a blog page
    And I login as a user who can comment
    When I upvote a comment
    Then that comment cannot be upvoted again
    
  @manual	
  Scenario: I can order comments by votes
    Given I am on a blog page
    When I order the comments by 'highest rated'
    Then the top 15 highest voted comments are shown