package androidx.databinding.adapters;

import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class ListenerUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final SparseArray<WeakHashMap<View, WeakReference<?>>> f8867a = new SparseArray<>();

    public static <T> T a(View view, T t11, int i11) {
        WeakReference weakReference;
        if (Build.VERSION.SDK_INT >= 14) {
            T tag = view.getTag(i11);
            view.setTag(i11, t11);
            return tag;
        }
        SparseArray<WeakHashMap<View, WeakReference<?>>> sparseArray = f8867a;
        synchronized (sparseArray) {
            WeakHashMap weakHashMap = sparseArray.get(i11);
            if (weakHashMap == null) {
                weakHashMap = new WeakHashMap();
                sparseArray.put(i11, weakHashMap);
            }
            if (t11 == null) {
                weakReference = (WeakReference) weakHashMap.remove(view);
            } else {
                weakReference = (WeakReference) weakHashMap.put(view, new WeakReference(t11));
            }
            if (weakReference == null) {
                return null;
            }
            T t12 = weakReference.get();
            return t12;
        }
    }
}
