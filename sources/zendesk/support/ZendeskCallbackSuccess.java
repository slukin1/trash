package zendesk.support;

import com.zendesk.service.ZendeskCallback;
import lz.a;

abstract class ZendeskCallbackSuccess<E> extends ZendeskCallback<E> {
    private final ZendeskCallback callback;

    public ZendeskCallbackSuccess(ZendeskCallback zendeskCallback) {
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
