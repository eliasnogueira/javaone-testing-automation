package com.eliasnogueira.workshop.mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Teste para remover uma pessoa, onde e necessario pressionar o item (pessoa) para remove-lo
 * 
 * @author Elias Nogueira <elias.nogueira@gmail.com>
 */
public class RemoverPessoaTeste {
    
    @Test
    public void removerPessoa() throws MalformedURLException {
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
        
        // guarda o elemento em um mobileelement
        MobileElement item = driver.findElement(By.id("android:id/text1"));
        
        // instancia a classe de touch (reais) e efetua um long press no item
        TouchAction touch = new TouchAction(driver);
        touch.longPress(item).perform();
        
        // a mensagem para remocao e apresentada, logo primeiro valida a mensagem e depois remove o item
        assertEquals("Deseja remover a pessoa selecionada?", driver.findElement(By.id("android:id/message")).getText());
        driver.findElement(By.id("android:id/button1")).click();
        
        // valida a mensagem de sucesso e clica no botao OK
        assertEquals("A pessoa foi removida com sucesso!", driver.findElement(By.id("android:id/message")).getText());
        driver.findElement(By.id("android:id/button3")).click();
        
        driver.quit();
    }

}
