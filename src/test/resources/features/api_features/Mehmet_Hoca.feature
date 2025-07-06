@contact_message_api
Feature: ContactMessages api test

  @contact_message_api_01 @ApiAdmin
  Scenario: Yeni bir mesaj oluşturulabildigi doğrulanir
    Given Yeni bir mesaj olarak "bu bir test mesajidir" gönderilir
    Then status code 200 oldugu dogrulanir
    And contact message basarili bir sekilde olusturuldugu test edilir

  @ApiAdmin
  Scenario: Son olusturulan mesaj doğrulanir
    Given Son olusturulan mesaji alabilmek icin request yapilir
    Then status code 200 oldugu dogrulanir
    And son olusturulan mesaj test edilir

  @ApiAdmin
  Scenario: Son olusturulan mesajin güncellenebildigi doğrulanir
    Given Son olusturulan mesaji guncellemek icin request yapilir
    Then status code 200 oldugu dogrulanir
    And son olusturulan mesajin güncellenebildigi test edilir

  @ApiAdmin
  Scenario: Son olusturulan mesajin silinebildigi doğrulanir
    Given Son olusturulan mesaji silmek icin request yapilir
    Then status code 200 oldugu dogrulanir
    And son olusturulan mesajin silinebildigi test edilir