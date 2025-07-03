@APIerva12
  Feature: Countries controller

    @ApiAdmin
    Scenario: TC01 | GET
      Given URL ayarlanır: first "countries" second "all"
      When Get Request gönderilir ve Respond alınır | İki URL
      Then Status Code'ın 200 olduğu doğrulanır