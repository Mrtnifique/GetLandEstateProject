@US07
Feature: US07 Manager sayfada satılık ilanı verebilmeli

  Scenario: TC01 Manager sayfada satılık ilanı verebilmeli
    Given Web adresine gidilir
    When Manager olarak sayfaya giris yapılır
    And Ana sayfaya geri gidilir
    Then Create Property Sayfasına Gidilir
    And Description ve address bos birakildiginda uyari mesaji görülür
    Then Advert Type butonunda Sale seçilir
    Then Form doldurulur ve 3 MB'tan kucuk resim eklenir
    And Sayfa kapatılır

