package al;

import com.hbg.lib.common.utils.StringUtils;
import d7.q0;
import java.util.Comparator;

public final /* synthetic */ class c0 implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ c0 f3555b = new c0();

    public final int compare(Object obj, Object obj2) {
        return Integer.compare(q0.i(StringUtils.g((String) obj2)), q0.i(StringUtils.g((String) obj)));
    }
}
