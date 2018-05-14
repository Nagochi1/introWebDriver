package classExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class ImdbPerfume {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\test_automation\\drivers\\chromedriver.exe");
		//abrir driver
		WebDriver driver = new ChromeDriver(); 
		//ingresar url
		driver.get("http://www.imdb.com/");
		//buscar el campo de búsqueda
		WebElement searchTxt= driver.findElement(By.name("q"));
		//buscar botón de busqueda
		WebElement searchButton = driver.findElement(By.id("navbar-submit-button"));
		//Digitar nombre de pelicula Perfume en campo búsqueda
		searchTxt.clear();
		searchTxt.sendKeys("El Perfume");
		//Oprimir el botón de búsqueda
		searchButton.click();
		//Seleccionar la pelicula buscada
		WebElement lnkMovie = driver.findElement(By.linkText("El perfume: Historia de un asesino"));
		lnkMovie.click();
		//Cerrar navegador
		driver.quit();
		
		
	}

}
