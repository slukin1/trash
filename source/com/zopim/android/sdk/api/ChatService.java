package com.zopim.android.sdk.api;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.zendesk.belvedere.BelvedereResult;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.api.FileTransfers;
import com.zopim.android.sdk.api.ZopimChatApi;
import com.zopim.android.sdk.breadcrumbs.Event;
import com.zopim.android.sdk.breadcrumbs.Events;
import com.zopim.android.sdk.data.ConnectionPath;
import com.zopim.android.sdk.data.LivechatChatLogPath;
import com.zopim.android.sdk.data.observers.ChatLogObserver;
import com.zopim.android.sdk.data.observers.ConnectionObserver;
import com.zopim.android.sdk.model.ChatLog;
import com.zopim.android.sdk.model.Connection;
import com.zopim.android.sdk.model.Profile;
import com.zopim.android.sdk.model.VisitorInfo;
import com.zopim.android.sdk.store.Storage;
import com.zopim.android.sdk.util.BelvedereProvider;
import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import mz.f;
import s1.a;

public class ChatService extends Service implements ChatServiceApi {
    public static final String ACTION_CHAT_RECONNECT = "chat.action.RECONNECT";
    private static final long END_CHAT_TIMEOUT = TimeUnit.MINUTES.toMillis(1);
    public static final String EXTRA_ACCOUNT_KEY = "ACCOUNT_KEY";
    public static final String EXTRA_MACHINE_ID = "MACHINE_ID";
    public static final String EXTRA_SESSION_CONFIG = "SESSION_CONFIG";
    private static final String LOG_TAG = "ChatService";
    private static String accountKey;
    private static String pushToken;
    private static String referrer;
    private static String title;
    private Application app;
    /* access modifiers changed from: private */
    public ChatCommunication chat;
    private long chatInitializationTimeout;
    public ChatLogObserver chatLogObserver = new ChatLogObserver() {
        public void update(LinkedHashMap<String, ChatLog> linkedHashMap) {
            BelvedereResult d11;
            for (final ChatLog next : linkedHashMap.values()) {
                int i11 = AnonymousClass6.$SwitchMap$com$zopim$android$sdk$model$ChatLog$Type[next.getType().ordinal()];
                if (i11 != 1) {
                    if (i11 == 2) {
                        if (next.getAttachment() == null || next.getAttachment().getUrl() == null || next.getAttachment().getName() == null) {
                            Logger.l(ChatService.LOG_TAG, "Attachment url is not available. Skipping download.", new Object[0]);
                        } else {
                            FileTransfers fileTransfers = FileTransfers.INSTANCE;
                            FileTransfers.Info info = fileTransfers.transfers.get(next.getAttachment().getName());
                            if (info == null && (d11 = BelvedereProvider.INSTANCE.getInstance(ChatService.this.getApplicationContext()).d(next.getAttachment().getName())) != null) {
                                File file = d11.getFile();
                                FileTransfers.Info info2 = new FileTransfers.Info();
                                info2.status = FileTransfers.Status.SCHEDULED;
                                info2.file = file;
                                fileTransfers.transfers.put(next.getAttachment().getName(), info2);
                                next.setFile(file);
                                info = info2;
                            }
                            int i12 = AnonymousClass6.$SwitchMap$com$zopim$android$sdk$api$FileTransfers$Status[info.status.ordinal()];
                            if (i12 == 1) {
                                ChatService.this.handler.post(new Runnable() {
                                    public void run() {
                                        URL url = next.getAttachment().getUrl();
                                        File file = next.getFile();
                                        Logger.j(ChatService.LOG_TAG, "Starting file download task", new Object[0]);
                                        FileDownloader fileDownloader = new FileDownloader();
                                        fileDownloader.setRequestListener(new RegisteredCallback<File>() {
                                            public void onError(ErrorResponse errorResponse) {
                                                next.setError(ChatLog.Error.UPLOAD_FAILED_ERROR);
                                                next.setFailed(true);
                                                FileTransfers.INSTANCE.transfers.get(next.getAttachment().getName()).status = FileTransfers.Status.FAILED;
                                                LivechatChatLogPath.getInstance().broadcast();
                                            }

                                            public void onSuccess(File file) {
                                                Logger.j(ChatService.LOG_TAG, "Download completed", new Object[0]);
                                                next.setFailed(false);
                                                next.setFile(file);
                                                FileTransfers.INSTANCE.transfers.get(next.getAttachment().getName()).status = FileTransfers.Status.COMPLETED;
                                                LivechatChatLogPath.getInstance().broadcast();
                                            }
                                        });
                                        fileDownloader.execute(new Pair[]{new Pair(url, file)});
                                    }
                                });
                                info.status = FileTransfers.Status.STARTED;
                                next.setFailed(false);
                            } else if (i12 == 2) {
                                next.setFile(info.file);
                                next.setFailed(false);
                            } else if (i12 == 3) {
                                next.setFile(info.file);
                                next.setFailed(true);
                            }
                        }
                    }
                } else if (next.getUploadUrl() == null) {
                    Logger.l(ChatService.LOG_TAG, "Upload url is not available. Skipping upload.", new Object[0]);
                } else if (next.getFile() == null) {
                    Logger.l(ChatService.LOG_TAG, "Upload file is not available. Skipping upload.", new Object[0]);
                } else {
                    FileTransfers.Info info3 = FileTransfers.INSTANCE.transfers.get(next.getFileName());
                    if (info3 == null) {
                        Logger.l(ChatService.LOG_TAG, "Unexpected, upload info should have been added prior to this. Skipping upload", new Object[0]);
                    } else if (AnonymousClass6.$SwitchMap$com$zopim$android$sdk$api$FileTransfers$Status[info3.status.ordinal()] != 1) {
                        Logger.j(ChatService.LOG_TAG, "Skipping start of already started upload.", new Object[0]);
                    } else {
                        ChatService.this.handler.post(new Runnable() {
                            public void run() {
                                URL uploadUrl = next.getUploadUrl();
                                File file = next.getFile();
                                Logger.j(ChatService.LOG_TAG, "Starting file upload task", new Object[0]);
                                FileUploader fileUploader = new FileUploader();
                                fileUploader.setRequestListener(new RegisteredCallback<Void>() {
                                    public void onError(ErrorResponse errorResponse) {
                                        next.setError(ChatLog.Error.UPLOAD_FAILED_ERROR);
                                        next.setFailed(true);
                                        FileTransfers.INSTANCE.transfers.get(next.getFileName()).status = FileTransfers.Status.FAILED;
                                        LivechatChatLogPath.getInstance().broadcast();
                                    }

                                    public void onSuccess(Void voidR) {
                                        Logger.j(ChatService.LOG_TAG, "Upload completed", new Object[0]);
                                    }
                                });
                                fileUploader.execute(new Pair[]{new Pair(file, uploadUrl)});
                            }
                        });
                        info3.status = FileTransfers.Status.STARTED;
                        next.setFailed(false);
                        next.setProgress(1);
                    }
                }
            }
        }
    };
    private long chatSessionTimeout;
    /* access modifiers changed from: private */
    public ChatState chatState = ChatState.UNKNOWN;
    private final LivechatChatLogPath.ChatTimeoutReceiver chatTimeoutReceiver = new LivechatChatLogPath.ChatTimeoutReceiver();
    public ConnectionObserver connectionObserver = new ConnectionObserver() {
        private void resendUnsentEvents() {
            if (!ChatService.this.unsentEvents.isEmpty()) {
                Logger.j(ChatService.LOG_TAG, "Resending cached unsent events", new Object[0]);
                Queue<Event> queue = ChatService.this.unsentEvents;
                ChatService.this.unsentEvents.clear();
                ChatService.this.sendEvents((Event[]) queue.toArray(new Event[queue.size()]));
            }
        }

        private void resendUnsentFiles() {
            if (!ChatService.this.unsentFiles.isEmpty()) {
                Logger.j(ChatService.LOG_TAG, "Resending cached unsent files", new Object[0]);
                ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue(ChatService.this.unsentFiles);
                ChatService.this.unsentFiles.clear();
                while (true) {
                    File file = (File) concurrentLinkedQueue.poll();
                    if (file != null) {
                        ChatService.this.send(file);
                    } else {
                        return;
                    }
                }
            }
        }

        private void resendUnsentIntents() {
            if (ChatService.this.chatState == ChatState.ENDING) {
                Logger.j(ChatService.LOG_TAG, "Resending end chat intent", new Object[0]);
                ChatService.this.endChat();
            }
        }

        private void resendUnsentMessages() {
            if (!ChatService.this.unsentMessages.isEmpty()) {
                Logger.j(ChatService.LOG_TAG, "Resending cached unsent messages", new Object[0]);
                ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue(ChatService.this.unsentMessages);
                ChatService.this.unsentMessages.clear();
                while (true) {
                    String str = (String) concurrentLinkedQueue.poll();
                    if (str != null) {
                        ChatService.this.send(str);
                    } else {
                        return;
                    }
                }
            }
        }

        public void update(Connection connection) {
            if (connection.getStatus() == Connection.Status.CONNECTED) {
                if (ChatService.this.chatState == ChatState.INITIALIZING) {
                    ChatService.this.onChatInitialized();
                }
                resendUnsentMessages();
                resendUnsentFiles();
                resendUnsentEvents();
                resendUnsentIntents();
                LivechatChatLogPath.getInstance().trigger();
            }
        }
    };
    private final ConnectionPath.ConnectivityReceiver connectivityReceiver = new ConnectionPath.ConnectivityReceiver();
    /* access modifiers changed from: private */
    public String department;
    /* access modifiers changed from: private */
    public boolean foreground;
    public Handler handler = new Handler(Looper.getMainLooper());
    public ScheduledFuture keepAliveRunner;
    private AppLifeCycleHandler lifeCycleHandler;
    private final AtomicBoolean running = new AtomicBoolean(false);
    private final IBinder serviceBinder = new LocalBinder();
    /* access modifiers changed from: private */
    public String[] tags;
    private final Handler teardownHandler = new Handler(Looper.myLooper());
    private final Runnable teardownRunnable = new Runnable() {
        public void run() {
            ChatService.this.setChatState(ChatState.ENDED);
            ChatService.this.stopSelf();
            Logger.g(ChatService.LOG_TAG, "Finally gave up on ending the chat and destroyed the chat service", new Object[0]);
        }
    };
    public Queue<Event> unsentEvents = new ConcurrentLinkedQueue();
    public Queue<File> unsentFiles = new ConcurrentLinkedQueue();
    public Queue<String> unsentMessages = new ConcurrentLinkedQueue();
    /* access modifiers changed from: private */
    public String visitorEmail;
    /* access modifiers changed from: private */
    public String visitorName;
    /* access modifiers changed from: private */
    public String visitorNote;
    /* access modifiers changed from: private */
    public String visitorPhoneNumber;

    /* renamed from: com.zopim.android.sdk.api.ChatService$6  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        public static final /* synthetic */ int[] $SwitchMap$com$zopim$android$sdk$api$FileTransfers$Status;
        public static final /* synthetic */ int[] $SwitchMap$com$zopim$android$sdk$model$ChatLog$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        static {
            /*
                com.zopim.android.sdk.model.ChatLog$Type[] r0 = com.zopim.android.sdk.model.ChatLog.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$zopim$android$sdk$model$ChatLog$Type = r0
                r1 = 1
                com.zopim.android.sdk.model.ChatLog$Type r2 = com.zopim.android.sdk.model.ChatLog.Type.VISITOR_ATTACHMENT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$zopim$android$sdk$model$ChatLog$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                com.zopim.android.sdk.model.ChatLog$Type r3 = com.zopim.android.sdk.model.ChatLog.Type.CHAT_MSG_AGENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.zopim.android.sdk.api.FileTransfers$Status[] r2 = com.zopim.android.sdk.api.FileTransfers.Status.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$com$zopim$android$sdk$api$FileTransfers$Status = r2
                com.zopim.android.sdk.api.FileTransfers$Status r3 = com.zopim.android.sdk.api.FileTransfers.Status.SCHEDULED     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = $SwitchMap$com$zopim$android$sdk$api$FileTransfers$Status     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.zopim.android.sdk.api.FileTransfers$Status r2 = com.zopim.android.sdk.api.FileTransfers.Status.COMPLETED     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$api$FileTransfers$Status     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.zopim.android.sdk.api.FileTransfers$Status r1 = com.zopim.android.sdk.api.FileTransfers.Status.FAILED     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zopim.android.sdk.api.ChatService.AnonymousClass6.<clinit>():void");
        }
    }

    public enum ChatState {
        INITIALIZING,
        INITIALIZED,
        STARTED,
        PUSH,
        ENDING,
        ENDED,
        UNKNOWN
    }

    public class ChatUIStateReceiver extends BroadcastReceiver {
        public ChatUIStateReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if (intent == null) {
                return;
            }
            if (ChatSession.ACTION_CHAT_BACKGROUND.equals(intent.getAction())) {
                boolean unused = ChatService.this.foreground = false;
                if (ChatService.this.chatState == ChatState.INITIALIZED) {
                    ChatService.this.prepareTimeout();
                }
            } else if (ChatSession.ACTION_CHAT_FOREGROUND.equals(intent.getAction())) {
                boolean unused2 = ChatService.this.foreground = true;
                ChatService.this.cancelTimeoutIntent();
            }
        }
    }

    public class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public ChatServiceApi getService() {
            return ChatService.this;
        }
    }

    /* access modifiers changed from: private */
    public boolean canCommunicate() {
        ChatState chatState2 = this.chatState;
        if ((chatState2 == ChatState.INITIALIZED || chatState2 == ChatState.STARTED || chatState2 == ChatState.ENDING) && this.chat != null) {
            Connection connection = ZopimChatApi.getDataSource().getConnection();
            if ((connection != null ? connection.getStatus() : Connection.Status.UNKNOWN) == Connection.Status.CONNECTED) {
                return true;
            }
        }
        Logger.g(LOG_TAG, "Can not communicate at the moment. Chat is either not initialized or not connected.", new Object[0]);
        return false;
    }

    /* access modifiers changed from: private */
    public void cancelTimeoutIntent() {
        Intent startIntent = startIntent(this, ChatSession.ACTION_CHAT_SESSION_TIMEOUT, (String) null, (String) null, (ZopimChatApi.SessionApiConfig) null);
        PushAutoTrackHelper.hookIntentGetService(this, 0, startIntent, 268435456);
        PendingIntent service = PendingIntent.getService(this, 0, startIntent, 268435456);
        PushAutoTrackHelper.hookPendingIntentGetService(service, this, 0, startIntent, 268435456);
        ((AlarmManager) getSystemService("alarm")).cancel(service);
    }

    private void configureInitializationTimeout(boolean z11) {
        AlarmManager alarmManager = (AlarmManager) getSystemService("alarm");
        Intent startIntent = startIntent(this, ChatSession.ACTION_CHAT_INITIALIZATION_TIMEOUT, (String) null, (String) null, (ZopimChatApi.SessionApiConfig) null);
        PushAutoTrackHelper.hookIntentGetService(this, 0, startIntent, 134217728);
        PendingIntent service = PendingIntent.getService(this, 0, startIntent, 134217728);
        PushAutoTrackHelper.hookPendingIntentGetService(service, this, 0, startIntent, 134217728);
        if (alarmManager != null) {
            Logger.j(LOG_TAG, "Alarm manager acquired, scheduling chat initialization timeout", new Object[0]);
            long elapsedRealtime = SystemClock.elapsedRealtime() + this.chatInitializationTimeout;
            if (z11) {
                alarmManager.set(3, elapsedRealtime, service);
            } else {
                alarmManager.cancel(service);
            }
        } else {
            Logger.l(LOG_TAG, "Could not get the Alarm manager, will not set chat initialization timeout", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public void onChatInitialized() {
        if (this.chat == null) {
            Logger.j(LOG_TAG, "Initialization triggered but the chat instance is unavailable. Check that you are not using a stale connection state due to the service restart.", new Object[0]);
        } else if (this.chatState == ChatState.INITIALIZING) {
            Logger.j(LOG_TAG, "Chat initialized", new Object[0]);
            setChatState(ChatState.INITIALIZED);
            this.chat.sendChatButtonClicked();
            configureInitializationTimeout(false);
            Profile profile = ZopimChatApi.getDataSource().getProfile();
            if (profile != null) {
                String machineId = profile.getMachineId();
                Storage.machineId().setMachineId(machineId);
                this.lifeCycleHandler.setup(accountKey, machineId);
            }
            setEmail(this.visitorEmail);
            setName(this.visitorName);
            setPhoneNumber(this.visitorPhoneNumber);
            addNote(this.visitorNote);
            String[] strArr = this.tags;
            if (strArr != null && strArr.length > 0) {
                this.chat.addTags(strArr);
            }
            String str = pushToken;
            if (str != null) {
                this.chat.setPushToken(str);
            }
            Events.getQueue().addAll(this.unsentEvents);
            this.unsentEvents.clear();
            Events.getQueue().clear();
            sendEvents((Event[]) Events.getQueue().toArray(new Event[Events.getQueue().size()]));
            if (LivechatChatLogPath.getInstance().countMessages(ChatLog.Type.CHAT_MSG_VISITOR, ChatLog.Type.CHAT_MSG_AGENT, ChatLog.Type.CHAT_MSG_SYSTEM, ChatLog.Type.CHAT_MSG_TRIGGER) > 0) {
                setChatState(ChatState.STARTED);
            }
        } else {
            Logger.l(LOG_TAG, "Skipping chat initialization. Chat was in an unexpected state: " + this.chatState, new Object[0]);
        }
    }

    private void onChatStarted() {
        if (this.chatState == ChatState.INITIALIZED) {
            Log.v(LOG_TAG, "Chat started");
            setChatState(ChatState.STARTED);
            String str = this.department;
            if (str != null) {
                this.chat.setDepartment(str);
                return;
            }
            return;
        }
        Logger.g(LOG_TAG, "Skipping chat start. Chat was in an unexpected state: " + this.chatState, new Object[0]);
    }

    /* access modifiers changed from: private */
    public void prepareTimeout() {
        if (this.foreground) {
            return;
        }
        if (pushToken == null || this.chatState != ChatState.STARTED) {
            AlarmManager alarmManager = (AlarmManager) getSystemService("alarm");
            Intent startIntent = startIntent(this, ChatSession.ACTION_CHAT_SESSION_TIMEOUT, (String) null, (String) null, (ZopimChatApi.SessionApiConfig) null);
            PushAutoTrackHelper.hookIntentGetService(this, 0, startIntent, 134217728);
            PendingIntent service = PendingIntent.getService(this, 0, startIntent, 134217728);
            PushAutoTrackHelper.hookPendingIntentGetService(service, this, 0, startIntent, 134217728);
            if (alarmManager != null) {
                Logger.j(LOG_TAG, "Alarm manager acquired, scheduling chat timeout", new Object[0]);
                alarmManager.set(3, SystemClock.elapsedRealtime() + this.chatSessionTimeout, service);
                return;
            }
            Logger.l(LOG_TAG, "Could not get the Alarm manager, will not set chat timeout", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public void setChatState(ChatState chatState2) {
        this.chatState = chatState2;
        if (chatState2 != ChatState.INITIALIZED) {
            cancelTimeoutIntent();
        } else if (!this.foreground) {
            prepareTimeout();
        }
    }

    private void setRunning(boolean z11) {
        this.running.set(z11);
    }

    public static Intent startIntent(Context context, String str, String str2, String str3, ZopimChatApi.SessionApiConfig sessionApiConfig) {
        Intent intent = new Intent(context, ChatService.class);
        if (f.c(str)) {
            intent.setAction(str);
        }
        if (f.c(str2)) {
            intent.putExtra(EXTRA_ACCOUNT_KEY, str2);
        }
        if (f.c(str3)) {
            intent.putExtra(EXTRA_MACHINE_ID, str3);
        }
        if (sessionApiConfig != null) {
            intent.putExtra(EXTRA_SESSION_CONFIG, sessionApiConfig);
        }
        return intent;
    }

    public static void startService(Context context, String str, String str2, String str3, ZopimChatApi.SessionApiConfig sessionApiConfig) {
        ServiceUtils.startAsForegroundServiceIfNeeded(context, startIntent(context, str, str2, str3, sessionApiConfig));
    }

    private void storeNote(String str) {
        VisitorInfo visitorInfo = Storage.visitorInfo().getVisitorInfo();
        if (visitorInfo == null) {
            visitorInfo = new VisitorInfo.Builder().note(str).build();
        } else {
            visitorInfo.setNote(str);
        }
        Storage.visitorInfo().setVisitorInfo(visitorInfo);
        ZopimChatApi.setVisitorInfo(visitorInfo);
    }

    public void addNote(String str) {
        if (str != null) {
            this.chat.addNote(str);
            storeNote(str);
        }
    }

    public void clearPushToken() {
        pushToken = null;
        ChatCommunication chatCommunication = this.chat;
        if (chatCommunication != null) {
            chatCommunication.clearPushToken();
        }
    }

    public void disconnect() {
        Logger.j(LOG_TAG, "Terminating live connection", new Object[0]);
        ScheduledFuture scheduledFuture = this.keepAliveRunner;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ChatCommunication chatCommunication = this.chat;
        if (chatCommunication != null) {
            chatCommunication.disconnect();
        }
    }

    public boolean emailTranscript(String str) {
        if (canCommunicate()) {
            return this.chat.emailTranscript(str);
        }
        return false;
    }

    public void endChat() {
        if (canCommunicate()) {
            this.chat.endChat();
            setChatState(ChatState.ENDED);
            stopSelf();
            this.teardownHandler.removeCallbacksAndMessages((Object) null);
        } else {
            setChatState(ChatState.ENDING);
            Handler handler2 = this.teardownHandler;
            Runnable runnable = this.teardownRunnable;
            long j11 = END_CHAT_TIMEOUT;
            handler2.postDelayed(runnable, j11);
            Logger.l(LOG_TAG, String.format(Locale.US, "Unable to end the chat right now, will wait for connection for %d seconds before giving up.", new Object[]{Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j11))}), new Object[0]);
        }
        ScheduledFuture scheduledFuture = this.keepAliveRunner;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        BelvedereProvider.INSTANCE.getInstance(getApplicationContext()).a();
    }

    public void finalize() throws Throwable {
        Logger.j(LOG_TAG, "Service cleared from memory by GC", new Object[0]);
        super.finalize();
    }

    public ChatApiConfig getConfig() {
        return new ChatApiConfig() {
            public String getDepartment() {
                return ChatService.this.department != null ? ChatService.this.department : "";
            }

            public String[] getTags() {
                return ChatService.this.tags != null ? ChatService.this.tags : new String[0];
            }

            public VisitorInfo getVisitorInfo() {
                return new VisitorInfo.Builder().name(ChatService.this.visitorName).email(ChatService.this.visitorEmail).phoneNumber(ChatService.this.visitorPhoneNumber).note(ChatService.this.visitorNote).build();
            }
        };
    }

    public boolean hasEnded() {
        ChatState chatState2 = this.chatState;
        return chatState2 == ChatState.ENDED || chatState2 == ChatState.ENDING;
    }

    public boolean isRunning() {
        return this.running.get();
    }

    public IBinder onBind(Intent intent) {
        if (this.chatState == ChatState.PUSH) {
            this.chat = new WebBinder(this);
            this.chat.init(accountKey, Storage.machineId().getMachineId(), title, referrer);
            setChatState(ChatState.UNKNOWN);
        }
        return this.serviceBinder;
    }

    public void onCreate() {
        super.onCreate();
        Application application = (Application) getApplicationContext();
        this.app = application;
        AppLifeCycleHandler appLifeCycleHandler = new AppLifeCycleHandler(application);
        this.lifeCycleHandler = appLifeCycleHandler;
        this.app.registerActivityLifecycleCallbacks(appLifeCycleHandler);
        this.app.registerComponentCallbacks(this.lifeCycleHandler);
        ZopimChatApi.getDataSource().addConnectionObserver(this.connectionObserver);
        ZopimChatApi.getDataSource().addChatLogObserver(this.chatLogObserver);
        registerReceiver(this.connectivityReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        registerReceiver(this.chatTimeoutReceiver, new IntentFilter(ChatSession.ACTION_CHAT_SESSION_TIMEOUT));
        a.b(this).c(new ChatUIStateReceiver(), new IntentFilter(ChatSession.ACTION_CHAT_BACKGROUND));
        a.b(this).c(new ChatUIStateReceiver(), new IntentFilter(ChatSession.ACTION_CHAT_FOREGROUND));
        Logger.j(LOG_TAG, "Service created", new Object[0]);
    }

    public void onDestroy() {
        super.onDestroy();
        ScheduledFuture scheduledFuture = this.keepAliveRunner;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ZopimChatApi.getDataSource().deleteConnectionObserver(this.connectionObserver);
        ZopimChatApi.getDataSource().deleteChatLogObserver(this.chatLogObserver);
        this.app.unregisterActivityLifecycleCallbacks(this.lifeCycleHandler);
        this.app.unregisterComponentCallbacks(this.lifeCycleHandler);
        unregisterReceiver(this.connectivityReceiver);
        unregisterReceiver(this.chatTimeoutReceiver);
        Events.getQueue().addAll(this.unsentEvents);
        this.unsentEvents.clear();
        setRunning(false);
        Logger.j(LOG_TAG, "Chat service destroyed", new Object[0]);
    }

    public int onStartCommand(Intent intent, int i11, int i12) {
        ChatState chatState2;
        PushAutoTrackHelper.onServiceStartCommand(this, intent, i11, i12);
        setRunning(true);
        ServiceUtils.startForegroundIfNeeded(this, ZopimChatApi.getServiceNotificationServiceIntent());
        if (intent == null) {
            Logger.j(LOG_TAG, "Service restarted by the system, will not reinitialize the web binder", new Object[0]);
            return 1;
        }
        String action = intent.getAction();
        if (ChatSession.ACTION_CHAT_APP_BACKGROUND.equals(action)) {
            if (this.chatState == ChatState.STARTED && pushToken != null) {
                cancelTimeoutIntent();
                setChatState(ChatState.PUSH);
                disconnect();
            }
            return 1;
        }
        if (ChatSession.ACTION_CHAT_APP_FOREGROUND.equals(action)) {
            action = ACTION_CHAT_RECONNECT;
        }
        if (ChatSession.ACTION_CHAT_INITIALIZATION_TIMEOUT.equals(action)) {
            if (this.chatState != ChatState.INITIALIZING) {
                return 1;
            }
            Intent intent2 = new Intent();
            intent2.setAction(ChatSession.ACTION_CHAT_INITIALIZATION_TIMEOUT);
            intent2.setPackage(getApplicationContext().getPackageName());
            a.b(this).d(intent2);
            endChat();
            return 2;
        } else if (ChatSession.ACTION_CHAT_SESSION_TIMEOUT.equals(action)) {
            Logger.g(LOG_TAG, "Chat has timed out. Ending chat session.", new Object[0]);
            Intent intent3 = new Intent();
            if (pushToken == null || this.chatState == ChatState.INITIALIZED) {
                ZopimChatApi.chatSessionTimedOut();
                intent3.setAction(ChatSession.ACTION_CHAT_SESSION_TIMEOUT);
                a.b(this).d(intent3);
                endChat();
                return 2;
            }
            setChatState(ChatState.PUSH);
            disconnect();
            return 1;
        } else if (!ACTION_CHAT_RECONNECT.equals(action) || !((chatState2 = this.chatState) == ChatState.INITIALIZED || chatState2 == ChatState.INITIALIZING || chatState2 == ChatState.STARTED)) {
            if (accountKey == null) {
                accountKey = intent.getStringExtra(EXTRA_ACCOUNT_KEY);
            }
            if (accountKey == null) {
                Logger.l(LOG_TAG, "Can not start chat service without account id. Have you passed account id as extras?", new Object[0]);
                stopSelf();
                return 2;
            }
            this.chat = new WebBinder(this);
            setChatState(ChatState.INITIALIZING);
            ZopimChatApi.getDataSource().clear();
            String stringExtra = intent.getStringExtra(EXTRA_MACHINE_ID);
            if (stringExtra == null) {
                stringExtra = Storage.machineId().getMachineId();
            }
            Serializable serializableExtra = intent.getSerializableExtra(EXTRA_SESSION_CONFIG);
            if (serializableExtra instanceof ZopimChatApi.SessionApiConfig) {
                ZopimChatApi.SessionApiConfig sessionApiConfig = (ZopimChatApi.SessionApiConfig) serializableExtra;
                VisitorInfo visitorInfo = sessionApiConfig.visitorInfo;
                if (visitorInfo != null) {
                    this.visitorName = visitorInfo.getName();
                    this.visitorEmail = visitorInfo.getEmail();
                    this.visitorPhoneNumber = visitorInfo.getPhoneNumber();
                    this.visitorNote = visitorInfo.getNote();
                }
                this.department = sessionApiConfig.department;
                title = sessionApiConfig.title;
                referrer = sessionApiConfig.referrer;
                this.tags = sessionApiConfig.tags;
                this.chatInitializationTimeout = sessionApiConfig.initializationTimeout.longValue();
                this.chatSessionTimeout = sessionApiConfig.sessionTimeout.longValue();
            } else {
                Logger.l(LOG_TAG, "Error getting chat session configuration. Chat will not be configured.", new Object[0]);
            }
            if (this.chatInitializationTimeout <= 0) {
                Logger.g(LOG_TAG, "Configured chat initialization timeout is below the minimum threshold. Will use default timeout", new Object[0]);
                this.chatInitializationTimeout = ChatSession.DEFAULT_CHAT_INITIALIZATION_TIMEOUT;
            }
            if (this.chatSessionTimeout <= 0) {
                Logger.g(LOG_TAG, "Configured chat session timeout is below the minimum threshold. Will use default timeout", new Object[0]);
                this.chatSessionTimeout = ChatSession.DEFAULT_CHAT_SESSION_TIMEOUT;
            }
            configureInitializationTimeout(true);
            this.keepAliveRunner = Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new Runnable() {
                public void run() {
                    if (ChatService.this.canCommunicate()) {
                        ChatService.this.chat.keepAlive();
                    }
                }
            }, 1, 1, TimeUnit.MINUTES);
            this.chat.init(accountKey, stringExtra, title, referrer);
            Logger.j(LOG_TAG, "Chat service started", new Object[0]);
            return 1;
        } else {
            Logger.g(LOG_TAG, "Chat service already running and initialized, no need to re-initialize the web widget", new Object[0]);
            return 1;
        }
    }

    public void resend(String str) {
        if (canCommunicate()) {
            this.chat.resend(str);
        } else {
            Logger.j(LOG_TAG, "Unable to re-send message at the moment.", new Object[0]);
        }
    }

    public void resetTimeout() {
        prepareTimeout();
    }

    public void send(String str) {
        if (canCommunicate()) {
            if (this.chatState == ChatState.INITIALIZED) {
                onChatStarted();
            }
            this.chat.send(str);
            return;
        }
        Logger.j(LOG_TAG, "Unable to send message at the moment. Caching it for resending.", new Object[0]);
        this.unsentMessages.add(str);
    }

    public void sendChatComment(String str) {
        if (canCommunicate()) {
            this.chat.sendChatComment(str);
        }
    }

    public void sendChatRating(ChatLog.Rating rating) {
        if (canCommunicate()) {
            this.chat.sendChatRating(rating);
        }
    }

    public void sendEvents(Event... eventArr) {
        if (canCommunicate()) {
            this.chat.sendEvents(eventArr);
            return;
        }
        for (Event offer : eventArr) {
            this.unsentEvents.offer(offer);
        }
    }

    public boolean sendOfflineMessage(String str, String str2, String str3) {
        if (canCommunicate()) {
            return this.chat.sendOfflineMessage(str, str2, str3);
        }
        return false;
    }

    public void setDepartment(String str) {
        if (str != null) {
            this.department = str;
        }
    }

    public void setEmail(String str) {
        if (str != null) {
            this.chat.setEmail(str);
            VisitorInfo visitorInfo = Storage.visitorInfo().getVisitorInfo();
            if (visitorInfo == null) {
                visitorInfo = new VisitorInfo.Builder().email(str).build();
            } else {
                visitorInfo.setEmail(str);
            }
            Storage.visitorInfo().setVisitorInfo(visitorInfo);
            ZopimChatApi.setVisitorInfo(visitorInfo);
        }
    }

    public void setName(String str) {
        if (str != null) {
            this.chat.setName(str);
            VisitorInfo visitorInfo = Storage.visitorInfo().getVisitorInfo();
            if (visitorInfo == null) {
                visitorInfo = new VisitorInfo.Builder().name(str).build();
            } else {
                visitorInfo.setName(str);
            }
            Storage.visitorInfo().setVisitorInfo(visitorInfo);
            ZopimChatApi.setVisitorInfo(visitorInfo);
        }
    }

    public void setNote(String str) {
        if (str != null) {
            this.chat.setNote(str);
            storeNote(str);
        }
    }

    public void setPhoneNumber(String str) {
        if (str != null) {
            this.chat.setPhoneNumber(str);
            VisitorInfo visitorInfo = Storage.visitorInfo().getVisitorInfo();
            if (visitorInfo == null) {
                visitorInfo = new VisitorInfo.Builder().phoneNumber(str).build();
            } else {
                visitorInfo.setPhoneNumber(str);
            }
            Storage.visitorInfo().setVisitorInfo(visitorInfo);
            ZopimChatApi.setVisitorInfo(visitorInfo);
        }
    }

    public void setPushToken(String str) {
        pushToken = str;
        ChatCommunication chatCommunication = this.chat;
        if (chatCommunication != null) {
            chatCommunication.setPushToken(str);
            if (this.chatState == ChatState.PUSH) {
                this.chat = new WebBinder(this);
                this.chat.init(accountKey, Storage.machineId().getMachineId(), title, referrer);
                ZopimChatApi.getDataSource().clear();
                setChatState(ChatState.INITIALIZING);
            }
        }
    }

    public void send(File file) {
        if (canCommunicate()) {
            FileTransfers.Info find = FileTransfers.INSTANCE.find(file);
            if (find == null || find.status != FileTransfers.Status.FAILED) {
                this.chat.send(file);
                return;
            }
            Logger.j(LOG_TAG, "Re-sending file", new Object[0]);
            find.status = FileTransfers.Status.SCHEDULED;
            LivechatChatLogPath.getInstance().broadcast();
            return;
        }
        this.unsentFiles.add(file);
    }
}
