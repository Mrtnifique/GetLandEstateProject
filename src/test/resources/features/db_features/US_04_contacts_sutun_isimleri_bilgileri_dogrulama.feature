@DBUS04
  Feature: Contacts sutun isimleri ve bilgileri dogrulama

    @US04ERVA1
    Scenario: Contacts sutun isimleri dogrulama
      Given Kullanıcı veritabanına bağlanır
      When Contacts tablosuna erisim saglanir
      Then Headerların id, created_at, email, first_name, last_name, message, status oldugu dogrulanir

    @US04ERVA2
    Scenario: Contacts sutun bilgileri dogrulanir
      Given Kullanıcı veritabanına bağlanır
      When Contacts tablosuna erisim saglanir
      And 100 numarali satir sorgulanir
      And Id degeri 2675 olmalidir
      And Emaili ftmsmz@gmail.com olmalidir
      Then Message kutusunda merhaba hayat yazmalidir