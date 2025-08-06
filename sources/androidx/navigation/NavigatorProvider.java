package androidx.navigation;

import android.annotation.SuppressLint;
import androidx.navigation.Navigator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@SuppressLint({"TypeParameterUnusedInFormals"})
public class NavigatorProvider {

    /* renamed from: b  reason: collision with root package name */
    public static final a f10368b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final Map<Class<?>, String> f10369c = new LinkedHashMap();

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Navigator<? extends NavDestination>> f10370a = new LinkedHashMap();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final String a(Class<? extends Navigator<?>> cls) {
            String str = (String) NavigatorProvider.f10369c.get(cls);
            if (str == null) {
                Navigator.b bVar = (Navigator.b) cls.getAnnotation(Navigator.b.class);
                str = bVar != null ? bVar.value() : null;
                if (b(str)) {
                    NavigatorProvider.f10369c.put(cls, str);
                } else {
                    throw new IllegalArgumentException(("No @Navigator.Name annotation found for " + cls.getSimpleName()).toString());
                }
            }
            return str;
        }

        public final boolean b(String str) {
            if (str != null) {
                if (str.length() > 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public final Navigator<? extends NavDestination> b(Navigator<? extends NavDestination> navigator) {
        return c(f10368b.a(navigator.getClass()), navigator);
    }

    public Navigator<? extends NavDestination> c(String str, Navigator<? extends NavDestination> navigator) {
        if (f10368b.b(str)) {
            Navigator navigator2 = this.f10370a.get(str);
            if (x.b(navigator2, navigator)) {
                return navigator;
            }
            boolean z11 = false;
            if (navigator2 != null && navigator2.c()) {
                z11 = true;
            }
            if (!(!z11)) {
                throw new IllegalStateException(("Navigator " + navigator + " is replacing an already attached " + navigator2).toString());
            } else if (!navigator.c()) {
                return this.f10370a.put(str, navigator);
            } else {
                throw new IllegalStateException(("Navigator " + navigator + " is already attached to another NavController").toString());
            }
        } else {
            throw new IllegalArgumentException("navigator name cannot be an empty string".toString());
        }
    }

    public <T extends Navigator<?>> T d(String str) {
        if (f10368b.b(str)) {
            T t11 = (Navigator) this.f10370a.get(str);
            if (t11 != null) {
                return t11;
            }
            throw new IllegalStateException("Could not find Navigator with name \"" + str + "\". You must call NavController.addNavigator() for each navigation type.");
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string".toString());
    }

    public final Map<String, Navigator<? extends NavDestination>> e() {
        return MapsKt__MapsKt.u(this.f10370a);
    }
}
