@DBUS18
Feature: Kullanıcı Favorites sütun isimlerini ve bilgilerini doğrula

  Scenario: Favorites sütun isimlerini doğrula
    Given Kullanıcı "favorites" sekmesinden sütun isimlerini çeker
    Then Kullanıcı gelen isimleri doğrular
      | id         |
      | created_at |
      | updated_at |
      | advert_id  |
      | user_id    |

  Scenario: Kullanıcı Favorites sütun bilgilerini doğrular
    Given Kullanıcı "favorites" sekmesinden "348" id'den bilgileri çeker
    Then Kullanıcı gelen bilgileri doğrular
      | id  | created_at                 | updated_at | advert_id | user_id |
      | 348 | 2025-03-27 20:13:37.198318 | null       | 10        | 1576    |