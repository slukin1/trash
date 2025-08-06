package com.huobi.trade.prime.ui;

import android.content.Context;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import bh.j;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrimeInfo;
import com.hbg.lib.network.hbg.prime.PrimeBidResultDetail;
import com.hbg.lib.network.hbg.prime.PrimeResult;
import com.hbg.lib.network.hbg.prime.PrimeRounds;
import com.hbg.lib.widgets.LoadingView;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.huobi.trade.prime.bean.PrimeAveragePosition;
import com.huobi.trade.prime.bean.PrimeLuckyListOrderItem;
import com.huobi.trade.prime.dialog.PrimeFourDialog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import ht.o;
import i6.m;
import i6.t;
import it.b;
import it.c;
import it.d;
import it.e;
import it.f;
import it.g;
import it.h;
import it.i;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import pro.huobi.R;
import tg.r;

public class PrimeLayout extends FrameLayout implements it.a {
    public a A;
    public String B;
    public String C;
    public String D;
    public String E;
    public PrimeInfo F;
    public PrimeAveragePosition G;
    public boolean H;
    public t I;
    public PrimeFourDialog J;
    public boolean K;
    public t.a L;

    /* renamed from: b  reason: collision with root package name */
    public DecimalFormat f82229b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f82230c;

    /* renamed from: d  reason: collision with root package name */
    public EasyRecyclerView<s9.a> f82231d;

    /* renamed from: e  reason: collision with root package name */
    public PrimeCountDownLayout f82232e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f82233f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f82234g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f82235h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f82236i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f82237j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f82238k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f82239l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f82240m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f82241n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f82242o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f82243p;

    /* renamed from: q  reason: collision with root package name */
    public View f82244q;

    /* renamed from: r  reason: collision with root package name */
    public View f82245r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f82246s;

    /* renamed from: t  reason: collision with root package name */
    public LoadingView f82247t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f82248u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f82249v;

    /* renamed from: w  reason: collision with root package name */
    public TextView f82250w;

    /* renamed from: x  reason: collision with root package name */
    public TextView f82251x;

    /* renamed from: y  reason: collision with root package name */
    public TextView f82252y;

    /* renamed from: z  reason: collision with root package name */
    public final List<s9.a> f82253z;

    public interface a {
        void a();

        void b();

        void c();

        void d();

        FragmentManager e();

        void f();

        void g();

        void onCloseClick();
    }

    public PrimeLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void A(View view) {
        if (this.f82245r.getVisibility() != 0) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        this.f82245r.setVisibility(4);
        this.f82247t.setVisibility(0);
        this.f82247t.c();
        this.A.g();
        E();
        this.H = false;
        if (this.I == null) {
            this.I = new t(this.L);
        }
        this.I.sendMessageDelayed(this.I.obtainMessage(1), 1300);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void B(View view) {
        PrimeResult J2 = o.B().J();
        if (J2 == null) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        List<PrimeBidResultDetail> detail = J2.getDetail();
        if (detail != null && !detail.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < detail.size(); i11++) {
                PrimeBidResultDetail primeBidResultDetail = detail.get(i11);
                if (primeBidResultDetail != null) {
                    arrayList.add(new ft.a(String.format(Locale.US, getResources().getString(R.string.prime_lucky_order_dialog_item_title), new Object[]{primeBidResultDetail.getNumOfDigits()}), primeBidResultDetail.getDigits()));
                }
            }
            this.J.uh(J2.getWinRate(), arrayList);
            a aVar = this.A;
            if (!(aVar == null || aVar.e() == null)) {
                this.J.show(this.A.e(), "mPrimeFourDialog");
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C(Message message) {
        if (message.what == 1 && this.H) {
            J();
        }
    }

    private void J() {
        LoadingView loadingView = this.f82247t;
        if (loadingView != null) {
            loadingView.d();
            this.f82247t.setVisibility(8);
        }
        View view = this.f82245r;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private DecimalFormat getAmountDecFormat() {
        if (this.f82229b == null) {
            this.f82229b = new DecimalFormat("#,###");
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.US);
            decimalFormatSymbols.setDecimalSeparator(',');
            this.f82229b.setDecimalFormatSymbols(decimalFormatSymbols);
        }
        return this.f82229b;
    }

    private void k() {
        this.f82232e.setCountDownCallback(this);
        findViewById(R.id.id_prime_login_btn).setOnClickListener(new g(this));
        findViewById(R.id.id_prime_see_detail_btn).setOnClickListener(new h(this));
        findViewById(R.id.id_prime_project_report).setOnClickListener(new f(this));
        findViewById(R.id.id_prime_project_rule).setOnClickListener(new e(this));
        findViewById(R.id.id_prime_close_up_btn).setOnClickListener(new d(this));
        findViewById(R.id.linear_refresh).setOnClickListener(new c(this));
        TextView textView = this.f82252y;
        if (textView != null) {
            textView.setOnClickListener(new b(this));
        }
    }

    private void q(Context context) {
        this.I = new t(this.L);
        r(context);
        k();
    }

    private void r(Context context) {
        FrameLayout.inflate(context, getContentViewId(), this);
        this.f82247t = (LoadingView) findViewById(R.id.loading_refresh);
        this.f82245r = findViewById(R.id.linear_refresh);
        this.f82246s = (TextView) findViewById(R.id.text_refresh);
        this.f82244q = findViewById(R.id.relative_refresh);
        this.f82234g = (TextView) findViewById(R.id.id_prime_round_desc);
        this.f82231d = (EasyRecyclerView) findViewById(R.id.id_prime_list_recyclerView);
        this.f82232e = (PrimeCountDownLayout) findViewById(R.id.id_prime_count_down_view);
        this.f82235h = (TextView) findViewById(R.id.id_prime_limit_amount);
        this.f82238k = (TextView) findViewById(R.id.id_prime_this_amount);
        this.f82236i = (TextView) findViewById(R.id.id_prime_this_amount_title);
        this.f82237j = (TextView) findViewById(R.id.id_prime_this_stop_price_title);
        this.f82239l = (TextView) findViewById(R.id.id_prime_this_stop_price);
        this.f82240m = (TextView) findViewById(R.id.id_prime_start_time);
        this.f82241n = (TextView) findViewById(R.id.id_prime_list_layout_title);
        this.f82242o = (TextView) findViewById(R.id.id_prime_price_rate);
        this.f82243p = (TextView) findViewById(R.id.id_prime_count_down_title);
        this.f82248u = (TextView) findViewById(R.id.id_prime_tips_order_finish_desc);
        this.f82249v = (TextView) findViewById(R.id.id_prime_see_detail_btn);
        this.f82250w = (TextView) findViewById(R.id.id_prime_tips_tv_waiting);
        this.f82251x = (TextView) findViewById(R.id.id_prime_tips_order_finish_title);
        this.f82233f = (ImageView) findViewById(R.id.id_prime_round_logo_text_img);
        this.f82252y = (TextView) findViewById(R.id.id_prime_lucky_order_rule_tv);
        this.f82247t.setLottieAnimationRes(getRefreshJsonId());
        F();
        this.f82233f.setImageResource(getLogoImgResId());
    }

    private void setLimit(String str) {
        if (TextUtils.isEmpty(str)) {
            this.E = "--";
        } else {
            this.E = m.a(str).stripTrailingZeros().toPlainString();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void v(View view) {
        a aVar = this.A;
        if (aVar != null) {
            aVar.f();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void w(View view) {
        a aVar = this.A;
        if (aVar != null) {
            aVar.c();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void x(View view) {
        a aVar = this.A;
        if (aVar != null) {
            aVar.a();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void y(View view) {
        a aVar = this.A;
        if (aVar != null) {
            aVar.b();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void z(View view) {
        a aVar = this.A;
        if (aVar != null) {
            aVar.onCloseClick();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void D() {
        this.H = true;
        t tVar = this.I;
        if (tVar == null || !tVar.hasMessages(1)) {
            this.I.sendMessage(this.I.obtainMessage(1));
        }
    }

    public void E() {
        T(this.f82230c, o.B().J());
        if (r.x().F0()) {
            o.B().w();
        } else if (l()) {
            this.f82253z.clear();
            this.f82253z.add(new ft.b(getResources().getString(R.string.prime_order_id_status_please_login)));
            this.f82231d.setData(this.f82253z);
        }
    }

    public void F() {
        String string = BaseApplication.b().getString(R.string.n_exchange_prime_refresh_text);
        String string2 = BaseApplication.b().getString(R.string.n_exchange_prime_refresh);
        int indexOf = string.indexOf(string2);
        int length = string2.length() + indexOf;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getFirstColor());
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(getSecondColor());
        spannableStringBuilder.setSpan(foregroundColorSpan, 0, string.length(), 33);
        spannableStringBuilder.setSpan(foregroundColorSpan2, indexOf, length, 33);
        spannableStringBuilder.setSpan(new StyleSpan(1), indexOf, length, 33);
        this.f82246s.setText(spannableStringBuilder);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x005c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean G(android.view.ViewGroup r9, com.hbg.lib.data.symbol.PrimeInfo r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, boolean r14) {
        /*
            r8 = this;
            r8.J()
            r8.f82230c = r9
            r0 = 1
            r8.K = r0
            r8.F = r10
            r8.B = r11
            r8.C = r12
            r8.D = r13
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r1 = "PrimeLayout-->showPrimeInfo-->baseCurrency："
            r11.append(r1)
            r11.append(r12)
            java.lang.String r1 = " quoteCurrency:"
            r11.append(r1)
            r11.append(r13)
            java.lang.String r11 = r11.toString()
            i6.d.b(r11)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r1 = "PrimeLayout-->showPrimeInfo-->"
            r11.append(r1)
            r11.append(r10)
            java.lang.String r11 = r11.toString()
            i6.d.b(r11)
            i6.t r11 = r8.I
            if (r11 == 0) goto L_0x004a
            r2 = 0
            r11.removeCallbacksAndMessages(r2)
            r8.H = r0
        L_0x004a:
            java.util.Locale r11 = java.util.Locale.US
            java.lang.String r12 = r12.toUpperCase(r11)
            java.lang.String r11 = r13.toUpperCase(r11)
            r13 = 0
            if (r9 == 0) goto L_0x007d
            if (r14 == 0) goto L_0x0060
            r9.removeView(r8)     // Catch:{ Exception -> 0x005c }
        L_0x005c:
            r9.addView(r8)     // Catch:{ Exception -> 0x0066 }
            goto L_0x007d
        L_0x0060:
            r9.removeView(r8)     // Catch:{ Exception -> 0x0066 }
            r8.K = r13     // Catch:{ Exception -> 0x0066 }
            goto L_0x007d
        L_0x0066:
            r9 = move-exception
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r1)
            java.lang.String r9 = r9.toString()
            r14.append(r9)
            java.lang.String r9 = r14.toString()
            i6.d.b(r9)
        L_0x007d:
            if (r10 != 0) goto L_0x0085
            r8.n()
            boolean r9 = r8.K
            return r9
        L_0x0085:
            com.huobi.trade.prime.ui.PrimeCountDownLayout r9 = r8.f82232e
            r9.setValid(r0)
            java.lang.String r9 = r10.getRules()
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x00a0
            java.lang.String r9 = r10.getSummary()
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x00a0
            r9 = r0
            goto L_0x00a1
        L_0x00a0:
            r9 = r13
        L_0x00a1:
            r14 = 2131430623(0x7f0b0cdf, float:1.8482952E38)
            android.view.View r14 = r8.findViewById(r14)
            com.hbg.lib.common.utils.ViewUtil.m(r14, r9)
            java.util.List r9 = r10.getRounds()
            int r14 = r10.getStatus()
            r1 = 2131430604(0x7f0b0ccc, float:1.8482914E38)
            java.lang.String r2 = " "
            r3 = 2131430598(0x7f0b0cc6, float:1.8482901E38)
            r4 = 2
            if (r14 == r0) goto L_0x00c1
            if (r14 == r4) goto L_0x00c1
            goto L_0x011a
        L_0x00c1:
            android.widget.TextView r14 = r8.f82234g
            java.lang.String r5 = r8.getRoundDescTvText()
            r14.setText(r5)
            android.widget.TextView r14 = r8.f82234g
            int r5 = r8.getRoundDescTvColorResId()
            int r5 = bh.j.b(r5)
            r14.setTextColor(r5)
            android.widget.TextView r14 = r8.f82243p
            com.hbg.lib.common.utils.ViewUtil.m(r14, r0)
            com.huobi.trade.prime.ui.PrimeCountDownLayout r14 = r8.f82232e
            com.hbg.lib.common.utils.ViewUtil.m(r14, r0)
            android.view.View r14 = r8.findViewById(r3)
            com.hbg.lib.common.utils.ViewUtil.m(r14, r0)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.text.DecimalFormat r5 = r8.getAmountDecFormat()
            long r6 = r10.getRoundCirculation()
            java.lang.String r5 = r5.format(r6)
            r14.append(r5)
            r14.append(r2)
            r14.append(r12)
            java.lang.String r14 = r14.toString()
            android.widget.TextView r5 = r8.f82238k
            r5.setText(r14)
            android.view.View r14 = r8.findViewById(r1)
            ht.o r5 = ht.o.B()
            boolean r5 = r5.P()
            com.hbg.lib.common.utils.ViewUtil.m(r14, r5)
        L_0x011a:
            android.view.View r14 = r8.f82244q
            r5 = 8
            r14.setVisibility(r5)
            int r14 = r10.getStatus()
            if (r14 == r0) goto L_0x01b9
            if (r14 == r4) goto L_0x0195
            r4 = 3
            if (r14 == r4) goto L_0x012e
            goto L_0x01dc
        L_0x012e:
            android.widget.TextView r14 = r8.f82234g
            java.util.Locale r4 = java.util.Locale.US
            android.content.res.Resources r5 = r8.getResources()
            r6 = 2132026191(0x7f14234f, float:1.9690908E38)
            java.lang.String r5 = r5.getString(r6)
            java.lang.Object[] r6 = new java.lang.Object[r0]
            r6[r13] = r12
            java.lang.String r4 = java.lang.String.format(r4, r5, r6)
            r14.setText(r4)
            android.widget.TextView r14 = r8.f82234g
            r4 = 2131099916(0x7f06010c, float:1.7812199E38)
            int r4 = bh.j.b(r4)
            r14.setTextColor(r4)
            android.widget.TextView r14 = r8.f82243p
            com.hbg.lib.common.utils.ViewUtil.m(r14, r13)
            com.huobi.trade.prime.ui.PrimeCountDownLayout r14 = r8.f82232e
            com.hbg.lib.common.utils.ViewUtil.m(r14, r13)
            android.view.View r14 = r8.f82244q
            r14.setVisibility(r13)
            android.view.View r14 = r8.findViewById(r3)
            com.hbg.lib.common.utils.ViewUtil.m(r14, r13)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.text.DecimalFormat r3 = r8.getAmountDecFormat()
            long r4 = r10.getTotalRoundCirculation()
            java.lang.String r10 = r3.format(r4)
            r14.append(r10)
            r14.append(r2)
            r14.append(r12)
            java.lang.String r10 = r14.toString()
            android.widget.TextView r14 = r8.f82238k
            r14.setText(r10)
            android.view.View r10 = r8.findViewById(r1)
            com.hbg.lib.common.utils.ViewUtil.m(r10, r13)
            goto L_0x01dc
        L_0x0195:
            android.widget.TextView r14 = r8.f82243p
            java.util.Locale r1 = java.util.Locale.US
            android.content.res.Resources r2 = r8.getResources()
            int r3 = r8.getCountDownInTitleTextResId()
            java.lang.String r2 = r2.getString(r3)
            java.lang.Object[] r3 = new java.lang.Object[r0]
            int r10 = r10.getCurrentRoundNumber()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r3[r13] = r10
            java.lang.String r10 = java.lang.String.format(r1, r2, r3)
            r14.setText(r10)
            goto L_0x01dc
        L_0x01b9:
            android.widget.TextView r14 = r8.f82243p
            java.util.Locale r1 = java.util.Locale.US
            android.content.res.Resources r2 = r8.getResources()
            int r3 = r8.getCountDownPreTitleTextResId()
            java.lang.String r2 = r2.getString(r3)
            java.lang.Object[] r3 = new java.lang.Object[r0]
            int r10 = r10.getCurrentRoundNumber()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r3[r13] = r10
            java.lang.String r10 = java.lang.String.format(r1, r2, r3)
            r14.setText(r10)
        L_0x01dc:
            r8.U()
            r8.V()
            r8.W(r11)
            r8.R()
            android.widget.TextView r10 = r8.f82234g
            r10.setVisibility(r13)
            tg.r r10 = tg.r.x()
            boolean r10 = r10.F0()
            r11 = 2131430635(0x7f0b0ceb, float:1.8482977E38)
            if (r10 == 0) goto L_0x0202
            android.view.View r10 = r8.findViewById(r11)
            com.hbg.lib.common.utils.ViewUtil.m(r10, r13)
            goto L_0x0227
        L_0x0202:
            android.view.View r10 = r8.findViewById(r11)
            com.hbg.lib.common.utils.ViewUtil.m(r10, r0)
            r10 = 2131430638(0x7f0b0cee, float:1.8482983E38)
            android.view.View r10 = r8.findViewById(r10)
            com.hbg.lib.common.utils.ViewUtil.m(r10, r13)
            r10 = 2131430637(0x7f0b0ced, float:1.848298E38)
            android.view.View r10 = r8.findViewById(r10)
            com.hbg.lib.common.utils.ViewUtil.m(r10, r13)
            r10 = 2131430636(0x7f0b0cec, float:1.8482979E38)
            android.view.View r10 = r8.findViewById(r10)
            com.hbg.lib.common.utils.ViewUtil.m(r10, r13)
        L_0x0227:
            r8.M(r12)
            com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView<s9.a> r10 = r8.f82231d
            java.util.List<s9.a> r11 = r8.f82253z
            r8.L(r10, r11, r9)
            r8.S()
            r8.E()
            r8.N()
            boolean r9 = r8.K
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.trade.prime.ui.PrimeLayout.G(android.view.ViewGroup, com.hbg.lib.data.symbol.PrimeInfo, java.lang.String, java.lang.String, java.lang.String, boolean):boolean");
    }

    public boolean H() {
        return !s();
    }

    public void I(String str, PrimeAveragePosition primeAveragePosition, String str2, String str3) {
        this.C = str2;
        this.D = str3;
        i6.d.b("PrimeLayout-->showUserPrimePosition-->baseCurrency：" + this.C + " quoteCurrency:" + this.D);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("PrimeLayout-->showUserPrimePosition-->mPrimeInfo：");
        sb2.append(this.F);
        i6.d.b(sb2.toString());
        i6.d.b("PrimeLayout-->showUserPrimePosition-->primeAveragePosition：" + primeAveragePosition + " limit:" + this.E);
        this.G = primeAveragePosition;
        K(str);
    }

    public void K(String str) {
        setLimit(str);
        S();
    }

    public void L(EasyRecyclerView<s9.a> easyRecyclerView, List<s9.a> list, List<PrimeRounds> list2) {
        if (o.B().T()) {
            Q(o.B().J());
            return;
        }
        list.clear();
        ViewUtil.m(findViewById(R.id.id_prime_list_layout), list2 != null);
        if (list2 != null) {
            ViewUtil.m(findViewById(R.id.id_prime_list_layout), true);
            Locale locale = Locale.US;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd HH:mm:ss", locale);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm:ss", locale);
            for (int i11 = 0; i11 < list2.size(); i11++) {
                PrimeRounds primeRounds = list2.get(i11);
                if (primeRounds != null) {
                    list.add(new ft.c(String.format(Locale.US, getResources().getString(R.string.prime_list_item_title), new Object[]{String.valueOf(primeRounds.getRoundNum())}), simpleDateFormat.format(new Date(primeRounds.getRoundBeginTime())) + " - " + simpleDateFormat2.format(new Date(primeRounds.getRoundEndTime())), H()));
                }
            }
        }
        easyRecyclerView.setData(list);
    }

    public void M(String str) {
        if (o.B().T()) {
            this.f82241n.setText(getResources().getString(R.string.prime_my_order_id));
            return;
        }
        this.f82241n.setText(String.format(Locale.US, getResources().getString(R.string.prime_list_layout_title_text), new Object[]{str}));
    }

    public final void N() {
        PrimeResult J2 = o.B().J();
        ViewUtil.m(this.f82252y, r.x().F0() && o.B().T() && J2 != null && J2.isFinished() && J2.getDetail() != null && !J2.getDetail().isEmpty());
    }

    public void O() {
        PrimeAveragePosition primeAveragePosition = this.G;
        if (primeAveragePosition == null) {
            this.f82235h.setText(getResources().getString(R.string.prime_trade_limit_amount_detail_tip));
        } else if (!primeAveragePosition.isQualify()) {
            this.f82235h.setText(getResources().getString(R.string.prime_trade_limit_amount_trade_tip));
        } else if (o()) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            Locale locale = Locale.US;
            spannableStringBuilder.append(String.format(locale, getResources().getString(R.string.prime_trade_limit_amount_tip), new Object[]{""}));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText)), 0, spannableStringBuilder.length(), 33);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" " + this.E + " " + this.D.toUpperCase(locale));
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), getAmountColorRes())), 0, spannableStringBuilder2.length(), 33);
            this.f82235h.setText(spannableStringBuilder.append(spannableStringBuilder2));
        } else {
            this.f82235h.setText(getResources().getString(R.string.prime_trade_limit_amount_detail_tip));
        }
    }

    public void P() {
        PrimeResult J2 = o.B().J();
        if (J2 == null || TextUtils.isEmpty(J2.getOrderId()) || o.B().T()) {
            ViewUtil.m(findViewById(R.id.id_prime_tips_layout_waiting), false);
            ViewUtil.m(findViewById(R.id.id_prime_tips_layout_order_finish), false);
        } else if (!J2.isFinished()) {
            ViewUtil.m(findViewById(R.id.id_prime_tips_layout_waiting), true);
            this.f82250w.setText(getWaitingText());
            ViewUtil.m(findViewById(R.id.id_prime_tips_layout_order_finish), false);
        } else {
            ViewUtil.m(findViewById(R.id.id_prime_tips_layout_waiting), false);
            ViewUtil.m(findViewById(R.id.id_prime_tips_layout_order_finish), true);
            Locale locale = Locale.US;
            String string = getResources().getString(R.string.prime_please_order_finish_tips_desc_lite);
            this.f82248u.setText(String.format(locale, string, new Object[]{J2.getQuotaAmount() + " " + getBaseCurrencyUpper()}));
            this.f82251x.setText(String.format(locale, getResources().getString(R.string.prime_please_order_finish_tips_title), new Object[]{String.valueOf(this.F.getTotalRounds())}));
        }
    }

    public final void Q(PrimeResult primeResult) {
        String str;
        this.f82253z.clear();
        if (primeResult == null || TextUtils.isEmpty(primeResult.getOrderId())) {
            this.f82253z.add(new ft.b(getResources().getString(R.string.prime_order_id_status_cancel_unorder_lucky)));
        } else {
            List<String> bidIds = primeResult.getBidIds();
            List<String> winBidIds = primeResult.getWinBidIds();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (bidIds != null && !bidIds.isEmpty()) {
                for (int i11 = 0; i11 < bidIds.size(); i11++) {
                    String str2 = bidIds.get(i11);
                    boolean z11 = true;
                    boolean z12 = winBidIds != null && winBidIds.contains(str2);
                    PrimeLuckyListOrderItem primeLuckyListOrderItem = new PrimeLuckyListOrderItem();
                    primeLuckyListOrderItem.h(str2);
                    if (o.B().Z() || !primeResult.isFinished()) {
                        str = o.B().Z() ? getResources().getString(R.string.prime_trade_order_status_trading) : getResources().getString(R.string.prime_trade_order_status_ordering);
                    } else if (z12) {
                        str = primeResult.getQuotaPerBid() + " " + getBaseCurrencyUpper();
                    } else {
                        str = "";
                    }
                    primeLuckyListOrderItem.g(str);
                    if (!z12 || o.B().Z()) {
                        z11 = false;
                    }
                    primeLuckyListOrderItem.i(z11);
                    if (z12) {
                        arrayList.add(primeLuckyListOrderItem);
                    } else {
                        arrayList2.add(primeLuckyListOrderItem);
                    }
                }
            }
            if (!o.B().Z() && primeResult.isFinished() && arrayList.isEmpty()) {
                this.f82253z.add(new ft.e(getResources().getString(R.string.prime_lucky_item_title_thanks)));
            }
            this.f82253z.addAll(arrayList);
            this.f82253z.addAll(arrayList2);
        }
        N();
        this.f82231d.setData(this.f82253z);
    }

    public void R() {
        String str;
        int status = this.F.getStatus();
        if (status == 1 || status == 2) {
            ViewUtil.m(findViewById(R.id.id_prime_price_rate_layout), false);
        } else if (status == 3) {
            if (s()) {
                ViewUtil.m(findViewById(R.id.id_prime_price_rate_layout), false);
                return;
            }
            ViewUtil.m(findViewById(R.id.id_prime_price_rate_layout), true);
            BigDecimal a11 = m.a(this.F.getStopPrice());
            BigDecimal a12 = m.a(this.F.getStartPrice());
            BigDecimal divide = a11.subtract(a12).multiply(m.a("100")).divide(a12, 2, 1);
            if (divide.compareTo(BigDecimal.ZERO) > 0) {
                this.f82242o.setTextColor(ContextCompat.getColor(getContext(), w.h()));
                str = "+";
            } else {
                if (divide.compareTo(BigDecimal.ZERO) < 0) {
                    this.f82242o.setTextColor(ContextCompat.getColor(getContext(), w.d()));
                } else {
                    this.f82242o.setTextColor(ContextCompat.getColor(getContext(), R.color.color_flat));
                }
                str = "";
            }
            this.f82242o.setText(str + divide.toPlainString() + "%");
        }
    }

    public final void S() {
        if (r.x().F0()) {
            P();
            m();
            return;
        }
        ViewUtil.m(findViewById(R.id.id_prime_tips_layout_waiting), false);
        ViewUtil.m(findViewById(R.id.id_prime_tips_layout_order_finish), false);
        ViewUtil.m(findViewById(R.id.id_prime_tips_layout_normal), false);
    }

    public void T(ViewGroup viewGroup, PrimeResult primeResult) {
        this.f82230c = viewGroup;
        if (o.B().T()) {
            Q(primeResult);
        }
        S();
    }

    public void U() {
        String str;
        int status = this.F.getStatus();
        if (status == 1 || status == 2) {
            ViewUtil.m(this.f82240m, false);
        } else if (status == 3) {
            Locale locale = Locale.US;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", locale);
            ViewUtil.m(this.f82240m, true);
            String format = simpleDateFormat.format(new Date(this.F.getTradeBeginTime()));
            if (TextUtils.isEmpty(this.F.getSupportQuoteCurrency())) {
                str = "--";
            } else {
                str = this.F.getSupportQuoteCurrency();
            }
            if ("btcht".equalsIgnoreCase(this.F.getSymbolCode())) {
                this.f82240m.setText(String.format(locale, getResources().getString(R.string.prime_start_trade_time2), new Object[]{format}));
                return;
            }
            this.f82240m.setText(String.format(locale, getResources().getString(getStartTitleResId()), new Object[]{format, str.toUpperCase(locale)}));
        }
    }

    public void V() {
        int status = this.F.getStatus();
        if (status == 1 || status == 2) {
            if (s()) {
                this.f82236i.setText(getResources().getString(R.string.prime_this_cycle_amount));
            } else {
                this.f82236i.setText(getResources().getString(R.string.prime_this_amount));
            }
        } else if (status == 3) {
            if (s()) {
                this.f82236i.setText(getResources().getString(R.string.prime_this_cycle_amount));
            } else {
                this.f82236i.setText(getResources().getString(R.string.prime_this_amount_total));
            }
        }
    }

    public void W(String str) {
        boolean z11;
        int status = this.F.getStatus();
        if (status == 1 || status == 2 || (status == 3 && s())) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            ViewUtil.m(findViewById(R.id.id_prime_stop_price_layout), true);
            String currentPrice = this.F.getCurrentPrice();
            if (s()) {
                this.f82237j.setText(getResources().getString(R.string.prime_this_cycle_price));
                currentPrice = this.F.getRounds().get(0).getRoundIssuePrice();
            } else {
                this.f82237j.setText(getResources().getString(R.string.current_round_price));
            }
            this.f82239l.setText(currentPrice + " " + str);
            return;
        }
        ViewUtil.m(findViewById(R.id.id_prime_stop_price_layout), false);
    }

    public void b(int i11, long j11, long[] jArr) {
    }

    public void c(int i11) {
        if (getVisibility() == 0) {
            G((ViewGroup) null, o.B().F(), this.B, this.C, this.D, true);
        }
    }

    public int getAmountColorRes() {
        return R.color.baseColorPrimaryText;
    }

    public String getBaseCurrency() {
        PrimeInfo primeInfo = this.F;
        if (primeInfo != null) {
            this.C = primeInfo.getCurrency();
        }
        if (this.C == null) {
            this.C = "--";
        }
        return this.C;
    }

    public String getBaseCurrencyUpper() {
        return getBaseCurrency().toUpperCase(Locale.US);
    }

    public int getContentViewId() {
        return R.layout.prime_cover_layout;
    }

    public int getCountDownInTitleTextResId() {
        return s() ? R.string.current_round_remaining_time_end : R.string.current_round_remaining_time;
    }

    public int getCountDownPreTitleTextResId() {
        return s() ? R.string.prime_count_down_until_start_tips : R.string.current_round_remaining_start_time;
    }

    public int getFirstColor() {
        return getResources().getColor(R.color.baseColorPrimaryText);
    }

    public int getLogoImgResId() {
        return R.drawable.huobiprime;
    }

    public String getPrimeType() {
        PrimeInfo primeInfo = this.F;
        if (primeInfo != null) {
            return primeInfo.getPrimeType();
        }
        return null;
    }

    public int getRefreshJsonId() {
        return R.raw.prime_refresh_3x;
    }

    public int getRoundDescTvColorResId() {
        return R.color.prime;
    }

    public String getRoundDescTvText() {
        PrimeInfo primeInfo = this.F;
        int totalRounds = primeInfo != null ? primeInfo.getTotalRounds() : 0;
        PrimeInfo primeInfo2 = this.F;
        int currentRoundNumber = primeInfo2 != null ? primeInfo2.getCurrentRoundNumber() : 0;
        if (totalRounds == 1) {
            return String.format(Locale.US, getResources().getString(R.string.prime_round_desc_over_one), new Object[]{getBaseCurrencyUpper()});
        }
        return String.format(Locale.US, getResources().getString(R.string.prime_round_desc), new Object[]{getBaseCurrencyUpper(), String.valueOf(currentRoundNumber), String.valueOf(totalRounds)});
    }

    public int getSecondColor() {
        return getResources().getColor(R.color.vip_user_diamond_primary_text);
    }

    public int getStartTitleResId() {
        return R.string.prime_start_trade_time;
    }

    public String getWaitingText() {
        if (s()) {
            return getResources().getString(R.string.prime_please_wait_tips_title_lite);
        }
        return String.format(Locale.US, getResources().getString(R.string.prime_please_wait_tips_title), new Object[]{String.valueOf(this.F.getTotalRounds())});
    }

    public boolean l() {
        return o.B().T();
    }

    public void m() {
        if (u()) {
            O();
            ViewUtil.m(this.f82249v, t());
            ViewUtil.m(findViewById(R.id.id_prime_tips_layout_normal), true);
            return;
        }
        ViewUtil.m(findViewById(R.id.id_prime_tips_layout_normal), false);
    }

    public final void n() {
        this.f82232e.setValid(false);
        this.f82234g.setText(String.format(Locale.US, getResources().getString(R.string.prime_round_desc), new Object[]{getBaseCurrencyUpper(), Constants.ACCEPT_TIME_SEPARATOR_SERVER, Constants.ACCEPT_TIME_SEPARATOR_SERVER}));
        this.f82234g.setTextColor(j.b(R.color.prime));
        this.f82238k.setText("--");
        ViewUtil.m(findViewById(R.id.id_prime_stop_price_layout), true);
        this.f82239l.setText("--");
        ViewUtil.m(findViewById(R.id.id_prime_price_rate_layout), false);
        if (r.x().F0()) {
            ViewUtil.m(findViewById(R.id.id_prime_tips_layout_login), false);
        } else {
            ViewUtil.m(findViewById(R.id.id_prime_tips_layout_login), true);
            ViewUtil.m(findViewById(R.id.id_prime_tips_layout_normal), false);
        }
        ViewUtil.m(this.f82240m, false);
        ViewUtil.m(findViewById(R.id.id_prime_list_layout), false);
        ViewUtil.m(findViewById(R.id.id_prime_project_layout), false);
        L(this.f82231d, this.f82253z, (List<PrimeRounds>) null);
    }

    public boolean o() {
        return m.a(this.G.getMaxAccumulatedBuyableQuota()).compareTo(BigDecimal.ZERO) > 0;
    }

    public void p(ViewGroup viewGroup) {
        this.K = false;
        if (viewGroup != null) {
            try {
                viewGroup.removeView(this);
            } catch (Exception unused) {
            }
        }
        PrimeFourDialog primeFourDialog = this.J;
        if (primeFourDialog != null) {
            primeFourDialog.dismiss();
        }
        a aVar = this.A;
        if (aVar != null) {
            aVar.d();
        }
    }

    public boolean s() {
        PrimeInfo primeInfo = this.F;
        return primeInfo != null && primeInfo.getTotalRounds() == 1;
    }

    public void setCallback(a aVar) {
        this.A = aVar;
    }

    public void setOverLayoutResult(String str) {
    }

    public boolean t() {
        return true;
    }

    public boolean u() {
        PrimeResult J2;
        if (!o.B().T() && (J2 = o.B().J()) != null && !TextUtils.isEmpty(J2.getOrderId())) {
            return false;
        }
        return true;
    }

    public PrimeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PrimeLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f82253z = new ArrayList();
        this.H = true;
        this.J = new PrimeFourDialog();
        this.L = new i(this);
        q(context);
    }
}
