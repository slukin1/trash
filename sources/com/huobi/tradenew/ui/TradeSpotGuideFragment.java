package com.huobi.tradenew.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pro.huobi.R;

public class TradeSpotGuideFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public TextView f83218b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f83219c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f83220d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f83221e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f83222f;

    /* renamed from: g  reason: collision with root package name */
    public View f83223g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f83224h;

    /* renamed from: i  reason: collision with root package name */
    public int f83225i = 1;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void vh(View view) {
        this.f83225i++;
        l3();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void wh(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent(r rVar) {
    }

    public void afterInit() {
    }

    public int getContentViewResId() {
        return R.layout.fragment_trade_spot_guide;
    }

    public int getGravity() {
        return 17;
    }

    public void initView(r rVar) {
        this.f83224h = (ImageView) rVar.b(R.id.iv_trade_spot_guide);
        this.f83218b = (TextView) rVar.b(R.id.tv_guide_jump);
        this.f83219c = (TextView) rVar.b(R.id.tv_guide_confirm);
        this.f83220d = (TextView) rVar.b(R.id.tv_guide_next);
        this.f83221e = (TextView) rVar.b(R.id.tv_trade_guide_title);
        this.f83222f = (TextView) rVar.b(R.id.tv_trade_guide_content);
        this.f83223g = rVar.b(R.id.rl_guide_jump_next);
        l3();
        this.f83218b.setOnClickListener(new c2(this));
        this.f83220d.setOnClickListener(new b2(this));
        this.f83219c.setOnClickListener(new d2(this));
    }

    public boolean isFullScreen() {
        return false;
    }

    public boolean isTransparent() {
        return false;
    }

    public final void l3() {
        boolean isChineseLanguage = AppLanguageHelper.getInstance().isChineseLanguage();
        int i11 = this.f83225i;
        if (i11 == 1) {
            this.f83224h.setImageResource(isChineseLanguage ? R.drawable.trade_spot_margin_guide1 : R.drawable.trade_spot_margin_guide1_en);
            TextView textView = this.f83218b;
            textView.setText(getResources().getString(R.string.skip) + "(1/3)");
            this.f83221e.setText(getResources().getString(R.string.n_exchange_spot_margin_trade));
            this.f83222f.setText(getResources().getString(R.string.n_exchange_spot_margin_slider_amount_operate));
        } else if (i11 == 2) {
            this.f83224h.setImageResource(isChineseLanguage ? R.drawable.trade_spot_margin_guide2 : R.drawable.trade_spot_margin_guide2_en);
            TextView textView2 = this.f83218b;
            textView2.setText(getResources().getString(R.string.skip) + "(2/3)");
            this.f83221e.setText(getResources().getString(R.string.n_exchange_spot_margin_price_track));
            this.f83222f.setText(getResources().getString(R.string.n_exchange_spot_margin_price_filter));
        } else if (i11 == 3) {
            this.f83223g.setVisibility(8);
            this.f83224h.setImageResource(isChineseLanguage ? R.drawable.trade_spot_margin_guide3 : R.drawable.trade_spot_margin_guide3_en);
            this.f83221e.setText(getResources().getString(R.string.n_exchange_spot_margin_amount_filter));
            this.f83222f.setText(getResources().getString(R.string.n_exchange_spot_margin_amount_operate_filter));
            this.f83219c.setVisibility(0);
        }
    }
}
