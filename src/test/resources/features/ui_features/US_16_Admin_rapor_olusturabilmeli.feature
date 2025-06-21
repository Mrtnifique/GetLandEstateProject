@US016
Feature: Admin Rapor Yönetimi
  Background:
    Given Admin olarak giriş yapılmış olmalı

  @US_16 @TC_01
  Scenario: Admin İlanların Raporunu Oluşturabilmeli - Pozitif Senaryo
    Given Admin paneline giris yapilmistir
    When Sol menüden "Reports" sekmesine tıklanır
    Then Reports sayfası açılır
    And "Adverts" başlıklı rapor alanı görüntülenir
    When Aşağıdaki filtre bilgileri girilir:
      | startDate  | 01.01.2024 |
      | endDate    | 31.05.2025 |
      | category   | House      |
      | advertType | Sale       |
    And Excel export butonuna tıklanır
    Then Rapor başarıyla oluşturulur ve indirilir

  @US_16 @TC_02
  Scenario: Admin Popüler İlanların Raporunu Oluşturabilmeli - Pozitif Senaryo
    Given Admin paneline giriş yapılmıştır
    When "Most Popular Properties" bölümünde Amount değeri "5" olarak girilir
    And Excel export butonuna tıklanır
    Then Popüler ilanlar raporu başarıyla indirilir

  @US_16 @TC_03
  Scenario: Admin Kullanıcı Bilgilerine Göre Rapor Oluşturabilmeli - Pozitif Senaryo
    Given Admin paneline giriş yapılmıştır
    When "Users" bölümünde Role alanından "Admin" seçilir
    And Excel export butonuna tıklanır
    Then Admin rolündeki kullanıcıların raporu başarıyla indirilir

  @US_16 @TC_04
  Scenario: Admin Tur İsteklerine Göre Rapor Oluşturabilmeli - Pozitif Senaryo
    Given Admin paneline giriş yapılmıştır
    When "Tour Requests" bölümünde aşağıdaki filtreler doldurulur:
      | startDate | 01.01.2024 |
      | endDate   | 31.05.2025 |
      | status    | All        |
    And Excel export butonuna tıklanır
    Then Tur istekleri raporu başarıyla indirilir
