package gs;

import com.huobi.statistics.GrowingIOStatics;
import java.util.HashMap;
import java.util.Map;

public class e {

    /* renamed from: b  reason: collision with root package name */
    public static final e f84186b = new e();

    /* renamed from: a  reason: collision with root package name */
    public Map<String, f> f84187a = new HashMap();

    public static e b() {
        return f84186b;
    }

    public boolean a(String str, boolean z11, Map<String, Object> map) {
        f fVar = this.f84187a.get(str);
        if (fVar == null) {
            return false;
        }
        fVar.c(System.nanoTime());
        if (z11) {
            return d(str, map);
        }
        return true;
    }

    public void c(String str) {
        if (this.f84187a.containsKey(str)) {
            this.f84187a.remove(str);
        }
        f fVar = new f(str);
        fVar.d(System.nanoTime());
        this.f84187a.put(str, fVar);
    }

    public boolean d(String str, Map<String, Object> map) {
        f fVar = this.f84187a.get(str);
        if (fVar == null) {
            return false;
        }
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("PM_EVENT_TIME_S", Long.valueOf(fVar.f()));
        hashMap.put("PM_EVENT_TIME_MS", Long.valueOf(fVar.e()));
        GrowingIOStatics.c(str, hashMap);
        return true;
    }
}
