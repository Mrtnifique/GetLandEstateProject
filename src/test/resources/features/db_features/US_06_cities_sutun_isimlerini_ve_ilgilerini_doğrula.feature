@DBUS06
Feature: Kullanıcı Favorites sütun isimlerini ve bilgilerini doğrula

  Scenario: Kullanıcı favorites sütun isimlerini doğrular
    Given Kullanıcı "cities" sekmesinden sütun isimlerini çeker
    Then Kullanıcı gelen isimleri doğrular
      | id |
      | lat |
      | Ing |
      | name |
      | county_id |

  Scenario: Kullanıcı Favorites sütun bilgilerini doğrular
    Given Kullanıcı "cities" sekmesinden "4123" id'den bilgileri çeker
    Then Kullanıcı gelen bilgileri doğrular
      | id  | lat | Ing | name | country_id |
      | 4123 | 38.6852729 | 30.6427411 | Afyonkarahisar | 223 |
