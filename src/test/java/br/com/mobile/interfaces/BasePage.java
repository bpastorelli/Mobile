package br.com.mobile.interfaces;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;

public interface BasePage {
	
	/**
	 * Adiciona um elemento mapeado ao mapa de elementos.
	 * 
	 * @param name Nome que será atribuido ao elemento.
	 * @param by   Condição de busca Id, Name e etc.
	 */
	void addElement(String name, By by);
	
	/**
	 * Busca um elemento dentro do mapElements
	 * 
	 * @param name Nome do elemento no mapa
	 * @return WebElemento
	 */
	WebElement getElement(String name);
	
	/**
	 * Busca o mapeamento de um elemento a partir do key informado no mapa de elementos.
	 * 
	 * @param key
	 * @return By
	 */
	By getMap(String key);
	
	/**
	 * Busca elemento pelo By (name, id, xpath...)
	 * 
	 * @param by By.Id, By.Name, By.Xpath...
	 * @return WebElement
	 */
	WebElement findElement(By by);
	
	/**
	 * Clica um elemento pelo nome informado no mapElements
	 * 
	 * @param name Nome do elemento
	 */
	void clickElementByMapElements(String name);
	
	/**
	 * Clica no elemento a partir do By.
	 * 
	 * @param by Id, Name, Xpath...
	 */
	void clickElement(By by);
	
	/**
	 * Clica no elemento.
	 * 
	 * @param element Elemento
	 */
	void clickElement(MobileElement element);
	
	/**
	 * Move o mouse para o elemento e clica.
	 * 
	 * @param name nome do elemento no mapa de elementos.
	 */
	void moveToElementClick(String name);
	
	/**
	 * Aguarda o elemento visível
	 * 
	 * @param elemento Elemento a ser aguardado
	 * @param time     Tempo limite de espera
	 * @return Retorna true caso esteja visível ou false caso não esteja visível.
	 */
	boolean waitDisplayed(WebElement elemento, int time);
	
	/**
	 * Aguarda um determinado texto ser aprensentado na tela.
	 * 
	 * @param elemento Elemento que contém o texto esperado.
	 * @param texto    Texto a ser apresentado.
	 * @param time     Tempo limite de espera.
	 * @return Retorna true caso o texto esteja presente e false caso não esteja
	 *         presente.
	 */
	boolean waitTextElement(WebElement elemento, String texto);
	
	/**
	 * Aguarda um determinado texto na página independente do elemento.
	 * 
	 * @param text Texto a ser esperado
	 * @return Boolean
	 */
	boolean waitText(String text);
	
	/**
	 * Aguarda um determinado texto na página independente do elemento.
	 * 
	 * @param text Texto a ser aguardado
	 * @time Tempo de espera
	 * @return Boolean
	 */	
	boolean waitText(String text, Integer time);
	
	/**
	 * Desliza a tela para a esquerda.
	 */
	void touchActionLeft();
	
	/**
	 * Desliza a tela para a direita.
	 */
	void touchActionRight();
	
	/**
	 * Desliza a tela para cima.
	 */	
	void touchActionTop();
	
	/**
	 * Desliza a tela para cima por determinadas vezes.
	 * 
	 * @param qtde Quantidades de vezes a deslizar a tela para cima.
	 */
	void touchActionTop(int qtde);
	
	/**
	 * Desliza a tela para baixo.
	 */
	void touchActionDown();
	
	/**
	 * Desliza a tela para baixo por determinadas vezes.
	 * 
	 * @param qtde Quantidades de vezes a deslizar a tela para baixo.
	 */
	void touchActionDown(int qtde);
	
	/**
	 * Aguarda até o tempo informado de segundos.
	 * 
	 * @param segundos
	 */
	void wait(int segundos);
	
	/**
	 * Digitar um texto
	 * 
	 * @param text Texto
	 */
	void setText(String name, String text);
	
	/**
	 * Desliza para cima até que o elemento esteja visivel.
	 * @param name Nome do elemento mapeado no mapa de elementos
	 */	
	void touchActionTopDisplayed(String name);
	
	/**
	 * Desliza para baixo até que o elemento esteja visivel.
	 * @param name Nome do elemento mapeado no mapa de elementos
	 */
	void touchActionDownDisplayed(String name);
	
	/**
	 * Desliza para baixo até que o elemento esteja visivel.
	 * @param element Elemento
	 */
	void touchActionDownDisplayed(MobileElement element);
	
	/**
	 * Desliza para a esquerda até que o elemento esteja visível.
	 * @param name Nome do elemento mapeado no mapa de elementos.
	 * @message Mensagem e evidência gerada após deslizar a tela.
	 */
	void touchActionLeftDisplayed(String name, String message);
	
	/**
	 * Desliza para a direita até que o elemento esteja visível
	 * @param name Nome do elemento mapeado no mapa de elementos.
	 * @message Mensagem e evidência gerada após deslizar a tela.
	 */
	void touchActionRightDisplayed(String name, String message);
	
	/**
	 * Desliza para a esquerda até que o texto esteja visível.
	 * @param texto Texto esperado.
	 * @message Mensagem e evidência gerada após deslizar a tela.
	 */
	void touchActionLeftTextDisplayed(String text, String message);
	
	/**
	 * Desliza para a direita até que o texto esteja visível.
	 * @param texto Texto esperado.
	 * @message Mensagem e evidência gerada após deslizar a tela.
	 */
	void touchActionRightTextDisplayed(String text, String message);
	
	/**
	 * Desliza para baixo até que o texto esteja visível.
	 * @param texto Texto esperado.
	 * @message Mensagem e evidência gerada após deslizar a tela.
	 */
	void touchActionDownTextDisplayed(String text, String message);
	
	/**
	 * Verifica se o elemento está presente
	 * @param name Nome do elemento mapeado no mapa de elementos
	 */
	boolean elementIsPresent(String name);
	
	/**
	 * Verifica se o texto está presente
	 * @param text Texto esperado
	 * @return Boolean
	 */
	boolean textIsPresent(String text);
	
	/**
	 * Scroll da Tela
	 * 
	 * @param fromX De X
	 * @param fromY De Y
	 * @param toX Para X
	 * @param toY Para Y
	 */
	void scroll(int fromX, int fromY, int toX, int toY);
	
	/**
	 * Clica nos popus
	 * @param option True aceitar e False recusar
	 */
	void alert(Boolean option);
	
	/**
	 * Pressiona uma tecla
	 * @param key Tecla a ser clicada
	 */
	void pressKey(int key);
	
	/**
	 * Lista elementos a partir de uma classe css
	 * @param name Nome do elemento mapeado no mapa de elementos
	 * @return List<MobileElement> 
	 */
	List<MobileElement> getListElements(String name);
	
	/**
	 * Seleciona item em uma lista suspensa
	 * @param name Nome do elemento mapeado na lista de elementos
	 * @param text Texto a ser selecionado
	 */
	void selectItemList(String name, String text);

}
