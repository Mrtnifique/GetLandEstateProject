@APIUS01Seval

Feature: API Tour Requests CRUD Flow

  @ApiAdmin
  Scenario: TC01 | GET Admin Tour Request Count
    Given Tour-Request_Controller Get icin URL düzenlenir
    When GET request gönderilir ve response alınır
    Then status code 200 olmali
