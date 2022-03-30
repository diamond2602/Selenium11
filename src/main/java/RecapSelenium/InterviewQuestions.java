package RecapSelenium;

public class InterviewQuestions {
    /*
    1)What are the advantages and disadvantages of Selenium?
    Advantages: *Free open source
                *It supports multiple language(java, python, c++, C#)
                *Big Community
                *It supports multiple browsers(chrome, firefox..)
    Disadvantages:
                *You cannot automate the captcha, pictures, mobile application....
                * There is no direct call for error report.(support center)
                *It only automates the web application
                * It does not have any system to generate report, so we use TESTNG report system

    2)What type of testing can you automate with Selenium?
               **smoke
               ***Regression
               **Functional test(positive and negative)
    3)What are the test types do n ot automate with Selenium?
               *Performance Testing
               *Manual Testing(captcha, pictures)
               *Non-functional testing(performance, stress, load....)
               *Load Testing
               *Stress Testing

     4)What is locator and what are the locator types ? *********
     Locator is a way to find the elements from DOM(development tool/page)
               *ID
               *ClassName
               *Xpath
               *TagName
               *LinkText
               *PartialLinkText
               *CSS
     5) How do you handle dynamic Elements? CVS *********
      In my project, I faced many dynamic elements and I used different ways to handle with
        * I used parent-child relationship to locate the elements.
        * I used special element types like (following-sibling, preceding-sibling, contains...,
       and, or syntax )  //I would give a little bit of information I meant and, or conditions.
        * I went with different attributes which are not dynamic.


     6)Difference between driver.get and driver.navigate.to() ?
     NavigateTo() --> it does not wait webelements (page) to be loaded.
                  --> it has some methods(back(), refresh(), forward(),to())

       Get()--> it will wait webelements (page) to be loaded.

     7)Difference between driver.close() and driver.quit()?
       close()--> it specifically closes the window that you are currently working.(where your driver is located)

       quit()- it closes all the windows.(whole browsers)

     8) What is XPATH? and can you tell me about types of Xpath?Which one do you use in your project mostly?
     *XPATH: Xpath is used to find the location of the elements on a webpage by using HTML structure.

     --> there are 2 types of XPATH:
       1)Absolute XPATH: It goes from all teh way parent to child step by step.
       2)Relative XPATH: it directly focuses o the child. (location of the elements)

       --> In my Project, I use mostly relative xpath because it directly focuses on the child which I need to locate
     9)What is the difference between Absolute and Relative XPATH?

       Absolute XPATH:*It goes from parent to child
                      *It has (/) single slash for the path
                      *Synthax is different

       Relative XPATH:*It goes directly to child
                      *It has (//) double slash for the path
                      *Synthax is different

     10)How do you handle static drop down menus?
       In my project, I was handling static drop-down with different ways:
       * I would definitely check the tag of the location.
       *If the location has SELECT tag --> I use SELECT CLASS (Select select=new Select(Webelement);
       *If  the location does not have Select Tag --> I use locators to locate my elements.(senKeys())
       _ I can also use ACTION CLASS to hoverOver my element(moveToElement)

    11) What are the methods of Select?

        Select class is really useful for my project,to be able to use Select Class, element must have select tag
        I can locate the elements with these Select Methods:
        *SelectByVisibleText()
        *SelectByIndex()
        *SelectByValue()

     12) What kind of exceptions did you face in selenium?

         * NoSuchElementException
         *NullPointersException
         *StaleElementReference Exception
         *ElementIsNotInteractable Exception
         *TimeOutException
         *NoSuchFrameException
         *NoSuchWindowException
         *AlertUnhandledException

      13) In what condition do yuo get StaleElementReference Exception? How do yuo handle it?

      * in project, I had a hard time with StaleElementReference Exception to handle?

         *once the element is not in DOM anymore
         *Navigate to  another page and come back. (element needs little  time to be loaded)

         -->  I CAN HANDLE THIS EXCEPTION EITHER PUTTING SOME TIME TO BE UPDATED(THREAD.SLEEP)
         --> I REINITIALIZE MY ELEMENT BEFORE I DO MY ACTIONS O IT.
         --> You can also refresh the page.

       14)How do you handle the Alerts?

       There are different types of alerts I faced in my framework

       1) Operation System Alert:I cannot handle it directly, I need to use ROBOT CLASS (show off)

       2) HTML Alert: I just need to find element and click on it.(close)

       3)Javascript Alert (pop-ups)--> I handle this alerts/pop-ups with ALERT CLASS(RemoteAlertClass)

        Alert alert=driver.switchTo().Alert().

     15) For the alert Interface what kind of methods do you know?

     First of all, Alerts is an interface I agree, but the methods are coming from RemoteAlertClass

     I think you were checking me:)  //these are tips for you to make interview process warmer
     We have 4 methods of AlertClass:

     Alert alert= driver.switchTo().Alert();
         1)alert.Accept()-->which click the Ok Button
         2)alert.Dismiss()--> which clicks to cancel button
         3)alert.GetText()--> which gets the text from popup
         4)alert.SendKeys()--which sends the keys to popup

     16)What do  yuon know about iframe? can you tell me the type that you used before
     and how do you handle iframe in Selenium?
       16-2) Here is the secanrio we have a website and I would like to get the text of rice
        from products, All xpath is correct and theer is no problem with attribute as well. there
        is no problem with switching the window. But i can not get the price of the product.What do
        you think the reason could be?

        NOTE: iframe is basically HTML inside another HTML. The reason people are using iframe
        because they would like to get extra protection for their data like ) advertisement, videos...)
        The reason could be the Iframe, so basically I would do to the website and check the HTMl
        has an Iframe tage or not by typing(iframe or frame). If there is iframe on the HTMl, I would
        definitely check that the element I am looking ofr is not under the iframe.

            I CAN DEAL WITH IFRAME ELEMENTS BY SWITCHING MY DRIVER:
            driver.switchTo.frame():


            SHOW OFF PART:
          If you want i can give you more details about other methods for iframe LIKE:
          driver.switchTo.ParentFrame()--> which goes to the parent iframe
          driver.switchTo.defaultContent()-->which goes to the main HTML

          17) What do you know about ACTIONS class?
          Actions class basically does the functionality of my mouse and keyboard. I can say it is really useful my project to
          handle some elements.Some of the important methods
          actions class have:

          Actions actions= new Actions(driver)

          *MoveByOffset()
          *DoubleClick()
          *SendKeys()
          *ContextClick()-->Right Click
          *ClickAndHold. and release()
          *DragAndDrop()
          *MoveToElements()-->hover over
          *Click()
          *Perform()
          NOTE: You must put perform at he end to do your any actions methods you call.

           Keyboard:
           Keys.ENTER/RETURN
           KEYS.ARROW-UP, ARROW-DOWN, ARROW-RIGHT,ARROW-LEFT

 18) What is the difference between Find element and Find Elements()?

 *Find element: *driver.findElement(By."")
                *returns the single webElement
                * once it fails, it throws nopSuchElement exception

 *Find elements:* driver.findElements(By."")
                *returns the list of webElement
                * once it fails, it throws empty list of array.(no exception)

 19) What are the driver and webelement methods( IN never heard as an interview question)

 Driver methods:
 *get
 *navigate
 *getTitle
 *findelement/findelements
 *getCurrentUrl
 *getPageSiource
 *manage
 *close
 *quit

 Webelement methods:
 *senKeys
 *click
 *getText
 *Clear
 *Isdisplayed/IsEnabled/IsSelected
 *submit
 *GetAttribute
 *GetCssvalue

 20) What is the difference between check-box and radio button?
 CheckBox: you can click multiple boxes
 Radiobutton: you can choose  only one.

 21) Difference between isDisplayed, IsSelected, IsEnabled?

 All of them return boolean condition:
 *IsDisplayed: It displays the elements it is visible or not
 IsEnabled: It checks the element is enabled or not.--> (mostly I use it to click the element to make sure
 it is not disable)
 IsSelected: The element is selected or not( check mark inside the box)

 22)How do yuo switch the multiple windows?
 --> I can use driver.WindowHandle and driver. WindowHandles methods to switch my window
 and handle the elements from other websites. We use set to store our page ids.(unique)
 driver.switchTo().window(id);


 public static void switchByTitle(WebDriver driver, String title){
    Set<String> allPagesId= driver.getWindowHandles();
    for (String id: allPagesId){//internet --> new window
        driver.switchTo().window(id);
        if(driver.getTitle().contains(title)){
            break;
        }
    }

 23)How do you scroll down to the page from Web Browser ?

I would use JAVASCRIPT  with SCROLLINTOVIEW, ScrollTo (x,y) and POINT CLASS(show off answer)
//check your browser utils that we created for the more details.
    Point point= new Point()
    point.getX()--> coordinate of x
    point.getY()--> coordinate of y
    MoveByOffset(x,y)

 24)How do yuo download and upload file in selenium?
 *Find the element that triggers upload window.(choose button)
 *Find the path of the file you want to upload
 *driver.findElement(chooseButtton).sendKeys(Location of the file)(//C:Users//usa.png)

 25)What is the difference between ASSERT and SofASSERT?
 //to be honest the have similar logic in terms of the validation, but there is a couple differences
as much as I know
Assert: is a classs that have some methods to validate the actual and expected data with the methods
like assert,assertequals, assertTrue...
*When it fails, it immediately throws an exception the stop the executing next code.


SoftAssert: is a classs that have some methods to validate the actual and expected data with the methods
like assert,assertequals, assertTrue...
    *When it fails, it does not throws an exception then it keeps executing the next code.
    *** to be able to activate soft assert. You  have to softassert.asssertall method at he end

    Softassert sofasssert= new Softasssert();

 26)Can yuo tell me about Singleton? Have you ever used it in you project?
 First of all, I appracite for this question I love the singleton because in teh past once
 I was working on my driver. I was getting  lots of NULLPOINTER exceotion. But with help of Singleton
 pattern desgin,I made my driver more safe and reliable.
 How do I create Singleton Desing patter is:
 Encapsulation:
 1)I need to have private WenDriver
 2)I need to have private Constructor (because I do not watn anyone to create and obkect from this class)
 3)I create a public method to be called by other classes
 4)I use if conditions like (if driver==nu;; and initalize my driver) and return it

 27)CAn yuo tell me how you provide pictures once you find the bug?
 In my project, I have really good implementation for the screenshot. iT MEANS ONCE MY TEST
 FAIL my system takes screenshot of them and store.

 28) Do you know anything about DataProvider?
 28-1) What do you do with the same test with different scenarios?

 DataProvider is a way to execute your different set of data with the same test.
 @DataProvider(name="test")
 @Test(dataprovider="test")

 29)What do yuo know about the wait times?--> can you tell me the difference between
  implicit and explicit wait?

  Implicit wait: is a wait which waits for specific time while locating the elements.

      * when it does not find the element on a certain  time you provide. It throws NoSuchElement Exception

 Explicit wait: is a wait which applies to particular webelement until the
 EXPECTED CONDITION specified is met.
       WebdriverWait wait= new WebDriverWait(Duration.ofSeconds(10))
       wait.until.(ExpectedCondition.visibilityofElement(Webelement)
      * when it does not find the element on a certain  time you provide. It throws TimeoutException

30) We have different customers for the specific website login. I would like to test our all
customers login functionality is working or not. How would you test it?

DATA PROVIDER. You should talk how data provider works.

     */
}
