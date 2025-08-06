package n20;

import org.joda.time.Chronology;
import org.joda.time.a;
import org.joda.time.c;
import org.joda.time.e;
import org.joda.time.i;

public class n extends a implements g, m {

    /* renamed from: a  reason: collision with root package name */
    public static final n f22984a = new n();

    public void d(c cVar, Object obj, Chronology chronology) {
        int[] iArr = a.c(chronology).get((i) cVar, ((e) obj).getMillis());
        for (int i11 = 0; i11 < iArr.length; i11++) {
            cVar.setValue(i11, iArr[i11]);
        }
    }

    public Class<?> e() {
        return e.class;
    }

    public long g(Object obj) {
        return ((e) obj).getMillis();
    }
}
