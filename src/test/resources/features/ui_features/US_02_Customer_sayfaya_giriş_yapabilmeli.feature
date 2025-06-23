@US02
Feature: US02 Customer sayfaya giriş etmeli

  Scenario: TC01 (Positive test)
    Given Web seyfesine get
    When Register seyfesine daxil olmali
    Then Ad, Soyad ve telefon nomresi yazmali
    Then Dogru email yazmali
    Then Dogru password yazmali
    And  Register olmali
    And Customer olaraq qeyd olmali
    And Sayfa kapatılır


  Scenario: TC02 (Negative test)
    Given Web seyfesine get
    When Register seyfesine daxil olmali
    Then Ad, Soyad ve telefon nomresi xetali yazmali
    Then Fake email yazmali
    Then Fake password yazmali
    And Register olmamali
    And Customer olaraq qeyd olmamali
    And Sayfa kapatılır

