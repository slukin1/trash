package com.sumsub.sns.prooface.network;

import androidx.annotation.Keep;
import com.sumsub.sns.core.data.listener.TokenExpirationHandler;
import com.sumsub.sns.internal.core.common.SNSSession;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.g0;
import com.sumsub.sns.prooface.data.LivenessMessageType;
import com.sumsub.sns.prooface.data.h;
import com.sumsub.sns.prooface.data.i;
import com.sumsub.sns.prooface.data.j;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.k;
import kotlin.reflect.p;
import kotlinx.coroutines.h0;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public final class Liveness3dFaceRepository {

    /* renamed from: l  reason: collision with root package name */
    public static final b f40232l = new b((r) null);

    /* renamed from: m  reason: collision with root package name */
    public static final int f40233m = 4001;

    /* renamed from: n  reason: collision with root package name */
    public static final int f40234n = 4002;

    /* renamed from: o  reason: collision with root package name */
    public static final int f40235o = 3;

    /* renamed from: a  reason: collision with root package name */
    public final OkHttpClient f40236a;

    /* renamed from: b  reason: collision with root package name */
    public final String f40237b;

    /* renamed from: c  reason: collision with root package name */
    public final SNSSession f40238c;

    /* renamed from: d  reason: collision with root package name */
    public final kotlinx.serialization.json.a f40239d;

    /* renamed from: e  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.b<String> f40240e;

    /* renamed from: f  reason: collision with root package name */
    public int f40241f;

    /* renamed from: g  reason: collision with root package name */
    public WebSocket f40242g;

    /* renamed from: h  reason: collision with root package name */
    public a f40243h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f40244i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f40245j;

    /* renamed from: k  reason: collision with root package name */
    public final c f40246k = new c(this);

    @Keep
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\b\u0004\u0005\u0006\u0007\b\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0001\b\f\r\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/sumsub/sns/prooface/network/Liveness3dFaceRepository$LivenessRepositoryResult;", "", "<init>", "()V", "a", "b", "c", "d", "e", "f", "g", "h", "Lcom/sumsub/sns/prooface/network/Liveness3dFaceRepository$LivenessRepositoryResult$a;", "Lcom/sumsub/sns/prooface/network/Liveness3dFaceRepository$LivenessRepositoryResult$b;", "Lcom/sumsub/sns/prooface/network/Liveness3dFaceRepository$LivenessRepositoryResult$c;", "Lcom/sumsub/sns/prooface/network/Liveness3dFaceRepository$LivenessRepositoryResult$d;", "Lcom/sumsub/sns/prooface/network/Liveness3dFaceRepository$LivenessRepositoryResult$e;", "Lcom/sumsub/sns/prooface/network/Liveness3dFaceRepository$LivenessRepositoryResult$f;", "Lcom/sumsub/sns/prooface/network/Liveness3dFaceRepository$LivenessRepositoryResult$g;", "Lcom/sumsub/sns/prooface/network/Liveness3dFaceRepository$LivenessRepositoryResult$h;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public static abstract class LivenessRepositoryResult {

        public static final class a extends LivenessRepositoryResult {

            /* renamed from: a  reason: collision with root package name */
            public static final a f40247a = new a();

            public a() {
                super((r) null);
            }
        }

        public static final class b extends LivenessRepositoryResult {

            /* renamed from: a  reason: collision with root package name */
            public final j f40248a;

            public b(j jVar) {
                super((r) null);
                this.f40248a = jVar;
            }

            public final j a() {
                return this.f40248a;
            }
        }

        public static final class c extends LivenessRepositoryResult {

            /* renamed from: a  reason: collision with root package name */
            public final Throwable f40249a;

            public c(Throwable th2) {
                super((r) null);
                this.f40249a = th2;
            }

            public final Throwable a() {
                return this.f40249a;
            }
        }

        public static final class d extends LivenessRepositoryResult {

            /* renamed from: a  reason: collision with root package name */
            public final j f40250a;

            public d(j jVar) {
                super((r) null);
                this.f40250a = jVar;
            }

            public final j a() {
                return this.f40250a;
            }
        }

        public static final class e extends LivenessRepositoryResult {

            /* renamed from: a  reason: collision with root package name */
            public static final e f40251a = new e();

            public e() {
                super((r) null);
            }
        }

        public static final class f extends LivenessRepositoryResult {

            /* renamed from: a  reason: collision with root package name */
            public final j f40252a;

            public f(j jVar) {
                super((r) null);
                this.f40252a = jVar;
            }

            public final j a() {
                return this.f40252a;
            }
        }

        public static final class g extends LivenessRepositoryResult {

            /* renamed from: a  reason: collision with root package name */
            public final j f40253a;

            public g(j jVar) {
                super((r) null);
                this.f40253a = jVar;
            }

            public final j a() {
                return this.f40253a;
            }
        }

        public static final class h extends LivenessRepositoryResult {

            /* renamed from: a  reason: collision with root package name */
            public final String f40254a;

            public h(String str) {
                super((r) null);
                this.f40254a = str;
            }

            public final String a() {
                return this.f40254a;
            }
        }

        public /* synthetic */ LivenessRepositoryResult(r rVar) {
            this();
        }

        private LivenessRepositoryResult() {
        }
    }

    public interface a {
        void a(LivenessRepositoryResult livenessRepositoryResult);
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public b() {
        }
    }

    public static final class c extends WebSocketListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Liveness3dFaceRepository f40255a;

        public /* synthetic */ class a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f40256a;

            static {
                int[] iArr = new int[LivenessMessageType.values().length];
                iArr[LivenessMessageType.livenessSessionStarted.ordinal()] = 1;
                iArr[LivenessMessageType.livenessSessionInProgress.ordinal()] = 2;
                iArr[LivenessMessageType.livenessSessionCompleted.ordinal()] = 3;
                iArr[LivenessMessageType.livenessSessionTerminated.ordinal()] = 4;
                f40256a = iArr;
            }
        }

        public c(Liveness3dFaceRepository liveness3dFaceRepository) {
            this.f40255a = liveness3dFaceRepository;
        }

        public void onClosed(WebSocket webSocket, int i11, String str) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            String a11 = com.sumsub.sns.internal.log.c.a(this);
            com.sumsub.log.logger.a.a(aVar, a11, "Liveness3dFaceRepository.onClosed: code=" + i11 + " reason=" + str, (Throwable) null, 4, (Object) null);
            this.f40255a.f40245j = false;
        }

        public void onClosing(WebSocket webSocket, int i11, String str) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            String a11 = com.sumsub.sns.internal.log.c.a(this);
            com.sumsub.log.logger.a.a(aVar, a11, "Liveness3dFaceRepository.onClosing: code=" + i11 + " reason=" + str, (Throwable) null, 4, (Object) null);
            if (i11 == 4001 || i11 == 4002) {
                a b11 = this.f40255a.f40243h;
                if (b11 != null) {
                    b11.a(LivenessRepositoryResult.e.f40251a);
                }
                this.f40255a.d();
                return;
            }
            this.f40255a.f40244i = true;
        }

        public void onFailure(WebSocket webSocket, Throwable th2, Response response) {
            if (!this.f40255a.f40244i) {
                com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
                String a11 = com.sumsub.sns.internal.log.c.a(this);
                com.sumsub.log.logger.a.a(aVar, a11, "Liveness3dFaceRepository.onFailure: e=" + th2 + ' ', (Throwable) null, 4, (Object) null);
                a b11 = this.f40255a.f40243h;
                if (b11 != null) {
                    b11.a(new LivenessRepositoryResult.c(th2));
                }
            }
            this.f40255a.f40245j = false;
        }

        public void onMessage(WebSocket webSocket, String str) {
            try {
                kotlinx.serialization.json.a d11 = this.f40255a.f40239d;
                kotlinx.serialization.modules.d a11 = d11.a();
                p n11 = Reflection.n(h.class);
                MagicApiIntrinsics.a("kotlinx.serialization.serializer.withModule");
                h hVar = (h) d11.c(kotlinx.serialization.h.d(a11, n11), str);
                int i11 = a.f40256a[LivenessMessageType.Companion.a(hVar.i()).ordinal()];
                if (i11 == 1) {
                    this.f40255a.f40241f = 0;
                    a b11 = this.f40255a.f40243h;
                    if (b11 != null) {
                        b11.a(new LivenessRepositoryResult.f(hVar.e()));
                    }
                } else if (i11 == 2) {
                    a b12 = this.f40255a.f40243h;
                    if (b12 != null) {
                        b12.a(new LivenessRepositoryResult.d(hVar.e()));
                    }
                } else if (i11 == 3) {
                    a b13 = this.f40255a.f40243h;
                    if (b13 != null) {
                        b13.a(new LivenessRepositoryResult.b(hVar.e()));
                    }
                } else if (i11 != 4) {
                    a b14 = this.f40255a.f40243h;
                    if (b14 != null) {
                        b14.a(new LivenessRepositoryResult.h(str));
                    }
                } else {
                    a b15 = this.f40255a.f40243h;
                    if (b15 != null) {
                        b15.a(new LivenessRepositoryResult.g(hVar.e()));
                    }
                }
            } catch (Exception e11) {
                com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
                String a12 = com.sumsub.sns.internal.log.c.a(this);
                com.sumsub.sns.internal.log.b.b(aVar, a12, "Can't parse liveness message=" + str, e11);
                a b16 = this.f40255a.f40243h;
                if (b16 != null) {
                    b16.a(new LivenessRepositoryResult.c(e11));
                }
            }
        }

        public void onOpen(WebSocket webSocket, Response response) {
            this.f40255a.f40244i = false;
            this.f40255a.f40245j = true;
            Liveness3dFaceRepository liveness3dFaceRepository = this.f40255a;
            liveness3dFaceRepository.a(i.b(liveness3dFaceRepository.f40237b));
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.prooface.network.Liveness3dFaceRepository$updateToken$1$1", f = "Liveness3dFaceRepository.kt", l = {}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f40257a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f40258b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Liveness3dFaceRepository f40259c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Liveness3dFaceRepository liveness3dFaceRepository, kotlin.coroutines.c<? super d> cVar) {
            super(2, cVar);
            this.f40259c = liveness3dFaceRepository;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((d) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            d dVar = new d(this.f40259c, cVar);
            dVar.f40258b = obj;
            return dVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f40257a == 0) {
                k.b(obj);
                h0 h0Var = (h0) this.f40258b;
                String str = null;
                try {
                    TokenExpirationHandler tokenExpirationHandler = e0.f32018a.getTokenExpirationHandler();
                    if (tokenExpirationHandler != null) {
                        str = tokenExpirationHandler.onTokenExpired();
                    }
                } catch (Exception e11) {
                    com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
                    String a11 = com.sumsub.sns.internal.log.c.a(h0Var);
                    String message = e11.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    aVar.e(a11, message, e11);
                }
                boolean z11 = true;
                if (str == null || !g0.b(str)) {
                    z11 = false;
                }
                if (z11) {
                    com.sumsub.sns.internal.log.a aVar2 = com.sumsub.sns.internal.log.a.f34862a;
                    String a12 = com.sumsub.sns.internal.log.c.a(h0Var);
                    com.sumsub.log.logger.a.a(aVar2, a12, "Liveness3dFaceRepository.New token is available. Token is " + str, (Throwable) null, 4, (Object) null);
                    this.f40259c.f40240e.a(str);
                    this.f40259c.a();
                }
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public Liveness3dFaceRepository(OkHttpClient okHttpClient, String str, SNSSession sNSSession, kotlinx.serialization.json.a aVar, com.sumsub.sns.internal.core.b<String> bVar) {
        this.f40236a = okHttpClient;
        this.f40237b = str;
        this.f40238c = sNSSession;
        this.f40239d = aVar;
        this.f40240e = bVar;
    }

    public final boolean c() {
        return this.f40245j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0052, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0053, code lost:
        kotlin.io.b.a(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0056, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
            r7 = this;
            com.sumsub.sns.internal.log.a r6 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r1 = com.sumsub.sns.internal.log.c.a(r7)
            java.lang.String r2 = "Liveness3dFaceRepository.updateToken"
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r6
            com.sumsub.log.logger.a.a(r0, r1, r2, r3, r4, r5)
            int r0 = r7.f40241f
            r1 = 1
            int r0 = r0 + r1
            r7.f40241f = r0
            r2 = 3
            if (r0 <= r2) goto L_0x0039
            java.lang.String r1 = com.sumsub.sns.internal.log.c.a(r7)
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r2 = "Liveness3dFaceRepository. Max reconnect attempts reached"
            r0 = r6
            com.sumsub.log.logger.a.a(r0, r1, r2, r3, r4, r5)
            com.sumsub.sns.prooface.network.Liveness3dFaceRepository$a r0 = r7.f40243h
            if (r0 == 0) goto L_0x0038
            com.sumsub.sns.prooface.network.Liveness3dFaceRepository$LivenessRepositoryResult$c r1 = new com.sumsub.sns.prooface.network.Liveness3dFaceRepository$LivenessRepositoryResult$c
            java.lang.Exception r2 = new java.lang.Exception
            java.lang.String r3 = "Invalid access token"
            r2.<init>(r3)
            r1.<init>(r2)
            r0.a(r1)
        L_0x0038:
            return
        L_0x0039:
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.newSingleThreadExecutor()
            kotlinx.coroutines.ExecutorCoroutineDispatcher r0 = kotlinx.coroutines.f1.b(r0)
            com.sumsub.sns.prooface.network.Liveness3dFaceRepository$d r2 = new com.sumsub.sns.prooface.network.Liveness3dFaceRepository$d     // Catch:{ all -> 0x0050 }
            r3 = 0
            r2.<init>(r7, r3)     // Catch:{ all -> 0x0050 }
            java.lang.Object unused = kotlinx.coroutines.h.b(r3, r2, r1, r3)     // Catch:{ all -> 0x0050 }
            kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0050 }
            kotlin.io.b.a(r0, r3)
            return
        L_0x0050:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0052 }
        L_0x0052:
            r2 = move-exception
            kotlin.io.b.a(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.prooface.network.Liveness3dFaceRepository.d():void");
    }

    public final void b() {
        com.sumsub.log.logger.a.a(com.sumsub.sns.internal.log.a.f34862a, com.sumsub.sns.internal.log.c.a(this), "Liveness3dFaceRepository.disconnect", (Throwable) null, 4, (Object) null);
        WebSocket webSocket = this.f40242g;
        if (webSocket != null) {
            webSocket.close(1000, "disconnect");
        }
        this.f40242g = null;
    }

    public final void a(a aVar) {
        this.f40241f = 0;
        this.f40243h = aVar;
        a();
    }

    public final void a(h hVar) {
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        String a11 = com.sumsub.sns.internal.log.c.a(this);
        com.sumsub.log.logger.a.a(aVar, a11, "Liveness3dFaceRepository.send: " + hVar.i() + " isClosed=" + this.f40244i, (Throwable) null, 4, (Object) null);
        if (!this.f40244i) {
            WebSocket webSocket = this.f40242g;
            if (webSocket != null) {
                kotlinx.serialization.json.a aVar2 = this.f40239d;
                kotlinx.serialization.modules.d a12 = aVar2.a();
                p n11 = Reflection.n(h.class);
                MagicApiIntrinsics.a("kotlinx.serialization.serializer.withModule");
                webSocket.send(aVar2.b(kotlinx.serialization.h.d(a12, n11), hVar));
                return;
            }
            a aVar3 = this.f40243h;
            if (aVar3 != null) {
                aVar3.a(LivenessRepositoryResult.a.f40247a);
            }
        }
    }

    public final void a() {
        try {
            com.sumsub.log.logger.a.a(com.sumsub.sns.internal.log.a.f34862a, com.sumsub.sns.internal.log.c.a(this), "Liveness3dFaceRepository.newWebSocket", (Throwable) null, 4, (Object) null);
            WebSocket webSocket = this.f40242g;
            if (webSocket != null) {
                webSocket.close(1000, "reconnect");
            }
            this.f40242g = null;
            Request.Builder builder = new Request.Builder();
            this.f40242g = this.f40236a.newWebSocket(builder.url(this.f40238c.getUrl() + "ws/liveness?token=" + this.f40238c.getAccessToken()).build(), this.f40246k);
        } catch (Exception e11) {
            a aVar = this.f40243h;
            if (aVar != null) {
                aVar.a(new LivenessRepositoryResult.c(e11));
            }
        }
    }
}
