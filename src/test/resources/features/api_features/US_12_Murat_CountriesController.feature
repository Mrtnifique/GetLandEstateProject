@API12Murat
Feature: API countries Controller

  @ApiAdmin
  Scenario: TC01 | Countries All Controller get
    Given URL ayarlanır: first "countries" second "all"
    When Get Request gönderilir ve Respond alınır | İki URL
    Then Status Code'ın 200 olduğu doğrulanır