@US08

Feature: US08 Manager verdiği ilanı görebilmeli

  @TC01E
  Scenario: TC01 Manager, verdiği ilanları ve ilan bilgilerini görüntüleyebilmeli
    Given Siteye Manager olarak giriş yapılır
    When  Back To Site butonuna tıklanır
    And Profile butonuna tıklanır
    And My Adverts butonuna tıklanır
    Then Verilen ilanların listelendiği görülür
    And Sayfa kapatılır

    @TC02E
    Scenario: TC02 Manager verdiği ilanı güncelleyebilmeli
    Given Siteye Manager olarak giriş yapılır
    When Back To Site butonuna tıklanır
    And  Profile butonuna tıklanır
    And My Adverts butonuna tıklanır
    Then Edit Advert butonuna tıklanır
    And Fiyat 950000 yapılır
    And Update butonuna tıklanır
    Then Başarı mesajı gorulur
    And Sayfa kapatılır

    @TC03ENegative
    Scenario: Manager negatif fiyat girdiğinde uyarı mesajı gorulmeli ve fiyat güncellenmemeli
      Given Siteye Manager olarak giriş yapılır
      When Back To Site butonuna tıklanır
      And Profile butonuna tıklanır
      And My Adverts butonuna tıklanır
      Then Edit Advert butonuna tıklanır
      And Fiyat alanına -900000 yazılır
      And Uyarı mesajı gorulur
      And Sayfa kapatılır