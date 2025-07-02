@API01Pinar
Feature: Tour Requests Controller API Testleri


  @ApiCustomer
  Scenario: Yeni bir tur istegi olusturmak
    Given Tur isteği oluşturmak için URL düzenlenir
    And Tur isteği için payload verisi hazırlanır
    When Tur isteği için POST request gönderilir ve response alınır
    Then Tur isteği için durum kodunun 200 olduğu doğrulanır

  @ApiCustomer
  Scenario: Customer için tüm tur isteklerini getirme
    Given URL ayarlanır: first "tour-requests" second "page" third "13"
    When Get Request gönderilir ve Respond alınır | Üç URL
   Then Status Code'ın 200 olduğu doğrulanır

  @ApiCustomer
  Scenario: Customer tur istegini gunceller
    Given Customer url düzenler
    And customer payload düzenler
    When Customer Put request gönderir ve response alınır
    Then status code 200 olmalı


  @ApiAdmin
    Scenario: Tur istegi silinir
      Given URL ayarlanır: first "tour-requests" second "1109"
      When Delete Request gönderilir ve Respond alınır | İki URL
      Then Status Code'ın 200 olduğu doğrulanır













