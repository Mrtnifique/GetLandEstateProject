@US_07API
Feature: API Report Controller

  @TourRequest
  Scenario: TC01 | Report Controller get
    Given URL ayarlanır: first "tour-requests" second "0" third "auth"
    When Get Request gönderilir ve Respond alınır | Üç URL
    Then Status Code'ın 200 olduğu doğrulanır
