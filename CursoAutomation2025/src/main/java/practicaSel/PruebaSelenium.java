package practicaSel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class PruebaSelenium {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		//Obtener elementos web
		WebElement userNameTxt = driver.findElement(By.id("user-name"));
		WebElement passwordTxt = driver.findElement(By.name("password"));
		WebElement clickBtn = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
		
		//Login
		userNameTxt.sendKeys("standard_user");
		Thread.sleep(2000); //2000 = 2 segundos
		
		passwordTxt.sendKeys("secret_sauce");
		Thread.sleep(2000);
		
		clickBtn.click();
		
		//obtener el titulo de la pestaña del navegador
		String title = driver.getTitle(); 
		System.out.println("El titulo de la pagina es: " + title);
		
		//Obtener la URL
		String url = driver.getCurrentUrl();
		System.out.println("La URL de la pagina es: " + url);
		
		//Metodos de navegacion en lpaginas
		//driver.navigate().back();  //ir a la pagina anterior
		//Thread.sleep(2000);
		
		//driver.navigate().forward(); //ir a la sig pagina
		//Thread.sleep(2000);
		
		//driver.navigate().refresh(); //hacer refresh
		
		//Verificar si un elemento se despliega
		boolean prodContainer = driver.findElement(By.className("inventory_item_name")).isDisplayed();
		if (prodContainer) {
			System.out.println("El articulo esta desplegado");
		}
		
		//Verificar el texto dentro de un elemento
		String prodName = driver.findElement(By.className("inventory_item_name")).getText();
		System.out.println("El producto es: " + prodName);
		
		//Dropdowns, estos elementos usan unas funciones que vienen en "org.openqa.selenium.support.ui." debo importarla
		driver.manage().window().maximize(); //maximizar ventana
		Select drpdwnSelect = new Select(driver.findElement(By.className("product_sort_container")));
		drpdwnSelect.selectByVisibleText("Price (low to high)");
	
		//Cerrar navegador
		driver.close();  //cierra la ventana/pestaña actual que el web driver esta usando
		driver.quit();  //cierra todas las ventanas del navegador que el webdriver abrio
		
	}

}
