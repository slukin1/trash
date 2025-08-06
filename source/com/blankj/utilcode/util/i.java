package com.blankj.utilcode.util;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Long> f63539a = new ConcurrentHashMap(64);

    public static void a(long j11) {
        Map<String, Long> map = f63539a;
        if (map.size() >= 64) {
            Iterator<Map.Entry<String, Long>> it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                if (j11 >= ((Long) it2.next().getValue()).longValue()) {
                    it2.remove();
                }
            }
        }
    }

    public static boolean b(View view, long j11) {
        Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return c(String.valueOf(view.hashCode()), j11);
    }

    public static boolean c(String str, long j11) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("The key is null.");
        } else if (j11 >= 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            a(elapsedRealtime);
            Map<String, Long> map = f63539a;
            Long l11 = map.get(str);
            if (l11 != null && elapsedRealtime < l11.longValue()) {
                return false;
            }
            map.put(str, Long.valueOf(elapsedRealtime + j11));
            return true;
        } else {
            throw new IllegalArgumentException("The duration is less than 0.");
        }
    }
}
