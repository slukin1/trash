package zendesk.support.request;

import com.zendesk.logger.Logger;
import com.zendesk.service.ZendeskCallback;
import lz.a;
import mz.f;
import zendesk.support.Request;
import zendesk.support.RequestProvider;
import zendesk.support.request.AsyncMiddleware;
import zendesk.support.suas.Dispatcher;
import zendesk.support.suas.GetState;

class ActionLoadRequest implements AsyncMiddleware.AsyncAction {
    /* access modifiers changed from: private */

    /* renamed from: af  reason: collision with root package name */
    public final ActionFactory f62970af;
    private final RequestProvider requestProvider;

    public ActionLoadRequest(ActionFactory actionFactory, RequestProvider requestProvider2) {
        this.f62970af = actionFactory;
        this.requestProvider = requestProvider2;
    }

    public void actionQueued(Dispatcher dispatcher, GetState getState) {
        dispatcher.dispatch(this.f62970af.loadRequest());
    }

    public void execute(final Dispatcher dispatcher, GetState getState, final AsyncMiddleware.Callback callback) {
        StateConversation fromState = StateConversation.fromState(getState.getState());
        String remoteId = fromState.getRemoteId();
        if (!f.c(remoteId)) {
            Logger.b(RequestActivity.LOG_TAG, "Skip loading request. No remote id found.", new Object[0]);
            dispatcher.dispatch(this.f62970af.skipAction());
            callback.done();
        } else if (fromState.getStatus() != null) {
            Logger.b(RequestActivity.LOG_TAG, "Skip loading request. Request status already available.", new Object[0]);
            dispatcher.dispatch(this.f62970af.skipAction());
            callback.done();
        } else {
            this.requestProvider.getRequest(remoteId, new ZendeskCallback<Request>() {
                public void onError(a aVar) {
                    Logger.l(RequestActivity.LOG_TAG, "Error loading request. Error: '%s'", aVar.getReason());
                    dispatcher.dispatch(ActionLoadRequest.this.f62970af.loadRequestError(aVar));
                    callback.done();
                }

                public void onSuccess(Request request) {
                    dispatcher.dispatch(ActionLoadRequest.this.f62970af.loadRequestSuccess(request));
                    callback.done();
                }
            });
        }
    }
}
