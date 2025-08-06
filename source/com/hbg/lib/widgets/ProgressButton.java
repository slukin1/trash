package com.hbg.lib.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import com.hbg.lib.common.utils.PixelUtils;

public class ProgressButton extends Button implements Animatable {

    /* renamed from: b  reason: collision with root package name */
    public l1 f71595b;

    /* renamed from: c  reason: collision with root package name */
    public String f71596c;

    /* renamed from: d  reason: collision with root package name */
    public a f71597d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f71598e = false;

    public interface a {
        void onFinish();
    }

    public ProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public void a() {
        this.f71598e = false;
        setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        setText(String.valueOf(this.f71596c));
        this.f71595b.d();
    }

    public final void b() {
        l1 l1Var = new l1(getTextSize(), this);
        this.f71595b = l1Var;
        l1Var.g(getCurrentTextColor());
        this.f71595b.f(this);
        this.f71596c = getText().toString();
    }

    public void c() {
        this.f71598e = true;
        setText("");
        setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.f71595b, (Drawable) null, (Drawable) null);
        this.f71595b.i();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f71598e) {
            setPadding(0, PixelUtils.a(13.0f), 0, 0);
        } else {
            setPadding(0, PixelUtils.a(0.0f), 0, 0);
        }
    }

    public boolean isRunning() {
        return false;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f71595b.j();
    }

    public void setOnAnimFinishListener(a aVar) {
        this.f71597d = aVar;
    }

    public void setRealText(int i11) {
        setRealText(getResources().getString(i11));
    }

    public void start() {
        c();
    }

    public void stop() {
        a aVar = this.f71597d;
        if (aVar != null) {
            aVar.onFinish();
        }
    }

    public void setRealText(String str) {
        setText(str);
        this.f71596c = str;
    }

    public ProgressButton(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b();
    }
}
