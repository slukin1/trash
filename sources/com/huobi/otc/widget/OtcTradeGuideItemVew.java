package com.huobi.otc.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.network.otc.core.bean.TradeGuideItemBean;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;

public class OtcTradeGuideItemVew extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f80099b;

    /* renamed from: c  reason: collision with root package name */
    public View f80100c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f80101d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f80102e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f80103f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f80104g;

    public OtcTradeGuideItemVew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public final void a(Context context) {
        View.inflate(context, R$layout.dialog_trade_guide_item_layout, this);
        this.f80099b = (ImageView) findViewById(R$id.iv_left);
        this.f80100c = findViewById(R$id.view_divide);
        this.f80101d = (TextView) findViewById(R$id.tv_top);
        this.f80102e = (TextView) findViewById(R$id.tv_des);
        this.f80103f = (TextView) findViewById(R$id.tv_sub_des);
        this.f80104g = (LinearLayout) findViewById(R$id.ll_left);
    }

    public void setData(TradeGuideItemBean tradeGuideItemBean) {
        if (tradeGuideItemBean.getImageRes() != 0) {
            this.f80104g.setVisibility(0);
            this.f80099b.setImageResource(tradeGuideItemBean.getImageRes());
        } else {
            this.f80104g.setVisibility(8);
        }
        this.f80101d.setText(tradeGuideItemBean.getTitleStr());
        String desStr = tradeGuideItemBean.getDesStr();
        if (!TextUtils.isEmpty(desStr)) {
            this.f80102e.setVisibility(0);
            this.f80102e.setText(desStr);
        } else {
            this.f80102e.setVisibility(8);
        }
        String subDesStr = tradeGuideItemBean.getSubDesStr();
        if (!TextUtils.isEmpty(subDesStr)) {
            this.f80103f.setVisibility(0);
            this.f80103f.setText(subDesStr);
        } else {
            this.f80103f.setVisibility(8);
        }
        if (tradeGuideItemBean.isLast()) {
            this.f80100c.setVisibility(8);
        } else {
            this.f80100c.setVisibility(0);
        }
    }
}
