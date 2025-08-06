package com.hbg.lib.widgets.ticker;

import android.graphics.Paint;
import com.hbg.lib.widgets.ticker.TickerView;
import java.util.HashMap;
import java.util.Map;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public final Paint f72401a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<Character, Float> f72402b = new HashMap(256);

    /* renamed from: c  reason: collision with root package name */
    public float f72403c;

    /* renamed from: d  reason: collision with root package name */
    public float f72404d;

    /* renamed from: e  reason: collision with root package name */
    public TickerView.ScrollingDirection f72405e = TickerView.ScrollingDirection.ANY;

    public c(Paint paint) {
        this.f72401a = paint;
        e();
    }

    public float a() {
        return this.f72404d;
    }

    public float b() {
        return this.f72403c;
    }

    public float c(char c11) {
        if (c11 == 0) {
            return 0.0f;
        }
        Float f11 = this.f72402b.get(Character.valueOf(c11));
        if (f11 != null) {
            return f11.floatValue();
        }
        float measureText = this.f72401a.measureText(Character.toString(c11));
        this.f72402b.put(Character.valueOf(c11), Float.valueOf(measureText));
        return measureText;
    }

    public TickerView.ScrollingDirection d() {
        return this.f72405e;
    }

    public void e() {
        this.f72402b.clear();
        Paint.FontMetrics fontMetrics = this.f72401a.getFontMetrics();
        float f11 = fontMetrics.bottom;
        float f12 = fontMetrics.top;
        this.f72403c = f11 - f12;
        this.f72404d = -f12;
    }

    public void f(TickerView.ScrollingDirection scrollingDirection) {
        this.f72405e = scrollingDirection;
    }
}
