package pk;

import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import tg.r;

public class e {

    /* renamed from: c  reason: collision with root package name */
    public static volatile e f47719c;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Boolean> f47720a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public Boolean f47721b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f47722a;

        /* renamed from: b  reason: collision with root package name */
        public String f47723b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f47724c;

        public a(boolean z11, String str, boolean z12) {
            this.f47722a = z11;
            this.f47723b = str;
            this.f47724c = z12;
        }
    }

    public static e a() {
        if (f47719c == null) {
            synchronized (e.class) {
                if (f47719c == null) {
                    f47719c = new e();
                }
            }
        }
        return f47719c;
    }

    public boolean b(boolean z11, String str) {
        String str2 = z11 ? "quan" : "zhu";
        HashMap<String, Boolean> hashMap = this.f47720a;
        Boolean bool = hashMap.get("position_mode_" + r.x().s() + "_" + str2 + "_" + str);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean c() {
        Boolean bool = this.f47721b;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public void d(boolean z11, String str, boolean z12) {
        String str2 = z11 ? "quan" : "zhu";
        HashMap<String, Boolean> hashMap = this.f47720a;
        hashMap.put("position_mode_" + r.x().s() + "_" + str2 + "_" + str, Boolean.valueOf(z12));
        EventBus.d().k(new a(z11, str, z12));
    }

    public void e(boolean z11) {
        this.f47721b = Boolean.valueOf(z11);
        EventBus.d().k(new a(true, "", z11));
    }
}
