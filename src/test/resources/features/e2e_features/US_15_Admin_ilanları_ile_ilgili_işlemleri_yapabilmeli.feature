@US015
Feature: US015 Admin rapor oluşturabilmeli

  Scenario: TC01 Admin, kategori (categories) ekleyebilmeli
    Given Siteye admin olarak giriş yapılır
    When Categories butonuna tıklanır
    And Yeni kategori eklenir
    Then Kategorinin eklenmiş olması test edilir
    And Sayfa kapatılır


