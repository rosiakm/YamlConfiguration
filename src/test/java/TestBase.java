import Factory.AllProperties;
import Factory.BrowserFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase {
    private static Logger log = LoggerFactory.getLogger(TestBase.class);

    public WebDriver driver;
    private static BrowserFactory browserFactory;
    private static AllProperties allProperties;

    @BeforeAll
    static void setUp(){
        allProperties = AllProperties.getInstance();
        browserFactory = new BrowserFactory();
    }
    @BeforeEach
    void beforeEach(){
        driver = browserFactory.getDriver();
        log.info("<<<<<<Driver initialized>>>>>>>");
        driver.get(System.getProperty("appUrl"));
        log.info("Url loaded: " + System.getProperty("appUrl"));
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
        log.info("<<<<<<Driver has been quit>>>>>>");
    }
}
