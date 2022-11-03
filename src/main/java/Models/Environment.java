package Models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@Data
@NoArgsConstructor
public class Environment {
    Map<String, EnvironmentAttributes> environments = new LinkedHashMap<>();

    @JsonAnySetter
    void setProperties(String key, EnvironmentAttributes value) {
        environments.put(key, value);
    }
    @JsonAnyGetter
    public List<EnvironmentAttributes> getEnvironments(){
        return this.environments.values().stream().toList();
    }
}
