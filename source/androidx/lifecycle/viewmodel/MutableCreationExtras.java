package androidx.lifecycle.viewmodel;

import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.r;

public final class MutableCreationExtras extends CreationExtras {
    public MutableCreationExtras() {
        this((CreationExtras) null, 1, (r) null);
    }

    public MutableCreationExtras(CreationExtras creationExtras) {
        b().putAll(creationExtras.b());
    }

    public <T> T a(CreationExtras.b<T> bVar) {
        return b().get(bVar);
    }

    public final <T> void c(CreationExtras.b<T> bVar, T t11) {
        b().put(bVar, t11);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutableCreationExtras(CreationExtras creationExtras, int i11, r rVar) {
        this((i11 & 1) != 0 ? CreationExtras.a.f10040b : creationExtras);
    }
}
