package com.zopim.android.sdk.api;

import java.util.concurrent.TimeUnit;

public interface ChatSession {
    public static final String ACTION_CHAT_APP_BACKGROUND = "chat.action.app.BACKGROUND";
    public static final String ACTION_CHAT_APP_FOREGROUND = "chat.action.app.FOREGROUND";
    public static final String ACTION_CHAT_BACKGROUND = "chat.action.BACKGROUND";
    public static final String ACTION_CHAT_FOREGROUND = "chat.action.FOREGROUND";
    public static final String ACTION_CHAT_INITIALIZATION_TIMEOUT = "chat.action.INITIALIZATION_TIMEOUT";
    public static final String ACTION_CHAT_SESSION_TIMEOUT = "chat.action.TIMEOUT";
    public static final long DEFAULT_CHAT_INITIALIZATION_TIMEOUT = TimeUnit.SECONDS.toMillis(40);
    public static final long DEFAULT_CHAT_SESSION_TIMEOUT;
    public static final long DEFAULT_RECONNECT_TIMEOUT;

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        DEFAULT_RECONNECT_TIMEOUT = timeUnit.toMillis(2);
        DEFAULT_CHAT_SESSION_TIMEOUT = timeUnit.toMillis(5);
    }
}
