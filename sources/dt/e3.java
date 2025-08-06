package dt;

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

public class e3 {

    /* renamed from: a  reason: collision with root package name */
    public String f84062a;

    /* renamed from: b  reason: collision with root package name */
    public SymbolBean f84063b;

    /* renamed from: c  reason: collision with root package name */
    public TradeType f84064c;

    /* renamed from: d  reason: collision with root package name */
    public SoftReference<c> f84065d;

    /* renamed from: e  reason: collision with root package name */
    public Context f84066e;

    /* renamed from: f  reason: collision with root package name */
    public LastKlineListener f84067f = new a();

    /* renamed from: g  reason: collision with root package name */
    public a.d f84068g = new b();

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
        /* renamed from: j */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void f(com.hbg.lib.network.pro.socket.response.LastKlineResponse r9) {
            /*
                r8 = this;
                com.hbg.lib.network.pro.socket.bean.KlineInfo r0 = r9.getTick()
                if (r0 == 0) goto L_0x00b6
                dt.e3 r1 = dt.e3.this
                java.lang.String r1 = r1.f84062a
                java.lang.String r9 = r9.getSymbol()
                boolean r9 = r1.equals(r9)
                if (r9 != 0) goto L_0x0018
                goto L_0x00b6
            L_0x0018:
                double r1 = r0.getClose()
                double r3 = r0.getOpen()
                double r1 = r1 - r3
                r3 = 0
                int r9 = java.lang.Double.compare(r1, r3)
                r5 = 2131235297(0x7f0811e1, float:1.8086784E38)
                r6 = 2131235298(0x7f0811e2, float:1.8086786E38)
                if (r9 <= 0) goto L_0x0046
                dt.e3 r9 = dt.e3.this
                android.content.Context r9 = r9.f84066e
                int r1 = com.hbg.lib.core.util.w.h()
                int r9 = androidx.core.content.ContextCompat.getColor(r9, r1)
                boolean r1 = com.hbg.lib.core.util.w.l()
                if (r1 == 0) goto L_0x0044
                goto L_0x0071
            L_0x0044:
                r5 = r6
                goto L_0x0071
            L_0x0046:
                int r9 = java.lang.Double.compare(r1, r3)
                if (r9 >= 0) goto L_0x0061
                dt.e3 r9 = dt.e3.this
                android.content.Context r9 = r9.f84066e
                int r1 = com.hbg.lib.core.util.w.d()
                int r9 = androidx.core.content.ContextCompat.getColor(r9, r1)
                boolean r1 = com.hbg.lib.core.util.w.l()
                if (r1 == 0) goto L_0x0071
                goto L_0x0044
            L_0x0061:
                dt.e3 r9 = dt.e3.this
                android.content.Context r9 = r9.f84066e
                r1 = 2131099916(0x7f06010c, float:1.7812199E38)
                int r9 = androidx.core.content.ContextCompat.getColor(r9, r1)
                r5 = 2131235296(0x7f0811e0, float:1.8086782E38)
            L_0x0071:
                double r1 = r0.getOpen()
                int r1 = java.lang.Double.compare(r1, r3)
                java.lang.String r2 = ""
                if (r1 != 0) goto L_0x0097
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                int r1 = com.hbg.lib.data.symbol.PrecisionUtil.v(r2)
                java.lang.String r1 = i6.m.i(r3, r1)
                r0.append(r1)
                java.lang.String r1 = "%"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                goto L_0x00ad
            L_0x0097:
                double r3 = r0.getClose()
                double r6 = r0.getOpen()
                double r3 = r3 - r6
                double r0 = r0.getOpen()
                double r3 = r3 / r0
                int r0 = com.hbg.lib.data.symbol.PrecisionUtil.v(r2)
                java.lang.String r0 = i6.m.S(r3, r0)
            L_0x00ad:
                dt.e3 r1 = dt.e3.this
                dt.e3$c r1 = r1.c()
                r1.O0(r0, r9, r5)
            L_0x00b6:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: dt.e3.a.f(com.hbg.lib.network.pro.socket.response.LastKlineResponse):void");
        }
    }

    public class b implements a.d {
        public b() {
        }

        public void a() {
            e3 e3Var = e3.this;
            e3Var.f(e3Var.f84062a);
        }
    }

    public interface c {
        void O0(String str, int i11, int i12);
    }

    public e3(TradeType tradeType, c cVar, Context context) {
        this.f84064c = tradeType;
        this.f84065d = new SoftReference<>(cVar);
        this.f84066e = context;
        e();
    }

    public c c() {
        return this.f84065d.get();
    }

    public void d(String str) {
        SymbolBean J = a1.v().J(str, TradeType.PRO);
        if (TextUtils.isEmpty(str) || !str.equals(this.f84062a) || this.f84063b == null || J == null || J.getState() == null || !J.getState().equals(this.f84063b.getState()) || this.f84063b.isWhiteEnabled() != J.isWhiteEnabled()) {
            g(this.f84062a);
            f(str);
        }
    }

    public final void e() {
        c().O0("--", ContextCompat.getColor(this.f84066e, R.color.baseColorSecondaryText), R.drawable.shape_trade_price_change_default);
    }

    public void f(String str) {
        SymbolBean J = a1.v().J(str, this.f84064c);
        if (J == null || !SymbolBean.PRE_ONLINE.equals(J.getState())) {
            x8.a.a().g(true, str, Period.day, this.f84067f);
            this.f84062a = str;
            this.f84063b = J;
        } else if (J.isWhiteEnabled()) {
            x8.a.a().g(true, str, Period.day, this.f84067f);
            this.f84062a = str;
            this.f84063b = J;
        }
        x8.a.a().d(this.f84068g);
    }

    public void g(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f84062a)) {
            if (TradeType.isContract(this.f84064c)) {
                q7.a.a().g(false, str, Period.day, this.f84067f);
                q7.a.a().c(this.f84068g);
            } else {
                x8.a.a().g(false, str, Period.day, this.f84067f);
                x8.a.a().c(this.f84068g);
            }
            e();
            this.f84062a = "";
            this.f84063b = null;
        }
    }
}
