package com.zopim.android.sdk.api;

import com.zopim.android.sdk.model.ChatLog;
import java.io.File;

public interface ChatApiCommands {
    void addNote(String str);

    void disconnect();

    boolean emailTranscript(String str);

    void endChat();

    void resend(String str);

    void send(File file);

    void send(String str);

    void sendChatComment(String str);

    void sendChatRating(ChatLog.Rating rating);

    boolean sendOfflineMessage(String str, String str2, String str3);

    void setDepartment(String str);

    void setEmail(String str);

    void setName(String str);

    void setNote(String str);

    void setPhoneNumber(String str);
}
