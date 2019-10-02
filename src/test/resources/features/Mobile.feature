#Author: your.email@your.domain.com

@mobile
Feature: Automacao Mobile
  I want to use this template for my feature file

  @acessando
  Scenario: Primeiro acesso
    Given Que eu quero testar "Primeiro acesso"
    And Encontro o texto "Bem-vindo!" na tela atual
    And Deslizo para a esquerda e visualizo 4 telas 
    When Clico no botao IR PARA O APLICATIVO
    Then Encontro o texto "Não perca nenhuma notícia!" na tela atual 
		