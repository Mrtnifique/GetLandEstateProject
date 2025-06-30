@API01Pinar
Feature: Tour Requests Controller API Testleri

  @ApiCustomer1
  Scenario: Yeni bir tur isteği oluşturma
    Given customer aşağıdaki verilerle "tour-requests" adresine POST isteği gönderir
      """
      {
        "tourDate": "2025-07-30",
        "tourTime": "15:30",
        "message": "Tur hakkında bilgi almak istiyorum.",
        "advertId": 71
      }
      """
    Then durum kodu 200 olmalıdır
    Then tur isteği başarılı şekilde oluşturulmalı ve bilgiler doğru dönmeli


  @ApiCustomer2
  Scenario: Customer için tüm tur isteklerini getirme
    Given customer "tour-requests/customer" adresine GET isteği gönderir
    Then durum kodu 200 olmalıdır
    And yanıt gövdesi "content" içermelidir


  @ApiCustomer3
  Scenario: Müşteri tur isteğini günceller
    Given müşteri "1094" id'li tour request için "tour-requests" adresine PUT isteği gönderir
    """
    {
      "tourDate": "2025-08-30",
      "tourTime": "16:30",
      "message": "Tur hakkında bilgi almak istiyorum.",
      "advertId": 71
    }
    """
    Then status code 200 olmalı
    And yanıt gövdesi "Tour request updated successfully" içermelidir








