package br.com.mobile.tests.appcenter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

import com.microsoft.appcenter.appium.Factory;

import br.com.mobile.actions.appcenter.ActionsAppCenter;
import br.com.mobile.regression.BaseTestCase;

public class AppCenterTests extends BaseTestCase {

    @Rule
    public TestWatcher watcher = Factory.createWatcher();
    
    private ActionsAppCenter actionsAppCenter = new ActionsAppCenter();
    
    @Test
    public void testA() {
    	
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
