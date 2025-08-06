package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import d10.a;
import kotlin.i;
import kotlin.reflect.c;

public final class n0<VM extends ViewModel> implements i<VM> {

    /* renamed from: b  reason: collision with root package name */
    public final c<VM> f10027b;

    /* renamed from: c  reason: collision with root package name */
    public final a<ViewModelStore> f10028c;

    /* renamed from: d  reason: collision with root package name */
    public final a<ViewModelProvider.Factory> f10029d;

    /* renamed from: e  reason: collision with root package name */
    public final a<CreationExtras> f10030e;

    /* renamed from: f  reason: collision with root package name */
    public VM f10031f;

    public n0(c<VM> cVar, a<? extends ViewModelStore> aVar, a<? extends ViewModelProvider.Factory> aVar2, a<? extends CreationExtras> aVar3) {
        this.f10027b = cVar;
        this.f10028c = aVar;
        this.f10029d = aVar2;
        this.f10030e = aVar3;
    }

    /* renamed from: a */
    public VM getValue() {
        VM vm2 = this.f10031f;
        if (vm2 != null) {
            return vm2;
        }
        VM a11 = new ViewModelProvider(this.f10028c.invoke(), this.f10029d.invoke(), this.f10030e.invoke()).a(c10.a.a(this.f10027b));
        this.f10031f = a11;
        return a11;
    }
}
