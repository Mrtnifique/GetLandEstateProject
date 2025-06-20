@US10
  Feature: US10 Customer kiralık ilan arayabilmeli

    Scenario: TC01 Customer kiralık ilan arayabilmeli
      Given Siteye customer olarak giriş yapılır
      And Anasayfa Rent Butonuna Tikla
      When Search butonuna tıklanır
      Then Rent ilan kontrol edilir

    Scenario: TC02 Customer Mülkler kısmından kiralık ilan arayabilmeli
      Given Siteye customer olarak giriş yapılır
      And Anasayfa Properties butonuna tikla
      And Advert Type butonuna tikla ve Rent sec
      When Filter Search Arama Butonuna Tikla
      Then Rent ilan kontrol edilir

    Scenario: TC03 İlanlar kısmındaki  Ara filtresi doğru sonuç vermeli
      Given Siteye customer olarak giriş yapılır
      And Anasayfa Properties butonuna tikla
      And Sitede olmayan bir ilan adi aratilir
      When Filter Search Arama Butonuna Tikla
      Then Bulunan ilan sayisi kontrol edilir
      And Filter Search Box temizlenir
      And Sitede bulunan bir ilan adi aratilir
      When Filter Search Arama Butonuna Tikla
      Then Ilan adi kontrol edilir

    Scenario: TC04 İlanlar kısmındaki  Fiyat aralığı filtresi doğru sonuç vermeli
      Given Siteye customer olarak giriş yapılır
      And Anasayfa Properties butonuna tikla
      When Fiyat kismina sayi disinda veri girisi denenir
      Then Fiyat kisminin bos oldugu test edilir
      And Min kismi Max kismindan buyuk yazilmasi denenir
      When Filter Search Arama Butonuna Tikla
      Then Start price must be less than end price. hatasi kontrol edilir
      And Pricelar temizlenir
      And Dogru Fiyat araligi yapilir
      When Filter Search Arama Butonuna Tikla
      Then Fiyatlar kontrol edilir

    Scenario: TC05 İlanlar kısmındaki Kategori filtresi doğru sonuç vermeli
      Given Siteye customer olarak giriş yapılır
      And Anasayfa Properties butonuna tikla
      And Category butonuna tikla ve house sec
      When Filter Search Arama Butonuna Tikla
      Then Ilanin categorysi kontrol edilir

    Scenario: TC06 İlanlar kısmındaki  Ülke - Şehir - İlçe  filtresi doğru sonuç vermeli
      Given Siteye customer olarak giriş yapılır
      And Anasayfa Properties butonuna tikla
      And Countrye tikla ve France sec
      And Citye tikla ve Allier sec
      And Districte tikla ve Vichy sec
      When Filter Search Arama Butonuna Tikla
      Then Ilanin konumu kontrol edilir