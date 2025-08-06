package com.wtree.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ErrorView extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public int f51249b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f51250c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f51251d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f51252e;

    /* renamed from: f  reason: collision with root package name */
    public View f51253f;

    /* renamed from: g  reason: collision with root package name */
    public View f51254g;

    /* renamed from: h  reason: collision with root package name */
    public View f51255h;

    /* renamed from: i  reason: collision with root package name */
    public String f51256i;

    public ErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public View getContentView() {
        return this.f51254g;
    }

    public View getErrorImageView() {
        return this.f51250c;
    }

    public int getState() {
        return this.f51249b;
    }

    public void setBackgroundColor(int i11) {
        this.f51255h.setBackgroundColor(i11);
    }

    public void setName(String str) {
        this.f51256i = str;
    }

    public void setRetryOnClik(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f51254g.setOnClickListener(onClickListener);
        }
    }

    public void setState(int i11) {
        this.f51249b = i11;
        if (!(i11 == 1 || i11 == 2)) {
            if (i11 == 3) {
                this.f51250c.setVisibility(0);
                setVisibility(0);
                this.f51253f.setVisibility(8);
                this.f51254g.setVisibility(0);
                this.f51251d.setVisibility(0);
                this.f51252e.setVisibility(8);
                this.f51251d.setText("无数据");
                return;
            } else if (i11 != 4) {
                if (i11 == 5) {
                    this.f51250c.setVisibility(0);
                    setVisibility(0);
                    this.f51253f.setVisibility(0);
                    this.f51254g.setVisibility(8);
                    return;
                } else if (i11 == 10) {
                    setVisibility(8);
                    return;
                } else {
                    return;
                }
            }
        }
        this.f51250c.setVisibility(0);
        setVisibility(0);
        this.f51252e.setVisibility(0);
        this.f51251d.setVisibility(0);
        this.f51253f.setVisibility(8);
        this.f51254g.setVisibility(0);
    }
}
