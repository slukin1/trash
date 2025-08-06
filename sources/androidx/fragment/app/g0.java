package androidx.fragment.app;

import android.os.Build;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.transition.FragmentTransitionSupport;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.x;

public final class g0 {

    /* renamed from: a  reason: collision with root package name */
    public static final g0 f9731a;

    /* renamed from: b  reason: collision with root package name */
    public static final FragmentTransitionImpl f9732b = (Build.VERSION.SDK_INT >= 21 ? new h0() : null);

    /* renamed from: c  reason: collision with root package name */
    public static final FragmentTransitionImpl f9733c;

    static {
        g0 g0Var = new g0();
        f9731a = g0Var;
        f9733c = g0Var.c();
    }

    public static final void a(Fragment fragment, Fragment fragment2, boolean z11, ArrayMap<String, View> arrayMap, boolean z12) {
        SharedElementCallback sharedElementCallback;
        if (z11) {
            sharedElementCallback = fragment2.getEnterTransitionCallback();
        } else {
            sharedElementCallback = fragment.getEnterTransitionCallback();
        }
        if (sharedElementCallback != null) {
            ArrayList arrayList = new ArrayList(arrayMap.size());
            for (Map.Entry<String, View> value : arrayMap.entrySet()) {
                arrayList.add((View) value.getValue());
            }
            ArrayList arrayList2 = new ArrayList(arrayMap.size());
            for (Map.Entry<String, View> key : arrayMap.entrySet()) {
                arrayList2.add((String) key.getKey());
            }
            if (z12) {
                sharedElementCallback.g(arrayList2, arrayList, (List<View>) null);
            } else {
                sharedElementCallback.f(arrayList2, arrayList, (List<View>) null);
            }
        }
    }

    public static final String b(ArrayMap<String, String> arrayMap, String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : arrayMap.entrySet()) {
            if (x.b(next.getValue(), str)) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry key : linkedHashMap.entrySet()) {
            arrayList.add((String) key.getKey());
        }
        return (String) CollectionsKt___CollectionsKt.c0(arrayList);
    }

    public static final void d(ArrayMap<String, String> arrayMap, ArrayMap<String, View> arrayMap2) {
        int size = arrayMap.size();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            }
            if (!arrayMap2.containsKey(arrayMap.p(size))) {
                arrayMap.n(size);
            }
        }
    }

    public static final void e(List<? extends View> list, int i11) {
        for (View visibility : list) {
            visibility.setVisibility(i11);
        }
    }

    public static final boolean f() {
        return (f9732b == null && f9733c == null) ? false : true;
    }

    public final FragmentTransitionImpl c() {
        try {
            return FragmentTransitionSupport.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
