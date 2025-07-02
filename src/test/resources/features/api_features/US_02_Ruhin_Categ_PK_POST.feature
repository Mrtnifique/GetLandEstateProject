@API02Ruhin

  Feature: Category Property Key Controller API Test-leri!

    Scenario: TC01 | Category-property-key-controller Post Test
      Given Adim "cat-pro-key-cont" icin URL duzenler
      And  Adim POST istegi icin payload hazırlanır
      When Send Request ve get Respond alinir
      Then Status Code 200 oldugunu dogrular



    Scenario: TC02 | Category-property-key-controller GET Test
        Given Adim "cat-pro-key-cont" icin URL duzenler
        And  Adim GET istegi icin payload hazırlanır
        When Send Request ve get Respond alinir
        Then Status Code 200 oldugunu dogrular




    Scenario: TC03 | Category-property-key-controller PUT Test
            Given Adim "cat-pro-key-cont" icin URL duzenler
            And  Adim PUT istegi icin payload hazırlanır
            When Send Request ve get Respond alinir
            Then Status Code 200 oldugunu dogrular



    Scenario: TC04 | Category-property-key-controller DELETE Test
      Given Adim "cat-pro-key-cont" icin URL duzenler
      And  Adim DELETE istegi icin payload hazırlanır
      When Send Request ve get Respond alinir
      Then Status Code 200 oldugunu dogrular