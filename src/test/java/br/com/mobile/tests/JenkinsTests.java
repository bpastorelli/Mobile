package br.com.mobile.tests;

import org.junit.Test;

import br.com.mobile.actions.android.ActionsMobile;
import br.com.mobile.regression.BaseTestCase;
import br.com.mobile.reports.LogReport;

public class JenkinsTests extends BaseTestCase {
    
    private ActionsMobile actions = new ActionsMobile();
    
    @Test
    public void testA() {
    	
    	LogReport.createTest("Teste: Login");
    	actions.logar("brunopastorelli@hotmail.com", "sid04197");
    }
    
    @Test
    public void testB() throws InterruptedException {
    	
    	LogReport.createTest("Teste: Pesquisa de produto");
    	actions.retornarInicio();
    	actions.pesquisaProduto("Bota Robofoot", "Bota Imobilizadora Robofoot Salvapé Original Seminova Top", "R$ 180");
    }
    
    @Test
    public void testC() {
    	
    	LogReport.createTest("Teste: Pesquisa de produto");
    	actions.retornarInicio();
    	actions.pesquisaProduto("Notebook", "Notebook Dell Inspiron 3583-u05p Pentium 4gb 500gb 15.6 Linux", "R$ 1.899");
    } 
    
    @Test
    public void testE() throws InterruptedException {
    	
    	LogReport.createTest("Teste: Adicionar produto Robofoot ao carrinho");
    	actions.retornarInicio();
    	actions.pesquisaProduto("Bota Robofoot", "Bota Imobilizadora Robofoot Salvapé Original Seminova Top", "R$ 180");
    	actions.adicionarProdutoCarrinho("Você adicionou ao seu carrinho");
    }
    
    @Test
    public void testF() throws InterruptedException {
    	
    	LogReport.createTest("Teste: Adicionar produto Notebook ao carrinho");
    	actions.retornarInicio();
    	actions.pesquisaProduto("Notebook", "Notebook Dell Inspiron 3583-u05p Pentium 4gb 500gb 15.6 Linux", "R$ 1.899");
    	actions.adicionarProdutoCarrinho("Você adicionou ao seu carrinho");
    }    
    
    @Test
    public void testG() {
    	
    	LogReport.createTest("Teste: Remover produto do carrinho");
    	actions.retornarInicio();
    	actions.removerProdutosCarrinho("O seu carrinho está vazio");
    }
    
    @Test
    public void testH() {
    	
    	LogReport.createTest("Teste: Logout");
    	actions.retornarInicio();
    	actions.logout();
    }
}
