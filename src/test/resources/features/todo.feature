@smoke
Feature: ToDo list features

Background: 
    Given user launching browser
    And user navigates to todo page
    When user enters todo name
    And click on enter

  Scenario: Check creating new todo
		Then todo is added in the list
		And close browser
  
  Scenario: Check deleting new todo
		Then todo is added in the list
		When click on delele todo
		Then todo should be deleted from list
		And close browser

  Scenario: Check completing new todo
		Then todo is added in the list
		And select todo created
		Then todo should be completed

