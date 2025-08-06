package com.huobi.homemarket.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

public class MarketIntroTextView extends AppCompatTextView {

    /* renamed from: b  reason: collision with root package name */
    public a f73060b;

    public interface a {
        void a(boolean z11);
    }

    public MarketIntroTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public final void d() {
        Layout layout;
        int lineCount;
        if (this.f73060b != null && getMaxLines() != Integer.MAX_VALUE && (layout = getLayout()) != null && (lineCount = layout.getLineCount()) > 0) {
            if (lineCount > getMaxLines()) {
                this.f73060b.a(true);
            } else if (layout.getEllipsisCount(lineCount - 1) > 0) {
                this.f73060b.a(true);
            } else {
                this.f73060b.a(false);
            }
        }
    }

    public final void init(Context context) {
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        d();
    }

    public void setDisplayListener(a aVar) {
        this.f73060b = aVar;
    }

    public MarketIntroTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context);
    }
}
