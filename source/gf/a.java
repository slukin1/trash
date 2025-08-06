package gf;

import android.content.Context;
import com.hbg.lib.common.utils.FloatWindowUtil;
import com.hbg.lib.common.utils.SP;
import i6.d;
import i6.k;
import mf.q;

public class a {

    /* renamed from: f  reason: collision with root package name */
    public static String f29014f = "SP_MARKET_WIDGET_SWITCH";

    /* renamed from: g  reason: collision with root package name */
    public static String f29015g = "SP_MARKET_WIDGET_BG_ALPHA";

    /* renamed from: h  reason: collision with root package name */
    public static String f29016h = "SP_MARKET_WIDGET_CHANGED_ALPHA";

    /* renamed from: a  reason: collision with root package name */
    public Context f29017a;

    /* renamed from: b  reason: collision with root package name */
    public q f29018b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f29019c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f29020d;

    /* renamed from: e  reason: collision with root package name */
    public float f29021e;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static a f29022a = new a();
    }

    public static float b() {
        return b.f29022a.f29021e;
    }

    public static Context c() {
        return b.f29022a.f29017a;
    }

    public static boolean d() {
        return FloatWindowUtil.b(c());
    }

    public static void e() {
        g();
        n(false);
    }

    public static void g() {
        b.f29022a.f();
    }

    public static void h(Context context) {
        b.f29022a.a(context.getApplicationContext());
    }

    public static boolean i() {
        return b.f29022a.f29020d;
    }

    public static boolean j() {
        return b.f29022a.f29019c;
    }

    public static boolean k() {
        q qVar = b.f29022a.f29018b;
        return qVar != null && qVar.j();
    }

    public static void l(float f11, boolean z11) {
        b.f29022a.f29021e = f11;
        if (z11) {
            SP.p(f29015g, f11);
        }
        q qVar = b.f29022a.f29018b;
        if (qVar != null) {
            qVar.k(f11);
        }
    }

    public static void m(boolean z11) {
        b.f29022a.f29020d = z11;
        SP.y(f29016h, z11);
    }

    public static void n(boolean z11) {
        b.f29022a.f29019c = z11;
        SP.y(f29014f, z11);
    }

    public static boolean o(boolean z11) {
        if (d()) {
            n(true);
            b.f29022a.p();
            return true;
        } else if (z11) {
            FloatWindowUtil.a(c());
            return false;
        } else {
            k.e("without float window Permission !!!");
            return false;
        }
    }

    public final void a(Context context) {
        this.f29017a = context;
    }

    public final void f() {
        q qVar = this.f29018b;
        if (qVar != null) {
            qVar.f();
        }
    }

    public final void p() {
        if (this.f29018b == null) {
            this.f29018b = new q(this.f29017a);
        }
        this.f29018b.l();
    }

    public a() {
        this.f29019c = SP.l(f29014f, false);
        this.f29021e = SP.c(f29015g, 0.75f);
        this.f29020d = SP.l(f29016h, false);
        d.b("MarketWidgetManager-->mBgAlpha:" + this.f29021e);
    }
}
