package androidx.camera.core.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Quirks {
    private final List<Quirk> mQuirks;

    public Quirks(List<Quirk> list) {
        this.mQuirks = new ArrayList(list);
    }

    public boolean contains(Class<? extends Quirk> cls) {
        for (Quirk quirk : this.mQuirks) {
            if (cls.isAssignableFrom(quirk.getClass())) {
                return true;
            }
        }
        return false;
    }

    public <T extends Quirk> T get(Class<T> cls) {
        Iterator<Quirk> it2 = this.mQuirks.iterator();
        while (it2.hasNext()) {
            T t11 = (Quirk) it2.next();
            if (t11.getClass() == cls) {
                return t11;
            }
        }
        return null;
    }

    public <T extends Quirk> List<T> getAll(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        for (Quirk next : this.mQuirks) {
            if (cls.isAssignableFrom(next.getClass())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
