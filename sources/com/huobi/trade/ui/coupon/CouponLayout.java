package com.huobi.trade.ui.coupon;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.SP;
import com.hbg.module.libkt.base.ext.b;
import com.huobi.coupon.CouponChooseDialog;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.trade.ui.coupon.CouponEngineFragment;
import gs.g;
import ij.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kt.c;
import kt.d;
import pro.huobi.R;

public class CouponLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public View f82605b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f82606c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f82607d;

    /* renamed from: e  reason: collision with root package name */
    public a f82608e;

    /* renamed from: f  reason: collision with root package name */
    public CouponEngineFragment.b f82609f;

    /* renamed from: g  reason: collision with root package name */
    public CouponEngineFragment f82610g;

    /* renamed from: h  reason: collision with root package name */
    public String f82611h;

    /* renamed from: i  reason: collision with root package name */
    public String f82612i;

    public interface a {
        CouponReturn i1();
    }

    public CouponLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d(context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(CouponReturn couponReturn) {
        CouponEngineFragment.b bVar = this.f82609f;
        if (bVar != null) {
            bVar.a(couponReturn);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(Context context, Void voidR) {
        j g11 = j.g();
        a aVar = this.f82608e;
        ArrayList<CouponReturn> f11 = g11.f("9,12", aVar == null ? null : aVar.i1());
        if (f11 != null && f11.size() > 0 && (context instanceof FragmentActivity)) {
            CouponChooseDialog.th().wh("9,12", new c(this)).show(((FragmentActivity) context).getSupportFragmentManager(), FirebaseAnalytics.Param.COUPON);
        }
    }

    public void c() {
        CouponEngineFragment couponEngineFragment = this.f82610g;
        if (couponEngineFragment != null) {
            couponEngineFragment.dismiss();
        }
    }

    public final void d(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_contract_coupon, (ViewGroup) null);
        this.f82605b = inflate;
        inflate.findViewById(R.id.contract_coupon_rl).setVisibility(0);
        this.f82606c = (TextView) this.f82605b.findViewById(R.id.contract_coupon_value_tv);
        this.f82607d = (ImageView) this.f82605b.findViewById(R.id.contract_coupon_red_iv);
        addView(this.f82605b, new ViewGroup.LayoutParams(-1, -2));
        dw.a.a(this.f82605b).throttleFirst(500, TimeUnit.MILLISECONDS).subscribe(new d(this, context));
    }

    public void g() {
        if (!b.w(j.g().f("9,12", (CouponReturn) null))) {
            int i11 = 0;
            boolean k11 = SP.k("couponChoose", "hasNewCoupon9,12", false);
            ImageView imageView = this.f82607d;
            if (!k11) {
                i11 = 8;
            }
            imageView.setVisibility(i11);
        }
    }

    public void h(String str, String str2) {
        this.f82611h = str;
        this.f82612i = str2;
    }

    public void i(int i11, String str, int i12) {
        if (getVisibility() != 0 && i11 == 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("trade_mode", this.f82611h);
            hashMap.put("version_type", this.f82612i);
            g.i("app_trade_coupon_view", hashMap);
        }
        setVisibility(i11);
        if (i11 == 0) {
            if (!b.w(j.g().f("9,12", (CouponReturn) null))) {
                int i13 = 0;
                boolean k11 = SP.k("couponChoose", "hasNewCoupon9,12", false);
                ImageView imageView = this.f82607d;
                if (!k11) {
                    i13 = 8;
                }
                imageView.setVisibility(i13);
            }
            this.f82606c.setText(str);
        }
    }

    public void setCallback(CouponEngineFragment.b bVar) {
        this.f82609f = bVar;
    }

    public void setSelectedCouponCallback(a aVar) {
        this.f82608e = aVar;
    }

    public CouponLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        d(context);
    }
}
