#Author: brunopastorelli@hotmail.com
@mobile
Feature: Automacao Mobile
  Feature de Testes para criação de framework de automação mobile.

  @login_sucesso
  Scenario: Login com sucesso
    Given Que eu quero testar "Login com sucesso"
    And Que efetuo o login com usuario "email@email.com" e senha "12345" validos
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

  @consultar_veiculo
  Scenario Outline: Consultar veiculo
    Given Que eu quero testar "Consultar um veiculo"
    And Que eu quero pesquisar um veiculo tipo <tipo>
    And Seleciono a marca <marca> e modelo <modelo>
    When Escolho o veiculo <escolher> e visualizo
    Then Valido o teste com o texto <preco> na pagina atual

    Examples: 
      | tipo    | marca    | modelo           | escolher                | preco       |
      | "Motos" | "Yamaha" | "MT 07"          | "Yamaha Mt-07 Abs,2018" | "R$ 31.490" |
      | "Motos" | "Suzuki" | "Outros Modelos" | "Suzuki Gsx R 1100"     | "R$ 16.900" |

  @logout
  Scenario: Efetuar logout
    Given Que eu quero testar "Logout"
    When Efetuo o logout do aplicativo
    Then Valido o teste com o texto "Acesse sua conta" na pagina atual
