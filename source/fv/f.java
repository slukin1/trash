package fv;

import android.os.Looper;
import android.util.Printer;
import android.view.WindowManager;
import com.huobi.woodpecker.monitor.base.BaseMonitor;
import com.huobi.woodpecker.utils.ContextUtil;
import com.huobi.woodpecker.utils.ReflectUtils;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class f extends BaseMonitor {

    /* renamed from: j  reason: collision with root package name */
    public static final f f22780j = new f();

    /* renamed from: c  reason: collision with root package name */
    public c f22781c = new c();

    /* renamed from: d  reason: collision with root package name */
    public Printer f22782d = null;

    /* renamed from: e  reason: collision with root package name */
    public b f22783e;

    /* renamed from: f  reason: collision with root package name */
    public float f22784f = 60.0f;

    /* renamed from: g  reason: collision with root package name */
    public float f22785g = 60.0f;

    /* renamed from: h  reason: collision with root package name */
    public float f22786h = 1.6666667E7f;

    /* renamed from: i  reason: collision with root package name */
    public List<a> f22787i = new ArrayList();

    public interface a {
        void b(b bVar);
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public float f22788a = 60.0f;

        /* renamed from: b  reason: collision with root package name */
        public float f22789b = 1.6666667E7f;

        /* renamed from: c  reason: collision with root package name */
        public long f22790c;

        /* renamed from: d  reason: collision with root package name */
        public long f22791d;

        public b(float f11, float f12) {
            this.f22788a = f11;
            this.f22789b = f12;
        }

        public void a() {
            this.f22790c = 0;
            this.f22791d = 0;
        }

        public float b() {
            return this.f22789b;
        }

        public final String c() {
            float f11 = 1.0E9f / ((float) (this.f22791d - this.f22790c));
            NumberFormat numberInstance = NumberFormat.getNumberInstance();
            numberInstance.setMaximumFractionDigits(2);
            numberInstance.setRoundingMode(RoundingMode.UP);
            return numberInstance.format((double) Math.min(f11, this.f22788a));
        }

        public float d() {
            return Math.min(1.0E9f / ((float) (this.f22791d - this.f22790c)), this.f22788a);
        }

        public String toString() {
            return "LoopTimeRecord{startLoopTimeMs=" + this.f22790c + ", endLoopTimeMs=" + this.f22791d + ", fps=" + c() + '}';
        }
    }

    public class c implements Printer {
        public c() {
        }

        public void println(String str) {
            if (!(f.this.f22783e == null || str == null)) {
                if (str.startsWith(">>>>> Dispatching to")) {
                    f.this.f22783e.f22790c = System.nanoTime();
                } else if (str.startsWith("<<<<< Finished to")) {
                    f.this.f22783e.f22791d = System.nanoTime();
                    for (a b11 : f.this.f22787i) {
                        b11.b(f.this.f22783e);
                    }
                    f fVar = f.this;
                    float unused = fVar.f22784f = fVar.f22783e.d();
                    float unused2 = f.this.f22784f;
                    f.this.f22783e.a();
                }
            }
            if (f.this.f22782d != null) {
                f.this.f22782d.println(str);
            }
        }
    }

    public static f m() {
        return f22780j;
    }

    public void d() {
        Looper mainLooper = Looper.getMainLooper();
        this.f22782d = (Printer) ReflectUtils.a(Printer.class, Looper.class, "mLogging", mainLooper, true);
        mainLooper.setMessageLogging(this.f22781c);
        WindowManager windowManager = (WindowManager) ContextUtil.g().getSystemService("window");
        if (windowManager != null) {
            this.f22785g = windowManager.getDefaultDisplay().getRefreshRate();
        } else {
            this.f22785g = 60.0f;
        }
        float f11 = this.f22785g;
        float f12 = 1.0E9f / f11;
        this.f22786h = f12;
        this.f22783e = new b(f11, f12);
    }

    public void e() {
        Looper.getMainLooper().setMessageLogging(this.f22782d);
    }

    public void n(a aVar) {
        this.f22787i.add(aVar);
    }

    public void o(a aVar) {
        this.f22787i.remove(aVar);
    }
}
