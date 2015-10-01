package com.paripassu.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Identificacao {
	
	Identificacao(WebDriver driver, String nome, String senha){
	 	WebDriverWait wait = new WebDriverWait(driver, 10);
	 	WebElement inputUsuario = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("inputUsuario")));
	 	inputUsuario.sendKeys(nome);
        WebElement inputPassword = driver.findElement(By.id("inputPassword"));
        inputPassword.sendKeys(senha);        
        wait.until(ExpectedConditions.textToBePresentInElementValue(inputPassword, senha));
        inputPassword.submit();
	}
}
