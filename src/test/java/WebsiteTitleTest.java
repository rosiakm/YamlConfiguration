import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class WebsiteTitleTest extends TestBase {
    private static Logger log = LoggerFactory.getLogger(WebsiteTitleTest.class);

    @Test
    void checkTitleTest(){
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(System.getProperty("title"));
    }
}
