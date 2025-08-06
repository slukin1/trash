package com.huobi.c2c.lend.view;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.widgets.CommonEditText;
import com.hbg.lib.widgets.MyNestedScrollView;
import com.huobi.c2c.lend.view.C2CLendOrderLayout;
import com.huobi.c2c.lend.view.C2CLendTradeLayout;
import com.huobi.c2c.util.o;
import com.huobi.page.SmartRefreshHeader;
import com.huobi.view.bubbleseekbar.BubbleSeekBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.m;
import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import ky.j;
import pro.huobi.R;
import qi.q;
import qi.r;
import qi.s;

public class C2CLendTradeView2 extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public SmartRefreshLayout f42970b;

    /* renamed from: c  reason: collision with root package name */
    public SmartRefreshHeader f42971c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f42972d;

    /* renamed from: e  reason: collision with root package name */
    public View f42973e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f42974f;

    /* renamed from: g  reason: collision with root package name */
    public MyNestedScrollView f42975g;

    /* renamed from: h  reason: collision with root package name */
    public View f42976h;

    /* renamed from: i  reason: collision with root package name */
    public C2CLendTradeLayout f42977i;

    /* renamed from: j  reason: collision with root package name */
    public C2CLendOrderLayout f42978j;

    /* renamed from: k  reason: collision with root package name */
    public final String f42979k;

    /* renamed from: l  reason: collision with root package name */
    public final g f42980l;

    /* renamed from: m  reason: collision with root package name */
    public String f42981m;

    /* renamed from: n  reason: collision with root package name */
    public String f42982n;

    public class a implements BubbleSeekBar.OnProgressChangedListener {
        public a() {
        }

        public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int i11, float f11) {
        }

        public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int i11, float f11, boolean z11) {
        }

        public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int i11, float f11, boolean z11) {
            i6.d.b("C2CLendTradeView-->onProgressChanged--> progress:" + i11 + " progressFloat:" + f11 + " fromUser:" + z11);
            if (z11) {
                C2CLendTradeView2.this.f42977i.getHuobiKeyboardHelper().hideKeyboard();
                if (m.a(C2CLendTradeView2.this.f42981m).doubleValue() > 0.0d) {
                    String str = "";
                    if (C2CLendTradeView2.this.f42981m != null) {
                        if (!(m.a(C2CLendTradeView2.this.f42981m).compareTo(BigDecimal.ZERO) == 0 || i11 == 0)) {
                            str = m.q(m.a(C2CLendTradeView2.this.f42981m).multiply(m.a(String.valueOf(i11))).divide(m.a("100"), 8, 1), o.a());
                        }
                        C2CLendTradeView2.this.f42977i.setAmountEtText(str);
                        return;
                    }
                    C2CLendTradeView2.this.f42977i.setAmountEtText(str);
                }
            }
        }
    }

    public class b implements C2CLendOrderLayout.a {
        public b() {
        }

        public void c(boolean z11) {
            if (C2CLendTradeView2.this.f42980l != null) {
                C2CLendTradeView2.this.f42980l.c(z11);
            }
        }

        public void d() {
            C2CLendTradeView2.this.k();
            if (C2CLendTradeView2.this.f42980l != null) {
                C2CLendTradeView2.this.f42980l.l(C2CLendTradeView2.this.f42979k);
            }
        }
    }

    public class c implements C2CLendTradeLayout.c {
        public c() {
        }

        public void a() {
            if (C2CLendTradeView2.this.f42980l != null) {
                C2CLendTradeView2.this.f42980l.a();
            }
        }

        public void d(boolean z11) {
            if (C2CLendTradeView2.this.f42980l != null) {
                C2CLendTradeView2.this.f42980l.d(z11);
            }
        }

        public void e() {
            C2CLendTradeView2.this.k();
            if (C2CLendTradeView2.this.f42980l != null) {
                C2CLendTradeView2.this.f42980l.e();
            }
        }

        public void g(boolean z11) {
            if (C2CLendTradeView2.this.f42980l != null) {
                C2CLendTradeView2.this.f42980l.g(z11);
            }
        }

        public void h(View view) {
            if (C2CLendTradeView2.this.f42980l != null) {
                C2CLendTradeView2.this.f42980l.h(view);
            }
        }
    }

    public class d implements ny.d {
        public d() {
        }

        public void P8(j jVar) {
        }

        public void bf(j jVar) {
            if (C2CLendTradeView2.this.f42980l == null || !C2CLendTradeView2.this.f42980l.isCanBeSeen()) {
                C2CLendTradeView2.this.v(true);
            } else {
                C2CLendTradeView2.this.f42980l.onRefresh();
            }
        }
    }

    public class e implements CommonEditText.b {
        public e() {
        }

        public boolean b() {
            if (C2CLendTradeView2.this.f42980l != null) {
                return C2CLendTradeView2.this.f42980l.b();
            }
            return false;
        }

        public void c(String str, Editable editable) {
            C2CLendTradeView2.this.C();
            if (TextUtils.isEmpty(str)) {
                C2CLendTradeView2.this.setYearRate((CharSequence) null);
                return;
            }
            String n11 = !TextUtils.isEmpty(str) ? m.n(m.a(str).multiply(m.a("365")).toPlainString(), o.f(), (String) null) : null;
            if (n11 == null || m.a(n11).compareTo(BigDecimal.ZERO) == 0) {
                C2CLendTradeView2.this.setYearRate((CharSequence) null);
                return;
            }
            String str2 = n11 + "%";
            String str3 = C2CLendTradeView2.this.getResources().getString(R.string.n_c2c_lend_out_year_rate) + " " + str2;
            SpannableString spannableString = new SpannableString(str3);
            spannableString.setSpan(new ForegroundColorSpan(C2CLendTradeView2.this.getResources().getColor(R.color.baseColorSecondaryText)), 0, str3.length(), 17);
            spannableString.setSpan(new ForegroundColorSpan(C2CLendTradeView2.this.getResources().getColor(R.color.baseColorMajorTheme100)), str3.indexOf(str2), str3.indexOf(str2) + str2.length(), 17);
            C2CLendTradeView2.this.setYearRate(spannableString);
        }
    }

    public class f implements CommonEditText.b {
        public f() {
        }

        public boolean b() {
            if (C2CLendTradeView2.this.f42980l != null) {
                return C2CLendTradeView2.this.f42980l.b();
            }
            return false;
        }

        public void c(String str, Editable editable) {
            float f11;
            C2CLendTradeView2.this.C();
            if (!TextUtils.isEmpty(str)) {
                BigDecimal a11 = m.a(str);
                BigDecimal a12 = m.a(C2CLendTradeView2.this.f42981m);
                if (a12.compareTo(BigDecimal.ZERO) > 0) {
                    f11 = a11.divide(a12, 8, 1).multiply(m.a("100")).floatValue();
                    C2CLendTradeView2.this.f42977i.setProgress(f11);
                }
            }
            f11 = 0.0f;
            C2CLendTradeView2.this.f42977i.setProgress(f11);
        }
    }

    public interface g {
        void a();

        boolean b();

        void c(boolean z11);

        void d(boolean z11);

        void e();

        void g(boolean z11);

        void h(View view);

        void i();

        boolean isCanBeSeen();

        void j();

        void k();

        void l(String str);

        void onRefresh();
    }

    public C2CLendTradeView2(Context context, String str, g gVar) {
        super(context);
        FrameLayout.inflate(context, R.layout.c2c_lend_trade_view2, this);
        this.f42979k = str;
        this.f42980l = gVar;
        n();
        i();
        j();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void q(View view) {
        k();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void r(View view) {
        g gVar = this.f42980l;
        if (gVar != null) {
            gVar.k();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void s(View view) {
        k();
        g gVar = this.f42980l;
        if (gVar != null) {
            gVar.i();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void A(boolean z11) {
        C2CLendOrderLayout c2CLendOrderLayout = this.f42978j;
        if (c2CLendOrderLayout != null) {
            c2CLendOrderLayout.j(z11);
        }
    }

    public void B(boolean z11, boolean z12) {
        this.f42977i.H(z11, z12);
    }

    public final void C() {
        String str;
        String rateText = this.f42977i.getRateText();
        String amountText = this.f42977i.getAmountText();
        if (TextUtils.isEmpty(rateText) || TextUtils.isEmpty(amountText) || m.a(amountText).compareTo(BigDecimal.ZERO) == 0) {
            str = null;
        } else {
            str = m.m(m.a(amountText).multiply(m.a(rateText).divide(m.a("100"), 32, 1)).toPlainString(), o.d(this.f42979k));
        }
        if (TextUtils.isEmpty(str)) {
            str = "--";
        }
        this.f42977i.F(str, this.f42979k);
    }

    public String getAmountText() {
        return this.f42977i.getAmountText();
    }

    public String getRateText() {
        return this.f42977i.getRateText();
    }

    public final void i() {
        setOnClickListener(new r(this));
        m();
        l();
        this.f42977i.setOnProgressChangedListener(new a());
        this.f42973e.setOnClickListener(new q(this));
        this.f42974f.setOnClickListener(new s(this));
        this.f42978j.setCallback(new b());
        this.f42977i.setCallback(new c());
        this.f42970b.e0(new d());
    }

    public void j() {
        this.f42977i.setCurrency(this.f42979k);
        String string = getResources().getString(R.string.n_c2c_lend_out_issue_lend_out);
        String A = k.C().A(this.f42979k, (String) null);
        if (TextUtils.isEmpty(A)) {
            A = "--";
        }
        this.f42972d.setText(String.format(Locale.US, string, new Object[]{A}));
        setAvailable((String) null);
        y();
    }

    public void k() {
        this.f42977i.o();
        g gVar = this.f42980l;
        if (gVar != null) {
            gVar.j();
        }
    }

    public final void l() {
        this.f42977i.setAmountIntPrecision(o.c());
        this.f42977i.setAmountFloatPrecision(o.a());
        this.f42977i.setAmountEtCallback(new f());
    }

    public final void m() {
        this.f42977i.setRateIntPrecision(1);
        this.f42977i.setRateFloatPrecision(4);
        this.f42977i.setRateEtCallback(new e());
    }

    public final void n() {
        this.f42970b = (SmartRefreshLayout) findViewById(R.id.tradePtrFrame);
        this.f42975g = (MyNestedScrollView) findViewById(R.id.id_c2c_lend_nested_scroll_view);
        this.f42976h = findViewById(R.id.id_c2c_lend_head_view);
        this.f42972d = (TextView) findViewById(R.id.c2c_lend_title_tv);
        this.f42973e = findViewById(R.id.c2c_lend_title_tips_btn);
        this.f42974f = (TextView) findViewById(R.id.c2c_lend_title_income_tv);
        this.f42977i = (C2CLendTradeLayout) findViewById(R.id.c2c_lend_trade_layout);
        this.f42978j = (C2CLendOrderLayout) findViewById(R.id.c2c_lend_order_layout);
    }

    public boolean o() {
        return this.f42977i.r();
    }

    public boolean p() {
        return this.f42977i.s();
    }

    public void setAllOrderBtnVisible(boolean z11) {
        C2CLendOrderLayout c2CLendOrderLayout = this.f42978j;
        if (c2CLendOrderLayout != null) {
            c2CLendOrderLayout.setAllOrderBtnVisible(z11);
        }
    }

    public void setAutoOrder(boolean z11) {
        this.f42977i.setAutoOrder(z11);
    }

    public void setAvailable(String str) {
        this.f42981m = str;
        String z11 = k.C().z(this.f42979k);
        String m11 = !TextUtils.isEmpty(this.f42981m) ? m.m(this.f42981m, o.a()) : "--";
        String string = getResources().getString(R.string.n_c2c_lend_out_current_available);
        C2CLendTradeLayout c2CLendTradeLayout = this.f42977i;
        c2CLendTradeLayout.setAvailable(string + " " + m11 + " " + z11);
        String n11 = m.n(this.f42981m, o.a(), "0.000");
        C2CLendTradeLayout c2CLendTradeLayout2 = this.f42977i;
        c2CLendTradeLayout2.setMaxAmount(n11 + " " + z11);
    }

    public void setBestBtnSelected(boolean z11) {
        this.f42977i.setBestBtnSelected(z11);
    }

    public void setLendMinAmount(String str) {
        this.f42982n = str;
        String m11 = m.m(str, o.a());
        C2CLendTradeLayout c2CLendTradeLayout = this.f42977i;
        c2CLendTradeLayout.setAmountEtHintText(getResources().getString(R.string.n_c2c_min_lend_amount) + " " + m11);
    }

    public void setMaxAmount(String str) {
        this.f42977i.setMaxAmount(str);
    }

    public void setOrderList(List<s9.a> list) {
        C2CLendOrderLayout c2CLendOrderLayout = this.f42978j;
        if (c2CLendOrderLayout != null) {
            c2CLendOrderLayout.setOrderList(list);
        }
    }

    public void setPeriod(String str) {
        this.f42977i.setPeriod(str);
    }

    public void setRange(String str) {
        this.f42977i.setRange(str);
    }

    public void setRateList(List<s9.a> list) {
        this.f42977i.setRateList(list);
    }

    public void setYearRate(CharSequence charSequence) {
        this.f42977i.setYearRate(charSequence);
    }

    public void t(Activity activity) {
        w();
        k();
    }

    public void u(boolean z11) {
        z(z11);
        setAllOrderBtnVisible(z11);
        w();
        k();
    }

    public void v(boolean z11) {
        if (this.f42971c != null) {
            this.f42971c.b(DateTimeUtils.h(DateTimeUtils.v(), "MM-dd HH:mm:ss"));
        }
        SmartRefreshLayout smartRefreshLayout = this.f42970b;
        if (smartRefreshLayout == null) {
            return;
        }
        if (z11) {
            smartRefreshLayout.finishRefresh();
            this.f42970b.setNoMoreData(false);
            return;
        }
        smartRefreshLayout.w();
    }

    public void w() {
        this.f42977i.setProgress(0.0f);
        x("", false);
        this.f42977i.E();
        setAutoOrder(false);
        setBestBtnSelected(false);
    }

    public void x(String str, boolean z11) {
        this.f42977i.G(str, z11);
    }

    public void y() {
        this.f42970b.i(true);
        this.f42970b.g(false);
        this.f42970b.V(false);
        SmartRefreshHeader smartRefreshHeader = new SmartRefreshHeader(getContext());
        this.f42971c = smartRefreshHeader;
        this.f42970b.j0(smartRefreshHeader);
    }

    public void z(boolean z11) {
        String str;
        String str2;
        if (z11) {
            String string = getResources().getString(R.string.c_to_c_loan);
            if (!TextUtils.isEmpty(this.f42979k)) {
                str2 = " " + k.C().z(this.f42979k);
            } else {
                str2 = "";
            }
            str = string + str2;
        } else {
            str = getResources().getString(R.string.login_button);
        }
        this.f42977i.setLendBtnText(str);
    }
}
