@API11Tugberk
Feature: API DailyReport Controller Testi

@ApiAdmin
Scenario: TC01 | DailyReport Get Testi
Given DailyReport Controller Get icin URL düzenlenir
When DailyReport Get Request gönderilir ve Respond alınır
Then Dogrulama kodun 200 olduğu doğrulanır
