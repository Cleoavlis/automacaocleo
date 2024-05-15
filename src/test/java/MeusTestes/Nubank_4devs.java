package MeusTestes;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Nubank_4devs {
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		
// Conectando ao driver do Chrome		
		System.setProperty("web.chrome.driver", "./Drive/chromedriver.exe");
		driver = new ChromeDriver();

		//Maximizar a página
		driver.manage().window().maximize();
	       
	}

	@After
	public void tearDown() throws Exception {
		 // Fechar o navegador
        Thread.sleep(1000);
      //driver.quit();

	}

	@Test
	public void test() throws InterruptedException {
		
		 // Navegar até a página do 4devs para gerar dados
        driver.get("https://www.4devs.com.br/");       
		
		 // Extrair dados do site 4devs
		
       WebElement btgp = driver.findElement(By.cssSelector("#top-nav > li:nth-child(23) > a"));
        JavascriptExecutor gp = (JavascriptExecutor)driver;
        gp.executeScript("arguments[0].scrollIntoView(true);",btgp);
        btgp.click();
        
        JavascriptExecutor gd = (JavascriptExecutor)driver;
        gd.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.id("bt_gerar_pessoa")));
        driver.findElement(By.cssSelector("#area_botoes > label > span")).click();
        
       // btgeradados.click();
        
     String Nome = driver.findElement(By.id("nome")).getText();    
   
        //WebElement
     
     String Geracpf =  driver.findElement(By.id("cpf")).getText();
    // JavascriptExecutor CPF = (JavascriptExecutor)driver;
    // CPF.executeScript("arguments[0].scrollIntoView(true);",Geracpf);
     
     
       // String cpf = cpfElement.getText();
      
  //  String Nome = driver.findElement(By.id("nome")).getText();    
     //JavascriptExecutor n = (JavascriptExecutor)driver;
    // n.executeScript("arguments[0].scrollIntoView(true);",Nome);   
    //String nome = Nome.getText();
       
        
        WebElement telefoneElement = driver.findElement(By.id("celular"));
        String telefone = telefoneElement.getText();
        JavascriptExecutor t = (JavascriptExecutor)driver;
        t.executeScript("arguments[0].scrollIntoView(true);",telefoneElement);
        
        WebElement emailElement = driver.findElement(By.id("email"));
        String email = emailElement.getText();
        JavascriptExecutor e = (JavascriptExecutor)driver;
        e.executeScript("arguments[0].scrollIntoView(true);",emailElement);

        
        // Navegar até a página de registro do Nubank

        driver.get("https://www.nubank.com.br/");
        
        // Preencher o formulário do Nubank com os dados gerados
	    Thread.sleep(800);
        WebElement cpfInput = driver.findElement(By.name("cpf"));
        cpfInput.sendKeys(Geracpf);
        driver.findElement(By.id("test")).click();
	    Thread.sleep(800);
        WebElement nomeInput = driver.findElement(By.name("name"));
        nomeInput.sendKeys(Nome);
	    Thread.sleep(800);
        WebElement telefoneInput = driver.findElement(By.name("phone"));
        telefoneInput.sendKeys(telefone);
	    Thread.sleep(800);
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys(email);
	    Thread.sleep(800);
        WebElement emailcInput = driver.findElement(By.name("emailConfirmation"));
        emailcInput.sendKeys(email);
	    Thread.sleep(800);
        driver.findElement(By.xpath("//*[@id=\"label-acceptedWhatsapp\"]/span[2]/span")).click();
        JavascriptExecutor cb = (JavascriptExecutor)driver;
        cb.executeScript("0,100");
        driver.findElement(By.xpath("//*[@id=\"label-accepted\"]/span[2]/span")).click();
        cb.executeScript("0,100");
        driver.findElement(By.xpath("//*[@id=\"complete-form-drawer\"]/div/div/div[2]/form/div/div[2]/div/button")).click();
        
       
	}

}
