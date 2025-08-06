package q1;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.o0;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.x;

public final class a implements ViewModelProvider.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final b<?>[] f16379a;

    public a(b<?>... bVarArr) {
        this.f16379a = bVarArr;
    }

    public /* synthetic */ ViewModel create(Class cls) {
        return o0.a(this, cls);
    }

    public <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
        T t11 = null;
        for (b<?> bVar : this.f16379a) {
            if (x.b(bVar.a(), cls)) {
                T invoke = bVar.b().invoke(creationExtras);
                t11 = invoke instanceof ViewModel ? (ViewModel) invoke : null;
            }
        }
        if (t11 != null) {
            return t11;
        }
        throw new IllegalArgumentException("No initializer set for given class " + cls.getName());
    }
}
