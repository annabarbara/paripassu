package com.paripassu.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Avaliado {
	private WebDriver driver;
	private WebDriverWait wait;
	private Espera espera;
	
	Avaliado(WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 10);
		this.espera = new Espera(driver);
	}
	
	 protected void cadastrarAvaliado(String avaliado) throws InterruptedException{
		 	WebElement avaliados = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Avaliados")));
		 	avaliados.click();
		 	WebElement novoAvaliado = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Novo avaliado")));
		 	novoAvaliado.click();
	        WebElement inputAvaliado = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("avaliadoNome")));
	        inputAvaliado.sendKeys(avaliado);
	        WebElement salvar = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Salvar")));
	        salvar.click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("th.ng-binding")));
	        espera.waitForLoad();
	 }
	 
	 protected void selecionarAvaliado(){
		 	espera.waitForLoad();
		 	WebElement questionarioEscolhido = wait.until(ExpectedConditions.elementToBeClickable(By.className("list-group-item")));
		 	questionarioEscolhido.click();
		 	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[placeholder='Digite para filtrar avaliado']")));
		 	WebElement avaliadoEscolhido = wait.until(ExpectedConditions.elementToBeClickable(By.className("list-group-item")));
		 	avaliadoEscolhido.click();
		 	espera.waitForLoad();
	 }
}
