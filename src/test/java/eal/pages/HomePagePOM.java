package eal.pages;
import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import eal.utilities.CommonMethods;
import eal.utilities.LogColor;

public class HomePagePOM extends CommonMethods {
	 private static final Logger logger = LogManager.getLogger(CommonMethods.class);
	 
	 //@FindBy(xpath ="//td[contains(text(),'UserID')]")
	 //@FindBy(xpath ="td:contains('UserID')")
	 	//public WebElement user_id_text_By;
	
	 //@FindBy(xpath = "//td[contains(text(),'Password')]")
	 	//public WebElement password_text_By;
	 
	 By user_id_text = By.xpath("//td[contains(text(),'UserID')]");
	 By password_text = By.xpath("//td[contains(text(),'Password')]");
	 By loginBtn = By.xpath("//input[@type='submit' and @name='btnLogin']");
	 By seleniumBtn = By.xpath("//a[contains(normalize-space(text()),'Selenium') and @class='dropdown-toggle']");
	 By tableDemoBtn = By.xpath("//a[contains(text(),'Table Demo')]");
	 //By tableDemoBtn = By.xpath("//ul[@class='dropdown-menu']//a[text()='Table Demo']");
	 By dropDownManu = By.xpath("//ul[@class='dropdown-menu']");	 
	 
	 
	 
	 
	 	public boolean verify_homepage_title() {
		 try {
			 logger.info("Getting the Actual Title");
			 String actualTitle = driver.getTitle();
			 logger.info("Got the title");
			 
			 String expectedTitle = "Guru99 Bank Home Page";
			 if(actualTitle.equals(expectedTitle)) {
				 return true;
			 }else {
				 return false;
			 }
		} catch (Exception e) {
			logger.error(LogColor.RED+e + LogColor.RESET);
			return false;
		}
	 }
	 
	 public boolean verify_userid_isVisible() {
		 try {
			boolean presenece = isElementPresent(user_id_text);
			if(presenece) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			logger.error(LogColor.RED+e + LogColor.RESET);
			return false;
		}
	 }
	 
	 public boolean verify_password_isVisible() {
		 try {
			 boolean presenece = isElementPresent(password_text);
			 if(presenece) {
					return true;
				}else {
					return false;
				}
		} catch (Exception e) {
			logger.error(LogColor.RED+e + LogColor.RESET);
			return false;
		}
	 }
	 
	 public boolean verify_loginBtn_isVisible() {
		 try {
			 boolean presenece = isElementPresent(loginBtn);
			 if(presenece) {
					return true;
				}else {
					return false;
				}
		} catch (Exception e) {
			logger.error(LogColor.RED+e + LogColor.RESET);
			return false;
		}
	 }
	 
	 public boolean verify_seleniumBtn_isVisible() {
		 try {
			 boolean presenece = isElementPresent(seleniumBtn);
			 if(presenece) {
					return true;
				}else {
					return false;
				}
		} catch (Exception e) {
			logger.error(LogColor.RED+e + LogColor.RESET);
			return false;
		}
	 }
	 
	 public boolean click_on_seleniumBtn() {
		    try {
		        WebElement element = waitForElement(seleniumBtn);
		        waitForClickablility(element);
		        clickAndDraw(element);
		        boolean presenece = isElementPresent(dropDownManu);
				 if(presenece) {
						return true;
					}else {
						logger.error(LogColor.RED+"Dropdown List is not Expand"
								+ "" + LogColor.RESET);
						return false;
					}
		    } catch (Exception e) {
		        logger.error(LogColor.RED+ "Failed to click on Selenium button: " + e.getMessage()+ LogColor.RESET);
		        return false; 
		    }
		}
	 
	 public boolean verify_table_demo_isVisible() {
		 try {
			 boolean presenece = isElementPresent(tableDemoBtn);
			 if(presenece) {
					return true;
				}else {
					return false;
				}
		} catch (Exception e) {
			logger.error(LogColor.RED+e + LogColor.RESET);
			return false;
		}
	 }
	 
	 
	 
}
