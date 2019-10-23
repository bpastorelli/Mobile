package br.com.mobile.tests;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import br.com.mobile.regression.AppConfiguration;
import br.com.mobile.regression.BaseTestCase;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/Mobile.feature"}, 
glue = { "br.com.mobile.stepDefinition" }, 
plugin = {"html:target/cucumber-html-report","json:target/cucumber.json"},
format = {"pretty", "html:target/reports/cucumber/html",
        "json:target/cucumber.json", "usage:target/usage.jsonx", "junit:target/junit.xml"}
		,tags = {"@mobile"})

@ContextConfiguration(classes= AppConfiguration.class)
public class MobileTests extends BaseTestCase {
	
}