@API05Selin
Feature: API User Controller Testleri

  @ApiCustomerSelin
  Scenario: User Register Testi
    Given User Register için URL düzenlenir
    And User Register için payload düzenlenir
    When User Register için POST request gönderilir ve response alınır
    Then User Register için Status kodunun 200 olduğu doğrulanır

  @ApiCustomerSelin
  Scenario: User Login Testi
    Given User Login için URL düzenlenir
    And User Login için payload düzenlenir
    When User Login için POST request gönderilir ve response alınır
    Then User Login için Status kodunun 200 olduğu doğrulanır


  @ApiCustomerSelin
  Scenario: Get Auth User Testi
    Given URL ayarlanır: first "users" second "auth"
    When Get Request gönderilir ve Respond alınır | İki URL
    Then Status Code'ın 200 olduğu doğrulanır


  @ApiAdmin
  Scenario: Update Auth User Testi
    Given  Auth User için URL düzenlenir
    And Auth User için güncelleme payload düzenlenir
    When Auth User için PATCH request gönderilir ve response alınır
    Then Auth User için Status kodunun 200 olduğu doğrulanır


  @ApiCustomerSelin
  Scenario: Delete Auth User Testi
    Given URL ayarlanır: first "users" second "auth"
    When Auth User için DELETE request gönderilir ve response alınır
    Then Auth User için Status kodunun 200 olduğu doğrulanır
