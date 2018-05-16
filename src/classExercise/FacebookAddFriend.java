package classExercise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class FacebookAddFriend {

	static WebDriver driver; 

	public static void main(String[] args) { 

		
		configurarNavegador(); //configurarNavegador 
		logearFacebook("luarball@hotmail.com", "Gonzalez"); //login 
		buscarAmigo("Carol Rojo"); //buscar amigo
		agregarAmigo("Carol Rojo", "Carolina Rojo"); //agregar amigo
		destruirConfiguracion();

	} 


	private static void destruirConfiguracion() {
		//driver.close();
		
	}


	private static void configurarNavegador() {  

		System.setProperty("webdriver.chrome.driver", "C:\\test_automation\\drivers\\chromedriver.exe");
		ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
        driver = new ChromeDriver(ops);
 		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		driver.get("http://www.facebook.com"); 

	} 

	private static void logearFacebook(String usuario, String password) { 
		WebElement campoUsuario; //id=email
		WebElement campoPassword; //id="pass"
		WebElement botonLogin; //data-testid="royal_login_button"
		
		campoUsuario = driver.findElement(By.id("email"));
		campoPassword = driver.findElement(By.id("pass"));
		botonLogin = driver.findElement(By.xpath("//input[@data-testid='royal_login_button']"));
		
		campoUsuario.clear();
		campoUsuario.sendKeys(usuario);
		campoPassword.clear();
		campoPassword.sendKeys(password);
		botonLogin.click();
	} 

	private static void agregarAmigo(String nameFriend, String infoFriend) {
		String xpath = "//div[ contains(@class,'_2yer')]";
		WebElement correctContainer = null;
		
		List <WebElement> containerList = driver.findElements(By.xpath(xpath));
		
		for (int i = 0; i < containerList.size(); i++) {
			WebElement currentElement = containerList.get(i);
						
			if(currentElement.getText().contains(infoFriend)) {
				correctContainer = currentElement;
				break;
			}
		}
		
		if(correctContainer != null) {
			WebElement addFriendLink = correctContainer.findElement(By.xpath(".//button[@aria-label='Agregar a amigos']"));
			addFriendLink.click();
			//if(addFriendLink.getText().contains("")) {
					
			//	}
			}
			//System.out.println(currentElement.getText());
	
		

	}

	private static void buscarAmigo(String nameFriend) {
		WebElement searchTxt= driver.findElement(By.name("q"));
		searchTxt.clear();
		searchTxt.sendKeys(nameFriend);
		WebElement searchButton = driver.findElement(By.xpath("//button[@data-testid='facebar_search_button']"));
		searchButton.click();
	
	}


}
