@API10Selin
Feature: API Districts Controller

  @ApiAdmin
  Scenario: TC01 | Districts Controller get
    Given URL ayarlanır: first "districts" second "search" third "4121"
    When Get Request gönderilir ve Respond alınır | Üç URL
    Then Status Code'ın 200 olduğu doğrulanır