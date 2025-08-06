package androidx.window.layout;

import android.app.Activity;
import d10.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.flow.e;

@d(c = "androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1", f = "WindowInfoTrackerImpl.kt", l = {54, 55}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H@"}, d2 = {"Lkotlinx/coroutines/flow/e;", "Landroidx/window/layout/s;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
public final class WindowInfoTrackerImpl$windowLayoutInfo$1 extends SuspendLambda implements p<e<? super s>, c<? super Unit>, Object> {
    public final /* synthetic */ Activity $activity;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public final /* synthetic */ WindowInfoTrackerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WindowInfoTrackerImpl$windowLayoutInfo$1(WindowInfoTrackerImpl windowInfoTrackerImpl, Activity activity, c<? super WindowInfoTrackerImpl$windowLayoutInfo$1> cVar) {
        super(2, cVar);
        this.this$0 = windowInfoTrackerImpl;
        this.$activity = activity;
    }

    /* access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    public static final void m12invokeSuspend$lambda0(kotlinx.coroutines.channels.d dVar, s sVar) {
        dVar.q(sVar);
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        WindowInfoTrackerImpl$windowLayoutInfo$1 windowInfoTrackerImpl$windowLayoutInfo$1 = new WindowInfoTrackerImpl$windowLayoutInfo$1(this.this$0, this.$activity, cVar);
        windowInfoTrackerImpl$windowLayoutInfo$1.L$0 = obj;
        return windowInfoTrackerImpl$windowLayoutInfo$1;
    }

    public final Object invoke(e<? super s> eVar, c<? super Unit> cVar) {
        return ((WindowInfoTrackerImpl$windowLayoutInfo$1) create(eVar, cVar)).invokeSuspend(Unit.f56620a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0070 A[Catch:{ all -> 0x009e }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007b A[Catch:{ all -> 0x009e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r9.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0039
            if (r1 == r3) goto L_0x0027
            if (r1 != r2) goto L_0x001f
            java.lang.Object r1 = r9.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r9.L$1
            androidx.core.util.Consumer r4 = (androidx.core.util.Consumer) r4
            java.lang.Object r5 = r9.L$0
            kotlinx.coroutines.flow.e r5 = (kotlinx.coroutines.flow.e) r5
            kotlin.k.b(r10)     // Catch:{ all -> 0x00a0 }
            r10 = r5
            goto L_0x0060
        L_0x001f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0027:
            java.lang.Object r1 = r9.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r9.L$1
            androidx.core.util.Consumer r4 = (androidx.core.util.Consumer) r4
            java.lang.Object r5 = r9.L$0
            kotlinx.coroutines.flow.e r5 = (kotlinx.coroutines.flow.e) r5
            kotlin.k.b(r10)     // Catch:{ all -> 0x00a0 }
            r6 = r5
            r5 = r9
            goto L_0x0073
        L_0x0039:
            kotlin.k.b(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.flow.e r10 = (kotlinx.coroutines.flow.e) r10
            r1 = 10
            kotlinx.coroutines.channels.BufferOverflow r4 = kotlinx.coroutines.channels.BufferOverflow.DROP_OLDEST
            r5 = 4
            r6 = 0
            kotlinx.coroutines.channels.d r1 = kotlinx.coroutines.channels.f.b(r1, r4, r6, r5, r6)
            androidx.window.layout.r r4 = new androidx.window.layout.r
            r4.<init>(r1)
            androidx.window.layout.WindowInfoTrackerImpl r5 = r9.this$0
            androidx.window.layout.n r5 = r5.f12104c
            android.app.Activity r6 = r9.$activity
            androidx.profileinstaller.f r7 = androidx.profileinstaller.f.f10497b
            r5.a(r6, r7, r4)
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()     // Catch:{ all -> 0x00a0 }
        L_0x0060:
            r5 = r9
        L_0x0061:
            r5.L$0 = r10     // Catch:{ all -> 0x009e }
            r5.L$1 = r4     // Catch:{ all -> 0x009e }
            r5.L$2 = r1     // Catch:{ all -> 0x009e }
            r5.label = r3     // Catch:{ all -> 0x009e }
            java.lang.Object r6 = r1.a(r5)     // Catch:{ all -> 0x009e }
            if (r6 != r0) goto L_0x0070
            return r0
        L_0x0070:
            r8 = r6
            r6 = r10
            r10 = r8
        L_0x0073:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x009e }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x009e }
            if (r10 == 0) goto L_0x0092
            java.lang.Object r10 = r1.next()     // Catch:{ all -> 0x009e }
            androidx.window.layout.s r10 = (androidx.window.layout.s) r10     // Catch:{ all -> 0x009e }
            r5.L$0 = r6     // Catch:{ all -> 0x009e }
            r5.L$1 = r4     // Catch:{ all -> 0x009e }
            r5.L$2 = r1     // Catch:{ all -> 0x009e }
            r5.label = r2     // Catch:{ all -> 0x009e }
            java.lang.Object r10 = r6.emit(r10, r5)     // Catch:{ all -> 0x009e }
            if (r10 != r0) goto L_0x0090
            return r0
        L_0x0090:
            r10 = r6
            goto L_0x0061
        L_0x0092:
            androidx.window.layout.WindowInfoTrackerImpl r10 = r5.this$0
            androidx.window.layout.n r10 = r10.f12104c
            r10.b(r4)
            kotlin.Unit r10 = kotlin.Unit.f56620a
            return r10
        L_0x009e:
            r10 = move-exception
            goto L_0x00a2
        L_0x00a0:
            r10 = move-exception
            r5 = r9
        L_0x00a2:
            androidx.window.layout.WindowInfoTrackerImpl r0 = r5.this$0
            androidx.window.layout.n r0 = r0.f12104c
            r0.b(r4)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
