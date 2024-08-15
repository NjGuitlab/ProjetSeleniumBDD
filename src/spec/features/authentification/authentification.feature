@authentification
Feature: Authentification
  En tant qu un utilisateur je veux m'authentifier à l'application Orange hlm

  Background: 
    Given je me connecte sur l'application
		
		
  @authentificationValide
  Scenario: Authentification avec identifiants valides
    When je saisis le username "Admin"
    And je saisis le password "admin123"
    And je clique sur le bouton login
    Then je me redirige vers la page d'acceuil et "Dashboard" s'affiche

  @authentificationUsernameInvalide
  Scenario: Authentification avec un username invalide
    When je saisis le username "test"
    And je saisis le password "admin123"
    And je clique sur le bouton login
    Then je me redirige vers la page d'acceuil et "Invalid credentials" s'affiche

  @authentificationNonValide
  Scenario Outline: Authentification avec des identifiants non valides
    When je saisis le username "<username>"
    And je saisis le password "<password>"
    And je clique sur le bouton login
    Then je me redirige vers la page d'acceuil et "<resultatAttendu>" s'affiche

    Examples: 
      | username | password | resultatAttendu     |
      | Admin    | erreur   | Invalid credentials |
      | test     | admin123 | Invalid credentials |
      |          | admin123 | Required            |
      | Admin    |          | Required            |
      |          |          | Required            |
