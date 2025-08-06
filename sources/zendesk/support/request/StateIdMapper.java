package zendesk.support.request;

import android.annotation.SuppressLint;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import mz.a;

class StateIdMapper implements Serializable {
    private final Map<Long, Long> localToRemote;
    private final Map<Long, Long> remoteToLocal;

    private StateIdMapper(Map<Long, Long> map, Map<Long, Long> map2) {
        this.remoteToLocal = map;
        this.localToRemote = map2;
    }

    public StateIdMapper addIdMapping(Long l11, Long l12) {
        this.remoteToLocal.put(l11, l12);
        this.localToRemote.put(l12, l11);
        return copy();
    }

    public StateIdMapper copy() {
        return new StateIdMapper(a.d(this.remoteToLocal), a.d(this.localToRemote));
    }

    public Long getLocalId(Long l11) {
        return this.remoteToLocal.get(l11);
    }

    public Long getRemoteId(Long l11) {
        return this.localToRemote.get(l11);
    }

    public Set<Long> getRemoteIds() {
        return this.remoteToLocal.keySet();
    }

    public boolean hasLocalId(Long l11) {
        return this.remoteToLocal.containsKey(l11) && this.localToRemote.containsValue(l11);
    }

    public boolean hasRemoteId(Long l11) {
        return this.localToRemote.containsKey(l11) && this.remoteToLocal.containsValue(l11);
    }

    public String toString() {
        return "IdMapper{ remoteToLocal=" + this.remoteToLocal + " localToRemote=" + this.localToRemote + '}';
    }

    @SuppressLint({"UseSparseArrays"})
    public StateIdMapper() {
        this.localToRemote = new HashMap();
        this.remoteToLocal = new HashMap();
    }
}
