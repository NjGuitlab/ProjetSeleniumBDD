@recherche
Feature: recherche utilisateur
  En tant qu'admin je veux effectuer une recherche d'un utilisateur par username

  Background: 
    Given je me connecte sur l'application
    When je saisis le username "Admin"
    And je saisis le password "admin123"
    And je clique sur le bouton login
    Then je me redirige vers la page d'acceuil et "Dashboard" s'affiche

  @rechercheUsername
  Scenario Outline: Rechercher un utilisateur avec username
    When je clique sur le bouton Admin
    And je rempli le username "<username>"
    And je clique sur le bouton search
    Then je verifie le username "<username>" affiche dans le tableau
    When je clique sur le menu deroulant du profil utilisateur
    And je clique sur le  bouton logout
    Then je me redirige vers la page de connexion et "Login" s'affiche

    Examples: 
      | username |
      | Admin    |

   