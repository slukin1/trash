package rt;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.socket.listener.LastKlineListener;
import d7.a1;
import g9.a;
import java.lang.ref.SoftReference;
import pro.huobi.R;

public class b0 {

    /* renamed from: a  reason: collision with root package name */
    public String f84749a;

    /* renamed from: b  reason: collision with root package name */
    public SymbolBean f84750b;

    /* renamed from: c  reason: collision with root package name */
    public TradeType f84751c;

    /* renamed from: d  reason: collision with root package name */
    public SoftReference<c> f84752d;

    /* renamed from: e  reason: collision with root package name */
    public Context f84753e;

    /* renamed from: f  reason: collision with root package name */
    public LastKlineListener f84754f = new a();

    /* renamed from: g  reason: collision with root package name */
    public a.d f84755g = new b();

    public class a extends LastKlineListener {
        public a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x005e, code lost:
            if (com.hbg.lib.core.util.w.l() != false) goto L_0x0044;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0041, code lost:
            if (com.hbg.lib.core.util.w.l() != false) goto L_0x0071;
         */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x007d  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0097  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00b7  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00ba  */
        /* renamed from: j */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void f(com.hbg.lib.network.pro.socket.response.LastKlineResponse r11) {
            /*
                r10 = this;
                com.hbg.lib.network.pro.socket.bean.KlineInfo r0 = r11.getTick()
                if (r0 == 0) goto L_0x00db
                rt.b0 r1 = rt.b0.this
                java.lang.String r1 = r1.f84749a
                java.lang.String r11 = r11.getSymbol()
                boolean r11 = r1.equals(r11)
                if (r11 != 0) goto L_0x0018
                goto L_0x00db
            L_0x0018:
                double r1 = r0.getClose()
                double r3 = r0.getOpen()
                double r1 = r1 - r3
                r3 = 0
                int r11 = java.lang.Double.compare(r1, r3)
                r5 = 2131235297(0x7f0811e1, float:1.8086784E38)
                r6 = 2131235298(0x7f0811e2, float:1.8086786E38)
                if (r11 <= 0) goto L_0x0046
                rt.b0 r11 = rt.b0.this
                android.content.Context r11 = r11.f84753e
                int r1 = com.hbg.lib.core.util.w.h()
                int r11 = androidx.core.content.ContextCompat.getColor(r11, r1)
                boolean r1 = com.hbg.lib.core.util.w.l()
                if (r1 == 0) goto L_0x0044
                goto L_0x0071
            L_0x0044:
                r5 = r6
                goto L_0x0071
            L_0x0046:
                int r11 = java.lang.Double.compare(r1, r3)
                if (r11 >= 0) goto L_0x0061
                rt.b0 r11 = rt.b0.this
                android.content.Context r11 = r11.f84753e
                int r1 = com.hbg.lib.core.util.w.d()
                int r11 = androidx.core.content.ContextCompat.getColor(r11, r1)
                boolean r1 = com.hbg.lib.core.util.w.l()
                if (r1 == 0) goto L_0x0071
                goto L_0x0044
            L_0x0061:
                rt.b0 r11 = rt.b0.this
                android.content.Context r11 = r11.f84753e
                r1 = 2131099916(0x7f06010c, float:1.7812199E38)
                int r11 = androidx.core.content.ContextCompat.getColor(r11, r1)
                r5 = 2131235296(0x7f0811e0, float:1.8086782E38)
            L_0x0071:
                double r1 = r0.getOpen()
                int r1 = java.lang.Double.compare(r1, r3)
                java.lang.String r2 = ""
                if (r1 != 0) goto L_0x0097
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                int r2 = com.hbg.lib.data.symbol.PrecisionUtil.v(r2)
                java.lang.String r2 = i6.m.i(r3, r2)
                r1.append(r2)
                java.lang.String r2 = "%"
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                goto L_0x00ad
            L_0x0097:
                double r6 = r0.getClose()
                double r8 = r0.getOpen()
                double r6 = r6 - r8
                double r8 = r0.getOpen()
                double r6 = r6 / r8
                int r1 = com.hbg.lib.data.symbol.PrecisionUtil.v(r2)
                java.lang.String r1 = i6.m.S(r6, r1)
            L_0x00ad:
                double r6 = r0.getClose()
                int r2 = java.lang.Double.compare(r6, r3)
                if (r2 != 0) goto L_0x00ba
                java.lang.String r0 = "--"
                goto L_0x00d2
            L_0x00ba:
                double r2 = r0.getClose()
                rt.b0 r0 = rt.b0.this
                java.lang.String r0 = r0.f84749a
                rt.b0 r4 = rt.b0.this
                com.hbg.lib.data.symbol.TradeType r4 = r4.f84751c
                int r0 = com.hbg.lib.data.symbol.PrecisionUtil.w(r0, r4)
                java.lang.String r0 = i6.m.i(r2, r0)
            L_0x00d2:
                rt.b0 r2 = rt.b0.this
                rt.b0$c r2 = r2.d()
                r2.t7(r0, r1, r11, r5)
            L_0x00db:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rt.b0.a.f(com.hbg.lib.network.pro.socket.response.LastKlineResponse):void");
        }
    }

    public class b implements a.d {
        public b() {
        }

        public void a() {
            b0 b0Var = b0.this;
            b0Var.g(b0Var.f84749a);
        }
    }

    public interface c {
        void t7(String str, String str2, int i11, int i12);
    }

    public b0(TradeType tradeType, c cVar, Context context) {
        this.f84751c = tradeType;
        this.f84752d = new SoftReference<>(cVar);
        this.f84753e = context;
        f();
    }

    public c d() {
        return this.f84752d.get();
    }

    public void e(String str) {
        SymbolBean J = a1.v().J(str, TradeType.PRO);
        if (TextUtils.isEmpty(str) || !str.equals(this.f84749a) || this.f84750b == null || J == null || J.getState() == null || !J.getState().equals(this.f84750b.getState()) || this.f84750b.isWhiteEnabled() != J.isWhiteEnabled()) {
            h(this.f84749a);
            g(str);
        }
    }

    public final void f() {
        d().t7("--", "--", ContextCompat.getColor(this.f84753e, R.color.baseColorSecondaryText), R.drawable.shape_trade_price_change_default);
    }

    public void g(String str) {
        SymbolBean J = a1.v().J(str, this.f84751c);
        if (J == null || !SymbolBean.PRE_ONLINE.equals(J.getState())) {
            x8.a.a().g(true, str, Period.day, this.f84754f);
            this.f84749a = str;
            this.f84750b = J;
        } else if (J.isWhiteEnabled()) {
            x8.a.a().g(true, str, Period.day, this.f84754f);
            this.f84749a = str;
            this.f84750b = J;
        }
        x8.a.a().d(this.f84755g);
    }

    public void h(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f84749a)) {
            if (TradeType.isContract(this.f84751c)) {
                q7.a.a().g(false, str, Period.day, this.f84754f);
                q7.a.a().c(this.f84755g);
            } else {
                x8.a.a().g(false, str, Period.day, this.f84754f);
                x8.a.a().c(this.f84755g);
            }
            f();
            this.f84749a = "";
            this.f84750b = null;
        }
    }
}
