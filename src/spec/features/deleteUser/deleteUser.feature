@deleteUser
Feature: cas de test pour supprimer un utilisateur

  Background: 
    Given je me connecte sur l'application
    When je saisis le username "Admin"
    And je saisis le password "admin123"
    And je clique sur le bouton login
    Then je me redirige vers la page d'acceuil et "Dashboard" s'affiche
    When je clique sur le bouton Admin

  @deleteUser
  Scenario Outline: Supprimer un utilisateur par username
    And je rempli le username "<username>"
    And je clique sur le bouton search
    Then je verifie le username "<username>" affiche dans le tableau
    When je clique sur le bouton supprimer
    And je confirme la suppression
    Then je verifie que l utilisateur a bien ete supprime "<messageDeleted>"
    And je rempli le username "<username>"
    And je clique sur le bouton search
    Then l utilisateur est supprime et non trouve "<messageUserNotFound>"

    Examples: 
      | username | messageDeleted       | messageUserNotFound |
      | player   | Successfully Deleted | No Records Found    |
