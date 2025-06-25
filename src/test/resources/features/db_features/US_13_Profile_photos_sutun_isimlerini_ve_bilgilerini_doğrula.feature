@US13
  Feature: Profile Photos sütun isimlerini ve bilgilerini doğrula

    Scenario: Profile Photos sütun isimlerini dogrula
      Given Kullanıcı "profile_photos" sekmesinden sütun isimlerini çeker
      Then Kullanıcı gelen isimleri dogrular
        | id      |
        | data    |
        | name    |
        | type    |