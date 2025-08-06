package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.a;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@SuppressLint({"RestrictedApi"})
public final class SavedStateRegistry {

    /* renamed from: g  reason: collision with root package name */
    public static final b f10932g = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final SafeIterableMap<String, c> f10933a = new SafeIterableMap<>();

    /* renamed from: b  reason: collision with root package name */
    public boolean f10934b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f10935c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10936d;

    /* renamed from: e  reason: collision with root package name */
    public a.b f10937e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10938f = true;

    public interface a {
        void a(c cVar);
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(r rVar) {
            this();
        }
    }

    public interface c {
        Bundle saveState();
    }

    public static final void d(SavedStateRegistry savedStateRegistry, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_START) {
            savedStateRegistry.f10938f = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            savedStateRegistry.f10938f = false;
        }
    }

    public final Bundle b(String str) {
        if (this.f10936d) {
            Bundle bundle = this.f10935c;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
            Bundle bundle3 = this.f10935c;
            if (bundle3 != null) {
                bundle3.remove(str);
            }
            Bundle bundle4 = this.f10935c;
            boolean z11 = false;
            if (bundle4 != null && !bundle4.isEmpty()) {
                z11 = true;
            }
            if (!z11) {
                this.f10935c = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
    }

    public final c c(String str) {
        Iterator<Map.Entry<String, c>> it2 = this.f10933a.iterator();
        while (it2.hasNext()) {
            Map.Entry next = it2.next();
            c cVar = (c) next.getValue();
            if (x.b((String) next.getKey(), str)) {
                return cVar;
            }
        }
        return null;
    }

    public final void e(Lifecycle lifecycle) {
        if (!this.f10934b) {
            lifecycle.a(new b(this));
            this.f10934b = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
    }

    public final void f(Bundle bundle) {
        if (!this.f10934b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        } else if (!this.f10936d) {
            this.f10935c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
            this.f10936d = true;
        } else {
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
    }

    public final void g(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f10935c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        SafeIterableMap<K, V>.d c11 = this.f10933a.c();
        while (c11.hasNext()) {
            Map.Entry entry = (Map.Entry) c11.next();
            bundle2.putBundle((String) entry.getKey(), ((c) entry.getValue()).saveState());
        }
        if (!bundle2.isEmpty()) {
            bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
        }
    }

    public final void h(String str, c cVar) {
        if (!(this.f10933a.g(str, cVar) == null)) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    public final void i(Class<? extends a> cls) {
        if (this.f10938f) {
            a.b bVar = this.f10937e;
            if (bVar == null) {
                bVar = new a.b(this);
            }
            this.f10937e = bVar;
            try {
                cls.getDeclaredConstructor(new Class[0]);
                a.b bVar2 = this.f10937e;
                if (bVar2 != null) {
                    bVar2.a(cls.getName());
                }
            } catch (NoSuchMethodException e11) {
                throw new IllegalArgumentException("Class " + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e11);
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
        }
    }
}
