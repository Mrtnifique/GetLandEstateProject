@DBUS07
  Feature: countries sutun isimlerini ve bilgilerini doğrula

    Scenario: Sütun isimleri ve ülke verileri doğrulanmalı
      Given API isteği gönderilir
      Then Dönüşte her ülke için şu alanlar bulunmalı:
        | id       |
        | name     |
        | location |
      And En az 1 ülke "name" alanı boş olmamalı
      And "Deutschland" isminde bir ülke bulunmalı
      Then Dönüşte her ülke için id, name ve location alanları boş olmamalı ve terminalde yazdırılmalı
