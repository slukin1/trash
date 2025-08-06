package com.huobi.otc.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.coupon.bean.Coupon;
import com.huobi.otc.widget.CouponItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.List;
import vp.t0;
import vp.u0;
import vp.v0;

public class UseSelectCouponView extends FrameLayout implements CouponItem.c {

    /* renamed from: b  reason: collision with root package name */
    public EasyRecyclerView<Coupon> f80190b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f80191c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f80192d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f80193e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f80194f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f80195g;

    /* renamed from: h  reason: collision with root package name */
    public Coupon f80196h;

    /* renamed from: i  reason: collision with root package name */
    public List<Coupon> f80197i;

    /* renamed from: j  reason: collision with root package name */
    public a f80198j;

    /* renamed from: k  reason: collision with root package name */
    public int f80199k = -1;

    /* renamed from: l  reason: collision with root package name */
    public HBDialogFragment f80200l;

    /* renamed from: m  reason: collision with root package name */
    public Coupon f80201m;

    /* renamed from: n  reason: collision with root package name */
    public Activity f80202n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f80203o = true;

    /* renamed from: p  reason: collision with root package name */
    public boolean f80204p = true;

    public interface a {
        void a(Coupon coupon);

        void b(Coupon coupon);

        void c();

        void onBack();
    }

    public UseSelectCouponView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void i(View view) {
        List<Coupon> list;
        this.f80196h = null;
        this.f80191c.setImageDrawable(ContextCompat.getDrawable(getContext(), R$drawable.common_check_selected));
        this.f80203o = false;
        int i11 = this.f80199k;
        if (i11 >= 0 && (list = this.f80197i) != null && i11 < list.size()) {
            this.f80197i.get(this.f80199k).setSelected(false);
        }
        this.f80199k = -1;
        this.f80190b.c();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void j(View view) {
        a aVar = this.f80198j;
        if (aVar == null) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (!this.f80203o) {
            aVar.c();
        } else {
            aVar.b(this.f80196h);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void k(View view) {
        a aVar = this.f80198j;
        if (aVar != null) {
            aVar.onBack();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void b(View view, Coupon coupon) {
    }

    public void c(HBDialogFragment hBDialogFragment, Coupon coupon) {
        this.f80200l = hBDialogFragment;
        this.f80201m = coupon;
    }

    public void d(Coupon coupon) {
        a aVar = this.f80198j;
        if (aVar != null) {
            aVar.a(coupon);
        }
    }

    public void e(View view, Coupon coupon) {
        int indexOf;
        List<Coupon> list = this.f80197i;
        if (list != null && this.f80199k != (indexOf = list.indexOf(coupon))) {
            this.f80191c.setImageDrawable(ContextCompat.getDrawable(getContext(), R$drawable.marquee_unselected));
            this.f80203o = true;
            this.f80196h = coupon;
            coupon.setSelected(true);
            int i11 = this.f80199k;
            if (i11 >= 0 && i11 < this.f80197i.size()) {
                this.f80197i.get(this.f80199k).setSelected(false);
            }
            this.f80199k = indexOf;
            this.f80190b.c();
        }
    }

    public Activity getRootActivity() {
        return this.f80202n;
    }

    public RelativeLayout getTitleRl() {
        return this.f80195g;
    }

    public final void h() {
        View inflate = FrameLayout.inflate(getContext(), R$layout.use_select_coupon_list_layout, this);
        this.f80190b = (EasyRecyclerView) inflate.findViewById(R$id.coupon_list_rv);
        this.f80191c = (ImageView) inflate.findViewById(R$id.select_payment_iv);
        this.f80193e = (RelativeLayout) inflate.findViewById(R$id.select_coupon_btn);
        this.f80194f = (RelativeLayout) inflate.findViewById(R$id.unused_coupon_rl);
        this.f80192d = (ImageView) inflate.findViewById(R$id.back_image);
        this.f80195g = (RelativeLayout) inflate.findViewById(R$id.title_rl);
        this.f80194f.setOnClickListener(new t0(this));
        this.f80193e.setOnClickListener(new u0(this));
        this.f80192d.setOnClickListener(new v0(this));
    }

    public void setCallback(a aVar) {
        this.f80198j = aVar;
    }

    public void setMActivity(Activity activity) {
        this.f80202n = activity;
    }

    public void setSelectCoupon(Coupon coupon) {
        this.f80196h = coupon;
    }

    public UseSelectCouponView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        h();
    }
}
