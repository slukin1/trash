package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class c0 {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<Object> f56771a;

    public c0(int i11) {
        this.f56771a = new ArrayList<>(i11);
    }

    public void a(Object obj) {
        this.f56771a.add(obj);
    }

    public void b(Object obj) {
        if (obj != null) {
            if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length > 0) {
                    ArrayList<Object> arrayList = this.f56771a;
                    arrayList.ensureCapacity(arrayList.size() + objArr.length);
                    Collections.addAll(this.f56771a, objArr);
                }
            } else if (obj instanceof Collection) {
                this.f56771a.addAll((Collection) obj);
            } else if (obj instanceof Iterable) {
                for (Object add : (Iterable) obj) {
                    this.f56771a.add(add);
                }
            } else if (obj instanceof Iterator) {
                Iterator it2 = (Iterator) obj;
                while (it2.hasNext()) {
                    this.f56771a.add(it2.next());
                }
            } else {
                throw new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
            }
        }
    }

    public int c() {
        return this.f56771a.size();
    }

    public Object[] d(Object[] objArr) {
        return this.f56771a.toArray(objArr);
    }
}
