package com.eliasnogueira.workshop.mobile;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

/**
 * Teste para alterar uma pessoa, validando todos os dados durante a acao de alterar
 * 
 * @author Elias Nogueira <elias.nogueira@gmail.com>
 */
public class AlterarPessoaTeste {

    @Test
    public void testeAlterarPessoa() throws MalformedURLException {
        DesiredCapabilities capacidade = new DesiredCapabilities();
        capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");

        // Este teste so executara com a app ja instalada. As propriedades abaixo esperam que a app ja esteja no dispositivo
        capacidade.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.eliasnogueira.workshop");
        capacidade.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "activities.ListActivity");

        AndroidDriver<MobileElement> driver
                = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capacidade);
        WebDriverWait wait = new WebDriverWait(driver, 30);

        // pesquisa a pessoa para alterar
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/search_button")));
        driver.findElement(By.id("android:id/search_button")).click();
        driver.findElement(By.id("android:id/search_src_text")).sendKeys("Claudio");

        // pega o texto do resultado da pesquisa e compara se e a mesma pessoa
        MobileElement item = driver.findElement(By.id("android:id/text1"));
        String texto = item.getText();
        assertEquals("Claudio", texto);

        // clica para alterar
        item.click();

        // altera o nome da pessoa
        MobileElement nomePessoa = driver.findElement(By.id("com.eliasnogueira.workshop:id/txt_nome"));
        nomePessoa.clear();
        nomePessoa.sendKeys("Claudiomir");
        driver.findElement(By.id("com.eliasnogueira.workshop:id/button")).click();

        // pesquisa a pessoa para alterar
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/search_button")));
        driver.findElement(By.id("android:id/search_button")).click();
        driver.findElement(By.id("android:id/search_src_text")).sendKeys("Claudiomir");

        // pega o texto do resultado da pesquisa e compara se e a mesma pessoa
        item = driver.findElement(By.id("android:id/text1"));
        texto = item.getText();
        assertEquals("Claudiomir", texto);

        driver.quit();
    }

}
