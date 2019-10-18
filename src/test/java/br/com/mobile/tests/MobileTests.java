package br.com.mobile.tests;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

import com.microsoft.appcenter.appium.Factory;

import br.com.mobile.actions.ActionsLogar;
import br.com.mobile.actions.ActionsPesquisa;
import br.com.mobile.regression.BaseTestCase;


public class MobileTests extends BaseTestCase {

    @Rule
    public TestWatcher watcher = Factory.createWatcher();
    
    private ActionsLogar actionsLogar = new ActionsLogar();
    
    private ActionsPesquisa actionsPesquisa = new ActionsPesquisa();
    
    @Test
    public void testeA() {
    	
    	actionsLogar.logar();
    }
    
    @Test
    public void testeB() {
    	
    	actionsPesquisa.pesquisarProduto("Bota Robofoot", "Robofoot Salvapé Original Seminova Top", "R$ 180");
    }
	
}
