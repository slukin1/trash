package com.zopim.android.sdk.data;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.google.gson.reflect.TypeToken;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.api.ChatSession;
import com.zopim.android.sdk.api.FileTransfers;
import com.zopim.android.sdk.api.R;
import com.zopim.android.sdk.data.observers.AccountObserver;
import com.zopim.android.sdk.model.Account;
import com.zopim.android.sdk.model.ChatLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class LivechatChatLogPath extends Path<LinkedHashMap<String, ChatLog>> {
    /* access modifiers changed from: private */
    public static final LivechatChatLogPath INSTANCE = new LivechatChatLogPath();
    private static final String LOG_TAG = "LivechatChatLogPath";
    public AccountObserver accountObserver = new AccountObserver() {
        /* access modifiers changed from: private */
        public final String ACCOUNT_STATUS_KEY = UUID.randomUUID().toString();
        private final long OFFLINE_THRESHOLD = TimeUnit.SECONDS.toMillis(10);
        private Runnable accountOfflineEventUpdater = new Runnable() {
            public void run() {
                ChatLog chatLog = new ChatLog((String) null, ChatLog.Type.ACCOUNT_OFFLINE, (String) null);
                synchronized (LivechatChatLogPath.this.lock) {
                    AnonymousClass2 r22 = AnonymousClass2.this;
                    ((LinkedHashMap) LivechatChatLogPath.this.data).put(r22.ACCOUNT_STATUS_KEY, chatLog);
                }
                LivechatChatLogPath.this.broadcast();
            }
        };
        private Handler handler = new Handler();

        public void update(Account account) {
            if (account != null && account.getStatus() != null) {
                int i11 = AnonymousClass3.$SwitchMap$com$zopim$android$sdk$model$Account$Status[account.getStatus().ordinal()];
                if (i11 == 1) {
                    synchronized (LivechatChatLogPath.this.lock) {
                        if (!((LinkedHashMap) LivechatChatLogPath.this.data).containsKey(this.ACCOUNT_STATUS_KEY)) {
                            this.handler.postDelayed(this.accountOfflineEventUpdater, this.OFFLINE_THRESHOLD);
                        }
                    }
                } else if (i11 == 2) {
                    this.handler.removeCallbacks(this.accountOfflineEventUpdater);
                    synchronized (LivechatChatLogPath.this.lock) {
                        if (((LinkedHashMap) LivechatChatLogPath.this.data).containsKey(this.ACCOUNT_STATUS_KEY)) {
                            ((LinkedHashMap) LivechatChatLogPath.this.data).remove(this.ACCOUNT_STATUS_KEY);
                            LivechatChatLogPath.this.broadcast();
                        }
                    }
                }
            }
        }
    };
    public Pair<String, ChatLog> chatRatingEntry;
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    private TimeoutManager timeoutManager = new TimeoutManager();
    private LinkedList<Pair<String, ChatLog>> unmatchedAgentQuestionnaire = new LinkedList<>();
    public Map<String, String> uploadedFiles = new HashMap();

    /* renamed from: com.zopim.android.sdk.data.LivechatChatLogPath$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$zopim$android$sdk$model$Account$Status;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.zopim.android.sdk.model.Account$Status[] r0 = com.zopim.android.sdk.model.Account.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$zopim$android$sdk$model$Account$Status = r0
                com.zopim.android.sdk.model.Account$Status r1 = com.zopim.android.sdk.model.Account.Status.OFFLINE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$model$Account$Status     // Catch:{ NoSuchFieldError -> 0x001d }
                com.zopim.android.sdk.model.Account$Status r1 = com.zopim.android.sdk.model.Account.Status.ONLINE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zopim.android.sdk.data.LivechatChatLogPath.AnonymousClass3.<clinit>():void");
        }
    }

    public static class ChatTimeoutReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if (intent == null || !ChatSession.ACTION_CHAT_SESSION_TIMEOUT.equals(intent.getAction())) {
                Logger.l(LivechatChatLogPath.LOG_TAG, "onReceive: intent was null or getAction() was mismatched", new Object[0]);
                return;
            }
            ChatLog chatLog = new ChatLog((String) null, ChatLog.Type.CHAT_MSG_TRIGGER, context.getResources().getString(R.string.chat_session_timeout_message));
            String l11 = chatLog.getTimestamp().toString();
            synchronized (LivechatChatLogPath.INSTANCE.lock) {
                ((LinkedHashMap) LivechatChatLogPath.INSTANCE.data).put(l11, chatLog);
            }
            LivechatChatLogPath.INSTANCE.broadcast(LivechatChatLogPath.INSTANCE.getData());
        }
    }

    public class SendTimeout implements Runnable {
        public ChatLog chatLogRecord;

        /* renamed from: id  reason: collision with root package name */
        public String f53463id;

        public SendTimeout(String str, ChatLog chatLog) {
            this.chatLogRecord = chatLog;
            this.f53463id = str;
        }

        public void run() {
            Logger.j(LivechatChatLogPath.LOG_TAG, "Message failed to send. Timeout occurred", new Object[0]);
            this.chatLogRecord.setFailed(true);
            LinkedHashMap linkedHashMap = new LinkedHashMap(1);
            linkedHashMap.put(this.f53463id, this.chatLogRecord);
            LivechatChatLogPath.this.updateInternal(linkedHashMap);
        }
    }

    public class TimeoutManager {
        private static final long TIMEOUT = 5000;
        private Handler handler = new Handler(Looper.myLooper());
        private Map<String, SendTimeout> unverifiedLog = new HashMap();

        public TimeoutManager() {
        }

        public synchronized void remove(String str) {
            Logger.j(LivechatChatLogPath.LOG_TAG, "Removing timeout runnable", new Object[0]);
            this.handler.removeCallbacks(this.unverifiedLog.get(str));
        }

        public synchronized void schedule(String str, ChatLog chatLog) {
            if (str == null) {
                Logger.l(LivechatChatLogPath.LOG_TAG, "Can not add chat log without an id", new Object[0]);
            } else if (chatLog == null) {
                Logger.l(LivechatChatLogPath.LOG_TAG, "Can not add chat log that is null", new Object[0]);
            } else {
                SendTimeout sendTimeout = this.unverifiedLog.get(str);
                if (sendTimeout != null) {
                    Logger.j(LivechatChatLogPath.LOG_TAG, "Removing previous timeout", new Object[0]);
                    this.handler.removeCallbacks(sendTimeout);
                }
                SendTimeout sendTimeout2 = new SendTimeout(str, chatLog);
                this.unverifiedLog.put(str, sendTimeout2);
                Logger.j(LivechatChatLogPath.LOG_TAG, "Scheduling timeout runnable", new Object[0]);
                this.handler.postDelayed(sendTimeout2, 5000);
            }
        }
    }

    private LivechatChatLogPath() {
        this.data = new LinkedHashMap();
        LivechatAccountPath.getInstance().addObserver(this.accountObserver);
    }

    private Pair<String, ChatLog> findAgentQuestionnaire(ChatLog chatLog) {
        if (chatLog == null) {
            Logger.l(LOG_TAG, "RowItem must not be null", new Object[0]);
            return null;
        }
        if (chatLog.getType() == ChatLog.Type.CHAT_MSG_VISITOR && chatLog.getMessage() != null && !chatLog.getMessage().isEmpty()) {
            Iterator it2 = this.unmatchedAgentQuestionnaire.iterator();
            while (it2.hasNext()) {
                Pair<String, ChatLog> pair = (Pair) it2.next();
                ChatLog chatLog2 = (ChatLog) pair.second;
                if (chatLog2.getType() == ChatLog.Type.CHAT_MSG_AGENT) {
                    ChatLog.Option[] options = chatLog2.getOptions();
                    int length = options.length;
                    int i11 = 0;
                    while (i11 < length) {
                        boolean equals = chatLog.getMessage().equals(options[i11].getLabel());
                        boolean z11 = chatLog.getTimestamp().longValue() > chatLog2.getTimestamp().longValue();
                        if (!equals || !z11) {
                            i11++;
                        } else {
                            this.unmatchedAgentQuestionnaire.remove(pair);
                            return pair;
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }

    public static LivechatChatLogPath getInstance() {
        return INSTANCE;
    }

    private ChatLog mergeEntries(ChatLog chatLog, ChatLog chatLog2) {
        if (chatLog == null) {
            return null;
        }
        if (chatLog2 == null) {
            return chatLog;
        }
        if (chatLog.getType() == ChatLog.Type.CHAT_RATING && chatLog2.getComment() == null) {
            chatLog.setRawNewRating((String) null);
            chatLog.setRawRating((String) null);
        }
        return (ChatLog) ChatGson.performUpdate(chatLog, chatLog2, ChatLog.class);
    }

    /* access modifiers changed from: private */
    public void updateInternal(LinkedHashMap<String, ChatLog> linkedHashMap) {
        String fileName;
        Pair<String, ChatLog> pair;
        if (linkedHashMap == null) {
            Logger.g(LOG_TAG, "Passed parameter must not be null. Aborting update.", new Object[0]);
            return;
        }
        synchronized (this.lock) {
            int i11 = 0;
            for (Map.Entry next : linkedHashMap.entrySet()) {
                String str = (String) next.getKey();
                ChatLog chatLog = (ChatLog) next.getValue();
                if (!(chatLog == null || chatLog.getType() != ChatLog.Type.CHAT_RATING || (pair = this.chatRatingEntry) == null)) {
                    str = (String) pair.first;
                }
                boolean z11 = true;
                if (((LinkedHashMap) this.data).containsKey(str)) {
                    ChatLog chatLog2 = (ChatLog) ((LinkedHashMap) this.data).get(str);
                    if (chatLog != null) {
                        ChatLog mergeEntries = mergeEntries(chatLog2, chatLog);
                        if (mergeEntries == null) {
                            ((LinkedHashMap) this.data).remove(str);
                        } else {
                            ((LinkedHashMap) this.data).put(str, mergeEntries);
                            boolean z12 = ChatLog.Type.CHAT_MSG_VISITOR == mergeEntries.getType();
                            boolean booleanValue = mergeEntries.isFailed() == null ? false : mergeEntries.isFailed().booleanValue();
                            if (z12 && !booleanValue) {
                                if (mergeEntries.isUnverified() != null) {
                                    z11 = mergeEntries.isUnverified().booleanValue();
                                }
                                if (z11) {
                                    this.timeoutManager.schedule(str, chatLog);
                                } else {
                                    this.timeoutManager.remove(str);
                                }
                            }
                        }
                    } else if (((ChatLog) ((LinkedHashMap) this.data).get(str)).getType() != ChatLog.Type.VISITOR_ATTACHMENT) {
                        ((LinkedHashMap) this.data).remove(str);
                        i11--;
                        this.timeoutManager.remove(str);
                    }
                } else if (chatLog != null) {
                    try {
                        ChatLog.Type type = ChatLog.Type.CHAT_MSG_VISITOR;
                        boolean z13 = type == chatLog.getType();
                        if (chatLog.getMessage() == null || !chatLog.getMessage().trim().isEmpty()) {
                            z11 = false;
                        }
                        if (!z13 || !z11) {
                            Pair<String, ChatLog> findAgentQuestionnaire = findAgentQuestionnaire(chatLog);
                            if (findAgentQuestionnaire != null) {
                                ChatLog.Option[] options = ((ChatLog) findAgentQuestionnaire.second).getOptions();
                                int i12 = 0;
                                while (true) {
                                    if (i12 >= options.length) {
                                        break;
                                    } else if (chatLog.getMessage().equals(options[i12].getLabel())) {
                                        options[i12].select();
                                        ((LinkedHashMap) this.data).put(findAgentQuestionnaire.first, findAgentQuestionnaire.second);
                                        break;
                                    } else {
                                        i12++;
                                    }
                                }
                            } else {
                                if (chatLog.getType() == ChatLog.Type.VISITOR_ATTACHMENT && (fileName = chatLog.getFileName()) != null) {
                                    chatLog.setFile(FileTransfers.INSTANCE.findFile(fileName));
                                    this.uploadedFiles.put(fileName, str);
                                }
                                if (chatLog.getType() == type) {
                                    String name = chatLog.getAttachment() != null ? chatLog.getAttachment().getName() : null;
                                    if (name != null) {
                                        ChatLog chatLog3 = (ChatLog) ((LinkedHashMap) this.data).get(this.uploadedFiles.get(name));
                                        if (chatLog3 != null) {
                                            chatLog3.setProgress(100);
                                        }
                                    }
                                }
                                if (chatLog.getType() == ChatLog.Type.CHAT_RATING) {
                                    this.chatRatingEntry = new Pair<>(str, chatLog);
                                }
                                ((LinkedHashMap) this.data).put(str, chatLog);
                                i11++;
                                if (z13) {
                                    if (chatLog.isUnverified() != null ? chatLog.isUnverified().booleanValue() : false) {
                                        this.timeoutManager.schedule(str, chatLog);
                                    }
                                }
                            }
                        }
                    } catch (Exception e11) {
                        Logger.k(LOG_TAG, "Failed to process json. Chat log record could not be created.", e11, new Object[0]);
                    }
                }
                if (chatLog != null && chatLog.getOptions() != null && chatLog.getOptions().length > 0) {
                    this.unmatchedAgentQuestionnaire.addFirst(new Pair(str, chatLog));
                }
            }
            if (i11 >= 0) {
                broadcast(getData());
            }
        }
    }

    public void clear() {
        synchronized (this.lock) {
            T t11 = this.data;
            if (t11 != null) {
                ((LinkedHashMap) t11).clear();
            }
        }
    }

    public int countMessages(ChatLog.Type... typeArr) {
        int i11 = 0;
        for (ChatLog type : getData().values()) {
            ChatLog.Type type2 = type.getType();
            for (ChatLog.Type equals : typeArr) {
                if (equals.equals(type2)) {
                    i11++;
                }
            }
        }
        return i11;
    }

    public void update(String str) {
        if (isClearRequired(str)) {
            clear();
        } else if (!str.isEmpty()) {
            updateInternal((LinkedHashMap) ChatGson.get().fromJson(str, new TypeToken<LinkedHashMap<String, ChatLog>>() {
            }.getType()));
        }
    }

    public LinkedHashMap<String, ChatLog> getData() {
        synchronized (this.lock) {
            if (this.data == null) {
                return new LinkedHashMap<>();
            }
            LinkedHashMap<String, ChatLog> linkedHashMap = new LinkedHashMap<>((Map) this.data);
            return linkedHashMap;
        }
    }
}
