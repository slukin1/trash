package com.huobi.index.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import pro.huobi.R;

public class IndexStepView extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public View f74024b;

    /* renamed from: c  reason: collision with root package name */
    public View f74025c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressBar f74026d;

    /* renamed from: e  reason: collision with root package name */
    public ProgressBar f74027e;

    /* renamed from: f  reason: collision with root package name */
    public int f74028f;

    /* renamed from: g  reason: collision with root package name */
    public IndexStepItemView f74029g;

    /* renamed from: h  reason: collision with root package name */
    public IndexStepItemView f74030h;

    /* renamed from: i  reason: collision with root package name */
    public IndexStepItemView f74031i;

    /* renamed from: j  reason: collision with root package name */
    public IndexStepItemView f74032j;

    /* renamed from: k  reason: collision with root package name */
    public IndexStepItemView f74033k;

    /* renamed from: l  reason: collision with root package name */
    public IndexStepItemView f74034l;

    /* renamed from: m  reason: collision with root package name */
    public IndexStepItemView f74035m;

    public IndexStepView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_index_step, this);
        this.f74024b = findViewById(R.id.fl_style1_index_step);
        this.f74025c = findViewById(R.id.fl_style2_index_step);
        this.f74026d = (ProgressBar) findViewById(R.id.fl_style1_progress);
        this.f74027e = (ProgressBar) findViewById(R.id.fl_style2_progress);
        this.f74029g = (IndexStepItemView) findViewById(R.id.fl_style1_item1);
        this.f74030h = (IndexStepItemView) findViewById(R.id.fl_style1_item2);
        this.f74031i = (IndexStepItemView) findViewById(R.id.fl_style1_item3);
        this.f74032j = (IndexStepItemView) findViewById(R.id.fl_style2_item1);
        this.f74033k = (IndexStepItemView) findViewById(R.id.fl_style2_item2);
        this.f74034l = (IndexStepItemView) findViewById(R.id.fl_style2_item3);
        this.f74035m = (IndexStepItemView) findViewById(R.id.fl_style2_item4);
    }

    public IndexStepView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f74028f = 1;
        a();
    }
}
