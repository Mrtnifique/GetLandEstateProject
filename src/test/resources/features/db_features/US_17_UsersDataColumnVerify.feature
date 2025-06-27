@DBUS_17
Feature: Users tablosundaki sütun bütünlüğünü ve veri kalitesini doğrular

  Background:
    Given Kullanıcı "Users" tablosuna bağlanır


  Scenario: Users tablosunda aşağıdaki sütunlar bulunmalıdır
    When Kullanıcı "Users" tablosunun sütun isimlerini çeker
    Then Kullanıcı aşağıdaki sütunları görmelidir
      | id          |
      | first_name  |
      | email       |
      | created_at  |
      | updated_at  |


  Scenario: Hiçbir kullanıcıda boş veya null e-posta olmamalı
    When "SELECT * FROM Users WHERE email IS NULL OR TRIM(email) = ''" sorgusu çalıştırılır
    Then Sonuç boş olmalıdır


  Scenario: Users tablosundaki id sütunu benzersiz olmalı
    When "SELECT id, COUNT(*) FROM Users GROUP BY id HAVING COUNT(*) > 1" sorgusu çalıştırılır
    Then Sonuç boş olmalıdır


  Scenario: created_at değeri updated_at değerinden önce olmalı
    When "SELECT * FROM Users WHERE updated_at < created_at" sorgusu çalıştırılır
    Then Sonuç boş olmalıdır