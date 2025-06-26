@DBUS15
Feature: Advert_types sutun isimlerini ve bilgilerini doğrula

  Scenario: Advert_types sutun isimlerini ve bilgilerini dogrula
    Given Istifadechi Database-ə qosulur
    When Istifadechi Advert_types cedvelinden melumatlari cekir
    Then Istifadechi sutun adlarini ve melumatlari dogrula