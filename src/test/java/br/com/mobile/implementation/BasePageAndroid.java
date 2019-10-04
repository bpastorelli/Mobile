package br.com.mobile.implementation;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;

import br.com.mobile.commons.Property;
import br.com.mobile.interfaces.BasePage;
import br.com.mobile.reports.LogReport;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class BasePageAndroid extends SetupAndroid implements BasePage{

	private static WebElement element;

	private static Map<String, By> mapElements = new HashMap<String, By>();

	/**
	 * Adiciona um elemento mapeado ao mapa de elementos.
	 * 
	 * @param name Nome que será atribuido ao elemento.
	 * @param by   Condição de busca Id, Name e etc.
	 */
	@Override
	public void addElement(String name, By by) {

		mapElements.put(name, by);
	}

	/**
	 * Busca um elemento dentro do mapElements
	 * 
	 * @param name Nome do elemento no mapa
	 * @return WebElemento
	 */
	@Override
	public WebElement getElement(String name) {

		By obj = null;
		element = null;
		try {
			obj = getMap(name);
			element = getDriver().findElement(obj);
		} catch (Exception e) {
			LogReport.fail(e.getMessage());
		}

		return element;
	}
	
	/**
	 * Busca o mapeamento de um elemento a partir do key informado no mapa de elementos.
	 * 
	 * @param key
	 * @return By
	 */
	@Override
	public By getMap(String key) {

		By obj = null;

		if (key != null && key != "") {
			return mapElements.get(key);
		}

		return obj;
	}

	/**
	 * Busca elemento pelo By (name, id, xpath...)
	 * 
	 * @param by By.Id, By.Name, By.Xpath...
	 * @return WebElement
	 */
	@Override
	public WebElement findElement(By by) {

		element = null;
		try {
			element = getDriver().findElement(by);
		} catch (Exception e) {
			LogReport.fail("[FALHA]Elemento " + by.toString() + " nao encontrado.");
		}

		return element;
	}

	/**
	 * Clica um elemento pelo nome informado no mapElements
	 * 
	 * @param name Nome do elemento
	 */
	@Override
	public void clickElementByMapElements(String name) {

		try {
			element = getElement(name);
			waitDisplayed(element, Property.TIMEOUT);
			element.click();
			wait(3);
			LogReport.info("Clicar no elemento " + name);
		} catch (Exception e) {
			LogReport.fail("[FALHA]Falha ao clicar no elemento " + element.getTagName() + ".");
		}
	}

	/**
	 * Clica no elemento a partir do By.
	 * 
	 * @param by Id, Name, Xpath...
	 */
	@Override
	public void clickElement(By by) {

		element = null;

		try {
			element = findElement(by);
			waitDisplayed(element, Property.TIMEOUT);
			LogReport.info("Clicar no elemento " + by);
		} catch (Exception e) {
			LogReport.fail("[FALHA]Falha ao clicar no elemento " + by.toString() + ".");
		}
	}

	/**
	 * Move o mouse para o elemento e clica.
	 * 
	 * @param name nome do elemento no mapa de elementos.
	 */
	@Override
	public void moveToElementClick(String name) {

		try {
			element = getElement(name);
			waitDisplayed(element, Property.TIMEOUT);
			new Actions(getDriver()).moveToElement(element).click().perform();
			LogReport.info("Mover o foco e clicar no elemento " + name);
		} catch (Exception e) {
			LogReport.fail("[FALHA]Falha ao clicar no elemento " + element.getTagName() + ".");
		}
	}

	/**
	 * Aguarda o elemento visível
	 * 
	 * @param elemento Elemento a ser aguardado
	 * @param time     Tempo limite de espera
	 * @return Retorna true caso esteja visível ou false caso não esteja visível.
	 */
	@Override
	public boolean waitDisplayed(WebElement elemento, int time) {

		boolean retorno = false;
		for (int i = 0; i < time; i++) {
			if (!elemento.isDisplayed())
				wait(1);
			else
				return true;
		}

		if (!retorno)
			LogReport.fail("[FALHA]Elemento " + elemento + " nao encontrado (timeout = " + time + ").");
		return retorno;
	}

	/**
	 * Aguarda um determinado texto ser aprensentado na tela.
	 * 
	 * @param elemento Elemento que contém o texto esperado.
	 * @param texto    Texto a ser apresentado.
	 * @param time     Tempo limite de espera.
	 * @return Retorna true caso o texto esteja presente e false caso não esteja
	 *         presente.
	 */
	@Override
	public boolean waitTextElement(WebElement elemento, String texto) {

		// Aguarda por determinado texto por ate o tempo informado na vari�vel time.
		boolean retorno = false;
		for (int i = 0; i < Property.TIMEOUT; i++) {
			if (!elemento.getText().contains(texto))
				wait(1);
			else
				return true;
		}

		if (!retorno)
			LogReport.fail("[FALHA]Elemento " + elemento + " nao encontrado (Timeout = " + Property.TIMEOUT + ").");
		return retorno;
	}

	/**
	 * Aguarda um determinado texto na página independente do elemento.
	 * 
	 * @param text
	 * @return Boolean
	 */
	@Override
	public boolean waitText(String text) {

		boolean retorno = false;
		for (int i = 0; i < Property.TIMEOUT; i++) {

			if (!getDriver().getPageSource().contains(text))
				wait(1);
			else
				return true;
		}

		if (!retorno)
			LogReport.fail("[FALHA]Texto esperado na página " + text + " nao apresntado (Timeout = " + Property.TIMEOUT
					+ ").");
		return retorno;
	}
	
	/**
	 * Desliza a tela para a esquerda.
	 */
	@Override
	public void toucheActionLeft() {
		
		try {
			
			Dimension size = driver.manage().window().getSize();
			int startx = (int)(size.width * 0.9D);
			int endx = (int)(size.width * 0.1D);
			int starty = size.height / 2;
			
			@SuppressWarnings("rawtypes")
			TouchAction<?> action = new TouchAction(getDriver());
			action.press(PointOption.point(startx, starty)).moveTo(PointOption.point(endx, starty)).release().perform();
		}catch(Exception e) {
			
			LogReport.fail("[FALHA]Falha ao deslizar a tela para esquerda (" + e.getMessage() + ")");
		}
	}

	@Override
	public void toucheActionRight() {
		
		try {
			
			Dimension size = driver.manage().window().getSize();
			int startx = (int)(size.width * 0.1D);
			int endx = (int)(size.width * 0.9D);
			int starty = size.height / 2;
			
			scroll(startx, starty, endx, starty);
			//@SuppressWarnings("rawtypes")
			//TouchAction<?> action = new TouchAction(getDriver());
			//action.press(PointOption.point(startx, starty)).moveTo(PointOption.point(endx, starty)).release().perform();
		}catch(Exception e) {
			
			LogReport.fail("[FALHA]Falha ao deslizar a tela para esquerda (" + e.getMessage() + ")");
		}		
	}	

	@Override
	public void touchActionTop() {
		
		try {
			
			Dimension size = driver.manage().window().getSize();
			int x = (int)(size.width * 0.1D);
			int y = (int)(size.width * 0.9D);
			
			TouchActions action = new TouchActions(getDriver());
			action.up(x, y);
		}catch(Exception e ) {
			
			LogReport.fail("[FALHA]Falha ao deslizar a tela para cima (" + e.getMessage() + ")");
		}		
	}

	@Override
	public void touchActionDown() {
		
		try {
			
		    int pressX = getDriver().manage().window().getSize().width / 2;
		    int bottomY = getDriver().manage().window().getSize().height * 4/5;
		    int topY = getDriver().manage().window().getSize().height / 8;
		    scroll(pressX, bottomY, pressX, topY);
		}catch(Exception e ) {
			
			LogReport.fail("[FALHA]Falha ao deslizar a tela para cima (" + e.getMessage() + ")");
		}	
	}
	
	private void scroll(int fromX, int fromY, int toX, int toY) {
	    
		@SuppressWarnings("rawtypes")
		TouchAction<?> touchAction = new TouchAction(driver);
	    touchAction.longPress(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release().perform();
	}

	@Override
	public void wait(int segundos) {
		
		try {
			synchronized(getDriver()) {
				getDriver().wait(segundos * 1000);
			}
		}catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void setText(String name, String text) {
		
		try {
			element = getElement(name);
			waitDisplayed(element, Property.TIMEOUT);
			element.sendKeys(text);
		}catch(Exception e) {
			LogReport.fail("[FALHA]Falha ao enviar texto para o campo " + name + ".");
		}
	}

	@Override
	public void touchDownDisplayed(String name) {
		
		for(int i = 0; i < Property.TIMEOUT; i++) {
			if(!elementIsPresent(name))
				touchActionDown();
			else
				return;
		}
	}

	@Override
	public boolean elementIsPresent(String name) {
		
		By obj = null;
		
		try {
			
			obj = getMap(name);
			element = getDriver().findElement(obj);
			return true;
		}catch(Exception e) {
			
			return false;
		}
	}
}
