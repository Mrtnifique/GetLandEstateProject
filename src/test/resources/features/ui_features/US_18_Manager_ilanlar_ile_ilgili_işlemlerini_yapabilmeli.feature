@US18
  Feature: Manager ilanlar ile ilgili işlemleri yapabilmeli

    Background:
      Given Web adresine gidilir
      When Manager hesabı ile sisteme giriş yapılır18
      And Manager tour request tıklar
      And Sayfadaki bir ilana tıklar

    @positive18
    Scenario: Manager ilan işlemlerini başarılı bir şekilde yapabilmeli

      And Tarih ve saat girilerek randevu olusturulur
      When Manager menüye gelip adverts tıklar
      Then Kendi verdiği ilanların isteklerini görebilmeli
      When Manager menüye gelip tour request tıklar
      Then Manager responses tıklayıp gelen gezme isteklerini yönetebilmeli

      @negative18
      Scenario: Manager ilan işlemlerini başarılı bir şekilde yapabilmeli

        And Tarih ve saat boş bırakılarak submit butonuna tıklanır
        And Randevu icin tarih ve saat girmeden uyarı mesajı görünürlüğü test edilir
        When Manager menüye gelip tour request tıklar
        Then Manager responses tıklayıp gelen gezme isteklerini yönetebilmeli


