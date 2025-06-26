
  @DBUS03
  Feature: category_property_values sütun isimlerini ve bilgilerini doğrula

    Background:
      Given Kullanıcı veritabanına bağlanır

  Scenario: category_property_values tablosunda doğru sütun isimleri bulunmalı
    When "category_property_values" tablosundan sütun bilgileri alınır
    Then Aşağıdaki sütunların mevcut olduğu doğrulanır
      | id                     |
      | value                  |
      | advert_id              |
      | category_property_key_id |
