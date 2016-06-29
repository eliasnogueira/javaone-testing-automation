package com.eliasnogueira.workshop.web;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlterarPessoaTeste {

    @Test
    public void testeAlterarPessoa() {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("http://eliasnogueira.com/tdc/automacao_rwm/workshop");

        // pesquisa a pessoa que sera alterada
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pesquisar")));
        driver.findElement(By.id("pesquisar")).sendKeys("TESTE CADASTRO");

        // esper a pesquisa pelo botao editar
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nome")));

        // validacoes
        assertEquals("TESTE CADASTRO", driver.findElement(By.id("nome")).getText());
        assertEquals("SAO PAULO", driver.findElement(By.id("endereco")).getText());
        assertEquals("AUTOMATIZAR", driver.findElement(By.id("hobbies")).getText());

        // clica em editar
        driver.findElement(By.id("editar")).click();

        // espera por algum campo na tela para garantir que ela está carregada
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("voltar")));
        
        /*
         * cria elementos web (webelement) para efetuar mais de uma ação sem precisar
         * efetuar novamente o driver.findElement....
        */
        WebElement nome = driver.findElement(By.id("nome"));
        WebElement endereco = driver.findElement(By.name("endereco"));
        WebElement hobbies = driver.findElement(By.cssSelector("input[ng-model='post.hobbies']"));

        // altera todos os campos, limpando o campo primeiro e depois digitando o valor
        nome.clear();
        nome.sendKeys("CADASTRO DE TESTE");

        endereco.clear();
        endereco.sendKeys("PORTO ALEGRE");

        hobbies.clear();
        hobbies.sendKeys("TOMAR CHIMARRAO");

        // clica em salvar
        driver.findElement(By.cssSelector(".w3-btn.w3-teal")).click();

        // verifica se os itens alterados
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("editar")));

        // valida se as informacoes estao contidas em algum lugar da pagina
        String conteudoDaPagina = driver.getPageSource();
        assertTrue(conteudoDaPagina.contains("CADASTRO DE TESTE"));
        assertTrue(conteudoDaPagina.contains("PORTO ALEGRE"));
        assertTrue(conteudoDaPagina.contains("TOMAR CHIMARRAO"));

        // fecha o browser
        driver.quit();
    }

}
