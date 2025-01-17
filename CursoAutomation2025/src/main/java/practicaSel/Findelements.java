package practicaSel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Findelements {

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
		
		//FindElements nos regresa una lista de todos los webelements que contengan el mismo localizador
		List <WebElement> listaProductos = driver.findElements(By.className("inventory_item_name"));
		System.out.println("El numero de elementos es : " + listaProductos.size());
		
		String primerProd = listaProductos.get(0).getText();  //Obtener el nombre de el primer producto de la lista "listaProductos" que se encuentra en la posicion 0
		String segundoProd = listaProductos.get(1).getText();
		
		System.out.println(primerProd);
		System.out.println(segundoProd);
		
		//Ciclo para imprimir todos los elementos de mi lista
		for (int  i=0; i < listaProductos.size(); i ++) {
			System.out.println("Los productos son : " + listaProductos.get(i).getText());
		}
		
		
	}

}
