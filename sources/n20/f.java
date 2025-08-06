package n20;

import java.util.Date;
import org.joda.time.Chronology;

public final class f extends a implements h, l {

    /* renamed from: a  reason: collision with root package name */
    public static final f f22981a = new f();

    public Class<?> e() {
        return Date.class;
    }

    public long k(Object obj, Chronology chronology) {
        return ((Date) obj).getTime();
    }
}
