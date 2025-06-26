@DBUS10
Feature: Confirmation_token sütun isimlerini ve bilgilerini doğrula

  Scenario: Confirmaton_token sütun isimlerini doğrula
    Given Kullanıcı "confirmation_token" sekmesinden sütun isimlerini çeker
    Then Kullanıcı gelen isimleri doğrular
      | id                 |
      | confirmation_token |
      | created_time       |
      | user_id            |


