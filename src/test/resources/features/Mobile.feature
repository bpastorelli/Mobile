#Author: brunopastorelli@hotmail.com

@mobile
Feature: Automacao Mobile 
  Feature de Testes para criação de framework de automação mobile.

	@login_sucesso
	Scenario: Login com sucesso
		Given Que eu quero testar "Login com sucesso"
		And Que efetuo o login com usuario "brunopastorelli@hotmail.com" e senha "sid04197" validos
		Then Valido o teste com o texto "Pagar com QR" na pagina atual

  @pesquisa_produtos
  Scenario Outline: Pesquisar um produto
    Given Que eu quero testar "Pesquisa de produtos"
    When Pesquiso o produto tipo <tipo> descricao <descricao>
    Then Visualizo o preco de <preco> do produto
    
    Examples:
    	| tipo            | descricao                                                       | preco      |
    	| "Notebook"      | "Notebook Dell Inspiron 3583-u05p Pentium 4gb 500gb 15.6 Linux" | "R$ 1.899" |
    	| "Bota Robofoot" | "Robofoot Salvapé Original Seminova Top"                        | "R$ 180"   |
    	
  @adicionar_produto_carrinho
  Scenario Outline: Adicionar produto ao carrinho
    Given Que eu quero testar "Adicionar produto ao carrinho"
    And Pesquiso o produto tipo <tipo> descricao <descricao>
    When Visualizo o preco de <preco> do produto
    And Adiciono o produto ao meu carrinho
    Then Valido o teste com o texto "Você adicionou ao seu carrinho" na pagina atual
    
    Examples:
    	| tipo            | descricao                                                       | preco      |
    	| "Notebook"      | "Notebook Dell Inspiron 3583-u05p Pentium 4gb 500gb 15.6 Linux" | "R$ 1.899" |
    	| "Bota Robofoot" | "Robofoot Salvapé Original Seminova Top"                        | "R$ 180"   |
    	
  @remover_todos_produtos_carrinho
  Scenario: Remover todos os produto do carrinho
    Given Que eu quero testar "Remover todos os produtos do carrinho"
    When Removo todos os produtos do carrinho
    Then Valido o teste com o texto "O seu carrinho está vazio" na pagina atual
    
 	@logout
 	Scenario: Efetuar logout
 		Given Que eu quero testar "Logout"
 		When Efetuo o logout do aplicativo
 		Then Valido o teste com o texto "Acesse sua conta" na pagina atual 

    
    