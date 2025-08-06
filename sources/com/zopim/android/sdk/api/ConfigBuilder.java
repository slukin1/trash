package com.zopim.android.sdk.api;

import com.zopim.android.sdk.api.ApiConfigBuilder;
import com.zopim.android.sdk.prechat.EmailTranscript;
import com.zopim.android.sdk.prechat.PreChatForm;

interface ConfigBuilder<T extends ApiConfigBuilder> {
    T emailTranscript(EmailTranscript emailTranscript);

    T fileSending(boolean z11);

    T preChatForm(PreChatForm preChatForm);
}
