package zendesk.classic.messaging;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public enum EngineListRegistry {
    INSTANCE;
    
    private final Map<String, List<c>> enginesRegistry;

    public String register(List<c> list) {
        String uuid = UUID.randomUUID().toString();
        this.enginesRegistry.put(uuid, list);
        return uuid;
    }

    public List<c> retrieveEngineList(String str) {
        return this.enginesRegistry.remove(str);
    }
}
