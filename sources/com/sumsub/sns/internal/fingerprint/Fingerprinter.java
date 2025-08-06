package com.sumsub.sns.internal.fingerprint;

import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.v;
import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.x;
import d10.l;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;
import kotlin.k;

public final class Fingerprinter {

    /* renamed from: c  reason: collision with root package name */
    public static final a f34262c = new a((r) null);

    /* renamed from: d  reason: collision with root package name */
    public static final String f34263d = "Fingerprinter";

    /* renamed from: a  reason: collision with root package name */
    public final d10.a<b> f34264a;

    /* renamed from: b  reason: collision with root package name */
    public final i f34265b = LazyKt__LazyJVMKt.a(new d(this));

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/sumsub/sns/internal/fingerprint/Fingerprinter$Version;", "", "", "intValue", "I", "getIntValue$idensic_mobile_sdk_aar_release", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "V_4", "V_5", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public enum Version {
        V_4(4),
        V_5(5);
        
        public static final a Companion = null;
        private final int intValue;

        public static final class a {
            public /* synthetic */ a(r rVar) {
                this();
            }

            public final Version a() {
                return Version.V_5;
            }

            public final Version b() {
                return Version.V_4;
            }

            public final Version c() {
                return (Version) ArraysKt___ArraysKt.k0(Version.values());
            }

            public a() {
            }
        }

        /* access modifiers changed from: public */
        static {
            Companion = new a((r) null);
        }

        private Version(int i11) {
            this.intValue = i11;
        }

        public final int getIntValue$idensic_mobile_sdk_aar_release() {
            return this.intValue;
        }
    }

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public a() {
        }
    }

    public static final class b extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fingerprinter f34266a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f34267b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l f34268c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ com.sumsub.sns.internal.fingerprint.tools.hashers.a f34269d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Fingerprinter fingerprinter, l lVar, l lVar2, com.sumsub.sns.internal.fingerprint.tools.hashers.a aVar) {
            super(0);
            this.f34266a = fingerprinter;
            this.f34267b = lVar;
            this.f34268c = lVar2;
            this.f34269d = aVar;
        }

        public final void a() {
            Object a11 = this.f34266a.b();
            if (Result.m3079isSuccessimpl(a11)) {
                Result.a aVar = Result.Companion;
                a11 = Result.m3071boximpl(((b) a11).a(this.f34269d));
            }
            Object a12 = com.sumsub.sns.internal.fingerprint.tools.b.a(Result.m3072constructorimpl(a11));
            l lVar = this.f34267b;
            Throwable r22 = Result.m3075exceptionOrNullimpl(a12);
            if (r22 == null) {
                lVar.invoke(a12);
                return;
            }
            this.f34268c.invoke("");
            com.sumsub.sns.internal.fingerprint.tools.logs.b.a(com.sumsub.sns.internal.fingerprint.tools.logs.a.f34670a, r22);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public static final class c extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fingerprinter f34270a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f34271b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l f34272c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Fingerprinter fingerprinter, l lVar, l lVar2) {
            super(0);
            this.f34270a = fingerprinter;
            this.f34271b = lVar;
            this.f34272c = lVar2;
        }

        public final void a() {
            Object a11 = this.f34270a.b();
            if (Result.m3079isSuccessimpl(a11)) {
                Result.a aVar = Result.Companion;
                a11 = Result.m3071boximpl(((b) a11).a());
            }
            Object a12 = com.sumsub.sns.internal.fingerprint.tools.b.a(Result.m3072constructorimpl(a11));
            l lVar = this.f34271b;
            if (Result.m3075exceptionOrNullimpl(a12) == null) {
                lVar.invoke(a12);
            } else {
                this.f34272c.invoke(MapsKt__MapsKt.h());
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public static final class d extends Lambda implements d10.a<Result<? extends b>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fingerprinter f34273a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Fingerprinter fingerprinter) {
            super(0);
            this.f34273a = fingerprinter;
        }

        public final Object a() {
            Fingerprinter fingerprinter = this.f34273a;
            try {
                Result.a aVar = Result.Companion;
                return Result.m3072constructorimpl((b) fingerprinter.f34264a.invoke());
            } catch (Throwable th2) {
                Result.a aVar2 = Result.Companion;
                return Result.m3072constructorimpl(k.a(th2));
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            return Result.m3071boximpl(a());
        }
    }

    public static final class e extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fingerprinter f34274a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l<Throwable, Unit> f34275b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l<b, Result<T>> f34276c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ l<T, Unit> f34277d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(Fingerprinter fingerprinter, l<? super Throwable, Unit> lVar, l<? super b, ? extends Result<? extends T>> lVar2, l<? super T, Unit> lVar3) {
            super(0);
            this.f34274a = fingerprinter;
            this.f34275b = lVar;
            this.f34276c = lVar2;
            this.f34277d = lVar3;
        }

        public final void a() {
            Object a11 = this.f34274a.b();
            l<b, Result<T>> lVar = this.f34276c;
            if (Result.m3079isSuccessimpl(a11)) {
                Result.a aVar = Result.Companion;
                a11 = Result.m3071boximpl(lVar.invoke((b) a11).m3081unboximpl());
            }
            Object a12 = com.sumsub.sns.internal.fingerprint.tools.b.a(Result.m3072constructorimpl(a11));
            l<T, Unit> lVar2 = this.f34277d;
            l<Throwable, Unit> lVar3 = this.f34275b;
            Throwable r32 = Result.m3075exceptionOrNullimpl(a12);
            if (r32 == null) {
                lVar2.invoke(a12);
            } else {
                lVar3.invoke(r32);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public Fingerprinter(d10.a<b> aVar) {
        this.f34264a = aVar;
    }

    public final String a(List<? extends v<?>> list) {
        return a(this, (List) list, (com.sumsub.sns.internal.fingerprint.tools.hashers.a) null, 2, (Object) null);
    }

    public final void a(l<? super String, Unit> lVar) {
        a(this, (com.sumsub.sns.internal.fingerprint.tools.hashers.a) null, (l) lVar, 1, (Object) null);
    }

    public final Object b() {
        return ((Result) this.f34265b.getValue()).m3081unboximpl();
    }

    public final void b(l<? super Map<String, String>, Unit> lVar) {
        if (Result.m3075exceptionOrNullimpl(com.sumsub.sns.internal.fingerprint.tools.threading.a.a(new c(this, lVar, lVar))) != null) {
            lVar.invoke(MapsKt__MapsKt.h());
        }
    }

    public static /* synthetic */ void a(Fingerprinter fingerprinter, com.sumsub.sns.internal.fingerprint.tools.hashers.a aVar, l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            aVar = new com.sumsub.sns.internal.fingerprint.tools.hashers.b();
        }
        fingerprinter.a(aVar, (l<? super String, Unit>) lVar);
    }

    public static /* synthetic */ String a(Fingerprinter fingerprinter, List list, com.sumsub.sns.internal.fingerprint.tools.hashers.a aVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            aVar = new com.sumsub.sns.internal.fingerprint.tools.hashers.b();
        }
        return fingerprinter.a((List<? extends v<?>>) list, aVar);
    }

    public final String a(List<? extends v<?>> list, com.sumsub.sns.internal.fingerprint.tools.hashers.a aVar) {
        Object obj;
        Object b11 = b();
        if (Result.m3079isSuccessimpl(b11)) {
            Result.a aVar2 = Result.Companion;
            obj = Result.m3072constructorimpl(Result.m3071boximpl(((b) b11).a(list, aVar)));
        } else {
            obj = Result.m3072constructorimpl(b11);
        }
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.b.a(obj);
        Throwable r42 = Result.m3075exceptionOrNullimpl(a11);
        if (r42 != null) {
            com.sumsub.sns.internal.fingerprint.tools.logs.b.a(com.sumsub.sns.internal.fingerprint.tools.logs.a.f34670a, r42);
        }
        if (Result.m3078isFailureimpl(a11)) {
            a11 = "";
        }
        return (String) a11;
    }

    public final x a() {
        Object b11 = b();
        if (Result.m3079isSuccessimpl(b11)) {
            Result.a aVar = Result.Companion;
            b11 = ((b) b11).b();
        }
        Object r02 = Result.m3072constructorimpl(b11);
        Throwable r12 = Result.m3075exceptionOrNullimpl(r02);
        if (r12 != null) {
            com.sumsub.sns.internal.fingerprint.tools.logs.b.a(com.sumsub.sns.internal.fingerprint.tools.logs.a.f34670a, r12);
        }
        if (Result.m3078isFailureimpl(r02)) {
            r02 = null;
        }
        return (x) r02;
    }

    public final <T> void a(l<? super Throwable, Unit> lVar, l<? super T, Unit> lVar2, l<? super b, ? extends Result<? extends T>> lVar3) {
        Throwable r32 = Result.m3075exceptionOrNullimpl(com.sumsub.sns.internal.fingerprint.tools.threading.a.a(new e(this, lVar, lVar3, lVar2)));
        if (r32 != null) {
            lVar.invoke(r32);
        }
    }

    public final void a(com.sumsub.sns.internal.fingerprint.tools.hashers.a aVar, l<? super String, Unit> lVar) {
        Throwable r22 = Result.m3075exceptionOrNullimpl(com.sumsub.sns.internal.fingerprint.tools.threading.a.a(new b(this, lVar, lVar, aVar)));
        if (r22 != null) {
            lVar.invoke("");
            com.sumsub.sns.internal.fingerprint.tools.logs.b.a(com.sumsub.sns.internal.fingerprint.tools.logs.a.f34670a, r22);
        }
    }
}
