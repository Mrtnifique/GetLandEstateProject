@US014

Feature: US_14 - Manager kendine ait olmayan bir ilan için randevu talebi oluşturabilmeli ve durumunu takip edebilmeli

  Background:
    Given siteye manager olarak giriş yapılır
    When Control Panel sekmesindeki siteye geri dön tiklanir
    When Dashboard'a tıklar


  Scenario: TC01 - Manager, başka bir manager’a ait ilan için randevu talebi oluşturur ve durumunu takip eder

    When Başka bir manager’a ait aktif ilan aranır

    When Bir ilan seçilip detay sayfası açılır
    Then "Tur Ayarla" formu görünür

    When Geçerli bir tur tarihi ve saati girilerek form eksiksiz doldurulur
    And "Tur Talebi Gönder" butonuna tıklanır
    Then "Talebiniz gönderildi" mesajı görülür

    When "Tur Taleplerim" sekmesine tıklanır
    Then "Tur Talebi" beklemede olarak listelenir



  Scenario: TC02 - Manager kendi ilanı için tur talebi oluşturamamalı ve reddedilen randevu durumunu görebilmeli
    When "İlanlarım" sekmesine tıklanır
    Then Kendi ilanları listelenir

    When Kendi ilana ait detay sayfası açılır
    Then Detay sayfası goruntulenmeli

    Then "Randevu Al" butonu görünmemeli ya da devre dışı olmalıdır

    When URL üzerinden doğrudan randevu formu açılmaya çalışılır
    Then "İşlem yapılamaz" mesajı ya da başka bir sayfaya yönlendirme gerçekleşmelidir


