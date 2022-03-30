package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ActionClassMethods {
    //ContextClick() --right click
    @Test
    public void ContextClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/");
        WebElement contextmenu= driver.findElement(By.partialLinkText("Context"));
        contextmenu.click();
        WebElement box= driver.findElement(By.id("hot-spot"));
        Actions actions= new Actions(driver);
        //  action class you must use perform at the end.
        actions.contextClick(box).perform();

    }
    @Test
    public  void Hoverover()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/");
        WebElement Hover= driver.findElement(By.linkText("Hovers"));
        Hover.click();
        Thread.sleep(2000);
        Actions actions=new Actions(driver);
        List<WebElement> names= driver.findElements(By.tagName("h5"));
        List<WebElement> pictures= driver.findElements(By.xpath("//div[@class='figure']/img"));
        List<String> expectedNames= Arrays.asList("name: user1", "name: user2", "name: user3");
        for(int i=0; i< names.size();i++){
            Thread.sleep(2000);
            actions.moveToElement(pictures.get(i)).perform(); //hover over here
            Assert.assertEquals(BrowserUtils.getTextMethod(names.get(i)),expectedNames.get(i));
            System.out.println(BrowserUtils.getTextMethod(names.get(i))); //get text here

        }

    }
    @Test
    public  void doubleclick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");
        driver.manage().window().maximize();
        WebElement doubleClickButton= driver.findElement(By.tagName("button"));
        Actions actions= new Actions(driver);
       // actions.doubleClick(doubleClickButton).perform();
//        actions.doubleClick().perform();
//        actions.doubleClick(driver.findElement(By.tagName("button"))).perform();
        //right click practice
        WebElement rightClickButton= driver.findElement(By.xpath("//span[.='right click me']"));
          actions.contextClick(rightClickButton).perform();
    }

    //TASK FOR STUDENTS
        /*
        Scenario to Automate:
1. Launch the Chrome web browser.
2. Open a URL "https://selenium08.blogspot.com/2019/11/double-click.html".
3. Locate the element "Double-click".
4.  click on the current location (i.e. on Double-click element).
5. Close the web browser.
         */

    @Test
    public  void doubleclickpractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://selenium08.blogspot.com/2019/11/double-click.html");
        driver.manage().window().maximize();
        WebElement doubleClickButton= driver.findElement(By.xpath("//button[@ondblclick=\"myFunction()\"]"));
        Actions actions= new Actions(driver);
        actions.doubleClick(doubleClickButton).perform();
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public  void dragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.manage().window().maximize();

        WebElement acceptcookies= driver.findElement(By.id("onetrust-accept-btn-handler"));
        Thread.sleep(3000);
        acceptcookies.click();
        Actions actions=new Actions(driver);
        for (int i=0; i<5;i++){
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }

        WebElement dragable= driver.findElement(By.xpath("//div[@id='draggable']"));

        WebElement orangebox= driver.findElement(By.xpath("//div[@class='test2']"));
        String actualmessage= BrowserUtils.getTextMethod(orangebox);
        String expectedmessage="... Or here.";
        Assert.assertEquals(actualmessage,expectedmessage);
        actions.dragAndDrop(dragable,orangebox).perform();
        Thread.sleep(3000);
        orangebox= driver.findElement(By.xpath("//div[@class='test2']"));//reinitializing after change
        String actualafterdraganddrop=BrowserUtils.getTextMethod(orangebox);
        String expectedafterdraganddrop="You did great!";
        Assert.assertEquals(actualafterdraganddrop,expectedafterdraganddrop);

        String actualcssValue=orangebox.getCssValue("background-color");
        String expectedCssValue="rgba(238, 111, 11, 1)";
        System.out.println(actualcssValue);
        Assert.assertEquals(actualcssValue,expectedCssValue);

    }

    @Test
    public void ClickAndHold() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.manage().window().maximize();
        WebElement acceptcookies= driver.findElement(By.id("onetrust-accept-btn-handler"));
        Thread.sleep(3000);
        acceptcookies.click();
       WebElement bluebox= driver.findElement(By.xpath("//div[@class='test1']"));
       String actualBlueBox= BrowserUtils.getTextMethod(bluebox);
       String expectedBLueBoxMessage="Drag the small circle here ...";
       Assert.assertEquals(actualBlueBox,expectedBLueBoxMessage);
        WebElement dragable= driver.findElement(By.xpath("//div[@id='draggable']"));
       Actions actions= new Actions(driver);
        actions.clickAndHold(dragable).moveToElement(bluebox).release().perform();

    }

    @Test
    public void dragandDropPractice(){
        /*
        1)Navigate to the website :"https://demoqa.com/droppable"
        2)Drag Drag me box and drop to drop box
        3)Validate the message is changed to "Dropped"
        4)Validate the css color is steel blue

         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demoqa.com/droppable");
        WebElement drag= driver.findElement(By.id("draggable"));
        WebElement box= driver.findElement(By.id("droppable"));
        Actions actions= new Actions(driver);
        actions.dragAndDrop(drag,box).perform();

        String actualcssValue=box.getCssValue("background-color");
        String expectedCssValue="rgba(70, 130, 180, 1)";
        System.out.println(actualcssValue);
        Assert.assertEquals(actualcssValue,expectedCssValue);
        //div[@id="droppable"
        WebElement droppedmessage= driver.findElement(By.xpath("//p[contains(text(),'Dropped!')]"));
        String actualdropmessage= droppedmessage.getText();
        String expecteddroppedmessage="Dropped!";
        Assert.assertEquals(actualdropmessage,expecteddroppedmessage);


    }
    @Test
    public  void ClickandHoldPractice(){
        /*
        1)Navigate to the website: "https://demoqa.com/droppable"
        2) Click Accept
        3) ClickAndHold not accepted box and release to drop box
        4) validate the background is still white and message is till "drop here"
        5) clickandHold acceptable box and release to drop box
        6) validate the background is blue and message is "dropped"
        */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demoqa.com/droppable");
WebElement accept= driver.findElement(By.id("droppableExample-tab-accept"));
accept.click();
        WebElement notacceptable= driver.findElement(By.id("notAcceptable"));
        WebElement dropbox= driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        Actions actions= new Actions(driver);

        actions.clickAndHold(notacceptable).moveToElement(dropbox).release().perform();
        String actualcssValueafter=dropbox.getCssValue("background-color");
        String expectedCssValue="rgba(0, 0, 0, 0)";
        Assert.assertEquals(actualcssValueafter,expectedCssValue);
        WebElement droppedmessage= driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        String actualdropmessage= droppedmessage.getText();
        String expecteddroppedmessage="Drop here";
        Assert.assertEquals(actualdropmessage,expecteddroppedmessage);
        WebElement acceptable= driver.findElement(By.id("acceptable"));
        actions.clickAndHold(acceptable).moveToElement(dropbox).release().perform();
        WebElement droppedmessageafteracptmove= driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        String actualdropmessageafteracptmove= droppedmessage.getText();
        String expecteddroppedmessageafteracptmove="Dropped!";
        Assert.assertEquals(actualdropmessageafteracptmove,expecteddroppedmessageafteracptmove);
        String actualcssValueafteracptmove=dropbox.getCssValue("background-color");
        String expectedCssValueafteracptmove="rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualcssValueafteracptmove,expectedCssValueafteracptmove);

    }
    @Test
    public void MoveByOffset(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement slider= driver.findElement(By.xpath("//input"));
        Actions actions= new Actions(driver);
        // x means -- horizontal y means--> vertical
        actions.clickAndHold(slider).moveByOffset(-30,0).perform();


    }
    @Test
    public void sliderShortCut() throws InterruptedException { // this is shortcut for testing slider
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement slider= driver.findElement(By.xpath("//input"));
        WebElement range= driver.findElement(By.xpath("//span[@id='range']"));
        String myrange="5";
        while (!range.getText().trim().equals(myrange)){
            Thread.sleep(1000);
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
    }

    @Test
    public void task2() throws InterruptedException {
        /*
TASK FOR STUDENTS:
1)navigate to the Website "https://text-compare.com/"
2)Type with the Keys --> "Good Bye Keys"
3)with CTRL(COMMAND)+A --> select all text
4)Copy this text CTRL(COMMAND) + C --> it will copy the text
5)Go to the second box and paste CTRL(COMMAND) + V-->it will paste the text
6) Validate this two boxes text are matching
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://text-compare.com/");
        WebElement firstbox= driver.findElement(By.xpath("//textarea[@id=\"inputText1\"]"));
        WebElement secondbox= driver.findElement(By.xpath("//textarea[@id=\"inputText2\"]"));
        Actions actions= new Actions(driver);
        actions.moveToElement(firstbox)
                .click().keyDown(Keys.SHIFT)
                .sendKeys("g")
                .keyUp(Keys.SHIFT)
                .sendKeys("ood")

                .sendKeys(Keys.SPACE)
                .keyDown(Keys.SHIFT)
                .sendKeys("b")
                .keyUp(Keys.SHIFT)
                .sendKeys("ye")

                .sendKeys(Keys.SPACE)
                .keyDown(Keys.SHIFT)
                .sendKeys("k")
                .keyUp(Keys.SHIFT)
                .sendKeys("eys")

                .keyDown(Keys.CONTROL)// for windows do control
                .sendKeys("a")
                .keyUp(Keys.CONTROL)

                .keyDown(Keys.CONTROL)// for windows do control
                .sendKeys("c")
                .keyUp(Keys.CONTROL).perform();


        actions.moveToElement(secondbox)
                .click()
                .keyDown(Keys.CONTROL)
                .sendKeys("v").perform();



       WebElement comparebutton= driver.findElement(By.className("compareButtonText"));
              comparebutton.click();
        String expectedtext="The two texts are identical!";
        Thread.sleep(5000);
        WebElement messageforuser=driver.findElement(By.className("messageForUser"));
        String actualtext1=messageforuser.getText();
        Assert.assertEquals(actualtext1, expectedtext);

    }

    @Test
    public void moveByOffsetPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        WebElement contactUs = driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Contact Us']"));
        Point coordinates = contactUs.getLocation();
        int xCord = coordinates.getX();
        int yCord = coordinates.getY();
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
       // actions.moveByOffset(xCord,yCord).click().build().perform();  for some reason in my machine this does not work, if not works use regular  actions.click(contactUs).perform();
        actions.click(contactUs).perform();

    }


}

