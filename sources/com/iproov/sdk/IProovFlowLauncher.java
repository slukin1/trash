package com.iproov.sdk;

import android.content.Context;
import androidx.annotation.Keep;
import com.iproov.sdk.CommonApi;
import com.iproov.sdk.IProov;
import com.iproov.sdk.core.Cfor;
import com.iproov.sdk.core.exception.UnexpectedErrorException;
import com.iproov.sdk.p004catch.Cdo;
import com.iproov.sdk.p009do.Cnew;
import com.iproov.sdk.utils.BaseCoroutineScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.h0;

@Metadata(bv = {}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\"\u0010#B\u0011\b\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\"\u0010$J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0015\u0010\f\u001a\u0004\u0018\u00010\u000bH@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ5\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J3\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0019\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lcom/iproov/sdk/IProovFlowLauncher;", "Lcom/iproov/sdk/CommonApi;", "Lcom/iproov/sdk/utils/BaseCoroutineScope;", "Landroid/content/Context;", "context", "Lcom/iproov/sdk/catch/do;", "getAppComponent", "", "doStop", "Lcom/iproov/sdk/CommonApi$KeyPair;", "getKeyPair", "Lcom/iproov/sdk/IProov$Session;", "currentSession", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "streamingUrl", "token", "Lcom/iproov/sdk/IProov$Options;", "options", "launch", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/iproov/sdk/IProov$Options;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lcom/iproov/sdk/return/extends;", "sessionOptions", "launchSession$iproov_release", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/iproov/sdk/return/extends;Lkotlin/coroutines/c;)Ljava/lang/Object;", "launchSession", "Lcom/iproov/sdk/core/for;", "internalOptions", "Lcom/iproov/sdk/core/for;", "Lkotlinx/coroutines/flow/j1;", "Lcom/iproov/sdk/IProov$IProovSessionState;", "getSessionsStates", "()Lkotlinx/coroutines/flow/j1;", "sessionsStates", "<init>", "()V", "(Lcom/iproov/sdk/core/for;)V", "iproov_release"}, k = 1, mv = {1, 5, 1})
@Keep
public final class IProovFlowLauncher extends BaseCoroutineScope implements CommonApi {
    private Cdo appComponent;
    /* access modifiers changed from: private */
    public Cfor internalOptions;

    public IProovFlowLauncher() {
        super((CoroutineDispatcher) null, 1, (r) null);
        this.internalOptions = new Cfor();
    }

    /* access modifiers changed from: private */
    public final Cdo getAppComponent(Context context) {
        Cdo doVar = this.appComponent;
        if (doVar != null) {
            return doVar;
        }
        com.iproov.sdk.p027static.Cdo doVar2 = new com.iproov.sdk.p027static.Cdo(context.getApplicationContext());
        this.appComponent = doVar2;
        return doVar2;
    }

    public static /* synthetic */ Object launch$default(IProovFlowLauncher iProovFlowLauncher, Context context, String str, String str2, IProov.Options options, c cVar, int i11, Object obj) {
        return iProovFlowLauncher.launch(context, str, str2, (i11 & 8) != 0 ? new IProov.Options((String) null, 0, 0, (IProov.Options.Filter) null, 0, (IProov.Options.Font) null, (IProov.Options.Icon) null, false, (IProov.Options.CloseButton) null, 0, 0, false, false, (List) null, 0, (IProov.Orientation) null, (IProov.Camera) null, (IProov.FaceDetector) null, (IProov.Options.GenuinePresenceAssurance) null, (IProov.Options.LivenessAssurance) null, 1048575, (r) null) : options, cVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043 A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object currentSession(kotlin.coroutines.c<? super com.iproov.sdk.IProov.Session> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.iproov.sdk.IProovFlowLauncher$currentSession$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.iproov.sdk.IProovFlowLauncher$currentSession$1 r0 = (com.iproov.sdk.IProovFlowLauncher$currentSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.iproov.sdk.IProovFlowLauncher$currentSession$1 r0 = new com.iproov.sdk.IProovFlowLauncher$currentSession$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.k.b(r5)
            goto L_0x003f
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0031:
            kotlin.k.b(r5)
            com.iproov.sdk.do.new r5 = com.iproov.sdk.p009do.Cnew.f489do
            r0.label = r3
            java.lang.Object r5 = r5.m574do((kotlin.coroutines.c<? super com.iproov.sdk.p009do.Ccase>) r0)
            if (r5 != r1) goto L_0x003f
            return r1
        L_0x003f:
            com.iproov.sdk.do.case r5 = (com.iproov.sdk.p009do.Ccase) r5
            if (r5 != 0) goto L_0x0045
            r5 = 0
            goto L_0x0049
        L_0x0045:
            com.iproov.sdk.IProov$Session r5 = com.iproov.sdk.Cdo.m544do((com.iproov.sdk.p009do.Ccase) r5)
        L_0x0049:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.IProovFlowLauncher.currentSession(kotlin.coroutines.c):java.lang.Object");
    }

    public void doStop() {
        IProov.Session session;
        super.doStop();
        IProov.IProovSessionState value = getSessionsStates().getValue();
        if (value != null && (session = value.getSession()) != null) {
            session.cancel();
        }
    }

    public String getBuildHash() {
        return CommonApi.Cdo.m54do(this);
    }

    public String getBuildNumber() {
        return CommonApi.Cdo.m56if(this);
    }

    public CommonApi.KeyPair getKeyPair(Context context) throws UnexpectedErrorException {
        return Cdo.m527do(getAppComponent(context).m244do());
    }

    public String getSdkVersion() {
        return CommonApi.Cdo.m55for(this);
    }

    public final j1<IProov.IProovSessionState> getSessionsStates() {
        Cnew newR = Cnew.f489do;
        IProovFlowLauncher$special$$inlined$map$1 iProovFlowLauncher$special$$inlined$map$1 = new IProovFlowLauncher$special$$inlined$map$1(f.b(newR.m575do()), this);
        i1 c11 = i1.f57228a.c();
        IProovSessionState value = newR.m575do().getValue();
        return f.a0(iProovFlowLauncher$special$$inlined$map$1, this, c11, value == null ? null : Cdo.m533do(value, (h0) this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object launch(android.content.Context r11, java.lang.String r12, java.lang.String r13, com.iproov.sdk.IProov.Options r14, kotlin.coroutines.c<? super com.iproov.sdk.IProov.Session> r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof com.iproov.sdk.IProovFlowLauncher$launch$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.iproov.sdk.IProovFlowLauncher$launch$1 r0 = (com.iproov.sdk.IProovFlowLauncher$launch$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.iproov.sdk.IProovFlowLauncher$launch$1 r0 = new com.iproov.sdk.IProovFlowLauncher$launch$1
            r0.<init>(r10, r15)
        L_0x0018:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.k.b(r15)
            goto L_0x004a
        L_0x0029:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0031:
            kotlin.k.b(r15)
            com.iproov.sdk.do.new r15 = com.iproov.sdk.p009do.Cnew.f489do
            com.iproov.sdk.IProovFlowLauncher$launch$2 r2 = new com.iproov.sdk.IProovFlowLauncher$launch$2
            r4 = r2
            r5 = r10
            r6 = r11
            r7 = r12
            r8 = r13
            r9 = r14
            r4.<init>(r5, r6, r7, r8, r9)
            r0.label = r3
            java.lang.Object r15 = r15.m573do(r11, r13, r2, r0)
            if (r15 != r1) goto L_0x004a
            return r1
        L_0x004a:
            com.iproov.sdk.do.case r15 = (com.iproov.sdk.p009do.Ccase) r15
            com.iproov.sdk.IProov$Session r11 = com.iproov.sdk.Cdo.m544do((com.iproov.sdk.p009do.Ccase) r15)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.IProovFlowLauncher.launch(android.content.Context, java.lang.String, java.lang.String, com.iproov.sdk.IProov$Options, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object launchSession$iproov_release(android.content.Context r11, java.lang.String r12, java.lang.String r13, com.iproov.sdk.p026return.Cextends r14, kotlin.coroutines.c<? super com.iproov.sdk.IProov.Session> r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof com.iproov.sdk.IProovFlowLauncher$launchSession$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.iproov.sdk.IProovFlowLauncher$launchSession$1 r0 = (com.iproov.sdk.IProovFlowLauncher$launchSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.iproov.sdk.IProovFlowLauncher$launchSession$1 r0 = new com.iproov.sdk.IProovFlowLauncher$launchSession$1
            r0.<init>(r10, r15)
        L_0x0018:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.k.b(r15)
            goto L_0x004a
        L_0x0029:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0031:
            kotlin.k.b(r15)
            com.iproov.sdk.do.new r15 = com.iproov.sdk.p009do.Cnew.f489do
            com.iproov.sdk.IProovFlowLauncher$launchSession$2 r2 = new com.iproov.sdk.IProovFlowLauncher$launchSession$2
            r4 = r2
            r5 = r10
            r6 = r11
            r7 = r12
            r8 = r13
            r9 = r14
            r4.<init>(r5, r6, r7, r8, r9)
            r0.label = r3
            java.lang.Object r15 = r15.m573do(r11, r13, r2, r0)
            if (r15 != r1) goto L_0x004a
            return r1
        L_0x004a:
            com.iproov.sdk.do.case r15 = (com.iproov.sdk.p009do.Ccase) r15
            com.iproov.sdk.IProov$Session r11 = com.iproov.sdk.Cdo.m544do((com.iproov.sdk.p009do.Ccase) r15)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.IProovFlowLauncher.launchSession$iproov_release(android.content.Context, java.lang.String, java.lang.String, com.iproov.sdk.return.extends, kotlin.coroutines.c):java.lang.Object");
    }

    public IProovFlowLauncher(Cfor forR) {
        this();
        this.internalOptions = forR;
    }
}
