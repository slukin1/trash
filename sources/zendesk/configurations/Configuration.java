package zendesk.configurations;

import java.io.Serializable;
import java.util.List;

public interface Configuration extends Serializable {
    List<Configuration> getConfigurations();
}
