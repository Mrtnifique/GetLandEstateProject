@Costumerroleupdatee2e2


Feature: Costumer Role Update UI

  #UI
  Scenario: Admin olusturulan customer kullanicisini admin yapabilmeli
    Given Siteye admin olarak giriş yapılır
    When Users butonuna tıklanır
    And  Arama kutusuna yildiz isilti yazilir
    And Ilgili kullanicinin yanindaki kalem kutucuguna tiklanir
    And Roles kismindan admin secilir
    And Update butonuna tiklanir
    Then Kullanicinin rolunun basariyla admin olarak guncellendigi dogrulanir
    And Sayfa kapatılır

  #DB
  Scenario: Database üzerinden user bilgilerinin görünürlüğü test edilir
    When Kullanıcı "users" sekmesinden sütun isimlerini çeker
    Then Kullanıcı gelen isimleri doğrular
      | id                  |
      | created_at          |
      | updated_at          |
      | built_in            |
      | email               |
      | enabled             |
      | first_name          |
      | last_name           |
      | locked              |
      | password_hash       |
      | phone               |
      | reset_password_code |
      | role                |
      | picture_id          |

  #API
  @ApiAdmin
  Scenario: API üzerinden user bilgileri güncellenebilirliği doğrulanır
    Given Auth User için URL düzenlenir
    And Auth User için güncelleme payload düzenlenir
    When Auth User için PATCH request gönderilir ve response alınır
    Then Auth User için Status kodunun 200 olduğu doğrulanır

