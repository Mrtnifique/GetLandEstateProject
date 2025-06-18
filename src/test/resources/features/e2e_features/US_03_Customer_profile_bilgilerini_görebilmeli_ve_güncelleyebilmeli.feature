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
    #Then Güncelleme başarı mesajı görüntülenir

    When Profile Photo sekmesi açılır
    And Fotoğraf seçilir ve yüklenir
   # Then Fotoğraf başarıyla güncellenir

    When Change Password sekmesi açılır
    And Şifre değiştirme formu doldurulur
    And CHANGE butonuna tıklanır
    #Then Şifre değiştirme başarı mesajı görüntülenir
    And Password strength STRONG olarak görüntülenir




  @TC02 @Negative
  Scenario: TC02 Geçersiz bilgilerle profil güncelleme
    When Ad, soyad silinir; geçersiz email ve telefon girilir
    And UPDATE butonuna tekrar tıklanır
    Then Zorunlu alan ve format uyarı mesajları gösterilir
    And Profil güncelleme işlemi başarısız olur



  @TC03 @Negative
  Scenario: TC03 Geçersiz şifre ile değiştirme
    When Şifre değiştirme sekmesi açılır
    And Yanlış mevcut şifre ve zayıf yeni şifre girilir, tekrar şifre boş bırakılır
    And Şifre gücü durumu kontrol edilir
    And CHANGE butonuna basılır
    Then Şifre gücü NONE veya WEAK görünür
    And Şifreler eşleşmiyor uyarısı çıkar
    And Şifre değişimi başarısız olur


  @TC04 @Negative
  Scenario: TC04 Geçersiz dosya ile profil resmi eklenemez
    When Geçersiz boyutta profil fotoğrafı yüklenmeye çalışılır
    Then Yükleme reddedilir ve hata mesajı gösterilir
