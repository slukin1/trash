package rt;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.socket.listener.LastKlineListener;
import g9.a;
import java.lang.ref.SoftReference;
import pro.huobi.R;

public class a0 {

    /* renamed from: a  reason: collision with root package name */
    public String f84735a;

    /* renamed from: b  reason: collision with root package name */
    public String f84736b;

    /* renamed from: c  reason: collision with root package name */
    public SymbolBean f84737c;

    /* renamed from: d  reason: collision with root package name */
    public SymbolBean f84738d;

    /* renamed from: e  reason: collision with root package name */
    public SoftReference<e> f84739e;

    /* renamed from: f  reason: collision with root package name */
    public Context f84740f;

    /* renamed from: g  reason: collision with root package name */
    public LastKlineListener f84741g = new a();

    /* renamed from: h  reason: collision with root package name */
    public LastKlineListener f84742h = new b();

    /* renamed from: i  reason: collision with root package name */
    public a.d f84743i = new c();

    /* renamed from: j  reason: collision with root package name */
    public a.d f84744j = new d();

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
                rt.a0 r1 = rt.a0.this
                java.lang.String r1 = r1.f84735a
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
                rt.a0 r9 = rt.a0.this
                android.content.Context r9 = r9.f84740f
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
                rt.a0 r9 = rt.a0.this
                android.content.Context r9 = r9.f84740f
                int r1 = com.hbg.lib.core.util.w.d()
                int r9 = androidx.core.content.ContextCompat.getColor(r9, r1)
                boolean r1 = com.hbg.lib.core.util.w.l()
                if (r1 == 0) goto L_0x0071
                goto L_0x0044
            L_0x0061:
                rt.a0 r9 = rt.a0.this
                android.content.Context r9 = r9.f84740f
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
                rt.a0 r1 = rt.a0.this
                rt.a0$e r1 = r1.f()
                r1.Og(r0, r9, r5)
            L_0x00b6:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rt.a0.a.f(com.hbg.lib.network.pro.socket.response.LastKlineResponse):void");
        }
    }

    public class b extends LastKlineListener {
        public b() {
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
                rt.a0 r1 = rt.a0.this
                java.lang.String r1 = r1.f84736b
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
                rt.a0 r9 = rt.a0.this
                android.content.Context r9 = r9.f84740f
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
                rt.a0 r9 = rt.a0.this
                android.content.Context r9 = r9.f84740f
                int r1 = com.hbg.lib.core.util.w.d()
                int r9 = androidx.core.content.ContextCompat.getColor(r9, r1)
                boolean r1 = com.hbg.lib.core.util.w.l()
                if (r1 == 0) goto L_0x0071
                goto L_0x0044
            L_0x0061:
                rt.a0 r9 = rt.a0.this
                android.content.Context r9 = r9.f84740f
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
                rt.a0 r1 = rt.a0.this
                rt.a0$e r1 = r1.f()
                r1.fg(r0, r9, r5)
            L_0x00b6:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rt.a0.b.f(com.hbg.lib.network.pro.socket.response.LastKlineResponse):void");
        }
    }

    public class c implements a.d {
        public c() {
        }

        public void a() {
            a0 a0Var = a0.this;
            a0Var.k(a0Var.f84737c);
        }
    }

    public class d implements a.d {
        public d() {
        }

        public void a() {
            a0 a0Var = a0.this;
            a0Var.k(a0Var.f84738d);
        }
    }

    public interface e {
        void Og(String str, int i11, int i12);

        void fg(String str, int i11, int i12);
    }

    public a0(e eVar, Context context) {
        this.f84739e = new SoftReference<>(eVar);
        this.f84740f = context;
        i();
        j();
    }

    public e f() {
        return this.f84739e.get();
    }

    public void g(SymbolBean symbolBean) {
        SymbolBean symbolBean2;
        if (symbolBean == null || (symbolBean2 = this.f84737c) == null || !symbolBean2.getSymbol().equals(symbolBean.getSymbol()) || symbolBean.getState() == null || !symbolBean.getState().equals(this.f84737c.getState()) || this.f84737c.isWhiteEnabled() != symbolBean.isWhiteEnabled()) {
            m(this.f84737c);
            k(symbolBean);
        }
    }

    public void h(SymbolBean symbolBean) {
        SymbolBean symbolBean2;
        if (symbolBean == null || (symbolBean2 = this.f84738d) == null || !symbolBean2.getSymbol().equals(symbolBean.getSymbol()) || symbolBean.getState() == null || !symbolBean.getState().equals(this.f84738d.getState()) || this.f84738d.isWhiteEnabled() != symbolBean.isWhiteEnabled()) {
            n(this.f84738d);
            l(symbolBean);
        }
    }

    public final void i() {
        f().Og("--", ContextCompat.getColor(this.f84740f, R.color.baseColorSecondaryText), R.drawable.shape_trade_price_change_default);
    }

    public final void j() {
        f().fg("--", ContextCompat.getColor(this.f84740f, R.color.baseColorSecondaryText), R.drawable.shape_trade_price_change_default);
    }

    public void k(SymbolBean symbolBean) {
        if (symbolBean != null) {
            if (!SymbolBean.PRE_ONLINE.equals(symbolBean.getState())) {
                x8.a.a().g(true, symbolBean.getSymbol(), Period.day, this.f84741g);
                this.f84735a = symbolBean.getSymbol();
                this.f84737c = symbolBean;
            } else if (symbolBean.isWhiteEnabled()) {
                x8.a.a().g(true, symbolBean.getSymbol(), Period.day, this.f84741g);
                this.f84735a = symbolBean.getSymbol();
                this.f84737c = symbolBean;
            }
            x8.a.a().d(this.f84743i);
        }
    }

    public void l(SymbolBean symbolBean) {
        if (symbolBean != null) {
            if (!SymbolBean.PRE_ONLINE.equals(symbolBean.getState())) {
                x8.a.a().g(true, symbolBean.getSymbol(), Period.day, this.f84742h);
                this.f84736b = symbolBean.getSymbol();
                this.f84738d = symbolBean;
            } else if (symbolBean.isWhiteEnabled()) {
                x8.a.a().g(true, symbolBean.getSymbol(), Period.day, this.f84742h);
                this.f84736b = symbolBean.getSymbol();
                this.f84738d = symbolBean;
            }
            x8.a.a().d(this.f84744j);
        }
    }

    public void m(SymbolBean symbolBean) {
        if (symbolBean != null && this.f84737c != null && !TextUtils.isEmpty(symbolBean.getSymbol())) {
            x8.a.a().g(false, symbolBean.getSymbol(), Period.day, this.f84741g);
            x8.a.a().c(this.f84743i);
            i();
            this.f84735a = "";
            this.f84737c = null;
        }
    }

    public void n(SymbolBean symbolBean) {
        if (symbolBean != null && this.f84738d != null && !TextUtils.isEmpty(symbolBean.getSymbol())) {
            x8.a.a().g(false, symbolBean.getSymbol(), Period.day, this.f84742h);
            x8.a.a().c(this.f84744j);
            j();
            this.f84736b = "";
            this.f84738d = null;
        }
    }
}
