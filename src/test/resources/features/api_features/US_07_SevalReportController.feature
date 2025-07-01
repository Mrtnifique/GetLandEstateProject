@APIUS07Seval
Feature: API Report Controller

  @ApiAdmin
  Scenario: TC01 | Report-Controller Get Testi
    Given Report-Controller Get icin URL düzenlenir
    When Report-Controller Get Request gönderilir ve Response alınır
    Then Dogrulama kodun 200 dogrulamasi yapilir