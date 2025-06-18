@US20
Feature: Yönetici İletileri Görüntüleme
  Yönetici, iletişimini kontrol edebilmelidir.
  Background:
    Given Web sitesine erişim sağlanabilmeli

  Scenario: Yönetici ileti mesajlarını görüntüleyebilmeli
    When "Mail Us" butonuna tıkla
    And Kutuları doldur "fatih US20", "Testcase01", "fustunyer@ggmail.com", "hello world"
    And "Send" butonuna tıkla
    And Admin girişi yapılır
    When ContactMessages butonuna tıkla
    And Mesajlardan birincisine tıkla
    Then Mesajın mail adresini ve tarihini al
    And Mesajı text olarak al
    Then Adminin ContactMessages görebildiğini doğrula
    And mesajımızdaki test datalarıyla aynı olmalı
