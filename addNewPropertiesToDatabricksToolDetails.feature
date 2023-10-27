@RegressionTest
Feature: Feature: As a FEMADex analyst or super user, I want to know what additional tools can be used to connect to FEMADex,
  so that I can select the most appropriate tool for my task.

  Design: https://www.figma.com/file/2NBHcUePC17JAzHloYJZ2W/fma

  @issue:FDT-200
  Scenario: Add new properties to Databricks details
    Given I'm a FEMADex user that is a member of a Team Workspace
    When I view the Databricks tools details
    Then I should see the following additional properties listed in Table 2 of  FEMADex Capabilities, Tools, And Services - FEMA EDAMI - Maestro Confluence (dhs.gov)
      |Server |
      |Port |
      |HTTP Path |
    And the added values should be displayed under the Get Token button


  Scenario: Add API call to get Token
    Given I'm a FEMADex user that is a member of a Team Workspace
    When I view the Databricks tools details
    Then in the "Properties" section I should see an action to generate the Databricks token "Generate new token"
    And When I select the action to generate the new token
    Then FEMADex should submit a request for token with no lifetime specified
    And When FEMADex receives a response
    Then the token should be displayed in a field like the other property values
    And I should have the ability to copy the token

  Scenario: Display Success/Failure of API Call
    Given I'm a FEMADex user that is a member of a Team Workspace
    When I select the action to generate a new token
    And When the call is successful at providing a token
    Then the following text should display: "Success. The token was successfully generated."
    And When the call is unsuccessful at providing a token
    Then the following text should display: "Token not generated. The Databricks token was not successfully generated. Please contact your workspace administrator for assistance."