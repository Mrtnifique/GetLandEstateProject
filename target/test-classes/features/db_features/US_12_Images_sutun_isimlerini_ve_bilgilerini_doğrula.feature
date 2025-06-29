@DBUS12
Feature: Images sütun isimlerini ve bilgilerini doğrula

Background:
  Given Kullanıcı veritabanına bağlanır

  Scenario: Images sütun isimlerini doğrula
    When Kullanıcı "images" sekmesinden sütun isimlerini çeker
    Then Kullanıcı gelen isimleri doğrular
      | id                 |
      | data               |
      | featured           |
      | name               |
      | type               |
      | advert_id          |


  Scenario: Images tablosundan "Modern Office" adlı görselin varlığını kontrol eder
    When Images tablosundan "Modern Office" adlı kayıt sorgulanır
    Then Kayıt bulunmalıdır
