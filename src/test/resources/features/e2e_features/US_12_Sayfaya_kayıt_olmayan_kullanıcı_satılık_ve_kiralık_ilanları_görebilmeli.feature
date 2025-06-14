@US_12
Feature: US012 Sayfaya kayıt olmayan kullanıcı satılık ve kiralık ilanları görebilmeli

  Scenario: TC01 Kullanıcı (Sayfaya Kayıt olmayan) satılık ve kiralık ilan arayabilmeli
    Given Web adresine gidilir
    When Search butonuna tıklanır
    And Filtreleme yapılarak arama yapılır
    Then Aranan ilanın listelenmesi test edilir
    Then İletisim bilgilerine tıklayarak uyarı mesajı alınır
    And Tarih ve saat girilerek randevu olusturulur
    Then Randevu icin uyarı mesajı görünürlüğü test edilir
    And Create one now butonuna tıklanır
    Then Register sayfasına gidildiği test edilir
    And Sayfa kapatılır

  Scenario: TC02 Admin, ilan Türü (Advert Types) ekleyebilmeli
    Given Web adresine gidilir
    When Login butonuna tıklanır
    And Username
    And Yeni advert type eklenir
    Then Advert type eklenmiş olması test edilir
    And Sayfa kapatılır
