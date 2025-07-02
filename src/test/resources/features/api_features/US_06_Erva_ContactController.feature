@APIerva
Feature: Contact controller

  @ApiAdmin
  Scenario: TC01 | POST
    Given Contact controller icin URL olusturulur
    And Contact controller icin payload olusturulur
    When Contact controller icin POST request gonderilir ve response alinir
    Then Contact controller icin status kodun 200 oldugu dogrulanir
    Then Contact message saved successfully gorunurlugu dogrulanir

  #@ApiAdmin
  #Scenario: TC02 | GET
  #  Given Contact Controller Get icin URL olusturulur
  #  When Get request gonderilir ve response alinir
  #  Then Status kodun 200 oldugu dog
#
  #@ApiAdmin
  #Scenario: TC03 | DELETE
  #  Given Contact controller delete icin URL olusturulur
  #  When Delete request gonderilir ve response alinir
  #  Then Status kodun 200 oldugu dogrulanir