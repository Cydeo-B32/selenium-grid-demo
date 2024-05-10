package cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * The {@code Driver} class is a utility for managing WebDriver instances using the Singleton pattern.
 * It provides methods to get a WebDriver instance and close it.
 */
public class Driver {

    // Private constructor to prevent instantiation from outside
    private Driver() {
    }

    // Thread-local variable to hold WebDriver instances
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    /**
     * Gets the singleton instance of WebDriver. If the instance is not initialized, it initializes it based on the
     * browser type specified in the configuration.
     *
     * @return The WebDriver instance.
     */
    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            // Get browser type from configuration
            String browserType = ConfigurationReader.getProperty("browser");

            // Initialize WebDriver based on browser type
            switch (browserType) {
                case "chrome":
                    driverPool.set(new ChromeDriver());
                    break;
                case "firefox":
                    driverPool.set(new FirefoxDriver());
                    break;
                case "edge":
                    driverPool.set(new EdgeDriver());
                    break;
                case "headless-chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless=new");
                    driverPool.set(new ChromeDriver(options));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid browser type specified in the configuration: " + browserType);
            }

            // Maximize the browser window and set implicit wait
            driverPool.get().manage().window().maximize();
            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driverPool.get();
    }

    /**
     * Closes the WebDriver instance and removes it from the thread-local variable.
     * If the instance is not null, it quits the WebDriver.
     */
    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit(); // Quit the WebDriver instance
            driverPool.remove(); // Remove the WebDriver instance from the thread-local variable
        }
    }
}
