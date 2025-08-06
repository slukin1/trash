package com.huobi.view.chart.data;

import android.graphics.drawable.Drawable;

public abstract class BaseEntry {
    private Object mData;
    private Drawable mIcon;

    /* renamed from: y  reason: collision with root package name */
    private float f19008y;

    public BaseEntry() {
        this.f19008y = 0.0f;
        this.mData = null;
        this.mIcon = null;
    }

    public Object getData() {
        return this.mData;
    }

    public Drawable getIcon() {
        return this.mIcon;
    }

    public float getY() {
        return this.f19008y;
    }

    public void setData(Object obj) {
        this.mData = obj;
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
    }

    public void setY(float f11) {
        this.f19008y = f11;
    }

    public BaseEntry(float f11) {
        this.f19008y = 0.0f;
        this.mData = null;
        this.mIcon = null;
        this.f19008y = f11;
    }

    public BaseEntry(float f11, Object obj) {
        this(f11);
        this.mData = obj;
    }

    public BaseEntry(float f11, Drawable drawable) {
        this(f11);
        this.mIcon = drawable;
    }

    public BaseEntry(float f11, Drawable drawable, Object obj) {
        this(f11);
        this.mIcon = drawable;
        this.mData = obj;
    }
}
