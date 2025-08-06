package mz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import jz.b;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final long[] f58284a = new long[0];

    /* renamed from: b  reason: collision with root package name */
    public static final jz.a f58285b = new C0673a();

    /* renamed from: mz.a$a  reason: collision with other inner class name */
    public static class C0673a implements jz.a {
        public Object apply(Object obj) {
            return obj;
        }
    }

    public static <TypeT> List<TypeT> a(Collection<TypeT> collection, TypeT typet, b<TypeT, TypeT, Boolean> bVar) {
        if (collection == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(collection);
        boolean z11 = false;
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            if (bVar.apply(arrayList.get(i11), typet).booleanValue()) {
                arrayList.set(i11, typet);
                z11 = true;
            }
        }
        if (!z11) {
            arrayList.add(typet);
        }
        return arrayList;
    }

    @SafeVarargs
    public static <TypeT> List<TypeT> b(List<TypeT>... listArr) {
        if (listArr == null || listArr.length == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = new CopyOnWriteArrayList(listArr).iterator();
        while (it2.hasNext()) {
            List list = (List) it2.next();
            if (i(list)) {
                Iterator it3 = new CopyOnWriteArrayList(list).iterator();
                while (it3.hasNext()) {
                    arrayList.add(it3.next());
                }
            }
        }
        return arrayList;
    }

    public static <TypeT> List<TypeT> c(List<TypeT> list) {
        if (list == null) {
            return new ArrayList();
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(list);
        ArrayList arrayList = new ArrayList(copyOnWriteArrayList.size());
        Iterator it2 = copyOnWriteArrayList.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next());
        }
        return arrayList;
    }

    public static <KeyT, ValueT> Map<KeyT, ValueT> d(Map<KeyT, ValueT> map) {
        if (map == null) {
            return new HashMap();
        }
        Map<KeyT, ValueT> synchronizedMap = Collections.synchronizedMap(map);
        HashMap hashMap = new HashMap();
        hashMap.putAll(synchronizedMap);
        return hashMap;
    }

    public static <TypeT> List<TypeT> e(List<TypeT> list) {
        return g(list) ? new ArrayList() : list;
    }

    public static <TypeT> List<TypeT> f(Collection<TypeT> collection, jz.a<TypeT, Boolean> aVar) {
        if (collection == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (TypeT next : collection) {
            if (aVar.apply(next).booleanValue()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static <TypeT> boolean g(Collection<TypeT> collection) {
        return collection == null || collection.isEmpty();
    }

    public static <TypeT> boolean h(TypeT[] typetArr) {
        return typetArr == null || typetArr.length == 0;
    }

    public static <TypeT> boolean i(Collection<TypeT> collection) {
        return !g(collection);
    }

    public static <TypeT> boolean j(TypeT[] typetArr) {
        return !h(typetArr);
    }

    public static <TypeT, ReturnT> List<ReturnT> k(Collection<TypeT> collection, jz.a<TypeT, ReturnT> aVar) {
        if (collection == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (TypeT apply : collection) {
            arrayList.add(aVar.apply(apply));
        }
        return arrayList;
    }

    public static <TypeT> List<TypeT> l(List<TypeT> list) {
        return Collections.unmodifiableList(e(list));
    }
}
