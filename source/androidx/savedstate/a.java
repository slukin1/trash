package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.r;
import androidx.savedstate.SavedStateRegistry;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public final class a implements r {

    /* renamed from: c  reason: collision with root package name */
    public static final C0056a f10943c = new C0056a((kotlin.jvm.internal.r) null);

    /* renamed from: b  reason: collision with root package name */
    public final c f10944b;

    /* renamed from: androidx.savedstate.a$a  reason: collision with other inner class name */
    public static final class C0056a {
        public C0056a() {
        }

        public /* synthetic */ C0056a(kotlin.jvm.internal.r rVar) {
            this();
        }
    }

    public static final class b implements SavedStateRegistry.c {

        /* renamed from: a  reason: collision with root package name */
        public final Set<String> f10945a = new LinkedHashSet();

        public b(SavedStateRegistry savedStateRegistry) {
            savedStateRegistry.h("androidx.savedstate.Restarter", this);
        }

        public final void a(String str) {
            this.f10945a.add(str);
        }

        public Bundle saveState() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList(this.f10945a));
            return bundle;
        }
    }

    public a(c cVar) {
        this.f10944b = cVar;
    }

    public final void a(String str) {
        try {
            Class<? extends U> asSubclass = Class.forName(str, false, a.class.getClassLoader()).asSubclass(SavedStateRegistry.a.class);
            try {
                Constructor<? extends U> declaredConstructor = asSubclass.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    ((SavedStateRegistry.a) declaredConstructor.newInstance(new Object[0])).a(this.f10944b);
                } catch (Exception e11) {
                    throw new RuntimeException("Failed to instantiate " + str, e11);
                }
            } catch (NoSuchMethodException e12) {
                throw new IllegalStateException("Class " + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e12);
            }
        } catch (ClassNotFoundException e13) {
            throw new RuntimeException("Class " + str + " wasn't found", e13);
        }
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_CREATE) {
            lifecycleOwner.getLifecycle().d(this);
            Bundle b11 = this.f10944b.getSavedStateRegistry().b("androidx.savedstate.Restarter");
            if (b11 != null) {
                ArrayList<String> stringArrayList = b11.getStringArrayList("classes_to_restore");
                if (stringArrayList != null) {
                    for (String a11 : stringArrayList) {
                        a(a11);
                    }
                    return;
                }
                throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            }
            return;
        }
        throw new AssertionError("Next event must be ON_CREATE");
    }
}
