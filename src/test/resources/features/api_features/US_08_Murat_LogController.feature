@API08Murat
Feature: API log Controller

  @ApiAdmin
  Scenario: TC01 | Logs Controller get
    Given URL ayarlanır: first "logs" second "3213"
    When Get Request gönderilir ve Respond alınır | İki URL
    Then Status Code'ın 200 olduğu doğrulanır