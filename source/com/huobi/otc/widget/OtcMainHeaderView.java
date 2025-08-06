package com.huobi.otc.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.KeyboardUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.otc.enums.OtcTradeAreaEnum;
import com.huobi.otc.ui.OtcTradeActivity;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jp.b1;
import rp.g;
import rx.Observable;
import vp.d0;
import vp.e0;
import vp.f0;
import vp.g0;

public class OtcMainHeaderView extends FrameLayout implements g.b {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f79989b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f79990c;

    /* renamed from: d  reason: collision with root package name */
    public View f79991d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f79992e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f79993f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f79994g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f79995h;

    /* renamed from: i  reason: collision with root package name */
    public View f79996i;

    /* renamed from: j  reason: collision with root package name */
    public Map<OtcTradeAreaEnum, String> f79997j = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    public a f79998k;

    /* renamed from: l  reason: collision with root package name */
    public g f79999l;

    /* renamed from: m  reason: collision with root package name */
    public int f80000m = 0;

    public interface a {
        void a(OtcTradeAreaEnum otcTradeAreaEnum);
    }

    public OtcMainHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j(context);
        g();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(Void voidR) {
        if (getContext() instanceof Activity) {
            KeyboardUtils.i((Activity) getContext());
            ((Activity) getContext()).finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(Void voidR) {
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f79992e.getWindowToken(), 0);
        this.f79999l.showAsDropDown(this);
        this.f79994g.setRotation(180.0f);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(Void voidR) {
        if (getContext() instanceof OtcTradeActivity) {
            OtcTradeActivity otcTradeActivity = (OtcTradeActivity) getContext();
            otcTradeActivity.xi(2, otcTradeActivity.Rh(), !b1.h().j() ? 1 : 0, String.valueOf(otcTradeActivity.fd()), this.f80000m);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(Void voidR) {
        OtcModuleConfig.a().K(getContext());
    }

    public void a(OtcTradeAreaEnum otcTradeAreaEnum) {
        if (otcTradeAreaEnum != null) {
            this.f79998k.a(otcTradeAreaEnum);
        }
    }

    public void b() {
        this.f79994g.setRotation(0.0f);
    }

    public final void g() {
        Observable<Void> a11 = dw.a.a(this.f79989b);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a11.throttleFirst(300, timeUnit).subscribe(new f0(this));
        dw.a.a(this.f79992e).throttleFirst(300, timeUnit).subscribe(new d0(this));
        dw.a.a(this.f79990c).throttleFirst(300, timeUnit).subscribe(new e0(this));
        dw.a.a(this.f79995h).throttleFirst(300, timeUnit).subscribe(new g0(this));
    }

    public View getGuideTab() {
        return this.f79992e;
    }

    public View getMenuGroup() {
        return this.f79991d;
    }

    public void h() {
        this.f79997j.put(OtcTradeAreaEnum.FAST_AREA, getResources().getString(R$string.n_otc_quick_trade));
        this.f79997j.put(OtcTradeAreaEnum.FREE_AREA, getResources().getString(R$string.n_otc_p2p));
        this.f79997j.put(OtcTradeAreaEnum.DEPOSIT_AREA, getResources().getString(R$string.n_otc_deposit));
    }

    public void i(OtcTradeAreaEnum otcTradeAreaEnum) {
        this.f79993f.setText(this.f79997j.get(otcTradeAreaEnum));
        if (otcTradeAreaEnum == OtcTradeAreaEnum.FREE_AREA) {
            this.f79995h.setVisibility(0);
        } else {
            this.f79995h.setVisibility(8);
        }
    }

    public final void j(Context context) {
        FrameLayout.inflate(context, R$layout.otc_main_header_layout, this);
        this.f79989b = (ImageView) findViewById(R$id.id_back_iv);
        this.f79995h = (ImageView) findViewById(R$id.iv_merchant_search);
        this.f79991d = findViewById(R$id.id_main_menu_view);
        this.f79990c = (ImageView) findViewById(R$id.id_head_menu);
        this.f79992e = (LinearLayout) findViewById(R$id.id_title_container);
        this.f79993f = (TextView) findViewById(R$id.id_area_title);
        this.f79994g = (ImageView) findViewById(R$id.id_change_area_icon);
        this.f79996i = findViewById(R$id.id_order_red_dot);
        g gVar = new g(context);
        this.f79999l = gVar;
        gVar.o(this);
        h();
    }

    public void o(int i11) {
        this.f80000m = i11;
        if (i11 == 0) {
            setBackgroundColor(Color.parseColor("#FF0E0E0E"));
            this.f79989b.setImageResource(R$drawable.otc_band_back_icon);
            this.f79990c.setImageResource(R$drawable.otc_band_more_icon);
            this.f79994g.setImageResource(R$drawable.otc_band_currency_arrow);
            this.f79993f.setTextColor(Color.parseColor("#FFE6E6E6"));
            this.f79995h.setImageResource(R$drawable.otc_brand_search_icon);
            return;
        }
        if (NightHelper.e().g()) {
            setBackgroundColor(Color.parseColor("#FF161616"));
        } else {
            setBackgroundColor(getResources().getColor(R$color.baseColorInputBackground, getContext().getTheme()));
        }
        this.f79989b.setImageResource(R$drawable.otc_title_back);
        this.f79990c.setImageResource(R$drawable.otc_header_menu_icon);
        this.f79994g.setImageResource(R$drawable.otc_change_area_down);
        this.f79993f.setTextColor(getResources().getColor(R$color.baseColorPrimaryText, getContext().getTheme()));
        this.f79995h.setImageResource(R$drawable.otc_normal_search_icon);
    }

    public void setHeaderCallback(a aVar) {
        this.f79998k = aVar;
    }

    public void setUnreadNum(int i11) {
        ViewUtil.m(this.f79996i, i11 > 0);
    }
}
