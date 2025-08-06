package n20;

import org.joda.time.Chronology;
import org.joda.time.a;
import org.joda.time.b;
import org.joda.time.c;
import org.joda.time.g;

public class p extends a implements i, g, m {

    /* renamed from: a  reason: collision with root package name */
    public static final p f22986a = new p();

    public boolean c(Object obj, Chronology chronology) {
        return true;
    }

    public void d(c cVar, Object obj, Chronology chronology) {
        g gVar = (g) obj;
        if (chronology == null) {
            chronology = a.j(gVar);
        }
        int[] iArr = chronology.get(cVar, gVar.getStartMillis(), gVar.getEndMillis());
        for (int i11 = 0; i11 < iArr.length; i11++) {
            cVar.setValue(i11, iArr[i11]);
        }
    }

    public Class<?> e() {
        return g.class;
    }

    public long g(Object obj) {
        return ((g) obj).toDurationMillis();
    }

    public void j(b bVar, Object obj, Chronology chronology) {
        g gVar = (g) obj;
        bVar.setInterval(gVar);
        if (chronology != null) {
            bVar.setChronology(chronology);
        } else {
            bVar.setChronology(gVar.getChronology());
        }
    }
}
