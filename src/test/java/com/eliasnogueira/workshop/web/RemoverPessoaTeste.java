package com.eliasnogueira.workshop.web;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RemoverPessoaTeste {

    @Test
    public void testeRemoverPessoa() {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("http://eliasnogueira.com/tdc/workshop");

        // pesquisa a pessoa que sera alterada
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pesquisar")));
        driver.findElement(By.id("pesquisar")).sendKeys("CADASTRO DE TESTE");

        // esper a pesquisa pelo botao editar
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("remover")));

        // clica em editar
        driver.findElement(By.id("remover")).click();

        // como aparece um alerta o Selenium precisa dar um foco nele
        Alert alerta = driver.switchTo().alert();

        // verifica se o texto do alerta e o de remocao
        assertEquals("Deseja realmente remover?", alerta.getText());

        // clica em ok para remover a mensagem (para cancelar usamos a funcao dismiss())
        alerta.accept();

        // verifica que o registro não existe mais na lista (na verdade procura em toda pagina)
        driver.findElement(By.id("pesquisar")).clear();

        // fecha o browser
        driver.quit();
    }

}
