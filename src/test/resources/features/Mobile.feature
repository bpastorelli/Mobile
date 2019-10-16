#Author: brunopastorelli@hotmail.com

@mobile
Feature: Automacao Mobile
  Feature de Testes para criação de framework de automação mobile.

  @primeiro_acesso_app_nao_instalado
  Scenario: Primeiro acesso - Aplicativo nao instalado
    Given Que eu quero testar "Primeiro acesso - Aplicativo nao instalado"
    And Caso apareça um popup com a mensagem "Instale a nova versão disponível" clico na opcao "MAIS TARDE"
    And Encontro o texto "O que está esperando?" na pagina atual
    When Clico no botao "Já tenho conta" da pagina inicial
    And Encontro o texto "Continuar com" na pagina atual
    And Clico no botao "NENHUMA DAS ALTERNATIVAS ACIMA" da pagina continuar
    #Then Encontro o texto "E-mail ou usuário" na pagina atual
    #And Digito o texto "brunopastorelli@hotmail.com" no campo e-mail na pagina logar
    #And Clico no botao "Continuar" da pagina logar 
    Then Encontro o texto "Senha" na pagina atual
    And Digito o texto "sid04197" no campo senha na pagina logar
    When Clico no botao "Entrar" da pagina logar
    And Caso apareça um popup com a mensagem "Salvar senha do Mercado Livre" clico na opcao "NUNCA"
    Then Encontro o texto "Pagar com QR" na pagina atual
    
  @pesquisar_produto
  Scenario Outline: Pesquisar um produto
    Given Que eu quero testar "Pesquisar um produto"
    #And Que eu ja esteja autenticado
    And Clico no botao "Buscar" da pagina pesquisa
    And Digito o texto <filtro> no campo txtBusca na pagina pesquisa
    And Seleciono o item <filtro> na lista de "produtos" da pagina pesquisa
    And Deslizo para baixo até o texto <descricao_produto> da pagina pesquisa
    When Escolho o produto <descricao_produto> na lista de "produtos filtrados"
    Then Encontro o texto <texto_esperado> na pagina atual
    
    Examples:
    	| filtro          | descricao_produto           | texto_esperado |
    	| "Bota Robofoot" | "Robofoot Salvapé Original" | "R$ 180"       |
    
    