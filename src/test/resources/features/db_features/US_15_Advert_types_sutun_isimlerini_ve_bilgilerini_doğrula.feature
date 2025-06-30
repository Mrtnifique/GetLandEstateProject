@DBUS15
Feature: Kullanicin Advert_types sutun isimlerini ve bilgilerini doğrula

  Scenario: Kullanicin Advert_types sutun isimlerini dogrular
    Given Kullanıcın database-e bağlanır
    When Kullanicin "advert_types" sekmesinden bilgilerini ceker

      | id       |
      | built_in |
      | title    |

  Scenario: Kullanici Advert_types sutun bilgilerini dogrular
    Given Kullanıcın database-e bağlanır
    When Kullanicin "advert_types" sekmesinden "319" id'den bilgilerini ceker
    Then Kullanicin gelen bilgileri dogrular

      | id  | built_in | title  |
      | 300 | false    | Kaleem |