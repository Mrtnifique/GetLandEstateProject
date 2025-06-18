@US18
  Feature: Manager ilanlar ile ilgili işlemleri yapabilmeli

    Background:
      Given Web adresine gidilir

    @positive18
    Scenario: Manager ilan işlemlerini başarılı bir şekilde yapabilmeli
      When Manager hesabı ile sisteme giriş yapılır
      And Manager properties tıklar
      And Sayfadaki bir ilana tıklar
      And Tarih ve saat girilerek randevu olusturulur
      When Manager menüye gelip adverts tıklar
      Then Kendi verdiği ilanların isteklerini görebilmeli
      When Manager münüye gelip tour request tıklar
      Then Manager responses tıklayıp gelen gezme isteklerini yönetebilmeli

      @negative18
      Scenario: Manager ilan işlemlerini başarılı bir şekilde yapabilmeli
        When Manager hesabı ile sisteme giriş yapılır
        And  Manager properties tıklar
        And Sayfadaki bir ilana tıklar
        And Tarih ve saat boş bıraklır
        And Tarih ve saat alanı zorunlu uyarısı çıkar
        When Manager menüye gelip tour request tıklar
        Then Manager responses tıklayıp gelen gezme isteklerini yönetebilmeli


