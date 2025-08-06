package n20;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.c;
import org.joda.time.field.e;
import org.joda.time.format.b;
import org.joda.time.format.i;
import org.joda.time.format.j;
import org.joda.time.format.n;
import org.joda.time.h;

public class s extends a implements h, l, g, m, i {

    /* renamed from: a  reason: collision with root package name */
    public static final s f22989a = new s();

    public void d(c cVar, Object obj, Chronology chronology) {
        String str = (String) obj;
        n a11 = j.a();
        cVar.clear();
        int f11 = a11.f(cVar, str, 0);
        if (f11 < str.length()) {
            if (f11 < 0) {
                a11.j(cVar.getPeriodType()).g(str);
            }
            throw new IllegalArgumentException("Invalid format: \"" + str + '\"');
        }
    }

    public Class<?> e() {
        return String.class;
    }

    public int[] f(h hVar, Object obj, Chronology chronology, b bVar) {
        if (bVar.e() != null) {
            chronology = chronology.withZone(bVar.e());
        }
        return chronology.get(hVar, bVar.u(chronology).j((String) obj));
    }

    public long g(Object obj) {
        long j11;
        long j12;
        long j13;
        String str = (String) obj;
        int length = str.length();
        if (length >= 4 && ((str.charAt(0) == 'P' || str.charAt(0) == 'p') && (str.charAt(1) == 'T' || str.charAt(1) == 't'))) {
            int i11 = length - 1;
            if (str.charAt(i11) == 'S' || str.charAt(i11) == 's') {
                String substring = str.substring(2, i11);
                int i12 = 0;
                int i13 = -1;
                for (int i14 = 0; i14 < substring.length(); i14++) {
                    if (substring.charAt(i14) < '0' || substring.charAt(i14) > '9') {
                        if (i14 == 0 && substring.charAt(0) == '-') {
                            i12 = 1;
                        } else if (i14 > i12 && substring.charAt(i14) == '.' && i13 == -1) {
                            i13 = i14;
                        } else {
                            throw new IllegalArgumentException("Invalid format: \"" + str + '\"');
                        }
                    }
                }
                if (i13 > 0) {
                    j12 = Long.parseLong(substring.substring(i12, i13));
                    String substring2 = substring.substring(i13 + 1);
                    if (substring2.length() != 3) {
                        substring2 = (substring2 + "000").substring(0, 3);
                    }
                    j11 = (long) Integer.parseInt(substring2);
                } else {
                    if (i12 != 0) {
                        j13 = Long.parseLong(substring.substring(i12, substring.length()));
                    } else {
                        j13 = Long.parseLong(substring);
                    }
                    j12 = j13;
                    j11 = 0;
                }
                if (i12 != 0) {
                    return e.e(e.h(-j12, 1000), -j11);
                }
                return e.e(e.h(j12, 1000), j11);
            }
        }
        throw new IllegalArgumentException("Invalid format: \"" + str + '\"');
    }

    public void j(org.joda.time.b bVar, Object obj, Chronology chronology) {
        Period period;
        long j11;
        org.joda.time.b bVar2 = bVar;
        Chronology chronology2 = chronology;
        String str = (String) obj;
        int indexOf = str.indexOf(47);
        if (indexOf >= 0) {
            String substring = str.substring(0, indexOf);
            if (substring.length() > 0) {
                String substring2 = str.substring(indexOf + 1);
                if (substring2.length() > 0) {
                    b u11 = i.i().u(chronology2);
                    n a11 = j.a();
                    long j12 = 0;
                    char charAt = substring.charAt(0);
                    Chronology chronology3 = null;
                    if (charAt == 'P' || charAt == 'p') {
                        period = a11.j(h(substring)).h(substring);
                    } else {
                        DateTime f11 = u11.f(substring);
                        j12 = f11.getMillis();
                        chronology3 = f11.getChronology();
                        period = null;
                    }
                    char charAt2 = substring2.charAt(0);
                    if (charAt2 != 'P' && charAt2 != 'p') {
                        DateTime f12 = u11.f(substring2);
                        j11 = f12.getMillis();
                        if (chronology3 == null) {
                            chronology3 = f12.getChronology();
                        }
                        if (chronology2 != null) {
                            chronology3 = chronology2;
                        }
                        if (period != null) {
                            j12 = chronology3.add((org.joda.time.i) period, j11, -1);
                        }
                    } else if (period == null) {
                        Period h11 = a11.j(h(substring2)).h(substring2);
                        if (chronology2 != null) {
                            chronology3 = chronology2;
                        }
                        j11 = chronology3.add((org.joda.time.i) h11, j12, 1);
                    } else {
                        throw new IllegalArgumentException("Interval composed of two durations: " + str);
                    }
                    bVar2.setInterval(j12, j11);
                    bVar2.setChronology(chronology3);
                    return;
                }
                throw new IllegalArgumentException("Format invalid: " + str);
            }
            throw new IllegalArgumentException("Format invalid: " + str);
        }
        throw new IllegalArgumentException("Format requires a '/' separator: " + str);
    }

    public long k(Object obj, Chronology chronology) {
        return i.i().u(chronology).j((String) obj);
    }
}
