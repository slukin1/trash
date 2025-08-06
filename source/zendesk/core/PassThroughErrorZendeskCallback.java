package zendesk.core;

import com.zendesk.service.ZendeskCallback;
import lz.a;

abstract class PassThroughErrorZendeskCallback<E> extends ZendeskCallback<E> {
    private final ZendeskCallback callback;

    public PassThroughErrorZendeskCallback(ZendeskCallback zendeskCallback) {
        this.callback = zendeskCallback;
    }

    public void onError(a aVar) {
        ZendeskCallback zendeskCallback = this.callback;
        if (zendeskCallback != null) {
            zendeskCallback.onError(aVar);
        }
    }

    public abstract void onSuccess(E e11);
}
