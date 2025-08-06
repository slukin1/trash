package com.huobi.index.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import pro.huobi.R;

public class IndexStepItemView extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public View f74013b;

    /* renamed from: c  reason: collision with root package name */
    public View f74014c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f74015d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f74016e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f74017f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f74018g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f74019h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f74020i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f74021j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f74022k;

    /* renamed from: l  reason: collision with root package name */
    public ImageView f74023l;

    public IndexStepItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_step_item, this);
        this.f74013b = findViewById(R.id.rl_style1_step_item);
        this.f74014c = findViewById(R.id.rl_style2_step_item);
        this.f74015d = (ImageView) findViewById(R.id.iv_style1_circle);
        this.f74016e = (ImageView) findViewById(R.id.iv_style1_step_arrow);
        this.f74017f = (TextView) findViewById(R.id.tv_style1_step_content);
        this.f74018g = (ImageView) findViewById(R.id.iv_style2_circle);
        this.f74022k = (TextView) findViewById(R.id.tv_style2_flag);
        this.f74019h = (TextView) findViewById(R.id.tv_style2_step_circle_unit);
        this.f74020i = (TextView) findViewById(R.id.tv_style2_step_circle_center);
        this.f74021j = (TextView) findViewById(R.id.tv_style2_step_content);
        this.f74023l = (ImageView) findViewById(R.id.iv_style2_step_arrow);
    }

    public IndexStepItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a();
    }
}
