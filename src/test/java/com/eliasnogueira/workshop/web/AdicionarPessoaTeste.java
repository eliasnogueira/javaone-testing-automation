package com.eliasnogueira.workshop.web;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdicionarPessoaTeste {

    @Test
    public void testeAdicionarPessoa() {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("http://eliasnogueira.com/tdc/automacao_rwm/workshop");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("adicionar")));
        driver.findElement(By.id("adicionar")).click();
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("voltar")));
        driver.findElement(By.id("nome")).sendKeys("TESTE CADASTRO");
        driver.findElement(By.name("endereco")).sendKeys("SAO PAULO");
        driver.findElement(By.cssSelector("input[ng-model='post.hobbies']")).sendKeys("AUTOMATIZAR");
        driver.findElement(By.cssSelector(".w3-btn.w3-teal")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nome")));
        String dadosPagina = driver.getPageSource();
        assertTrue(dadosPagina.contains("TESTE CADASTRO"));
        assertTrue(dadosPagina.contains("SAO PAULO"));
        assertTrue(dadosPagina.contains("PROGRAMAR"));

        driver.quit();
    }
}
