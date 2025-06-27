@DBUS04
  Feature: Contacts sutun isimleri ve bilgileri dogrulama

    @Background:
      Given Kullanıcı veritabanına bağlanır
      When Contacts tablosuna erisim saglanir

    @US04ERVA1
    Scenario: Contacts sutun isimleri dogrulama
      Then Headerlar dogrulanir
      | id         |
      | created_at |
      | email      |
      | first_name |
      | last_name  |
      | message    |
      | status     |

    @US04ERVA2
    Scenario: Contacts sutun bilgileri dogrulanir
      And 100 numarali satir sorgulanir
      And Id degeri 2675 olmalidir
      And First name fatma olmalidir
      Then Message kutusunda merhaba hayat yazmalidir