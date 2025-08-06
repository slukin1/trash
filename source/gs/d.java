package gs;

import java.util.HashMap;
import java.util.Map;

public class d {

    /* renamed from: c  reason: collision with root package name */
    public static final d f84183c = new d();

    /* renamed from: a  reason: collision with root package name */
    public long f84184a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, f> f84185b;

    public d() {
        b();
    }

    public static d a() {
        return f84183c;
    }

    public final void b() {
        HashMap hashMap = new HashMap();
        this.f84185b = hashMap;
        hashMap.put("INDEX_STEP_1", new f("INDEX_STEP_1"));
        this.f84185b.put("INDEX_STEP_2", new f("INDEX_STEP_2"));
    }

    public void c(String str) {
    }

    public void d(String str) {
        f fVar;
        if (this.f84184a == 0 && (fVar = this.f84185b.get(str)) != null && !fVar.b()) {
            fVar.d(System.nanoTime());
        }
    }
}
