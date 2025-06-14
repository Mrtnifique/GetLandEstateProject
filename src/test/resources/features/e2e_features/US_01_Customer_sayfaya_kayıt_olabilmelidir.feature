@US01
Feature: US01 Kullanıcı kayıt formundaki doğrulamalar

  Scenario: TC01 First Name alanı boş bırakıldığında uyarı verilmesi
    Given Kullanıcı "https://www.getlandestate.com/" sitesine erişir
    When Kayıt sayfasına gider
    And First Name alanını boş bırakır
    And Last Name alanına geçerli bir değer girer
    And Phone Number alanına geçerli bir değer girer
    And Email alanına geçerli bir değer girer
    And Enter Password alanına geçerli bir değer girer
    And Confirm Password alanına geçerli bir değer girer
    And Kullanıcı, şartları kabul eder kutusunu işaretler
    And Register butonuna tıklar
    Then First Name alanı için uyarı mesajı görüntülenir

  Scenario: TC02 Last Name alanı boş bırakıldığında uyarı verilmesi
    Given Kullanıcı "https://www.getlandestate.com/" sitesine erişir
    When Kayıt sayfasına gider
    And First Name alanına geçerli bir değer girer
    And Last Name alanını boş bırakır
    And Phone Number alanına geçerli bir değer girer
    And Email alanına geçerli bir değer girer
    And Enter Password alanına geçerli bir değer girer
    And Confirm Password alanına geçerli bir değer girer
    And Kullanıcı, şartları kabul eder kutusunu işaretler
    And Register butonuna tıklar
    Then Last Name alanı için uyarı mesajı görüntülenir

  Scenario: TC03 Phone Number alanı boş bırakıldığında uyarı verilmesi
    Given Kullanıcı "https://www.getlandestate.com/" sitesine erişir
    When Kayıt sayfasına gider
    And First Name alanına geçerli bir değer girer
    And Last Name alanına geçerli bir değer girer
    And Phone Number alanını boş bırakır
    And Email alanına geçerli bir değer girer
    And Enter Password alanına geçerli bir değer girer
    And Confirm Password alanına geçerli bir değer girer
    And Kullanıcı, şartları kabul eder kutusunu işaretler
    And Register butonuna tıklar
    Then Phone Number alanı için uyarı mesajı görüntülenir

  Scenario: TC04 Email alanı boş bırakıldığında uyarı verilmesi
    Given Kullanıcı "https://www.getlandestate.com/" sitesine erişir
    When Kayıt sayfasına gider
    And First Name alanına geçerli bir değer girer
    And Last Name alanına geçerli bir değer girer
    And Phone Number alanına geçerli bir değer girer
    And Email alanını boş bırakır
    And Enter Password alanına geçerli bir değer girer
    And Confirm Password alanına geçerli bir değer girer
    And Kullanıcı, şartları kabul eder kutusunu işaretler
    And Register butonuna tıklar
    Then Email alanı için uyarı mesajı görüntülenir

  Scenario: TC05 Geçersiz Email formatı girildiğinde uyarı verilmesi
    Given Kullanıcı "https://www.getlandestate.com/" sitesine erişir
    When Kayıt sayfasına gider
    And First Name alanına geçerli bir değer girer
    And Last Name alanına geçerli bir değer girer
    And Phone Number alanına geçerli bir değer girer
    And Email alanına geçersiz bir değer girer
    And Enter Password alanına geçerli bir değer girer
    And Confirm Password alanına geçerli bir değer girer
    And Kullanıcı, şartları kabul eder kutusunu işaretler
    And Register butonuna tıklar
    Then Email formatı için uyarı mesajı görüntülenir

  Scenario: TC06 Password alanı boş bırakıldığında uyarı verilmesi
    Given Kullanıcı "https://www.getlandestate.com/" sitesine erişir
    When Kayıt sayfasına gider
    And First Name alanına geçerli bir değer girer
    And Last Name alanına geçerli bir değer girer
    And Phone Number alanına geçerli bir değer girer
    And Email alanına geçerli bir değer girer
    And Enter Password alanını boş bırakır
    And Confirm Password alanına geçerli bir değer girer
    And Kullanıcı, şartları kabul eder kutusunu işaretler
    And Register butonuna tıklar
    Then Password alanı için uyarı mesajı görüntülenir

  Scenario: TC07 Zayıf şifre girildiğinde uyarı verilmesi
    Given Kullanıcı "https://www.getlandestate.com/" sitesine erişir
    When Kayıt sayfasına gider
    And First Name alanına geçerli bir değer girer
    And Last Name alanını boş bırakır
    And Phone Number alanına geçerli bir değer girer
    And Email alanına geçerli bir değer girer
    And Enter Password alanına zayıf bir değer girer
    And Confirm Password alanına zayıf bir değer girer
    And Kullanıcı, şartları kabul eder kutusunu işaretler
    And Register butonuna tıklar
    Then Zayıf şifre için uyarı mesajı görüntülenir

  Scenario: TC08 Confirm Password alanı boş bırakıldığında uyarı verilmesi
    Given Kullanıcı "https://www.getlandestate.com/" sitesine erişir
    When Kayıt sayfasına gider
    And First Name alanına geçerli bir değer girer
    And Last Name alanına geçerli bir değer girer
    And Phone Number alanına geçerli bir değer girer
    And Email alanına geçerli bir değer girer
    And Enter Password alanına geçerli bir değer girer
    And Confirm Password alanını boş bırakır
    And Kullanıcı, şartları kabul eder kutusunu işaretler
    And Register butonuna tıklar
    Then Confirm Password alanı için uyarı mesajı görüntülenir

  Scenario: TC09 Checkbox işaretlenmeden Register tıklanamaz
    Given Kullanıcı "https://www.getlandestate.com/" sitesine erişir
    When Kayıt sayfasına gider
    And First Name alanına geçerli bir değer girer
    And Last Name alanına geçerli bir değer girer
    And Phone Number alanına geçerli bir değer girer
    And Email alanına geçerli bir değer girer
    And Enter Password alanına geçerli bir değer girer
    And Confirm Password alanına geçerli bir değer girer
    And Kullanıcı, şartları kabul etmez
    And Register butonuna tıklar
    Then Checkbox işaretlenmeden kayıt olma işlemi başarısız olur

  Scenario: TC10 Tüm bilgiler doğru girildiğinde başarılı kayıt işlemi
    Given Kullanıcı "https://www.getlandestate.com/" sitesine erişir
    When Kayıt sayfasına gider
    And First Name alanına geçerli bir değer girer
    And Last Name alanına geçerli bir değer girer
    And Phone Number alanına geçerli bir değer girer
    And Email alanına geçerli bir değer girer
    And Enter Password alanına geçerli bir değer girer
    And Confirm Password alanına aynı şifreyi girer
    And Kullanıcı, şartları kabul eder kutusunu işaretler
    And Register butonuna tıklar
    Then Başarılı kayıt işlemi gerçekleşir
