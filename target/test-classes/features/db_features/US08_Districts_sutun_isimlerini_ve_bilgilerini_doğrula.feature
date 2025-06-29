@DBUS08
Feature: Kullanıcı Districts sütun isimlerini ve bilgilerini doğrula

  Scenario: Districts sütun isimlerini doğrula
    Given Kullanıcı "districts" tablosundan sütun isimlerini alir
    Then Kullanıcı gelen bilgiler doğrulanır
      | id         |
      | lat        |
      | lng        |
      | name       |
      | city_id    |

  Scenario: Kullanıcı Districts sütun bilgilerini doğrular
    Given Kullanıcı "districts" tablosundan "48337" id'den bilgileri alir
    Then Kullanıcıdan gelen bilgiler doğrulanir
      | id    | lat               | lng                | name      | city_id |
      | 48395 | 39.97771453857422 | 32.866981506347656 | Keçiören  | 4127    |

