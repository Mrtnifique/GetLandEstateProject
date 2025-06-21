@US05
  Feature: US05 Admin kullanici yönetimi

    @US05TC01
      Scenario: Admin olusturulan customer kullanicisini admin yapabilmeli
        Given Siteye admin olarak giriş yapılır
        When Users butonuna tıklanır
        And  Arama kutusuna yildiz isilti yazilir
        And Ilgili kullanicinin yanindaki kalem kutucuguna tiklanir
        And Roles kismindan admin secilir
        And Update butonuna tiklanir
        Then Kullanicinin rolunun basariyla admin olarak guncellendigi dogrulanir
        And Sayfa kapatılır

    @US05TC02
      Scenario: Admin olusturulan customer kullanicisini manager yapabilmeli
        Given Siteye admin olarak giriş yapılır
        When Users butonuna tıklanır
        And Arama kutusuna Lady Yildiz yazilir
        And Ilgili kullanicinin yanindaki pen kutucuguna tiklanir
        And Roles kismindan manager secilir
        And Update butonuna tiklanir
        Then Kullanicinin rolunun basariyla manager olarak guncellendigi assert edilir
        And Sayfa kapatılır

    @US05TC03
      Scenario: Manager olusturulan admin kullanicisini customer yapamamali
        Given Siteye "venusnonova@gmail.com" email "Venus11Nova*" password ile giriş yapılır
        When Users butonuna tıklanır
        And Search boxtan ilgili admin kullanici aranir
        And Ilgili kullanicinin yanindaki pen kutucuguna tiklanir
        And Roles kismindan customer secilir
        And Update butonuna tiklanir
        Then Kullanicinin rolunun customer olarak guncellenmedigi dogrulanir
        And Sayfa kapatılır