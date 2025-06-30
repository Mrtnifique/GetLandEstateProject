@DBUS02
Feature: Categories sutun isimlerini ve bilgilerini dogrula

  Scenario: Categories sutun isimlerini ve bilgilerini dogrula
    Given Kullanıcı database-e baglanır
    When Kullanıcı "Categories" sutun isimlerini ceker
    Then Kullanıcı sutun isimlerini ve bilgilerini dogrular

      |id  |
      |created_at|
      |updated_at|
      |is_active|
      |built_in|
      |icon|
      |seq|
      |slug|
      |title|

    Scenario: Categories sutun isimlerini ve bilgilerini dogrula
      Given Kullanıcı database-e baglanır
      When Kullanıcı "Categories" sekmesindeki "193" id'li bilgileri ceker
      Then Kullanıcı sutun isimlerini ve bilgilerini dogrular

        |id  |    icon                     | seq | slug               | title |
        |193 |    fa-solid fa-mountain-sun | 5   | land-1722713016558 | Land  |
