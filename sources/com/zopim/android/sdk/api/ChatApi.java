package com.zopim.android.sdk.api;

public interface ChatApi extends ChatApiCommands {
    ChatApiConfig getConfig();

    boolean hasEnded();

    void resetTimeout();
}
