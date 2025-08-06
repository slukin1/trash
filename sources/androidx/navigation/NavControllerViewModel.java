package androidx.navigation;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.o0;
import androidx.lifecycle.viewmodel.CreationExtras;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.r;

public final class NavControllerViewModel extends ViewModel implements l {

    /* renamed from: c  reason: collision with root package name */
    public static final b f10281c = new b((r) null);

    /* renamed from: d  reason: collision with root package name */
    public static final ViewModelProvider.Factory f10282d = new a();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, ViewModelStore> f10283b = new LinkedHashMap();

    public static final class a implements ViewModelProvider.Factory {
        public <T extends ViewModel> T create(Class<T> cls) {
            return new NavControllerViewModel();
        }

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return o0.b(this, cls, creationExtras);
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(r rVar) {
            this();
        }

        public final NavControllerViewModel a(ViewModelStore viewModelStore) {
            return (NavControllerViewModel) new ViewModelProvider(viewModelStore, NavControllerViewModel.f10282d, (CreationExtras) null, 4, (r) null).a(NavControllerViewModel.class);
        }
    }

    public ViewModelStore g(String str) {
        ViewModelStore viewModelStore = this.f10283b.get(str);
        if (viewModelStore != null) {
            return viewModelStore;
        }
        ViewModelStore viewModelStore2 = new ViewModelStore();
        this.f10283b.put(str, viewModelStore2);
        return viewModelStore2;
    }

    public final void i0(String str) {
        ViewModelStore remove = this.f10283b.remove(str);
        if (remove != null) {
            remove.a();
        }
    }

    public void onCleared() {
        for (ViewModelStore a11 : this.f10283b.values()) {
            a11.a();
        }
        this.f10283b.clear();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("NavControllerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} ViewModelStores (");
        Iterator<String> it2 = this.f10283b.keySet().iterator();
        while (it2.hasNext()) {
            sb2.append(it2.next());
            if (it2.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(')');
        return sb2.toString();
    }
}
