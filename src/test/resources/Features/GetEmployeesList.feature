Feature: Test to retreive get method of employee

  Scenario Outline: Send a valid Request to GET employee
    Given Get Call to url
    Then Response Code status is validated for GET
    And verify response content type is "<contentType>" for GetEmployeeList
    And print out the response body to console for GetEmployeeList

    Examples: 
      | contentType      |
      | application/json |