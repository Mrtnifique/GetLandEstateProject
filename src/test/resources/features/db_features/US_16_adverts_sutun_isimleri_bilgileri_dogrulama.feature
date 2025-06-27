@DBUS16
Feature: Adverts sutun isimleri ve bilgileri dogrulama

  @US16ERVA1
  Scenario: Adverts sutun isimleri dogrulama
    Given Kullanıcı "adverts" sekmesinden sütun isimlerini çeker
    Then Kullanıcı gelen isimleri doğrular
      | id                |
      | created_at        |
      | updated_at        |
      | address           |
      | built_in          |
      | description       |
      | is_active         |
      | lat               |
      | lng               |
      | price             |
      | slug              |
      | status_for_advert |
      | title             |
      | view_count        |
      | advert_type_id    |
      | category_id       |
      | city_id           |
      | country_id        |
      | district_id       |
      | user_id           |

  @US16ERVA2
  Scenario: Adverts sutun bilgileri dogrulanir
    Given Kullanıcı "adverts" sekmesinden "524" id'den bilgileri çeker
    Then Kullanıcı gelen bilgileri doğrular
      | id   | created_at                   | updated_at                   | address                            | built_in | description                                    | is_active | lat                | lng                | price | slug                              | status_for_advert | title               | view_count | advert_type_id | category_id | city_id | country_id | district_id | user_id |
      | 524  | 2025-03-19 15:05:56.436366   | 2025-03-24 07:44:17.273577   | Kisik bolgesinde baglar mevkisinde | false    | Mustakil bahceli, merkezi isitma ve klimali ev | true      | 38.043441599999994 | 29.39814828655458  | 10.0    | 1742396756996-mustakil-bahceli-ev | 0                 | Mustakil bahceli Ev | 4          | 2              | 1           | 4145    | 223        | 48592       | 36      |