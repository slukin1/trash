package androidx.lifecycle;

import android.os.Bundle;
import androidx.core.os.e;
import androidx.savedstate.SavedStateRegistry;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.r;
import kotlin.l;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.k1;

public final class SavedStateHandle {

    /* renamed from: f  reason: collision with root package name */
    public static final a f9940f = new a((r) null);

    /* renamed from: g  reason: collision with root package name */
    public static final Class<? extends Object>[] f9941g;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f9942a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, SavedStateRegistry.c> f9943b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, b<?>> f9944c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, b1<Object>> f9945d;

    /* renamed from: e  reason: collision with root package name */
    public final SavedStateRegistry.c f9946e;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final SavedStateHandle a(Bundle bundle, Bundle bundle2) {
            if (bundle != null) {
                bundle.setClassLoader(SavedStateHandle.class.getClassLoader());
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(UserMetadata.KEYDATA_FILENAME);
                ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
                if ((parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) ? false : true) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int size = parcelableArrayList.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        linkedHashMap.put((String) parcelableArrayList.get(i11), parcelableArrayList2.get(i11));
                    }
                    return new SavedStateHandle(linkedHashMap);
                }
                throw new IllegalStateException("Invalid bundle passed as restored state".toString());
            } else if (bundle2 == null) {
                return new SavedStateHandle();
            } else {
                HashMap hashMap = new HashMap();
                for (String str : bundle2.keySet()) {
                    hashMap.put(str, bundle2.get(str));
                }
                return new SavedStateHandle(hashMap);
            }
        }

        public final boolean b(Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class isInstance : SavedStateHandle.f9941g) {
                if (isInstance.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static final class b<T> extends MutableLiveData<T> {

        /* renamed from: a  reason: collision with root package name */
        public String f9947a;

        /* renamed from: b  reason: collision with root package name */
        public SavedStateHandle f9948b;

        public final void b() {
            this.f9948b = null;
        }

        public void setValue(T t11) {
            SavedStateHandle savedStateHandle = this.f9948b;
            if (savedStateHandle != null) {
                savedStateHandle.f9942a.put(this.f9947a, t11);
                b1 b1Var = (b1) savedStateHandle.f9945d.get(this.f9947a);
                if (b1Var != null) {
                    b1Var.setValue(t11);
                }
            }
            super.setValue(t11);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.Class<? extends java.lang.Object>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            androidx.lifecycle.SavedStateHandle$a r0 = new androidx.lifecycle.SavedStateHandle$a
            r1 = 0
            r0.<init>(r1)
            f9940f = r0
            r0 = 29
            java.lang.Class[] r0 = new java.lang.Class[r0]
            java.lang.Class r1 = java.lang.Boolean.TYPE
            r2 = 0
            r0[r2] = r1
            r1 = 1
            java.lang.Class<boolean[]> r2 = boolean[].class
            r0[r1] = r2
            java.lang.Class r1 = java.lang.Double.TYPE
            r2 = 2
            r0[r2] = r1
            r1 = 3
            java.lang.Class<double[]> r2 = double[].class
            r0[r1] = r2
            java.lang.Class r1 = java.lang.Integer.TYPE
            r2 = 4
            r0[r2] = r1
            r2 = 5
            java.lang.Class<int[]> r3 = int[].class
            r0[r2] = r3
            java.lang.Class r2 = java.lang.Long.TYPE
            r3 = 6
            r0[r3] = r2
            r2 = 7
            java.lang.Class<long[]> r3 = long[].class
            r0[r2] = r3
            r2 = 8
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r0[r2] = r3
            r2 = 9
            java.lang.Class<java.lang.String[]> r3 = java.lang.String[].class
            r0[r2] = r3
            r2 = 10
            java.lang.Class<android.os.Binder> r3 = android.os.Binder.class
            r0[r2] = r3
            r2 = 11
            java.lang.Class<android.os.Bundle> r3 = android.os.Bundle.class
            r0[r2] = r3
            java.lang.Class r2 = java.lang.Byte.TYPE
            r3 = 12
            r0[r3] = r2
            r2 = 13
            java.lang.Class<byte[]> r3 = byte[].class
            r0[r2] = r3
            java.lang.Class r2 = java.lang.Character.TYPE
            r3 = 14
            r0[r3] = r2
            r2 = 15
            java.lang.Class<char[]> r3 = char[].class
            r0[r2] = r3
            r2 = 16
            java.lang.Class<java.lang.CharSequence> r3 = java.lang.CharSequence.class
            r0[r2] = r3
            r2 = 17
            java.lang.Class<java.lang.CharSequence[]> r3 = java.lang.CharSequence[].class
            r0[r2] = r3
            r2 = 18
            java.lang.Class<java.util.ArrayList> r3 = java.util.ArrayList.class
            r0[r2] = r3
            java.lang.Class r2 = java.lang.Float.TYPE
            r3 = 19
            r0[r3] = r2
            r2 = 20
            java.lang.Class<float[]> r3 = float[].class
            r0[r2] = r3
            java.lang.Class<android.os.Parcelable> r2 = android.os.Parcelable.class
            r3 = 21
            r0[r3] = r2
            r2 = 22
            java.lang.Class<android.os.Parcelable[]> r4 = android.os.Parcelable[].class
            r0[r2] = r4
            r2 = 23
            java.lang.Class<java.io.Serializable> r4 = java.io.Serializable.class
            r0[r2] = r4
            java.lang.Class r2 = java.lang.Short.TYPE
            r4 = 24
            r0[r4] = r2
            r2 = 25
            java.lang.Class<short[]> r4 = short[].class
            r0[r2] = r4
            r2 = 26
            java.lang.Class<android.util.SparseArray> r4 = android.util.SparseArray.class
            r0[r2] = r4
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r3) goto L_0x00ad
            java.lang.Class<android.util.Size> r4 = android.util.Size.class
            goto L_0x00ae
        L_0x00ad:
            r4 = r1
        L_0x00ae:
            r5 = 27
            r0[r5] = r4
            r4 = 28
            if (r2 < r3) goto L_0x00b8
            java.lang.Class<android.util.SizeF> r1 = android.util.SizeF.class
        L_0x00b8:
            r0[r4] = r1
            f9941g = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.SavedStateHandle.<clinit>():void");
    }

    public SavedStateHandle(Map<String, ? extends Object> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f9942a = linkedHashMap;
        this.f9943b = new LinkedHashMap();
        this.f9944c = new LinkedHashMap();
        this.f9945d = new LinkedHashMap();
        this.f9946e = new e0(this);
        linkedHashMap.putAll(map);
    }

    public static final Bundle j(SavedStateHandle savedStateHandle) {
        for (Map.Entry entry : MapsKt__MapsKt.u(savedStateHandle.f9943b).entrySet()) {
            savedStateHandle.k((String) entry.getKey(), ((SavedStateRegistry.c) entry.getValue()).saveState());
        }
        Set<String> keySet = savedStateHandle.f9942a.keySet();
        ArrayList arrayList = new ArrayList(keySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String next : keySet) {
            arrayList.add(next);
            arrayList2.add(savedStateHandle.f9942a.get(next));
        }
        return e.a(l.a(UserMetadata.KEYDATA_FILENAME, arrayList), l.a("values", arrayList2));
    }

    public final boolean e(String str) {
        return this.f9942a.containsKey(str);
    }

    public final <T> T f(String str) {
        try {
            return this.f9942a.get(str);
        } catch (ClassCastException unused) {
            h(str);
            return null;
        }
    }

    public final <T> j1<T> g(String str, T t11) {
        Map<String, b1<Object>> map = this.f9945d;
        b1<Object> b1Var = map.get(str);
        if (b1Var == null) {
            if (!this.f9942a.containsKey(str)) {
                this.f9942a.put(str, t11);
            }
            b1Var = k1.a(this.f9942a.get(str));
            this.f9945d.put(str, b1Var);
            map.put(str, b1Var);
        }
        return f.b(b1Var);
    }

    public final <T> T h(String str) {
        T remove = this.f9942a.remove(str);
        b remove2 = this.f9944c.remove(str);
        if (remove2 != null) {
            remove2.b();
        }
        this.f9945d.remove(str);
        return remove;
    }

    public final SavedStateRegistry.c i() {
        return this.f9946e;
    }

    public final <T> void k(String str, T t11) {
        if (f9940f.b(t11)) {
            b<?> bVar = this.f9944c.get(str);
            MutableLiveData mutableLiveData = bVar instanceof MutableLiveData ? bVar : null;
            if (mutableLiveData != null) {
                mutableLiveData.setValue(t11);
            } else {
                this.f9942a.put(str, t11);
            }
            b1 b1Var = this.f9945d.get(str);
            if (b1Var != null) {
                b1Var.setValue(t11);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Can't put value with type " + t11.getClass() + " into saved state");
    }

    public final void l(String str, SavedStateRegistry.c cVar) {
        this.f9943b.put(str, cVar);
    }

    public SavedStateHandle() {
        this.f9942a = new LinkedHashMap();
        this.f9943b = new LinkedHashMap();
        this.f9944c = new LinkedHashMap();
        this.f9945d = new LinkedHashMap();
        this.f9946e = new e0(this);
    }
}
