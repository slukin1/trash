package com.twitter.sdk.android.core;

import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.internal.persistence.PreferenceStore;
import com.twitter.sdk.android.core.internal.persistence.PreferenceStoreStrategy;
import com.twitter.sdk.android.core.internal.persistence.SerializationStrategy;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

public class PersistedSessionManager<T extends Session> implements SessionManager<T> {
    private static final int NUM_SESSIONS = 1;
    private final AtomicReference<T> activeSessionRef;
    private final PreferenceStoreStrategy<T> activeSessionStorage;
    private final String prefKeySession;
    private final PreferenceStore preferenceStore;
    private volatile boolean restorePending;
    private final SerializationStrategy<T> serializer;
    private final ConcurrentHashMap<Long, T> sessionMap;
    private final ConcurrentHashMap<Long, PreferenceStoreStrategy<T>> storageMap;

    public PersistedSessionManager(PreferenceStore preferenceStore2, SerializationStrategy<T> serializationStrategy, String str, String str2) {
        this(preferenceStore2, serializationStrategy, new ConcurrentHashMap(1), new ConcurrentHashMap(1), new PreferenceStoreStrategy(preferenceStore2, serializationStrategy, str), str2);
    }

    private void internalSetSession(long j11, T t11, boolean z11) {
        this.sessionMap.put(Long.valueOf(j11), t11);
        PreferenceStoreStrategy preferenceStoreStrategy = this.storageMap.get(Long.valueOf(j11));
        if (preferenceStoreStrategy == null) {
            preferenceStoreStrategy = new PreferenceStoreStrategy(this.preferenceStore, this.serializer, getPrefKey(j11));
            this.storageMap.putIfAbsent(Long.valueOf(j11), preferenceStoreStrategy);
        }
        preferenceStoreStrategy.save(t11);
        Session session = (Session) this.activeSessionRef.get();
        if (session == null || session.getId() == j11 || z11) {
            synchronized (this) {
                this.activeSessionRef.compareAndSet(session, t11);
                this.activeSessionStorage.save(t11);
            }
        }
    }

    private void restoreActiveSession() {
        Session session = (Session) this.activeSessionStorage.restore();
        if (session != null) {
            internalSetSession(session.getId(), session, false);
        }
    }

    private synchronized void restoreAllSessions() {
        if (this.restorePending) {
            restoreActiveSession();
            restoreSessions();
            this.restorePending = false;
        }
    }

    private void restoreSessions() {
        Session session;
        for (Map.Entry next : this.preferenceStore.get().getAll().entrySet()) {
            if (isSessionPreferenceKey((String) next.getKey()) && (session = (Session) this.serializer.deserialize((String) next.getValue())) != null) {
                internalSetSession(session.getId(), session, false);
            }
        }
    }

    public void clearActiveSession() {
        restoreAllSessionsIfNecessary();
        if (this.activeSessionRef.get() != null) {
            clearSession(((Session) this.activeSessionRef.get()).getId());
        }
    }

    public void clearSession(long j11) {
        restoreAllSessionsIfNecessary();
        if (this.activeSessionRef.get() != null && ((Session) this.activeSessionRef.get()).getId() == j11) {
            synchronized (this) {
                this.activeSessionRef.set((Object) null);
                this.activeSessionStorage.clear();
            }
        }
        this.sessionMap.remove(Long.valueOf(j11));
        PreferenceStoreStrategy remove = this.storageMap.remove(Long.valueOf(j11));
        if (remove != null) {
            remove.clear();
        }
    }

    public T getActiveSession() {
        restoreAllSessionsIfNecessary();
        return (Session) this.activeSessionRef.get();
    }

    public String getPrefKey(long j11) {
        return this.prefKeySession + "_" + j11;
    }

    public T getSession(long j11) {
        restoreAllSessionsIfNecessary();
        return (Session) this.sessionMap.get(Long.valueOf(j11));
    }

    public Map<Long, T> getSessionMap() {
        restoreAllSessionsIfNecessary();
        return Collections.unmodifiableMap(this.sessionMap);
    }

    public boolean isSessionPreferenceKey(String str) {
        return str.startsWith(this.prefKeySession);
    }

    public void restoreAllSessionsIfNecessary() {
        if (this.restorePending) {
            restoreAllSessions();
        }
    }

    public void setActiveSession(T t11) {
        if (t11 != null) {
            restoreAllSessionsIfNecessary();
            internalSetSession(t11.getId(), t11, true);
            return;
        }
        throw new IllegalArgumentException("Session must not be null!");
    }

    public void setSession(long j11, T t11) {
        if (t11 != null) {
            restoreAllSessionsIfNecessary();
            internalSetSession(j11, t11, false);
            return;
        }
        throw new IllegalArgumentException("Session must not be null!");
    }

    public PersistedSessionManager(PreferenceStore preferenceStore2, SerializationStrategy<T> serializationStrategy, ConcurrentHashMap<Long, T> concurrentHashMap, ConcurrentHashMap<Long, PreferenceStoreStrategy<T>> concurrentHashMap2, PreferenceStoreStrategy<T> preferenceStoreStrategy, String str) {
        this.restorePending = true;
        this.preferenceStore = preferenceStore2;
        this.serializer = serializationStrategy;
        this.sessionMap = concurrentHashMap;
        this.storageMap = concurrentHashMap2;
        this.activeSessionStorage = preferenceStoreStrategy;
        this.activeSessionRef = new AtomicReference<>();
        this.prefKeySession = str;
    }
}
