package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.HashMap;
import uf.c;

public class OtcTradeGuideView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public int f80105b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f80106c = 0;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f80107d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f80108e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f80109f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f80110g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f80111h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f80112i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f80113j = false;

    /* renamed from: k  reason: collision with root package name */
    public boolean f80114k = false;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            c.b().r("otc_p2p_newUserTip_close_click", "", (HashMap) null);
            OtcTradeGuideView.this.f80107d.setVisibility(8);
            boolean unused = OtcTradeGuideView.this.f80113j = true;
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            c.b().r("otc_p2p_newUserTip_close_click", "", (HashMap) null);
            OtcTradeGuideView.this.f80108e.setVisibility(8);
            boolean unused = OtcTradeGuideView.this.f80114k = true;
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public OtcTradeGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(context);
    }

    public final void e(Context context) {
        View.inflate(context, R$layout.otc_trade_p2p_guide_layout, this);
        this.f80107d = (LinearLayout) findViewById(R$id.guide_container_buy_new);
        this.f80108e = (LinearLayout) findViewById(R$id.guide_container_sell_new);
        this.f80109f = (TextView) findViewById(R$id.guide_tip_text_buy);
        this.f80110g = (ImageView) findViewById(R$id.guide_tip_buy_close);
        this.f80111h = (TextView) findViewById(R$id.guide_tip_text_sell);
        this.f80112i = (ImageView) findViewById(R$id.guide_tip_sell_close);
        this.f80110g.setOnClickListener(new a());
        this.f80112i.setOnClickListener(new b());
    }

    public int getGuideStatus() {
        return this.f80106c;
    }

    public int getTradeType() {
        return this.f80105b;
    }

    public void setBuyTextListener(View.OnClickListener onClickListener) {
        this.f80109f.setOnClickListener(onClickListener);
    }

    public void setSellTextListener(View.OnClickListener onClickListener) {
        this.f80111h.setOnClickListener(onClickListener);
    }
}
