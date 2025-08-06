package com.huobi.otc.widget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.otc.widget.CouponCountDown;
import com.huobi.view.CouponCardView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.concurrent.TimeUnit;
import rx.functions.Action1;
import vp.i;
import vp.j;
import vp.k;

public class CouponReturnItem extends RelativeLayout implements CouponCountDown.b {

    /* renamed from: b  reason: collision with root package name */
    public CouponCardView f79723b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f79724c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f79725d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f79726e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f79727f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f79728g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f79729h;

    /* renamed from: i  reason: collision with root package name */
    public b f79730i;

    /* renamed from: j  reason: collision with root package name */
    public CouponReturn f79731j;

    /* renamed from: k  reason: collision with root package name */
    public HBDialogFragment f79732k;

    /* renamed from: l  reason: collision with root package name */
    public LinearLayout f79733l;

    /* renamed from: m  reason: collision with root package name */
    public LinearLayout f79734m;

    /* renamed from: n  reason: collision with root package name */
    public AmountTextView f79735n;

    public class a implements Action1<Void> {
        public a() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            if (CouponReturnItem.this.f79730i != null) {
                CouponReturnItem.this.f79730i.l0(CouponReturnItem.this.f79723b, CouponReturnItem.this.f79731j);
            }
        }
    }

    public interface b {
        void Qg(CouponReturn couponReturn);

        void f4(HBDialogFragment hBDialogFragment, CouponReturn couponReturn);

        Activity getRootActivity();

        void l0(View view, CouponReturn couponReturn);
    }

    public CouponReturnItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j(context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(HBDialogFragment hBDialogFragment) {
        b bVar = this.f79730i;
        if (bVar != null) {
            bVar.f4((HBDialogFragment) null, (CouponReturn) null);
        }
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void m(CouponReturn couponReturn, View view) {
        b bVar = this.f79730i;
        Activity activity = bVar != null ? (FragmentActivity) bVar.getRootActivity() : null;
        if (activity == null) {
            activity = oa.a.g().b();
        }
        HBDialogFragment j02 = new DialogUtils.b.d((FragmentActivity) activity).c1(getResources().getString(R$string.n_coupon_used_rules)).C0(couponReturn.getRules()).R0("").T0(true).q0(false).P0(getResources().getString(R$string.n_known)).Q0(new j(this)).j0();
        this.f79732k = j02;
        j02.show(((FragmentActivity) oa.a.g().b()).getSupportFragmentManager(), "");
        b bVar2 = this.f79730i;
        if (bVar2 != null) {
            bVar2.f4(this.f79732k, this.f79731j);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: setDataBoxData */
    public void k(String str) {
        try {
            if (this.f79728g.getPaint().measureText(str) >= ((float) this.f79734m.getMeasuredWidth())) {
                int indexOf = str.indexOf(InstructionFileId.DOT) - 4;
                str = str.substring(0, indexOf) + "\n" + str.substring(indexOf);
            }
            this.f79728g.setText(str);
        } catch (Exception unused) {
        }
    }

    public void a() {
        HBDialogFragment hBDialogFragment = this.f79732k;
        if (hBDialogFragment != null && hBDialogFragment.th()) {
            this.f79732k.dismiss();
        }
        b bVar = this.f79730i;
        if (bVar != null) {
            bVar.Qg(this.f79731j);
        }
    }

    public CouponCardView getCouponCardView() {
        return this.f79723b;
    }

    public TextView getTextViewCouponItemDesc() {
        return this.f79726e;
    }

    public TextView getTextViewCouponItemRule() {
        return this.f79727f;
    }

    public final void h() {
        dw.a.a(this.f79723b).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new a());
    }

    public void i(CouponReturn couponReturn) {
        if (couponReturn != null) {
            this.f79731j = couponReturn;
            this.f79735n.setVisibility(0);
            this.f79735n.f("", String.format("%sU", new Object[]{couponReturn.getAmount()}));
            if (!TextUtils.isEmpty(couponReturn.getMeetCondition())) {
                try {
                    if (Integer.parseInt(couponReturn.getMeetCondition()) > 0) {
                        ViewUtil.m(this.f79724c, true);
                        this.f79724c.setText(String.format(getResources().getString(R$string.n_coupon_return_meet_condition), new Object[]{couponReturn.getMeetCondition(), couponReturn.getAmount()}));
                    } else if (couponReturn.showNoThreshold) {
                        this.f79724c.setText(getResources().getString(R$string.n_exchange_coupon_nothreshold));
                    } else {
                        ViewUtil.m(this.f79724c, false);
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                    ViewUtil.m(this.f79724c, false);
                }
            } else if (couponReturn.showNoThreshold) {
                this.f79724c.setText(getResources().getString(R$string.n_exchange_coupon_nothreshold));
            } else {
                ViewUtil.m(this.f79724c, false);
            }
            this.f79725d.setText(getResources().getString(R$string.n_coupon_return_item_title));
            this.f79726e.setText(getResources().getString(R$string.n_coupon_return_item_desc));
            this.f79723b.setLeftColor(getResources().getColor(R$color.baseColorShadeFunctionButtonStart));
            this.f79734m.postDelayed(new k(this, String.format(getResources().getString(R$string.n_coupon_time_dealine), new Object[]{DateTimeUtils.h(couponReturn.getValidAt(), "yyyy.MM.dd")})), 100);
            n(couponReturn);
            this.f79727f.setOnClickListener(new i(this, couponReturn));
        }
    }

    public final void j(Context context) {
        LayoutInflater.from(context).inflate(R$layout.view_coupon_return_item, this, true);
        this.f79723b = (CouponCardView) findViewById(R$id.coupon_cart_view_coupon_item);
        this.f79735n = (AmountTextView) findViewById(R$id.amount_text_view_coupon_item);
        this.f79733l = (LinearLayout) findViewById(R$id.linear_layout_coupon_item_rule_box);
        this.f79734m = (LinearLayout) findViewById(R$id.linear_layout_coupon_item_date_box);
        this.f79724c = (TextView) findViewById(R$id.text_view_coupon_item_type);
        this.f79725d = (TextView) findViewById(R$id.auto_size_text_view_coupon_item_title);
        this.f79726e = (TextView) findViewById(R$id.text_view_coupon_item_desc);
        this.f79727f = (TextView) findViewById(R$id.text_view_coupon_item_rule);
        this.f79728g = (TextView) findViewById(R$id.text_view_coupon_item_time);
        this.f79729h = (ImageView) findViewById(R$id.coupon_select_iv);
        h();
    }

    public final void n(CouponReturn couponReturn) {
        int i11;
        Context context = getContext();
        if (context != null) {
            ImageView imageView = this.f79729h;
            if (couponReturn.isSelected()) {
                i11 = R$drawable.marquee_selected;
            } else {
                i11 = R$drawable.marquee_unselected;
            }
            imageView.setImageResource(i11);
            if (couponReturn.isSelected()) {
                this.f79723b.setStrokeColor(ContextCompat.getColor(context, R$color.coupon_return_item_selected_color));
            } else {
                this.f79723b.setStrokeColor(ContextCompat.getColor(context, R$color.baseColorPrimarySeparator));
            }
        }
    }

    public void setCallback(b bVar) {
        this.f79730i = bVar;
    }

    public CouponReturnItem(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        j(context);
    }
}
