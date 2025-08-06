package r4;

import android.util.SparseArray;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f66597a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final SparseArray<s4.a> f66598b = new SparseArray<>();

    public final s4.a a(int i11) {
        return f66598b.get(i11);
    }

    public final void b(s4.a aVar) {
        f66598b.append(aVar.getType(), aVar);
    }
}
