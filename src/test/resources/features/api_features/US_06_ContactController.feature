
@API06Tugberk
Feature: API Contact Controller Testleri

  @ApiAdmin
  Scenario: TC01 | Contact Controler Testi
    Given Contact Controller icin URL düzenlenir
    And Contact Controller icin payload olusturulur
    Then Status Code 200 olduğu doğrulanır
    Then Contact message saved successfully görünürlüğü doğrulanir

  @ApiAdmin
  Scenario: TC02 | Contact Controller Get Testi
    Given Contact Controller Get icin URL düzenlenir
    When Get Request gönderilir ve Respond alınır
    Then Status Code 200 olduğu doğrulanır


  @ApiAdmin
  Scenario: TC03 | Contact Controller Delete Testi
    Given Contact Controller Delete icin URL düzenlenir
    When Delete Request gönderilir ve Respond alınır
    Then Status Code 200 olduğu doğrulanır


  @ApiAdmin
  Scenario: TC04 | Contact Controller Patch Testi
    Given Contact Controller Patch icin URL düzenlenir
    And Contact Controller Patch icin payload olusturulur
    When Patch Request gönderilir ve Respond alınır
    Then Response body deki lastName degeri kontrol edilmelidir
