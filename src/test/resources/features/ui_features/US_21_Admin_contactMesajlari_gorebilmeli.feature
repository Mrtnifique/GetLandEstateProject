@US21
Feature: Admin İletileri Görüntüleme
  Admin iletisimini kontrol edebilmelidir.
  @TC01_Pozitif
  Scenario: Admin ileti mesajlarını görüntüleyebilmeli
    When sitesiye git
    And Mail Us butonuna tıkla
    And Kutuları doldur
    And Send butonuna tıkla
    And Admin girisi yapar
    When ContactMessages butonuna tıkla
    And Messajlarda arama yap
    Then Manager ContactMessages görebildiğini doğrula


