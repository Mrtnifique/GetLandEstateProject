@API05Selin
Feature: API User Controller Testleri

  @ApiCustomer
  Scenario: User Register Testi
    Given User Register için URL düzenlenir
    And User Register için payload düzenlenir
    When User Register için POST request gönderilir ve response alınır
    Then User Register için Status kodunun 200 olduğu doğrulanır

  @ApiCustomer
  Scenario: User Login Testi
    Given User Login için URL düzenlenir
    And User Login için payload düzenlenir
    When User Login için POST request gönderilir ve response alınır
    Then User Login için Status kodunun 200 olduğu doğrulanır


  @ApiCustomer
  Scenario: Get Auth User Testi
    Given URL ayarlanır: first "users" second "auth"
    When Auth User için GET request gönderilir ve response alınır
    Then Auth User için Status kodunun 200 olduğu doğrulanır


  @ApiCustomer
  Scenario: Update Auth User Testi
    Given  Auth User için URL düzenlenir
    And Auth User için güncelleme payload düzenlenir
    When Auth User için PATCH request gönderilir ve response alınır
    Then Auth User için Status kodunun 200 olduğu doğrulanır


  @ApiCustomer
  Scenario: Delete Auth User Testi
    Given URL ayarlanır: first "users" second "auth"
    When Auth User için DELETE request gönderilir ve response alınır
    Then Auth User için Status kodunun 200 olduğu doğrulanır
