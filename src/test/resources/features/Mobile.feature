#Author: brunopastorelli@hotmail.com
@mobile
Feature: Automacao Mobile
  Feature de Testes para criação de framework de automação mobile.

  @login_sucesso
  Scenario: Login com sucesso
    Given Que eu quero testar "Login com sucesso"
    And Que efetuo o login com usuario "brunopastorelli@hotmail.com" e senha "sid04197" validos
    Then Valido o teste com o texto "Pagar com QR" na pagina atual

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
      | "Bota Robofoot" | "Bota Imobilizadora Robofoot Salvapé Original Seminova Top"     | "R$ 180"   |

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
    When Marco o produto nos meus favoritos

    Examples: 
      | tipo                    | marca        | modelo           | escolher                                                   | preco       |
      | "Motos"                 | "Yamaha"     | "MT 07"          | "Yamaha Mt-07 Abs,2018 Financiamos E Parcelamos No Cartão" | "R$ 31.490" |
      | "Motos"                 | "Suzuki"     | "Outros Modelos" | "Suzuki Gsx R 1100"                                        | "R$ 16.900" |
      | "Motos"                 | "Triumph"    | "Tiger 800"      | "Triumph Tiger 800 2014"                                   | "R$ 28.900" |
      | "Carros e caminhonetes" | "Mitsubishi" | "L200"           | "Mitsubishi L200 3.5 Triton Hpe Cab. Dupl A 4x4 Aut. 4p"   | "R$ 49.990" |

  @logout
  Scenario: Efetuar logout
    Given Que eu quero testar "Logout"
    When Efetuo o logout do aplicativo
    Then Valido o teste com o texto "Acesse sua conta" na pagina atual
