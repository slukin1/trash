package kotlinx.coroutines.rx3;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import java.util.NoSuchElementException;
import kotlin.Result;

public final class RxAwaitKt$awaitOne$2$1 implements k<T> {

    /* renamed from: b  reason: collision with root package name */
    public b f57433b;

    /* renamed from: c  reason: collision with root package name */
    public T f57434c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f57435d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.k<T> f57436e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Mode f57437f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ T f57438g;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f57439a;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                kotlinx.coroutines.rx3.Mode[] r0 = kotlinx.coroutines.rx3.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlinx.coroutines.rx3.Mode r1 = kotlinx.coroutines.rx3.Mode.FIRST     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlinx.coroutines.rx3.Mode r1 = kotlinx.coroutines.rx3.Mode.FIRST_OR_DEFAULT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlinx.coroutines.rx3.Mode r1 = kotlinx.coroutines.rx3.Mode.LAST     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                kotlinx.coroutines.rx3.Mode r1 = kotlinx.coroutines.rx3.Mode.SINGLE     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                f57439a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx3.RxAwaitKt$awaitOne$2$1.a.<clinit>():void");
        }
    }

    public RxAwaitKt$awaitOne$2$1(kotlinx.coroutines.k<? super T> kVar, Mode mode, T t11) {
        this.f57436e = kVar;
        this.f57437f = mode;
        this.f57438g = t11;
    }

    public void onComplete() {
        if (this.f57435d) {
            if (this.f57436e.isActive()) {
                kotlinx.coroutines.k<T> kVar = this.f57436e;
                Result.a aVar = Result.Companion;
                kVar.resumeWith(Result.m3072constructorimpl(this.f57434c));
            }
        } else if (this.f57437f == Mode.FIRST_OR_DEFAULT) {
            kotlinx.coroutines.k<T> kVar2 = this.f57436e;
            Result.a aVar2 = Result.Companion;
            kVar2.resumeWith(Result.m3072constructorimpl(this.f57438g));
        } else if (this.f57436e.isActive()) {
            kotlinx.coroutines.k<T> kVar3 = this.f57436e;
            Result.a aVar3 = Result.Companion;
            kVar3.resumeWith(Result.m3072constructorimpl(kotlin.k.a(new NoSuchElementException("No value received via onNext for " + this.f57437f))));
        }
    }

    public void onError(Throwable th2) {
        kotlinx.coroutines.k<T> kVar = this.f57436e;
        Result.a aVar = Result.Companion;
        kVar.resumeWith(Result.m3072constructorimpl(kotlin.k.a(th2)));
    }

    public void onNext(T t11) {
        int i11 = a.f57439a[this.f57437f.ordinal()];
        b bVar = null;
        if (i11 == 1 || i11 == 2) {
            if (!this.f57435d) {
                this.f57435d = true;
                kotlinx.coroutines.k<T> kVar = this.f57436e;
                Result.a aVar = Result.Companion;
                kVar.resumeWith(Result.m3072constructorimpl(t11));
                b bVar2 = this.f57433b;
                if (bVar2 != null) {
                    bVar = bVar2;
                }
                bVar.dispose();
            }
        } else if (i11 != 3 && i11 != 4) {
        } else {
            if (this.f57437f != Mode.SINGLE || !this.f57435d) {
                this.f57434c = t11;
                this.f57435d = true;
                return;
            }
            if (this.f57436e.isActive()) {
                kotlinx.coroutines.k<T> kVar2 = this.f57436e;
                Result.a aVar2 = Result.Companion;
                kVar2.resumeWith(Result.m3072constructorimpl(kotlin.k.a(new IllegalArgumentException("More than one onNext value for " + this.f57437f))));
            }
            b bVar3 = this.f57433b;
            if (bVar3 != null) {
                bVar = bVar3;
            }
            bVar.dispose();
        }
    }

    public void onSubscribe(b bVar) {
        this.f57433b = bVar;
        this.f57436e.x(new RxAwaitKt$awaitOne$2$1$onSubscribe$1(bVar));
    }
}
