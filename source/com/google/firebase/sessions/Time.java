package com.google.firebase.sessions;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.time.DurationUnit;
import kotlin.time.b;
import kotlin.time.d;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0005\u001a\u00020\u0002H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/google/firebase/sessions/Time;", "Lcom/google/firebase/sessions/TimeProvider;", "Lkotlin/time/b;", "elapsedRealtime-UwyO8pc", "()J", "elapsedRealtime", "", "currentTimeUs", "<init>", "()V", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
public final class Time implements TimeProvider {
    public static final Companion Companion = new Companion((r) null);
    private static final long US_PER_MILLIS = 1000;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/google/firebase/sessions/Time$Companion;", "", "()V", "US_PER_MILLIS", "", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public long currentTimeUs() {
        return System.currentTimeMillis() * 1000;
    }

    /* renamed from: elapsedRealtime-UwyO8pc  reason: not valid java name */
    public long m3249elapsedRealtimeUwyO8pc() {
        b.a aVar = b.f56931c;
        return d.t(SystemClock.elapsedRealtime(), DurationUnit.MILLISECONDS);
    }
}
