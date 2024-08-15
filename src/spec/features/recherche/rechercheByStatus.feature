@recherche
Feature: rechercher par status
  En tant qu'admin je recherche un utilisateur en choisissant son statut

  Background: 
    Given je me connecte sur l'application
    When je saisis le username "Admin"
    And je saisis le password "admin123"
    And je clique sur le bouton login
    Then je me redirige vers la page d'acceuil et "Dashboard" s'affiche
    When je clique sur le bouton Admin

  @rechercheByStatus
  Scenario Outline: rechercher un utilisateur par status
    When je choisis un statut "<status>"
    And je clique sur le bouton search
    Then je verifie le statut affiche dans le tableau "<status>"
    When je clique sur le menu deroulant du profil utilisateur
    And je clique sur le  bouton logout
    Then je me redirige vers la page de connexion et "Login" s'affiche

    Examples: 
      | status   |
      | Enabled  |
      | Disabled |
