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
    And Pesquiso o produto tipo <tipo> descricao <descricao>
    Then Visualizo o preco de <preco> do produto
    
    Examples:
    	| tipo            | descricao                                                       | preco      |
    	| "Notebook"      | "Notebook Dell Inspiron 3583-u05p Pentium 4gb 500gb 15.6 Linux" | "R$ 1.899" |
    	| "Bota Robofoot" | "Robofoot Salvapé Original Seminova Top"                        | "R$ 180"   |
    	
  @adicionar_produto_carrinho
  Scenario Outline: Adicionar produto ao carrinho
    Given Que eu quero testar "Adicionar produto ao carrinho"
    And Pesquiso o produto tipo <tipo> descricao <descricao>
    And Visualizo o preco de <preco> do produto
    And Adiciono o produto ao meu carrinho
    Then Valido o teste com o texto "Você adicionou ao seu carrinho" na pagina atual
    
    Examples:
    	| tipo            | descricao                                                       | preco      |
    	| "Notebook"      | "Notebook Dell Inspiron 3583-u05p Pentium 4gb 500gb 15.6 Linux" | "R$ 1.899" |
    	| "Bota Robofoot" | "Robofoot Salvapé Original Seminova Top"                        | "R$ 180"   |

    
    