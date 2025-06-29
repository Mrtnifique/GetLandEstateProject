@US017
Feature: Manager Rapor Yönetimi

  Background:
    Given Manager olarak giriş yapılmış olmalı

  @US_17 @TC_01
  Scenario: Manager İlanların Raporunu Oluşturabilmeli - Pozitif Senaryo
    Given Manager olarak giriş yapılmış olmalı
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

  @US_17 @TC_02
  Scenario: Manager Popüler İlanların Raporunu Oluşturabilmeli - Pozitif Senaryo
    Given Manager olarak giriş yapılmış olmalı
    When "Most Popular Properties" bölümünde Amount değeri "5" olarak girilir
    And Excel export butonuna tıklanır
    Then Popüler ilanlar raporu başarıyla indirilir

  @US_17 @TC_03
  Scenario: Manager Kullanıcı Bilgilerine Göre Rapor Oluşturabilmeli - Pozitif Senaryo
    Given Manager olarak giriş yapılmış olmalı
    When "Users" bölümünde Role alanından "Manager" seçilir
    And Excel export butonuna tıklanır
    Then Manager rolündeki kullanıcıların raporu başarıyla indirilir

  @US_17 @TC_04
  Scenario: Manager Tur İsteklerine Göre Rapor Oluşturabilmeli - Pozitif Senaryo
    Given Manager olarak giriş yapılmış olmalı
    When "Tour Requests" bölümünde aşağıdaki filtreler doldurulur:
      | startDate | 01.01.2024 |
      | endDate   | 31.05.2025 |
      | status    | All        |
    And Excel export butonuna tıklanır
    Then Tur istekleri raporu başarıyla indirilir