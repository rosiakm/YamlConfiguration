package Models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class EnvironmentAttributes {
    boolean active;
    public boolean isActive() {
        return active;
    }

    Map<String, Object> properties = new LinkedHashMap<>();

    @JsonAnySetter
    void setProperties(String key, Object value) {
        properties.put(key, value);
    }
    @JsonAnyGetter
    public Map<String, Object> getProperties(){
        return properties;
    }
}
