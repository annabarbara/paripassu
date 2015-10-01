package com.paripassu.webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Questao{
	private WebDriver driver;
	private WebDriverWait wait;
	
	Questao(WebDriver webDriver){
		driver = webDriver;
		this.wait = new WebDriverWait(driver, 10);
	}
	
	protected void criarQuestoes(int qtd){
	 	WebElement questao = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".item-origem")));	
	 	questao.click();
	 	if (qtd>1){
	 		for (int i = 2; i<=qtd; i++){
	 			adicionarMaisQuestoes();
	 		}
	 	}
	}
	
	protected void editarNomeQuestoes(List<String> nomesQuestoes){
		this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("panel-heading")));
	 	for (int i=0; i<nomesQuestoes.size(); i++){
	 		editarNomeQuestao(i, nomesQuestoes.get(i));
	 	}
	}
	
	private void editarNomeQuestao(int ordem, String nomeQuestao){
	 	WebElement questaoAberta = driver.findElement(By.cssSelector("#listContent  .panel:nth-child("+(ordem+2)+") > div"));
	 	questaoAberta.click();
	 	WebElement questaoEdit = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea.form-control")));
	 	questaoEdit.clear();
	 	questaoEdit.sendKeys(nomeQuestao);
	 	WebElement salvarQuestao = driver.findElement(By.cssSelector("#panelForm .btn-primary"));
	 	salvarQuestao.click();		
	}
	
	protected void responderQuestoes(List<String> respostasQuestoes){
		this.wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h4.text-primary")));
	 	for (int i=0; i<respostasQuestoes.size(); i++){
	 		responderQuestao(i, respostasQuestoes.get(i));
	 	}
	}
	
	private void responderQuestao(int ordem, String respostaQuestao){
	 	WebElement questao = driver.findElement(By.cssSelector(".ng-scope:nth-child("+(ordem+3)+") .form-control"));
	 	questao.sendKeys(respostaQuestao);
	}
	
	private void adicionarMaisQuestoes(){
	 	WebElement adicionar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button:nth-of-type(3)")));
	 	adicionar.click();
	}
}
