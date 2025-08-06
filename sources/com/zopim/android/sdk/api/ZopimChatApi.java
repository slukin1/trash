package com.zopim.android.sdk.api;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.api.ChatService;
import com.zopim.android.sdk.breadcrumbs.Event;
import com.zopim.android.sdk.breadcrumbs.Events;
import com.zopim.android.sdk.data.DataSource;
import com.zopim.android.sdk.data.PathDataSource;
import com.zopim.android.sdk.model.ChatLog;
import com.zopim.android.sdk.model.PushData;
import com.zopim.android.sdk.model.VisitorInfo;
import com.zopim.android.sdk.store.Storage;
import com.zopim.android.sdk.util.AppInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ZopimChatApi implements ChatApi, ChatSession {
    private static final DataSource DATA_SOURCE = new PathDataSource();
    private static final String LOG_TAG = "ZopimChatApi";
    /* access modifiers changed from: private */
    public static String pushToken;
    private static Intent serviceNotificationServiceIntent;
    /* access modifiers changed from: private */
    public static ZopimChatApi singleton;
    /* access modifiers changed from: private */
    public static VisitorInfo visitorInfo;
    /* access modifiers changed from: private */
    public String accountKey;
    /* access modifiers changed from: private */
    public ChatServiceApi chatService;
    /* access modifiers changed from: private */
    public DefaultConfig defaultConfig;
    /* access modifiers changed from: private */
    public boolean ended;
    /* access modifiers changed from: private */
    public SessionApiConfig sessionConfig;
    private Queue<Event> unsentEvents = new ConcurrentLinkedQueue();
    private Queue<File> unsentFiles = new ConcurrentLinkedQueue();
    private Queue<String> unsentMessages = new ConcurrentLinkedQueue();

    public static class ChatServiceConnection implements ServiceConnection {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Logger.b(ZopimChatApi.LOG_TAG, "Bound to chat service", new Object[0]);
            ChatServiceApi unused = ZopimChatApi.singleton.chatService = ((ChatService.LocalBinder) iBinder).getService();
            ZopimChatApi.singleton.resendUnsentMessages();
            ZopimChatApi.singleton.resendUnsentFiles();
            ZopimChatApi.singleton.resendUnsentEvents();
            if (ZopimChatApi.pushToken != null) {
                ZopimChatApi.singleton.chatService.setPushToken(ZopimChatApi.pushToken);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Logger.b(ZopimChatApi.LOG_TAG, "Unbound from chat service", new Object[0]);
            ChatServiceApi unused = ZopimChatApi.singleton.chatService = null;
        }
    }

    public static class DefaultConfig<T extends DefaultConfig> extends ApiConfigBuilder<T> {
        public boolean disableVisitorInfoStorage;
        public Long initializationTimeout;
        public Long reconnectTimeout;
        public Long sessionTimeout;

        @Deprecated
        public Void build() {
            return null;
        }

        public T disableVisitorInfoStorage() {
            this.disableVisitorInfoStorage = true;
            return this;
        }

        public T initializationTimeout(long j11) {
            if (j11 < 0) {
                Logger.g(ZopimChatApi.LOG_TAG, "Can not configure initialization timeout. Timeout must not be less than 0", new Object[0]);
                return this;
            }
            this.initializationTimeout = Long.valueOf(j11);
            return this;
        }

        public T reconnectTimeout(long j11) {
            if (j11 < 0) {
                Logger.g(ZopimChatApi.LOG_TAG, "Can not configure reconnect timeout. Timeout must not be less than 0", new Object[0]);
                return this;
            }
            this.reconnectTimeout = Long.valueOf(j11);
            return this;
        }

        public T sessionTimeout(long j11) {
            if (j11 < 0) {
                Logger.g(ZopimChatApi.LOG_TAG, "Can not configure session timeout. Timeout must not be less than 0", new Object[0]);
                return this;
            }
            this.sessionTimeout = Long.valueOf(j11);
            return this;
        }

        public /* bridge */ /* synthetic */ ApiConfigBuilder tags(String... strArr) {
            return super.tags(strArr);
        }
    }

    public static class SessionApiConfig<T extends SessionApiConfig> extends ApiConfigBuilder<T> {
        public Long initializationTimeout;
        public Long sessionTimeout;
        public VisitorInfo visitorInfo;

        public ChatApi build(FragmentActivity fragmentActivity) {
            if (!ZopimChatApi.isInitialized()) {
                Logger.d(ZopimChatApi.LOG_TAG, "Have you initialized?", new Object[0]);
                return new UninitializedChatApi();
            } else if (fragmentActivity == null) {
                Logger.d(ZopimChatApi.LOG_TAG, "Can not build the chat. Activity must not be null.", new Object[0]);
                return new UninitializedChatApi();
            } else {
                DefaultConfig access$800 = ZopimChatApi.singleton.defaultConfig;
                Storage.init(fragmentActivity);
                if (access$800.disableVisitorInfoStorage) {
                    Storage.visitorInfo().disable();
                }
                boolean unused = ZopimChatApi.singleton.ended = false;
                FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                if (supportFragmentManager.m0(ChatServiceBinder.class.getName()) == null) {
                    Logger.j(ZopimChatApi.LOG_TAG, "Adding chat service binder fragment to the host activity", new Object[0]);
                    FragmentTransaction q11 = supportFragmentManager.q();
                    q11.e(new ChatServiceBinder(), ChatServiceBinder.class.getName());
                    q11.j();
                    if (ZopimChatApi.visitorInfo != null) {
                        this.visitorInfo = ZopimChatApi.visitorInfo;
                    } else {
                        this.visitorInfo = Storage.visitorInfo().getVisitorInfo();
                    }
                    String str = this.department;
                    if (str == null || str.isEmpty()) {
                        this.department = access$800.department;
                    }
                    String[] strArr = access$800.tags;
                    if (strArr != null && strArr.length > 0) {
                        if (this.tags == null) {
                            this.tags = strArr;
                        } else {
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(Arrays.asList(access$800.tags));
                            arrayList.addAll(Arrays.asList(this.tags));
                            this.tags = (String[]) arrayList.toArray(new String[arrayList.size()]);
                        }
                    }
                    if (this.title == null) {
                        String str2 = access$800.title;
                        if (str2 != null) {
                            this.title = str2;
                        } else {
                            this.title = fragmentActivity.getResources().getString(R.string.mobile_chat_referrer);
                        }
                    }
                    if (this.referrer == null) {
                        String str3 = access$800.referrer;
                        if (str3 != null) {
                            this.referrer = str3;
                        } else {
                            this.referrer = String.format(Locale.US, "%s, v%s", new Object[]{AppInfo.getApplicationName(fragmentActivity), AppInfo.getApplicationVersionName(fragmentActivity)});
                        }
                    }
                    Long l11 = access$800.initializationTimeout;
                    if (l11 != null) {
                        this.initializationTimeout = l11;
                    } else {
                        this.initializationTimeout = Long.valueOf(ChatSession.DEFAULT_CHAT_INITIALIZATION_TIMEOUT);
                    }
                    Long l12 = access$800.sessionTimeout;
                    if (l12 != null) {
                        this.sessionTimeout = l12;
                    } else {
                        this.sessionTimeout = Long.valueOf(ChatSession.DEFAULT_CHAT_SESSION_TIMEOUT);
                    }
                    SessionApiConfig unused2 = ZopimChatApi.singleton.sessionConfig = this;
                    ChatService.startService(fragmentActivity, (String) null, ZopimChatApi.singleton.accountKey, Storage.machineId().getMachineId(), this);
                } else {
                    Logger.j(ZopimChatApi.LOG_TAG, "Activity is already bound to Chat Service, skipping service start", new Object[0]);
                }
                return ZopimChatApi.singleton;
            }
        }
    }

    public static class SessionConfig extends SessionApiConfig<SessionConfig> {
        public /* bridge */ /* synthetic */ ChatApi build(FragmentActivity fragmentActivity) {
            return super.build(fragmentActivity);
        }
    }

    public static class SingletonHolder {
        private static final ZopimChatApi INSTANCE = new ZopimChatApi();

        private SingletonHolder() {
        }

        /* access modifiers changed from: private */
        public static ZopimChatApi getInstance() {
            return INSTANCE;
        }
    }

    private boolean canCommunicate() {
        ChatServiceApi chatServiceApi = this.chatService;
        if ((chatServiceApi != null) && chatServiceApi.isRunning()) {
            return true;
        }
        Logger.g(LOG_TAG, "Can not chat at the moment. Chat is not connected to the chat service.", new Object[0]);
        return false;
    }

    public static void chatSessionTimedOut() {
        if (isInitialized()) {
            Logger.g(LOG_TAG, "Received chat timeout. Ending chat.", new Object[0]);
            singleton.endChat();
            if (!singleton.hasEnded()) {
                Logger.g(LOG_TAG, "Chat previously expired. Updating chat state as ended.", new Object[0]);
                singleton.ended = true;
            }
        }
    }

    public static void clearPushToken() {
        pushToken = null;
        if (singleton.canCommunicate()) {
            singleton.chatService.clearPushToken();
        }
    }

    public static DataSource getDataSource() {
        return DATA_SOURCE;
    }

    public static Long getInitializationTimeout() {
        if (!isInitialized()) {
            Logger.l(LOG_TAG, "Chat must be initialized to use initialization timeout configuration. Will return default timeout.", new Object[0]);
            return Long.valueOf(ChatSession.DEFAULT_CHAT_INITIALIZATION_TIMEOUT);
        }
        Long l11 = singleton.defaultConfig.initializationTimeout;
        if (l11 != null) {
            return l11;
        }
        return Long.valueOf(ChatSession.DEFAULT_CHAT_INITIALIZATION_TIMEOUT);
    }

    public static Long getReconnectTimeout() {
        if (!isInitialized()) {
            Logger.l(LOG_TAG, "Chat must be initialized to use reconnect timeout configuration. Will return default timeout.", new Object[0]);
            return Long.valueOf(ChatSession.DEFAULT_RECONNECT_TIMEOUT);
        }
        Long l11 = singleton.defaultConfig.reconnectTimeout;
        if (l11 != null) {
            return l11;
        }
        return Long.valueOf(ChatSession.DEFAULT_RECONNECT_TIMEOUT);
    }

    public static Intent getServiceNotificationServiceIntent() {
        return serviceNotificationServiceIntent;
    }

    public static DefaultConfig init(String str) {
        try {
            return init(str, DefaultConfig.class);
        } catch (ExceptionInInitializerError unused) {
            DefaultConfig defaultConfig2 = new DefaultConfig();
            Logger.l(LOG_TAG, "Failed to initialize configuration. Provided global configuration parameters will be ignored.", new Object[0]);
            return defaultConfig2;
        }
    }

    public static boolean isInitialized() {
        ZopimChatApi zopimChatApi = singleton;
        if (zopimChatApi != null && zopimChatApi.defaultConfig != null && zopimChatApi.accountKey != null) {
            return true;
        }
        Logger.j(LOG_TAG, "Initialization verification failed. Did you initialize?", new Object[0]);
        return false;
    }

    public static void onMessageReceived(PushData pushData) {
        if (!singleton.hasEnded() && pushData.getType() == PushData.Type.END) {
            singleton.endChat();
        }
    }

    /* access modifiers changed from: private */
    public void resendUnsentEvents() {
        if (!this.unsentEvents.isEmpty()) {
            Logger.j(LOG_TAG, "Resending cached unsent events", new Object[0]);
            Queue<Event> queue = this.unsentEvents;
            this.unsentEvents.clear();
            sendEvents((Event[]) queue.toArray(new Event[queue.size()]));
        }
    }

    /* access modifiers changed from: private */
    public void resendUnsentFiles() {
        if (!this.unsentFiles.isEmpty()) {
            Logger.j(LOG_TAG, "Resending cached unsent files", new Object[0]);
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue(this.unsentFiles);
            this.unsentFiles.clear();
            while (true) {
                File file = (File) concurrentLinkedQueue.poll();
                if (file != null) {
                    send(file);
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void resendUnsentMessages() {
        if (!this.unsentMessages.isEmpty()) {
            Logger.j(LOG_TAG, "Resending cached unsent messages", new Object[0]);
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue(this.unsentMessages);
            this.unsentMessages.clear();
            while (true) {
                String str = (String) concurrentLinkedQueue.poll();
                if (str != null) {
                    send(str);
                } else {
                    return;
                }
            }
        }
    }

    public static synchronized ChatApi resume(FragmentActivity fragmentActivity) {
        synchronized (ZopimChatApi.class) {
            if (!isInitialized()) {
                Logger.d(LOG_TAG, "Have you initialized?", new Object[0]);
                UninitializedChatApi uninitializedChatApi = new UninitializedChatApi();
                return uninitializedChatApi;
            } else if (fragmentActivity == null) {
                Logger.d(LOG_TAG, "Resuming chat is not possible. Activity must not be null.", new Object[0]);
                UninitializedChatApi uninitializedChatApi2 = new UninitializedChatApi();
                return uninitializedChatApi2;
            } else {
                ZopimChatApi zopimChatApi = singleton;
                if (zopimChatApi.chatService == null || zopimChatApi.hasEnded()) {
                    Logger.g(LOG_TAG, "Resuming chat is not possible", new Object[0]);
                    UninitializedChatApi uninitializedChatApi3 = new UninitializedChatApi();
                    return uninitializedChatApi3;
                }
                ChatService.startService(fragmentActivity.getApplicationContext(), ChatService.ACTION_CHAT_RECONNECT, (String) null, (String) null, (SessionApiConfig) null);
                FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                if (supportFragmentManager.m0(ChatServiceBinder.class.getName()) == null) {
                    Logger.j(LOG_TAG, "Adding chat service binder fragment to the host activity", new Object[0]);
                    FragmentTransaction q11 = supportFragmentManager.q();
                    q11.e(new ChatServiceBinder(), ChatServiceBinder.class.getName());
                    q11.j();
                }
                ZopimChatApi zopimChatApi2 = singleton;
                return zopimChatApi2;
            }
        }
    }

    private void sendEvents(Event... eventArr) {
        if (canCommunicate()) {
            this.chatService.sendEvents(eventArr);
            return;
        }
        for (Event offer : eventArr) {
            singleton.unsentEvents.offer(offer);
        }
    }

    public static void setPushToken(String str) {
        pushToken = str;
        if (singleton.canCommunicate() && str != null) {
            singleton.chatService.setPushToken(str);
        }
    }

    public static void setServiceNotificationContentIntent(Intent intent) {
        serviceNotificationServiceIntent = intent;
    }

    public static void setVisitorInfo(VisitorInfo visitorInfo2) {
        visitorInfo = visitorInfo2;
    }

    public static synchronized ChatApi start(FragmentActivity fragmentActivity) {
        ChatApi build;
        synchronized (ZopimChatApi.class) {
            build = new SessionApiConfig().build(fragmentActivity);
        }
        return build;
    }

    public static void trackEvent(String str) {
        if (str == null || str.isEmpty()) {
            Logger.l(LOG_TAG, "Tracked event must not be null or empty", new Object[0]);
        } else if (!isInitialized()) {
            Events.getQueue().offer(new Event(str));
        } else if (singleton.canCommunicate()) {
            singleton.sendEvents(new Event(str));
        } else {
            singleton.unsentEvents.offer(new Event(str));
        }
    }

    public void addNote(String str) {
        if (canCommunicate() && str != null) {
            this.chatService.addNote(str);
        }
    }

    public void disconnect() {
        if (canCommunicate()) {
            this.chatService.disconnect();
        }
    }

    public boolean emailTranscript(String str) {
        if (canCommunicate()) {
            return this.chatService.emailTranscript(str);
        }
        return false;
    }

    public void endChat() {
        if (canCommunicate()) {
            this.chatService.endChat();
            this.ended = true;
            return;
        }
        Logger.g(LOG_TAG, "Can not end chat while disconnected from the chat service", new Object[0]);
    }

    public ChatApiConfig getConfig() {
        return new ChatApiConfig() {
            public String getDepartment() {
                String str = ZopimChatApi.this.sessionConfig.department;
                return str != null ? str : "";
            }

            public String[] getTags() {
                String[] strArr = ZopimChatApi.this.sessionConfig.tags;
                return strArr != null ? strArr : new String[0];
            }

            public VisitorInfo getVisitorInfo() {
                VisitorInfo visitorInfo = ZopimChatApi.this.sessionConfig.visitorInfo;
                return visitorInfo != null ? visitorInfo : new VisitorInfo.Builder().build();
            }
        };
    }

    public boolean hasEnded() {
        if (canCommunicate()) {
            return this.chatService.hasEnded();
        }
        return this.ended;
    }

    public void resend(String str) {
        if (canCommunicate()) {
            this.chatService.resend(str);
        } else {
            Logger.j(LOG_TAG, "Unable to re-send message at the moment.", new Object[0]);
        }
    }

    public void resetTimeout() {
        if (canCommunicate()) {
            this.chatService.resetTimeout();
        }
    }

    public void send(String str) {
        if (canCommunicate()) {
            this.chatService.send(str);
            return;
        }
        Logger.j(LOG_TAG, "Unable to send message at the moment. Caching it for resending.", new Object[0]);
        this.unsentMessages.add(str);
    }

    public void sendChatComment(String str) {
        if (canCommunicate()) {
            this.chatService.sendChatComment(str);
        }
    }

    public void sendChatRating(ChatLog.Rating rating) {
        if (canCommunicate()) {
            this.chatService.sendChatRating(rating);
        }
    }

    public boolean sendOfflineMessage(String str, String str2, String str3) {
        if (canCommunicate()) {
            return this.chatService.sendOfflineMessage(str, str2, str3);
        }
        return false;
    }

    public void setDepartment(String str) {
        if (canCommunicate() && str != null) {
            this.chatService.setDepartment(str);
        }
    }

    public void setEmail(String str) {
        if (canCommunicate() && str != null) {
            this.chatService.setEmail(str);
        }
    }

    public void setName(String str) {
        if (canCommunicate() && str != null) {
            this.chatService.setName(str);
        }
    }

    public void setNote(String str) {
        if (canCommunicate() && str != null) {
            this.chatService.setNote(str);
        }
    }

    public void setPhoneNumber(String str) {
        if (canCommunicate() && str != null) {
            this.chatService.setPhoneNumber(str);
        }
    }

    public static <T extends DefaultConfig> T init(String str, Class<T> cls) throws ExceptionInInitializerError {
        if (str == null || str.isEmpty()) {
            Logger.d(LOG_TAG, "Account key must not be empty or null. Chat initialization will fail!", new Object[0]);
        }
        if (singleton == null) {
            Logger.g(LOG_TAG, "Initializing Chat SDK", new Object[0]);
            singleton = SingletonHolder.getInstance();
        }
        singleton.accountKey = str;
        Logger.j(LOG_TAG, "Staring chat configuration", new Object[0]);
        try {
            T t11 = (DefaultConfig) cls.newInstance();
            singleton.defaultConfig = t11;
            return t11;
        } catch (InstantiationException e11) {
            throw new ExceptionInInitializerError(e11);
        } catch (IllegalAccessException e12) {
            throw new ExceptionInInitializerError(e12);
        }
    }

    public void send(File file) {
        if (canCommunicate()) {
            this.chatService.send(file);
        } else {
            this.unsentFiles.add(file);
        }
    }
}
