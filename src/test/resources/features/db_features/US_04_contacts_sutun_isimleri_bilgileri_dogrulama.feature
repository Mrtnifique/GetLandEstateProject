@DBUS04
  Feature: Contacts sutun isimleri ve bilgileri dogrulama

    @US04ERVA1
    Scenario: Contacts sutun isimleri dogrulama
      Given Kullanıcı "contacts" sekmesinden sütun isimlerini çeker
      Then Kullanıcı gelen isimleri doğrular
      | id         |
      | created_at |
      | email      |
      | first_name |
      | last_name  |
      | message    |
      | status     |

    @US04ERVA2
    Scenario: Contacts sutun bilgileri dogrulanir
      Given Kullanıcı "contacts" sekmesinden "2675" id'den bilgileri çeker
      Then Kullanıcı gelen bilgileri doğrular
        | id   | created_at                 | email            | first_name | last_name | message      | status |
        | 2675 | 2025-03-28 15:16:25.281986 | ftmsmz@gmail.com | Fatma      | yasar     |merhaba hayat | true   |