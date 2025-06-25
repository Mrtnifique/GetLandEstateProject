@DBUS14
Feature: Tour Requests Sütun İsim Doğrulama

  Scenario: 1003 numaralı satırdaki verilerin doğrulanması
    Given Kullanıcı veritabanına bağlanır
    And tour_requests tablosuna erişim sağlanır
    When 1003 numaralı satır sorgulanır
    Then advert_id değeri 32 olmalıdır
    And guest_user_id değeri 1570 olmalıdır
    And owner_user_id değeri 7 olmalıdır

  Scenario: Tour requests tablosu sütun yapısı doğrulaması
    Given Kullanıcı veritabanına bağlanır
    And tour_requests tablosuna erişim sağlanır
    When tablo yapısı kontrol edilir
    Then advert_id sütunu mevcut olmalıdır
    And guest_user_id sütunu mevcut olmalıdır
    And owner_user_id sütunu mevcut olmalıdır