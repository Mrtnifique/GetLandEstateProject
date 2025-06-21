@US19
Feature: US19 - Kullanıcı iletişim formundan mesaj gönderebilmeli

  Background:
    Given Web adresine gidilir

@positive19
  Scenario: Kullanıcı başarılı bir şekilde iletişim formu gönderir
    When Kullanıcı iletişim formuna tıklar
    And Kullanıcı First Name alanına "Ali" yazar
    And Kullanıcı Last Name alanına "Yılmaz" yazar
    And Kullanıcı geçersiz bir email adresi "abc" yazar
    Then Geçersiz email uyarısı görüntülenir
    When Kullanıcı geçerli bir email adresi "ali@test.com" yazar
    And Kullanıcı mesaj kutusuna "Merhaba, bu bir test mesajıdır." yazar
    And Kullanıcı gönder butonuna tıklar
    Then Mesaj başarıyla gönderildi uyarısı görüntülenir

@negative19
  Scenario:Hatalı bilgilerle form gönderilemez
    When Kullanıcı iletişim formuna tıklar
    And Kullanıcı First Name alanına "A" yazar
    And Kullanıcı Last Name alanına "" yazar
    And Kullanıcı email alanına "" yazar
    And Kullanıcı geçersiz bir email adresi "abc" yazar
    And Kullanıcı mesaj kutusunu boş bırakır
    Then First Name minimum 2 karakter uyarısı görüntülenir
    And Last Name minimum 2 karakter uyarısı görüntülenir
    And Email zorunlu alan uyarısı görüntülenir
    And Geçersiz email uyarısı görüntülenir
    And Mesaj gönderilemez
