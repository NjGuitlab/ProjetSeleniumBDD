@recherche
Feature: multi recherche par :  Username-Status-EmployeName-Role
  En tant qu admin je veux effectuer une multi recherche d'utilisateur

  Background: 
    Given je me connecte sur l'application
    When je saisis le username "Admin"
    And je saisis le password "admin123"
    And je clique sur le bouton login
    Then je me redirige vers la page d'acceuil et "Dashboard" s'affiche
    When je clique sur le bouton Admin

  @multiRecherche
  Scenario Outline: rechercher un utilisateur avec plusieurs criteres
    And je rempli le username "<username>"
    When je choisi le role "<role>"
    When je saisis le nom de l employee "<nom>"
    When je choisis un statut "<status>"
    And je clique sur le bouton search
    Then je verifie le username "<username>" affiche dans le tableau
    Then je verifie le role "<role>" affiche dans le tableau
    Then je verifie le nom "<nom>" affiche dans le tableau
    Then je verifie le statut affiche dans le tableau "<status>"
    When je clique sur le menu deroulant du profil utilisateur
    And je clique sur le  bouton logout
    Then je me redirige vers la page de connexion et "Login" s'affiche

    Examples: 
      | username | role  | nom        | status  |
      | Admin    | Admin | manda user | Enabled |
