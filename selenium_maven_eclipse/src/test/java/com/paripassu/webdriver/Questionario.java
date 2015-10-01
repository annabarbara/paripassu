package com.paripassu.webdriver;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Questionario {
	private WebDriver driver;
	private Questao questao;
	private WebDriverWait wait;
	Espera espera;
	
	Questionario(WebDriver driver){
		this.driver = driver;
		this.questao = new Questao(this.driver);
		this.wait = new WebDriverWait(driver, 10);
		this.espera = new Espera(this.driver);
	}

	 protected void cadastrarQuestionario(List<String> nomesQuestoes) throws InterruptedException{
		 	// acessar a p�gina de question�rios
		 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("inputPassword")));
		 	WebElement questionarios = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Questionarios")));
		 	questionarios.click();
		 	WebElement novoQuestionario = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Novo question�rio")));
		 	novoQuestionario.click();
		 	espera.waitForLoad();
		   if(espera.isElementPresent(By.tagName("select"))){
			   // Selecionar modo "avaliado" e seguir em frente
			   Select seletor = new Select(driver.findElement(By.tagName("select")));
			   seletor.selectByVisibleText("Avaliado");
			   WebElement proximo = driver.findElement(By.linkText("Pr�ximo"));
			   proximo.click();
			   // Editar o nome do t�pico
			   WebElement topicoAberto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("panel-heading")));
			   topicoAberto.click();
			   WebElement nomeTopico = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("userTopicName")));
			   nomeTopico.clear();
			   nomeTopico.sendKeys("Analista de Qualidade");
			   WebElement salvar = driver.findElement(By.linkText("Salvar"));
			   salvar.click();
			   // Adicionar mais quest�es
			   int qtdQuestoes = 3;
			   questao.criarQuestoes(qtdQuestoes);
			   // Editar o nome das quest�es
			   questao.editarNomeQuestoes(nomesQuestoes);
		 	// Salvar e finalizar
			   WebElement finalizar = driver.findElement(By.className("btn-success"));
			   finalizar.click();
			   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("th.ng-binding")));
		   }else{
		 		System.out.println("J� existe um question�rio criado. Teste prosseguir� utilizando o mesmo.");
		 		espera.waitForLoad();
		   }
	 }
	
	 protected void aplicarQuestionario(List<String> respostas){
		 // navegar at� nova aplica��o
		 	espera.waitForLoad();
		 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("inputPassword")));
		 	WebElement aplicacoes = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Aplica��o de question�rio")));
		 	aplicacoes.click();
		 	WebElement novaAplicacao = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Nova aplica��o de question�rio")));
		 	novaAplicacao.click();
		 // selecionar o avaliado
		 	Avaliado avaliado = new Avaliado(driver);
		 	avaliado.selecionarAvaliado();
		 // responder as quest�es e salvar
		 	questao.responderQuestoes(respostas);
	        WebElement salvar = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Salvar")));
	        salvar.click();
	 }
}
