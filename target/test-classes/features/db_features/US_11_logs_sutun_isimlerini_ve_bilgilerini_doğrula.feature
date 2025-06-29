@DBUS11
Feature: logs sutun isimlerini ve bilgilerini doğrula

    Scenario: logs sutun isimlerini ve bilgilerini doğrula
        Given Kullanıcı "logs" sekmesinden sutun isimlerini ceker
        Then Kullanıcı gelen isimleri dogrular
            | id         |
            | advert_id  |
            | created_at |
            | message    |
            | user_id    |