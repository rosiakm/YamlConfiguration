package Factory;

import Models.Browser;
import Models.EnvironmentAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class AllProperties {
    private static Logger log = LoggerFactory.getLogger(AllProperties.class);
    YamlReader yamlReader = new YamlReader();
    private Browser browser;
    private List<EnvironmentAttributes> listOfEnvironments;

    private AllProperties(){
        setBrowserProperties();
        setEnvironmentProperties();
    }

    public static AllProperties getInstance(){
        return AllProperties.AllPropertiesSingleton.INSTANCE;
    }

    private void setEnvironmentProperties(){
        listOfEnvironments = yamlReader.getConfig().getEnvironment().getEnvironments();
        for (EnvironmentAttributes envAttributes : listOfEnvironments){
            if(envAttributes.isActive()){
                Map<String, Object> envProperties = envAttributes.getProperties();
                for (Map.Entry entry : envProperties.entrySet()){
                    System.setProperty(entry.getKey().toString(), entry.getValue().toString());
                    log.info("Load env properties: {} = {}", entry.getKey().toString(), entry.getValue().toString());
                }
                break;
            }
        }
    }
    private void setBrowserProperties(){
        browser = yamlReader.getConfig().getBrowser();
        Map<String, Object> browserProperties = browser.getProperties();
        for (Map.Entry entry : browserProperties.entrySet()){
            System.setProperty(entry.getKey().toString(), entry.getValue().toString());
            log.info("Load env properties: {} = {}", entry.getKey().toString(), entry.getValue().toString());
        }
    }
    public static class AllPropertiesSingleton {
        private static final AllProperties INSTANCE = new AllProperties();
    }
}
