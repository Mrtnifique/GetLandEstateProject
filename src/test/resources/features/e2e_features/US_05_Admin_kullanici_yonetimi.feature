@US05
  Feature: US05 Admin kullanici yönetimi

      Scenario: Admin olusturulan customer kullanicisini admin yapabilmeli
        Given Siteye admin olarak giriş yapılır
        When Users butonuna tiklanir
        And  Arama kutusuna yildiz isilti yazilir
        And Ilgili kullanicinin yanindaki kalem kutucuguna tiklanir
        And Roles kismindan admin secilir
        And Update butonuna basilir
        Then Kullanicinin rolunun basariyla admin olarak guncellendigi dogrulanir