package androidx.constraintlayout.widget;

import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class SharedValues {

    /* renamed from: a  reason: collision with root package name */
    public SparseIntArray f8108a = new SparseIntArray();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<Integer, HashSet<WeakReference<a>>> f8109b = new HashMap<>();

    public interface a {
    }

    public void a(int i11, a aVar) {
        HashSet hashSet = this.f8109b.get(Integer.valueOf(i11));
        if (hashSet == null) {
            hashSet = new HashSet();
            this.f8109b.put(Integer.valueOf(i11), hashSet);
        }
        hashSet.add(new WeakReference(aVar));
    }

    public void b(int i11, a aVar) {
        HashSet hashSet = this.f8109b.get(Integer.valueOf(i11));
        if (hashSet != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                WeakReference weakReference = (WeakReference) it2.next();
                a aVar2 = (a) weakReference.get();
                if (aVar2 == null || aVar2 == aVar) {
                    arrayList.add(weakReference);
                }
            }
            hashSet.removeAll(arrayList);
        }
    }
}
