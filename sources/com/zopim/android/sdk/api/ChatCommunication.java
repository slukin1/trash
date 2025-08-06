package com.zopim.android.sdk.api;

import com.zopim.android.sdk.breadcrumbs.Event;

abstract class ChatCommunication implements ChatApiCommands, BreadcrumbsApi {
    public abstract void addTags(String... strArr);

    public abstract void clearPushToken();

    public abstract void init(String str, String str2, String str3, String str4);

    public abstract void keepAlive();

    public abstract void removeTags(String... strArr);

    public abstract void sendChatButtonClicked();

    public abstract void sendVisitorPath(Event event);

    public abstract void sendVisitorPaths(Event[] eventArr);

    public abstract void setPushToken(String str);
}
