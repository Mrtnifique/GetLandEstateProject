@US09



Feature: US09 Admin girilen ilanları aktif edebilmeli ,reddedebilmeli ,güncelleyebilmelidir

  Background:
    Given Siteye admin olarak giriş yapılır
    Given kullanıcı ilanlar sayfasındadır






  @US09@TC01
  Scenario: İlanlar aktive edilebilmelidir
    When Aratma kutusuna Seferihisar yazıp aratılır
    And Sayfada görüntülenen ilanın işlem menüsünden güncelleme butonuna basılır
    Then ilanın durum ddm den aktif seçeneği seçilir ve güncellenir
    And  Aratma kutusuna Seferihisar yazıp aratılır
    Then İlanın aktif olduğu doğrulanır
    And Sayfa kapatılır



  @US09@TC02
  Scenario: İlanlar güncellenebilmeli
    When Aratma kutusuna Bungalow yazıp aratılır
    And  Sayfada görüntülenen ilanın işlem menüsünden güncelleme butonuna basılır
    When İşlem başarılı şekilde güncellendi mesajı doğrulanır
    And  Sayfa kapatılır



  @US09@TC03
  Scenario: İlanlar reddedilebilmelidir
    When  Aratma kutusuna Seferihisar yazıp aratılır
    And   Sayfada görüntülenen ilanın işlem menüsünden güncelleme butonuna basılır
    Then ilanın durum ddm den Reddedildi seçeneği seçilir ve güncellenir
    And  Aratma kutusuna Seferihisar yazıp aratılır
    Then İlanın Reddedildi olduğu doğrulanır
    And Sayfa kapatılır

