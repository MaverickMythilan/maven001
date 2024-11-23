package com.baseclass;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;

public abstract class Base_Class {
	public static WebDriver driver;
	
	public static ExtentReports extentReports;
	
	public static File file;

	protected static WebDriver launchBrowser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}

		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING BROWSER LAUNCH");

		}
		driver.manage().window().maximize();
		return driver;
	}

	protected static WebDriver launchUrl(String url) {
		try {
			driver.get(url);

		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING URL LAUNCH");

		}
		return driver;
	}

	protected static void quitBrowser() {
		try {
			driver.quit();

		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING QUIT BROWSER");
		}
	}

	protected static void closeBrowser() {
		try {
			driver.close();

		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING CLOSE BROWSER");
		}
	}

	protected static void passValue(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING PASS VALUE");
		}

	}

	protected static void navigationPage(String url) {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING NAVIGATE TO OTHER URL");
		}
	}

	protected static void elementClick(WebElement element) {
		try {
			element.click();

		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING ELEMENT CLICK");
		}
	}

	protected static Select dropDownObject(WebElement element) {
		Select select = new Select(element);
		return select;
	}

	protected static void selectByVisibleText(WebElement element, String text) {
		try {
			dropDownObject(element).selectByVisibleText(text);

		} catch (Exception e) {
			Assert.fail("ERROR :OCCUR DURING SELECT BY VISIBLE TEXT");
		}
	}

	protected static void selectByIndex(WebElement element, int num) {
		try {
			dropDownObject(element).selectByIndex(num);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING SELECT BY INDEX  ");
		}
	}
	
	protected static void selectByWindowHandles(int num) {
		try {
			List<String> allWindow = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window(allWindow.get(num));
			
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING WINDOW HANDLES");
		}
	}
	// AlertObject
		protected static Alert switchingAlert(WebElement element) {

			Alert alert = driver.switchTo().alert();

			return alert;

		}

		// is enable
		protected static boolean isEnable(WebElement element) {
			return element.isEnabled();
		}

		// is displayed
		protected static boolean isDisplayed(WebElement element) {

			return element.isDisplayed();

		}

		// is selected
		protected static boolean isSelected(WebElement element) {

			return element.isSelected();
		}

		// implicit wait
		protected static void implicitWait(int seconds) {
			try {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
			} catch (Exception e) {
				Assert.fail("ERROR : PAGE IS NOT LOADING IN A GIVEN SECONDS");
			}
		}

		// Explicit wait
		protected static void explicitWait(WebElement element, int seconds) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
				wait.until(ExpectedConditions.visibilityOf(element));
				wait.until(ExpectedConditions.invisibilityOf(element));
			} catch (Exception e) {
				Assert.fail("ERROR : PAGE IS NOT LOADING IN A GIVEN SECONDS");
			}
		}
		
		protected static void explicitWaitCLicable(WebElement element, int seconds) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
				wait.until(ExpectedConditions.elementToBeClickable(element));
			} catch (Exception e) {
				Assert.fail("ERROR : PAGE IS NOT LOADING IN A GIVEN SECONDS");
			}
		}

		// action
		protected static Actions actionObject() {
			Actions action = new Actions(driver);
			return action;
		}

		// drag and drop element
		protected static void dragAndDrop(WebElement a, WebElement b) {
			try {
				actionObject().dragAndDrop(a, b);
			} catch (Exception e) {
				Assert.fail("ERROR : OCCURS DURING A DRAG AND DROP");
			}
		}

		// move curser on the element
		protected static void hoverTheElement(WebElement element) {
			try {
				actionObject().moveToElement(element).perform();
				;
			} catch (Exception e) {
				Assert.fail("ERROR : OCCURS DURING MOVE TO ELEMENT");
			}
		}

		// right click
		protected static void rightClick(WebElement element) {
			try {
				actionObject().contextClick().perform();
			} catch (Exception e) {
				Assert.fail("ERROR : OCCURS DURING RIGHT CLICK");
			}
		}

		// double click
		protected static void doubleClick(WebElement element) {
			try {
				actionObject().doubleClick().perform();
			} catch (Exception e) {
				Assert.fail("ERROR : OCCURS DURING DOUBLE CLICK");
			}
		}

		// move to the element and click
		protected static void moveToTHeElementAndClick(WebElement element) {
			try {
				actionObject().moveToElement(element).click().build().perform();
			} catch (Exception e) {
				Assert.fail("ERROR : OCCURS DURING MOVE TO ELEMENT AND CLICK");
			}
		}

		// screen shot
		protected static void takeScreenShot(String filePath) {
			TakesScreenshot screenShot = (TakesScreenshot) driver;

			try {
				File source = screenShot.getScreenshotAs(OutputType.FILE);
				File destination = new File(filePath);
				FileHandler.copy(source, destination);
			} catch (Exception e) {
				Assert.fail("ERROR : OCCURS DURING TAKING SCREENSHOT");
			}
		}

		// frames --> switch frame by the use of elements
		protected static void switchFrame(WebElement element) {
			try {
				driver.switchTo().frame(element);
			} catch (Exception e) {
				Assert.fail("ERROR : OCCURS DURING SWITCHING THE FRAME");
			}
		}
		
		//javaScrpt executer to scroll down
		protected static void scrollDown() {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,3000)");	
		}
			
			protected static void validation (String actual,String expected) {
				try {
					Assert.assertEquals(actual, expected);
				} catch (Exception e) {
					Assert.fail("ERROR OCCUR DURING VALIDATION");
				
				}
				
				
			}
			
			public static void extentRepotStart(String location) {
				extentReports = new ExtentReports();
				file = new File(location);
				ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
				extentReports.attachReporter(sparkReporter);
			}
			
			public static void extentTearDown(String location) throws IOException {
			extentReports.flush();
			file = new File(location);
			Desktop.getDesktop().browse((file).toURI());
			}
			
			public String takeScreenshot() throws IOException {
				
				TakesScreenshot screenshot =(TakesScreenshot) driver;
				String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
				File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
				File destfile = new File("Screenshort||.png" + "_" + timeStamp + ".png");
				FileUtils.copyFile(scrfile, destfile);
				return destfile.getAbsolutePath();
			}
			
			
				
	}
	

	

