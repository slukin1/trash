package i6;

import android.widget.PopupWindow;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static List<SoftReference<PopupWindow>> f68174a = new ArrayList();

    public static void a(PopupWindow popupWindow) {
        f68174a.add(new SoftReference(popupWindow));
    }

    public static boolean b() {
        List<SoftReference<PopupWindow>> list = f68174a;
        return list != null && !list.isEmpty();
    }

    public static void c(PopupWindow popupWindow) {
        Iterator<SoftReference<PopupWindow>> it2 = f68174a.iterator();
        while (it2.hasNext()) {
            SoftReference next = it2.next();
            if (!(next == null || next.get() == null || next.get() != popupWindow)) {
                it2.remove();
            }
        }
    }
}
