@addUser
Feature: ajouter un utilisateur en remplissant le formulaire d'ajout

  Background: 
    Given je me connecte sur l'application
    When je saisis le username "Admin"
    And je saisis le password "admin123"
    And je clique sur le bouton login
    Then je me redirige vers la page d'acceuil et "Dashboard" s'affiche
    When je clique sur le bouton Admin

  @adduser
  Scenario Outline: ajouter un nouvel utilisateur
    Given je clique sur ajouter un utilisateur
    When je selectionne un role "<role>"
    And je saisis l employe name "<EmployeName>"
    And je selectionne un statut "<statut>"
    And je saisis un username "<username>"
    And je saisis mon nouveau mot de passe "<mdpass>"
    And je confirme mon mot de passe "<mdpass>"
    And j enregistre mon ajout d utilisateur
    Then je verifie que le message d enregistrement saffiche "<messageNotification>"
    And je rempli le username "<username>"
    And je clique sur le bouton search
    Then je verifie le username "<username>" affiche dans le tableau
    When je clique sur le bouton supprimer
    And je confirme la suppression
    Then je verifie que l utilisateur a bien ete supprime "<messageDeleted>"

    Examples: 
      | role  | EmployeName | statut   | username | mdpass      | messageNotification | messageDeleted       |
      | Admin | Israa22     | Enabled  | nammour  | France@2024 | Successfully Saved  | Successfully Deleted |
      | ESS   | Israa22     | Disabled | user123  | France@2024 | Successfully Saved  | Successfully Deleted |
