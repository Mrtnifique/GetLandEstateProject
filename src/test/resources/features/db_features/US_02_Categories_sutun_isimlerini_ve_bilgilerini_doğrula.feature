@DBUS02
  Feature: Categories sutun isimlerini ve bilgilerini doğrula

    Scenario: Categories sutun isimlerini ve bilgilerini dogrula
      Given Kullanıcı veritabanına bağlanır
      When Kullanıcı Categories sutun isimlerini ve bilgilerini çeker
      Then Kullanıcı Categories sutun isimlerini ve bilgilerini dogrular