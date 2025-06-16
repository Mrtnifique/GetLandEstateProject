@US013
Feature: Manager kendi ilanlarına gelen randevu isteklerini görüntüleyip kabul edebilmeli

  Background:
    Given Siteye manager olarak giris yapilir

  Scenario: Randevu isteğini görüntüleme ve kabul etme
    When "Tur Taleplerim" sekmesine tıklar
    Then Randevu istekleri sayfası açılır

    When Kendi ilanlarına ait randevu isteklerini listeler
    Then İlan adı, tarih ve kullanıcı bilgileri görünmelidir

    When Bir randevu isteği seçer ve "Kabul Et" butonuna tıklar
    Then "İstek başarıyla kabul edildi" mesajı görünmelidir
    And Talep durumu "Kabul Edildi" olarak güncellenmelidir
