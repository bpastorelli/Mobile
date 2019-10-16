package br.com.mobile.tests;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

import com.microsoft.appcenter.appium.Factory;

import br.com.mobile.regression.BaseTestCase;

//@RunWith(Cucumber.class)
//@CucumberOptions(features = {"Mobile/src/test/resources/features/Mobile.feature"}, 
//glue = { "br.com.mobile.stepDefinition" }, 
//plugin = {"html:target/cucumber-html-report","json:target/cucumber.json"},
//format = {"pretty", "html:target/reports/cucumber/html",
//        "json:target/cucumber.json", "usage:target/usage.jsonx", "junit:target/junit.xml"}
//		,tags = {"@mobile"})

//@ContextConfiguration(classes= AppConfiguration.class)
public class MobileTests extends BaseTestCase {

    @Rule
    public TestWatcher watcher = Factory.createWatcher();
    
    @Test
    public void testA() {
    	
    	
    }
	
}
