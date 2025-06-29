@API01Pinar
Feature: Tour Requests Controller API Testleri

    @ApiCustomer
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



