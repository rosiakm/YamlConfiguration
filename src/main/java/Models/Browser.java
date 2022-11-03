package Models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;
@Data
@NoArgsConstructor
public class Browser {
    Map<String, Object> browserProperties = new LinkedHashMap<>();

    @JsonAnySetter
    void setProperties(String key, Object value) {
        browserProperties.put(key, value);
    }
    @JsonAnyGetter
    public Map<String, Object> getProperties(){
        return browserProperties;
    }
}
