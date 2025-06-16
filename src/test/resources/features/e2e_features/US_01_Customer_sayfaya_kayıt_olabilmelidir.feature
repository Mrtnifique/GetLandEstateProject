@US01
Feature: US01 Kullanıcı kayıt formundaki doğrulamalar

  Scenario: TC01 First Name alanı boş bırakıldığında uyarı verilmesi
    Given Kullanıcı "https://www.getlandestate.com/" sitesine erişir
    When Kayıt sayfasına gider
    And Kullanici bilgileri girilir
    Then First Name alanı için uyarı mesajı görüntülenir

  Scenario: TC02 Last Name alanı boş bırakıldığında uyarı verilmesi
    Given Kullanıcı "https://www.getlandestate.com/" sitesine erişir
    When Kayıt sayfasına gider
    And Kullanici bilgileri girilir
    Then Last Name alanı için uyarı mesajı görüntülenir

  Scenario: TC03 Phone Number alanı boş bırakıldığında uyarı verilmesi
    Given Kullanıcı "https://www.getlandestate.com/" sitesine erişir
    When Kayıt sayfasına gider
    And Kullanici bilgileri girilir
    Then Phone Number alanı için uyarı mesajı görüntülenir

  Scenario: TC04 Email alanı boş bırakıldığında uyarı verilmesi
    Given Kullanıcı "https://www.getlandestate.com/" sitesine erişir
    When Kayıt sayfasına gider
    And Kullanici bilgileri girilir
    Then Email alanı için uyarı mesajı görüntülenir

  Scenario: TC05 Geçersiz Email formatı girildiğinde uyarı verilmesi
    Given Kullanıcı "https://www.getlandestate.com/" sitesine erişir
    When Kayıt sayfasına gider
    And Kullanici bilgileri girilir
    Then Email formatı için uyarı mesajı görüntülenir

  Scenario: TC06 Password alanı boş bırakıldığında uyarı verilmesi
    Given Kullanıcı "https://www.getlandestate.com/" sitesine erişir
    When Kayıt sayfasına gider
    And Kullanici bilgileri girilir
    Then Password alanı için uyarı mesajı görüntülenir

  Scenario: TC07 Zayıf şifre girildiğinde uyarı verilmesi
    Given Kullanıcı "https://www.getlandestate.com/" sitesine erişir
    When Kayıt sayfasına gider
    And Kullanici bilgileri girilir
    Then Zayıf şifre için uyarı mesajı görüntülenir

  Scenario: TC08 Confirm Password alanı boş bırakıldığında uyarı verilmesi
    Given Kullanıcı "https://www.getlandestate.com/" sitesine erişir
    When Kayıt sayfasına gider
    And Kullanici bilgileri girilir
    Then Confirm Password alanı için uyarı mesajı görüntülenir

  Scenario: TC09 Checkbox işaretlenmeden Register tıklanamaz
    Given Kullanıcı "https://www.getlandestate.com/" sitesine erişir
    When Kayıt sayfasına gider
    And Kullanici bilgileri girilir
    Then Checkbox işaretlenmeden kayıt olma işlemi başarısız olur

  Scenario: TC10 Tüm bilgiler doğru girildiğinde başarılı kayıt işlemi
    Given Kullanıcı "https://www.getlandestate.com/" sitesine erişir
    When Kayıt sayfasına gider
    And Kullanici bilgileri girilir
    Then Başarılı kayıt işlemi gerçekleşir
