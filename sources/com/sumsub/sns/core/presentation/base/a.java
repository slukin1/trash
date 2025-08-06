package com.sumsub.sns.core.presentation.base;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.m0;
import com.sumsub.log.logger.Logger;
import com.sumsub.sns.core.data.model.SNSCompletionResult;
import com.sumsub.sns.core.data.model.SNSException;
import com.sumsub.sns.core.data.model.SNSSDKState;
import com.sumsub.sns.core.presentation.base.a.l;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.o;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import com.sumsub.sns.internal.log.LoggerType;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.flow.FlowKt__ShareKt;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.f1;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.k1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;
import kotlinx.coroutines.v1;

public abstract class a<T extends l> extends ViewModel {

    /* renamed from: o  reason: collision with root package name */
    public static final c f30779o = new c((kotlin.jvm.internal.r) null);
    @Deprecated

    /* renamed from: p  reason: collision with root package name */
    public static final long f30780p = 25000;

    /* renamed from: a  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.common.a f30781a;

    /* renamed from: b  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.dynamic.b f30782b;

    /* renamed from: c  reason: collision with root package name */
    public Boolean f30783c;

    /* renamed from: d  reason: collision with root package name */
    public final kotlinx.coroutines.channels.d<j> f30784d;

    /* renamed from: e  reason: collision with root package name */
    public final kotlinx.coroutines.flow.d<j> f30785e;

    /* renamed from: f  reason: collision with root package name */
    public final kotlinx.coroutines.channels.d<d10.p<T, kotlin.coroutines.c<? super T>, Object>> f30786f = kotlinx.coroutines.channels.f.b(Integer.MAX_VALUE, (BufferOverflow) null, (d10.l) null, 6, (Object) null);

    /* renamed from: g  reason: collision with root package name */
    public final a1<T> f30787g;

    /* renamed from: h  reason: collision with root package name */
    public final f1<T> f30788h;

    /* renamed from: i  reason: collision with root package name */
    public final b1<k> f30789i;

    /* renamed from: j  reason: collision with root package name */
    public final j1<k> f30790j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f30791k;

    /* renamed from: l  reason: collision with root package name */
    public b.c f30792l;

    /* renamed from: m  reason: collision with root package name */
    public final kotlinx.coroutines.d0 f30793m;

    /* renamed from: n  reason: collision with root package name */
    public com.sumsub.sns.internal.core.data.model.e f30794n;

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.base.SNSViewModel$1", f = "SNSViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.sumsub.sns.core.presentation.base.a$a  reason: collision with other inner class name */
    public static final class C0281a extends SuspendLambda implements d10.p<b.a, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f30795a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f30796b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a<T> f30797c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0281a(a<T> aVar, kotlin.coroutines.c<? super C0281a> cVar) {
            super(2, cVar);
            this.f30797c = aVar;
        }

        /* renamed from: a */
        public final Object invoke(b.a aVar, kotlin.coroutines.c<? super Unit> cVar) {
            return ((C0281a) create(aVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            C0281a aVar = new C0281a(this.f30797c, cVar);
            aVar.f30796b = obj;
            return aVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
            r2 = r2.i();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r2) {
            /*
                r1 = this;
                java.lang.Object unused = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r0 = r1.f30795a
                if (r0 != 0) goto L_0x0026
                kotlin.k.b(r2)
                java.lang.Object r2 = r1.f30796b
                com.sumsub.sns.internal.core.data.source.dynamic.b$a r2 = (com.sumsub.sns.internal.core.data.source.dynamic.b.a) r2
                com.sumsub.sns.core.presentation.base.a<T> r0 = r1.f30797c
                if (r2 == 0) goto L_0x001f
                com.sumsub.sns.internal.core.data.source.dynamic.e r2 = r2.i()
                if (r2 == 0) goto L_0x001f
                java.lang.Object r2 = r2.d()
                com.sumsub.sns.internal.core.data.model.e r2 = (com.sumsub.sns.internal.core.data.model.e) r2
                goto L_0x0020
            L_0x001f:
                r2 = 0
            L_0x0020:
                r0.f30794n = r2
                kotlin.Unit r2 = kotlin.Unit.f56620a
                return r2
            L_0x0026:
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r2.<init>(r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.base.a.C0281a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.base.SNSViewModel$launchOnViewModelScope$1", f = "SNSViewModel.kt", l = {380}, m = "invokeSuspend")
    public static final class a0 extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f30798a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f30799b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> f30800c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a<T> f30801d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f30802e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a0(d10.p<? super h0, ? super kotlin.coroutines.c<? super Unit>, ? extends Object> pVar, a<T> aVar, String str, kotlin.coroutines.c<? super a0> cVar) {
            super(2, cVar);
            this.f30800c = pVar;
            this.f30801d = aVar;
            this.f30802e = str;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((a0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            a0 a0Var = new a0(this.f30800c, this.f30801d, this.f30802e, cVar);
            a0Var.f30799b = obj;
            return a0Var;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r7.f30801d, (java.lang.Throwable) r8, r7.f30802e, (java.lang.Object) null, 4, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x003c, code lost:
            r0 = r8;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:4:0x000f, B:9:0x0022] */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x002f A[ExcHandler: Exception (r8v2 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:4:0x000f] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r7.f30798a
                r2 = 1
                if (r1 == 0) goto L_0x001b
                if (r1 != r2) goto L_0x0013
                java.lang.Object r0 = r7.f30799b
                kotlinx.coroutines.h0 r0 = (kotlinx.coroutines.h0) r0
                kotlin.k.b(r8)     // Catch:{ CancellationException -> 0x003d, Exception -> 0x002f }
                goto L_0x004b
            L_0x0013:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x001b:
                kotlin.k.b(r8)
                java.lang.Object r8 = r7.f30799b
                kotlinx.coroutines.h0 r8 = (kotlinx.coroutines.h0) r8
                d10.p<kotlinx.coroutines.h0, kotlin.coroutines.c<? super kotlin.Unit>, java.lang.Object> r1 = r7.f30800c     // Catch:{ CancellationException -> 0x003c, Exception -> 0x002f }
                r7.f30799b = r8     // Catch:{ CancellationException -> 0x003c, Exception -> 0x002f }
                r7.f30798a = r2     // Catch:{ CancellationException -> 0x003c, Exception -> 0x002f }
                java.lang.Object r8 = r1.invoke(r8, r7)     // Catch:{ CancellationException -> 0x003c, Exception -> 0x002f }
                if (r8 != r0) goto L_0x004b
                return r0
            L_0x002f:
                r8 = move-exception
                r1 = r8
                com.sumsub.sns.core.presentation.base.a<T> r0 = r7.f30801d
                java.lang.String r2 = r7.f30802e
                r3 = 0
                r4 = 4
                r5 = 0
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r0, (java.lang.Throwable) r1, (java.lang.String) r2, (java.lang.Object) r3, (int) r4, (java.lang.Object) r5)
                goto L_0x004b
            L_0x003c:
                r0 = r8
            L_0x003d:
                com.sumsub.sns.internal.log.a r1 = com.sumsub.sns.internal.log.a.f34862a
                java.lang.String r2 = com.sumsub.sns.internal.log.c.a(r0)
                r4 = 0
                r5 = 4
                r6 = 0
                java.lang.String r3 = "CancellationException happened"
                com.sumsub.log.logger.a.a(r1, r2, r3, r4, r5, r6)
            L_0x004b:
                kotlin.Unit r8 = kotlin.Unit.f56620a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.base.a.a0.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object a(Object obj) {
            h0 h0Var = (h0) this.f30799b;
            try {
                this.f30800c.invoke(h0Var, this);
            } catch (CancellationException unused) {
                com.sumsub.log.logger.a.a(com.sumsub.sns.internal.log.a.f34862a, com.sumsub.sns.internal.log.c.a(h0Var), "CancellationException happened", (Throwable) null, 4, (Object) null);
            } catch (Exception e11) {
                a.a((a) this.f30801d, (Throwable) e11, this.f30802e, (Object) null, 4, (Object) null);
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.base.SNSViewModel$2", f = "SNSViewModel.kt", l = {136, 137, 141, 142}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f30803a;

        /* renamed from: b  reason: collision with root package name */
        public Object f30804b;

        /* renamed from: c  reason: collision with root package name */
        public int f30805c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a<T> f30806d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a<T> aVar, kotlin.coroutines.c<? super b> cVar) {
            super(2, cVar);
            this.f30806d = aVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((b) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new b(this.f30806d, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0065 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0073  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0093  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00d1 A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r11.f30805c
                r2 = 0
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 1
                if (r1 == 0) goto L_0x004b
                if (r1 == r6) goto L_0x0040
                if (r1 == r5) goto L_0x0031
                if (r1 == r4) goto L_0x0025
                if (r1 != r3) goto L_0x001d
                java.lang.Object r1 = r11.f30803a
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                kotlin.k.b(r12)
                goto L_0x0058
            L_0x001d:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L_0x0025:
                java.lang.Object r1 = r11.f30803a
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                kotlin.k.b(r12)
                r7 = r1
                r1 = r0
                r0 = r11
                goto L_0x00bf
            L_0x0031:
                java.lang.Object r1 = r11.f30804b
                d10.p r1 = (d10.p) r1
                java.lang.Object r7 = r11.f30803a
                kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
                kotlin.k.b(r12)
                r8 = r1
                r1 = r0
                r0 = r11
                goto L_0x008b
            L_0x0040:
                java.lang.Object r1 = r11.f30803a
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                kotlin.k.b(r12)
                r7 = r1
                r1 = r0
                r0 = r11
                goto L_0x006b
            L_0x004b:
                kotlin.k.b(r12)
                com.sumsub.sns.core.presentation.base.a<T> r12 = r11.f30806d
                kotlinx.coroutines.channels.d r12 = r12.f30786f
                kotlinx.coroutines.channels.ChannelIterator r1 = r12.iterator()
            L_0x0058:
                r12 = r11
            L_0x0059:
                r12.f30803a = r1
                r12.f30804b = r2
                r12.f30805c = r6
                java.lang.Object r7 = r1.a(r12)
                if (r7 != r0) goto L_0x0066
                return r0
            L_0x0066:
                r10 = r0
                r0 = r12
                r12 = r7
                r7 = r1
                r1 = r10
            L_0x006b:
                java.lang.Boolean r12 = (java.lang.Boolean) r12
                boolean r12 = r12.booleanValue()
                if (r12 == 0) goto L_0x00d6
                java.lang.Object r12 = r7.next()
                d10.p r12 = (d10.p) r12
                com.sumsub.sns.core.presentation.base.a<T> r8 = r0.f30806d
                r0.f30803a = r7
                r0.f30804b = r12
                r0.f30805c = r5
                java.lang.Object r8 = r8.a((kotlin.coroutines.c<? super java.lang.Boolean>) r0)
                if (r8 != r1) goto L_0x0088
                return r1
            L_0x0088:
                r10 = r8
                r8 = r12
                r12 = r10
            L_0x008b:
                java.lang.Boolean r12 = (java.lang.Boolean) r12
                boolean r12 = r12.booleanValue()
                if (r12 == 0) goto L_0x00d2
                com.sumsub.sns.core.presentation.base.a<T> r12 = r0.f30806d
                kotlinx.coroutines.flow.a1 r12 = r12.f30787g
                java.util.List r12 = r12.a()
                java.lang.Object r12 = kotlin.collections.CollectionsKt___CollectionsKt.c0(r12)
                com.sumsub.sns.core.presentation.base.a$l r12 = (com.sumsub.sns.core.presentation.base.a.l) r12
                if (r12 != 0) goto L_0x00ab
                com.sumsub.sns.core.presentation.base.a<T> r12 = r0.f30806d
                com.sumsub.sns.core.presentation.base.a$l r12 = r12.e()
            L_0x00ab:
                com.sumsub.sns.core.presentation.base.a<T> r9 = r0.f30806d
                r9.a(r12)
                if (r12 == 0) goto L_0x00d2
                r0.f30803a = r7
                r0.f30804b = r2
                r0.f30805c = r4
                java.lang.Object r12 = r8.invoke(r12, r0)
                if (r12 != r1) goto L_0x00bf
                return r1
            L_0x00bf:
                com.sumsub.sns.core.presentation.base.a$l r12 = (com.sumsub.sns.core.presentation.base.a.l) r12
                com.sumsub.sns.core.presentation.base.a<T> r8 = r0.f30806d
                kotlinx.coroutines.flow.a1 r8 = r8.f30787g
                r0.f30803a = r7
                r0.f30805c = r3
                java.lang.Object r12 = r8.emit(r12, r0)
                if (r12 != r1) goto L_0x00d2
                return r1
            L_0x00d2:
                r12 = r0
                r0 = r1
                r1 = r7
                goto L_0x0059
            L_0x00d6:
                kotlin.Unit r12 = kotlin.Unit.f56620a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.base.a.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.base.SNSViewModel$prepare$1", f = "SNSViewModel.kt", l = {167, 174, 185, 197, 204}, m = "invokeSuspend")
    public static final class b0 extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f30807a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a<T> f30808b;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.base.SNSViewModel$prepare$1$1", f = "SNSViewModel.kt", l = {168}, m = "invokeSuspend")
        /* renamed from: com.sumsub.sns.core.presentation.base.a$b0$a  reason: collision with other inner class name */
        public static final class C0282a extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super SNSSDKState>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f30809a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ Object f30810b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a<T> f30811c;

            @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.base.SNSViewModel$prepare$1$1$1", f = "SNSViewModel.kt", l = {}, m = "invokeSuspend")
            /* renamed from: com.sumsub.sns.core.presentation.base.a$b0$a$a  reason: collision with other inner class name */
            public static final class C0283a extends SuspendLambda implements d10.p<SNSSDKState, kotlin.coroutines.c<? super Boolean>, Object> {

                /* renamed from: a  reason: collision with root package name */
                public int f30812a;

                /* renamed from: b  reason: collision with root package name */
                public /* synthetic */ Object f30813b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ h0 f30814c;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0283a(h0 h0Var, kotlin.coroutines.c<? super C0283a> cVar) {
                    super(2, cVar);
                    this.f30814c = h0Var;
                }

                /* renamed from: a */
                public final Object invoke(SNSSDKState sNSSDKState, kotlin.coroutines.c<? super Boolean> cVar) {
                    return ((C0283a) create(sNSSDKState, cVar)).invokeSuspend(Unit.f56620a);
                }

                public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                    C0283a aVar = new C0283a(this.f30814c, cVar);
                    aVar.f30813b = obj;
                    return aVar;
                }

                public final Object invokeSuspend(Object obj) {
                    Object unused = IntrinsicsKt__IntrinsicsKt.d();
                    if (this.f30812a == 0) {
                        kotlin.k.b(obj);
                        SNSSDKState sNSSDKState = (SNSSDKState) this.f30813b;
                        com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
                        String a11 = com.sumsub.sns.internal.log.c.a(this.f30814c);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("sdkState: ");
                        sb2.append(sNSSDKState);
                        sb2.append(", ");
                        sb2.append(sNSSDKState != null ? sNSSDKState.getMessage() : null);
                        com.sumsub.sns.core.c.b(cVar, a11, sb2.toString(), (Throwable) null, 4, (Object) null);
                        return kotlin.coroutines.jvm.internal.a.a(sNSSDKState != null);
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0282a(a<T> aVar, kotlin.coroutines.c<? super C0282a> cVar) {
                super(2, cVar);
                this.f30811c = aVar;
            }

            /* renamed from: a */
            public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super SNSSDKState> cVar) {
                return ((C0282a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                C0282a aVar = new C0282a(this.f30811c, cVar);
                aVar.f30810b = obj;
                return aVar;
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f30809a;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    kotlinx.coroutines.flow.d<SNSSDKState> b11 = this.f30811c.f30781a.b();
                    C0283a aVar = new C0283a((h0) this.f30810b, (kotlin.coroutines.c<? super C0283a>) null);
                    this.f30809a = 1;
                    obj = kotlinx.coroutines.flow.f.z(b11, aVar, this);
                    if (obj == d11) {
                        return d11;
                    }
                } else if (i11 == 1) {
                    kotlin.k.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return obj;
            }
        }

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.base.SNSViewModel$prepare$1$2", f = "SNSViewModel.kt", l = {176, 180, 181}, m = "invokeSuspend")
        public static final class b extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public Object f30815a;

            /* renamed from: b  reason: collision with root package name */
            public int f30816b;

            /* renamed from: c  reason: collision with root package name */
            public /* synthetic */ Object f30817c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ a<T> f30818d;

            @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.base.SNSViewModel$prepare$1$2$configRequest$1", f = "SNSViewModel.kt", l = {179}, m = "invokeSuspend")
            /* renamed from: com.sumsub.sns.core.presentation.base.a$b0$b$a  reason: collision with other inner class name */
            public static final class C0284a extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.e>, Object> {

                /* renamed from: a  reason: collision with root package name */
                public int f30819a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a<T> f30820b;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0284a(a<T> aVar, kotlin.coroutines.c<? super C0284a> cVar) {
                    super(2, cVar);
                    this.f30820b = aVar;
                }

                /* renamed from: a */
                public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.e> cVar) {
                    return ((C0284a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
                }

                public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                    return new C0284a(this.f30820b, cVar);
                }

                public final Object invokeSuspend(Object obj) {
                    Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                    int i11 = this.f30819a;
                    if (i11 == 0) {
                        kotlin.k.b(obj);
                        com.sumsub.sns.internal.core.data.source.dynamic.b b11 = this.f30820b.f30782b;
                        this.f30819a = 1;
                        obj = com.sumsub.sns.internal.core.data.source.dynamic.h.b(b11, false, this, 1, (Object) null);
                        if (obj == d11) {
                            return d11;
                        }
                    } else if (i11 == 1) {
                        kotlin.k.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return obj;
                }
            }

            @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.base.SNSViewModel$prepare$1$2$stringsRequest$1", f = "SNSViewModel.kt", l = {178}, m = "invokeSuspend")
            /* renamed from: com.sumsub.sns.core.presentation.base.a$b0$b$b  reason: collision with other inner class name */
            public static final class C0285b extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super b.c>, Object> {

                /* renamed from: a  reason: collision with root package name */
                public int f30821a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a<T> f30822b;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0285b(a<T> aVar, kotlin.coroutines.c<? super C0285b> cVar) {
                    super(2, cVar);
                    this.f30822b = aVar;
                }

                /* renamed from: a */
                public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super b.c> cVar) {
                    return ((C0285b) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
                }

                public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                    return new C0285b(this.f30822b, cVar);
                }

                public final Object invokeSuspend(Object obj) {
                    Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                    int i11 = this.f30821a;
                    if (i11 == 0) {
                        kotlin.k.b(obj);
                        com.sumsub.sns.internal.core.data.source.dynamic.b b11 = this.f30822b.f30782b;
                        this.f30821a = 1;
                        obj = b11.d(this);
                        if (obj == d11) {
                            return d11;
                        }
                    } else if (i11 == 1) {
                        kotlin.k.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return obj;
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(a<T> aVar, kotlin.coroutines.c<? super b> cVar) {
                super(2, cVar);
                this.f30818d = aVar;
            }

            /* renamed from: a */
            public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
                return ((b) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                b bVar = new b(this.f30818d, cVar);
                bVar.f30817c = obj;
                return bVar;
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v11, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: kotlinx.coroutines.h0} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Removed duplicated region for block: B:19:0x008f A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x0090  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r13) {
                /*
                    r12 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r1 = r12.f30816b
                    r2 = 3
                    r3 = 2
                    r4 = 1
                    r5 = 0
                    if (r1 == 0) goto L_0x0037
                    if (r1 == r4) goto L_0x002f
                    if (r1 == r3) goto L_0x0023
                    if (r1 != r2) goto L_0x001b
                    java.lang.Object r0 = r12.f30817c
                    com.sumsub.sns.core.presentation.base.a r0 = (com.sumsub.sns.core.presentation.base.a) r0
                    kotlin.k.b(r13)
                    goto L_0x0092
                L_0x001b:
                    java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r13.<init>(r0)
                    throw r13
                L_0x0023:
                    java.lang.Object r1 = r12.f30815a
                    com.sumsub.sns.core.presentation.base.a r1 = (com.sumsub.sns.core.presentation.base.a) r1
                    java.lang.Object r3 = r12.f30817c
                    kotlinx.coroutines.n0 r3 = (kotlinx.coroutines.n0) r3
                    kotlin.k.b(r13)
                    goto L_0x007c
                L_0x002f:
                    java.lang.Object r1 = r12.f30817c
                    kotlinx.coroutines.h0 r1 = (kotlinx.coroutines.h0) r1
                    kotlin.k.b(r13)
                    goto L_0x0050
                L_0x0037:
                    kotlin.k.b(r13)
                    java.lang.Object r13 = r12.f30817c
                    r1 = r13
                    kotlinx.coroutines.h0 r1 = (kotlinx.coroutines.h0) r1
                    com.sumsub.sns.core.presentation.base.a<T> r13 = r12.f30818d
                    com.sumsub.sns.internal.core.data.source.dynamic.b r13 = r13.f30782b
                    r12.f30817c = r1
                    r12.f30816b = r4
                    java.lang.Object r13 = r13.b(r12)
                    if (r13 != r0) goto L_0x0050
                    return r0
                L_0x0050:
                    com.sumsub.sns.core.presentation.base.a$b0$b$b r9 = new com.sumsub.sns.core.presentation.base.a$b0$b$b
                    com.sumsub.sns.core.presentation.base.a<T> r13 = r12.f30818d
                    r9.<init>(r13, r5)
                    r7 = 0
                    r8 = 0
                    r10 = 3
                    r11 = 0
                    r6 = r1
                    kotlinx.coroutines.n0 r13 = kotlinx.coroutines.i.b(r6, r7, r8, r9, r10, r11)
                    com.sumsub.sns.core.presentation.base.a$b0$b$a r9 = new com.sumsub.sns.core.presentation.base.a$b0$b$a
                    com.sumsub.sns.core.presentation.base.a<T> r4 = r12.f30818d
                    r9.<init>(r4, r5)
                    kotlinx.coroutines.n0 r1 = kotlinx.coroutines.i.b(r6, r7, r8, r9, r10, r11)
                    com.sumsub.sns.core.presentation.base.a<T> r4 = r12.f30818d
                    r12.f30817c = r1
                    r12.f30815a = r4
                    r12.f30816b = r3
                    java.lang.Object r13 = r13.j(r12)
                    if (r13 != r0) goto L_0x007a
                    return r0
                L_0x007a:
                    r3 = r1
                    r1 = r4
                L_0x007c:
                    com.sumsub.sns.internal.core.data.source.dynamic.b$c r13 = (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r13
                    r1.f30792l = r13
                    com.sumsub.sns.core.presentation.base.a<T> r13 = r12.f30818d
                    r12.f30817c = r13
                    r12.f30815a = r5
                    r12.f30816b = r2
                    java.lang.Object r1 = r3.j(r12)
                    if (r1 != r0) goto L_0x0090
                    return r0
                L_0x0090:
                    r0 = r13
                    r13 = r1
                L_0x0092:
                    com.sumsub.sns.internal.core.data.model.e r13 = (com.sumsub.sns.internal.core.data.model.e) r13
                    r0.f30794n = r13
                    kotlin.Unit r13 = kotlin.Unit.f56620a
                    return r13
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.base.a.b0.b.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        public static final class c extends Lambda implements d10.l<k, k> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a<T> f30823a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(a<T> aVar) {
                super(1);
                this.f30823a = aVar;
            }

            /* renamed from: a */
            public final k invoke(k kVar) {
                return k.a(kVar, false, true, false, this.f30823a.h().a("sns_general_poweredBy"), this.f30823a.h().a("sns_general_progress_text"), 5, (Object) null);
            }
        }

        public static final class d extends Lambda implements d10.l<k, k> {

            /* renamed from: a  reason: collision with root package name */
            public static final d f30824a = new d();

            public d() {
                super(1);
            }

            /* renamed from: a */
            public final k invoke(k kVar) {
                return k.a(kVar, false, false, true, (CharSequence) null, (CharSequence) null, 27, (Object) null);
            }
        }

        public static final class e extends Lambda implements d10.l<k, k> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ boolean f30825a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public e(boolean z11) {
                super(1);
                this.f30825a = z11;
            }

            /* renamed from: a */
            public final k invoke(k kVar) {
                return k.a(kVar, this.f30825a, false, false, (CharSequence) null, (CharSequence) null, 30, (Object) null);
            }
        }

        public static final class f extends Lambda implements d10.l<k, k> {

            /* renamed from: a  reason: collision with root package name */
            public static final f f30826a = new f();

            public f() {
                super(1);
            }

            /* renamed from: a */
            public final k invoke(k kVar) {
                return k.a(kVar, false, false, false, (CharSequence) null, (CharSequence) null, 30, (Object) null);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b0(a<T> aVar, kotlin.coroutines.c<? super b0> cVar) {
            super(2, cVar);
            this.f30808b = aVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((b0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new b0(this.f30808b, cVar);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.lang.Boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v14, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.Boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.Boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.lang.Boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Boolean} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0099 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00b4 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00de A[Catch:{ Exception -> 0x019d }, RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00e4 A[Catch:{ Exception -> 0x019d }] */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x0166 A[Catch:{ Exception -> 0x019d }] */
        /* JADX WARNING: Removed duplicated region for block: B:88:0x0139 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(T r15) {
            /*
                r14 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r14.f30807a
                r2 = 5
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 1
                r7 = 0
                if (r1 == 0) goto L_0x0036
                if (r1 == r6) goto L_0x0032
                if (r1 == r5) goto L_0x002e
                if (r1 == r4) goto L_0x002a
                if (r1 == r3) goto L_0x0025
                if (r1 != r2) goto L_0x001d
                kotlin.k.b(r15)     // Catch:{ Exception -> 0x019d }
                goto L_0x00df
            L_0x001d:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L_0x0025:
                kotlin.k.b(r15)
                goto L_0x00b5
            L_0x002a:
                kotlin.k.b(r15)
                goto L_0x009a
            L_0x002e:
                kotlin.k.b(r15)
                goto L_0x0073
            L_0x0032:
                kotlin.k.b(r15)
                goto L_0x005b
            L_0x0036:
                kotlin.k.b(r15)
                com.sumsub.sns.core.c r8 = com.sumsub.sns.core.c.f30748a
                com.sumsub.sns.core.presentation.base.a<T> r15 = r14.f30808b
                java.lang.String r9 = com.sumsub.sns.internal.log.c.a(r15)
                r11 = 0
                r12 = 4
                r13 = 0
                java.lang.String r10 = "Lifecycle: Preparing view model"
                com.sumsub.sns.core.c.b(r8, r9, r10, r11, r12, r13)
                com.sumsub.sns.core.presentation.base.a$b0$a r15 = new com.sumsub.sns.core.presentation.base.a$b0$a
                com.sumsub.sns.core.presentation.base.a<T> r1 = r14.f30808b
                r15.<init>(r1, r7)
                r14.f30807a = r6
                r8 = 25000(0x61a8, double:1.23516E-319)
                java.lang.Object r15 = kotlinx.coroutines.TimeoutKt.d(r8, r15, r14)
                if (r15 != r0) goto L_0x005b
                return r0
            L_0x005b:
                com.sumsub.sns.core.data.model.SNSSDKState r15 = (com.sumsub.sns.core.data.model.SNSSDKState) r15
                if (r15 == 0) goto L_0x01ab
                kotlinx.coroutines.CoroutineDispatcher r15 = kotlinx.coroutines.v0.b()
                com.sumsub.sns.core.presentation.base.a$b0$b r1 = new com.sumsub.sns.core.presentation.base.a$b0$b
                com.sumsub.sns.core.presentation.base.a<T> r8 = r14.f30808b
                r1.<init>(r8, r7)
                r14.f30807a = r5
                java.lang.Object r15 = kotlinx.coroutines.g.g(r15, r1, r14)
                if (r15 != r0) goto L_0x0073
                return r0
            L_0x0073:
                com.sumsub.sns.core.presentation.base.a<T> r15 = r14.f30808b
                kotlinx.coroutines.flow.a1 r15 = r15.f30787g
                java.util.List r15 = r15.a()
                java.lang.Object r15 = kotlin.collections.CollectionsKt___CollectionsKt.c0(r15)
                if (r15 != 0) goto L_0x009a
                com.sumsub.sns.core.presentation.base.a<T> r15 = r14.f30808b
                com.sumsub.sns.core.presentation.base.a$l r15 = r15.e()
                if (r15 == 0) goto L_0x009a
                com.sumsub.sns.core.presentation.base.a<T> r1 = r14.f30808b
                kotlinx.coroutines.flow.a1 r1 = r1.f30787g
                r14.f30807a = r4
                java.lang.Object r15 = r1.emit(r15, r14)
                if (r15 != r0) goto L_0x009a
                return r0
            L_0x009a:
                com.sumsub.sns.core.presentation.base.a<T> r15 = r14.f30808b
                kotlinx.coroutines.flow.b1 r15 = r15.f30789i
                com.sumsub.sns.core.presentation.base.a$b0$c r1 = new com.sumsub.sns.core.presentation.base.a$b0$c
                com.sumsub.sns.core.presentation.base.a<T> r4 = r14.f30808b
                r1.<init>(r4)
                com.sumsub.sns.internal.core.common.b0.a(r15, r1)
                com.sumsub.sns.core.presentation.base.a<T> r15 = r14.f30808b
                r14.f30807a = r3
                java.lang.Object r15 = r15.d((kotlin.coroutines.c<? super kotlin.Unit>) r14)
                if (r15 != r0) goto L_0x00b5
                return r0
            L_0x00b5:
                com.sumsub.sns.core.presentation.base.a<T> r15 = r14.f30808b
                kotlinx.coroutines.flow.b1 r15 = r15.f30789i
                com.sumsub.sns.core.presentation.base.a$b0$d r1 = com.sumsub.sns.core.presentation.base.a.b0.d.f30824a
                com.sumsub.sns.internal.core.common.b0.a(r15, r1)
                com.sumsub.sns.core.c r8 = com.sumsub.sns.core.c.f30748a
                com.sumsub.sns.core.presentation.base.a<T> r15 = r14.f30808b
                java.lang.String r9 = com.sumsub.sns.internal.log.c.a(r15)
                r11 = 0
                r12 = 4
                r13 = 0
                java.lang.String r10 = "Lifecycle: ViewModel prepared"
                com.sumsub.sns.core.c.b(r8, r9, r10, r11, r12, r13)
                com.sumsub.sns.core.presentation.base.a<T> r15 = r14.f30808b     // Catch:{ Exception -> 0x019d }
                com.sumsub.sns.internal.core.data.source.common.a r15 = r15.f30781a     // Catch:{ Exception -> 0x019d }
                r14.f30807a = r2     // Catch:{ Exception -> 0x019d }
                java.lang.Object r15 = r15.a((kotlin.coroutines.c<? super java.util.Map<java.lang.String, ? extends java.lang.Object>>) r14)     // Catch:{ Exception -> 0x019d }
                if (r15 != r0) goto L_0x00df
                return r0
            L_0x00df:
                java.util.Map r15 = (java.util.Map) r15     // Catch:{ Exception -> 0x019d }
                r0 = 0
                if (r15 == 0) goto L_0x018e
                java.lang.String r8 = "minimalisticUi"
                r1 = 47
                char[] r9 = new char[r6]     // Catch:{ Exception -> 0x019d }
                char r1 = (char) r1     // Catch:{ Exception -> 0x019d }
                r9[r0] = r1     // Catch:{ Exception -> 0x019d }
                r10 = 0
                r11 = 0
                r12 = 6
                r13 = 0
                java.util.List r1 = kotlin.text.StringsKt__StringsKt.K0(r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x019d }
                kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ Exception -> 0x019d }
                r2.<init>()     // Catch:{ Exception -> 0x019d }
                r2.element = r15     // Catch:{ Exception -> 0x019d }
                int r15 = r1.size()     // Catch:{ Exception -> 0x019d }
                int r15 = r15 - r6
                kotlin.ranges.h r15 = kotlin.ranges.RangesKt___RangesKt.o(r0, r15)     // Catch:{ Exception -> 0x019d }
                java.util.Iterator r15 = r15.iterator()     // Catch:{ Exception -> 0x019d }
            L_0x0109:
                boolean r3 = r15.hasNext()     // Catch:{ Exception -> 0x019d }
                if (r3 == 0) goto L_0x0174
                r3 = r15
                kotlin.collections.IntIterator r3 = (kotlin.collections.IntIterator) r3     // Catch:{ Exception -> 0x019d }
                int r3 = r3.a()     // Catch:{ Exception -> 0x019d }
                T r4 = r2.element     // Catch:{ Exception -> 0x019d }
                java.util.Map r4 = (java.util.Map) r4     // Catch:{ Exception -> 0x019d }
                java.lang.Object r3 = r1.get(r3)     // Catch:{ Exception -> 0x019d }
                java.lang.Object r3 = r4.get(r3)     // Catch:{ Exception -> 0x019d }
                boolean r4 = r3 instanceof java.util.Map     // Catch:{ Exception -> 0x019d }
                if (r4 == 0) goto L_0x0129
                java.util.Map r3 = (java.util.Map) r3     // Catch:{ Exception -> 0x019d }
                goto L_0x012a
            L_0x0129:
                r3 = r7
            L_0x012a:
                if (r3 == 0) goto L_0x0188
                java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x019d }
                r4.<init>()     // Catch:{ Exception -> 0x019d }
                java.util.Set r3 = r3.entrySet()     // Catch:{ Exception -> 0x019d }
                java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x019d }
            L_0x0139:
                boolean r5 = r3.hasNext()     // Catch:{ Exception -> 0x019d }
                if (r5 == 0) goto L_0x016a
                java.lang.Object r5 = r3.next()     // Catch:{ Exception -> 0x019d }
                java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ Exception -> 0x019d }
                java.lang.Object r6 = r5.getKey()     // Catch:{ Exception -> 0x019d }
                boolean r8 = r6 instanceof java.lang.String     // Catch:{ Exception -> 0x019d }
                if (r8 != 0) goto L_0x014e
                r6 = r7
            L_0x014e:
                java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x019d }
                if (r6 != 0) goto L_0x0153
                goto L_0x015e
            L_0x0153:
                java.lang.Object r5 = r5.getValue()     // Catch:{ Exception -> 0x019d }
                boolean r8 = r5 instanceof java.lang.Object     // Catch:{ Exception -> 0x019d }
                if (r8 != 0) goto L_0x015c
                r5 = r7
            L_0x015c:
                if (r5 != 0) goto L_0x0160
            L_0x015e:
                r5 = r7
                goto L_0x0164
            L_0x0160:
                kotlin.Pair r5 = kotlin.l.a(r6, r5)     // Catch:{ Exception -> 0x019d }
            L_0x0164:
                if (r5 == 0) goto L_0x0139
                r4.add(r5)     // Catch:{ Exception -> 0x019d }
                goto L_0x0139
            L_0x016a:
                java.util.Map r3 = kotlin.collections.MapsKt__MapsKt.s(r4)     // Catch:{ Exception -> 0x019d }
                if (r3 != 0) goto L_0x0171
                goto L_0x0188
            L_0x0171:
                r2.element = r3     // Catch:{ Exception -> 0x019d }
                goto L_0x0109
            L_0x0174:
                T r15 = r2.element     // Catch:{ Exception -> 0x019d }
                java.util.Map r15 = (java.util.Map) r15     // Catch:{ Exception -> 0x019d }
                java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r1)     // Catch:{ Exception -> 0x019d }
                java.lang.Object r15 = r15.get(r1)     // Catch:{ Exception -> 0x019d }
                boolean r1 = r15 instanceof java.lang.Boolean     // Catch:{ Exception -> 0x019d }
                if (r1 != 0) goto L_0x0185
                goto L_0x0186
            L_0x0185:
                r7 = r15
            L_0x0186:
                java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ Exception -> 0x019d }
            L_0x0188:
                if (r7 == 0) goto L_0x018e
                boolean r0 = r7.booleanValue()     // Catch:{ Exception -> 0x019d }
            L_0x018e:
                com.sumsub.sns.core.presentation.base.a<T> r15 = r14.f30808b     // Catch:{ Exception -> 0x019d }
                kotlinx.coroutines.flow.b1 r15 = r15.f30789i     // Catch:{ Exception -> 0x019d }
                com.sumsub.sns.core.presentation.base.a$b0$e r1 = new com.sumsub.sns.core.presentation.base.a$b0$e     // Catch:{ Exception -> 0x019d }
                r1.<init>(r0)     // Catch:{ Exception -> 0x019d }
                com.sumsub.sns.internal.core.common.b0.a(r15, r1)     // Catch:{ Exception -> 0x019d }
                goto L_0x01a8
            L_0x019d:
                com.sumsub.sns.core.presentation.base.a<T> r15 = r14.f30808b
                kotlinx.coroutines.flow.b1 r15 = r15.f30789i
                com.sumsub.sns.core.presentation.base.a$b0$f r0 = com.sumsub.sns.core.presentation.base.a.b0.f.f30826a
                com.sumsub.sns.internal.core.common.b0.a(r15, r0)
            L_0x01a8:
                kotlin.Unit r15 = kotlin.Unit.f56620a
                return r15
            L_0x01ab:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "SDK prepare timeout"
                r15.<init>(r0)
                throw r15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.base.a.b0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final class c {
        public /* synthetic */ c(kotlin.jvm.internal.r rVar) {
            this();
        }

        public c() {
        }
    }

    public static final class c0 extends Lambda implements d10.l<k, k> {

        /* renamed from: a  reason: collision with root package name */
        public static final c0 f30827a = new c0();

        public c0() {
            super(1);
        }

        /* renamed from: a */
        public final k invoke(k kVar) {
            return k.a(kVar, false, true, true, (CharSequence) null, (CharSequence) null, 25, (Object) null);
        }
    }

    public static final class d implements j {

        /* renamed from: a  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.data.model.o f30828a;

        /* renamed from: b  reason: collision with root package name */
        public final String f30829b;

        /* renamed from: c  reason: collision with root package name */
        public final CharSequence f30830c;

        public d(com.sumsub.sns.internal.core.data.model.o oVar, String str, CharSequence charSequence) {
            this.f30828a = oVar;
            this.f30829b = str;
            this.f30830c = charSequence;
        }

        public final com.sumsub.sns.internal.core.data.model.o a() {
            return this.f30828a;
        }

        public final String b() {
            return this.f30829b;
        }

        public final CharSequence c() {
            return this.f30830c;
        }

        public final CharSequence d() {
            return this.f30830c;
        }

        public final com.sumsub.sns.internal.core.data.model.o e() {
            return this.f30828a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return kotlin.jvm.internal.x.b(this.f30828a, dVar.f30828a) && kotlin.jvm.internal.x.b(this.f30829b, dVar.f30829b) && kotlin.jvm.internal.x.b(this.f30830c, dVar.f30830c);
        }

        public final String f() {
            return this.f30829b;
        }

        public int hashCode() {
            com.sumsub.sns.internal.core.data.model.o oVar = this.f30828a;
            int i11 = 0;
            int hashCode = (((oVar == null ? 0 : oVar.hashCode()) * 31) + this.f30829b.hashCode()) * 31;
            CharSequence charSequence = this.f30830c;
            if (charSequence != null) {
                i11 = charSequence.hashCode();
            }
            return hashCode + i11;
        }

        public String toString() {
            return "ErrorEvent(error=" + this.f30828a + ", idDocSetType=" + this.f30829b + ", buttonText=" + this.f30830c + ')';
        }

        public final d a(com.sumsub.sns.internal.core.data.model.o oVar, String str, CharSequence charSequence) {
            return new d(oVar, str, charSequence);
        }

        public static /* synthetic */ d a(d dVar, com.sumsub.sns.internal.core.data.model.o oVar, String str, CharSequence charSequence, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                oVar = dVar.f30828a;
            }
            if ((i11 & 2) != 0) {
                str = dVar.f30829b;
            }
            if ((i11 & 4) != 0) {
                charSequence = dVar.f30830c;
            }
            return dVar.a(oVar, str, charSequence);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.base.SNSViewModel", f = "SNSViewModel.kt", l = {279}, m = "runWithProgressIndicator")
    public static final class d0<T> extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f30831a;

        /* renamed from: b  reason: collision with root package name */
        public Object f30832b;

        /* renamed from: c  reason: collision with root package name */
        public Object f30833c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f30834d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a<T> f30835e;

        /* renamed from: f  reason: collision with root package name */
        public int f30836f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d0(a<T> aVar, kotlin.coroutines.c<? super d0> cVar) {
            super(cVar);
            this.f30835e = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f30834d = obj;
            this.f30836f |= Integer.MIN_VALUE;
            return this.f30835e.a(0, (d10.l) null, this);
        }
    }

    public static final class e implements j {

        /* renamed from: a  reason: collision with root package name */
        public final com.sumsub.sns.internal.core.common.q f30837a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f30838b;

        /* renamed from: c  reason: collision with root package name */
        public final Long f30839c;

        public e() {
            this((com.sumsub.sns.internal.core.common.q) null, (Object) null, (Long) null, 7, (kotlin.jvm.internal.r) null);
        }

        public final com.sumsub.sns.internal.core.common.q a() {
            return this.f30837a;
        }

        public final Object b() {
            return this.f30838b;
        }

        public final Long c() {
            return this.f30839c;
        }

        public final Long d() {
            return this.f30839c;
        }

        public final Object e() {
            return this.f30838b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return kotlin.jvm.internal.x.b(this.f30837a, eVar.f30837a) && kotlin.jvm.internal.x.b(this.f30838b, eVar.f30838b) && kotlin.jvm.internal.x.b(this.f30839c, eVar.f30839c);
        }

        public final com.sumsub.sns.internal.core.common.q f() {
            return this.f30837a;
        }

        public int hashCode() {
            int hashCode = this.f30837a.hashCode() * 31;
            Object obj = this.f30838b;
            int i11 = 0;
            int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            Long l11 = this.f30839c;
            if (l11 != null) {
                i11 = l11.hashCode();
            }
            return hashCode2 + i11;
        }

        public String toString() {
            return "FinishEvent(reason=" + this.f30837a + ", payload=" + this.f30838b + ", delay=" + this.f30839c + ')';
        }

        public e(com.sumsub.sns.internal.core.common.q qVar, Object obj, Long l11) {
            this.f30837a = qVar;
            this.f30838b = obj;
            this.f30839c = l11;
        }

        public final e a(com.sumsub.sns.internal.core.common.q qVar, Object obj, Long l11) {
            return new e(qVar, obj, l11);
        }

        public static /* synthetic */ e a(e eVar, com.sumsub.sns.internal.core.common.q qVar, Object obj, Long l11, int i11, Object obj2) {
            if ((i11 & 1) != 0) {
                qVar = eVar.f30837a;
            }
            if ((i11 & 2) != 0) {
                obj = eVar.f30838b;
            }
            if ((i11 & 4) != 0) {
                l11 = eVar.f30839c;
            }
            return eVar.a(qVar, obj, l11);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ e(com.sumsub.sns.internal.core.common.q qVar, Object obj, Long l11, int i11, kotlin.jvm.internal.r rVar) {
            this((i11 & 1) != 0 ? q.c.f32251b : qVar, (i11 & 2) != 0 ? null : obj, (i11 & 4) != 0 ? null : l11);
        }
    }

    public static final class e0 extends kotlin.coroutines.a implements kotlinx.coroutines.d0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30840a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e0(d0.a aVar, a aVar2) {
            super(aVar);
            this.f30840a = aVar2;
        }

        public void handleException(CoroutineContext coroutineContext, Throwable th2) {
            com.sumsub.sns.core.c.f30748a.a(com.sumsub.sns.internal.log.c.a(this.f30840a), "Prepare error", th2);
            if (this.f30840a.f30792l == null) {
                this.f30840a.f30792l = new b.c((Map) null, (List) null, 3, (kotlin.jvm.internal.r) null);
            }
            com.sumsub.sns.internal.core.common.b0.a(this.f30840a.f30789i, c0.f30827a);
            a aVar = this.f30840a;
            a.a(aVar, th2, aVar.f(), (Object) null, 4, (Object) null);
        }
    }

    public static final class f implements j {

        /* renamed from: a  reason: collision with root package name */
        public static final f f30841a = new f();
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.base.SNSViewModel$throwError$1$1", f = "SNSViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class f0 extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f30842a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f30843b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Throwable f30844c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f0(Throwable th2, kotlin.coroutines.c<? super f0> cVar) {
            super(2, cVar);
            this.f30844c = th2;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((f0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            f0 f0Var = new f0(this.f30844c, cVar);
            f0Var.f30843b = obj;
            return f0Var;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f30842a == 0) {
                kotlin.k.b(obj);
                Logger a11 = com.sumsub.sns.internal.log.a.f34862a.a(LoggerType.KIBANA);
                String a12 = com.sumsub.sns.internal.log.c.a((h0) this.f30843b);
                String message = this.f30844c.getMessage();
                if (message == null) {
                    message = "";
                }
                a11.e(a12, message, this.f30844c);
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class g implements j {

        /* renamed from: a  reason: collision with root package name */
        public static final g f30845a = new g();
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.base.SNSViewModel$updateState$1", f = "SNSViewModel.kt", l = {342}, m = "invokeSuspend")
    public static final class g0 extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f30846a;

        /* renamed from: b  reason: collision with root package name */
        public int f30847b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a<T> f30848c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d10.p<T, kotlin.coroutines.c<? super T>, Object> f30849d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ T f30850e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g0(a<T> aVar, d10.p<? super T, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, T t11, kotlin.coroutines.c<? super g0> cVar) {
            super(2, cVar);
            this.f30848c = aVar;
            this.f30849d = pVar;
            this.f30850e = t11;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((g0) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new g0(this.f30848c, this.f30849d, this.f30850e, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            a1 a1Var;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f30847b;
            if (i11 == 0) {
                kotlin.k.b(obj);
                a1 g11 = this.f30848c.f30787g;
                d10.p<T, kotlin.coroutines.c<? super T>, Object> pVar = this.f30849d;
                T t11 = this.f30850e;
                this.f30846a = g11;
                this.f30847b = 1;
                Object invoke = pVar.invoke(t11, this);
                if (invoke == d11) {
                    return d11;
                }
                a1Var = g11;
                obj = invoke;
            } else if (i11 == 1) {
                a1Var = (a1) this.f30846a;
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a1Var.d(obj);
            return Unit.f56620a;
        }
    }

    public static final class h implements j {

        /* renamed from: a  reason: collision with root package name */
        public final String f30851a;

        public h(String str) {
            this.f30851a = str;
        }

        public final String a() {
            return this.f30851a;
        }

        public final String b() {
            return this.f30851a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof h) && kotlin.jvm.internal.x.b(this.f30851a, ((h) obj).f30851a);
        }

        public int hashCode() {
            return this.f30851a.hashCode();
        }

        public String toString() {
            return "OpenUrlEvent(uri=" + this.f30851a + ')';
        }

        public final h a(String str) {
            return new h(str);
        }

        public static /* synthetic */ h a(h hVar, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = hVar.f30851a;
            }
            return hVar.a(str);
        }
    }

    public static final class i implements j {

        /* renamed from: a  reason: collision with root package name */
        public final String f30852a;

        public i(String str) {
            this.f30852a = str;
        }

        public final String a() {
            return this.f30852a;
        }

        public final String b() {
            return this.f30852a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof i) && kotlin.jvm.internal.x.b(this.f30852a, ((i) obj).f30852a);
        }

        public int hashCode() {
            return this.f30852a.hashCode();
        }

        public String toString() {
            return "PermissionRequest(permission=" + this.f30852a + ')';
        }

        public final i a(String str) {
            return new i(str);
        }

        public static /* synthetic */ i a(i iVar, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = iVar.f30852a;
            }
            return iVar.a(str);
        }
    }

    public interface j {
    }

    public static final class k {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f30853a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f30854b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f30855c;

        /* renamed from: d  reason: collision with root package name */
        public final CharSequence f30856d;

        /* renamed from: e  reason: collision with root package name */
        public final CharSequence f30857e;

        public k() {
            this(false, false, false, (CharSequence) null, (CharSequence) null, 31, (kotlin.jvm.internal.r) null);
        }

        public final boolean a() {
            return this.f30853a;
        }

        public final boolean b() {
            return this.f30854b;
        }

        public final boolean c() {
            return this.f30855c;
        }

        public final CharSequence d() {
            return this.f30856d;
        }

        public final CharSequence e() {
            return this.f30857e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return this.f30853a == kVar.f30853a && this.f30854b == kVar.f30854b && this.f30855c == kVar.f30855c && kotlin.jvm.internal.x.b(this.f30856d, kVar.f30856d) && kotlin.jvm.internal.x.b(this.f30857e, kVar.f30857e);
        }

        public final boolean f() {
            return this.f30854b;
        }

        public final boolean g() {
            return this.f30853a;
        }

        public final CharSequence h() {
            return this.f30856d;
        }

        public int hashCode() {
            boolean z11 = this.f30853a;
            boolean z12 = true;
            if (z11) {
                z11 = true;
            }
            int i11 = (z11 ? 1 : 0) * true;
            boolean z13 = this.f30854b;
            if (z13) {
                z13 = true;
            }
            int i12 = (i11 + (z13 ? 1 : 0)) * 31;
            boolean z14 = this.f30855c;
            if (!z14) {
                z12 = z14;
            }
            int i13 = (i12 + (z12 ? 1 : 0)) * 31;
            CharSequence charSequence = this.f30856d;
            int i14 = 0;
            int hashCode = (i13 + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
            CharSequence charSequence2 = this.f30857e;
            if (charSequence2 != null) {
                i14 = charSequence2.hashCode();
            }
            return hashCode + i14;
        }

        public final CharSequence i() {
            return this.f30857e;
        }

        public final boolean j() {
            return this.f30855c;
        }

        public String toString() {
            return "SNSViewModelInternalState(hideLogo=" + this.f30853a + ", areStringsReady=" + this.f30854b + ", isViewModelPrepared=" + this.f30855c + ", poweredByText=" + this.f30856d + ", progressText=" + this.f30857e + ')';
        }

        public k(boolean z11, boolean z12, boolean z13, CharSequence charSequence, CharSequence charSequence2) {
            this.f30853a = z11;
            this.f30854b = z12;
            this.f30855c = z13;
            this.f30856d = charSequence;
            this.f30857e = charSequence2;
        }

        public final k a(boolean z11, boolean z12, boolean z13, CharSequence charSequence, CharSequence charSequence2) {
            return new k(z11, z12, z13, charSequence, charSequence2);
        }

        public static /* synthetic */ k a(k kVar, boolean z11, boolean z12, boolean z13, CharSequence charSequence, CharSequence charSequence2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = kVar.f30853a;
            }
            if ((i11 & 2) != 0) {
                z12 = kVar.f30854b;
            }
            boolean z14 = z12;
            if ((i11 & 4) != 0) {
                z13 = kVar.f30855c;
            }
            boolean z15 = z13;
            if ((i11 & 8) != 0) {
                charSequence = kVar.f30856d;
            }
            CharSequence charSequence3 = charSequence;
            if ((i11 & 16) != 0) {
                charSequence2 = kVar.f30857e;
            }
            return kVar.a(z11, z14, z15, charSequence3, charSequence2);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ k(boolean r4, boolean r5, boolean r6, java.lang.CharSequence r7, java.lang.CharSequence r8, int r9, kotlin.jvm.internal.r r10) {
            /*
                r3 = this;
                r10 = r9 & 1
                r0 = 0
                if (r10 == 0) goto L_0x0007
                r10 = r0
                goto L_0x0008
            L_0x0007:
                r10 = r4
            L_0x0008:
                r4 = r9 & 2
                if (r4 == 0) goto L_0x000e
                r1 = r0
                goto L_0x000f
            L_0x000e:
                r1 = r5
            L_0x000f:
                r4 = r9 & 4
                if (r4 == 0) goto L_0x0014
                goto L_0x0015
            L_0x0014:
                r0 = r6
            L_0x0015:
                r4 = r9 & 8
                r5 = 0
                if (r4 == 0) goto L_0x001c
                r2 = r5
                goto L_0x001d
            L_0x001c:
                r2 = r7
            L_0x001d:
                r4 = r9 & 16
                if (r4 == 0) goto L_0x0023
                r9 = r5
                goto L_0x0024
            L_0x0023:
                r9 = r8
            L_0x0024:
                r4 = r3
                r5 = r10
                r6 = r1
                r7 = r0
                r8 = r2
                r4.<init>(r5, r6, r7, r8, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.base.a.k.<init>(boolean, boolean, boolean, java.lang.CharSequence, java.lang.CharSequence, int, kotlin.jvm.internal.r):void");
        }
    }

    public interface l {
    }

    public static final class m implements j {

        /* renamed from: a  reason: collision with root package name */
        public final Document f30858a;

        public m(Document document) {
            this.f30858a = document;
        }

        public final Document a() {
            return this.f30858a;
        }

        public final Document b() {
            return this.f30858a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof m) && kotlin.jvm.internal.x.b(this.f30858a, ((m) obj).f30858a);
        }

        public int hashCode() {
            return this.f30858a.hashCode();
        }

        public String toString() {
            return "ShowDocumentEvent(document=" + this.f30858a + ')';
        }

        public final m a(Document document) {
            return new m(document);
        }

        public static /* synthetic */ m a(m mVar, Document document, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                document = mVar.f30858a;
            }
            return mVar.a(document);
        }
    }

    public static final class n implements j {

        /* renamed from: a  reason: collision with root package name */
        public final int f30859a;

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f30860b;

        /* renamed from: c  reason: collision with root package name */
        public final CharSequence f30861c;

        /* renamed from: d  reason: collision with root package name */
        public final CharSequence f30862d;

        public n(int i11, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
            this.f30859a = i11;
            this.f30860b = charSequence;
            this.f30861c = charSequence2;
            this.f30862d = charSequence3;
        }

        public final int a() {
            return this.f30859a;
        }

        public final CharSequence b() {
            return this.f30860b;
        }

        public final CharSequence c() {
            return this.f30861c;
        }

        public final CharSequence d() {
            return this.f30862d;
        }

        public final int e() {
            return this.f30859a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof n)) {
                return false;
            }
            n nVar = (n) obj;
            return this.f30859a == nVar.f30859a && kotlin.jvm.internal.x.b(this.f30860b, nVar.f30860b) && kotlin.jvm.internal.x.b(this.f30861c, nVar.f30861c) && kotlin.jvm.internal.x.b(this.f30862d, nVar.f30862d);
        }

        public final CharSequence f() {
            return this.f30860b;
        }

        public final CharSequence g() {
            return this.f30862d;
        }

        public final CharSequence h() {
            return this.f30861c;
        }

        public int hashCode() {
            int i11 = this.f30859a * 31;
            CharSequence charSequence = this.f30860b;
            int i12 = 0;
            int hashCode = (i11 + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
            CharSequence charSequence2 = this.f30861c;
            int hashCode2 = (hashCode + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
            CharSequence charSequence3 = this.f30862d;
            if (charSequence3 != null) {
                i12 = charSequence3.hashCode();
            }
            return hashCode2 + i12;
        }

        public String toString() {
            return "ShowPermissionDialog(dialogId=" + this.f30859a + ", message=" + this.f30860b + ", positiveButton=" + this.f30861c + ", negativeButton=" + this.f30862d + ')';
        }

        public final n a(int i11, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
            return new n(i11, charSequence, charSequence2, charSequence3);
        }

        public static /* synthetic */ n a(n nVar, int i11, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = nVar.f30859a;
            }
            if ((i12 & 2) != 0) {
                charSequence = nVar.f30860b;
            }
            if ((i12 & 4) != 0) {
                charSequence2 = nVar.f30861c;
            }
            if ((i12 & 8) != 0) {
                charSequence3 = nVar.f30862d;
            }
            return nVar.a(i11, charSequence, charSequence2, charSequence3);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ n(int i11, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i12, kotlin.jvm.internal.r rVar) {
            this((i12 & 1) != 0 ? 0 : i11, charSequence, charSequence2, charSequence3);
        }
    }

    public static final class o implements j {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f30863a;

        public o(boolean z11) {
            this.f30863a = z11;
        }

        public final boolean a() {
            return this.f30863a;
        }

        public final boolean b() {
            return this.f30863a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof o) && this.f30863a == ((o) obj).f30863a;
        }

        public int hashCode() {
            boolean z11 = this.f30863a;
            if (z11) {
                return 1;
            }
            return z11 ? 1 : 0;
        }

        public String toString() {
            return "ShowProgressEvent(show=" + this.f30863a + ')';
        }

        public final o a(boolean z11) {
            return new o(z11);
        }

        public static /* synthetic */ o a(o oVar, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = oVar.f30863a;
            }
            return oVar.a(z11);
        }
    }

    public static final class p implements j {

        /* renamed from: a  reason: collision with root package name */
        public static final p f30864a = new p();
    }

    public static final class q implements j {

        /* renamed from: a  reason: collision with root package name */
        public final String f30865a;

        public q(String str) {
            this.f30865a = str;
        }

        public final String a() {
            return this.f30865a;
        }

        public final String b() {
            return this.f30865a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof q) && kotlin.jvm.internal.x.b(this.f30865a, ((q) obj).f30865a);
        }

        public int hashCode() {
            return this.f30865a.hashCode();
        }

        public String toString() {
            return "ShowToast(message=" + this.f30865a + ')';
        }

        public final q a(String str) {
            return new q(str);
        }

        public static /* synthetic */ q a(q qVar, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = qVar.f30865a;
            }
            return qVar.a(str);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.base.SNSViewModel", f = "SNSViewModel.kt", l = {365}, m = "awaitStringsReady")
    public static final class r extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f30866a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a<T> f30867b;

        /* renamed from: c  reason: collision with root package name */
        public int f30868c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(a<T> aVar, kotlin.coroutines.c<? super r> cVar) {
            super(cVar);
            this.f30867b = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f30866a = obj;
            this.f30868c |= Integer.MIN_VALUE;
            return this.f30867b.a((kotlin.coroutines.c<? super Boolean>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.base.SNSViewModel$awaitStringsReady$2", f = "SNSViewModel.kt", l = {366}, m = "invokeSuspend")
    public static final class s extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super k>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f30869a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a<T> f30870b;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.base.SNSViewModel$awaitStringsReady$2$1", f = "SNSViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.sumsub.sns.core.presentation.base.a$s$a  reason: collision with other inner class name */
        public static final class C0286a extends SuspendLambda implements d10.p<k, kotlin.coroutines.c<? super Boolean>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f30871a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ Object f30872b;

            public C0286a(kotlin.coroutines.c<? super C0286a> cVar) {
                super(2, cVar);
            }

            /* renamed from: a */
            public final Object invoke(k kVar, kotlin.coroutines.c<? super Boolean> cVar) {
                return ((C0286a) create(kVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                C0286a aVar = new C0286a(cVar);
                aVar.f30872b = obj;
                return aVar;
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f30871a == 0) {
                    kotlin.k.b(obj);
                    return kotlin.coroutines.jvm.internal.a.a(((k) this.f30872b).f());
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s(a<T> aVar, kotlin.coroutines.c<? super s> cVar) {
            super(2, cVar);
            this.f30870b = aVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super k> cVar) {
            return ((s) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new s(this.f30870b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f30869a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                b1 f11 = this.f30870b.f30789i;
                C0286a aVar = new C0286a((kotlin.coroutines.c<? super C0286a>) null);
                this.f30869a = 1;
                obj = kotlinx.coroutines.flow.f.z(f11, aVar, this);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return obj;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.base.SNSViewModel", f = "SNSViewModel.kt", l = {369}, m = "awaitViewModelPrepared")
    public static final class t extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f30873a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a<T> f30874b;

        /* renamed from: c  reason: collision with root package name */
        public int f30875c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t(a<T> aVar, kotlin.coroutines.c<? super t> cVar) {
            super(cVar);
            this.f30874b = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f30873a = obj;
            this.f30875c |= Integer.MIN_VALUE;
            return this.f30874b.b((kotlin.coroutines.c<? super Boolean>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.base.SNSViewModel$awaitViewModelPrepared$2", f = "SNSViewModel.kt", l = {370}, m = "invokeSuspend")
    public static final class u extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super k>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f30876a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a<T> f30877b;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.base.SNSViewModel$awaitViewModelPrepared$2$1", f = "SNSViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.sumsub.sns.core.presentation.base.a$u$a  reason: collision with other inner class name */
        public static final class C0287a extends SuspendLambda implements d10.p<k, kotlin.coroutines.c<? super Boolean>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f30878a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ Object f30879b;

            public C0287a(kotlin.coroutines.c<? super C0287a> cVar) {
                super(2, cVar);
            }

            /* renamed from: a */
            public final Object invoke(k kVar, kotlin.coroutines.c<? super Boolean> cVar) {
                return ((C0287a) create(kVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                C0287a aVar = new C0287a(cVar);
                aVar.f30879b = obj;
                return aVar;
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f30878a == 0) {
                    kotlin.k.b(obj);
                    return kotlin.coroutines.jvm.internal.a.a(((k) this.f30879b).j());
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public u(a<T> aVar, kotlin.coroutines.c<? super u> cVar) {
            super(2, cVar);
            this.f30877b = aVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super k> cVar) {
            return ((u) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new u(this.f30877b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f30876a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                b1 f11 = this.f30877b.f30789i;
                C0287a aVar = new C0287a((kotlin.coroutines.c<? super C0287a>) null);
                this.f30876a = 1;
                obj = kotlinx.coroutines.flow.f.z(f11, aVar, this);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return obj;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.base.SNSViewModel$events$1", f = "SNSViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class v extends SuspendLambda implements d10.p<kotlinx.coroutines.flow.e<? super j>, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f30880a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a<T> f30881b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public v(a<T> aVar, kotlin.coroutines.c<? super v> cVar) {
            super(2, cVar);
            this.f30881b = aVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.flow.e<? super j> eVar, kotlin.coroutines.c<? super Unit> cVar) {
            return ((v) create(eVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new v(this.f30881b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f30880a == 0) {
                kotlin.k.b(obj);
                this.f30881b.f30783c = kotlin.coroutines.jvm.internal.a.a(true);
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.base.SNSViewModel$events$2", f = "SNSViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class w extends SuspendLambda implements d10.q<kotlinx.coroutines.flow.e<? super j>, Throwable, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f30882a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a<T> f30883b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public w(a<T> aVar, kotlin.coroutines.c<? super w> cVar) {
            super(3, cVar);
            this.f30883b = aVar;
        }

        /* renamed from: a */
        public final Object invoke(kotlinx.coroutines.flow.e<? super j> eVar, Throwable th2, kotlin.coroutines.c<? super Unit> cVar) {
            return new w(this.f30883b, cVar).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f30882a == 0) {
                kotlin.k.b(obj);
                this.f30883b.f30783c = kotlin.coroutines.jvm.internal.a.a(false);
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.base.SNSViewModel$fireEvent$1", f = "SNSViewModel.kt", l = {329}, m = "invokeSuspend")
    public static final class x extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f30884a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f30885b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a<T> f30886c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ j f30887d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public x(boolean z11, a<T> aVar, j jVar, kotlin.coroutines.c<? super x> cVar) {
            super(2, cVar);
            this.f30885b = z11;
            this.f30886c = aVar;
            this.f30887d = jVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((x) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new x(this.f30885b, this.f30886c, this.f30887d, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f30884a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                if (this.f30885b) {
                    com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
                    String a11 = com.sumsub.sns.internal.log.c.a(this.f30886c);
                    com.sumsub.log.logger.a.d(aVar, a11, "fireEvent: " + this.f30887d, (Throwable) null, 4, (Object) null);
                }
                kotlinx.coroutines.channels.d d12 = this.f30886c.f30784d;
                j jVar = this.f30887d;
                this.f30884a = 1;
                if (d12.send(jVar, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.base.SNSViewModel", f = "SNSViewModel.kt", l = {352}, m = "getString")
    public static final class y extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f30888a;

        /* renamed from: b  reason: collision with root package name */
        public Object f30889b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f30890c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a<T> f30891d;

        /* renamed from: e  reason: collision with root package name */
        public int f30892e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public y(a<T> aVar, kotlin.coroutines.c<? super y> cVar) {
            super(cVar);
            this.f30891d = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f30890c = obj;
            this.f30892e |= Integer.MIN_VALUE;
            return this.f30891d.a((String) null, (kotlin.coroutines.c<? super String>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.base.SNSViewModel", f = "SNSViewModel.kt", l = {360}, m = "getStrings")
    public static final class z extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f30893a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f30894b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a<T> f30895c;

        /* renamed from: d  reason: collision with root package name */
        public int f30896d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public z(a<T> aVar, kotlin.coroutines.c<? super z> cVar) {
            super(cVar);
            this.f30895c = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f30894b = obj;
            this.f30896d |= Integer.MIN_VALUE;
            return this.f30895c.c((kotlin.coroutines.c<? super b.c>) this);
        }
    }

    public a(com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar) {
        this.f30781a = aVar;
        this.f30782b = bVar;
        kotlinx.coroutines.channels.d<j> b11 = kotlinx.coroutines.channels.f.b(0, (BufferOverflow) null, (d10.l) null, 7, (Object) null);
        this.f30784d = b11;
        kotlinx.coroutines.flow.d d11 = kotlinx.coroutines.flow.u.b(kotlinx.coroutines.flow.f.I(kotlinx.coroutines.flow.f.T(b11), v0.c()), 0, (BufferOverflow) null, 3, (Object) null);
        h0 a11 = m0.a(this);
        i1.a aVar2 = i1.f57228a;
        this.f30785e = kotlinx.coroutines.flow.f.O(kotlinx.coroutines.flow.f.R(FlowKt__ShareKt.h(d11, a11, i1.a.b(aVar2, 0, 0, 3, (Object) null), 0, 4, (Object) null), new v(this, (kotlin.coroutines.c<? super v>) null)), new w(this, (kotlin.coroutines.c<? super w>) null));
        a1<T> b12 = g1.b(1, 0, (BufferOverflow) null, 6, (Object) null);
        this.f30787g = b12;
        this.f30788h = kotlinx.coroutines.flow.f.V(kotlinx.coroutines.flow.f.s(b12), m0.a(this), i1.a.b(aVar2, 0, 0, 3, (Object) null), 1);
        b1<k> a12 = k1.a(new k(false, false, false, (CharSequence) null, (CharSequence) null, 31, (kotlin.jvm.internal.r) null));
        this.f30789i = a12;
        this.f30790j = kotlinx.coroutines.flow.f.b(a12);
        this.f30793m = new e0(kotlinx.coroutines.d0.f57063q0, this);
        com.sumsub.sns.internal.core.common.b0.b(bVar.b(), m0.a(this), new C0281a(this, (kotlin.coroutines.c<? super C0281a>) null));
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new b(this, (kotlin.coroutines.c<? super b>) null), 3, (Object) null);
        n();
    }

    public static /* synthetic */ void l() {
    }

    public void a(com.sumsub.sns.internal.core.data.model.o oVar) {
    }

    public Object d(kotlin.coroutines.c<? super Unit> cVar) {
        return Unit.f56620a;
    }

    public T e() {
        return null;
    }

    public String f() {
        return DocumentType.f32355j;
    }

    public final b.c h() {
        b.c cVar = this.f30792l;
        if (cVar != null) {
            return cVar;
        }
        com.sumsub.sns.core.c.f30748a.a(com.sumsub.sns.internal.log.c.a(this), "Accessing strings before onPrepared()", new IllegalAccessException("Accessing strings before onPrepared(). Use getStrings() or getString() instead."));
        return new b.c((Map) null, (List) null, 3, (kotlin.jvm.internal.r) null);
    }

    public final j1<k> i() {
        return this.f30790j;
    }

    public f1<T> j() {
        return this.f30788h;
    }

    public final boolean k() {
        return this.f30791k;
    }

    public void m() {
    }

    public final n1 n() {
        return kotlinx.coroutines.i.d(m0.a(this), v0.c().plus(this.f30793m), (CoroutineStart) null, new b0(this, (kotlin.coroutines.c<? super b0>) null), 2, (Object) null);
    }

    public final boolean o() {
        return this.f30790j.getValue().g();
    }

    public void onCleared() {
        super.onCleared();
        com.sumsub.log.logger.a.d(com.sumsub.sns.internal.log.a.f34862a, com.sumsub.sns.internal.log.c.a(this), "onCleared", (Throwable) null, 4, (Object) null);
        ReceiveChannel.DefaultImpls.a(this.f30786f, (CancellationException) null, 1, (Object) null);
    }

    public static final void i(a aVar) {
        aVar.b(false);
    }

    public void b(com.sumsub.sns.internal.core.data.model.o oVar) {
        com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
        String a11 = com.sumsub.sns.internal.log.c.a(this);
        com.sumsub.sns.core.c.b(cVar, a11, "Handle error: " + oVar, (Throwable) null, 4, (Object) null);
        if (oVar instanceof o.e) {
            m();
        } else if (oVar instanceof o.c) {
            a((SNSCompletionResult) new SNSCompletionResult.AbnormalTermination(oVar.b()));
        }
    }

    public final T c() {
        T t11 = (l) CollectionsKt___CollectionsKt.c0(this.f30787g.a());
        return t11 == null ? e() : t11;
    }

    public final kotlinx.coroutines.flow.d<j> g() {
        return this.f30785e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.b.c> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.sumsub.sns.core.presentation.base.a.z
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.sumsub.sns.core.presentation.base.a$z r0 = (com.sumsub.sns.core.presentation.base.a.z) r0
            int r1 = r0.f30896d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f30896d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.core.presentation.base.a$z r0 = new com.sumsub.sns.core.presentation.base.a$z
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f30894b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f30896d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.f30893a
            com.sumsub.sns.core.presentation.base.a r0 = (com.sumsub.sns.core.presentation.base.a) r0
            kotlin.k.b(r5)
            goto L_0x0044
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0035:
            kotlin.k.b(r5)
            r0.f30893a = r4
            r0.f30896d = r3
            java.lang.Object r5 = r4.a((kotlin.coroutines.c<? super java.lang.Boolean>) r0)
            if (r5 != r1) goto L_0x0043
            return r1
        L_0x0043:
            r0 = r4
        L_0x0044:
            com.sumsub.sns.internal.core.data.source.dynamic.b$c r5 = r0.h()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.base.a.c(kotlin.coroutines.c):java.lang.Object");
    }

    public final com.sumsub.sns.internal.core.data.model.e d() {
        return this.f30794n;
    }

    public static final void h(a aVar) {
        aVar.b(true);
    }

    public final void b(boolean z11) {
        a((j) new o(z11));
    }

    public final void a(boolean z11) {
        this.f30791k = z11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(kotlin.coroutines.c<? super java.lang.Boolean> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.sumsub.sns.core.presentation.base.a.t
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.sumsub.sns.core.presentation.base.a$t r0 = (com.sumsub.sns.core.presentation.base.a.t) r0
            int r1 = r0.f30875c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f30875c = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.core.presentation.base.a$t r0 = new com.sumsub.sns.core.presentation.base.a$t
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f30873a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f30875c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.k.b(r7)
            goto L_0x0045
        L_0x0029:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0031:
            kotlin.k.b(r7)
            com.sumsub.sns.core.presentation.base.a$u r7 = new com.sumsub.sns.core.presentation.base.a$u
            r2 = 0
            r7.<init>(r6, r2)
            r0.f30875c = r3
            r4 = 25000(0x61a8, double:1.23516E-319)
            java.lang.Object r7 = kotlinx.coroutines.TimeoutKt.d(r4, r7, r0)
            if (r7 != r1) goto L_0x0045
            return r1
        L_0x0045:
            if (r7 == 0) goto L_0x0048
            goto L_0x0049
        L_0x0048:
            r3 = 0
        L_0x0049:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.a.a(r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.base.a.b(kotlin.coroutines.c):java.lang.Object");
    }

    public final void a(Throwable th2) {
        Integer code;
        if ((th2 instanceof SNSException.Api) && (code = ((SNSException.Api) th2).getCode()) != null && code.intValue() == 401) {
            a(this, th2, f(), (Object) null, 4, (Object) null);
        }
    }

    public final void a(com.sumsub.sns.internal.core.data.model.o oVar, String str) {
        boolean z11;
        Throwable b11;
        if (!kotlin.jvm.internal.x.b(this.f30783c, Boolean.FALSE)) {
            String str2 = null;
            com.sumsub.sns.core.c.f30748a.b(com.sumsub.sns.internal.log.c.a(this), "An error happened", oVar != null ? oVar.b() : null);
            if (oVar instanceof o.e) {
                z11 = true;
            } else {
                z11 = oVar instanceof o.c;
            }
            if (z11 && (b11 = oVar.b()) != null) {
                n1 unused = kotlinx.coroutines.i.d(m0.a(this), v1.f57574b, (CoroutineStart) null, new f0(b11, (kotlin.coroutines.c<? super f0>) null), 2, (Object) null);
            }
            b.c cVar = this.f30792l;
            if (cVar != null) {
                str2 = cVar.a("sns_alert_action_ok");
            }
            a((j) new d(oVar, str, str2));
        }
    }

    public static /* synthetic */ void a(a aVar, Throwable th2, String str, Object obj, int i11, Object obj2) {
        if (obj2 == null) {
            if ((i11 & 4) != 0) {
                obj = null;
            }
            aVar.a(th2, str, obj);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: throwError");
    }

    public final void a(Throwable th2, String str, Object obj) {
        com.sumsub.sns.internal.core.data.model.o a11 = com.sumsub.sns.internal.core.common.o.a(th2, obj);
        if (a11 != null) {
            a(a11, str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> java.lang.Object a(long r5, d10.l<? super kotlin.coroutines.c<? super T>, ? extends java.lang.Object> r7, kotlin.coroutines.c<? super T> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.sumsub.sns.core.presentation.base.a.d0
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.sumsub.sns.core.presentation.base.a$d0 r0 = (com.sumsub.sns.core.presentation.base.a.d0) r0
            int r1 = r0.f30836f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f30836f = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.core.presentation.base.a$d0 r0 = new com.sumsub.sns.core.presentation.base.a$d0
            r0.<init>(r4, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f30834d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f30836f
            r3 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r5 = r0.f30833c
            java.lang.Runnable r5 = (java.lang.Runnable) r5
            java.lang.Object r6 = r0.f30832b
            android.os.Handler r6 = (android.os.Handler) r6
            java.lang.Object r7 = r0.f30831a
            com.sumsub.sns.core.presentation.base.a r7 = (com.sumsub.sns.core.presentation.base.a) r7
            kotlin.k.b(r8)
            goto L_0x0064
        L_0x0035:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003d:
            kotlin.k.b(r8)
            android.os.Handler r8 = new android.os.Handler
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            r8.<init>(r2)
            com.sumsub.sns.core.presentation.base.c r2 = new com.sumsub.sns.core.presentation.base.c
            r2.<init>(r4)
            r8.postDelayed(r2, r5)
            r0.f30831a = r4
            r0.f30832b = r8
            r0.f30833c = r2
            r0.f30836f = r3
            java.lang.Object r5 = r7.invoke(r0)
            if (r5 != r1) goto L_0x0060
            return r1
        L_0x0060:
            r7 = r4
            r6 = r8
            r8 = r5
            r5 = r2
        L_0x0064:
            r6.removeCallbacks(r5)
            com.sumsub.sns.core.presentation.base.d r5 = new com.sumsub.sns.core.presentation.base.d
            r5.<init>(r7)
            r6.post(r5)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.base.a.a(long, d10.l, kotlin.coroutines.c):java.lang.Object");
    }

    public static /* synthetic */ Object a(a aVar, long j11, d10.l lVar, kotlin.coroutines.c cVar, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                j11 = 300;
            }
            return aVar.a(j11, lVar, cVar);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: runWithProgressIndicator");
    }

    public static /* synthetic */ void a(a aVar, com.sumsub.sns.internal.core.common.q qVar, Object obj, Long l11, int i11, Object obj2) {
        if (obj2 == null) {
            if ((i11 & 1) != 0) {
                qVar = q.c.f32251b;
            }
            if ((i11 & 2) != 0) {
                obj = null;
            }
            if ((i11 & 4) != 0) {
                l11 = null;
            }
            aVar.a(qVar, obj, l11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finish");
    }

    public final void a(com.sumsub.sns.internal.core.common.q qVar, Object obj, Long l11) {
        b(false);
        a((j) new e(qVar, obj, l11));
    }

    public final void a(String str) {
        try {
            com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
            String a11 = com.sumsub.sns.internal.log.c.a(this);
            com.sumsub.sns.core.c.b(cVar, a11, "An user has clicked on " + str, (Throwable) null, 4, (Object) null);
            if (kotlin.jvm.internal.x.b(str, "support")) {
                a((j) p.f30864a);
            } else {
                a((j) new h(str));
            }
        } catch (Throwable th2) {
            com.sumsub.sns.core.c.f30748a.a(com.sumsub.sns.internal.log.c.a(this), "onLinkClicked", th2);
        }
    }

    public void a(j jVar) {
        a(jVar, true);
    }

    public final void a(j jVar, boolean z11) {
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new x(z11, this, jVar, (kotlin.coroutines.c<? super x>) null), 3, (Object) null);
    }

    public static /* synthetic */ void a(a aVar, boolean z11, d10.p pVar, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                z11 = false;
            }
            aVar.a(z11, pVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateState");
    }

    public final void a(boolean z11, d10.p<? super T, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar) {
        if (z11) {
            l c11 = c();
            a(c11);
            n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new g0(this, pVar, c11, (kotlin.coroutines.c<? super g0>) null), 3, (Object) null);
            return;
        }
        this.f30786f.q(pVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004c A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.String r5, kotlin.coroutines.c<? super java.lang.String> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.sumsub.sns.core.presentation.base.a.y
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.sumsub.sns.core.presentation.base.a$y r0 = (com.sumsub.sns.core.presentation.base.a.y) r0
            int r1 = r0.f30892e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f30892e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.core.presentation.base.a$y r0 = new com.sumsub.sns.core.presentation.base.a$y
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f30890c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f30892e
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r5 = r0.f30889b
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r0 = r0.f30888a
            com.sumsub.sns.core.presentation.base.a r0 = (com.sumsub.sns.core.presentation.base.a) r0
            kotlin.k.b(r6)
            goto L_0x004a
        L_0x0031:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0039:
            kotlin.k.b(r6)
            r0.f30888a = r4
            r0.f30889b = r5
            r0.f30892e = r3
            java.lang.Object r6 = r4.a((kotlin.coroutines.c<? super java.lang.Boolean>) r0)
            if (r6 != r1) goto L_0x0049
            return r1
        L_0x0049:
            r0 = r4
        L_0x004a:
            if (r5 != 0) goto L_0x004e
            r5 = 0
            goto L_0x0056
        L_0x004e:
            com.sumsub.sns.internal.core.data.source.dynamic.b$c r6 = r0.h()
            java.lang.String r5 = r6.a((java.lang.String) r5)
        L_0x0056:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.base.a.a(java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.coroutines.c<? super java.lang.Boolean> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.sumsub.sns.core.presentation.base.a.r
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.sumsub.sns.core.presentation.base.a$r r0 = (com.sumsub.sns.core.presentation.base.a.r) r0
            int r1 = r0.f30868c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f30868c = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.core.presentation.base.a$r r0 = new com.sumsub.sns.core.presentation.base.a$r
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f30866a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f30868c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.k.b(r7)
            goto L_0x0045
        L_0x0029:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0031:
            kotlin.k.b(r7)
            com.sumsub.sns.core.presentation.base.a$s r7 = new com.sumsub.sns.core.presentation.base.a$s
            r2 = 0
            r7.<init>(r6, r2)
            r0.f30868c = r3
            r4 = 25000(0x61a8, double:1.23516E-319)
            java.lang.Object r7 = kotlinx.coroutines.TimeoutKt.d(r4, r7, r0)
            if (r7 != r1) goto L_0x0045
            return r1
        L_0x0045:
            if (r7 == 0) goto L_0x0048
            goto L_0x0049
        L_0x0048:
            r3 = 0
        L_0x0049:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.a.a(r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.base.a.a(kotlin.coroutines.c):java.lang.Object");
    }

    public final void a(String str, d10.p<? super h0, ? super kotlin.coroutines.c<? super Unit>, ? extends Object> pVar) {
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new a0(pVar, this, str, (kotlin.coroutines.c<? super a0>) null), 3, (Object) null);
    }

    public final void a(SNSCompletionResult sNSCompletionResult) {
        com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
        String a11 = com.sumsub.sns.internal.log.c.a(this);
        com.sumsub.sns.core.c.b(cVar, a11, "Completion the SDK with result - " + sNSCompletionResult, (Throwable) null, 4, (Object) null);
        a(this, (com.sumsub.sns.internal.core.common.q) new q.d(sNSCompletionResult), (Object) null, (Long) null, 6, (Object) null);
    }

    public final void a(T t11) {
        if (t11 == null && com.sumsub.sns.internal.core.common.e0.f32018a.isDebug()) {
            throw new IllegalStateException(("Before updating state provide default state for " + com.sumsub.sns.internal.log.c.a(this) + " by overriding getDefaultState()").toString());
        }
    }
}
