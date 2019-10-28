package br.com.mobile.tests.android;

import org.junit.Test;

import br.com.mobile.actions.android.ActionsMobile;
import br.com.mobile.regression.BaseTestCase;
import br.com.mobile.reports.LogReport;

public class JenkinsTests extends BaseTestCase {
    
    private ActionsMobile actionsAppCenter = new ActionsMobile();
    
    @Test
    public void testA() {
    	
    	LogReport.createTest("Iniciando o Teste: ");
    	actionsAppCenter.logar("brunopastorelli@hotmail.com", "sid04197");
    }
    
    @Test
    public void testB() {
    	
    	actionsAppCenter.pesquisaProduto("Bota Robofoot", "Robofoot Salvapé Original Seminova Top", "R$ 180");
    }
    
    @Test
    public void testC() {
    	
    	actionsAppCenter.novaPesquisaProduto("Notebook", "Notebook Dell Inspiron 3583-u05p Pentium 4gb 500gb 15.6 Linux", "R$ 1.749");
    } 
    
    @Test
    public void testE() {
    	
    	actionsAppCenter.novaPesquisaProduto("Bota Robofoot", "Robofoot Salvapé Original Seminova Top", "R$ 180");
    	actionsAppCenter.adicionarProdutoCarrinho("Você adicionou ao seu carrinho");
    }
    
    @Test
    public void testF() {
    
    	actionsAppCenter.removerProdutoCarrinho();
    }
}