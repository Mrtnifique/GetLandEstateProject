@API_US13
Feature: City Controller API Testleri

  @ApiAdmin
  Scenario: TC01 | Belirli bir ülkeye ait sehirleri listeleme
    Given URL ayarlanır: first "cities" second "search" third "82"
    When Get Request gönderilir ve Respond alınır | Üç URL
    Then Status Code'ın 200 olduğu doğrulanır

  @ApiAdmin
  Scenario: TC02 | Butun sehirleri listeleme
    Given URL ayarlanır: first "cities" second "all"
    When Get Request gönderilir ve Respond alınır | İki URL
    Then Status Code'ın 200 olduğu doğrulanır





