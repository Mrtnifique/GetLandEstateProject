@DBUS14
Feature: Tour Requests Sütun İsim Doğrulama

  Background: Given Kullanıcı veritabanına bağlanır
    And tour_requests tablosuna erişim sağlanır

  Scenario: 1003 numaralı satırdaki verilerin doğrulanması
    When 1003 numaralı satır sorgulanır
    Then advert_id değeri 32 olmalıdır
    And guest_user_id değeri 1570 olmalıdır
    And owner_user_id değeri 7 olmalıdır

  Scenario: Tour requests tablosu sütun yapısı doğrulaması
    When tablo yapısı kontrol edilir
    Then advert_id sütunu mevcut olmalıdır
    And guest_user_id sütunu mevcut olmalıdır
    And owner_user_id sütunu mevcut olmalıdır