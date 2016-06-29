package com.eliasnogueira.workshop.mobile;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import java.io.File;

public class PesquisaPessoaScrollTeste {

    @Test
    public void testePesquisaScroll() throws MalformedURLException {
        File app = new File("src/main/resources/app/workshop.apk");
        
        DesiredCapabilities capacidade = new DesiredCapabilities();
        capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capacidade.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        AndroidDriver<MobileElement> driver
                = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capacidade);

        // efetua um scroll ate encontrar. quando encontra clica. se nao encontra da erro
        driver.scrollToExact("Claudiomir").click();

        // pega o valor do atributo texto do campo e compara se trouxe o nome do usuario
        assertEquals("Claudiomir", driver.findElement(By.id("com.eliasnogueira.workshop:id/txt_nome")).getAttribute("text"));

        driver.quit();
    }

}
