@US013
Feature: US013-Manager kendi ilanlarına gelen randevu isteklerini görüntüleyip kabul edebilmeli

  Background:
    Given Siteye manager olarak giris yapilir
    When Control Panel sekmesindeki siteye geri dön tiklanir
    When Dashboard'a tıklar



  Scenario: TC01-Manager Randevu isteğini görüntüleme ve kabul etme


    When Tur Taleplerim sekmesine tiklar

    When Tur Cevaplarim sekmesine tiklar

    When Kendi ilanlarına ait randevu isteklerini listeler
    Then İlan adı, tarih ve kullanıcı bilgileri görünmelidir

    When Bir randevu istegini secer
    And Secilen randevu istegi kabul edilir
    Then Talep durumu "Onaylandi" olarak güncellenmelidir


  Scenario: TC02 - Manager pasif ilanlara gelen randevu isteklerini kabul edememeli
    When "Tur Taleplerim" sekmesine tıklanır
    When Pasif durumdaki bir ilana ait randevu talebi görüntülenir
    Then Randevu talebi için onay  ve reddet  butonları görünmemeli veya tıklanamaz olmalı
    And Onay butonuna tıklanmaya çalışıldığında sistem işlem yapmamalı ve onay gerçekleşmemelidir








