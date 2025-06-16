@US20
Feature: Yönetici Contact Mesajlari Görüntüleme
  Yönetici, iletişimini kontrol edebilmelidir.

  Background:
    Given Web sitesine erişim sağlanabilmeli

  Scenario: Yönetici ileti mesajlarını görüntüleyebilmeli
    When Web sitesine git "http://64.227.123.49/"
    And "Mail Us" butonuna tıkla
    And Kutuları doldur "fatih US20", "Testcase01", "fustunyer@ggmail.com", "hello world"
    And "Send" butonuna tıkla
    And Login butonuna tıkla
    Then Login sayfası açılmalı
    When Admin e-posta adresini gir "b307admin@gmail.com"
    And Admin şifresini gir "B307admin@"
    Then Admin girişi açılmalı
    When ContactMessages butonuna tıkla
    And Mesajlardan birincisine tıkla
    Then Mesajın mail adresini ve tarihini al
    And Mesajı text olarak al
    Then Adminin ContactMessages görebildiğini doğrula
    And mesajımızdaki test datalarıyla aynı olmalı
