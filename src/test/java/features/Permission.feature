Feature: Managing Permission for Spring Security

  Scenario: client makes call to GET /permissions
    When the client call /permissions
    Then the client receives status of 200
    And the response should be contain "can_read_user"
