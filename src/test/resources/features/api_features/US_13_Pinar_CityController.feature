@API_US13
Feature: City Controller API Testleri

  @ApiCity
  Scenario: Belirli bir ülkeye ait şehirleri listeleme
    Given kullanıcı "country/all" endpointine GET isteği gönderir
    Then yanıt gövdesinden "Deutschland" ülkesinin id'si alınır
    And kullanıcı "city/byCountry" endpointine bu id ile GET isteği gönderir
    Then durum kodu 200 olmalıdır
    And yanıt gövdesi "Berlin" içermelidir
