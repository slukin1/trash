package com.huobi.asset2.index.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;

public class FeatureEntranceItemView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public View f42674b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f42675c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f42676d;

    public FeatureEntranceItemView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        this.f42674b = LayoutInflater.from(context).inflate(R$layout.item_asset_entrance_bar, this);
        this.f42675c = (ImageView) findViewById(R$id.iv_icon);
        this.f42676d = (TextView) findViewById(R$id.tv_label);
    }

    public void b(int i11, int i12) {
        this.f42675c.setImageResource(i11);
        this.f42676d.setText(i12);
    }

    public FeatureEntranceItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public FeatureEntranceItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context);
    }
}
