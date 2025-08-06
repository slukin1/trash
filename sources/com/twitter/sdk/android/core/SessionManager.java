package com.twitter.sdk.android.core;

import com.twitter.sdk.android.core.Session;
import java.util.Map;

public interface SessionManager<T extends Session> {
    void clearActiveSession();

    void clearSession(long j11);

    T getActiveSession();

    T getSession(long j11);

    Map<Long, T> getSessionMap();

    void setActiveSession(T t11);

    void setSession(long j11, T t11);
}
