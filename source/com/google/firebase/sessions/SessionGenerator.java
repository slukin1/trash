package com.google.firebase.sessions;

import com.xiaomi.mipush.sdk.Constants;
import d10.a;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00048\u0006@BX.¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0019\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/google/firebase/sessions/SessionGenerator;", "", "", "generateSessionId", "Lcom/google/firebase/sessions/SessionDetails;", "generateNewSession", "", "collectEvents", "Z", "getCollectEvents", "()Z", "Lcom/google/firebase/sessions/TimeProvider;", "timeProvider", "Lcom/google/firebase/sessions/TimeProvider;", "firstSessionId", "Ljava/lang/String;", "", "sessionIndex", "I", "<set-?>", "currentSession", "Lcom/google/firebase/sessions/SessionDetails;", "getCurrentSession", "()Lcom/google/firebase/sessions/SessionDetails;", "getHasGenerateSession", "hasGenerateSession", "Lkotlin/Function0;", "Ljava/util/UUID;", "uuidGenerator", "<init>", "(ZLcom/google/firebase/sessions/TimeProvider;Ld10/a;)V", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
public final class SessionGenerator {
    private final boolean collectEvents;
    private SessionDetails currentSession;
    private final String firstSessionId;
    private int sessionIndex;
    private final TimeProvider timeProvider;
    private final a<UUID> uuidGenerator;

    public SessionGenerator(boolean z11, TimeProvider timeProvider2, a<UUID> aVar) {
        this.collectEvents = z11;
        this.timeProvider = timeProvider2;
        this.uuidGenerator = aVar;
        this.firstSessionId = generateSessionId();
        this.sessionIndex = -1;
    }

    private final String generateSessionId() {
        return StringsKt__StringsJVMKt.G(this.uuidGenerator.invoke().toString(), Constants.ACCEPT_TIME_SEPARATOR_SERVER, "", false, 4, (Object) null).toLowerCase(Locale.ROOT);
    }

    public final SessionDetails generateNewSession() {
        int i11 = this.sessionIndex + 1;
        this.sessionIndex = i11;
        this.currentSession = new SessionDetails(i11 == 0 ? this.firstSessionId : generateSessionId(), this.firstSessionId, this.sessionIndex, this.timeProvider.currentTimeUs());
        return getCurrentSession();
    }

    public final boolean getCollectEvents() {
        return this.collectEvents;
    }

    public final SessionDetails getCurrentSession() {
        SessionDetails sessionDetails = this.currentSession;
        if (sessionDetails != null) {
            return sessionDetails;
        }
        return null;
    }

    public final boolean getHasGenerateSession() {
        return this.currentSession != null;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SessionGenerator(boolean z11, TimeProvider timeProvider2, a aVar, int i11, r rVar) {
        this(z11, timeProvider2, (i11 & 4) != 0 ? AnonymousClass1.INSTANCE : aVar);
    }
}
