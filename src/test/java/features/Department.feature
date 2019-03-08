Feature: Managing Department Data Master

  Scenario: client makes call to GET /department
    When the client call /department/all
    Then the department receives status of 200
    And the response should be contain:
  """
  Department One
  """
#    """
#    [{"id":1,"name":"Department One"},{"id":2,"name":"Department Two"}]
#    """
