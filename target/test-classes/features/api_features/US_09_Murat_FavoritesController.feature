@API09Murat
Feature: API Favorites Controller

  @ApiAdmin
  Scenario: TC01 | Favorites Controller get
    Given URL ayarlanır: first "favorites" second "50" third "auth"
    When Get Request gönderilir ve Respond alınır | Üç URL
    Then Status Code'ın 200 olduğu doğrulanır

  @ApiAdmin
  Scenario: TC02 | Favorites Controller delete
    Given URL ayarlanır: first "favorites" second "50" third "auth"
    When Delete Request gönderilir ve Respond alınır | Üç URL
    Then Status Code'ın 200 olduğu doğrulanır