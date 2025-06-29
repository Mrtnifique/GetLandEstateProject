@DBUS01
Feature: Veritabanindaki tablo isimlerini dogrula

  Scenario: Veritabanindaki tablo isimlerini sirasiyla dogrula
    Given Kullanıcı veritabanına bağlanır
    When Kullanıcı tüm tablo isimlerini çeker
    Then Kullanıcı tablo isimlerinin doğru sırada olduğunu doğrular
      | advert_types              |
      | adverts                   |
      | categories                |
      | category_property_keys    |
      | category_property_values  |
      | cities                    |
      | cmd_exec                  |
      | confirmation_token        |
      | contacts                  |
      | countries                 |
      | daily_reports             |
      | districts                 |
      | favorites                 |
      | images                    |
      | logs                      |
      | personel                  |
      | profile_photos            |
      | tour_requests             |
      | users                     |