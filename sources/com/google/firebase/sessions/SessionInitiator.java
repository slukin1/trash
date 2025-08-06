package com.google.firebase.sessions;

import android.app.Application;
import com.google.firebase.sessions.settings.SessionsSettings;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.time.b;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;

@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001f\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\u00020\u00188\u0000X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Lcom/google/firebase/sessions/SessionInitiator;", "", "", "initiateSession", "appBackgrounded", "appForegrounded", "Lcom/google/firebase/sessions/TimeProvider;", "timeProvider", "Lcom/google/firebase/sessions/TimeProvider;", "Lkotlin/coroutines/CoroutineContext;", "backgroundDispatcher", "Lkotlin/coroutines/CoroutineContext;", "Lcom/google/firebase/sessions/SessionInitiateListener;", "sessionInitiateListener", "Lcom/google/firebase/sessions/SessionInitiateListener;", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "sessionsSettings", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "Lcom/google/firebase/sessions/SessionGenerator;", "sessionGenerator", "Lcom/google/firebase/sessions/SessionGenerator;", "Lkotlin/time/b;", "backgroundTime", "J", "Landroid/app/Application$ActivityLifecycleCallbacks;", "activityLifecycleCallbacks", "Landroid/app/Application$ActivityLifecycleCallbacks;", "getActivityLifecycleCallbacks$com_google_firebase_firebase_sessions", "()Landroid/app/Application$ActivityLifecycleCallbacks;", "<init>", "(Lcom/google/firebase/sessions/TimeProvider;Lkotlin/coroutines/CoroutineContext;Lcom/google/firebase/sessions/SessionInitiateListener;Lcom/google/firebase/sessions/settings/SessionsSettings;Lcom/google/firebase/sessions/SessionGenerator;)V", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
public final class SessionInitiator {
    private final Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new SessionInitiator$activityLifecycleCallbacks$1(this);
    private final CoroutineContext backgroundDispatcher;
    private long backgroundTime;
    private final SessionGenerator sessionGenerator;
    /* access modifiers changed from: private */
    public final SessionInitiateListener sessionInitiateListener;
    private final SessionsSettings sessionsSettings;
    private final TimeProvider timeProvider;

    public SessionInitiator(TimeProvider timeProvider2, CoroutineContext coroutineContext, SessionInitiateListener sessionInitiateListener2, SessionsSettings sessionsSettings2, SessionGenerator sessionGenerator2) {
        this.timeProvider = timeProvider2;
        this.backgroundDispatcher = coroutineContext;
        this.sessionInitiateListener = sessionInitiateListener2;
        this.sessionsSettings = sessionsSettings2;
        this.sessionGenerator = sessionGenerator2;
        this.backgroundTime = timeProvider2.m3250elapsedRealtimeUwyO8pc();
        initiateSession();
    }

    private final void initiateSession() {
        n1 unused = i.d(i0.a(this.backgroundDispatcher), (CoroutineContext) null, (CoroutineStart) null, new SessionInitiator$initiateSession$1(this, this.sessionGenerator.generateNewSession(), (c<? super SessionInitiator$initiateSession$1>) null), 3, (Object) null);
    }

    public final void appBackgrounded() {
        this.backgroundTime = this.timeProvider.m3250elapsedRealtimeUwyO8pc();
    }

    public final void appForegrounded() {
        if (b.h(b.D(this.timeProvider.m3250elapsedRealtimeUwyO8pc(), this.backgroundTime), this.sessionsSettings.m3254getSessionRestartTimeoutUwyO8pc()) > 0) {
            initiateSession();
        }
    }

    public final Application.ActivityLifecycleCallbacks getActivityLifecycleCallbacks$com_google_firebase_firebase_sessions() {
        return this.activityLifecycleCallbacks;
    }
}
