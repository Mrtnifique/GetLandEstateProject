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
    And Mesajlardan birincisine tıkla
    Then Mesajın mail adresini ve tarihini al
    And Mesajı text olarak al
    Then Manager ContactMessages görebildiğini doğrula
    And mesajımızdaki test datalarıyla aynı olmalı
