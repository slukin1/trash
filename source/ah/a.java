package ah;

import android.app.Activity;
import android.os.SystemClock;
import com.google.gson.Gson;
import com.hbg.lib.common.utils.LogAndWoodRecorder;
import com.huobi.activity.StartFlashActivity;
import com.huobi.main.ui.HuobiMainActivity;
import gs.g;
import java.util.HashMap;

public class a {

    /* renamed from: g  reason: collision with root package name */
    public static a f40683g;

    /* renamed from: a  reason: collision with root package name */
    public long f40684a;

    /* renamed from: b  reason: collision with root package name */
    public long f40685b;

    /* renamed from: c  reason: collision with root package name */
    public Boolean f40686c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40687d = false;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f40688e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f40689f = false;

    public static a c() {
        a aVar = f40683g;
        if (aVar != null) {
            return aVar;
        }
        synchronized (a.class) {
            if (f40683g == null) {
                f40683g = new a();
            }
        }
        return f40683g;
    }

    public void a() {
        this.f40684a = SystemClock.elapsedRealtime();
        if (this.f40685b != 0) {
            this.f40685b = 0;
        }
    }

    public void b() {
        if (!this.f40688e) {
            this.f40688e = true;
            if (this.f40686c.booleanValue() && this.f40685b > this.f40684a) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                HashMap hashMap = new HashMap();
                hashMap.put("Step1", Long.valueOf(this.f40685b - this.f40684a));
                hashMap.put("Step2", Long.valueOf(elapsedRealtime - this.f40685b));
                g("appStartTime", hashMap);
            }
        }
    }

    public void d() {
        if (!this.f40689f && this.f40685b == 0) {
            this.f40685b = SystemClock.elapsedRealtime();
        }
    }

    public void e(Activity activity) {
        if (this.f40686c == null) {
            if (this.f40687d && (activity instanceof HuobiMainActivity)) {
                this.f40686c = Boolean.TRUE;
            } else if (activity instanceof StartFlashActivity) {
                this.f40687d = true;
            } else {
                this.f40686c = Boolean.FALSE;
            }
        }
    }

    public void f() {
        this.f40689f = true;
    }

    public void g(String str, HashMap<String, Object> hashMap) {
        g.i(str, hashMap);
        if (!hashMap.isEmpty()) {
            LogAndWoodRecorder.a(str, new Gson().toJson((Object) hashMap));
        }
    }
}
