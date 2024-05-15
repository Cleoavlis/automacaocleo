package MeusTestes;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCarrinho {

WebDriver driver;	
	@Before
	public void setUp() throws Exception {


		System.setProperty("web.chrome.drive", "./Drive/chromedrive.exe");
		
		
		driver = new ChromeDriver();
		driver.get("https://www.americanas.com.br/");
		driver.manage().window().maximize();
		//Supondo que "closeButton" seja o ID ou outro identificador do botão para fechar a viewBox
		//WebElement closeButton = 			
				driver.findElement(By.xpath("//*[@id=\"rsyswpsdk\"]/div/div[2]/div/div/div/div/a[1]")).click();

		// Clique no botão para fechar a viewBox
		//closeButton.click();
		
		Thread.sleep(300);
		WebElement searchInput = driver.findElement(By.name("conteudo"));
		searchInput.sendKeys("bonecas");
		//searchInput.sendKeys(Keys.ENTER); // Simula pressionar a tecla Enter
		
	}

	@After
	public void tearDown() throws Exception {
		
		//driver.quit();

	}

	@Test
	public void test() {
		
	}

}
