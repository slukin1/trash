package jumio.dui;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.z;
import d10.l;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;

public final class f<T> extends MutableLiveData<T> {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f56394a = new AtomicBoolean(false);

    public static final class a extends Lambda implements l<T, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f<T> f56395a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z<? super T> f56396b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(f<T> fVar, z<? super T> zVar) {
            super(1);
            this.f56395a = fVar;
            this.f56396b = zVar;
        }

        public final Object invoke(Object obj) {
            if (this.f56395a.f56394a.compareAndSet(true, false)) {
                this.f56396b.onChanged(obj);
            }
            return Unit.f56620a;
        }
    }

    public static final class b implements z, u {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f56397a;

        public b(a aVar) {
            this.f56397a = aVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof u)) {
                return false;
            }
            return x.b(this.f56397a, ((u) obj).getFunctionDelegate());
        }

        public final kotlin.f<?> getFunctionDelegate() {
            return this.f56397a;
        }

        public final int hashCode() {
            return this.f56397a.hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f56397a.invoke(obj);
        }
    }

    public final void observe(LifecycleOwner lifecycleOwner, z<? super T> zVar) {
        super.observe(lifecycleOwner, new b(new a(this, zVar)));
    }

    public final void setValue(T t11) {
        this.f56394a.set(true);
        super.setValue(t11);
    }
}
