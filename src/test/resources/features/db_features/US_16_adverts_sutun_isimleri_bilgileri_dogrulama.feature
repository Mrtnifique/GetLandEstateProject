@DBUS16
  Feature: Adverts sutun isimleri ve bilgileri dogrulama

    @Background:
      Given Kullanıcı veritabanına bağlanır
        When Contacts tablosuna erisim saglanir

    @US16ERVA1
    Scenario: Adverts sutun isimleri dogrulama
      Then Headerların eksiksiz oldugu dogrulanir
        | id                |
        | address           |
        | advert_type_id    |
        | built_in          |
        | category_id       |
        | city_id           |
        | country_id        |
        | created_at        |
        | description       |
        | district_id       |
        | is_active         |
        | lat               |
        | lng               |
        | price             |
        | slug              |
        | status_for_advert |
        | title             |
        | updated_at        |
        | user_id           |
        | view_count        |

    @US16ERVA2
    Scenario: Adverts sutun bilgileri dogrulama
      And 24 numarali satir sorgulanir
      And Id degeri 33 olmalidir
      Then Pricei 350000 olmalidir