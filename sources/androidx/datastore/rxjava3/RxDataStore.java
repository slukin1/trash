package androidx.datastore.rxjava3;

import androidx.datastore.core.d;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.b;
import j00.h;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.p1;
import kotlinx.coroutines.rx3.RxConvertKt;

@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001\u0017B\u001f\b\u0002\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0007J(\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\nH\u0007R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0013¨\u0006\u0018"}, d2 = {"Landroidx/datastore/rxjava3/RxDataStore;", "", "T", "Lio/reactivex/rxjava3/disposables/b;", "", "dispose", "", "isDisposed", "Lio/reactivex/rxjava3/core/Flowable;", "c", "Lj00/h;", "Lio/reactivex/rxjava3/core/Single;", "transform", "d", "Landroidx/datastore/core/d;", "b", "Landroidx/datastore/core/d;", "delegateDs", "Lkotlinx/coroutines/h0;", "Lkotlinx/coroutines/h0;", "scope", "<init>", "(Landroidx/datastore/core/d;Lkotlinx/coroutines/h0;)V", "a", "datastore-rxjava3_release"}, k = 1, mv = {1, 5, 1})
public final class RxDataStore<T> implements b {

    /* renamed from: d  reason: collision with root package name */
    public static final a f9272d = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public final d<T> f9273b;

    /* renamed from: c  reason: collision with root package name */
    public final h0 f9274c;

    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ,\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\"\b\b\u0001\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Landroidx/datastore/rxjava3/RxDataStore$a;", "", "T", "Landroidx/datastore/core/d;", "delegateDs", "Lkotlinx/coroutines/h0;", "scope", "Landroidx/datastore/rxjava3/RxDataStore;", "a", "<init>", "()V", "datastore-rxjava3_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final <T> RxDataStore<T> a(d<T> dVar, h0 h0Var) {
            return new RxDataStore<>(dVar, h0Var, (r) null);
        }
    }

    public RxDataStore(d<T> dVar, h0 h0Var) {
        this.f9273b = dVar;
        this.f9274c = h0Var;
    }

    public /* synthetic */ RxDataStore(d dVar, h0 h0Var, r rVar) {
        this(dVar, h0Var);
    }

    public final Flowable<T> c() {
        return RxConvertKt.a(this.f9273b.getData(), this.f9274c.getCoroutineContext());
    }

    public final Single<T> d(h<T, Single<T>> hVar) {
        return RxConvertKt.b(i.b(this.f9274c, e2.b((n1) null, 1, (Object) null), (CoroutineStart) null, new RxDataStore$updateDataAsync$1(this, hVar, (c<? super RxDataStore$updateDataAsync$1>) null), 2, (Object) null), this.f9274c.getCoroutineContext().minusKey(n1.f57382r0));
    }

    public void dispose() {
        n1.a.a(p1.k(this.f9274c.getCoroutineContext()), (CancellationException) null, 1, (Object) null);
    }

    public boolean isDisposed() {
        return p1.k(this.f9274c.getCoroutineContext()).isActive();
    }
}
