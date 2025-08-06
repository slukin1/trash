package zendesk.support.request;

import android.content.Context;
import com.zendesk.service.ZendeskCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import lz.a;
import zendesk.core.ActionHandlerRegistry;
import zendesk.support.RequestStatus;
import zendesk.support.request.AsyncMiddleware;
import zendesk.support.requestlist.RequestInfo;
import zendesk.support.requestlist.RequestInfoDataSource;
import zendesk.support.requestlist.RequestListActivity;
import zendesk.support.suas.Listener;

class ComponentUpdateActionHandlers implements Listener<StateConversation> {
    /* access modifiers changed from: private */
    public final ActionHandlerRegistry actionHandlerRegistry;
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public final RequestInfoDataSource.LocalDataSource localDataSource;
    /* access modifiers changed from: private */
    public final AsyncMiddleware.Queue queue = new AsyncMiddleware.Queue();

    public class RefreshCallback extends ZendeskCallback<List<RequestInfo>> {
        private final AsyncMiddleware.Callback callback;

        public void onError(a aVar) {
            this.callback.done();
            if (!ComponentUpdateActionHandlers.this.queue.isRunning()) {
                RequestListActivity.refresh(ComponentUpdateActionHandlers.this.context, ComponentUpdateActionHandlers.this.actionHandlerRegistry);
            }
        }

        private RefreshCallback(AsyncMiddleware.Callback callback2) {
            this.callback = callback2;
        }

        public void onSuccess(List<RequestInfo> list) {
            this.callback.done();
            if (!ComponentUpdateActionHandlers.this.queue.isRunning()) {
                RequestListActivity.refresh(ComponentUpdateActionHandlers.this.context, ComponentUpdateActionHandlers.this.actionHandlerRegistry);
            }
        }
    }

    public ComponentUpdateActionHandlers(Context context2, ActionHandlerRegistry actionHandlerRegistry2, RequestInfoDataSource.LocalDataSource localDataSource2) {
        this.context = context2;
        this.actionHandlerRegistry = actionHandlerRegistry2;
        this.localDataSource = localDataSource2;
    }

    private List<RequestInfo.AgentInfo> getLast5AgentInfos(List<StateMessage> list, List<StateRequestUser> list2) {
        HashMap hashMap = new HashMap(list2.size());
        for (StateRequestUser next : list2) {
            long id2 = next.getId();
            if (next.isAgent() && !hashMap.containsKey(Long.valueOf(id2))) {
                hashMap.put(Long.valueOf(id2), next);
            }
        }
        ArrayList arrayList = new ArrayList();
        List<TypeT> c11 = mz.a.c(list);
        Collections.reverse(c11);
        for (TypeT userId : c11) {
            long userId2 = userId.getUserId();
            if (hashMap.containsKey(Long.valueOf(userId2))) {
                StateRequestUser stateRequestUser = (StateRequestUser) hashMap.get(Long.valueOf(userId2));
                arrayList.add(new RequestInfo.AgentInfo(String.valueOf(userId2), stateRequestUser.getName(), stateRequestUser.getAvatar()));
                if (arrayList.size() == 5) {
                    break;
                }
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    private boolean hasPendingMessages(StateConversation stateConversation) {
        for (StateMessage state : stateConversation.getMessages()) {
            if (state.getState().getStatus() == 3) {
                return true;
            }
        }
        return false;
    }

    private RequestInfo map(StateConversation stateConversation) {
        List<StateMessage> messages = stateConversation.getMessages();
        if (mz.a.g(messages)) {
            return null;
        }
        String localId = stateConversation.getLocalId();
        String remoteId = stateConversation.getRemoteId();
        RequestStatus status = stateConversation.getStatus();
        StateMessage stateMessage = messages.get(0);
        StateMessage stateMessage2 = messages.get(stateConversation.getMessages().size() - 1);
        Date date = stateMessage2.getDate();
        List<RequestInfo.AgentInfo> last5AgentInfos = getLast5AgentInfos(stateConversation.getMessages(), stateConversation.getUsers());
        RequestInfo.MessageInfo messageInfo = new RequestInfo.MessageInfo(String.valueOf(stateMessage.getId()), stateMessage.getDate(), stateMessage.getBody());
        RequestInfo.MessageInfo messageInfo2 = new RequestInfo.MessageInfo(String.valueOf(stateMessage2.getId()), stateMessage2.getDate(), stateMessage2.getBody());
        HashSet hashSet = new HashSet();
        for (StateMessage next : messages) {
            String valueOf = String.valueOf(next.getId());
            if (next.getState().getStatus() == 1) {
                hashSet.add(valueOf);
            }
        }
        return new RequestInfo(localId, remoteId, status, false, date, last5AgentInfos, messageInfo, messageInfo2, hashSet);
    }

    public void update(final StateConversation stateConversation) {
        final RequestInfo map = map(stateConversation);
        if (map == null) {
            this.queue.dispatch(new AsyncMiddleware.Item() {
                public void execute(AsyncMiddleware.Callback callback) {
                    ComponentUpdateActionHandlers.this.localDataSource.remove(stateConversation.getLocalId(), new RefreshCallback(callback));
                }
            });
        } else if (!hasPendingMessages(stateConversation)) {
            this.queue.dispatch(new AsyncMiddleware.Item() {
                public void execute(AsyncMiddleware.Callback callback) {
                    ComponentUpdateActionHandlers.this.localDataSource.insert(map, new RefreshCallback(callback));
                }
            });
        }
    }
}
