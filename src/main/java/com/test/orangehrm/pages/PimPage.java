package com.test.orangehrm.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/*
1)Click PIM on the mainpage
    2)Click Add button under PIM
    3)Fill the boxes
    4)Click Save Button
    5)Wait for the next direction
 */

public class PimPage {

    public PimPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "btnAdd")
    WebElement addButton;

    @FindBy(id="firstName")
    WebElement firstname;

    @FindBy(id="lastName")
    WebElement lastname;

    @FindBy(id="employeeId")
    WebElement employeeid;

    @FindBy(id="photofile")
    WebElement choosefile;

    @FindBy(id="btnSave")
    WebElement savebutton;

    @FindBy(name="personal[txtEmpFirstName]")
    WebElement validationName;

    @FindBy(name="personal[txtEmpLastName]")
    WebElement validationlastname;

    @FindBy(id= "personal_txtEmployeeId")
    WebElement validationEmployeeid;

    @FindBy(id="btnSave")
    WebElement editbutton;

    @FindBy(id="personal_optGender_1")
    WebElement gendermale;

    @FindBy(id="personal_cmbNation")
    WebElement nationality;

    @FindBy(id="personal_cmbMarital")
    WebElement maritalstatus;

    @FindBy(id="personal_DOB")
    WebElement dateofbirth;

    public void addEmployeeForPIM(String name, String lastname, String employeeid, String uploadfile) throws InterruptedException {
        addButton.click();
       this.firstname.sendKeys(name);
       this.lastname.sendKeys(lastname);
       this.employeeid.sendKeys(employeeid);
       this.choosefile.sendKeys(uploadfile); // hard code version "C:\\Users\\diamo\\Desktop\\USA.png"
       Thread.sleep(1000);
       savebutton.click();
       Thread.sleep(1000);
            }

  public String validateFirstName(){
        return validationName.getAttribute("value");
  }

    public String validateLastName(){
        return validationlastname.getAttribute("value");
    }

    public boolean validatEmployeeid(String employeeid){
        return validationEmployeeid.getAttribute("value").endsWith(employeeid);
    }

    public  void editPersonalDetails(String nation, String dateofbirth, String maritalstatus){
        editbutton.click();
        gendermale.click();
        BrowserUtils.selectBy(nationality, nation,"text");
       this.dateofbirth.clear();
       this.dateofbirth.sendKeys(dateofbirth);
       BrowserUtils.selectBy(this.maritalstatus, maritalstatus, "text");
       savebutton.click();
    }
    public String validateTheNationality(){
        Select select= new Select(nationality);
        return select.getFirstSelectedOption().getText().trim();
    }

}
