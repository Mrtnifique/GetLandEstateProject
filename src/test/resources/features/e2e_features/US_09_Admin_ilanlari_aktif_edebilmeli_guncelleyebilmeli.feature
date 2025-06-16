@US09
Feature: US09 Admin ilanlarla ilgili islemleri yapar
Background:
  Given Kullanici "admin" olarak giris yapar
  When "Profilim"e tiklar
  Then "Ilanlarim" a tiklar

  Scenario: TC01 Admin ilanlari guncelleyebilmeli

    And Kayitli ilanlarim'da duzenleme islemi yapar
    Then 'Guncelleme basarili ' yazisini goruntuler.

    Scenario: TC02 Admin ilanlari silebilmeli

      Then Ilanlarimda silme islemi yapar
      And Silme isleminin basariyla gerceklestigi mesajini goruntuler .

      Scenario: TC03 Admin ilanlari aktive edebilmeli

        Then Ilanlarin goruntulendigi sayfada guncelleye tiklar
        When Pasif butonu aktive eder
        And Guncelle butonuna tiklar
        Then Guncelleme basarili mesajini goruntuler
        When Guncellenen sayfada butonun aktif oldugu goruntulenir

        Scenario: TC04 Admin ilanlar ile ilgili arama islemleri yapabilmeli

          And Arama yapar
