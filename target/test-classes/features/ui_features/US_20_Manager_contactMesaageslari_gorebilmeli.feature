@US20
Feature: Manager İletileri Görüntüleme
  Manager, iletisimini kontrol edebilmelidir.
@TC01
  Scenario: Yönetici ileti mesajlarını görüntüleyebilmeli
    When sitesiye git
    And Mail Us butonuna tıkla
    And Kutuları doldur
    And Send butonuna tıkla
    And Manager girisi yapar
    When ContactMessages butonuna tıkla
    And Messajlarda arama yap
    Then Manager ContactMessages görebildiğini doğrula
  And Siteye "test" username "test" password ile giriş yapılır
