@API02Ruhin

  Feature: Category Property Key Controller API Test-leri!

    @ApiAdmin
    Scenario: TC01 | Category-property-key-controller Post Test
      Given Adim cat-pro-key-cont icin URL duzenler
      When POST Send Request ve get Response alinir
      Then Status code 200 oldugunu dogrula



    @ApiAdmin
    Scenario: TC02 | Category-property-key-controller GET Test
        Given Adim cat-pro-key-cont icin URL duzenler
        When GET Send Request ve get Response alinir
        Then Status code 200 oldugunu dogrula




    @ApiAdmin
    Scenario: TC03 | Category-property-key-controller PUT Test
        Given Adim cat-pro-key-cont icin URL duzenler
        And  Adim PUT istegi icin payload hazırlanır
        When PUT Send Request ve get Response alinir
        Then Status code 200 oldugunu dogrula



    @ApiAdmin
    Scenario: TC04 | Category-Property-Key-controller delete
      Given URL duzenlenir: first "categoriesKey" second "properties" third "1"
      When Delete send Request ve get Response alınır
      Then Status code 200 oldugunu dogrula