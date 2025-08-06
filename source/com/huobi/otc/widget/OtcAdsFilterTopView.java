package com.huobi.otc.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.network.otc.core.bean.Merchant;
import com.hbg.lib.widgets.CommonSwitchButton;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.otc.enums.OtcAdsFilterType;
import com.huobi.otc.ui.OtcTradeActivity;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import jp.b1;
import rx.Observable;
import rx.functions.Action1;
import up.f;
import vp.a0;
import vp.z;

public class OtcAdsFilterTopView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public OtcAdsFilterItemView f79928b;

    /* renamed from: c  reason: collision with root package name */
    public OtcAdsFilterItemView f79929c;

    /* renamed from: d  reason: collision with root package name */
    public HorizontalScrollView f79930d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f79931e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f79932f;

    /* renamed from: g  reason: collision with root package name */
    public d f79933g;

    /* renamed from: h  reason: collision with root package name */
    public CommonSwitchButton f79934h;

    /* renamed from: i  reason: collision with root package name */
    public View f79935i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f79936j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f79937k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f79938l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f79939m;

    /* renamed from: n  reason: collision with root package name */
    public int f79940n;

    public class a implements Action1<Void> {
        public a() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            OtcAdsFilterTopView.this.j(OtcAdsFilterType.PAY_METHOD_FILTER);
        }
    }

    public class b implements Action1<Void> {
        public b() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            OtcAdsFilterTopView.this.f79934h.b(!OtcAdsFilterTopView.this.f79934h.isChecked(), true);
            HashMap hashMap = new HashMap();
            if (OtcAdsFilterTopView.this.f79934h.isChecked()) {
                op.a.r(OtcAdsFilterTopView.this.f79940n).L(true);
                hashMap.put("open", Boolean.TRUE);
            } else {
                op.a.r(OtcAdsFilterTopView.this.f79940n).L(false);
                hashMap.put("open", Boolean.FALSE);
            }
            OtcAdsFilterTopView.this.f79934h.setCheckedBgColor(OtcAdsFilterTopView.this.getResources().getColor(R$color.baseColorMajorTheme100));
            uf.c.b().r("otc_p2p_avaliableSwtch_click", "", hashMap);
            op.a.r(OtcAdsFilterTopView.this.f79940n).y();
        }
    }

    public class c implements Action1<Void> {
        public c() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            if (OtcAdsFilterTopView.this.getContext() instanceof OtcTradeActivity) {
                OtcTradeActivity otcTradeActivity = (OtcTradeActivity) OtcAdsFilterTopView.this.getContext();
                otcTradeActivity.xi(1, otcTradeActivity.Rh(), !b1.h().j() ? 1 : 0, String.valueOf(otcTradeActivity.fd()), 1);
            }
        }
    }

    public interface d {
        void G8(OtcAdsFilterType otcAdsFilterType);
    }

    public OtcAdsFilterTopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k() {
        j(OtcAdsFilterType.AMOUNT_FILTER);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l() {
        j(OtcAdsFilterType.PAY_METHOD_FILTER_NEW);
    }

    private void setFilterCheckedStatus(boolean z11) {
        this.f79932f.setImageResource(z11 ? R$drawable.trade_otc_optional_icon_filter_sel : R$drawable.trade_otc_optional_icon_filter_nol);
    }

    public final void f() {
        op.a r11 = op.a.r(this.f79940n);
        if (this.f79939m != r11.v()) {
            this.f79939m = r11.v();
            this.f79934h.setChecked(r11.v());
        }
    }

    public final void g() {
        this.f79928b.setCallBack(new a0(this));
        this.f79929c.setCallBack(new z(this));
        Observable<Void> a11 = dw.a.a(this.f79931e);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a11.throttleFirst(300, timeUnit).subscribe(new a());
        dw.a.a(this.f79935i).throttleFirst(300, timeUnit).subscribe(new b());
        dw.a.a(this.f79936j).throttleFirst(300, timeUnit).subscribe(new c());
    }

    public View getIdAdsAvaiableContainer() {
        return this.f79935i;
    }

    public CommonSwitchButton getIdAvailableBtn() {
        return this.f79934h;
    }

    public LinearLayout getIdMerchantLevelChildLl() {
        return this.f79931e;
    }

    public final void h(Context context) {
        FrameLayout.inflate(context, R$layout.otc_ads_filter_top_layout, this);
        OtcAdsFilterItemView otcAdsFilterItemView = (OtcAdsFilterItemView) findViewById(R$id.id_amount_filter_item);
        this.f79928b = otcAdsFilterItemView;
        otcAdsFilterItemView.setText(getResources().getString(R$string.otc_trade_filter_amount_title));
        OtcAdsFilterItemView otcAdsFilterItemView2 = (OtcAdsFilterItemView) findViewById(R$id.id_pay_method_filter_item);
        this.f79929c = otcAdsFilterItemView2;
        otcAdsFilterItemView2.setText(getResources().getString(R$string.otc_trade_filter_payment_title));
        this.f79931e = (LinearLayout) findViewById(R$id.id_merchant_filter_container);
        this.f79932f = (ImageView) findViewById(R$id.id_merchant_filter);
        this.f79930d = (HorizontalScrollView) findViewById(R$id.otc_filter_scroll_view);
        this.f79934h = (CommonSwitchButton) findViewById(R$id.id_ads_available);
        this.f79935i = findViewById(R$id.id_ads_available_container);
        this.f79936j = (LinearLayout) findViewById(R$id.ll_coin_info);
        this.f79937k = (ImageView) findViewById(R$id.iv_coin);
        this.f79938l = (TextView) findViewById(R$id.tv_coin_name);
        f();
        m();
        g();
    }

    public boolean i() {
        op.a r11 = op.a.r(this.f79940n);
        boolean w11 = r11.w();
        boolean u11 = r11.u();
        boolean x11 = r11.x();
        boolean t11 = r11.t();
        boolean s11 = r11.s();
        int i11 = r11.i();
        String g11 = r11.g();
        return w11 || u11 || x11 || t11 || s11 || i11 > 0 || (g11 != null && !g11.isEmpty()) || Merchant.SUPER.value.equals(r11.j());
    }

    public final void j(OtcAdsFilterType otcAdsFilterType) {
        d dVar = this.f79933g;
        if (dVar != null) {
            dVar.G8(otcAdsFilterType);
        }
    }

    public void m() {
        op.a r11 = op.a.r(this.f79940n);
        String a11 = r11.a();
        if (TextUtils.isEmpty(a11) || "0".equals(a11)) {
            this.f79928b.e();
        } else {
            this.f79928b.d();
        }
        String n11 = r11.n();
        if (TextUtils.isEmpty(n11) || "0".equals(n11)) {
            this.f79929c.e();
        } else {
            this.f79929c.d();
        }
        setFilterCheckedStatus(i());
    }

    public void setAvailableBtn(boolean z11) {
        if (this.f79939m != z11) {
            this.f79939m = z11;
            this.f79934h.setChecked(z11);
            op.a.r(this.f79940n).L(z11);
        }
    }

    public void setCoinName(String str) {
        this.f79938l.setText(str.toUpperCase());
        ConfigPreferences.m("otc_config", "otc_select_trade_coin", str.toUpperCase());
        f6.c.a().f(this.f79937k, f.b().c((String) this.f79938l.getText()), R$drawable.coin_default_icon);
    }

    public void setFilterCallBack(d dVar) {
        this.f79933g = dVar;
    }

    public void setType(int i11) {
        this.f79940n = i11;
        LinearLayout linearLayout = this.f79936j;
        boolean z11 = true;
        if (i11 == 1) {
            z11 = false;
        }
        ViewUtil.m(linearLayout, z11);
    }

    public OtcAdsFilterTopView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f79940n = 0;
        h(context);
    }
}
