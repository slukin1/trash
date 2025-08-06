package zendesk.support.requestlist;

import java.util.HashSet;
import java.util.Set;
import lz.d;

class CancelableCompositeCallback {
    private Set<d> zendeskCallbacks = new HashSet();

    public void add(d... dVarArr) {
        for (d add : dVarArr) {
            add(add);
        }
    }

    public void cancel() {
        for (d cancel : this.zendeskCallbacks) {
            cancel.cancel();
        }
        this.zendeskCallbacks.clear();
    }

    public void add(d dVar) {
        this.zendeskCallbacks.add(dVar);
    }
}
