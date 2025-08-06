package n20;

import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.a;
import org.joda.time.h;

public class q extends a implements l {

    /* renamed from: a  reason: collision with root package name */
    public static final q f22987a = new q();

    public Chronology a(Object obj, Chronology chronology) {
        return chronology == null ? a.c(((h) obj).getChronology()) : chronology;
    }

    public Chronology b(Object obj, DateTimeZone dateTimeZone) {
        return a(obj, (Chronology) null).withZone(dateTimeZone);
    }

    public Class<?> e() {
        return h.class;
    }

    public int[] i(h hVar, Object obj, Chronology chronology) {
        h hVar2 = (h) obj;
        int size = hVar.size();
        int[] iArr = new int[size];
        for (int i11 = 0; i11 < size; i11++) {
            iArr[i11] = hVar2.get(hVar.getFieldType(i11));
        }
        chronology.validate(hVar, iArr);
        return iArr;
    }
}
