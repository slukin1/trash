package kotlinx.coroutines.debug.internal;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.c;

public final class DebugCoroutineInfoImpl {
    public volatile WeakReference<c> _lastObservedFrame;
    public volatile String _state;

    /* renamed from: a  reason: collision with root package name */
    public final f f57084a;

    /* renamed from: b  reason: collision with root package name */
    public final long f57085b;

    /* renamed from: c  reason: collision with root package name */
    public final WeakReference<CoroutineContext> f57086c;
    public volatile Thread lastObservedThread;

    public final List<StackTraceElement> b() {
        return CollectionsKt__CollectionsKt.k();
    }

    public final CoroutineContext c() {
        return (CoroutineContext) this.f57086c.get();
    }

    public final f d() {
        return this.f57084a;
    }

    public final List<StackTraceElement> e() {
        return b();
    }

    public final c f() {
        WeakReference<c> weakReference = this._lastObservedFrame;
        if (weakReference != null) {
            return (c) weakReference.get();
        }
        return null;
    }

    public final String g() {
        return this._state;
    }

    public final List<StackTraceElement> h() {
        c f11 = f();
        if (f11 == null) {
            return CollectionsKt__CollectionsKt.k();
        }
        ArrayList arrayList = new ArrayList();
        while (f11 != null) {
            StackTraceElement stackTraceElement = f11.getStackTraceElement();
            if (stackTraceElement != null) {
                arrayList.add(stackTraceElement);
            }
            f11 = f11.getCallerFrame();
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object i(kotlin.sequences.SequenceScope<? super java.lang.StackTraceElement> r6, kotlin.coroutines.jvm.internal.c r7, kotlin.coroutines.c<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1 r0 = (kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1 r0 = new kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r6 = r0.L$2
            kotlin.coroutines.jvm.internal.c r6 = (kotlin.coroutines.jvm.internal.c) r6
            java.lang.Object r7 = r0.L$1
            kotlin.sequences.SequenceScope r7 = (kotlin.sequences.SequenceScope) r7
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r2 = (kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl) r2
            kotlin.k.b(r8)
            goto L_0x005e
        L_0x0035:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003d:
            kotlin.k.b(r8)
            r2 = r5
        L_0x0041:
            if (r7 != 0) goto L_0x0046
            kotlin.Unit r6 = kotlin.Unit.f56620a
            return r6
        L_0x0046:
            java.lang.StackTraceElement r8 = r7.getStackTraceElement()
            if (r8 == 0) goto L_0x0061
            r0.L$0 = r2
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r8 = r6.b(r8, r0)
            if (r8 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r4 = r7
            r7 = r6
            r6 = r4
        L_0x005e:
            r4 = r7
            r7 = r6
            r6 = r4
        L_0x0061:
            kotlin.coroutines.jvm.internal.c r7 = r7.getCallerFrame()
            if (r7 == 0) goto L_0x0068
            goto L_0x0041
        L_0x0068:
            kotlin.Unit r6 = kotlin.Unit.f56620a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl.i(kotlin.sequences.SequenceScope, kotlin.coroutines.jvm.internal.c, kotlin.coroutines.c):java.lang.Object");
    }

    public String toString() {
        return "DebugCoroutineInfo(state=" + g() + ",context=" + c() + ')';
    }
}
