@US015
Feature: US015 Admin rapor oluşturabilmeli

  Background:
    Given Siteye admin olarak giriş yapılır

  Scenario: TC01 | Admin, kategori (categories) ekleyebilmeli
    When Categories butonuna tıklanır
    And Yeni kategori eklenir
    Then Kategorinin eklenmiş olduğu doğrulanır
    And Sayfa kapatılır

  Scenario: TC02 | Admin, ilan Türü (Advert Types) ekleyebilmeli
    When Advert Types butonuna tıklanır
    And Yeni Advert Type eklenir
    Then Advert Type eklenmiş olması doğrulanır
    And Sayfa kapatılır

  Scenario: TC03 | Admin, kullanıcı arayabilmeli, güncelleme yapabilmeli ve kullanıcıya farklı roller atayabilmeli
    When Users butonuna tıklanır
    Then Kullanıcı aratılabilmesi doğrulanır
    And Kullanıcı rolü ve bilgileri güncellenir
    Then Kullanıcı bilgilerinin güncellendiği doğrulanır
    And Sayfa kapatılır

  Scenario: TC04 | Admin, Kategoriler (Categories) sekmesinde kategori güncelleyebilmeli
    When Categories butonuna tıklanır
    And Kategori verileri güncellenir
    Then Kategori verilerinin güncellenmiş olması doğrulanır
    And Sayfa kapatılır

  Scenario: TC05 | Admin olarak tour requestler görülebilir olmalı
    When Tour Requests butonuna tıklanır
    Then Tour Request görünebildiği doğrulanır
    And Sayfa kapatılır

  Scenario: TC06 | Admin, icon bilgisi girmeden kategori (categories) ekleyememeli
    When Categories butonuna tıklanır
    And Icon bilgisi girilmeden kategori eklenmeye çalışılır
    Then Kategorinin eklenemiyor olması doğrulanır
    And Sayfa kapatılır

  Scenario: TC07 | Admin, title girmeden advert type ekleyememeli
    When Advert Types butonuna tıklanır
    And Title bilgisi girilmeden advert eklenmeye çalışılır
    Then Advertin eklenemiyor olması doğrulanır
    And Sayfa kapatılır


