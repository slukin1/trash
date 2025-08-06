package zendesk.support.guide;

import com.zendesk.service.ZendeskCallback;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import lz.a;
import lz.d;

final class AggregatedCallback<T> extends ZendeskCallback<T> {
    private final Set<d<T>> callbackSet = Collections.synchronizedSet(new HashSet());

    public boolean add(ZendeskCallback<T> zendeskCallback) {
        boolean isEmpty = this.callbackSet.isEmpty();
        this.callbackSet.add(d.a(zendeskCallback));
        return isEmpty;
    }

    public void cancel() {
        for (d<T> cancel : this.callbackSet) {
            cancel.cancel();
        }
        this.callbackSet.clear();
    }

    public void onError(a aVar) {
        for (d<T> onError : this.callbackSet) {
            onError.onError(aVar);
        }
        this.callbackSet.clear();
    }

    public void onSuccess(T t11) {
        for (d<T> onSuccess : this.callbackSet) {
            onSuccess.onSuccess(t11);
        }
        this.callbackSet.clear();
    }
}
