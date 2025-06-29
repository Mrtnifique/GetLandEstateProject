@US06
Feature: US06 Manager sayfada kiralık ilanı verebilmeli
  @TC061
  Scenario: TC01 Manager sayfada kiralık ilanı verebilmeli
    Given Web adresine gidilir
    When Manager olarak sayfaya giris yapılır
    And Ana sayfaya geri gidilir
    Then Create Property Sayfasına Gidilir
    Then Common Information, Address Information, Properties elementleri görülür
    And Description ve address bos birakildiginda uyari mesaji görülür
    Then Advert Type butonunda Rent seçilir
    Then Form doldurulur ve 3 MB'tan kucuk resim eklenir
    And Sayfa kapatılır

  Scenario: TC02 3 MB'tan buyuk gorsel eklendiginde sistem uyari vermeli ve yukleyememeli
    Given Web adresine gidilir
    Given Manager olarak sayfaya giris yapılır
    When Ana sayfaya geri gidilir
    Then Create Property Sayfasına Gidilir
    And 3 MB tan daha buyuk resim yuklenir
    Then Each image should be a maximum of 3 MB uyarı mesajinin geldiği dogrulanir
    And Sayfa kapatılır
