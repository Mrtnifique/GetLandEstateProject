@US11
Feature: US11 Customer satılık ilan arayabilmeli

  Scenario: TC01 Customer satılık ilan arayabilmeli
    Given Siteye customer olarak giriş yapılır
    And Anasayfa Sale Butonuna Tikla
    When Search butonuna tıklanır
    Then Sale ilan kontrol edilir

  Scenario: TC02 Customer Mülkler kısmından satılık ilan arayabilmeli
    Given Siteye customer olarak giriş yapılır
    And Anasayfa Properties butonuna tikla
    And Advert Type butonuna tikla ve Sale sec
    When Filter Search Arama Butonuna Tikla
    Then Sale ilan kontrol edilir