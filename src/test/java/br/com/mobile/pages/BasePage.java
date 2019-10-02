package br.com.mobile.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import br.com.mobile.commons.Property;
import br.com.mobile.commons.SetupEnviroment;
import br.com.mobile.reports.LogReport;
import br.com.mobile.utils.Utils;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage extends SetupEnviroment {

	private static WebElement element;

	private static Map<String, By> mapElements = new HashMap<String, By>();

	/**
	 * Adiciona um elemento mapeado ao mapa de elementos.
	 * 
	 * @param name Nome que será atribuido ao elemento.
	 * @param by   Condição de busca Id, Name e etc.
	 */
	public void addElement(String name, By by) {

		mapElements.put(name, by);
	}

	/**
	 * Busca um elemento dentro do mapElements
	 * 
	 * @param name Nome do elemento no mapa
	 * @return WebElemento
	 */
	protected WebElement getElement(String name) {

		By obj = null;
		element = null;
		try {
			obj = getMap(name);
			element = driver.findElement(obj);
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
	private By getMap(String key) {

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
	protected WebElement findElement(By by) {

		element = null;
		try {
			element = driver.findElement(by);
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
	protected void clickElementByMapElements(String name) {

		try {
			element = getElement(name);
			waitDisplayed(element, Property.TIMEOUT);
			element.click();
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
	protected void clickElement(By by) {

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
	protected void moveToElementClick(String name) {

		try {
			element = getElement(name);
			waitDisplayed(element, Property.TIMEOUT);
			new Actions(driver).moveToElement(element).click().perform();
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
	public static boolean waitDisplayed(WebElement elemento, int time) {

		boolean retorno = false;
		for (int i = 0; i < time; i++) {
			if (!elemento.isDisplayed())
				Utils.wait(1);
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
	public static boolean waitTextElement(WebElement elemento, String texto) {

		// Aguarda por determinado texto por ate o tempo informado na vari�vel time.
		boolean retorno = false;
		for (int i = 0; i < Property.TIMEOUT; i++) {
			if (!elemento.getText().contains(texto))
				Utils.wait(1);
			else
				return true;
		}

		if (!retorno)
			LogReport.fail("[FALHA]Elemento " + elemento + " nao encontrado (Timeout = " + Property.TIMEOUT + ").");
		return retorno;
	}

	public static boolean waitText(String text) {

		boolean retorno = false;
		for (int i = 0; i < Property.TIMEOUT; i++) {

			if (!driver.getPageSource().contains(text))
				Utils.wait(1);
			else
				return true;
		}

		if (!retorno)
			LogReport.fail("[FALHA]Texto esperado na página " + text + " nao apresntado (Timeout = " + Property.TIMEOUT
					+ ").");
		return retorno;
	}
	
	public void toucheActionLeft() {
		
		try {
			
			Dimension size = driver.manage().window().getSize();
			int startx = (int)(size.width * 0.9D);
			int endx = (int)(size.width * 0.1D);
			int starty = size.height / 2;
			
			@SuppressWarnings("rawtypes")
			TouchAction<?> action = new TouchAction(driver);
			action.press(PointOption.point(startx, starty)).moveTo(PointOption.point(endx, starty)).release().perform();
		}catch(Exception e) {
			
			LogReport.fail("[FALHA]Falha ao deslizar a tela para esquerda (" + e.getMessage() + ")");
		}
	}

}
