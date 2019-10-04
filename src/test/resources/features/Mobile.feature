#Author: brunopastorelli@hotmail.com

@mobile
Feature: Automacao Mobile
  Feature de Testes para criação de framework de automção mobile.

  @acessando_introducao
  Scenario: Primeiro acesso passando pela introducao
    Given Que eu quero testar "Primeiro acesso - Passando pela introducao"
    And Encontro o texto "Bem-vindo!" na tela atual
    And Deslizo para a esquerda e visualizo 4 telas
    When Clico no botao "IR PARA O APLICATIVO"
    Then Encontro o texto "Não perca nenhuma notícia!" na tela atual 
    
  @acessando_pula_introducao
  Scenario: Primeiro acesso navegando pela introducao e pulando a introducao
    Given Que eu quero testar "Primeiro acesso - Pulando a introducao"
    And Desinstalo o aplicativo do dispositivo
    And Finalizo o aplicativo inicializado
    And Reinstalo o aplicativo no dispositivo
    And Encontro o texto "Bem-vindo!" na tela atual
    And Deslizo para a esquerda e visualizo 4 telas
    And Deslizo para a direita e visualizo 4 telas
    When Clico no botao "PULAR"
    Then Encontro o texto "Não perca nenhuma notícia!" na tela atual 

  @configurando_notificacoes
  Scenario Outline: Configuracao de Notificacoes
    Given Que eu quero testar "Configuracao de Notificacoes"
    And Desinstalo o aplicativo do dispositivo
    And Finalizo o aplicativo inicializado
    And Reinstalo o aplicativo no dispositivo
    And Encontro o texto "Bem-vindo!" na tela atual
    When Clico no botao "PULAR"
    And Encontro o texto "Não perca nenhuma notícia!" na tela atual
    And Configuro a quantidade de noticias para <opcao>
    And Configuro tipos de alertas <alerta>
    Then Deslizo a tela para baixo 1 vezes
    Then Deslizo a tela para cima 1 vezes
    When Clico no botao "IR PARA A TELA INICIAL"
    Then Encontro o texto "Login pelas redes sociais" na tela atual 
    
    Examples:
    	| opcao                           | alerta     | 
      | "Não quero perder nada"         | "Vibração" |
      | "Só as mais importantes"        | "Som"      |
      | "Apenas grandes acontecimentos" | "Som"      |
      | "Não receber nenhuma"           | "Vibração" |