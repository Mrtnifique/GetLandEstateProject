@US012
Feature: US012 Sayfaya kayıt olmayan kullanıcı satılık ve kiralık ilanları görebilmeli


  @TC01T

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


  Scenario: TC02 Kullanıcı satılık ve kiralık ilanlar ile ilgili tur talebi için tarih ve saat boş bırakıldığında uyarı görülebilmeli
    Given Customer olarak sayfaya giris yapılır
    When Login butonuna tıklanır
    And Search butonuna tıklanır
    And Filtreleme yapılarak arama yapılır
    Then Aranan ilanın listelenmesi test edilir
    And Tarih ve saat boş bırakılarak submit butonuna tıklanır
    Then Randevu icin tarih ve saat girmeden uyarı mesajı görünürlüğü test edilir
    And Sayfa kapatılır
