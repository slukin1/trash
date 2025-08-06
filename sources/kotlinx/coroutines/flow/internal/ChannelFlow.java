package kotlinx.coroutines.flow.internal;

import d10.l;
import d10.p;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.k;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.k0;

public abstract class ChannelFlow<T> implements h<T> {

    /* renamed from: b  reason: collision with root package name */
    public final CoroutineContext f57236b;

    /* renamed from: c  reason: collision with root package name */
    public final int f57237c;

    /* renamed from: d  reason: collision with root package name */
    public final BufferOverflow f57238d;

    public ChannelFlow(CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        this.f57236b = coroutineContext;
        this.f57237c = i11;
        this.f57238d = bufferOverflow;
        if (j0.a()) {
            if (!(i11 != -1)) {
                throw new AssertionError();
            }
        }
    }

    public static /* synthetic */ <T> Object g(ChannelFlow<T> channelFlow, e<? super T> eVar, c<? super Unit> cVar) {
        Object g11 = i0.g(new ChannelFlow$collect$2(eVar, channelFlow, (c<? super ChannelFlow$collect$2>) null), cVar);
        return g11 == IntrinsicsKt__IntrinsicsKt.d() ? g11 : Unit.f56620a;
    }

    public d<T> c(CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        boolean z11 = true;
        if (j0.a()) {
            if (!(i11 != -1)) {
                throw new AssertionError();
            }
        }
        CoroutineContext plus = coroutineContext.plus(this.f57236b);
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            int i12 = this.f57237c;
            if (i12 != -3) {
                if (i11 != -3) {
                    if (i12 != -2) {
                        if (i11 != -2) {
                            if (j0.a()) {
                                if (!(this.f57237c >= 0)) {
                                    throw new AssertionError();
                                }
                            }
                            if (j0.a()) {
                                if (i11 < 0) {
                                    z11 = false;
                                }
                                if (!z11) {
                                    throw new AssertionError();
                                }
                            }
                            i12 = this.f57237c + i11;
                            if (i12 < 0) {
                                i11 = Integer.MAX_VALUE;
                            }
                        }
                    }
                }
                i11 = i12;
            }
            bufferOverflow = this.f57238d;
        }
        if (x.b(plus, this.f57236b) && i11 == this.f57237c && bufferOverflow == this.f57238d) {
            return this;
        }
        return i(plus, i11, bufferOverflow);
    }

    public Object collect(e<? super T> eVar, c<? super Unit> cVar) {
        return g(this, eVar, cVar);
    }

    public String f() {
        return null;
    }

    public abstract Object h(k<? super T> kVar, c<? super Unit> cVar);

    public abstract ChannelFlow<T> i(CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow);

    public d<T> j() {
        return null;
    }

    public final p<k<? super T>, c<? super Unit>, Object> k() {
        return new ChannelFlow$collectToFun$1(this, (c<? super ChannelFlow$collectToFun$1>) null);
    }

    public final int l() {
        int i11 = this.f57237c;
        if (i11 == -3) {
            return -2;
        }
        return i11;
    }

    public ReceiveChannel<T> m(h0 h0Var) {
        return ProduceKt.e(h0Var, this.f57236b, l(), this.f57238d, CoroutineStart.ATOMIC, (l) null, k(), 16, (Object) null);
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String f11 = f();
        if (f11 != null) {
            arrayList.add(f11);
        }
        if (this.f57236b != EmptyCoroutineContext.INSTANCE) {
            arrayList.add("context=" + this.f57236b);
        }
        if (this.f57237c != -3) {
            arrayList.add("capacity=" + this.f57237c);
        }
        if (this.f57238d != BufferOverflow.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.f57238d);
        }
        return k0.a(this) + '[' + CollectionsKt___CollectionsKt.k0(arrayList, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 62, (Object) null) + ']';
    }
}
