@recherche
Feature: recherche par userRole
  En tant qu'admin je veux effectuer une recherche par user Role

  Background: 
    Given je me connecte sur l'application
    When je saisis le username "Admin"
    And je saisis le password "admin123"
    And je clique sur le bouton login
    Then je me redirige vers la page d'acceuil et "Dashboard" s'affiche
    When je clique sur le bouton Admin

  @rechercheUserRole
  Scenario Outline: recherche UserRole
    When je choisi le role "<role>"
    And je clique sur le bouton search
    Then je verifie le role "<role>" affiche dans le tableau
    When je clique sur le menu deroulant du profil utilisateur
    And je clique sur le  bouton logout
    Then je me redirige vers la page de connexion et "Login" s'affiche

    Examples: 
      | role  |
      | Admin |
      | ESS   |
