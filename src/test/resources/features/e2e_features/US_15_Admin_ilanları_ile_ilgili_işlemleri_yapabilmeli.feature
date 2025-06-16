@US015
Feature: US015 Admin rapor oluşturabilmeli

  Scenario: TC01 Admin, kategori (categories) ekleyebilmeli
    Given Siteye admin olarak giriş yapılır
    When Categories butonuna tıklanır
    And Yeni kategori eklenir
    Then Kategorinin eklenmiş olması test edilir
    And Sayfa kapatılır

  Scenario: TC02 Admin, ilan Türü (Advert Types) ekleyebilmeli
    Given Siteye admin olarak giriş yapılır
    When Advert types butonuna tıklanır
    And Yeni advert type eklenir
    Then Advert type eklenmiş olması test edilir
    And Sayfa kapatılır

  Scenario: TC03 Admin, kullanıcı arayabilmeli, güncelleme yapabilmeli ve kullanıcıya farklı roller atayabilmeli
    Given Siteye admin olarak giriş yapılır
    When Users butonuna tıklanır
    Then Kullanıcı aratılabilirliği test edilir
    And Kullanıcı rolü ve bilgileri güncellenir
    Then Kullanıcı bilgilerinin güncellenebilirliği test edilir
    And Sayfa kapatılır

  Scenario: TC04 Admin, Kategoriler (Categories) sekmesinde kategori güncelleyebilmeli
    Given Siteye admin olarak giriş yapılır
    When Categories butonuna tıklanır
    And Kategori verileri güncellenir
    Then Kategori verilerinin güncellenmesi test edilir
    And Sayfa kapatılır

  Scenario: TC05 Admin olarak tour requestler görülebilir olmalı
    Given Siteye admin olarak giriş yapılır
    When Tour requests butonuna tıklanır
    Then Tour request görünebilirliği test edilir
    And Sayfa kapatılır

  Scenario: TC06 Admin, icon bilgisi girmeden kategori (categories) ekleyememeli
    Given Siteye admin olarak giriş yapılır
    When Categories butonuna tıklanır
    And Icon bilgisi girilmeden kategori eklenmeye çalışılır
    Then Kategorinin eklenmemiş olması test edilir
    And Sayfa kapatılır

  Scenario: TC07 Admin, title girmeden advert type ekleyememeli
    Given Siteye admin olarak giriş yapılır
    When Advert types butonuna tıklanır
    And Title bilgisi girilmeden advert eklenmeye çalışılır
    Then Advertin eklenmemiş olması test edilir
    And Sayfa kapatılır


