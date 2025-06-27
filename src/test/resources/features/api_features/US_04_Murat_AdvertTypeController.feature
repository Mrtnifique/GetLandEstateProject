@API04Murat
Feature: API Advert Type Controller

  @ApiAdmin
  Scenario: TC01 | Advert Type Controller get

  @ApiAdmin
  Scenario: TC02 | Advert Type Controller post
    Given Advert Type için URL ayarlanır
    And Advert Type için payload ayarlanır
    When Advert Type için get Request gönderilir ve Respond alınır
    Then Status Code'ın 200 olduğu doğrulanır


  @ApiAdmin
  Scenario: TC03 | Advert Type Controller patch

  @ApiAdmin
  Scenario: TC04 | Advert Type Controller delete