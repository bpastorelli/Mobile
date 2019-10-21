package br.com.mobile.tests;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

import com.microsoft.appcenter.appium.Factory;

import br.com.mobile.actions.ActionsLogar;
import br.com.mobile.actions.ActionsMenu;
import br.com.mobile.actions.ActionsPesquisa;
import br.com.mobile.regression.BaseTestCase;


public class MobileTests extends BaseTestCase {

    @Rule
    public TestWatcher watcher = Factory.createWatcher();
    
    private ActionsMenu actionsMenu = new ActionsMenu();
    
    private ActionsLogar actionsLogar = new ActionsLogar();
    
    private ActionsPesquisa actionsPesquisa = new ActionsPesquisa();
    
    @Test
    public void testeA() {
    	
    	actionsLogar.logar();
    }
    
    @Test
    public void testeB() {
    	
    	actionsPesquisa.pesquisaProduto("Bota Robofoot", "Robofoot Salvapé Original Seminova Top", "R$ 180");
    }
    
    @Test
    public void testeC() {
    	
    	actionsPesquisa.novaPesquisaProduto("Notebook", "Notebook Dell Inspiron 3583-u05p Pentium 4gb 500gb 15.6 Linux", "R$ 1.749");
    }
    
    @Test
    public void testeD() {
    	
    	actionsPesquisa.novaPesquisaProduto("Bota Robofoot", "Robofoot Salvapé Original Seminova Top", "R$ 180");
    	actionsPesquisa.adicionarProdutoCarrinho("Você adicionou ao seu carrinho");
    }
    
    @Test
    public void testeE() {
    
    	actionsPesquisa.removerProdutoCarrinho();
    }
}
