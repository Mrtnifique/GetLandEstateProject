@DBUS05
Feature: Daily reports sütun isimlerini ve bilgilerini doğrula

Background:
  Given Kullanıcı veritabanına bağlanır

  Scenario: Daily reports sütun isimlerini doğrula
    When Kullanıcı "daily_reports" sekmesinden sütun isimlerini çeker
    Then Kullanıcı gelen isimleri doğrular
      | id                                |
      | date                              |
      | number_of_contact_message         |
      | number_of_favorites               |
      | number_of_rent_adverts            |
      | number_of_sale_adverts            |
      | number_of_tour_requests           |
      | number_of_users                   |


  Scenario: Daily Reports tablosundan "number_of_rent_adverts" adlı görselin varlığını kontrol eder
    Given Daily Reports tablosundan number_of_rent_adverts adlı kayıt bilgilerini çeker
    Then  Kullanıcı gelen bilgileri doğrular
