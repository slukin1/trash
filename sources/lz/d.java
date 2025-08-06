package lz;

import com.zendesk.logger.Logger;
import com.zendesk.service.ZendeskCallback;

public class d<T> extends ZendeskCallback<T> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f58081a = false;

    /* renamed from: b  reason: collision with root package name */
    public final ZendeskCallback<T> f58082b;

    public d(ZendeskCallback<T> zendeskCallback) {
        this.f58082b = zendeskCallback;
    }

    public static <T> d<T> a(ZendeskCallback<T> zendeskCallback) {
        return new d<>(zendeskCallback);
    }

    public void cancel() {
        this.f58081a = true;
    }

    public void onError(a aVar) {
        ZendeskCallback<T> zendeskCallback;
        if (this.f58081a || (zendeskCallback = this.f58082b) == null) {
            Logger.e("SafeZendeskCallback", aVar);
        } else {
            zendeskCallback.onError(aVar);
        }
    }

    public void onSuccess(T t11) {
        ZendeskCallback<T> zendeskCallback;
        if (this.f58081a || (zendeskCallback = this.f58082b) == null) {
            Logger.l("SafeZendeskCallback", "Operation was a success but callback is null or was cancelled", new Object[0]);
        } else {
            zendeskCallback.onSuccess(t11);
        }
    }
}
