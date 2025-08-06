package zendesk.support.request;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import mz.a;
import mz.f;
import zendesk.support.SupportUiStorage;
import zendesk.support.suas.Listener;
import zendesk.support.suas.State;
import zendesk.support.suas.StateSelector;

class ComponentPersistence implements Listener<RequestPersistenceModel> {
    private static final String LOG_TAG = "ComponentPersistence";
    private final Executor executor;
    /* access modifiers changed from: private */
    public final AtomicBoolean isMappingComplete = new AtomicBoolean(false);
    private final PersistenceSelector persistenceSelector;
    private final PersistenceQueue queue;
    /* access modifiers changed from: private */
    public final SupportUiStorage supportUiStorage;

    public interface Item {
        void persist();
    }

    public static class PersistenceItem implements Item {
        private final RequestPersistenceModel model;
        private final SupportUiStorage supportUiStorage;

        public PersistenceItem(SupportUiStorage supportUiStorage2, RequestPersistenceModel requestPersistenceModel) {
            this.supportUiStorage = supportUiStorage2;
            this.model = requestPersistenceModel;
        }

        public void persist() {
            this.supportUiStorage.write(this.model.getLocalRequestId(), this.model);
        }
    }

    public static class PersistenceQueue {
        /* access modifiers changed from: private */
        public final List<Item> actions = new ArrayList(2);
        private final Executor executor;
        /* access modifiers changed from: private */
        public final AtomicBoolean workerRunning = new AtomicBoolean(false);

        public class Worker implements Runnable {
            private Worker() {
            }

            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
                zendesk.support.request.ComponentPersistence.PersistenceQueue.access$300(r3.this$0).remove(r1);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
                throw r0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:7:0x0021, code lost:
                if (r1 == null) goto L_0x0000;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
                r1.persist();
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r3 = this;
                L_0x0000:
                    zendesk.support.request.ComponentPersistence$PersistenceQueue r0 = zendesk.support.request.ComponentPersistence.PersistenceQueue.this
                    java.util.List r0 = r0.actions
                    monitor-enter(r0)
                    zendesk.support.request.ComponentPersistence$PersistenceQueue r1 = zendesk.support.request.ComponentPersistence.PersistenceQueue.this     // Catch:{ all -> 0x0046 }
                    java.util.List r1 = r1.actions     // Catch:{ all -> 0x0046 }
                    int r1 = r1.size()     // Catch:{ all -> 0x0046 }
                    r2 = 0
                    if (r1 <= 0) goto L_0x003b
                    zendesk.support.request.ComponentPersistence$PersistenceQueue r1 = zendesk.support.request.ComponentPersistence.PersistenceQueue.this     // Catch:{ all -> 0x0046 }
                    java.util.List r1 = r1.actions     // Catch:{ all -> 0x0046 }
                    java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0046 }
                    zendesk.support.request.ComponentPersistence$Item r1 = (zendesk.support.request.ComponentPersistence.Item) r1     // Catch:{ all -> 0x0046 }
                    monitor-exit(r0)     // Catch:{ all -> 0x0046 }
                    if (r1 == 0) goto L_0x0000
                    r1.persist()     // Catch:{ Exception -> 0x0026, all -> 0x0030 }
                L_0x0026:
                    zendesk.support.request.ComponentPersistence$PersistenceQueue r0 = zendesk.support.request.ComponentPersistence.PersistenceQueue.this
                    java.util.List r0 = r0.actions
                    r0.remove(r1)
                    goto L_0x0000
                L_0x0030:
                    r0 = move-exception
                    zendesk.support.request.ComponentPersistence$PersistenceQueue r2 = zendesk.support.request.ComponentPersistence.PersistenceQueue.this
                    java.util.List r2 = r2.actions
                    r2.remove(r1)
                    throw r0
                L_0x003b:
                    zendesk.support.request.ComponentPersistence$PersistenceQueue r1 = zendesk.support.request.ComponentPersistence.PersistenceQueue.this     // Catch:{ all -> 0x0046 }
                    java.util.concurrent.atomic.AtomicBoolean r1 = r1.workerRunning     // Catch:{ all -> 0x0046 }
                    r1.set(r2)     // Catch:{ all -> 0x0046 }
                    monitor-exit(r0)     // Catch:{ all -> 0x0046 }
                    return
                L_0x0046:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x0046 }
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: zendesk.support.request.ComponentPersistence.PersistenceQueue.Worker.run():void");
            }
        }

        public PersistenceQueue(Executor executor2) {
            this.executor = executor2;
        }

        private void startWorker() {
            if (this.workerRunning.compareAndSet(false, true)) {
                this.executor.execute(new Worker());
            }
        }

        public void dispatch(Item item) {
            if (item != null) {
                synchronized (this.actions) {
                    if (this.actions.size() >= 2) {
                        this.actions.set(1, item);
                    } else {
                        this.actions.add(item);
                    }
                    startWorker();
                }
            }
        }
    }

    public static class PersistenceSelector implements StateSelector<RequestPersistenceModel> {
        public RequestPersistenceModel selectData(State state) {
            StateConversation fromState = StateConversation.fromState(state);
            return new RequestPersistenceModel(fromState.getLocalId(), new Date(), "5.2.0", fromState, StateAndroidLifecycle.fromState(state).getState() == 2);
        }
    }

    public static class RequestIdMapper {
        private final Map<String, String> localToRemote = new HashMap();
        private final Map<String, String> remoteToLocal = new HashMap();

        public RequestIdMapper addIdMapping(String str, String str2) {
            this.localToRemote.put(str2, str);
            this.remoteToLocal.put(str, str2);
            return this;
        }

        public RequestIdMapper addLocalId(String str) {
            this.localToRemote.put(str, "");
            return this;
        }

        public String getLocalId(String str) {
            return this.remoteToLocal.get(str);
        }

        public Set<String> getLocalIds() {
            return this.localToRemote.keySet();
        }

        public String getRemoteId(String str) {
            return this.localToRemote.get(str);
        }

        public boolean hasLocalId(String str) {
            return this.remoteToLocal.containsKey(str) && f.c(this.remoteToLocal.get(str));
        }

        public boolean hasRemoteId(String str) {
            return this.localToRemote.containsKey(str) && f.c(this.localToRemote.get(str));
        }

        public RequestIdMapper removeLocalIdMapping(String str) {
            this.localToRemote.remove(str);
            return this;
        }
    }

    public static class RequestPersistenceModel {
        private final transient boolean activityStopped;
        private final StateConversation conversation;
        private final Date date;
        private final transient String requestId;
        private final String version;

        public RequestPersistenceModel(String str, Date date2, String str2, StateConversation stateConversation, boolean z11) {
            this.requestId = str;
            this.date = date2;
            this.version = str2;
            this.conversation = stateConversation;
            this.activityStopped = z11;
        }

        public StateConversation getConversation() {
            return this.conversation;
        }

        public Date getDate() {
            return this.date;
        }

        public String getLocalRequestId() {
            return this.requestId;
        }

        public String getVersion() {
            return this.version;
        }

        public boolean isActivityStopped() {
            return this.activityStopped;
        }
    }

    public ComponentPersistence(SupportUiStorage supportUiStorage2, PersistenceQueue persistenceQueue, Executor executor2) {
        this.supportUiStorage = supportUiStorage2;
        this.persistenceSelector = new PersistenceSelector();
        this.queue = persistenceQueue;
        this.executor = executor2;
    }

    private void persistConversation(RequestPersistenceModel requestPersistenceModel) {
        boolean isActivityStopped = requestPersistenceModel.isActivityStopped();
        boolean c11 = f.c(requestPersistenceModel.getLocalRequestId());
        boolean z11 = requestPersistenceModel.getConversation().getMessages().size() > 0;
        if (isActivityStopped && c11 && z11) {
            this.queue.dispatch(new PersistenceItem(this.supportUiStorage, requestPersistenceModel));
        }
    }

    private void persistRequestId(final RequestPersistenceModel requestPersistenceModel) {
        if (!this.isMappingComplete.get()) {
            final String remoteId = requestPersistenceModel.getConversation().getRemoteId();
            final String localId = requestPersistenceModel.getConversation().getLocalId();
            final boolean z11 = false;
            boolean z12 = requestPersistenceModel.getConversation().getMessages().size() > 0;
            if (f.c(remoteId) && f.c(localId)) {
                z11 = true;
            }
            if (z11 || z12) {
                if (z11) {
                    this.isMappingComplete.set(true);
                }
                this.executor.execute(new Runnable() {
                    public void run() {
                        RequestIdMapper requestIdMapper = (RequestIdMapper) ComponentPersistence.this.supportUiStorage.read(SupportUiStorage.REQUEST_MAPPER, RequestIdMapper.class);
                        if (requestIdMapper == null) {
                            requestIdMapper = new RequestIdMapper();
                        }
                        if (z11) {
                            if (!requestIdMapper.hasLocalId(remoteId) || !requestIdMapper.hasRemoteId(localId)) {
                                ComponentPersistence.this.supportUiStorage.write(SupportUiStorage.REQUEST_MAPPER, requestIdMapper.addIdMapping(remoteId, localId));
                            }
                        } else if (!requestIdMapper.hasRemoteId(localId)) {
                            ComponentPersistence.this.supportUiStorage.write(SupportUiStorage.REQUEST_MAPPER, requestIdMapper.addLocalId(localId));
                        }
                    }
                });
            }
        } else if (a.g(requestPersistenceModel.getConversation().getMessages())) {
            this.executor.execute(new Runnable() {
                public void run() {
                    RequestIdMapper requestIdMapper = (RequestIdMapper) ComponentPersistence.this.supportUiStorage.read(SupportUiStorage.REQUEST_MAPPER, RequestIdMapper.class);
                    String localRequestId = requestPersistenceModel.getLocalRequestId();
                    if (requestIdMapper != null) {
                        ComponentPersistence.this.supportUiStorage.write(SupportUiStorage.REQUEST_MAPPER, requestIdMapper.removeLocalIdMapping(localRequestId));
                        ComponentPersistence.this.isMappingComplete.set(false);
                    }
                }
            });
        }
    }

    public StateSelector<RequestPersistenceModel> getSelector() {
        return this.persistenceSelector;
    }

    public void update(RequestPersistenceModel requestPersistenceModel) {
        persistConversation(requestPersistenceModel);
        persistRequestId(requestPersistenceModel);
    }
}
