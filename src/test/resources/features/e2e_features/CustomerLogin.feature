@CustomerLogine2e
Feature: Customer Login e2e

  #UI
  Scenario: Site uzerinden customer hesabı olusturulması dogrulanır
    Given Web seyfesine get
    When Register seyfesine daxil olmali
    Then Ad, Soyad ve telefon nomresi yazmali
    Then Dogru email yazmali
    Then Dogru password yazmali
    And  Register olmali
    And Customer olaraq qeyd olmali
    And Sayfa kapatılır

  #DB
  Scenario: Database uzerinden kullanıcı hesaplari goruntulernir
    Given Kullanıcı "Users" tablosuna bağlanır
    When Kullanıcı "Users" tablosunun sütun isimlerini çeker
    Then Kullanıcı aşağıdaki sütunları görmelidir
      | id         |
      | first_name |
      | email      |
      | created_at |
      | updated_at |

  #API
  @ApiCustomerSelin
  Scenario: API uzerinden customer hesabı olusturulması dogrulanır
    Given User Register için URL düzenlenir
    And User Register için payload düzenlenir
    When User Register için POST request gönderilir ve response alınır
    Then User Register için Status kodunun 200 olduğu doğrulanır