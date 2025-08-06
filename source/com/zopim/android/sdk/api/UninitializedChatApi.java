package com.zopim.android.sdk.api;

import com.zopim.android.sdk.model.ChatLog;
import com.zopim.android.sdk.model.VisitorInfo;
import java.io.File;

class UninitializedChatApi implements ChatApi {
    public void addNote(String str) {
    }

    public void disconnect() {
    }

    public boolean emailTranscript(String str) {
        return false;
    }

    public void endChat() {
    }

    public ChatApiConfig getConfig() {
        return new ChatApiConfig() {
            public String getDepartment() {
                return "";
            }

            public String[] getTags() {
                return new String[0];
            }

            public VisitorInfo getVisitorInfo() {
                return new VisitorInfo.Builder().build();
            }
        };
    }

    public boolean hasEnded() {
        return true;
    }

    public void resend(String str) {
    }

    public void resetTimeout() {
    }

    public void send(File file) {
    }

    public void send(String str) {
    }

    public void sendChatComment(String str) {
    }

    public void sendChatRating(ChatLog.Rating rating) {
    }

    public boolean sendOfflineMessage(String str, String str2, String str3) {
        return false;
    }

    public void setDepartment(String str) {
    }

    public void setEmail(String str) {
    }

    public void setName(String str) {
    }

    public void setNote(String str) {
    }

    public void setPhoneNumber(String str) {
    }
}
