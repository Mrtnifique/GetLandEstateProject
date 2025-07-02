@API03Ayhan
Feature: API Advert Controller

  @ApiAdmin
  Scenario: TC01 | Advert Controller get
    Given URL ayarlanır: first "adverts" second "search"
    When Get Request gönderilir ve Respond alınır | İki URL
    Then Status Code'ın 200 olduğu doğrulanır

 # @ApiAdmin
  #Scenario: TC02 | Advert Controller post
    #Given URL ayarlanır: first "adverts"
    #And Advert Controller için payload ayarlanır
    #When Post Request gönderilir ve Respond alınır | Tek URL
    #Then Status Code'ın 200 olduğu doğrulanır

 # @ApiAdmin
  #Scenario: TC03 | Advert Controller put
    #Given URL ayarlanır: first "adverts" second "admin" third "5"
    #And Advert Controller için payload ayarlanır
    #When Put Request gönderilir ve Respond alınır | Üç URL
   #Then Status Code'ın 200 olduğu doğrulanır

  @ApiAdmin
  Scenario: TC04 | Advert Type Controller delete
    Given URL ayarlanır: first "adverts" second "id:54"
    When Delete Request gönderilir ve Respond alınır | İki URL
    Then Status Code'ın 200 olduğu doğrulanır