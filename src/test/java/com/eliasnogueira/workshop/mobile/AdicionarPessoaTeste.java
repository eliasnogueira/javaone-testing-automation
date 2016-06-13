package com.eliasnogueira.workshop.mobile;

import static org.junit.Assert.assertEquals;

import java.io.File;
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
 * Teste para adicionar uma pessoa
 * 
 * @author Elias Nogueira <elias.nogueira@gmail.com>
 */
public class AdicionarPessoaTeste {

    @Test
    public void testeAdicionarPessoa() throws MalformedURLException {

        File app = new File("src/main/resources/app/workshop.apk");

        DesiredCapabilities capacidade = new DesiredCapabilities();
        capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capacidade.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.eliasnogueira.workshop");
        capacidade.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "activities.ListActivity");

        AndroidDriver<MobileElement> driver
                = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capacidade);
        WebDriverWait wait = new WebDriverWait(driver, 20);

        // clica no botao adicionar
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.eliasnogueira.workshop:id/fab")));
        driver.findElement(By.id("com.eliasnogueira.workshop:id/fab")).click();

        // preenche os campos e salva
        driver.findElement(By.id("com.eliasnogueira.workshop:id/txt_nome")).sendKeys("Nome Teste");
        driver.findElement(By.id("com.eliasnogueira.workshop:id/txt_endereco")).sendKeys("Endereco Teste");
        driver.findElement(By.id("com.eliasnogueira.workshop:id/txt_hobbies")).sendKeys("Hobbies Teste");
        driver.findElement(By.id("com.eliasnogueira.workshop:id/button")).click();

        // efetua a pesquisa por um nome
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/search_button")));
        driver.findElement(By.id("android:id/search_button")).click();
        driver.findElement(By.id("android:id/search_src_text")).sendKeys("Nome Teste");

        // valida se o nome e o esperado
        String texto = driver.findElement(By.id("android:id/text1")).getText();
        assertEquals("Nome Teste", texto);

        driver.quit();
    }
}
