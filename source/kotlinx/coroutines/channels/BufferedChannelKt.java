package kotlinx.coroutines.channels;

import d10.l;
import kotlin.Unit;
import kotlin.reflect.g;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.k;

public final class BufferedChannelKt {

    /* renamed from: a  reason: collision with root package name */
    public static final g<Object> f57018a = new g(-1, (g) null, (BufferedChannel) null, 0);

    /* renamed from: b  reason: collision with root package name */
    public static final int f57019b = f0.e("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, (Object) null);

    /* renamed from: c  reason: collision with root package name */
    public static final int f57020c = f0.e("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, (Object) null);

    /* renamed from: d  reason: collision with root package name */
    public static final c0 f57021d = new c0("BUFFERED");

    /* renamed from: e  reason: collision with root package name */
    public static final c0 f57022e = new c0("SHOULD_BUFFER");

    /* renamed from: f  reason: collision with root package name */
    public static final c0 f57023f = new c0("S_RESUMING_BY_RCV");

    /* renamed from: g  reason: collision with root package name */
    public static final c0 f57024g = new c0("RESUMING_BY_EB");

    /* renamed from: h  reason: collision with root package name */
    public static final c0 f57025h = new c0("POISONED");

    /* renamed from: i  reason: collision with root package name */
    public static final c0 f57026i = new c0("DONE_RCV");

    /* renamed from: j  reason: collision with root package name */
    public static final c0 f57027j = new c0("INTERRUPTED_SEND");

    /* renamed from: k  reason: collision with root package name */
    public static final c0 f57028k = new c0("INTERRUPTED_RCV");

    /* renamed from: l  reason: collision with root package name */
    public static final c0 f57029l = new c0("CHANNEL_CLOSED");

    /* renamed from: m  reason: collision with root package name */
    public static final c0 f57030m = new c0("SUSPEND");

    /* renamed from: n  reason: collision with root package name */
    public static final c0 f57031n = new c0("SUSPEND_NO_WAITER");

    /* renamed from: o  reason: collision with root package name */
    public static final c0 f57032o = new c0("FAILED");

    /* renamed from: p  reason: collision with root package name */
    public static final c0 f57033p = new c0("NO_RECEIVE_RESULT");

    /* renamed from: q  reason: collision with root package name */
    public static final c0 f57034q = new c0("CLOSE_HANDLER_CLOSED");

    /* renamed from: r  reason: collision with root package name */
    public static final c0 f57035r = new c0("CLOSE_HANDLER_INVOKED");

    /* renamed from: s  reason: collision with root package name */
    public static final c0 f57036s = new c0("NO_CLOSE_CAUSE");

    public static final long A(int i11) {
        if (i11 == 0) {
            return 0;
        }
        if (i11 != Integer.MAX_VALUE) {
            return (long) i11;
        }
        return Long.MAX_VALUE;
    }

    public static final <T> boolean B(k<? super T> kVar, T t11, l<? super Throwable, Unit> lVar) {
        Object D = kVar.D(t11, (Object) null, lVar);
        if (D == null) {
            return false;
        }
        kVar.w(D);
        return true;
    }

    public static /* synthetic */ boolean C(k kVar, Object obj, l lVar, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            lVar = null;
        }
        return B(kVar, obj, lVar);
    }

    public static final long v(long j11, boolean z11) {
        return (z11 ? 4611686018427387904L : 0) + j11;
    }

    public static final long w(long j11, int i11) {
        return (((long) i11) << 60) + j11;
    }

    public static final <E> g<E> x(long j11, g<E> gVar) {
        return new g(j11, gVar, gVar.u(), 0);
    }

    public static final <E> g<g<E>> y() {
        return BufferedChannelKt$createSegmentFunction$1.INSTANCE;
    }

    public static final c0 z() {
        return f57029l;
    }
}
