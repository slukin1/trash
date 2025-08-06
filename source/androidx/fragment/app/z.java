package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.o0;
import androidx.lifecycle.viewmodel.CreationExtras;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class z extends ViewModel {

    /* renamed from: h  reason: collision with root package name */
    public static final ViewModelProvider.Factory f9796h = new a();

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, Fragment> f9797a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, z> f9798b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<String, ViewModelStore> f9799c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public final boolean f9800d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9801e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9802f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f9803g = false;

    public class a implements ViewModelProvider.Factory {
        public <T extends ViewModel> T create(Class<T> cls) {
            return new z(true);
        }

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return o0.b(this, cls, creationExtras);
        }
    }

    public z(boolean z11) {
        this.f9800d = z11;
    }

    public static z j(ViewModelStore viewModelStore) {
        return (z) new ViewModelProvider(viewModelStore, f9796h).a(z.class);
    }

    public void b(Fragment fragment) {
        if (this.f9803g) {
            if (FragmentManager.P0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (!this.f9797a.containsKey(fragment.mWho)) {
            this.f9797a.put(fragment.mWho, fragment);
            if (FragmentManager.P0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    public void c(Fragment fragment, boolean z11) {
        if (FragmentManager.P0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        e(fragment.mWho, z11);
    }

    public void d(String str, boolean z11) {
        if (FragmentManager.P0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
        }
        e(str, z11);
    }

    public final void e(String str, boolean z11) {
        z zVar = this.f9798b.get(str);
        if (zVar != null) {
            if (z11) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(zVar.f9798b.keySet());
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    zVar.d((String) it2.next(), true);
                }
            }
            zVar.onCleared();
            this.f9798b.remove(str);
        }
        ViewModelStore viewModelStore = this.f9799c.get(str);
        if (viewModelStore != null) {
            viewModelStore.a();
            this.f9799c.remove(str);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || z.class != obj.getClass()) {
            return false;
        }
        z zVar = (z) obj;
        if (!this.f9797a.equals(zVar.f9797a) || !this.f9798b.equals(zVar.f9798b) || !this.f9799c.equals(zVar.f9799c)) {
            return false;
        }
        return true;
    }

    public Fragment h(String str) {
        return this.f9797a.get(str);
    }

    public Collection<Fragment> h0() {
        return new ArrayList(this.f9797a.values());
    }

    public int hashCode() {
        return (((this.f9797a.hashCode() * 31) + this.f9798b.hashCode()) * 31) + this.f9799c.hashCode();
    }

    public z i(Fragment fragment) {
        z zVar = this.f9798b.get(fragment.mWho);
        if (zVar != null) {
            return zVar;
        }
        z zVar2 = new z(this.f9800d);
        this.f9798b.put(fragment.mWho, zVar2);
        return zVar2;
    }

    public ViewModelStore i0(Fragment fragment) {
        ViewModelStore viewModelStore = this.f9799c.get(fragment.mWho);
        if (viewModelStore != null) {
            return viewModelStore;
        }
        ViewModelStore viewModelStore2 = new ViewModelStore();
        this.f9799c.put(fragment.mWho, viewModelStore2);
        return viewModelStore2;
    }

    public boolean j0() {
        return this.f9801e;
    }

    public void k0(Fragment fragment) {
        if (!this.f9803g) {
            if ((this.f9797a.remove(fragment.mWho) != null) && FragmentManager.P0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
            }
        } else if (FragmentManager.P0(2)) {
            Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
        }
    }

    public void l0(boolean z11) {
        this.f9803g = z11;
    }

    public boolean m0(Fragment fragment) {
        if (!this.f9797a.containsKey(fragment.mWho)) {
            return true;
        }
        if (this.f9800d) {
            return this.f9801e;
        }
        return !this.f9802f;
    }

    public void onCleared() {
        if (FragmentManager.P0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f9801e = true;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("FragmentManagerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} Fragments (");
        Iterator<Fragment> it2 = this.f9797a.values().iterator();
        while (it2.hasNext()) {
            sb2.append(it2.next());
            if (it2.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") Child Non Config (");
        Iterator<String> it3 = this.f9798b.keySet().iterator();
        while (it3.hasNext()) {
            sb2.append(it3.next());
            if (it3.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") ViewModelStores (");
        Iterator<String> it4 = this.f9799c.keySet().iterator();
        while (it4.hasNext()) {
            sb2.append(it4.next());
            if (it4.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(')');
        return sb2.toString();
    }
}
