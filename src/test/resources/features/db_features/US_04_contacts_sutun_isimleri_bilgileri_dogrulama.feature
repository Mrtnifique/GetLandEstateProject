@DBUS04
  Feature: Contacts sutun isimleri ve bilgileri dogrulama

    @Background:
      Given Kullanıcı veritabanına bağlanır
        When Contacts tablosuna erisim saglanir

    @US04ERVA1
    Scenario: Contacts sutun isimleri dogrulama
      Then Headerların eksiksiz oldugu dogrulanir
      | id         |
      | created_at |
      | email      |
      | first_name |
      | last_name  |
      | message    |
      | status     |

    @US04ERVA2
    Scenario: Contacts sutun bilgileri dogrulama
      And 100 numarali satir sorgulanir
      And Id degeri 2676 olmalidir
      Then Message merhaba hayat olmalidir