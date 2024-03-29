package br.com.mobile.implementations;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import br.com.mobile.commons.Property;
import br.com.mobile.interfaces.BasePage;
import br.com.mobile.reports.LogReport;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class BasePageAndroid extends SetupAndroid implements BasePage {

	private static MobileElement element;

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
	public MobileElement getElement(String name) {
		
		By obj = null;
		element = null;
		for(int i=0; i < Property.TIMEOUT; i++) {			
			try {
				obj = getMap(name);
				element = getDriver().findElement(obj);
				waitDisplayed(element, Property.TIMEOUT);
				return element;
			} catch (Exception e) {}
		}
		
		LogReport.fail("Elemento " + name + " não encontrado");
		
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
	public MobileElement findElement(By by) {

		element = null;
		try {
			element = getDriver().findElement(by);
			waitDisplayed(element, Property.TIMEOUT);
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
			element.click();
			LogReport.info("Clicar no elemento " + name, Property.EVIDENCIAR_STEPS);
		} catch (Exception e) {
			LogReport.fail("[FALHA]Falha ao clicar no elemento " + element.getTagName() + ".");
		}
	}

	/**
	 * Clica no elemento a partir do By.
	 * @param by Id, Name, Xpath...
	 */
	@Override
	public void clickElement(By by) {

		element = null;

		try {
			element = findElement(by);
			LogReport.info("Clicar no elemento " + by, Property.EVIDENCIAR_STEPS);
			element.click();
		} catch (Exception e) {
			LogReport.fail("[FALHA]Falha ao clicar no elemento " + by.toString() + ".");
		}
	}

	/**
	 * Clica no elemento a partir do By.
	 * @param element Elemento a ser clicado
	 */
	@Override
	public void clickElement(MobileElement element) {

		try {
			waitDisplayed(element, Property.TIMEOUT);
			element.click();
		} catch (Exception e) {
			LogReport.fail("[FALHA]Falha ao clicar no elemento " + element.getTagName() + ".");
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
			LogReport.info("Mover o foco e clicar no elemento " + name, Property.EVIDENCIAR_STEPS);
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
			LogReport.fail("[FALHA]Elemento " + elemento + " nao encontrado (Timeout = " + time + ").");
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

		return waitText(text, 0);
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
	 * Desliza a tela para a esquerda.
	 */
	@Override
	public void touchActionLeft() {

		try {

			Dimension size = getDriver().manage().window().getSize();
			int startx = (int) (size.width * 0.9D);
			int endx = (int) (size.width * 0.1D);
			int starty = size.height / 2;
			scroll(startx, starty, endx, starty);
		} catch (Exception e) {

			LogReport.fail("[FALHA]Falha ao deslizar a tela para esquerda (" + e.getMessage() + ")");
		}
	}
	
	@Override
	public void touchActionLeft(Integer qtde) {
		
		for(int i=0; i< qtde; i++) {
			touchActionLeft();
		}
	}

	/**
	 * Deslizar a tela para a direita.
	 */
	@Override
	public void touchActionRight() {

		try {

			Dimension size = getDriver().manage().window().getSize();
			int startx = (int) (size.width * 0.1D);
			int endx = (int) (size.width * 0.9D);
			int starty = size.height / 2;
			scroll(startx, starty, endx, starty);
		} catch (Exception e) {

			LogReport.fail("[FALHA]Falha ao deslizar a tela para esquerda (" + e.getMessage() + ")");
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

			LogReport.fail("[FALHA]Falha ao deslizar a tela para cima (" + e.getMessage() + ")");
		}
	}

	/**
	 * Deslizar a tela para cima N vezes.
	 * 
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

			LogReport.fail("[FALHA]Falha ao deslizar a tela para cima (" + e.getMessage() + ")");
		}
	}

	/**
	 * Deslizar para N vezes
	 * 
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
		TouchAction<?> touchAction = new TouchAction(getDriver());
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
		
		setText(name, text, false);
	}
	
	@Override
	public void setText(String name, String text, Boolean slow) {
		
		try {
			element = getElement(name);
			waitDisplayed(element, Property.TIMEOUT);
			
			if(slow) {				
				for (int i=0; i<text.length(); i++) { 		 
			        char c = text.charAt(i);
			        String s = new StringBuilder().append(c).toString();
			        element.sendKeys(s);
				}
			} else {				
				element.sendKeys(text);
			}
		} catch (Exception e) {
			LogReport.fail("[FALHA]Falha ao enviar texto para o campo " + name + ".");
		}
	}

	@Override
	public void touchActionTopDisplayed(String name) {

		for (int i = 0; i < Property.TIMEOUT; i++) {
			if (!elementIsPresent(name))
				touchActionTop();
			else
				return;
		}
		
		LogReport.fail("Elemento \"" + name + "\" não encontrado.");
	}

	@Override
	public void touchActionDownDisplayed(String name) {

		for (int i = 0; i < Property.TIMEOUT; i++) {
			if (!elementIsPresent(name))
				touchActionDown();
			else
				return;
		}
		
		LogReport.fail("Elemento \"" + name + "\" não encontrado.");
	}

	@Override
	public void touchActionDownDisplayed(MobileElement element) {

		for (int i = 0; i < Property.TIMEOUT; i++) {
			if (!element.isDisplayed())
				touchActionDown();
			else
				return;
		}
		
		LogReport.fail("Elemento não encontrado.");
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
	public void touchActionLeftDisplayed(String name, String message) {

		for (int i = 0; i < Property.TIMEOUT; i++) {
			if (!elementIsPresent(name)) {
				touchActionLeft();
			} else {
				LogReport.info(message, Property.EVIDENCIAR_STEPS);				
				return;
			}
		}
		
		LogReport.fail("Elemento \"" + name + "\" não encontrado.");
	}

	@Override
	public void touchActionRightDisplayed(String name, String message) {

		for (int i = 0; i < Property.TIMEOUT; i++) {
			if (!elementIsPresent(name)) {
				touchActionRight();
			} else {
				LogReport.info(message, Property.EVIDENCIAR_STEPS);
				return;
			}
		}
		
		LogReport.fail("Elemento \"" + name + "\" não encontrado.");
	}

	@Override
	public void touchActionLeftTextDisplayed(String text, String message) {

		for (int i = 0; i < Property.TIMEOUT; i++) {
			if (!textIsPresent(text)) {
				touchActionLeft();
			} else {				
				LogReport.info(message, Property.EVIDENCIAR_STEPS);
				return;
			}
		}
		
		LogReport.fail("Produto \"" + text + "\" não encontrado.");
	}
	
	@Override
	public void touchActionTopTextDisplayed(String text, String message) {

		for (int i = 0; i < Property.TIMEOUT; i++) {
			if (!textIsPresent(text)) {
				touchActionTop();
			} else {
				LogReport.info(message, Property.EVIDENCIAR_STEPS);				
				return;
			}
		}
		
		LogReport.fail("Produto \"" + text + "\" não encontrado.");
	}

	@Override
	public void touchActionRightTextDisplayed(String text, String message) {

		for (int i = 0; i < Property.TIMEOUT; i++) {
			if (!textIsPresent(text)) {
				touchActionRight();
				LogReport.info(message, Property.EVIDENCIAR_STEPS);
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

		if (option)
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
			LogReport.fail("[FALHA]Elemento " + obj.toString() + " nao encontrado.");
		}

		return elements;
	}

	@Override
	public void selectItemList(String name, String text) {

		List<MobileElement> elements = getListElements(name);	
		
        element = elements.stream()
                .filter(x -> text.toLowerCase().equals(x.getText().trim().toLowerCase()))
                .findAny()
                .orElse(null);
        
        if(!element.equals(null)) {        	
        	touchActionDownDisplayed(element);
        	clickElement(element);
        	LogReport.info("Selecionado o item " + text, Property.EVIDENCIAR_STEPS);        
        }else {
        	LogReport.fail("Elemento " + name + " não encontrado.");
        }
	}

	@Override
	public void touchActionDownTextDisplayed(String text, String message) {

		for (int i = 0; i < Property.TIMEOUT; i++) {
			if (!textIsPresent(text)) {
				touchActionDown();
			} else {
				LogReport.info(message, Property.EVIDENCIAR_STEPS);
				return;
			}
		}
		
		LogReport.fail("Produto \"" + text + "\" não encontrado.");
	}

	@Override
	public void touchActionRight(Integer qtde) {

		for (int i = 0; i < qtde; i++) {
			touchActionRight();
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
		
		LogReport.fail("Produto não encontrado.");
	}

	@Override
	public boolean elementIsDisplayed(String name) {

		By obj = null;

		try {
			obj = getMap(name);
			element = getDriver().findElement(obj);
			if (element.isDisplayed())
				return true;
			else
				return false;
		} catch (Exception e) {

			return false;
		}
	}

	@Override
	public void clickByText(String text, String name) {

		clickByText(text, name, Property.TIMEOUT);
	}

	@Override
	public void clickByText(String text, String name, Integer time) {

		boolean presence = false;
		int timeOut = time != Property.TIMEOUT ? time : Property.TIMEOUT;

		int i = 0;
		do {
			i++;
			wait(1);
			if (textIsPresent(text)) {
				clickElementByMapElements(name);
				if (!textIsPresent(text)) {
					presence = true;
				}
			}
		} while (!presence && i < timeOut);
	}

	@Override
	public void sendKeys(Keys key) {

		Actions action = new Actions(driver);
		action.sendKeys().sendKeys(key).build().perform();
	}

	@Override
	public void returnUntilTextDisplayed(String text) {

		for (int i = 0; i < Property.TIMEOUT; i++) {
			waitText(text, 1);
			if (textIsPresent(text)) {
				return;
			}
			getDriver().navigate().back();
		}

	}
}
