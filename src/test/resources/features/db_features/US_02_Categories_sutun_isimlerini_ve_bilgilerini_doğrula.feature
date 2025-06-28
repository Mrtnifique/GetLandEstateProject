@DBUS02
Feature: Categories sütun adlarını və məlumatlarını təsdiqləyir

  Scenario: Categories sütun adlarını və məlumatlarını təsdiqləyir
    Given İstifadəçi database-ə qoşulur
    When İstifadəçi "Categories" cədvəlindən məlumatları çəkir
    Then İstifadəçi sütun adlarını və məlumatların düzgünlüyünü təsdiqləyir

      |CategoryId|
      |CategoryName|
      |Description|
