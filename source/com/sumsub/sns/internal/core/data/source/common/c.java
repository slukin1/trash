package com.sumsub.sns.internal.core.data.source.common;

import com.sumsub.sns.core.data.listener.SNSStateChangedHandler;
import com.sumsub.sns.core.data.model.SNSSDKState;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.data.model.g;
import java.util.Locale;
import java.util.Map;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.k1;

public final class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public final b f33256a;

    /* renamed from: b  reason: collision with root package name */
    public String f33257b;

    /* renamed from: c  reason: collision with root package name */
    public final b1<SNSSDKState> f33258c;

    /* renamed from: d  reason: collision with root package name */
    public final j1<SNSSDKState> f33259d;

    /* renamed from: e  reason: collision with root package name */
    public g f33260e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, ? extends Object> f33261f;

    @d(c = "com.sumsub.sns.internal.core.data.source.common.RealCommonRepository", f = "RealCommonRepository.kt", l = {24}, m = "getActionById")
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33262a;

        /* renamed from: b  reason: collision with root package name */
        public Object f33263b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f33264c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f33265d;

        /* renamed from: e  reason: collision with root package name */
        public int f33266e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(c cVar, kotlin.coroutines.c<? super a> cVar2) {
            super(cVar2);
            this.f33265d = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33264c = obj;
            this.f33266e |= Integer.MIN_VALUE;
            return this.f33265d.a((String) null, false, this);
        }
    }

    @d(c = "com.sumsub.sns.internal.core.data.source.common.RealCommonRepository", f = "RealCommonRepository.kt", l = {50}, m = "getClientIntegrationSettings")
    public static final class b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33267a;

        /* renamed from: b  reason: collision with root package name */
        public Object f33268b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f33269c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f33270d;

        /* renamed from: e  reason: collision with root package name */
        public int f33271e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(c cVar, kotlin.coroutines.c<? super b> cVar2) {
            super(cVar2);
            this.f33270d = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33269c = obj;
            this.f33271e |= Integer.MIN_VALUE;
            return this.f33270d.a((kotlin.coroutines.c<? super Map<String, ? extends Object>>) this);
        }
    }

    public c(b bVar) {
        this.f33256a = bVar;
        b1<SNSSDKState> a11 = k1.a(null);
        this.f33258c = a11;
        this.f33259d = f.b(a11);
    }

    public String a() {
        return this.f33257b;
    }

    /* renamed from: c */
    public j1<SNSSDKState> b() {
        return this.f33259d;
    }

    public void a(String str) {
        this.f33257b = str;
    }

    public Object b(kotlin.coroutines.c<? super SNSSDKState> cVar) {
        SNSSDKState value = this.f33258c.getValue();
        return value == null ? SNSSDKState.Ready.INSTANCE : value;
    }

    public Object c(kotlin.coroutines.c<? super Locale> cVar) {
        return e0.f32018a.getLocale();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(java.lang.String r11, boolean r12, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.sumsub.sns.internal.core.data.source.common.c.a
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.sumsub.sns.internal.core.data.source.common.c$a r0 = (com.sumsub.sns.internal.core.data.source.common.c.a) r0
            int r1 = r0.f33266e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33266e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.common.c$a r0 = new com.sumsub.sns.internal.core.data.source.common.c$a
            r0.<init>(r10, r13)
        L_0x0018:
            java.lang.Object r13 = r0.f33264c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33266e
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r11 = r0.f33263b
            com.sumsub.sns.internal.core.data.source.common.c r11 = (com.sumsub.sns.internal.core.data.source.common.c) r11
            java.lang.Object r12 = r0.f33262a
            com.sumsub.sns.internal.core.data.source.common.c r12 = (com.sumsub.sns.internal.core.data.source.common.c) r12
            kotlin.k.b(r13)
            goto L_0x007b
        L_0x0031:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0039:
            kotlin.k.b(r13)
            com.sumsub.sns.internal.log.a r4 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r5 = com.sumsub.sns.internal.log.c.a(r10)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r2 = "Trying to get an action("
            r13.append(r2)
            r13.append(r11)
            java.lang.String r2 = "). Force flag is "
            r13.append(r2)
            r13.append(r12)
            java.lang.String r6 = r13.toString()
            r7 = 0
            r8 = 4
            r9 = 0
            com.sumsub.log.logger.a.a(r4, r5, r6, r7, r8, r9)
            com.sumsub.sns.internal.core.data.model.g r13 = r10.f33260e
            if (r13 == 0) goto L_0x006a
            if (r12 == 0) goto L_0x0068
            goto L_0x006a
        L_0x0068:
            r12 = r10
            goto L_0x0083
        L_0x006a:
            com.sumsub.sns.internal.core.data.source.common.b r12 = r10.f33256a
            r0.f33262a = r10
            r0.f33263b = r10
            r0.f33266e = r3
            java.lang.Object r13 = r12.a((java.lang.String) r11, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0351d>) r0)
            if (r13 != r1) goto L_0x0079
            return r1
        L_0x0079:
            r11 = r10
            r12 = r11
        L_0x007b:
            com.sumsub.sns.internal.core.data.model.remote.response.d$c$d r13 = (com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0351d) r13
            com.sumsub.sns.internal.core.data.model.g r13 = com.sumsub.sns.internal.core.data.model.remote.response.e.b(r13)
            r11.f33260e = r13
        L_0x0083:
            com.sumsub.sns.internal.core.data.model.g r11 = r12.f33260e
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.common.c.a(java.lang.String, boolean, kotlin.coroutines.c):java.lang.Object");
    }

    public void a(SNSSDKState sNSSDKState) {
        SNSSDKState value = this.f33258c.getValue();
        if (!x.b(value, sNSSDKState)) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            String a11 = com.sumsub.sns.internal.log.c.a(this);
            com.sumsub.log.logger.a.a(aVar, a11, "The SDK state was changed: " + value + " -> " + sNSSDKState, (Throwable) null, 4, (Object) null);
            if (value != null) {
                try {
                    SNSStateChangedHandler stateChangedHandler = e0.f32018a.getStateChangedHandler();
                    if (stateChangedHandler != null) {
                        stateChangedHandler.onStateChanged(value, sNSSDKState);
                    }
                } catch (Exception e11) {
                    com.sumsub.sns.internal.log.a aVar2 = com.sumsub.sns.internal.log.a.f34862a;
                    String a12 = com.sumsub.sns.internal.log.c.a(this);
                    String message = e11.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    aVar2.e(a12, message, e11);
                }
            }
            e0.f32018a.a(sNSSDKState);
            this.f33258c.setValue(sNSSDKState);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(kotlin.coroutines.c<? super java.util.Map<java.lang.String, ? extends java.lang.Object>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.sumsub.sns.internal.core.data.source.common.c.b
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.sumsub.sns.internal.core.data.source.common.c$b r0 = (com.sumsub.sns.internal.core.data.source.common.c.b) r0
            int r1 = r0.f33271e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33271e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.common.c$b r0 = new com.sumsub.sns.internal.core.data.source.common.c$b
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f33269c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33271e
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r1 = r0.f33268b
            com.sumsub.sns.internal.core.data.source.common.c r1 = (com.sumsub.sns.internal.core.data.source.common.c) r1
            java.lang.Object r0 = r0.f33267a
            com.sumsub.sns.internal.core.data.source.common.c r0 = (com.sumsub.sns.internal.core.data.source.common.c) r0
            kotlin.k.b(r5)
            goto L_0x0051
        L_0x0031:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0039:
            kotlin.k.b(r5)
            java.util.Map<java.lang.String, ? extends java.lang.Object> r5 = r4.f33261f
            if (r5 != 0) goto L_0x0056
            com.sumsub.sns.internal.core.data.source.common.b r5 = r4.f33256a
            r0.f33267a = r4
            r0.f33268b = r4
            r0.f33271e = r3
            java.lang.Object r5 = r5.a(r0)
            if (r5 != r1) goto L_0x004f
            return r1
        L_0x004f:
            r0 = r4
            r1 = r0
        L_0x0051:
            java.util.Map r5 = (java.util.Map) r5
            r1.f33261f = r5
            goto L_0x0057
        L_0x0056:
            r0 = r4
        L_0x0057:
            java.util.Map<java.lang.String, ? extends java.lang.Object> r5 = r0.f33261f
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.common.c.a(kotlin.coroutines.c):java.lang.Object");
    }
}
