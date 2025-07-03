@ContactMessagese2e
Feature: Contact Messages e2e

  #UI
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

  #DB
  Scenario: Contacts sutun bilgileri dogrulanir
    Given Kullanıcı "contacts" sekmesinden "2809" id'den bilgileri çeker
    Then Kullanıcı gelen bilgileri doğrular
      | id   | created_at                | email           | first_name | last_name | message                         | status |
      | 2809 | 2025-06-18 12:48:53.69481 | abcali@test.com | Ali        | Yılmaz    | Merhaba, bu bir test mesajıdır. | false  |

  #API
  @ApiAdmin
  Scenario: Contact Controller Get Testi
    Given Contact Controller Get icin URL düzenlenir
    When Get Request gönderilir ve Respond alınır
    Then Status Code 200 olduğu doğrulanır