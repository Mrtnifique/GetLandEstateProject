@AdvertTypee2e

Feature: Advert Type e2e

  #UI
  Scenario: Advert Type eklenebiliyor olması doğrulanır
    Given Siteye admin olarak giriş yapılır
    When Advert Types butonuna tıklanır
    And Yeni Advert Type eklenir
    Then Advert Type eklenmiş olması doğrulanır
    And Sayfa kapatılır

  #DB
  Scenario: Eklenen Advert Typelar database de gözlemlenir
    Given Kullanıcın database-e bağlanır
    When Kullanicin "advert_types" sekmesinden "319" id'den bilgilerini ceker
    Then Kullanicin gelen bilgileri dogrular

      | id  | built_in | title  |
      | 300 | false    | Kaleem |

  #API
  @ApiAdmin
  Scenario: API üzerinden Advert Type eklenebiliyor olması doğrulanır
    Given URL ayarlanır: first "advert-types"
    And Advert Type için payload ayarlanır
    When Post Request gönderilir ve Respond alınır | Tek URL
    Then Status Code'ın 200 olduğu doğrulanır