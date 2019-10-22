package br.com.mobile.implementations;

import static org.junit.Assert.assertFalse;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import br.com.mobile.commons.Property;
import br.com.mobile.interfaces.BasePage;
import br.com.mobile.reports.LogReport;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public abstract class BasePageAppCenter extends SetupAndroidAppCenter implements BasePage {

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
			assertFalse(e.getMessage(), true);
		}

		return element;
	}

	/**
	 * Busca o mapeamento de um elemento a partir do key informado no mapa de
	 * elementos.
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
			assertFalse("[FALHA]Elemento " + by.toString() + " nao encontrado.", true);
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
		} catch (Exception e) {
			assertFalse("[FALHA]Falha ao clicar no elemento " + element.getTagName() + ".", true);
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
			assertFalse("[FALHA]Falha ao clicar no elemento " + by.toString() + ".", true);
		}
	}
	
	/**
	 * Clica no elemento a partir do By.
	 * 
	 * @param element Elemento a ser clicado
	 */
	@Override
	public void clickElement(MobileElement element) {

		try {
			waitDisplayed(element, Property.TIMEOUT);
			element.click();
		} catch (Exception e) {
			assertFalse("[FALHA]Falha ao clicar no elemento " + element.getText() + ".", true);
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
		} catch (Exception e) {
			assertFalse("[FALHA]Falha ao clicar no elemento " + element.getTagName() + ".", true);
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
			assertFalse("[FALHA]Elemento " + elemento + " nao encontrado (Timeout = " + time + ").", true);
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

		boolean retorno = false;
		for (int i = 0; i < Property.TIMEOUT; i++) {
			if (!elemento.getText().contains(texto))
				wait(1);
			else
				return true;
		}

		if (!retorno)
			assertFalse("[FALHA]Elemento " + elemento + " nao encontrado (Timeout = " + Property.TIMEOUT + ").", true);
		return retorno;
	}

	@Override
	public boolean waitText(String text, Integer time) {
		
		boolean retorno = false;
		Integer aguardar = time == 0 ? Property.TIMEOUT : time; 
		
		for (int i = 0; i < aguardar; i++) {

			if (!getDriver().getPageSource().contains(text))
				wait(1);
			else
				return true;
		}

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

		return waitText(text, 5);
	}

	/**
	 * Desliza a tela para a esquerda.
	 */
	@Override
	public void touchActionLeft() {

		try {

			Dimension size = driver.manage().window().getSize();
			int startx = (int) (size.width * 0.9D);
			int endx = (int) (size.width * 0.1D);
			int starty = size.height / 2;
			scroll(startx, starty, endx, starty);
		} catch (Exception e) {
			assertFalse("[FALHA]Falha ao deslizar a tela para esquerda (" + e.getMessage() + ")", true);
		}
	}

	/**
	 * Deslizar a tela para a direita.
	 */
	@Override
	public void touchActionRight() {

		try {

			Dimension size = driver.manage().window().getSize();
			int startx = (int) (size.width * 0.1D);
			int endx = (int) (size.width * 0.9D);
			int starty = size.height / 2;
			scroll(startx, starty, endx, starty);
		} catch (Exception e) {
			assertFalse("[FALHA]Falha ao deslizar a tela para esquerda (" + e.getMessage() + ")", true);
		}
	}
	
	/**
	 * Desliza para a direita por n quantidade de vezes
	 */
	@Override
	public void touchActionRight(Integer qtde) {
		
		for (int i = 0; i < qtde; i++) {
			touchActionRight();
		}
	}

	/**
	 * Deslizar a tela para cima.
	 */
	@Override
	public void touchActionTop() {

		try {

			int pressX = getDriver().manage().window().getSize().width / 2;
			int bottomY = getDriver().manage().window().getSize().height / 8;
			int topY = getDriver().manage().window().getSize().height * 4 / 5;
			scroll(pressX, bottomY, pressX, topY);
		} catch (Exception e) {

			assertFalse("[FALHA]Falha ao deslizar a tela para cima (" + e.getMessage() + ")", true);
		}
	}

	/**
	 * Deslizar a tela para cima N vezes.
	 * @param qtde Quantidade de vezes a deslizar para cima
	 */
	@Override
	public void touchActionTop(int qtde) {

		for (int i = 0; i < qtde; i++) {

			touchActionTop();
		}
	}

	/**
	 * Deslizar para baixo.
	 */
	@Override
	public void touchActionDown() {

		try {

			int pressX = getDriver().manage().window().getSize().width / 2;
			int bottomY = getDriver().manage().window().getSize().height * 4 / 5;
			int topY = getDriver().manage().window().getSize().height / 8;
			scroll(pressX, bottomY, pressX, topY);
		} catch (Exception e) {

			assertFalse("[FALHA]Falha ao deslizar a tela para cima (" + e.getMessage() + ")", true);
		}
	}

	/**
	 * Deslizar para N vezes
	 * @param qtde Quantidade de vezes a deslizar.
	 */
	@Override
	public void touchActionDown(int qtde) {

		for (int i = 0; i < qtde; i++) {

			touchActionDown();
		}
	}

	/**
	 * Método de scroll da tela.
	 */
	@Override
	public void scroll(int fromX, int fromY, int toX, int toY) {

		@SuppressWarnings("rawtypes")
		TouchAction<?> touchAction = new TouchAction(driver);
		touchAction.longPress(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release().perform();
	}

	@Override
	public void wait(int segundos) {

		try {
			synchronized (getDriver()) {
				getDriver().wait(segundos * 1000);
			}
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void setText(String name, String text) {

		try {
			element = getElement(name);
			waitDisplayed(element, Property.TIMEOUT);
			element.sendKeys(text);
		} catch (Exception e) {
			assertFalse("[FALHA]Falha ao enviar texto para o campo " + name + ".", true);
		}
	}
	
	@Override
	public void touchActionTopDisplayed(String name) {

		for (int i = 0; i < Property.TIMEOUT; i++) {
			if (!elementIsDisplayed(name))
				touchActionTop();
			else
				return;
		}
	}

	@Override
	public void touchActionDownDisplayed(String name) {

		for (int i = 0; i < Property.TIMEOUT; i++) {
			if (!elementIsDisplayed(name))
				touchActionDown();
			else
				return;
		}
	}
	
	@Override
	public void touchActionDownDisplayed(MobileElement element) {

		for (int i = 0; i < Property.TIMEOUT; i++) {
			if (!element.isDisplayed())
				touchActionDown();
			else
				return;
		}
	}
	
	@Override
	public void touchActionTopDisplayed(MobileElement element) {

		for (int i = 0; i < Property.TIMEOUT; i++) {
			if (!element.isDisplayed())
				touchActionTop();
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
		} catch (Exception e) {

			return false;
		}
	}
	
	@Override
	public boolean elementIsDisplayed(String name) {
		
		By obj = null;

		try {
			obj = getMap(name);
			element = getDriver().findElement(obj);
			if(element.isDisplayed())
				return true;
			else
				return false;
		} catch (Exception e) {

			return false;
		}		
	}

	@Override
	public void touchActionLeftDisplayed(String name, String message) {

		for (int i = 0; i < Property.TIMEOUT; i++) {
			if (!elementIsPresent(name)) {
				touchActionLeft();
				LogReport.info(message);
			} else
				return;
		}
	}

	@Override
	public void touchActionRightDisplayed(String name, String message) {

		for (int i = 0; i < Property.TIMEOUT; i++) {
			if (!elementIsPresent(name)) {
				touchActionRight();
				LogReport.info(message);
			} else
				return;
		}
	}

	@Override
	public void touchActionLeftTextDisplayed(String text, String message) {

		for (int i = 0; i < Property.TIMEOUT; i++) {
			if (!textIsPresent(text)) {
				touchActionLeft();
			} else
				return;
		}
	}

	@Override
	public void touchActionRightTextDisplayed(String text, String message) {

		for (int i = 0; i < Property.TIMEOUT; i++) {
			if (!textIsPresent(text)) {
				touchActionRight();
			} else
				return;
		}
	}

	@Override
	public boolean textIsPresent(String text) {

		if (!getDriver().getPageSource().contains(text))
			return false;
		else
			return true;
	}

	@Override
	public void alert(Boolean option) {
		
		if(option)
			getDriver().switchTo().alert().accept();
		else 
			getDriver().switchTo().alert().dismiss();
		
	}

	@Override
	public void pressKey(int key) {
		
	     Robot robot;
	     try {
	         robot = new Robot();
	          robot.keyPress(key);
	          robot.keyRelease(key);
	     } catch (AWTException e) {
	         e.printStackTrace();
	     }
	}

	@Override
	public List<MobileElement> getListElements(String name) {
		
		By obj = null;
		List<MobileElement> elements = null;
		
		try {
			obj = getMap(name);
			elements = getDriver().findElements(obj);
		} catch (Exception e) {
			assertFalse("[FALHA]Elemento " + obj.toString() + " nao encontrado.", true);
		}

		return elements;
	}

	@Override
	public void selectItemList(String name, String text) {
		
		List<MobileElement> elements = getListElements(name);
		
		for(MobileElement e : elements) {
			if(e.getText().toLowerCase().contains(text.toLowerCase())) {
				touchActionDownDisplayed(e);
				clickElement(e);
				return;
			}
		}
	}

	@Override
	public void touchActionDownTextDisplayed(String text, String mensagem) {
		
		for (int i = 0; i < Property.TIMEOUT; i++) {
			if (!textIsPresent(text)) {
				touchActionDown();
			} else {
				return;
			}
		}
	}
	
	@Override
	public void clickByText(String text, String name) {
		
		clickByText(text, name, 5);
	}

	@Override
	public void clickByText(String text, String name, Integer time) {
		
		boolean presence = false; 
		int timeOut = time != Property.TIMEOUT ? time : Property.TIMEOUT;
		
		int i = 0;
		do {
			i++;
			wait(1);
			if(textIsPresent(text)) {
				clickElementByMapElements(name);
				if(!textIsPresent(text)) {					
					presence = true;
				}
			}
		}while(!presence && i < timeOut);
	}

}
