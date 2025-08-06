package com.zopim.android.sdk.api;

import com.zopim.android.sdk.model.ChatLog;
import com.zopim.android.sdk.model.VisitorInfo;
import com.zopim.android.sdk.prechat.EmailTranscript;
import com.zopim.android.sdk.prechat.PreChatForm;
import java.io.File;

public final class UninitializedChat extends UninitializedChatApi implements Chat {
    public /* bridge */ /* synthetic */ void addNote(String str) {
        super.addNote(str);
    }

    public /* bridge */ /* synthetic */ void disconnect() {
        super.disconnect();
    }

    public /* bridge */ /* synthetic */ boolean emailTranscript(String str) {
        return super.emailTranscript(str);
    }

    public /* bridge */ /* synthetic */ void endChat() {
        super.endChat();
    }

    public /* bridge */ /* synthetic */ boolean hasEnded() {
        return super.hasEnded();
    }

    public /* bridge */ /* synthetic */ void resend(String str) {
        super.resend(str);
    }

    public /* bridge */ /* synthetic */ void resetTimeout() {
        super.resetTimeout();
    }

    public /* bridge */ /* synthetic */ void send(File file) {
        super.send(file);
    }

    public /* bridge */ /* synthetic */ void sendChatComment(String str) {
        super.sendChatComment(str);
    }

    public /* bridge */ /* synthetic */ void sendChatRating(ChatLog.Rating rating) {
        super.sendChatRating(rating);
    }

    public /* bridge */ /* synthetic */ boolean sendOfflineMessage(String str, String str2, String str3) {
        return super.sendOfflineMessage(str, str2, str3);
    }

    public /* bridge */ /* synthetic */ void setDepartment(String str) {
        super.setDepartment(str);
    }

    public /* bridge */ /* synthetic */ void setEmail(String str) {
        super.setEmail(str);
    }

    public /* bridge */ /* synthetic */ void setName(String str) {
        super.setName(str);
    }

    public /* bridge */ /* synthetic */ void setNote(String str) {
        super.setNote(str);
    }

    public /* bridge */ /* synthetic */ void setPhoneNumber(String str) {
        super.setPhoneNumber(str);
    }

    public ChatConfig getConfig() {
        final ChatApiConfig config = super.getConfig();
        return new ChatConfig() {
            public String getDepartment() {
                return config.getDepartment();
            }

            public EmailTranscript getEmailTranscript() {
                return EmailTranscript.PROMPT;
            }

            public PreChatForm getPreChatForm() {
                return new PreChatForm.Builder().build();
            }

            public String[] getTags() {
                return config.getTags();
            }

            public VisitorInfo getVisitorInfo() {
                return config.getVisitorInfo();
            }

            public boolean isFileSendingEnabled() {
                return false;
            }
        };
    }

    public /* bridge */ /* synthetic */ void send(String str) {
        super.send(str);
    }
}
