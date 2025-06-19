@US09
Feature: US09 Admin ilanlarla ilgili islemleri yapar
Background:

  Given Siteye admin olarak giriş yapılır
  When Profilime  tiklar
  Then Ilanlarima tiklar

  Scenario: TC01 Admin ilanlari guncelleyebilmeli

    And Kayitli ilanlarim'da duzenleme islemi yapar
    Then Guncelleme basarili  yazisini goruntuler.

    Scenario: TC02 Admin ilanlari silebilmeli

      And Ilanlarimda silme islemi yapar
      And Silme isleminin basariyla gerceklestigi mesajini goruntuler .

      Scenario: TC03 Admin ilanlari aktive edebilmeli

        Then Ilanlarin goruntulendigi sayfada guncelleye tiklar
        When Pasif butonu aktive eder
        And Guncelle butonuna tiklar
        Then Guncelleme basarili mesajini goruntuler
        When Guncellenen sayfada butonun aktif oldugu goruntulenir

        Scenario: TC04 Admin ilanlar ile ilgili arama islemleri yapabilmeli

          And Arama yapar

       Scenario:TC05 Ilanlarim sayfasinda arama ozelligi eksik(negatif test)
         And Arama butonu bulunmamalidir