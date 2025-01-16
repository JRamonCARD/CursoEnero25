package practicaSel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EjercicioCheckOut {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		//Obtener elementos web
		WebElement userNameTxt = driver.findElement(By.id("user-name"));
		WebElement passwordTxt = driver.findElement(By.name("password"));
		WebElement clickBtn = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
				
		//Login
		userNameTxt.sendKeys("standard_user");		
		passwordTxt.sendKeys("secret_sauce");
		Thread.sleep(2000);		
		clickBtn.click();
		
		//obtener el titulo de la pestaña del navegador
		String title = driver.getTitle(); 
		System.out.println("El titulo de la pagina es: " + title);
		
		//Encontrar "Add to cart" del primer producto y dar click
		WebElement carCompra = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
		carCompra.click();
		Thread.sleep(2000);
		
		//Encontrar el "Carrito" y dar click 
		WebElement carritoBtn = driver.findElement(By.id("shopping_cart_container"));
		carritoBtn.click();
		Thread.sleep(2000);
		
		//Encontrar y desplegar la etiqueta de "Your Cart"
		String yourCartLabel = driver.findElement(By.className("title")).getText();
		System.out.println("Estas en esta pagina: " + yourCartLabel);
		
		//Encontrar el boton de checkout y dar click
		WebElement checkoutBtn = driver.findElement(By.id("checkout"));
		checkoutBtn.click();
		
		//Llenar formulario y mandar data
		WebElement firstNameTxt = driver.findElement(By.id("first-name"));
		firstNameTxt.sendKeys("Ramon");
		
		WebElement lastNameTxt = driver.findElement(By.id("last-name"));
		lastNameTxt.sendKeys("Cardenas");
		
		WebElement zipCode = driver.findElement(By.id("postal-code"));
		zipCode.sendKeys("20200");
		Thread.sleep(2000);
		
		//Encontrar "Continue" button y dar click
		WebElement continueBtn = driver.findElement(By.id("continue"));
		continueBtn.click();
				
		//Validar "Check - Overview" label esta desplegado
		String checkoutOverview = driver.findElement(By.className("title")).getText();
		System.out.println("La etiqueta es: " + checkoutOverview);
		Thread.sleep(2000);
				
		//Encontrar "Finish" boton esta y dar click
		WebElement finishBtn = driver.findElement(By.id("finish"));
		finishBtn.click();
		
		//Validar que el mensaje de compra es correcto
		String orderMessage = driver.findElement(By.className("complete-header")).getText();
		System.out.println("La etiqueta es: " + orderMessage);
		
		String compraRealizada = "Thank you for your order!";
		
		if(compraRealizada.contains(orderMessage)) //si la variable orderMessage contiene lo mismo que lo que asigne a compraRealizada
		{
			System.out.println("La compra se realizo");
		}
		else 
		{
			System.out.println("La compra no se realizo");
		}
		Thread.sleep(3000);
		
		//Cerrar navegador
		driver.close();
		driver.quit();
		

	}

}
