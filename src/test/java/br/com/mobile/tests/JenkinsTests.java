package br.com.mobile.tests;

import org.junit.Test;

import br.com.mobile.actions.android.ActionsMobile;
import br.com.mobile.regression.BaseTestCase;
import br.com.mobile.reports.LogReport;

public class JenkinsTests extends BaseTestCase {

	private ActionsMobile actions = new ActionsMobile();
    
    @Test
    public void testA() {
    	
    	String usuario = "email@email.com";
    	String senha = "123456";
    	
    	LogReport.createTest("Login");
    	actions.logar(usuario, senha);
    	
    	LogReport.passFail(actions.textoEncontrado("Pagar com QR"), "Login com usuario " + usuario);
    }
    
    @Test
    public void testB() throws InterruptedException {
    	
    	LogReport.createTest("Pesquisa de produto");
    	actions.retornarInicio("Pagar com QR");
    	actions.pesquisaProduto("Bota Robofoot", "Bota Imobilizadora Robofoot Salvapé Original Seminova Top");
    	actions.validarTexto("R$ 180");
    	
    	LogReport.passFail(actions.textoEncontrado("R$ 180"), "Pesquisa do produto Bota Robofoot");
    }
    
    @Test
    public void testC() {
    	
    	LogReport.createTest("Pesquisa de produto");
    	actions.retornarInicio("Pagar com QR");
    	actions.pesquisaProduto("Notebook", "Notebook Dell Inspiron 3583-u05p Pentium 4gb 500gb 15.6 Linux");
    	actions.validarTexto("R$ 1.899");
    	
    	LogReport.passFail(actions.textoEncontrado("R$ 1.899"), "Pesquisa do produto Notebook");
    } 
    
    @Test
    public void testE() throws InterruptedException {
    	
    	LogReport.createTest("Adicionar produto Robofoot ao carrinho");
    	actions.retornarInicio("Pagar com QR");
    	actions.pesquisaProduto("Bota Robofoot", "Bota Imobilizadora Robofoot Salvapé Original Seminova Top");
    	actions.validarTexto("R$ 180");
    	actions.adicionarProdutoCarrinho();
    	
    	LogReport.passFail(actions.textoEncontrado("Você adicionou ao seu carrinho", 5), "Adicionar produto ao carrinho");
    }
    
    @Test
    public void testF() throws InterruptedException {
    	
    	LogReport.createTest("Adicionar produto Notebook ao carrinho");
    	actions.retornarInicio("Pagar com QR");
    	actions.pesquisaProduto("Notebook", "Notebook Dell Inspiron 3583-u05p Pentium 4gb 500gb 15.6 Linux");
    	actions.validarTexto("R$ 1.899");
    	actions.adicionarProdutoCarrinho();
    	
    	LogReport.passFail(actions.textoEncontrado("Você adicionou ao seu carrinho", 5), "Adicionar produto ao carrinho");
    }    
    
    @Test
    public void testG() {
    	
    	LogReport.createTest("Remover produto do carrinho");
    	actions.retornarInicio("Pagar com QR");
    	actions.removerProdutosCarrinho("O seu carrinho está vazio");
    	
    	LogReport.passFail(actions.textoEncontrado("O seu carrinho está vazio"), "Remover produto do carrinho");
    }
    
    @Test
    public void testH() {
    	
    	LogReport.createTest("Logout");
    	actions.retornarInicio("Pagar com QR");
    	actions.logout();
    	
    	LogReport.passFail(actions.textoEncontrado("Acesse sua conta"), "Logout");
    }
}
