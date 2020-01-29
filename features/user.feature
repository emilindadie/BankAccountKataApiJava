Feature: User Catalog
  An User wants to register himself into the system

  @Catalog
  Scenario Outline: Register himself in the system
    Given a user of name <name> and of email <email> and of address <address> and of password <password>
    When he want to register himself
    Then the user is registered

    Examples:
      | name        | Emilin                  |
      | email       | dadie.emilin@gmail.com  |
      | address     | 14 rue de Mulhouse      |
      | password    | azerty                  |
 
  @Catalog
  Scenario Outline: Login to the system
    Given a user of email <email> and of password <password>
    When he want to signin to the system
    Then the user is signin

    Examples:
      | email       | dadie.emilin@gmail.com  |
      | password    | azerty                  |