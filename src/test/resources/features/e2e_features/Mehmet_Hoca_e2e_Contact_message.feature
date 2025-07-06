@contact_message_e2e
Feature: ContactMessages e2e test

 #API Verification
  @contact_message_e2e_01 @ApiAdmin
  Scenario: Yeni bir mesaj oluşturulabildigi doğrulanir E2E
    Given "ali", "can","ali@can.com","e2e icin test mesaji", ile Yeni bir mesaj olusturulur
    Then status code 200 oldugu dogrulanir end to end
    And contact message basarili bir sekilde olusturuldugu test edilir end to end

      #UI Admin Verification
  @contact_message_e2e_02
  Scenario: Admin contact message lari ui üzerinden görebilmelidir
    Given admin ana sayfaya gider
    When admin olarak "admin@gmail.com" ve "admin123!" bilgileri ile login olur
    And Dashboard'da Contact Messages linkine tıklar
    Then admin contact message da "e2e icin test mesaji" metnini dogrular
    And sayfayi kapatir


    #DB Verification
  Scenario: contact message lari DB üzerinden doğrulanir
    Given kullanici database e baglanir
    Then girilen "ali", "can", "ali@can.com", "e2e icin test mesaji" bilgiler database uzerinden dogrulanir
    And database baglantisi kapatilir
