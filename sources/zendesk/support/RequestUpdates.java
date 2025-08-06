package zendesk.support;

import java.util.Collections;
import java.util.Map;
import mz.a;

public final class RequestUpdates {
    private final Map<String, Integer> requestIds;

    public RequestUpdates(Map<String, Integer> map) {
        if (map == null) {
            this.requestIds = Collections.emptyMap();
        } else {
            this.requestIds = map;
        }
    }

    public Map<String, Integer> getRequestUpdates() {
        return a.d(this.requestIds);
    }

    public boolean hasUpdatedRequests() {
        return !this.requestIds.isEmpty();
    }

    public boolean isRequestUnread(String str) {
        return this.requestIds.containsKey(str) && this.requestIds.get(str).intValue() > 0;
    }

    public int totalUpdates() {
        int i11 = 0;
        for (Integer intValue : this.requestIds.values()) {
            i11 += intValue.intValue();
        }
        return i11;
    }
}
