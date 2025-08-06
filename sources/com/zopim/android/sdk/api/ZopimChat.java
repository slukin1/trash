package com.zopim.android.sdk.api;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.api.ZopimChatApi;
import com.zopim.android.sdk.data.DataSource;
import com.zopim.android.sdk.model.ChatLog;
import com.zopim.android.sdk.model.VisitorInfo;
import com.zopim.android.sdk.prechat.EmailTranscript;
import com.zopim.android.sdk.prechat.PreChatForm;
import java.io.File;

public class ZopimChat implements Chat {
    private static final String LOG_TAG = "ZopimChat";
    /* access modifiers changed from: private */
    public static DefaultConfig defaultConfig = new DefaultConfig();
    /* access modifiers changed from: private */
    public static SessionConfig sessionConfig = new SessionConfig();
    private final ChatApi chatApi;

    public static class DefaultConfig extends ZopimChatApi.DefaultConfig<DefaultConfig> implements ConfigBuilder<DefaultConfig> {
        /* access modifiers changed from: private */
        public EmailTranscript emailTranscript;
        /* access modifiers changed from: private */
        public boolean fileSendingEnabled = true;
        /* access modifiers changed from: private */
        public PreChatForm preChatForm;

        public DefaultConfig emailTranscript(EmailTranscript emailTranscript2) {
            if (emailTranscript2 == null) {
                Logger.l(ZopimChat.LOG_TAG, "EmailTranscript must not be null", new Object[0]);
            } else {
                this.emailTranscript = emailTranscript2;
            }
            return this;
        }

        public DefaultConfig fileSending(boolean z11) {
            this.fileSendingEnabled = z11;
            return this;
        }

        public DefaultConfig preChatForm(PreChatForm preChatForm2) {
            if (preChatForm2 == null) {
                Logger.l(ZopimChat.LOG_TAG, "PreChatForm must not be null", new Object[0]);
            } else {
                this.preChatForm = preChatForm2;
            }
            return this;
        }
    }

    public static class SessionConfig extends ZopimChatApi.SessionApiConfig<SessionConfig> implements ConfigBuilder<SessionConfig> {
        /* access modifiers changed from: private */
        public EmailTranscript emailTranscript;
        /* access modifiers changed from: private */
        public Boolean fileSendingEnabled;
        /* access modifiers changed from: private */
        public PreChatForm preChatForm;

        public Chat build(FragmentActivity fragmentActivity) {
            ChatApi build = super.build(fragmentActivity);
            if (build instanceof UninitializedChatApi) {
                return new UninitializedChat();
            }
            if (this.preChatForm == null) {
                this.preChatForm = ZopimChat.defaultConfig.preChatForm;
            }
            if (this.emailTranscript == null) {
                this.emailTranscript = ZopimChat.defaultConfig.emailTranscript;
            }
            if (this.fileSendingEnabled == null) {
                this.fileSendingEnabled = Boolean.valueOf(ZopimChat.defaultConfig.fileSendingEnabled);
            }
            return new ZopimChat(build, this);
        }

        public SessionConfig emailTranscript(EmailTranscript emailTranscript2) {
            if (emailTranscript2 == null) {
                Logger.l(ZopimChat.LOG_TAG, "EmailTranscript must not be null", new Object[0]);
            } else {
                this.emailTranscript = emailTranscript2;
            }
            return this;
        }

        public SessionConfig fileSending(boolean z11) {
            this.fileSendingEnabled = Boolean.valueOf(z11);
            return this;
        }

        public SessionConfig preChatForm(PreChatForm preChatForm2) {
            if (preChatForm2 == null) {
                Logger.l(ZopimChat.LOG_TAG, "PreChatForm must not be null", new Object[0]);
            } else {
                this.preChatForm = preChatForm2;
            }
            return this;
        }
    }

    public static void clearPushToken() {
        ZopimChatApi.clearPushToken();
    }

    @Deprecated
    public static DataSource getDataSource() {
        return ZopimChatApi.getDataSource();
    }

    @Deprecated
    public static Long getInitializationTimeout() {
        return ZopimChatApi.getInitializationTimeout();
    }

    @Deprecated
    public static Long getReconnectTimeout() {
        return ZopimChatApi.getReconnectTimeout();
    }

    public static DefaultConfig init(String str) {
        try {
            defaultConfig = (DefaultConfig) ZopimChatApi.init(str, DefaultConfig.class);
        } catch (ExceptionInInitializerError unused) {
            Logger.l(LOG_TAG, "Failed to initialize configuration. Provided global configuration parameters will be ignored.", new Object[0]);
            defaultConfig = new DefaultConfig();
        }
        sessionConfig = new SessionConfig();
        return defaultConfig;
    }

    public static synchronized Chat resume(FragmentActivity fragmentActivity) {
        synchronized (ZopimChat.class) {
            ChatApi resume = ZopimChatApi.resume(fragmentActivity);
            if (resume instanceof UninitializedChatApi) {
                UninitializedChat uninitializedChat = new UninitializedChat();
                return uninitializedChat;
            }
            ZopimChat zopimChat = new ZopimChat(resume, sessionConfig);
            return zopimChat;
        }
    }

    public static void setPushToken(String str) {
        ZopimChatApi.setPushToken(str);
    }

    public static void setServiceNotificationContentIntent(Intent intent) {
        ZopimChatApi.setServiceNotificationContentIntent(intent);
    }

    public static void setVisitorInfo(VisitorInfo visitorInfo) {
        ZopimChatApi.setVisitorInfo(visitorInfo);
    }

    public static synchronized Chat start(FragmentActivity fragmentActivity) {
        Chat build;
        synchronized (ZopimChat.class) {
            build = new SessionConfig().build(fragmentActivity);
        }
        return build;
    }

    public static void trackEvent(String str) {
        ZopimChatApi.trackEvent(str);
    }

    public void addNote(String str) {
        this.chatApi.addNote(str);
    }

    public void disconnect() {
        this.chatApi.disconnect();
    }

    public boolean emailTranscript(String str) {
        return this.chatApi.emailTranscript(str);
    }

    public void endChat() {
        this.chatApi.endChat();
    }

    public boolean hasEnded() {
        return this.chatApi.hasEnded();
    }

    public void resend(String str) {
        this.chatApi.resend(str);
    }

    public void resetTimeout() {
        this.chatApi.resetTimeout();
    }

    public void send(String str) {
        this.chatApi.send(str);
    }

    public void sendChatComment(String str) {
        this.chatApi.sendChatComment(str);
    }

    public void sendChatRating(ChatLog.Rating rating) {
        this.chatApi.sendChatRating(rating);
    }

    public boolean sendOfflineMessage(String str, String str2, String str3) {
        return this.chatApi.sendOfflineMessage(str, str2, str3);
    }

    public void setDepartment(String str) {
        this.chatApi.setDepartment(str);
    }

    public void setEmail(String str) {
        this.chatApi.setEmail(str);
    }

    public void setName(String str) {
        this.chatApi.setName(str);
    }

    public void setNote(String str) {
        this.chatApi.setNote(str);
    }

    public void setPhoneNumber(String str) {
        this.chatApi.setPhoneNumber(str);
    }

    private ZopimChat(ChatApi chatApi2, SessionConfig sessionConfig2) {
        this.chatApi = chatApi2 == null ? new UninitializedChatApi() : chatApi2;
        sessionConfig = sessionConfig2 == null ? new SessionConfig() : sessionConfig2;
    }

    public ChatConfig getConfig() {
        final ChatApiConfig config = this.chatApi.getConfig();
        return new ChatConfig() {
            public String getDepartment() {
                return config.getDepartment();
            }

            public EmailTranscript getEmailTranscript() {
                EmailTranscript access$200 = ZopimChat.sessionConfig.emailTranscript;
                return access$200 != null ? access$200 : EmailTranscript.PROMPT;
            }

            public PreChatForm getPreChatForm() {
                PreChatForm access$100 = ZopimChat.sessionConfig.preChatForm;
                return access$100 != null ? access$100 : new PreChatForm.Builder().build();
            }

            public String[] getTags() {
                return config.getTags();
            }

            public VisitorInfo getVisitorInfo() {
                return config.getVisitorInfo();
            }

            public boolean isFileSendingEnabled() {
                Boolean access$300 = ZopimChat.sessionConfig.fileSendingEnabled;
                if (access$300 != null) {
                    return access$300.booleanValue();
                }
                return true;
            }
        };
    }

    public void send(File file) {
        this.chatApi.send(file);
    }
}
