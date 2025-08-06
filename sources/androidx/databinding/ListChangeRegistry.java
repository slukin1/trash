package androidx.databinding;

import androidx.core.util.g;
import androidx.databinding.CallbackRegistry;
import androidx.databinding.ObservableList;

public class ListChangeRegistry extends CallbackRegistry<ObservableList.OnListChangedCallback, ObservableList, b> {

    /* renamed from: g  reason: collision with root package name */
    public static final g<b> f8855g = new g<>(10);

    /* renamed from: h  reason: collision with root package name */
    public static final CallbackRegistry.NotifierCallback<ObservableList.OnListChangedCallback, ObservableList, b> f8856h = new a();

    public class a extends CallbackRegistry.NotifierCallback<ObservableList.OnListChangedCallback, ObservableList, b> {
        /* renamed from: b */
        public void a(ObservableList.OnListChangedCallback onListChangedCallback, ObservableList observableList, int i11, b bVar) {
            if (i11 == 1) {
                onListChangedCallback.e(observableList, bVar.f8857a, bVar.f8858b);
            } else if (i11 == 2) {
                onListChangedCallback.f(observableList, bVar.f8857a, bVar.f8858b);
            } else if (i11 == 3) {
                onListChangedCallback.g(observableList, bVar.f8857a, bVar.f8859c, bVar.f8858b);
            } else if (i11 != 4) {
                onListChangedCallback.d(observableList);
            } else {
                onListChangedCallback.h(observableList, bVar.f8857a, bVar.f8858b);
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f8857a;

        /* renamed from: b  reason: collision with root package name */
        public int f8858b;

        /* renamed from: c  reason: collision with root package name */
        public int f8859c;
    }

    public ListChangeRegistry() {
        super(f8856h);
    }

    public static b m(int i11, int i12, int i13) {
        b acquire = f8855g.acquire();
        if (acquire == null) {
            acquire = new b();
        }
        acquire.f8857a = i11;
        acquire.f8859c = i12;
        acquire.f8858b = i13;
        return acquire;
    }

    /* renamed from: n */
    public synchronized void e(ObservableList observableList, int i11, b bVar) {
        super.e(observableList, i11, bVar);
        if (bVar != null) {
            f8855g.release(bVar);
        }
    }

    public void o(ObservableList observableList, int i11, int i12) {
        e(observableList, 1, m(i11, 0, i12));
    }

    public void p(ObservableList observableList, int i11, int i12) {
        e(observableList, 2, m(i11, 0, i12));
    }

    public void q(ObservableList observableList, int i11, int i12) {
        e(observableList, 4, m(i11, 0, i12));
    }
}
