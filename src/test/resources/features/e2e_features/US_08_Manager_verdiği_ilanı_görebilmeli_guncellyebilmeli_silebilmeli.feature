@US08

Feature: US08 Manager verdiği ilanı görebilmeli

Scenario: TC01 Manager, verdiği ilanları ve ilan bilgilerini görüntüleyebilmeli
  Given Siteye Manager olarak giriş yapılır
  When  Back To Site butonuna tıklanır

  And Profile butonuna tıklanır
  And My Adverts butonuna tıklanır
  Then Verilen ilanların listelendiği görülür
  And Her ilanda Date Published, Status ve View-Like-Tour bilgileri doğrulanır
  And Sayfa kapatılır
