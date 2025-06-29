@API04Murat
Feature: API Advert Type Controller

  @ApiAdmin
  Scenario: TC01 | Advert Type Controller get
    Given URL ayarlanır: first "advert-types" second "119"
    When Get Request gönderilir ve Respond alınır | İki URL
    Then Status Code'ın 200 olduğu doğrulanır

  @ApiAdmin
  Scenario: TC02 | Advert Type Controller post
    Given URL ayarlanır: first "advert-types"
    And Advert Type için payload ayarlanır
    When Post Request gönderilir ve Respond alınır | Tek URL
    Then Status Code'ın 200 olduğu doğrulanır

  @ApiAdmin
  Scenario: TC03 | Advert Type Controller put
    Given URL ayarlanır: first "advert-types" second "119"
    And Advert Type için payload ayarlanır
    When Put Request gönderilir ve Respond alınır | İki URL
    Then Status Code'ın 200 olduğu doğrulanır

  @ApiAdmin
  Scenario: TC04 | Advert Type Controller delete
    Given URL ayarlanır: first "advert-types" second "119"
    When Delete Request gönderilir ve Respond alınır | İki URL
    Then Status Code'ın 200 olduğu doğrulanır