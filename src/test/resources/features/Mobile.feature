#Author: brunopastorelli@hotmail.com

@mobile
Feature: Automacao Mobile 
  Feature de Testes para criação de framework de automação mobile.

	@login_sucesso
	Scenario: Login com sucesso
		Given Que eu quero testar "Login com sucesso"
		And Que efetuo o login com usuario e senha validos
		Then Valido o teste com o texto "Pagar com QR" na pagina atual

  @pesquisa_produtos
  Scenario Outline: Pesquisar um produto
    Given Que eu quero testar "Pesquisa de produtos"
    Then Pesquiso o produto tipo <tipo> descricao <descricao> com o preco <preco>
    
    Examples:
    	| tipo            | descricao                                                       | preco      |
    	| "Notebook"      | "Notebook Dell Inspiron 3583-u05p Pentium 4gb 500gb 15.6 Linux" | "R$ 1.899" |
    	| "Bota Robofoot" | "Robofoot Salvapé Original Seminova Top"                        | "R$ 180"   |
    	
  @adicionar_produto_carrinho
  Scenario Outline: Adicionar produto ao carrinho
    Given Que eu quero testar "Adicionar produto ao carrinho"
    And Pesquiso o produto tipo <tipo> descricao <descricao> com o preco <preco>
    Then Adiciono o produto ao meu carrinho e recebo a mensagem "Você adicionou ao seu carrinho"
    
    Examples:
    	| tipo            | descricao                                                       | preco      |
    	| "Notebook"      | "Notebook Dell Inspiron 3583-u05p Pentium 4gb 500gb 15.6 Linux" | "R$ 1.899" |
    	| "Bota Robofoot" | "Robofoot Salvapé Original Seminova Top"                        | "R$ 180"   |

    
    