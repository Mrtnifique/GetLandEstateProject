@DBUS09
Feature: category_property_keys sutun isimlerini ve bilgilerini doğrula

  Scenario: category_property_keys tablosunda doğru sütun isimleri bulunmalı
    Given Database bağlantısı kurulur
    When "category_property_keys" tablosundan sütun bilgileri çekilir
    Then Aşağıdaki sütunların mevcut olduğu doğrulanır:
      | id          |
      | built_in    |
      | key_type    |
      | name        |
      | prefix      |
      | suffix      |
      | category_id |
