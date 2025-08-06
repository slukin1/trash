package com.sumsub.sns.internal.core.data.source.applicant.remote;

import com.sumsub.sns.internal.core.common.e1;
import com.sumsub.sns.internal.core.common.x;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.IdentitySide;
import com.sumsub.sns.internal.core.data.model.SNSMessage;
import com.sumsub.sns.internal.core.data.model.g;
import com.sumsub.sns.internal.core.data.model.remote.response.d;
import com.sumsub.sns.internal.core.data.source.applicant.remote.utils.a;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.reflect.p;
import kotlin.reflect.q;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

public final class d implements com.sumsub.sns.internal.core.data.source.applicant.a {

    /* renamed from: f  reason: collision with root package name */
    public static final a f33083f = new a((r) null);

    /* renamed from: g  reason: collision with root package name */
    public static final String f33084g = "ApplicantDataSource";

    /* renamed from: a  reason: collision with root package name */
    public final e f33085a;

    /* renamed from: b  reason: collision with root package name */
    public final c f33086b;

    /* renamed from: c  reason: collision with root package name */
    public final OkHttpClient f33087c;

    /* renamed from: d  reason: collision with root package name */
    public final String f33088d;

    /* renamed from: e  reason: collision with root package name */
    public final kotlinx.serialization.json.a f33089e = x.a(false, 1, (Object) null);

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public a() {
        }
    }

    public static final class b implements kotlinx.coroutines.flow.d<SNSMessage.ServerMessage> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.flow.d f33090a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f33091b;

        public static final class a<T> implements kotlinx.coroutines.flow.e {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ kotlinx.coroutines.flow.e f33092a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d f33093b;

            @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.applicant.remote.ApplicantRemoteDataSource$applicantState$$inlined$map$1$2", f = "ApplicantRemoteDataSource.kt", l = {224}, m = "emit")
            /* renamed from: com.sumsub.sns.internal.core.data.source.applicant.remote.d$b$a$a  reason: collision with other inner class name */
            public static final class C0359a extends ContinuationImpl {

                /* renamed from: a  reason: collision with root package name */
                public /* synthetic */ Object f33094a;

                /* renamed from: b  reason: collision with root package name */
                public int f33095b;

                /* renamed from: c  reason: collision with root package name */
                public Object f33096c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ a f33097d;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0359a(a aVar, kotlin.coroutines.c cVar) {
                    super(cVar);
                    this.f33097d = aVar;
                }

                public final Object invokeSuspend(Object obj) {
                    this.f33094a = obj;
                    this.f33095b |= Integer.MIN_VALUE;
                    return this.f33097d.emit((Object) null, this);
                }
            }

            public a(kotlinx.coroutines.flow.e eVar, d dVar) {
                this.f33092a = eVar;
                this.f33093b = dVar;
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.c r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof com.sumsub.sns.internal.core.data.source.applicant.remote.d.b.a.C0359a
                    if (r0 == 0) goto L_0x0013
                    r0 = r7
                    com.sumsub.sns.internal.core.data.source.applicant.remote.d$b$a$a r0 = (com.sumsub.sns.internal.core.data.source.applicant.remote.d.b.a.C0359a) r0
                    int r1 = r0.f33095b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f33095b = r1
                    goto L_0x0018
                L_0x0013:
                    com.sumsub.sns.internal.core.data.source.applicant.remote.d$b$a$a r0 = new com.sumsub.sns.internal.core.data.source.applicant.remote.d$b$a$a
                    r0.<init>(r5, r7)
                L_0x0018:
                    java.lang.Object r7 = r0.f33094a
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r2 = r0.f33095b
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    kotlin.k.b(r7)
                    goto L_0x004d
                L_0x0029:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L_0x0031:
                    kotlin.k.b(r7)
                    kotlinx.coroutines.flow.e r7 = r5.f33092a
                    java.lang.String r6 = (java.lang.String) r6
                    com.sumsub.sns.internal.core.data.model.SNSMessage$ServerMessage$j r2 = com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.Companion
                    com.sumsub.sns.internal.core.data.source.applicant.remote.d r4 = r5.f33093b
                    kotlinx.serialization.json.a r4 = r4.f33089e
                    com.sumsub.sns.internal.core.data.model.SNSMessage$ServerMessage r6 = r2.a(r4, r6)
                    r0.f33095b = r3
                    java.lang.Object r6 = r7.emit(r6, r0)
                    if (r6 != r1) goto L_0x004d
                    return r1
                L_0x004d:
                    kotlin.Unit r6 = kotlin.Unit.f56620a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.remote.d.b.a.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
            }
        }

        public b(kotlinx.coroutines.flow.d dVar, d dVar2) {
            this.f33090a = dVar;
            this.f33091b = dVar2;
        }

        public Object collect(kotlinx.coroutines.flow.e eVar, kotlin.coroutines.c cVar) {
            Object collect = this.f33090a.collect(new a(eVar, this.f33091b), cVar);
            if (collect == IntrinsicsKt__IntrinsicsKt.d()) {
                return collect;
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.applicant.remote.ApplicantRemoteDataSource", f = "ApplicantRemoteDataSource.kt", l = {264}, m = "availableLanguages")
    public static final class c extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f33098a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f33099b;

        /* renamed from: c  reason: collision with root package name */
        public int f33100c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(d dVar, kotlin.coroutines.c<? super c> cVar) {
            super(cVar);
            this.f33099b = dVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33098a = obj;
            this.f33100c |= Integer.MIN_VALUE;
            return this.f33099b.a((kotlin.coroutines.c<? super List<n>>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.applicant.remote.ApplicantRemoteDataSource", f = "ApplicantRemoteDataSource.kt", l = {241}, m = "getApplicantAddress")
    /* renamed from: com.sumsub.sns.internal.core.data.source.applicant.remote.d$d  reason: collision with other inner class name */
    public static final class C0360d extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f33101a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f33102b;

        /* renamed from: c  reason: collision with root package name */
        public int f33103c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0360d(d dVar, kotlin.coroutines.c<? super C0360d> cVar) {
            super(cVar);
            this.f33102b = dVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33101a = obj;
            this.f33103c |= Integer.MIN_VALUE;
            return this.f33102b.e((String) null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.applicant.remote.ApplicantRemoteDataSource", f = "ApplicantRemoteDataSource.kt", l = {290}, m = "postAgreement")
    public static final class e extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f33104a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f33105b;

        /* renamed from: c  reason: collision with root package name */
        public int f33106c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(d dVar, kotlin.coroutines.c<? super e> cVar) {
            super(cVar);
            this.f33105b = dVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33104a = obj;
            this.f33106c |= Integer.MIN_VALUE;
            return this.f33105b.a((String) null, (com.sumsub.sns.internal.core.data.model.b) null, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.applicant.remote.ApplicantRemoteDataSource", f = "ApplicantRemoteDataSource.kt", l = {294}, m = "postAgreementForAction")
    public static final class f extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f33107a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f33108b;

        /* renamed from: c  reason: collision with root package name */
        public int f33109c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(d dVar, kotlin.coroutines.c<? super f> cVar) {
            super(cVar);
            this.f33108b = dVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33107a = obj;
            this.f33109c |= Integer.MIN_VALUE;
            return this.f33108b.b((String) null, (com.sumsub.sns.internal.core.data.model.b) null, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.applicant.remote.ApplicantRemoteDataSource", f = "ApplicantRemoteDataSource.kt", l = {170}, m = "setCustomFields")
    public static final class g extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f33110a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f33111b;

        /* renamed from: c  reason: collision with root package name */
        public int f33112c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(d dVar, kotlin.coroutines.c<? super g> cVar) {
            super(cVar);
            this.f33111b = dVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33110a = obj;
            this.f33112c |= Integer.MIN_VALUE;
            return this.f33111b.a((String) null, (String) null, (String) null, (List<com.sumsub.sns.internal.core.data.model.remote.e>) null, (List<String>) null, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.applicant.remote.ApplicantRemoteDataSource", f = "ApplicantRemoteDataSource.kt", l = {156}, m = "setFields")
    public static final class h extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f33113a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f33114b;

        /* renamed from: c  reason: collision with root package name */
        public int f33115c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(d dVar, kotlin.coroutines.c<? super h> cVar) {
            super(cVar);
            this.f33114b = dVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33113a = obj;
            this.f33115c |= Integer.MIN_VALUE;
            return this.f33114b.a((String) null, (Map<String, ? extends Object>) null, (List<String>) null, (kotlin.coroutines.c<? super g.a>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.applicant.remote.ApplicantRemoteDataSource", f = "ApplicantRemoteDataSource.kt", l = {133}, m = "setPending")
    public static final class i extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f33116a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f33117b;

        /* renamed from: c  reason: collision with root package name */
        public int f33118c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(d dVar, kotlin.coroutines.c<? super i> cVar) {
            super(cVar);
            this.f33117b = dVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33116a = obj;
            this.f33118c |= Integer.MIN_VALUE;
            return this.f33117b.a((String) null, (kotlin.coroutines.c<? super Boolean>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.applicant.remote.ApplicantRemoteDataSource", f = "ApplicantRemoteDataSource.kt", l = {60}, m = "uploadFile")
    public static final class j extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f33119a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f33120b;

        /* renamed from: c  reason: collision with root package name */
        public int f33121c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(d dVar, kotlin.coroutines.c<? super j> cVar) {
            super(cVar);
            this.f33120b = dVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33119a = obj;
            this.f33121c |= Integer.MIN_VALUE;
            return this.f33120b.a((String) null, (String) null, (InputStream) null, (String) null, (IdentitySide) null, (Map<String, String>) null, (DocumentType) null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.applicant.remote.ApplicantRemoteDataSource", f = "ApplicantRemoteDataSource.kt", l = {102}, m = "uploadFile")
    public static final class k extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f33122a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f33123b;

        /* renamed from: c  reason: collision with root package name */
        public int f33124c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(d dVar, kotlin.coroutines.c<? super k> cVar) {
            super(cVar);
            this.f33123b = dVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33122a = obj;
            this.f33124c |= Integer.MIN_VALUE;
            return this.f33123b.a((String) null, (String) null, (File) null, (String) null, (IdentitySide) null, (Map<String, String>) null, (DocumentType) null, (a.C0361a) null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.applicant.remote.ApplicantRemoteDataSource", f = "ApplicantRemoteDataSource.kt", l = {80}, m = "uploadFileForAction")
    public static final class l extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f33125a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f33126b;

        /* renamed from: c  reason: collision with root package name */
        public int f33127c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(d dVar, kotlin.coroutines.c<? super l> cVar) {
            super(cVar);
            this.f33126b = dVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33125a = obj;
            this.f33127c |= Integer.MIN_VALUE;
            return this.f33126b.b((String) null, (String) null, (InputStream) null, (String) null, (IdentitySide) null, (Map<String, String>) null, (DocumentType) null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.applicant.remote.ApplicantRemoteDataSource", f = "ApplicantRemoteDataSource.kt", l = {124}, m = "uploadFileForAction")
    public static final class m extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f33128a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f33129b;

        /* renamed from: c  reason: collision with root package name */
        public int f33130c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(d dVar, kotlin.coroutines.c<? super m> cVar) {
            super(cVar);
            this.f33129b = dVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33128a = obj;
            this.f33130c |= Integer.MIN_VALUE;
            return this.f33129b.b((String) null, (String) null, (File) null, (String) null, (IdentitySide) null, (Map<String, String>) null, (DocumentType) null, (a.C0361a) null, this);
        }
    }

    public d(e eVar, c cVar, OkHttpClient okHttpClient, String str) {
        this.f33085a = eVar;
        this.f33086b = cVar;
        this.f33087c = okHttpClient;
        this.f33088d = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object b(java.lang.String r17, java.lang.String r18, java.io.InputStream r19, java.lang.String r20, com.sumsub.sns.internal.core.data.model.IdentitySide r21, java.util.Map<java.lang.String, java.lang.String> r22, com.sumsub.sns.internal.core.data.model.DocumentType r23, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.remote.k> r24) {
        /*
            r16 = this;
            r0 = r16
            r1 = r24
            boolean r2 = r1 instanceof com.sumsub.sns.internal.core.data.source.applicant.remote.d.l
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.sumsub.sns.internal.core.data.source.applicant.remote.d$l r2 = (com.sumsub.sns.internal.core.data.source.applicant.remote.d.l) r2
            int r3 = r2.f33127c
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f33127c = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.core.data.source.applicant.remote.d$l r2 = new com.sumsub.sns.internal.core.data.source.applicant.remote.d$l
            r2.<init>(r0, r1)
        L_0x001c:
            r9 = r2
            java.lang.Object r1 = r9.f33125a
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r3 = r9.f33127c
            r4 = 1
            if (r3 == 0) goto L_0x0036
            if (r3 != r4) goto L_0x002e
            kotlin.k.b(r1)
            goto L_0x0082
        L_0x002e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0036:
            kotlin.k.b(r1)
            okhttp3.MultipartBody$Part r5 = com.sumsub.sns.internal.core.data.source.applicant.remote.utils.c.a((java.io.InputStream) r19)
            r1 = r18
            r3 = r20
            r6 = r21
            okhttp3.RequestBody r6 = com.sumsub.sns.internal.core.data.source.applicant.remote.utils.c.a(r1, r3, r6)
            com.sumsub.sns.internal.log.a r10 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "uploadFileForAction: meta="
            r1.append(r3)
            r1.append(r6)
            java.lang.String r3 = ", file="
            r1.append(r3)
            r1.append(r5)
            java.lang.String r12 = r1.toString()
            r13 = 0
            r14 = 4
            r15 = 0
            java.lang.String r11 = "ApplicantRemoteDataSource"
            com.sumsub.log.logger.a.a(r10, r11, r12, r13, r14, r15)
            com.sumsub.sns.internal.core.data.source.applicant.remote.c r3 = r0.f33086b
            if (r23 == 0) goto L_0x0073
            java.lang.String r1 = r23.c()
            goto L_0x0074
        L_0x0073:
            r1 = 0
        L_0x0074:
            r8 = r1
            r9.f33127c = r4
            r4 = r17
            r7 = r22
            java.lang.Object r1 = r3.b(r4, r5, r6, r7, r8, r9)
            if (r1 != r2) goto L_0x0082
            return r2
        L_0x0082:
            retrofit2.Response r1 = (retrofit2.Response) r1
            com.sumsub.sns.internal.core.data.model.remote.k r1 = com.sumsub.sns.internal.core.data.source.applicant.remote.utils.c.a((retrofit2.Response<com.sumsub.sns.internal.core.data.model.remote.l>) r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.remote.d.b(java.lang.String, java.lang.String, java.io.InputStream, java.lang.String, com.sumsub.sns.internal.core.data.model.IdentitySide, java.util.Map, com.sumsub.sns.internal.core.data.model.DocumentType, kotlin.coroutines.c):java.lang.Object");
    }

    public Object c(String str, kotlin.coroutines.c<? super h0> cVar) {
        return this.f33085a.c(str, cVar);
    }

    public Object d(String str, kotlin.coroutines.c<? super d0> cVar) {
        return this.f33085a.d(str, cVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object e(java.lang.String r5, kotlin.coroutines.c<? super java.util.Map<java.lang.String, ? extends java.lang.Object>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.sumsub.sns.internal.core.data.source.applicant.remote.d.C0360d
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.sumsub.sns.internal.core.data.source.applicant.remote.d$d r0 = (com.sumsub.sns.internal.core.data.source.applicant.remote.d.C0360d) r0
            int r1 = r0.f33103c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33103c = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.applicant.remote.d$d r0 = new com.sumsub.sns.internal.core.data.source.applicant.remote.d$d
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f33101a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33103c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.k.b(r6)
            goto L_0x003f
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.k.b(r6)
            com.sumsub.sns.internal.core.data.source.applicant.remote.e r6 = r4.f33085a
            r0.f33103c = r3
            java.lang.Object r6 = r6.e(r5, r0)
            if (r6 != r1) goto L_0x003f
            return r1
        L_0x003f:
            com.sumsub.sns.internal.core.data.model.remote.response.d$c$d r6 = (com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0351d) r6
            com.sumsub.sns.internal.core.data.model.remote.response.d$c$c r5 = r6.M()
            if (r5 == 0) goto L_0x0054
            java.util.List r5 = r5.n()
            if (r5 == 0) goto L_0x0054
            java.lang.Object r5 = kotlin.collections.CollectionsKt___CollectionsKt.c0(r5)
            java.util.Map r5 = (java.util.Map) r5
            goto L_0x0055
        L_0x0054:
            r5 = 0
        L_0x0055:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.remote.d.e(java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    public Object f(String str, kotlin.coroutines.c<? super d.c.C0351d> cVar) {
        return this.f33085a.f(str, cVar);
    }

    public Object g(String str, kotlin.coroutines.c<? super w> cVar) {
        return this.f33085a.g(str, cVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(java.lang.String r22, java.lang.String r23, java.io.InputStream r24, java.lang.String r25, com.sumsub.sns.internal.core.data.model.IdentitySide r26, java.util.Map<java.lang.String, java.lang.String> r27, com.sumsub.sns.internal.core.data.model.DocumentType r28, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.remote.k> r29) {
        /*
            r21 = this;
            r0 = r21
            r1 = r29
            boolean r2 = r1 instanceof com.sumsub.sns.internal.core.data.source.applicant.remote.d.j
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.sumsub.sns.internal.core.data.source.applicant.remote.d$j r2 = (com.sumsub.sns.internal.core.data.source.applicant.remote.d.j) r2
            int r3 = r2.f33121c
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f33121c = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.core.data.source.applicant.remote.d$j r2 = new com.sumsub.sns.internal.core.data.source.applicant.remote.d$j
            r2.<init>(r0, r1)
        L_0x001c:
            r9 = r2
            java.lang.Object r1 = r9.f33119a
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r3 = r9.f33121c
            r10 = 0
            r4 = 1
            if (r3 == 0) goto L_0x0037
            if (r3 != r4) goto L_0x002f
            kotlin.k.b(r1)
            goto L_0x0084
        L_0x002f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0037:
            kotlin.k.b(r1)
            okhttp3.MultipartBody$Part r5 = com.sumsub.sns.internal.core.data.source.applicant.remote.utils.c.a((java.io.InputStream) r24)
            r1 = r23
            r3 = r25
            r6 = r26
            okhttp3.RequestBody r6 = com.sumsub.sns.internal.core.data.source.applicant.remote.utils.c.a(r1, r3, r6)
            com.sumsub.sns.internal.log.a r11 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "uploadFile: meta="
            r1.append(r3)
            r1.append(r6)
            java.lang.String r3 = ", file="
            r1.append(r3)
            r1.append(r5)
            java.lang.String r13 = r1.toString()
            r14 = 0
            r15 = 4
            r16 = 0
            java.lang.String r12 = "ApplicantRemoteDataSource"
            com.sumsub.log.logger.a.a(r11, r12, r13, r14, r15, r16)
            com.sumsub.sns.internal.core.data.source.applicant.remote.c r3 = r0.f33086b
            if (r28 == 0) goto L_0x0076
            java.lang.String r1 = r28.c()
            r8 = r1
            goto L_0x0077
        L_0x0076:
            r8 = r10
        L_0x0077:
            r9.f33121c = r4
            r4 = r22
            r7 = r27
            java.lang.Object r1 = r3.a(r4, r5, r6, r7, r8, r9)
            if (r1 != r2) goto L_0x0084
            return r2
        L_0x0084:
            retrofit2.Response r1 = (retrofit2.Response) r1
            okhttp3.Headers r2 = r1.headers()
            java.lang.String r3 = "X-Image-Id"
            java.lang.String r18 = r2.get(r3)
            if (r18 == 0) goto L_0x00ad
            java.lang.Object r2 = r1.body()
            r11 = r2
            com.sumsub.sns.internal.core.data.model.remote.k r11 = (com.sumsub.sns.internal.core.data.model.remote.k) r11
            if (r11 == 0) goto L_0x00ab
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r19 = 63
            r20 = 0
            com.sumsub.sns.internal.core.data.model.remote.k r10 = com.sumsub.sns.internal.core.data.model.remote.k.a(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
        L_0x00ab:
            if (r10 != 0) goto L_0x00b4
        L_0x00ad:
            java.lang.Object r1 = r1.body()
            r10 = r1
            com.sumsub.sns.internal.core.data.model.remote.k r10 = (com.sumsub.sns.internal.core.data.model.remote.k) r10
        L_0x00b4:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.remote.d.a(java.lang.String, java.lang.String, java.io.InputStream, java.lang.String, com.sumsub.sns.internal.core.data.model.IdentitySide, java.util.Map, com.sumsub.sns.internal.core.data.model.DocumentType, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object b(java.lang.String r18, java.lang.String r19, java.io.File r20, java.lang.String r21, com.sumsub.sns.internal.core.data.model.IdentitySide r22, java.util.Map<java.lang.String, java.lang.String> r23, com.sumsub.sns.internal.core.data.model.DocumentType r24, com.sumsub.sns.internal.core.data.source.applicant.remote.utils.a.C0361a r25, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.remote.k> r26) {
        /*
            r17 = this;
            r0 = r17
            r1 = r20
            r2 = r26
            boolean r3 = r2 instanceof com.sumsub.sns.internal.core.data.source.applicant.remote.d.m
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.sumsub.sns.internal.core.data.source.applicant.remote.d$m r3 = (com.sumsub.sns.internal.core.data.source.applicant.remote.d.m) r3
            int r4 = r3.f33130c
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f33130c = r4
            goto L_0x001e
        L_0x0019:
            com.sumsub.sns.internal.core.data.source.applicant.remote.d$m r3 = new com.sumsub.sns.internal.core.data.source.applicant.remote.d$m
            r3.<init>(r0, r2)
        L_0x001e:
            r10 = r3
            java.lang.Object r2 = r10.f33128a
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r10.f33130c
            r5 = 1
            if (r4 == 0) goto L_0x0038
            if (r4 != r5) goto L_0x0030
            kotlin.k.b(r2)
            goto L_0x0092
        L_0x0030:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0038:
            kotlin.k.b(r2)
            com.sumsub.sns.internal.core.data.source.applicant.remote.utils.a r2 = new com.sumsub.sns.internal.core.data.source.applicant.remote.utils.a
            r4 = 0
            r6 = r25
            r2.<init>(r1, r4, r6)
            okhttp3.MultipartBody$Part r6 = com.sumsub.sns.internal.core.data.source.applicant.remote.utils.c.a((java.io.File) r1, (okhttp3.RequestBody) r2)
            r2 = r19
            r7 = r21
            r8 = r22
            okhttp3.RequestBody r7 = com.sumsub.sns.internal.core.data.source.applicant.remote.utils.c.a(r2, r7, r8)
            com.sumsub.sns.internal.log.a r11 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r8 = "uploadFileForAction: meta="
            r2.append(r8)
            r2.append(r7)
            java.lang.String r8 = ", file="
            r2.append(r8)
            java.lang.String r1 = r20.getName()
            r2.append(r1)
            java.lang.String r13 = r2.toString()
            r14 = 0
            r15 = 4
            r16 = 0
            java.lang.String r12 = "ApplicantDataSource"
            com.sumsub.log.logger.a.a(r11, r12, r13, r14, r15, r16)
            com.sumsub.sns.internal.core.data.source.applicant.remote.c r1 = r0.f33086b
            if (r24 == 0) goto L_0x0083
            java.lang.String r2 = r24.c()
            r9 = r2
            goto L_0x0084
        L_0x0083:
            r9 = r4
        L_0x0084:
            r10.f33130c = r5
            r4 = r1
            r5 = r18
            r8 = r23
            java.lang.Object r2 = r4.b(r5, r6, r7, r8, r9, r10)
            if (r2 != r3) goto L_0x0092
            return r3
        L_0x0092:
            retrofit2.Response r2 = (retrofit2.Response) r2
            com.sumsub.sns.internal.core.data.model.remote.k r1 = com.sumsub.sns.internal.core.data.source.applicant.remote.utils.c.a((retrofit2.Response<com.sumsub.sns.internal.core.data.model.remote.l>) r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.remote.d.b(java.lang.String, java.lang.String, java.io.File, java.lang.String, com.sumsub.sns.internal.core.data.model.IdentitySide, java.util.Map, com.sumsub.sns.internal.core.data.model.DocumentType, com.sumsub.sns.internal.core.data.source.applicant.remote.utils.a$a, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(java.lang.String r23, java.lang.String r24, java.io.File r25, java.lang.String r26, com.sumsub.sns.internal.core.data.model.IdentitySide r27, java.util.Map<java.lang.String, java.lang.String> r28, com.sumsub.sns.internal.core.data.model.DocumentType r29, com.sumsub.sns.internal.core.data.source.applicant.remote.utils.a.C0361a r30, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.remote.k> r31) {
        /*
            r22 = this;
            r0 = r22
            r1 = r25
            r2 = r31
            boolean r3 = r2 instanceof com.sumsub.sns.internal.core.data.source.applicant.remote.d.k
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.sumsub.sns.internal.core.data.source.applicant.remote.d$k r3 = (com.sumsub.sns.internal.core.data.source.applicant.remote.d.k) r3
            int r4 = r3.f33124c
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f33124c = r4
            goto L_0x001e
        L_0x0019:
            com.sumsub.sns.internal.core.data.source.applicant.remote.d$k r3 = new com.sumsub.sns.internal.core.data.source.applicant.remote.d$k
            r3.<init>(r0, r2)
        L_0x001e:
            r10 = r3
            java.lang.Object r2 = r10.f33122a
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r10.f33124c
            r5 = 1
            r11 = 0
            if (r4 == 0) goto L_0x0039
            if (r4 != r5) goto L_0x0031
            kotlin.k.b(r2)
            goto L_0x0092
        L_0x0031:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0039:
            kotlin.k.b(r2)
            com.sumsub.sns.internal.core.data.source.applicant.remote.utils.a r2 = new com.sumsub.sns.internal.core.data.source.applicant.remote.utils.a
            r4 = r30
            r2.<init>(r1, r11, r4)
            okhttp3.MultipartBody$Part r6 = com.sumsub.sns.internal.core.data.source.applicant.remote.utils.c.a((java.io.File) r1, (okhttp3.RequestBody) r2)
            r2 = r24
            r4 = r26
            r7 = r27
            okhttp3.RequestBody r7 = com.sumsub.sns.internal.core.data.source.applicant.remote.utils.c.a(r2, r4, r7)
            com.sumsub.sns.internal.log.a r12 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "uploadFile: meta="
            r2.append(r4)
            r2.append(r7)
            java.lang.String r4 = ", file="
            r2.append(r4)
            java.lang.String r1 = r25.getName()
            r2.append(r1)
            java.lang.String r14 = r2.toString()
            r15 = 0
            r16 = 4
            r17 = 0
            java.lang.String r13 = "ApplicantRemoteDataSource"
            com.sumsub.log.logger.a.a(r12, r13, r14, r15, r16, r17)
            com.sumsub.sns.internal.core.data.source.applicant.remote.c r4 = r0.f33086b
            if (r29 == 0) goto L_0x0084
            java.lang.String r1 = r29.c()
            r9 = r1
            goto L_0x0085
        L_0x0084:
            r9 = r11
        L_0x0085:
            r10.f33124c = r5
            r5 = r23
            r8 = r28
            java.lang.Object r2 = r4.a(r5, r6, r7, r8, r9, r10)
            if (r2 != r3) goto L_0x0092
            return r3
        L_0x0092:
            retrofit2.Response r2 = (retrofit2.Response) r2
            okhttp3.Headers r1 = r2.headers()
            java.lang.String r3 = "X-Image-Id"
            java.lang.String r19 = r1.get(r3)
            if (r19 == 0) goto L_0x00bc
            java.lang.Object r1 = r2.body()
            r12 = r1
            com.sumsub.sns.internal.core.data.model.remote.k r12 = (com.sumsub.sns.internal.core.data.model.remote.k) r12
            if (r12 == 0) goto L_0x00ba
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r20 = 63
            r21 = 0
            com.sumsub.sns.internal.core.data.model.remote.k r11 = com.sumsub.sns.internal.core.data.model.remote.k.a(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
        L_0x00ba:
            if (r11 != 0) goto L_0x00c3
        L_0x00bc:
            java.lang.Object r1 = r2.body()
            r11 = r1
            com.sumsub.sns.internal.core.data.model.remote.k r11 = (com.sumsub.sns.internal.core.data.model.remote.k) r11
        L_0x00c3:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.remote.d.a(java.lang.String, java.lang.String, java.io.File, java.lang.String, com.sumsub.sns.internal.core.data.model.IdentitySide, java.util.Map, com.sumsub.sns.internal.core.data.model.DocumentType, com.sumsub.sns.internal.core.data.source.applicant.remote.utils.a$a, kotlin.coroutines.c):java.lang.Object");
    }

    public Object b(String str, int i11, kotlin.coroutines.c<? super Unit> cVar) {
        Object b11 = this.f33086b.b(str, i11, cVar);
        return b11 == IntrinsicsKt__IntrinsicsKt.d() ? b11 : Unit.f56620a;
    }

    public Object a(String str, int i11, kotlin.coroutines.c<? super Unit> cVar) {
        Object a11 = this.f33086b.a(str, i11, cVar);
        return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Unit.f56620a;
    }

    public Object b(String str, a0 a0Var, kotlin.coroutines.c<? super b0> cVar) {
        return this.f33085a.b(str, a0Var, cVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(java.lang.String r5, kotlin.coroutines.c<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.sumsub.sns.internal.core.data.source.applicant.remote.d.i
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.sumsub.sns.internal.core.data.source.applicant.remote.d$i r0 = (com.sumsub.sns.internal.core.data.source.applicant.remote.d.i) r0
            int r1 = r0.f33118c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33118c = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.applicant.remote.d$i r0 = new com.sumsub.sns.internal.core.data.source.applicant.remote.d$i
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f33116a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33118c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.k.b(r6)
            goto L_0x003f
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.k.b(r6)
            com.sumsub.sns.internal.core.data.source.applicant.remote.e r6 = r4.f33085a
            r0.f33118c = r3
            java.lang.Object r6 = r6.a((java.lang.String) r5, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.applicant.remote.g>) r0)
            if (r6 != r1) goto L_0x003f
            return r1
        L_0x003f:
            com.sumsub.sns.internal.core.data.source.applicant.remote.g r6 = (com.sumsub.sns.internal.core.data.source.applicant.remote.g) r6
            java.lang.Integer r5 = r6.k()
            if (r5 != 0) goto L_0x0048
            goto L_0x004f
        L_0x0048:
            int r5 = r5.intValue()
            if (r5 != r3) goto L_0x004f
            goto L_0x0050
        L_0x004f:
            r3 = 0
        L_0x0050:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.a.a(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.remote.d.a(java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    public Object b(String str, String str2, String str3, kotlin.coroutines.c<? super b0> cVar) {
        return this.f33085a.b(str, str2, str3, cVar);
    }

    public Object b(y yVar, kotlin.coroutines.c<? super w> cVar) {
        return this.f33085a.b(yVar, cVar);
    }

    public Object b(String str, kotlin.coroutines.c<? super g> cVar) {
        return this.f33085a.b(str, cVar);
    }

    public Object b(String str, String str2, kotlin.coroutines.c<? super Unit> cVar) {
        Class<String> cls = String.class;
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        com.sumsub.log.logger.a.a(aVar, f33084g, "Set language " + str2 + " for action " + str, (Throwable) null, 4, (Object) null);
        kotlinx.serialization.json.a aVar2 = this.f33089e;
        Map l11 = MapsKt__MapsKt.l(kotlin.l.a("id", str), kotlin.l.a("lang", str2));
        kotlinx.serialization.modules.d a11 = aVar2.a();
        q.a aVar3 = q.f56856c;
        p p11 = Reflection.p(Map.class, aVar3.a(Reflection.n(cls)), aVar3.a(Reflection.n(cls)));
        MagicApiIntrinsics.a("kotlinx.serialization.serializer.withModule");
        Object a12 = this.f33085a.a(RequestBody.Companion.create(aVar2.b(kotlinx.serialization.h.d(a11, p11), l11), MediaType.Companion.parse("application/json; charset=utf-8")), (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.remote.response.d>) cVar);
        return a12 == IntrinsicsKt__IntrinsicsKt.d() ? a12 : Unit.f56620a;
    }

    public kotlinx.coroutines.flow.d<SNSMessage.ServerMessage> a(com.sumsub.sns.internal.core.b<String> bVar) {
        OkHttpClient okHttpClient = this.f33087c;
        return new b(e1.a(okHttpClient, this.f33088d + "ws/iframe?token=", bVar), this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(java.lang.String r17, java.util.Map<java.lang.String, ? extends java.lang.Object> r18, java.util.List<java.lang.String> r19, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g.a> r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = r20
            boolean r2 = r1 instanceof com.sumsub.sns.internal.core.data.source.applicant.remote.d.h
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.sumsub.sns.internal.core.data.source.applicant.remote.d$h r2 = (com.sumsub.sns.internal.core.data.source.applicant.remote.d.h) r2
            int r3 = r2.f33115c
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f33115c = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.core.data.source.applicant.remote.d$h r2 = new com.sumsub.sns.internal.core.data.source.applicant.remote.d$h
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f33113a
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r2.f33115c
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L_0x0037
            if (r4 != r6) goto L_0x002f
            kotlin.k.b(r1)
            goto L_0x00b5
        L_0x002f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0037:
            kotlin.k.b(r1)
            kotlinx.serialization.json.a r1 = r0.f33089e
            kotlinx.serialization.modules.d r4 = r1.a()
            kotlin.reflect.q$a r7 = kotlin.reflect.q.f56856c
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            kotlin.reflect.p r8 = kotlin.jvm.internal.Reflection.n(r8)
            kotlin.reflect.q r8 = r7.a(r8)
            java.lang.Class<java.lang.Object> r9 = java.lang.Object.class
            kotlin.reflect.p r9 = kotlin.jvm.internal.Reflection.n(r9)
            kotlin.reflect.q r7 = r7.a(r9)
            java.lang.Class<java.util.Map> r9 = java.util.Map.class
            kotlin.reflect.p r7 = kotlin.jvm.internal.Reflection.p(r9, r8, r7)
            java.lang.String r8 = "kotlinx.serialization.serializer.withModule"
            kotlin.jvm.internal.MagicApiIntrinsics.a(r8)
            kotlinx.serialization.b r4 = kotlinx.serialization.h.d(r4, r7)
            r7 = r18
            java.lang.String r1 = r1.b(r4, r7)
            com.sumsub.sns.internal.log.a r7 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r8 = "setFields: "
            r4.append(r8)
            r4.append(r1)
            java.lang.String r9 = r4.toString()
            r10 = 0
            r11 = 4
            r12 = 0
            java.lang.String r8 = "ApplicantDataSource"
            com.sumsub.log.logger.a.a(r7, r8, r9, r10, r11, r12)
            com.sumsub.sns.internal.core.data.source.applicant.remote.e r4 = r0.f33085a
            okhttp3.RequestBody$Companion r7 = okhttp3.RequestBody.Companion
            okhttp3.MediaType$Companion r8 = okhttp3.MediaType.Companion
            java.lang.String r9 = "application/json; charset=utf-8"
            okhttp3.MediaType r8 = r8.parse(r9)
            okhttp3.RequestBody r1 = r7.create((java.lang.String) r1, (okhttp3.MediaType) r8)
            if (r19 == 0) goto L_0x00a9
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 62
            r15 = 0
            java.lang.String r8 = ","
            r7 = r19
            java.lang.String r7 = kotlin.collections.CollectionsKt___CollectionsKt.k0(r7, r8, r9, r10, r11, r12, r13, r14, r15)
            goto L_0x00aa
        L_0x00a9:
            r7 = r5
        L_0x00aa:
            r2.f33115c = r6
            r8 = r17
            java.lang.Object r1 = r4.a((java.lang.String) r8, (okhttp3.RequestBody) r1, (java.lang.String) r7, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0350c>) r2)
            if (r1 != r3) goto L_0x00b5
            return r3
        L_0x00b5:
            com.sumsub.sns.internal.core.data.model.remote.response.d$c$c r1 = (com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0350c) r1
            com.sumsub.sns.internal.core.data.model.g$a r1 = com.sumsub.sns.internal.core.data.model.remote.response.e.a(r1, r5, r6, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.remote.d.a(java.lang.String, java.util.Map, java.util.List, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object b(java.lang.String r5, com.sumsub.sns.internal.core.data.model.b r6, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.sumsub.sns.internal.core.data.source.applicant.remote.d.f
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.sumsub.sns.internal.core.data.source.applicant.remote.d$f r0 = (com.sumsub.sns.internal.core.data.source.applicant.remote.d.f) r0
            int r1 = r0.f33109c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33109c = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.applicant.remote.d$f r0 = new com.sumsub.sns.internal.core.data.source.applicant.remote.d$f
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f33107a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33109c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.k.b(r7)
            goto L_0x003f
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.k.b(r7)
            com.sumsub.sns.internal.core.data.source.applicant.remote.e r7 = r4.f33085a
            r0.f33109c = r3
            java.lang.Object r7 = r7.b((java.lang.String) r5, (com.sumsub.sns.internal.core.data.model.b) r6, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0351d>) r0)
            if (r7 != r1) goto L_0x003f
            return r1
        L_0x003f:
            com.sumsub.sns.internal.core.data.model.remote.response.d$c$d r7 = (com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0351d) r7
            com.sumsub.sns.internal.core.data.model.g r5 = com.sumsub.sns.internal.core.data.model.remote.response.e.b(r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.remote.d.b(java.lang.String, com.sumsub.sns.internal.core.data.model.b, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.util.List<com.sumsub.sns.internal.core.data.model.remote.e> r19, java.util.List<java.lang.String> r20, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g> r21) {
        /*
            r15 = this;
            r0 = r15
            r1 = r21
            boolean r2 = r1 instanceof com.sumsub.sns.internal.core.data.source.applicant.remote.d.g
            if (r2 == 0) goto L_0x0016
            r2 = r1
            com.sumsub.sns.internal.core.data.source.applicant.remote.d$g r2 = (com.sumsub.sns.internal.core.data.source.applicant.remote.d.g) r2
            int r3 = r2.f33112c
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0016
            int r3 = r3 - r4
            r2.f33112c = r3
            goto L_0x001b
        L_0x0016:
            com.sumsub.sns.internal.core.data.source.applicant.remote.d$g r2 = new com.sumsub.sns.internal.core.data.source.applicant.remote.d$g
            r2.<init>(r15, r1)
        L_0x001b:
            java.lang.Object r1 = r2.f33110a
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r2.f33112c
            r5 = 1
            if (r4 == 0) goto L_0x0034
            if (r4 != r5) goto L_0x002c
            kotlin.k.b(r1)
            goto L_0x0063
        L_0x002c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0034:
            kotlin.k.b(r1)
            com.sumsub.sns.internal.core.data.source.applicant.remote.e r1 = r0.f33085a
            com.sumsub.sns.internal.core.data.model.remote.d r4 = new com.sumsub.sns.internal.core.data.model.remote.d
            r6 = r16
            r7 = r17
            r8 = r18
            r9 = r19
            r4.<init>(r6, r7, r8, r9)
            if (r20 == 0) goto L_0x0059
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 62
            r14 = 0
            java.lang.String r7 = ","
            r6 = r20
            java.lang.String r6 = kotlin.collections.CollectionsKt___CollectionsKt.k0(r6, r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x005a
        L_0x0059:
            r6 = 0
        L_0x005a:
            r2.f33112c = r5
            java.lang.Object r1 = r1.a((com.sumsub.sns.internal.core.data.model.remote.d) r4, (java.lang.String) r6, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0351d>) r2)
            if (r1 != r3) goto L_0x0063
            return r3
        L_0x0063:
            com.sumsub.sns.internal.core.data.model.remote.response.d$c$d r1 = (com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0351d) r1
            com.sumsub.sns.internal.core.data.model.g r1 = com.sumsub.sns.internal.core.data.model.remote.response.e.a((com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0351d) r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.remote.d.a(java.lang.String, java.lang.String, java.lang.String, java.util.List, java.util.List, kotlin.coroutines.c):java.lang.Object");
    }

    public Object a(String str, a0 a0Var, kotlin.coroutines.c<? super b0> cVar) {
        return this.f33085a.a(str, a0Var, cVar);
    }

    public Object a(String str, String str2, String str3, kotlin.coroutines.c<? super b0> cVar) {
        return this.f33085a.a(str, str2, str3, cVar);
    }

    public Object a(String str, String str2, String str3, String str4, List<String> list, kotlin.coroutines.c<? super g> cVar) {
        return this.f33085a.a(str, new com.sumsub.sns.internal.core.data.model.remote.b(str2, str3, str4, list), cVar);
    }

    public Object a(y yVar, kotlin.coroutines.c<? super w> cVar) {
        return this.f33085a.a(yVar, cVar);
    }

    public Object a(u uVar, kotlin.coroutines.c<? super w> cVar) {
        return this.f33085a.a(uVar, cVar);
    }

    public Object a(String str, byte[] bArr, kotlin.coroutines.c<? super Map<String, ? extends Object>> cVar) {
        return this.f33085a.a(str, RequestBody.Companion.create$default(RequestBody.Companion, bArr, MediaType.Companion.parse("application/json"), 0, 0, 6, (Object) null), cVar);
    }

    public Object a(String str, b bVar, kotlin.coroutines.c<? super e0> cVar) {
        return this.f33085a.a(str, bVar, cVar);
    }

    public Object a(String str, String str2, a aVar, kotlin.coroutines.c<? super e0> cVar) {
        return this.f33085a.a(str, str2, aVar, cVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(kotlin.coroutines.c<? super java.util.List<com.sumsub.sns.internal.core.data.source.applicant.remote.n>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.sumsub.sns.internal.core.data.source.applicant.remote.d.c
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.sumsub.sns.internal.core.data.source.applicant.remote.d$c r0 = (com.sumsub.sns.internal.core.data.source.applicant.remote.d.c) r0
            int r1 = r0.f33100c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33100c = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.applicant.remote.d$c r0 = new com.sumsub.sns.internal.core.data.source.applicant.remote.d$c
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f33098a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33100c
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
            com.sumsub.sns.internal.core.data.source.applicant.remote.e r5 = r4.f33085a
            r0.f33100c = r3
            java.lang.Object r5 = r5.a(r0)
            if (r5 != r1) goto L_0x003f
            return r1
        L_0x003f:
            com.sumsub.sns.internal.core.data.source.applicant.remote.f r5 = (com.sumsub.sns.internal.core.data.source.applicant.remote.f) r5
            java.util.List r5 = r5.b()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.remote.d.a(kotlin.coroutines.c):java.lang.Object");
    }

    public Object a(String str, String str2, kotlin.coroutines.c<? super Unit> cVar) {
        Class<String> cls = String.class;
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        com.sumsub.log.logger.a.a(aVar, f33084g, "Set language " + str2 + " for applicant " + str, (Throwable) null, 4, (Object) null);
        kotlinx.serialization.json.a aVar2 = this.f33089e;
        Map l11 = MapsKt__MapsKt.l(kotlin.l.a("id", str), kotlin.l.a("lang", str2));
        kotlinx.serialization.modules.d a11 = aVar2.a();
        q.a aVar3 = q.f56856c;
        p p11 = Reflection.p(Map.class, aVar3.a(Reflection.n(cls)), aVar3.a(Reflection.n(cls)));
        MagicApiIntrinsics.a("kotlinx.serialization.serializer.withModule");
        Object b11 = this.f33085a.b(RequestBody.Companion.create(aVar2.b(kotlinx.serialization.h.d(a11, p11), l11), MediaType.Companion.parse("application/json; charset=utf-8")), (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.remote.response.d>) cVar);
        return b11 == IntrinsicsKt__IntrinsicsKt.d() ? b11 : Unit.f56620a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(java.lang.String r5, com.sumsub.sns.internal.core.data.model.b r6, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.sumsub.sns.internal.core.data.source.applicant.remote.d.e
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.sumsub.sns.internal.core.data.source.applicant.remote.d$e r0 = (com.sumsub.sns.internal.core.data.source.applicant.remote.d.e) r0
            int r1 = r0.f33106c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33106c = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.applicant.remote.d$e r0 = new com.sumsub.sns.internal.core.data.source.applicant.remote.d$e
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f33104a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33106c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.k.b(r7)
            goto L_0x003f
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.k.b(r7)
            com.sumsub.sns.internal.core.data.source.applicant.remote.e r7 = r4.f33085a
            r0.f33106c = r3
            java.lang.Object r7 = r7.a((java.lang.String) r5, (com.sumsub.sns.internal.core.data.model.b) r6, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0351d>) r0)
            if (r7 != r1) goto L_0x003f
            return r1
        L_0x003f:
            com.sumsub.sns.internal.core.data.model.remote.response.d$c$d r7 = (com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0351d) r7
            com.sumsub.sns.internal.core.data.model.g r5 = com.sumsub.sns.internal.core.data.model.remote.response.e.a((com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0351d) r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.remote.d.a(java.lang.String, com.sumsub.sns.internal.core.data.model.b, kotlin.coroutines.c):java.lang.Object");
    }
}
