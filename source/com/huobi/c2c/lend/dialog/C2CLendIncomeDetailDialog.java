package com.huobi.c2c.lend.dialog;

import android.view.View;
import android.widget.TextView;
import com.hbg.lib.core.util.w;
import com.hbg.lib.network.hbg.core.bean.C2CLendThresholdGetAssetInfo;
import com.hbg.lib.network.hbg.core.bean.C2CLoanBalanceInfo;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.c2c.util.o;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.m;
import i6.r;
import pi.a;
import pro.huobi.R;

public class C2CLendIncomeDetailDialog extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public View f42907b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f42908c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f42909d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f42910e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f42911f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f42912g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f42913h;

    /* renamed from: i  reason: collision with root package name */
    public String f42914i;

    /* renamed from: j  reason: collision with root package name */
    public C2CLoanBalanceInfo f42915j;

    /* renamed from: k  reason: collision with root package name */
    public C2CLendThresholdGetAssetInfo f42916k;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent(r rVar) {
        this.f42907b.setOnClickListener(new a(this));
    }

    public void afterInit() {
        String z11 = k.C().z(this.f42914i);
        if (this.f42908c != null) {
            String string = getResources().getString(R.string.c_to_c_loan);
            TextView textView = this.f42908c;
            textView.setText(string + " " + z11);
        }
        String string2 = getResources().getString(R.string.n_c2c_lend_out_lend_out_ing);
        TextView textView2 = this.f42910e;
        if (textView2 != null) {
            textView2.setText(string2 + "(" + z11 + ")");
        }
        yh();
        zh();
        xh();
        wh();
    }

    public int getAnimationStyle() {
        return R.style.top_dialog_animation;
    }

    public int getContentViewResId() {
        return R.layout.c2c_lend_income_detail_dialog;
    }

    public int getGravity() {
        return 48;
    }

    public void initView(r rVar) {
        this.f42907b = rVar.b(R.id.c2c_lend_income_detail_dialog);
        this.f42908c = (TextView) rVar.b(R.id.c2c_lend_income_detail_dialog_title);
        this.f42909d = (TextView) rVar.b(R.id.c2c_lend_income_detail_dialog_lended);
        this.f42910e = (TextView) rVar.b(R.id.c2c_lend_income_detail_dialog_lended_title);
        this.f42911f = (TextView) rVar.b(R.id.c2c_lend_income_detail_dialog_pre_income);
        this.f42912g = (TextView) rVar.b(R.id.c2c_lend_income_detail_dialog_total_income);
        this.f42913h = (TextView) rVar.b(R.id.c2c_lend_income_detail_dialog_ordering);
    }

    public boolean isTransparent() {
        return false;
    }

    public void th(C2CLendThresholdGetAssetInfo c2CLendThresholdGetAssetInfo) {
        this.f42916k = c2CLendThresholdGetAssetInfo;
    }

    public void uh(C2CLoanBalanceInfo c2CLoanBalanceInfo) {
        this.f42915j = c2CLoanBalanceInfo;
    }

    public void vh(String str) {
        this.f42914i = str;
    }

    public final void wh() {
        if (this.f42909d != null) {
            C2CLendThresholdGetAssetInfo c2CLendThresholdGetAssetInfo = this.f42916k;
            this.f42909d.setText(c2CLendThresholdGetAssetInfo != null ? m.m(c2CLendThresholdGetAssetInfo.getLendedUnRepayAmount(), o.a()) : "--");
        }
    }

    public final void xh() {
        if (this.f42913h != null) {
            C2CLoanBalanceInfo c2CLoanBalanceInfo = this.f42915j;
            String m11 = c2CLoanBalanceInfo != null ? m.m(m.a(c2CLoanBalanceInfo.getTotalAmount()).subtract(m.a(this.f42915j.getFilledAmount())).toPlainString(), o.a()) : "--";
            String z11 = k.C().z(this.f42914i);
            TextView textView = this.f42913h;
            textView.setText(m11 + " " + z11);
        }
    }

    public final void yh() {
        if (this.f42911f != null) {
            C2CLoanBalanceInfo c2CLoanBalanceInfo = this.f42915j;
            String m11 = c2CLoanBalanceInfo != null ? m.m(c2CLoanBalanceInfo.getExpectIncome(), o.d(this.f42914i)) : "--";
            String z11 = k.C().z(this.f42914i);
            TextView textView = this.f42911f;
            textView.setText(m11 + " " + z11);
            this.f42911f.setTextColor(getResources().getColor(w.h()));
        }
    }

    public final void zh() {
        if (this.f42912g != null) {
            C2CLoanBalanceInfo c2CLoanBalanceInfo = this.f42915j;
            String m11 = c2CLoanBalanceInfo != null ? m.m(c2CLoanBalanceInfo.getAccumulatedIncome(), o.d(this.f42914i)) : "--";
            String z11 = k.C().z(this.f42914i);
            TextView textView = this.f42912g;
            textView.setText(m11 + " " + z11);
            this.f42912g.setTextColor(getResources().getColor(w.h()));
        }
    }
}
