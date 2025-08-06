package q1;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewmodel.CreationExtras;
import d10.l;

public final class b<T extends ViewModel> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<T> f16380a;

    /* renamed from: b  reason: collision with root package name */
    public final l<CreationExtras, T> f16381b;

    public b(Class<T> cls, l<? super CreationExtras, ? extends T> lVar) {
        this.f16380a = cls;
        this.f16381b = lVar;
    }

    public final Class<T> a() {
        return this.f16380a;
    }

    public final l<CreationExtras, T> b() {
        return this.f16381b;
    }
}
