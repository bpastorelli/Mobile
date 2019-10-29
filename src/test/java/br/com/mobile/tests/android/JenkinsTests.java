package br.com.mobile.tests.android;

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
    	actions.logout();
    }
    
    @Test
    public void testB() {
    	
    	LogReport.createTest("Teste: Pesquisa de produto");
    	actions.logar("brunopastorelli@hotmail.com", "sid04197");
    	actions.pesquisaProduto("Bota Robofoot", "Robofoot Salvapé Original Seminova Top", "R$ 180");
    	actions.logout();
    }
    
    @Test
    public void testC() {
    	
    	LogReport.createTest("Teste: Nova pesquisa de produto");
    	actions.logar("brunopastorelli@hotmail.com", "sid04197");
    	actions.pesquisaProduto("Notebook", "Notebook Dell Inspiron 3583-u05p Pentium 4gb 500gb 15.6 Linux", "R$ 1.749");
    	actions.logout();
    } 
    
    @Test
    public void testE() {
    	
    	LogReport.createTest("Teste: Adicionar produto ao carrinho");
    	actions.logar("brunopastorelli@hotmail.com", "sid04197");
    	actions.pesquisaProduto("Bota Robofoot", "Robofoot Salvapé Original Seminova Top", "R$ 180");
    	actions.adicionarProdutoCarrinho("Você adicionou ao seu carrinho");
    	actions.logout();
    }
    
    @Test
    public void testF() {
    	
    	LogReport.createTest("Teste: Adicionar produto ao carrinho");
    	actions.logar("brunopastorelli@hotmail.com", "sid04197");
    	actions.pesquisaProduto("Notebook", "Notebook Dell Inspiron 3583-u05p Pentium 4gb 500gb 15.6 Linux", "R$ 1.749");
    	actions.adicionarProdutoCarrinho("Você adicionou ao seu carrinho");
    	actions.logout();
    }    
    
    @Test
    public void testG() {
    	
    	LogReport.createTest("Teste: Remover produto do carrinho");
    	actions.logar("brunopastorelli@hotmail.com", "sid04197");
    	actions.removerProdutoCarrinho();
    	actions.logout();
    	
    }
}
