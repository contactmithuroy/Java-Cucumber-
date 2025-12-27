package eal.utilities;

import java.time.Duration;
import java.util.HashMap;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Driver {
	// Constractor:

	public Driver() {

	}

	public static WebDriver driver;
	public static final Logger logger = LogManager.getLogger(Driver.class);

	// Default download Path:
	public static String downloadFolderPath = System.getProperty("user.dir") + "\\Downloads";

	public static String browser = System.getProperty("browser", "chrome");

	public static WebDriver getDriver() {
		// Backup code if browser is not given in maven command/pipeline
		if (driver == null) {
			if (browser == null || browser.isBlank()) {
				logger.info(LogColor.RED + "Current Browser is Null so launching Edge by Default for pipeline"
						+ LogColor.RESET);
				browser = "edge";
			}

			EdgeOptions edgeOptions = new EdgeOptions();
			ChromeOptions chromeOptions = new ChromeOptions();

			/*
			 * Useful When to Use
				This setup is useful when:
				Automating file downloads				
				Running tests in CI/CD pipelines				
				Avoiding browser popups and permission dialogs				
				Running tests in parallel				
				Ensuring each test run has a clean browser profile
			 */
			HashMap<String, Object> edgePrefs = new HashMap<>();
			HashMap<String, Object> chromePrefs = new HashMap<>();
			switch (browser) {
			case "edge":
				// Set up preferences
				edgePrefs.put("download.default_directory", downloadFolderPath);
				//Downloads go to a known folder (no OS prompt)
				
				edgePrefs.put("profile.default_content_settings.popups", 0);
				//Disables popups
				
				edgePrefs.put("profile.default_zoom_level", 0);
				//Prevents zoom inconsistencies
				
				edgePrefs.put("profile.default_content_setting_values.automatic_downloads", 1);
				//Allows multiple downloads automatically
				
				edgePrefs.put("download.prompt_for_download", false);
				//Disables “Save As” dialog
				
				edgeOptions.setExperimentalOption("prefs", edgePrefs);
				//Applies preferences to Edge browser
				

				// Arguments:
				edgeOptions.addArguments("--inprivate"); // Enable headless mode
				//Launches Edge in private mode (no cache, cookies)
				
				edgeOptions.addArguments("disable-gpu"); 
				// Disable GPU acceleration
				
				edgeOptions.addArguments("--disable-notifications");
				//Blocks notification popups
				edgeOptions.addArguments("--no-download-notification");
				//Block download notification 
				edgeOptions.addArguments("--window-size=1920,1080");
				edgeOptions.addArguments("--force-device-scale-factor=1");
				edgeOptions.addArguments("--high-dpi-support=1");
				//Prevents scaling issues on high-DPI screens

				// Generate a unique user data directory for, Cookie leakage, Session reuse,Parallel execution conflicts
				logger.info("creating temp directory in -Edge");
				String tempUserDataDir = System.getProperty("java.io.tmpdir") + "/edge-profile-" + UUID.randomUUID();
				edgeOptions.addArguments("--user-data-dir=" + tempUserDataDir);
				// Save it for cleanup
				System.setProperty("edge.temp.profile", tempUserDataDir);

				// launch Browser
				driver = new EdgeDriver(edgeOptions);

				break;

			case "chrome":
				// Set up preferences

				chromePrefs.put("download.default_directory", downloadFolderPath);
				chromePrefs.put("profile.default_content_settings.popups", 0);
				chromePrefs.put("profile.default_zoom_level", 0);
				chromePrefs.put("profile.default_content_setting_values.automatic_downloads", 1);
				chromePrefs.put("download.prompt_for_download", false);

				chromeOptions.setExperimentalOption("prefs", chromePrefs);

				// Arguments
				chromeOptions.addArguments("--incognito"); // Chrome equivalent of Edge's inprivate
				chromeOptions.addArguments("--disable-gpu"); // Disable GPU acceleration
				chromeOptions.addArguments("--disable-notifications");
				chromeOptions.addArguments("--no-download-notification");
				chromeOptions.addArguments("--window-size=1920,1080");
				chromeOptions.addArguments("--force-device-scale-factor=1");
				chromeOptions.addArguments("--high-dpi-support=1");

				// Generate a unique user data directory
				logger.info("creating temp directory in -Chrome");
				String tempUserDataDirchrome = System.getProperty("java.io.tmpdir") + "/chrome-profile-"
						+ UUID.randomUUID();
				chromeOptions.addArguments("--user-data-dir=" + tempUserDataDirchrome);

				// Save it for cleanup
				System.setProperty("chrome.temp.profile", tempUserDataDirchrome);

				// Launch Browser
				driver = new ChromeDriver(chromeOptions);
				break;
				
			case "edge-headless":
			    // Set up preferences
			    edgePrefs.put("download.default_directory", downloadFolderPath);
			    edgePrefs.put("profile.default_content_settings.popups", 0);
			    edgePrefs.put("profile.default_zoom_level", 0);
			    edgePrefs.put("profile.default_content_setting_values.automatic_downloads", 1);
			    edgePrefs.put("download.prompt_for_download", false);
			    edgeOptions.setExperimentalOption("prefs", edgePrefs);

			    // Arguments:
			    edgeOptions.addArguments("--headless"); // Enable headless mode
			    edgeOptions.addArguments("--inprivate");
			    edgeOptions.addArguments("--disable-gpu"); // Disable GPU acceleration
			    edgeOptions.addArguments("--disable-notifications");
			    edgeOptions.addArguments("--no-download-notification");
			    edgeOptions.addArguments("--window-size=1920,1080");
			    edgeOptions.addArguments("--force-device-scale-factor=1");
			    edgeOptions.addArguments("--high-dpi-support=1");
			    edgeOptions.addArguments("--disable-dev-shm-usage"); // Overcome limited resource problems
			    edgeOptions.addArguments("--no-sandbox"); // Bypass OS security model

			    // Generate a unique user data directory
			    logger.info("creating temp directory in -Edge Headless");
			    String tempUserDataDirEdgeHeadless = System.getProperty("java.io.tmpdir") + "/edge-headless-profile-" + UUID.randomUUID();
			    edgeOptions.addArguments("--user-data-dir=" + tempUserDataDirEdgeHeadless);
			    // Save it for cleanup
			    System.setProperty("edge.temp.profile", tempUserDataDirEdgeHeadless);

			    // launch Browser
			    driver = new EdgeDriver(edgeOptions);
			    break;

			case "chrome-headless":
			    // Set up preferences
			    chromePrefs.put("download.default_directory", downloadFolderPath);
			    chromePrefs.put("profile.default_content_settings.popups", 0);
			    chromePrefs.put("profile.default_zoom_level", 0);
			    chromePrefs.put("profile.default_content_setting_values.automatic_downloads", 1);
			    chromePrefs.put("download.prompt_for_download", false);
			    chromeOptions.setExperimentalOption("prefs", chromePrefs);

			    // Arguments
			    chromeOptions.addArguments("--headless"); // Enable headless mode
			    chromeOptions.addArguments("--incognito");
			    chromeOptions.addArguments("--disable-gpu"); // Disable GPU acceleration
			    chromeOptions.addArguments("--disable-notifications");
			    chromeOptions.addArguments("--no-download-notification");
			    chromeOptions.addArguments("--window-size=1920,1080");
			    chromeOptions.addArguments("--force-device-scale-factor=1");
			    chromeOptions.addArguments("--high-dpi-support=1");
			    chromeOptions.addArguments("--disable-dev-shm-usage"); // Overcome limited resource problems
			    chromeOptions.addArguments("--no-sandbox"); // Bypass OS security model

			    // Generate a unique user data directory
			    logger.info("creating temp directory in -Chrome Headless");
			    String tempUserDataDirChromeHeadless = System.getProperty("java.io.tmpdir") + "/chrome-headless-profile-" + UUID.randomUUID();
			    chromeOptions.addArguments("--user-data-dir=" + tempUserDataDirChromeHeadless);

			    // Save it for cleanup
			    System.setProperty("chrome.temp.profile", tempUserDataDirChromeHeadless);

			    // Launch Browser
			    driver = new ChromeDriver(chromeOptions);
			    break;

			}
		}
		driver.manage().deleteAllCookies();
		return driver;
	}
	public static void closeDriver() {
		if(driver == null) {
			driver.quit();
			driver = null;
		}
	}
	public static void BrowserSetup() {
		logger.info(LogColor.RED + "Browser Setup" + LogColor.RESET);
		Driver.getDriver().manage().deleteAllCookies();
		Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Driver.getDriver().manage().window().maximize();
		String URL = ConfigurationReader.getProperty("url");
		Driver.getDriver().get(URL);
		logger.info("URL Lunched:" + ConfigurationReader.getProperty("url"));
		CommonMethods.waitForPageAndAjaxToLoad();
	}

}
