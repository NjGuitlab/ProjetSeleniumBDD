@Deconnexion
Feature: deconnexion
  En tant qu'un utilisateur je veux me deconnecter de l'application orangeHrm

  Background: 
    Given je me connecte sur l'application
    When je saisis le username "Admin"
    And je saisis le password "admin123"
    And je clique sur le bouton login
    Then je me redirige vers la page d'acceuil et "Dashboard" s'affiche

  @deconnexion
  Scenario: deconnexion de l'application
    When je clique sur le menu deroulant du profil utilisateur
    And je clique sur le  bouton logout
    Then je me redirige vers la page de connexion et "Login" s'affiche
