package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import c10.a;
import d10.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.reflect.c;
import q1.b;

public final class InitializerViewModelFactoryBuilder {

    /* renamed from: a  reason: collision with root package name */
    public final List<b<?>> f10041a = new ArrayList();

    public final <T extends ViewModel> void a(c<T> cVar, l<? super CreationExtras, ? extends T> lVar) {
        this.f10041a.add(new b(a.a(cVar), lVar));
    }

    public final ViewModelProvider.Factory b() {
        b[] bVarArr = (b[]) this.f10041a.toArray(new b[0]);
        return new q1.a((b[]) Arrays.copyOf(bVarArr, bVarArr.length));
    }
}
