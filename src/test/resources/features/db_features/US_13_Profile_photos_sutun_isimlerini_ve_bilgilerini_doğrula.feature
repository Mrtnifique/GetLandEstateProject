@DBUS13
  Feature: Profile Photos sütun isimlerini ve bilgilerini doğrula

    Scenario: Profile Photos sütun isimlerini dogrula
      Given Kullanıcı "profile_photos" sekmesinden sütun isimlerini çeker
      Then Kullanıcı gelen isimleri dogrular
        | id      |
        | data    |
        | name    |
        | type    |

    Scenario: Kullanıcı Profile Photos sütun bilgilerini doğrular
      Given Kullanıcı "profile_photos" tablosundan "63" id'den bilgileri alir
      Then Kullanıcıdan gelen bilgiler doğrulanir
        | id    | data              | name               | type       |
        | 63    | 2081312           | cropped-image.jpg  | image/jpeg |