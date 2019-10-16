package br.com.mobile.tests;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

import com.microsoft.appcenter.appium.Factory;

import br.com.mobile.actions.ActionsLogar;
import br.com.mobile.regression.BaseTestCase;


public class MobileTests extends BaseTestCase {

    @Rule
    public TestWatcher watcher = Factory.createWatcher();
    
    private ActionsLogar actionsLogar = new ActionsLogar();
    
    @Test
    public void testA() {
    	
    	actionsLogar.logar();
    	
    }
	
}
