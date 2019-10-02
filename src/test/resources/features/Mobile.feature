#Author: brunopastorelli@hotmail.com

@mobile
Feature: Automacao Mobile
  Feature de Testes para criação de framework de automção mobile.

  @acessando_introducao
  Scenario: Primeiro acesso passando pela introducao
    Given Que eu quero testar "Primeiro acesso"
    And Encontro o texto "Bem-vindo!" na tela atual
    And Deslizo para a esquerda e visualizo 4 telas
    When Clico no botao IR PARA O APLICATIVO
    Then Encontro o texto "Não perca nenhuma notícia!" na tela atual 
    
  @acessando_pula_introducao
  Scenario: Primeiro acesso navegando pela introducao e pulando a introducao
    Given Que eu quero testar "Primeiro acesso"
    And Desinstalo o aplicativo do dispositivo
    And Finalizo o aplicativo inicializado
    And Reinstalo o aplicativo no dispositivo
    And Encontro o texto "Bem-vindo!" na tela atual
    And Deslizo para a esquerda e visualizo 4 telas
    And Deslizo para a direita e visualizo 4 telas
    When Clico no botao PULAR
    Then Encontro o texto "Não perca nenhuma notícia!" na tela atual 
		