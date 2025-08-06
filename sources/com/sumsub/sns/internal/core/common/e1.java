package com.sumsub.sns.internal.core.common;

import com.sumsub.sns.internal.core.b;
import d10.p;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.channels.k;
import kotlinx.coroutines.channels.m;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.p1;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public final class e1 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f32044a = "webSocketFlow";

    /* renamed from: b  reason: collision with root package name */
    public static final int f32045b = 1000;

    /* renamed from: c  reason: collision with root package name */
    public static final long f32046c = 10000;

    @d(c = "com.sumsub.sns.internal.core.common.WebSocketFlowKt$webSocketFlow$1", f = "WebSocketFlow.kt", l = {111, 98}, m = "invokeSuspend")
    public static final class a extends SuspendLambda implements p<k<? super String>, c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f32047a;

        /* renamed from: b  reason: collision with root package name */
        public Object f32048b;

        /* renamed from: c  reason: collision with root package name */
        public Object f32049c;

        /* renamed from: d  reason: collision with root package name */
        public int f32050d;

        /* renamed from: e  reason: collision with root package name */
        public /* synthetic */ Object f32051e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f32052f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b<String> f32053g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ OkHttpClient f32054h;

        /* renamed from: com.sumsub.sns.internal.core.common.e1$a$a  reason: collision with other inner class name */
        public static final class C0325a extends WebSocketListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Ref$ObjectRef<State> f32055a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Ref$ObjectRef<c<Unit>> f32056b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ k<String> f32057c;

            public C0325a(Ref$ObjectRef<State> ref$ObjectRef, Ref$ObjectRef<c<Unit>> ref$ObjectRef2, k<? super String> kVar) {
                this.f32055a = ref$ObjectRef;
                this.f32056b = ref$ObjectRef2;
                this.f32057c = kVar;
            }

            public void onClosed(WebSocket webSocket, int i11, String str) {
                com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
                com.sumsub.sns.core.c.b(cVar, e1.f32044a, "WebSocketListener.onClosed: code=" + i11 + " reason=" + str, (Throwable) null, 4, (Object) null);
                m.a.a(this.f32057c.getChannel(), (Throwable) null, 1, (Object) null);
            }

            public void onFailure(WebSocket webSocket, Throwable th2, Response response) {
                CoroutineContext context;
                com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
                com.sumsub.log.logger.a.b(aVar, e1.f32044a, "WebSocketListener.onFailure: \n" + th2 + 10 + response, (Throwable) null, 4, (Object) null);
                c cVar = (c) this.f32056b.element;
                boolean z11 = true;
                if (cVar == null || (context = cVar.getContext()) == null || !p1.l(context)) {
                    z11 = false;
                }
                if (!((State) this.f32055a.element).isDisconnected()) {
                    com.sumsub.sns.core.c cVar2 = com.sumsub.sns.core.c.f30748a;
                    com.sumsub.sns.core.c.b(cVar2, e1.f32044a, "WebSocketListener.onFailure: n" + th2 + "\n isActive=" + z11 + ",  " + response, (Throwable) null, 4, (Object) null);
                    this.f32055a.element = State.DISCONNECTING;
                }
                if (z11) {
                    try {
                        c cVar3 = (c) this.f32056b.element;
                        if (cVar3 != null) {
                            Result.a aVar2 = Result.Companion;
                            cVar3.resumeWith(Result.m3072constructorimpl(Unit.f56620a));
                        }
                    } catch (Exception e11) {
                        com.sumsub.sns.internal.log.b.b(com.sumsub.sns.internal.log.a.f34862a, e1.f32044a, "Failed to resume", e11);
                    }
                    this.f32057c.q("");
                }
            }

            public void onMessage(WebSocket webSocket, String str) {
                com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
                com.sumsub.log.logger.a.a(aVar, e1.f32044a, "WebSocketListener.onMessage: text=" + str, (Throwable) null, 4, (Object) null);
                com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
                com.sumsub.sns.core.c.b(cVar, e1.f32044a, "onMessage: size=" + str.length(), (Throwable) null, 4, (Object) null);
                this.f32057c.q(str);
            }

            public void onOpen(WebSocket webSocket, Response response) {
                com.sumsub.sns.core.c.b(com.sumsub.sns.core.c.f30748a, e1.f32044a, "WebSocketListener.onOpen", (Throwable) null, 4, (Object) null);
                this.f32055a.element = State.CONNECTED;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str, b<String> bVar, OkHttpClient okHttpClient, c<? super a> cVar) {
            super(2, cVar);
            this.f32052f = str;
            this.f32053g = bVar;
            this.f32054h = okHttpClient;
        }

        /* renamed from: a */
        public final Object invoke(k<? super String> kVar, c<? super Unit> cVar) {
            return ((a) create(kVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            a aVar = new a(this.f32052f, this.f32053g, this.f32054h, cVar);
            aVar.f32051e = obj;
            return aVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x007c A[Catch:{ all -> 0x0114 }] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x008e A[Catch:{ all -> 0x0114 }] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x00e0 A[Catch:{ all -> 0x0114 }] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00e6 A[Catch:{ all -> 0x0114 }] */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00f5 A[Catch:{ all -> 0x0114 }] */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0113 A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                r17 = this;
                r1 = r17
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r2 = r1.f32050d
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L_0x004a
                if (r2 == r4) goto L_0x0033
                if (r2 != r3) goto L_0x002b
                java.lang.Object r2 = r1.f32049c
                com.sumsub.sns.internal.core.common.e1$a$a r2 = (com.sumsub.sns.internal.core.common.e1.a.C0325a) r2
                java.lang.Object r5 = r1.f32048b
                kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref$ObjectRef) r5
                java.lang.Object r6 = r1.f32047a
                okhttp3.WebSocket r6 = (okhttp3.WebSocket) r6
                java.lang.Object r7 = r1.f32051e
                kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref$ObjectRef) r7
                kotlin.k.b(r18)     // Catch:{ all -> 0x0114 }
                r8 = r2
                r2 = r1
            L_0x0025:
                r16 = r7
                r7 = r5
                r5 = r16
                goto L_0x0072
            L_0x002b:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L_0x0033:
                java.lang.Object r2 = r1.f32049c
                com.sumsub.sns.internal.core.common.e1$a$a r2 = (com.sumsub.sns.internal.core.common.e1.a.C0325a) r2
                java.lang.Object r5 = r1.f32048b
                kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref$ObjectRef) r5
                java.lang.Object r6 = r1.f32047a
                okhttp3.WebSocket r6 = (okhttp3.WebSocket) r6
                java.lang.Object r7 = r1.f32051e
                kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref$ObjectRef) r7
                kotlin.k.b(r18)     // Catch:{ all -> 0x0114 }
                r8 = r2
                r2 = r1
                goto L_0x00eb
            L_0x004a:
                kotlin.k.b(r18)
                java.lang.Object r2 = r1.f32051e
                kotlinx.coroutines.channels.k r2 = (kotlinx.coroutines.channels.k) r2
                kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
                r5.<init>()
                r6 = 0
                kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
                r7.<init>()
                com.sumsub.sns.internal.core.common.State r8 = com.sumsub.sns.internal.core.common.State.DEFAULT
                r7.element = r8
                com.sumsub.sns.internal.core.common.e1$a$a r8 = new com.sumsub.sns.internal.core.common.e1$a$a
                r8.<init>(r7, r5, r2)
                com.sumsub.sns.core.c r9 = com.sumsub.sns.core.c.f30748a
                r12 = 0
                r13 = 4
                r14 = 0
                java.lang.String r10 = "webSocketFlow"
                java.lang.String r11 = "Start WebSocket flow"
                com.sumsub.sns.core.c.b(r9, r10, r11, r12, r13, r14)
                r2 = r1
            L_0x0072:
                T r9 = r7.element     // Catch:{ all -> 0x0114 }
                com.sumsub.sns.internal.core.common.State r9 = (com.sumsub.sns.internal.core.common.State) r9     // Catch:{ all -> 0x0114 }
                boolean r9 = r9.isDisconnected()     // Catch:{ all -> 0x0114 }
                if (r9 != 0) goto L_0x0088
                com.sumsub.sns.core.c r10 = com.sumsub.sns.core.c.f30748a     // Catch:{ all -> 0x0114 }
                java.lang.String r11 = "webSocketFlow"
                java.lang.String r12 = "WebSocket newWebSocket"
                r13 = 0
                r14 = 4
                r15 = 0
                com.sumsub.sns.core.c.b(r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x0114 }
            L_0x0088:
                T r9 = r7.element     // Catch:{ all -> 0x0114 }
                com.sumsub.sns.internal.core.common.State r10 = com.sumsub.sns.internal.core.common.State.DISCONNECTING     // Catch:{ all -> 0x0114 }
                if (r9 != r10) goto L_0x0092
                com.sumsub.sns.internal.core.common.State r9 = com.sumsub.sns.internal.core.common.State.DISCONNECTED     // Catch:{ all -> 0x0114 }
                r7.element = r9     // Catch:{ all -> 0x0114 }
            L_0x0092:
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0114 }
                r9.<init>()     // Catch:{ all -> 0x0114 }
                java.lang.String r10 = r2.f32052f     // Catch:{ all -> 0x0114 }
                r9.append(r10)     // Catch:{ all -> 0x0114 }
                com.sumsub.sns.internal.core.b<java.lang.String> r10 = r2.f32053g     // Catch:{ all -> 0x0114 }
                java.lang.Object r10 = r10.get()     // Catch:{ all -> 0x0114 }
                java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0114 }
                r9.append(r10)     // Catch:{ all -> 0x0114 }
                java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0114 }
                okhttp3.Request$Builder r10 = new okhttp3.Request$Builder     // Catch:{ all -> 0x0114 }
                r10.<init>()     // Catch:{ all -> 0x0114 }
                okhttp3.Request$Builder r9 = r10.url((java.lang.String) r9)     // Catch:{ all -> 0x0114 }
                okhttp3.Request r9 = r9.build()     // Catch:{ all -> 0x0114 }
                okhttp3.OkHttpClient r10 = r2.f32054h     // Catch:{ all -> 0x0114 }
                okhttp3.WebSocket r6 = r10.newWebSocket(r9, r8)     // Catch:{ all -> 0x0114 }
                r2.f32051e = r5     // Catch:{ all -> 0x0114 }
                r2.f32047a = r6     // Catch:{ all -> 0x0114 }
                r2.f32048b = r7     // Catch:{ all -> 0x0114 }
                r2.f32049c = r8     // Catch:{ all -> 0x0114 }
                r2.f32050d = r4     // Catch:{ all -> 0x0114 }
                kotlinx.coroutines.l r9 = new kotlinx.coroutines.l     // Catch:{ all -> 0x0114 }
                kotlin.coroutines.c r10 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.c(r2)     // Catch:{ all -> 0x0114 }
                r9.<init>(r10, r4)     // Catch:{ all -> 0x0114 }
                r9.A()     // Catch:{ all -> 0x0114 }
                r5.element = r9     // Catch:{ all -> 0x0114 }
                java.lang.Object r9 = r9.v()     // Catch:{ all -> 0x0114 }
                java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()     // Catch:{ all -> 0x0114 }
                if (r9 != r10) goto L_0x00e3
                kotlin.coroutines.jvm.internal.f.c(r2)     // Catch:{ all -> 0x0114 }
            L_0x00e3:
                if (r9 != r0) goto L_0x00e6
                return r0
            L_0x00e6:
                r16 = r7
                r7 = r5
                r5 = r16
            L_0x00eb:
                T r9 = r5.element     // Catch:{ all -> 0x0114 }
                com.sumsub.sns.internal.core.common.State r9 = (com.sumsub.sns.internal.core.common.State) r9     // Catch:{ all -> 0x0114 }
                boolean r9 = r9.isDisconnected()     // Catch:{ all -> 0x0114 }
                if (r9 != 0) goto L_0x0101
                com.sumsub.sns.core.c r10 = com.sumsub.sns.core.c.f30748a     // Catch:{ all -> 0x0114 }
                java.lang.String r11 = "webSocketFlow"
                java.lang.String r12 = "WebSocket flow delay reconnect"
                r13 = 0
                r14 = 4
                r15 = 0
                com.sumsub.sns.core.c.b(r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x0114 }
            L_0x0101:
                r9 = 10000(0x2710, double:4.9407E-320)
                r2.f32051e = r7     // Catch:{ all -> 0x0114 }
                r2.f32047a = r6     // Catch:{ all -> 0x0114 }
                r2.f32048b = r5     // Catch:{ all -> 0x0114 }
                r2.f32049c = r8     // Catch:{ all -> 0x0114 }
                r2.f32050d = r3     // Catch:{ all -> 0x0114 }
                java.lang.Object r9 = kotlinx.coroutines.DelayKt.b(r9, r2)     // Catch:{ all -> 0x0114 }
                if (r9 != r0) goto L_0x0025
                return r0
            L_0x0114:
                r0 = move-exception
                com.sumsub.sns.core.c r2 = com.sumsub.sns.core.c.f30748a
                r10 = 0
                r11 = 4
                r12 = 0
                java.lang.String r8 = "webSocketFlow"
                java.lang.String r9 = "WebSocket finalization"
                r7 = r2
                com.sumsub.sns.core.c.b(r7, r8, r9, r10, r11, r12)
                if (r6 == 0) goto L_0x012f
                r3 = 1000(0x3e8, float:1.401E-42)
                java.lang.String r4 = "finalization"
                boolean r3 = r6.close(r3, r4)
                kotlin.coroutines.jvm.internal.a.a(r3)
            L_0x012f:
                r10 = 0
                r11 = 4
                r12 = 0
                java.lang.String r8 = "webSocketFlow"
                java.lang.String r9 = "Stop WebSocket flow"
                r7 = r2
                com.sumsub.sns.core.c.b(r7, r8, r9, r10, r11, r12)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.common.e1.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final kotlinx.coroutines.flow.d<String> a(OkHttpClient okHttpClient, String str, b<String> bVar) {
        return f.e(new a(str, bVar, okHttpClient, (c<? super a>) null));
    }
}
