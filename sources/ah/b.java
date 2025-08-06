package ah;

import android.util.Log;
import bh.j;
import com.hbg.lib.common.network.NetworkStatus;
import com.huobi.woodpecker.WoodPeckerSDK;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.util.HashMap;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f40690a = "";

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Long> f40691b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public long f40692c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40693d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40694e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f40695f;

    public b(String str) {
        this.f40690a = str;
    }

    public void a(String str, String str2, boolean z11) {
        if (!this.f40693d && !this.f40695f && !this.f40694e) {
            e(str, b(str2), z11, str2);
            this.f40693d = true;
        }
    }

    public long b(String str) {
        if (this.f40691b.get(str) != null) {
            this.f40691b.remove(str);
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f40692c;
        Log.d("TimeMonitor", str + l.f34627b + currentTimeMillis);
        this.f40691b.put(str, Long.valueOf(currentTimeMillis));
        return currentTimeMillis;
    }

    public void c() {
        d(true);
    }

    public void d(boolean z11) {
        if (this.f40691b.size() > 0) {
            this.f40691b.clear();
        }
        this.f40692c = System.currentTimeMillis();
        if (z11 && !NetworkStatus.c(j.c())) {
            this.f40695f = true;
        }
    }

    public void e(String str, long j11, boolean z11, String str2) {
        Log.i("TimeMonitor_End", "key:" + str + ", tag:" + str2 + " end : " + j11);
        if (z11) {
            WoodPeckerSDK.f().g().d(str, (double) j11, str2);
        }
    }
}
