@API09Ayhan
Feature: API Favorites Controller

  @ApiAdmin
  Scenario: TC01 | Favorites Controller get
    Given URL ayarlanır: first "favorites" second "50" third "auth"
    When Get Request gönderilir ve Respond alınır | Üç URL
    Then Status Code'ın 200 olduğu doğrulanır

  @ApiAdmin
  Scenario: TC02 | Favorites Controller countFavGet
    Given URL ayarlanır: first "favorites" second "countFav"
    When Get Request gönderilir ve Respond alınır | İki URL
    Then Status Code'ın 200 olduğu doğrulanır