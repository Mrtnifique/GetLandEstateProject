@DBUS15
Feature: Kullanicin Advert_types sutun isimlerini ve bilgilerini doğrula

  Scenario: Kullanicin Advert_types sutun isimlerini dogrular
    Given Kullanıcın database-e bağlanır
    When Kullanicin "advert_types" sekmesinden bilgilerini ceker

      | id         |
      | created_at |
      | updated_at |
      | is_active  |
      | built_in   |
      | icon       |
      | seq        |
      | slug       |
      | title      |

  Scenario: Kullanici Advert_types sutun bilgilerini dogrular
  Given Kullanıcın database-e bağlanır
  When Kullanicin "advert_types" sekmesinden "300" id'den bilgilerini ceker
  Then Kullanicin gelen bilgileri dogrular

    | id  | is_active |  icon       | seq | title      |
    | 300 | true      |  headphones | 12  | denemedort |

