package com.hbg.module.libkt.custom.indicator.navigator.titles;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.TextView;
import com.hbg.module.libkt.base.ext.c;
import pe.a;

public class PagerTitleView extends TextView implements a {

    /* renamed from: b  reason: collision with root package name */
    public int f24829b;

    /* renamed from: c  reason: collision with root package name */
    public int f24830c;

    /* renamed from: d  reason: collision with root package name */
    public int f24831d;

    /* renamed from: e  reason: collision with root package name */
    public int f24832e;

    /* renamed from: f  reason: collision with root package name */
    public float f24833f;

    /* renamed from: g  reason: collision with root package name */
    public float f24834g = -1.0f;

    /* renamed from: h  reason: collision with root package name */
    public Typeface f24835h;

    /* renamed from: i  reason: collision with root package name */
    public Typeface f24836i;

    public PagerTitleView(Context context) {
        super(context);
        setGravity(17);
        int a11 = c.a(10.0f);
        setPadding(a11, 0, a11, 0);
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
    }

    public int getContentBottom() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) (((float) (getHeight() / 2)) + ((fontMetrics.bottom - fontMetrics.top) / ((float) 2)));
    }

    public int getContentLeft() {
        String str;
        Rect rect = new Rect();
        if (StringsKt__StringsKt.R(getText().toString(), "\n", false, 2, (Object) null)) {
            str = "";
            for (String str2 : (String[]) StringsKt__StringsKt.L0(getText().toString(), new String[]{"\\n"}, false, 0, 6, (Object) null).toArray(new String[0])) {
                if (str2.length() > str.length()) {
                    str = str2;
                }
            }
        } else {
            str = getText().toString();
        }
        getPaint().getTextBounds(str, 0, str.length(), rect);
        return (getLeft() + (getWidth() / 2)) - (rect.width() / 2);
    }

    public int getContentRight() {
        String str;
        Rect rect = new Rect();
        if (StringsKt__StringsKt.R(getText().toString(), "\n", false, 2, (Object) null)) {
            str = "";
            for (String str2 : (String[]) StringsKt__StringsKt.L0(getText().toString(), new String[]{"\\n"}, false, 0, 6, (Object) null).toArray(new String[0])) {
                if (str2.length() > str.length()) {
                    str = str2;
                }
            }
        } else {
            str = getText().toString();
        }
        getPaint().getTextBounds(str, 0, str.length(), rect);
        return getLeft() + (getWidth() / 2) + (rect.width() / 2);
    }

    public int getContentTop() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) (((float) (getHeight() / 2)) - ((fontMetrics.bottom - fontMetrics.top) / ((float) 2)));
    }

    public final int getNormalBgColor() {
        return this.f24832e;
    }

    public final int getNormalColor() {
        return this.f24830c;
    }

    public final int getSelectedBgColor() {
        return this.f24831d;
    }

    public final int getSelectedColor() {
        return this.f24829b;
    }

    public void onDeselected(int i11, int i12) {
        setTextColor(this.f24830c);
        setBackgroundResource(this.f24832e);
        setTextSize(this.f24833f);
        Typeface typeface = this.f24835h;
        if (typeface != null) {
            setTypeface(typeface);
            setTypeface(typeface, 0);
        }
    }

    public void onEnter(int i11, int i12, float f11, boolean z11) {
    }

    public void onLeave(int i11, int i12, float f11, boolean z11) {
    }

    public void onSelected(int i11, int i12) {
        setTextColor(this.f24829b);
        setBackgroundResource(this.f24831d);
        float f11 = this.f24834g;
        if (f11 > 0.0f) {
            setTextSize(f11);
        }
        Typeface typeface = this.f24836i;
        if (typeface != null) {
            setTypeface(typeface, 1);
        }
    }

    public final void setNormalBgColor(int i11) {
        this.f24832e = i11;
    }

    public final void setNormalColor(int i11) {
        this.f24830c = i11;
    }

    public final void setNormalTextFont(Typeface typeface) {
        this.f24835h = typeface;
    }

    public final void setScaleTextFont(Typeface typeface) {
        this.f24836i = typeface;
    }

    public final void setSelectedBgColor(int i11) {
        this.f24831d = i11;
    }

    public final void setSelectedColor(int i11) {
        this.f24829b = i11;
    }

    public final void setSelectedTextSize(float f11) {
        this.f24834g = f11;
    }

    public void setTextSize(float f11) {
        super.setTextSize(f11);
        if (this.f24833f == 0.0f) {
            this.f24833f = f11;
        }
    }
}
