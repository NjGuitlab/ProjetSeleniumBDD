@recherche
Feature: recherche par nom
  En tant qu admin je veux effectuer une recherche par nom employe

  Background: 
    Given je me connecte sur l'application
    When je saisis le username "Admin"
    And je saisis le password "admin123"
    And je clique sur le bouton login
    Then je me redirige vers la page d'acceuil et "Dashboard" s'affiche
    When je clique sur le bouton Admin

  @rechercheByName
  Scenario Outline: recherche un utilisateur par nom
    When je saisis le nom de l employee "<nom>"
    And je clique sur le bouton search
    Then je verifie le nom "<nom>" affiche dans le tableau
    When je clique sur le menu deroulant du profil utilisateur
    And je clique sur le  bouton logout
    Then je me redirige vers la page de connexion et "Login" s'affiche

    Examples: 
      | nom           |
      | Ranga Akunuri |
      | Moon Baker    |
