package com.zopim.android.sdk.api;

import com.zopim.android.sdk.prechat.EmailTranscript;
import com.zopim.android.sdk.prechat.PreChatForm;

public interface ChatConfig extends ChatApiConfig {
    EmailTranscript getEmailTranscript();

    PreChatForm getPreChatForm();

    boolean isFileSendingEnabled();
}
