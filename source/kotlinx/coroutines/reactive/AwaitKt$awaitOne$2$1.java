package kotlinx.coroutines.reactive;

import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.Unit;
import kotlinx.coroutines.e0;
import kotlinx.coroutines.k;
import z20.c;
import z20.d;

public final class AwaitKt$awaitOne$2$1 implements c<T> {

    /* renamed from: b  reason: collision with root package name */
    public d f57392b;

    /* renamed from: c  reason: collision with root package name */
    public T f57393c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f57394d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f57395e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ k<T> f57396f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Mode f57397g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ T f57398h;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f57399a;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                kotlinx.coroutines.reactive.Mode[] r0 = kotlinx.coroutines.reactive.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlinx.coroutines.reactive.Mode r1 = kotlinx.coroutines.reactive.Mode.FIRST     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlinx.coroutines.reactive.Mode r1 = kotlinx.coroutines.reactive.Mode.FIRST_OR_DEFAULT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlinx.coroutines.reactive.Mode r1 = kotlinx.coroutines.reactive.Mode.LAST     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                kotlinx.coroutines.reactive.Mode r1 = kotlinx.coroutines.reactive.Mode.SINGLE     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                kotlinx.coroutines.reactive.Mode r1 = kotlinx.coroutines.reactive.Mode.SINGLE_OR_DEFAULT     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                f57399a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.AwaitKt$awaitOne$2$1.a.<clinit>():void");
        }
    }

    public AwaitKt$awaitOne$2$1(k<? super T> kVar, Mode mode, T t11) {
        this.f57396f = kVar;
        this.f57397g = mode;
        this.f57398h = t11;
    }

    public final boolean b(String str) {
        if (this.f57395e) {
            AwaitKt.g(this.f57396f.getContext(), str);
            return false;
        }
        this.f57395e = true;
        return true;
    }

    public final synchronized void c(d10.a<Unit> aVar) {
        aVar.invoke();
    }

    public void onComplete() {
        if (b("onComplete")) {
            if (this.f57394d) {
                Mode mode = this.f57397g;
                if (mode != Mode.FIRST_OR_DEFAULT && mode != Mode.FIRST && this.f57396f.isActive()) {
                    k<T> kVar = this.f57396f;
                    Result.a aVar = Result.Companion;
                    kVar.resumeWith(Result.m3072constructorimpl(this.f57393c));
                    return;
                }
                return;
            }
            Mode mode2 = this.f57397g;
            if (mode2 == Mode.FIRST_OR_DEFAULT || mode2 == Mode.SINGLE_OR_DEFAULT) {
                k<T> kVar2 = this.f57396f;
                Result.a aVar2 = Result.Companion;
                kVar2.resumeWith(Result.m3072constructorimpl(this.f57398h));
            } else if (this.f57396f.isActive()) {
                k<T> kVar3 = this.f57396f;
                Result.a aVar3 = Result.Companion;
                kVar3.resumeWith(Result.m3072constructorimpl(kotlin.k.a(new NoSuchElementException("No value received via onNext for " + this.f57397g))));
            }
        }
    }

    public void onError(Throwable th2) {
        if (b("onError")) {
            k<T> kVar = this.f57396f;
            Result.a aVar = Result.Companion;
            kVar.resumeWith(Result.m3072constructorimpl(kotlin.k.a(th2)));
        }
    }

    public void onNext(T t11) {
        d dVar = this.f57392b;
        k<T> kVar = this.f57396f;
        if (dVar == null) {
            e0.a(kVar.getContext(), new IllegalStateException("'onNext' was called before 'onSubscribe'"));
        } else if (this.f57395e) {
            AwaitKt.g(kVar.getContext(), "onNext");
        } else {
            int i11 = a.f57399a[this.f57397g.ordinal()];
            if (i11 == 1 || i11 == 2) {
                if (this.f57394d) {
                    AwaitKt.h(this.f57396f.getContext(), this.f57397g);
                    return;
                }
                this.f57394d = true;
                c(new AwaitKt$awaitOne$2$1$onNext$1(dVar));
                k<T> kVar2 = this.f57396f;
                Result.a aVar = Result.Companion;
                kVar2.resumeWith(Result.m3072constructorimpl(t11));
            } else if (i11 == 3 || i11 == 4 || i11 == 5) {
                Mode mode = this.f57397g;
                if ((mode == Mode.SINGLE || mode == Mode.SINGLE_OR_DEFAULT) && this.f57394d) {
                    c(new AwaitKt$awaitOne$2$1$onNext$2(dVar));
                    if (this.f57396f.isActive()) {
                        k<T> kVar3 = this.f57396f;
                        Result.a aVar2 = Result.Companion;
                        kVar3.resumeWith(Result.m3072constructorimpl(kotlin.k.a(new IllegalArgumentException("More than one onNext value for " + this.f57397g))));
                        return;
                    }
                    return;
                }
                this.f57393c = t11;
                this.f57394d = true;
            }
        }
    }

    public void onSubscribe(d dVar) {
        if (this.f57392b != null) {
            c(new AwaitKt$awaitOne$2$1$onSubscribe$1(dVar));
            return;
        }
        this.f57392b = dVar;
        this.f57396f.x(new AwaitKt$awaitOne$2$1$onSubscribe$2(this, dVar));
        c(new AwaitKt$awaitOne$2$1$onSubscribe$3(dVar, this.f57397g));
    }
}
