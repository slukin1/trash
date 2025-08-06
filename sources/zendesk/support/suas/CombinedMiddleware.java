package zendesk.support.suas;

import java.util.Collection;
import java.util.Iterator;

class CombinedMiddleware implements Middleware {
    private final Collection<Middleware> middleware;

    public CombinedMiddleware(Collection<Middleware> collection) {
        if (collection == null || collection.size() == 0) {
            this.middleware = null;
        } else {
            this.middleware = collection;
        }
    }

    /* access modifiers changed from: private */
    public void loopThroughMiddleware(Action<?> action, GetState getState, Dispatcher dispatcher, Continuation continuation, Iterator<Middleware> it2) {
        if (it2.hasNext()) {
            final GetState getState2 = getState;
            final Dispatcher dispatcher2 = dispatcher;
            final Continuation continuation2 = continuation;
            final Iterator<Middleware> it3 = it2;
            it2.next().onAction(action, getState, dispatcher, new Continuation() {
                public void next(Action<?> action) {
                    CombinedMiddleware.this.loopThroughMiddleware(action, getState2, dispatcher2, continuation2, it3);
                }
            });
            return;
        }
        continuation.next(action);
    }

    public void onAction(Action<?> action, GetState getState, Dispatcher dispatcher, Continuation continuation) {
        Collection<Middleware> collection = this.middleware;
        if (collection != null) {
            loopThroughMiddleware(action, getState, dispatcher, continuation, collection.iterator());
            return;
        }
        continuation.next(action);
    }
}
