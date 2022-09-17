package a101T.OtomasyonPracticumFirstCase;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class A101TestOtomasyonPracticumFirstCase {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		
		
		System.setProperty("webdriver.chrome.driver", "Util\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Timeouts bekle1= driver.manage().timeouts();
		Timeouts bekle2= driver.manage().timeouts();
		
		driver.get("https://www.a101.com.tr/"); bekle1.implicitlyWait(1, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click(); //�e.
		bekle2.implicitlyWait(2, TimeUnit.SECONDS);
		
		JavascriptExecutor js = ((JavascriptExecutor) driver); 
		
		System.out.println("Page title: " + js.executeScript("return document.title;").toString());
		js.executeScript("history.go(0)"); bekle1.implicitlyWait(1, TimeUnit.SECONDS); //s.y.
		
		Actions action = new Actions(driver);
		
		WebElement giyim= driver.findElement(By.xpath("//a[normalize-space()='Giyim & aksesuar']")); //giyim
		action.moveToElement(giyim).build().perform(); Thread.sleep(1000);
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 15px solid yellow;');", giyim);
		
		// 1)
		WebElement dizalti= driver.findElement(By.linkText("Dizalt� �orap")); //�orap
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 5px solid red;');", dizalti); //boyama
		Thread.sleep(1000);
		System.out.println("Giyim-> Aksesuar-> Kad�n �� Giyim->Dizalt� �orap b�l�m�ne girilir: " + 
		driver.findElement(By.linkText("Dizalt� �orap")).getText()); 	//�orap metin alma
		dizalti.click();												
		Thread.sleep(1000);
		
		js.executeScript("window.scrollBy(0,900)"); Thread.sleep(1000);
		// 2)
		WebElement siyah= driver.findElement(By.xpath("//label[@for='attributes_integration_colourS�YAH']"));
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 5px solid red;');", siyah);
		Thread.sleep(1000);
		System.out.println("A��lan �r�n�n siyah oldu�u do�rulan�r: " + siyah.getText()); //renk metin alma
		js.executeScript("arguments[0]. click();", siyah);
		Thread.sleep(1000);
		
		WebElement corap= driver.findElement(By.xpath("//body[1]/section[1]/section[4]/div[3]/div[2]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[1]/article[1]"));
		js.executeScript("arguments[0].style.border='10px solid orange'", corap); Thread.sleep(1000);
		corap.click(); Thread.sleep(1000); // �orap
		
		
		WebElement syh2= driver.findElement(By.xpath("//span[contains(text(),'S�YAH')][1]"));
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 5px solid yellow;');", syh2);
		System.out.println(driver.findElement(By.className("selected-variant-text")).getText()); // renk metni alma
		Thread.sleep(1000);
		
		// 3)
		WebElement sepetekle= driver.findElement(By.xpath("//button[@class='add-to-basket button green block with-icon js-add-basket']"));
		js.executeScript("arguments[0].style.border='5px solid black'", sepetekle); Thread.sleep(1000);
		System.out.println("Sepete Ekle butonuna t�klan�r: " + sepetekle.getText());
		sepetekle.click(); Thread.sleep(1000);
		
		// 4)
		WebElement sepetig�r�nt�le= driver.findElement(By.linkText("Sepeti G�r�nt�le")); //Sepete gittik
		js.executeScript("arguments[0].style.border='5px solid black'", sepetig�r�nt�le); Thread.sleep(1000);
		System.out.println("Sepeti G�r�nt�le butonuna t�klan�r: " + sepetig�r�nt�le.getText());
		sepetig�r�nt�le.click(); Thread.sleep(1000);
		
		js.executeScript("window.scrollBy(0,150)"); Thread.sleep(1000); //biraz a�a�i indik
		// 5)
		WebElement sepetonayla= driver.findElement(By.linkText("Sepeti Onayla")); 
		System.out.println("Sepeti Onayla butonuna t�klan�r: " + sepetonayla.getText());
		sepetonayla.click();
		
		js.executeScript("window.scrollBy(0,150)"); Thread.sleep(1000); //biraz a�a�i indik
		// 6)
		WebElement uyelmadan= driver.findElement(By.linkText("�YE OLMADAN DEVAM ET")); 
		js.executeScript("arguments[0].style.border='8px solid purple'", uyelmadan); Thread.sleep(1000);
		System.out.println("�ye olmadan devam et butonuna t�klan�r: " + uyelmadan.getText());
		uyelmadan.click(); Thread.sleep(2000);
		
		// 7)
		WebElement rastgelemail= driver.findElement(By.xpath("//input[@name='user_email']")); // mail girdik 
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);	
		rastgelemail.sendKeys("dadal" + randomInt + "@oglu.com"); Thread.sleep(1000);
		System.out.println("Mail ekran� gelir: " + rastgelemail.getText());
		
		driver.findElement(By.xpath("//button[normalize-space()='DEVAM ET']")).click(); Thread.sleep(2000);
		
		WebElement teslimatadresi= driver.findElement(By.xpath("//div[normalize-space()='L�tfen teslimat adresi se�in.']"));
		System.out.println("Sonras�nda adres ekran� gelir: " + teslimatadresi.getText());
		
		// 8)
		WebElement yeniadresolustur= driver.findElement(By.linkText("Yeni adres olu�tur"));
		System.out.println("Sonras�nda adres ekran� gelir: " + yeniadresolustur.getText());
		yeniadresolustur.click(); Thread.sleep(2000);
		
		driver.findElement(By.name("title")).sendKeys("A101im");	  // adres bilgileri k�sm�
		driver.findElement(By.name("first_name")).sendKeys("John"); 
		driver.findElement(By.name("last_name")).sendKeys("Carter"); Thread.sleep(1000);
		//bekle2.implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.className("js-phone-number")).sendKeys("553 117 4518"); Thread.sleep(1000);
		//bekle2.implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//select[@name='city']")).sendKeys("ADANA"); Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@name='township']")).sendKeys("CEYHAN"); Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@name='district']")).sendKeys("AZ�ZL� MAH"); Thread.sleep(1000);
		driver.findElement(By.name("line")).sendKeys("ah bii bilsem bende oraya gidece�im");
		driver.findElement(By.className("js-post-code")).sendKeys("16500"); Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='KAYDET']")).click(); Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='continue']//li[1]//label[1]//div[2]//div[1]")).click(); // Kargo ismi***
		
		WebElement KaydetveDevamEt= driver.findElement(By.cssSelector(".button.block.green.js-proceed-button")); Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='9px solid purple'", KaydetveDevamEt);
		System.out.println("Teslimat Adresi: " + KaydetveDevamEt.getText());
		KaydetveDevamEt.click(); Thread.sleep(2000);
		
		WebElement �demekrani= driver.findElement(By.xpath("//div[normalize-space()='Masterpass ile �deme'][1]")); //son sayfa metin alma
		System.out.println("�deme Ekran�: " + �demekrani.getText());
		
		
		driver.findElement(By.xpath("//div[@class='form-area js-new-creditcard-area']//input[@name='name']")).sendKeys("Mehmed Said Ta�demir");
		driver.findElement(By.xpath("//input[@class='js-masterpassbin-payment-card']")).sendKeys("4766190330067591"); Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='form-area js-new-creditcard-area']//select[@name='card_month']")).sendKeys("10");
		driver.findElement(By.cssSelector("div[class='form-area js-new-creditcard-area'] select[name='card_year']")).sendKeys("26"); Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='form-area js-new-creditcard-area']//input[@name='card_cvv']")).sendKeys("387");
		
		// 9)
		WebElement kabul= driver.findElement(By.cssSelector("label[for='agrement2']")); // Thread.sleep(1000);
		action.moveToElement(kabul).build().perform();
		js.executeScript("arguments[0]. click();", kabul); Thread.sleep(1000);
		
		driver.findElement(By.className("order-complete")).click(); Thread.sleep(1000);
		
		System.out.println("�deme Ekran� URL: " + driver.getCurrentUrl());
		
		
	}

}
