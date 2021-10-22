package passos;

import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PassosDefinidos {
    private WebDriver navegador;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sempre IT\\IdeaProjects\\br.com.netshoes\\Driver\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Dado("que estou no site http://www.netshoes.com.br")
    public void queEstouNoSiteHttpWwwNetshoesComBr() {
        navegador.get("http://www.netshoes.com.br");
    }
    @Quando("faco login")
    public void facoLogin() {
        navegador.findElement(By.xpath("//a[@href='#header-user-anonymous']")).click();
        WebDriverWait wait = new WebDriverWait(navegador, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(li, 'Login')]")));
        navegador.findElement(By.xpath("//ul[contains(li, 'Login')]")).click();
        navegador.findElement(By.xpath("//input[@id='username']")).sendKeys("raphaelsan.dev@outlook.com");
        navegador.findElement(By.xpath("//input[@id='password']")).sendKeys("teste123");
        navegador.findElement(By.xpath("//*[@id='login-button']")).click();
    }
    @E("seleciono a sequencia de menus todas categorias, masculino, tenis")
    public void selecionoASequenciaDeMenusTodasCategoriasMasculinoTenis() {
        //navegador.switchTo().frame("chaordic-remote-collect");
        navegador.findElement(By.xpath("/html/body/div[1]/div[6]/div[2]/div[1]/div/a")).click();
        navegador.findElement(By.xpath("//h4[@class='navbar__hamburger--title']")).click();
        navegador.findElement(By.xpath("//*[@id='Layer_1']")).click();
        Actions action = new Actions(navegador);
        WebElement we = navegador.findElement(By.xpath("//*[@href='/masculino/home?mi=hm_ger_mntop_H_sub&psn=Menu_Top']"));
        action.moveToElement(we).moveToElement(navegador.findElement(By.xpath("(//div[3]//ul//li[7]//a)[1]"))).click().build().perform();

        //navegador.findElement(By.xpath("(//div[3]//ul//li[7]//a)[1]")).click();

    }
    @E("seleciono um tenis por cor e tamanho")
    public void selecionoUmTenisPorCorETamanho() {

    }
    @Entao("entro no carrinho e verifico se o produto esta la")
    public void entroNoCarrinhoEVerificoSeOProdutoEstaLa() {

    }
}
