@DBUS02
Feature: Categories sutun isimlerini ve bilgilerini dogrula

  Scenario: Categories sutun isimlerini dogrula
    Given Kullanici veri_tabanina baglanir
    When Kullanıcı categories tablosundan sütun isimlerini çeker
    Then Kullanıcı gelen isimlerin tamamini dogrular

      | id         |
      | created_at |
      | updated_at |
      | is_active  |
      | built_in   |
      | icon       |
      | seq        |
      | slug       |
      | title      |

  Scenario: Categories satir isimlerini ve bilgilerini dogrula
    Given Kullanıcı "categories" tablosundan "312" nolu id'den bilgileri çeker
    Then Kullanıcı categories tablosundan gelen bilgiler doğrulanır

      | id  | created_at                 | updated_at                 | icon  | seq | slug                         | title          |
      | 312 | 2025-03-16 06:54:39.784368 | 2025-06-17 17:05:02.316011 | house | 1   | 1750179902286-housetinyhouse | HouseTinyHouse |