@US01
Feature: US01 Kullanıcı kayıt formundaki doğrulamalar

  Background:
    Given Kullanıcı "https://www.getlandestate.com/" sitesine erişir
    When Kayıt sayfasına gider

  Scenario: TC01 First Name alanı boş bırakıldığında uyarı verilmesi
    And Kullanici bilgilerini girer: "", "Yılmaz", "05001112233", "mail@example.com", "StrongPass123?", "StrongPass123?", true
    And Register butonuna tıklar
    Then First Name alanı için uyarı mesajı görüntülenir

  Scenario: TC02 Last Name alanı boş bırakıldığında uyarı verilmesi
    And Kullanici bilgilerini girer: "Ali", "", "05001112233", "mail@example.com", "StrongPass123?", "StrongPass123?", true
    And Register butonuna tıklar
    Then Last Name alanı için uyarı mesajı görüntülenir

  Scenario: TC03 Phone Number boş bırakıldığında uyarı verilmesi
    And Kullanici bilgilerini girer: "Ali", "Yılmaz", "", "mail@example.com", "StrongPass123?", "StrongPass123?", true
    And Register butonuna tıklar
    Then Phone Number alanı için uyarı mesajı görüntülenir

  Scenario: TC04 Email boş bırakıldığında uyarı verilmesi
    And Kullanici bilgilerini girer: "Ali", "Yılmaz", "05001112233", "", "StrongPass123?", "StrongPass123?", true
    And Register butonuna tıklar
    Then Email alanı için uyarı mesajı görüntülenir

  Scenario: TC05 Geçersiz Email formatı girildiğinde uyarı verilmesi
    And Kullanici bilgilerini girer: "Ali", "Yılmaz", "05001112233", "abc", "StrongPass123?", "StrongPass123?", true
    And Register butonuna tıklar
    Then Email alanı için uyarı mesajı görüntülenir

  Scenario: TC06 Password alanı boş bırakıldığında uyarı verilmesi
    And Kullanici bilgilerini girer: "Ali", "Yılmaz", "05001112233", "mail@example.com", "", "StrongPass123?", true
    And Register butonuna tıklar
    Then Password alanı için uyarı mesajı görüntülenir

  Scenario: TC07 Zayıf şifre girildiğinde uyarı verilmesi
    And Kullanici bilgilerini girer: "Ali", "Yılmaz", "05001112233", "mail@example.com", "123", "123", true
    And Register butonuna tıklar
    Then Zayıf şifre için uyarı mesajı görüntülenir

  Scenario: TC08 Confirm Password alanı boş bırakıldığında uyarı verilmesi
    And Kullanici bilgilerini girer: "Ali", "Yılmaz", "05001112233", "mail@example.com", "StrongPass123?", "", true
    And Register butonuna tıklar
    Then Confirm Password alanı için uyarı mesajı görüntülenir

  Scenario: TC09 Checkbox işaretlenmeden Register tıklanamaz
    And Kullanici bilgilerini girer: "Ali", "Yılmaz", "05001112233", "mail@example.com", "StrongPass123?", "StrongPass123?", false
    Then Checkbox işaretlenmeden kayıt olma işlemi başarısız olur

  Scenario: TC10 Tüm bilgiler doğru girildiğinde başarılı kayıt işlemi
    And Kullanici bilgilerini girer: "Ali", "Yılmaz", "05001112233", "mail@example.com", "StrongPass123?", "StrongPass123?", true
    And Register butonuna tıklar
    Then Başarılı kayıt işlemi gerçekleşir
