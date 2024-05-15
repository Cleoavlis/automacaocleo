package Aut_Nubank;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomacaoNubank {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdrive.chrome.drive", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://nubank.com.br/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1200);
		js.executeScript("window.scrollBy(0,-200)");
		driver.findElement(By.name("cpf")).sendKeys("888.201.220-49");
	}

	@After
	public void tearDown() throws Exception {
        Thread.sleep(5000);

		driver.quit();
		
	}

	@Test
	public void validacaoNubank() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

String texto;
texto = driver.findElement(By.xpath("//*[@id=\"short-form\"]/h3")).getText();
assertEquals( "Peça sua conta e cartão de crédito do Nubank", texto);
driver.findElement(By.id("test")).click();
Thread.sleep(1000);
driver.findElement(By.id("label-name")).sendKeys("Abigail Amorim");
Thread.sleep(1000);
driver.findElement(By.id("label-phone")).sendKeys("61984254534");
Thread.sleep(1000);
driver.findElement(By.id("label-email")).sendKeys("abigailamorim3@gmail.com");
Thread.sleep(1000);
driver.findElement(By.id("label-emailConfirmation")).sendKeys("abigailamorim3@gmail.com");
driver.findElement(By.xpath("//*[@id=\"label-acceptedWhatsapp\"]/span[2]")).click();
Thread.sleep(1000);
js.executeScript("window.scrollBy(0,100)");
Thread.sleep(1000);
driver.findElement(By.id("label-accepted")).click();
Thread.sleep(1000);
js.executeScript("window.scrollBy(0,500)");
driver.findElement(By.xpath("//*[@id=\"complete-form-drawer\"]/div/div/div[2]/form/div/div[2]/div/button")).click();
Thread.sleep(5000);

}

}
