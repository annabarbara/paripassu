package com.paripassu.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Espera {
	private WebDriver driver;
	private WebDriverWait wait;
	
	Espera(WebDriver webDriver){
		driver = webDriver;
		this.wait = new WebDriverWait(driver, 10);
	}
	
	 protected void waitForLoad() {
		 final boolean paginaCarregada = ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
		 final boolean jsCarregado = ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active")) == 0;
		    ExpectedCondition<Boolean> pageLoadCondition = new
		        ExpectedCondition<Boolean>() {
		            public Boolean apply(WebDriver driver) {
		                return (paginaCarregada && jsCarregado);
		            }
		        };
		    wait.until(pageLoadCondition);
		}
	 
	 	public boolean isElementPresent(By element) {
		 	   try {
		 	 //      driver.(element);
		 		  wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		 	       return true;
		 	   } catch (NoSuchElementException|TimeoutException e) {
		 	       return false;
		 	   }
		 	}	 	
	}	
