@RegressionTest @GlobalSearch
Feature: As an internal FEMADex user with access to the data product search who is a member of one or more Teams,
  I want the data product search results page to include a workspace filter, so that I can easily find data products that belong to my teams' workspace.




    Background: Log in
    Given I am a FEMADex user in pilot interested in search bar

  @test-seq-1
  Scenario: Test empty result set in Data Search
    When I enter QWERTY in the search box and press enter
    Then I should see No Results returned to the user

  @test-seq-2
    Scenario: Filter group updates and redesign
    When I navigate to the data product search results
    Then I see a section Refine Results with following filter groups to further refine my search results
    And I see each value within the filters has the count that represents the number of search results returned for the search criteria
    And I have the ability to collapse and or expand the filter groups

  @test-seq-3
  Scenario: Filter selection design
    When I navigate to the data product search results and select a filter
    Then I see the selected filters are displayed at the top of the search results

  @test-seq-4
  Scenario: Filter values for "My Filters" filter group
    When I navigate to the data product search results
    Then I see the My Filters filter group has the following values My Favorites

    # ************************************** BELOW IS COMING FROM THE ENHANCEMENT STORY FDT-320 *******************************************

  @issue:@FDT-320
  Scenario: Add Workspace Filter
    When I navigate to the data product search results
    Then I will see a filter group named "Workspace" within the Refine Results section
    And the new group is displayed as the first filter group in the section
    And one of the values in the filter group will be "Enterprise" which correlates to data products in the search results that belong to the Enterprise workspace
    And the other values in the filter group will be the Team Name for all of the teams that I am a member of that have data products in the search results
    And the values in the group will be ordered Alphabetically
    And each value within the group has the count that represents the number of search results returned for the search criteria

  Scenario: Show Workspace Indicator in Search Results*
    Given I'm a FEMADex user with access to the data product search who is a member of one or more Teams
    When I navigate to the data product search results
    Then for the data products in the search results that belong to the Enterprise workspace, I will see a green icon with the word "ENTERPRISE" followed by "Enterprise Workspace" listed as the first attribute in the line of attributes displayed below the Data Product Title
    And for the data products in the search results that belong to a Team workspace, I will see a blue icon with the word "TEAM" followed by the name of the team as the first attribute in the line of attributes displayed below the Data Product title
    And I will see the label "Details Modified" which is the date the metadata was last updated in CKAN
    And in the "View more" in the search result here is a field "Published" which is the date the product was added to the catalog to be searchable
    And When I hover over the TEAM or ENTERPRISE icon, there is a tool tip that display either "Enterprise Workspace" or "Team Workspace Name"
    And the dates follow the format as shown in the design

  Scenario: Show Workspace Indicator in Data Product Details modal
    Given I'm a FEMADex user with access to the data product search who is a member of one or more Teams
    When I navigate to the data product search results And open the Data Product Details modal
    Then if the data product belongs to the Enterprise workspace, I will see a green icon with the word "ENTERPRISE" followed by "Enterprise Workspace"
    And listed as the first attribute in the line of attributes displayed below the Data Product Title
    And if the data product belongs to a Team workspace, I will see a blue icon with the word "TEAM" followed by the name of the Team as the first attribute in the line of attributes displayed below the Data Product Title
    And I will see the label "Details Modified" which is the date the metadata was last updated in CKAN
    And the date follows the format as shown in the design
    And When I hover over the TEAM or ENTERPRISE icon, there is a tool tip that display either "Enterprise Workspace" or "Team Workspace Name"

  Scenario: Remove Formats Filter*
    Given I'm a FEMADex user with access to the data product search
    When I navigate to the data product search
    Then I will no longer see the "Formats" filter group
    And When I expAnd the "View More" menu in the search results for a data product, I will no longer see the Formats attribute

  Scenario: Update Sort dropdown*
    Given I'm a FEMADex user with access to the data product search
    When I navigate to the data product search
    Then I want the Sort option to sort by "Details Modified" which is the date the metadata was updated
    And upon selection "Details Modified" Then the search results filter by date descending

  Scenario: Data product details - add Sensitivity Level
    Given I'm a FEMADex user with access to view product details
    When I open the product details
    Then I want to see the "Sensitivity Level" value in the main header section as shown in the design "https://www.figma.com/file/2NBHcUePC17JAzHloYJZ2W/fma?node-id=1436%3A12161"

