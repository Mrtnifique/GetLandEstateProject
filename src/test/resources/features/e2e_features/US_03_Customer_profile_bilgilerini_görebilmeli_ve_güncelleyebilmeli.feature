@US03
Feature: US03 Customer profile bilgilerini görebilmeli ve güncelleyebilmeli

  Background:
    Given Siteye customer olarak giriş yapılır
    And MY PROFILE sayfasına tıklanır

  @TC01
  Scenario: TC01 Customer, profile bilgilerini görebilmeli ve güncelleyebilmeli
    Then Profile sayfası açılır
    And Profil bilgileri doğru görüntülenir

    When Profil bilgileri güncellenir
    And UPDATE butonuna tıklanır
    Then Güncelleme başarı mesajı görüntülenir

    When Change Password sekmesi açılır
    And Şifre değiştirme formu doldurulur
    And CHANGE butonuna tıklanır
    Then Şifre değiştirme başarı mesajı görüntülenir
    And Password strength STRONG olarak görüntülenir

    When Profile Photo sekmesi açılır
    And Fotoğraf seçilir ve yüklenir
    Then Fotoğraf başarıyla güncellenir

    When Delete Account sekmesi açılır
    Then Uyarı mesajı görüntülenir
    And Form validasyonu çalışır

  @TC02 @Negative
  Scenario: TC02 Geçersiz Bilgilerle Profil Güncelleme
    When Firstname ve Lastname alanını tamamen sil
    And Email alanına geçersiz format gir
    And Telefon alanına geçersiz format gir
    And UPDATE butonuna tıklanır
    Then Ad alanı boş bırakılamaz hata mesajı gösterilir
    And Geçerli email adres giriniz hata mesajı gösterilir
    And Telefon numarası geçersiz format hata mesajı gösterilir
    And Profil bilgileri güncellenmez