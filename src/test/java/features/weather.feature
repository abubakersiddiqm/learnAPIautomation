Feature: Get weather details for india
  Scenario: weather details for india
    Given request uri for zippo
    And get the value for india
    When places is Janpath
    Then validate the status code


