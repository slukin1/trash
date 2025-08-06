package com.hbg.lib.widgets.tablayout;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.widgets.R$font;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import la.a;
import la.b;

public class TabItemLayout extends LinearLayout implements View.OnClickListener, a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f72310b;

    /* renamed from: c  reason: collision with root package name */
    public int f72311c;

    /* renamed from: d  reason: collision with root package name */
    public b f72312d;

    /* renamed from: e  reason: collision with root package name */
    public int f72313e;

    /* renamed from: f  reason: collision with root package name */
    public int f72314f;

    /* renamed from: g  reason: collision with root package name */
    public TabItemView f72315g;

    /* renamed from: h  reason: collision with root package name */
    public TabItemView f72316h;

    /* renamed from: i  reason: collision with root package name */
    public TabItemView f72317i;

    /* renamed from: j  reason: collision with root package name */
    public String f72318j;

    /* renamed from: k  reason: collision with root package name */
    public String f72319k;

    /* renamed from: l  reason: collision with root package name */
    public String f72320l;

    public TabItemLayout(Context context) {
        this(context, (AttributeSet) null);
        a(context);
    }

    public final void a(Context context) {
        setGravity(16);
        removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        TabItemView tabItemView = new TabItemView(getContext());
        this.f72315g = tabItemView;
        tabItemView.setLayoutParams(layoutParams);
        this.f72315g.setGravity(8388627);
        this.f72315g.setTypeface(ResourcesCompat.h(context, R$font.roboto_medium));
        addView(this.f72315g);
        if (TextUtils.isEmpty(this.f72318j)) {
            this.f72315g.setVisibility(8);
        } else {
            this.f72315g.setVisibility(0);
        }
        TabItemView tabItemView2 = new TabItemView(getContext());
        this.f72316h = tabItemView2;
        tabItemView2.setLayoutParams(layoutParams);
        this.f72316h.setGravity(17);
        addView(this.f72316h);
        if (TextUtils.isEmpty(this.f72319k)) {
            this.f72316h.setVisibility(8);
        } else {
            this.f72316h.setVisibility(0);
        }
        TabItemView tabItemView3 = new TabItemView(getContext());
        this.f72317i = tabItemView3;
        tabItemView3.setLayoutParams(layoutParams);
        this.f72317i.setGravity(8388629);
        addView(this.f72317i);
        if (TextUtils.isEmpty(this.f72320l)) {
            this.f72317i.setVisibility(8);
        } else {
            this.f72317i.setVisibility(0);
        }
        setOnClickListener(this);
        setChecked(this.f72310b);
    }

    public void c(boolean z11, boolean z12) {
        this.f72310b = z11;
        int childCount = getChildCount();
        setSelected(z11);
        for (int i11 = 0; i11 < childCount; i11++) {
            ((a) getChildAt(i11)).c(z11, z12);
        }
    }

    public TabItemView getMiddleView() {
        return this.f72316h;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        b bVar = this.f72312d;
        if (bVar != null) {
            bVar.onItemClick(this.f72311c);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void setChecked(boolean z11) {
        c(z11, false);
    }

    public void setItemClickCallBack(b bVar) {
        this.f72312d = bVar;
    }

    public void setLeftViewText(String str) {
        this.f72318j = str;
        this.f72315g.setText(str);
        if (TextUtils.isEmpty(this.f72318j)) {
            this.f72315g.setVisibility(8);
        } else {
            this.f72315g.setVisibility(0);
        }
    }

    public void setLeftViewTextSize(int i11) {
        this.f72315g.setTextSize((float) i11);
    }

    public void setMiddleViewText(String str) {
        this.f72319k = str;
        this.f72316h.setText(str);
        if (TextUtils.isEmpty(this.f72319k)) {
            this.f72316h.setVisibility(8);
        } else {
            this.f72316h.setVisibility(0);
        }
    }

    public void setMiddleViewTextSize(int i11) {
        this.f72316h.setTextSize((float) i11);
    }

    public void setPosition(int i11) {
        this.f72311c = i11;
    }

    public void setRightViewText(String str) {
        this.f72320l = str;
        this.f72317i.setText(str);
        if (TextUtils.isEmpty(this.f72320l)) {
            this.f72317i.setVisibility(8);
        } else {
            this.f72317i.setVisibility(0);
        }
    }

    public void setRightViewTextSize(int i11) {
        this.f72317i.setTextSize((float) i11);
    }

    public void setTabCheckTextColor(int i11) {
        this.f72313e = i11;
        this.f72315g.setCheckColor(i11);
        this.f72316h.setCheckColor(this.f72313e);
        this.f72317i.setCheckColor(this.f72313e);
    }

    public void setTabUnCheckTextColor(int i11) {
        this.f72314f = i11;
        this.f72315g.setUnCheckColor(i11);
        this.f72316h.setUnCheckColor(this.f72314f);
        this.f72317i.setUnCheckColor(this.f72314f);
    }

    public TabItemLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabItemLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context);
    }
}
