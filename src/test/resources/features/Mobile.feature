#Author: brunopastorelli@hotmail.com

@mobile
Feature: Automacao Mobile 
  Feature de Testes para criação de framework de automação mobile.

  @primeiro_acesso_app_nao_instalado
  Scenario Outline: Primeiro acesso - Aplicativo nao instalado
    Given Que eu quero testar "Primeiro acesso - Aplicativo nao instalado"
    And Que efetuo o login com usuario e senha
    Then Pesquiso o produto tipo <tipo> descricao <descricao> com o preco <preco>
    
    Examples:
    	| tipo            | descricao                                | preco      |
    	| "Bota Robofoot" | "Robofoot Salvapé Original Seminova Top" | "R$ 180"   |

    
    