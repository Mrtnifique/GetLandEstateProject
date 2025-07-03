@APIUS07Semih
  Feature: API report-controller

    @ApiAdmin
    Scenario: TC01 report-controller GET Testi
      Given Report Controller GET icin URL duzenlenir
      When Report Controller icin GET request gonderilir ve response alinir
      Then Dogrulama kodu 200 dogrulamasi