package com.huobi.tradingbot.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.huobi.login.usercenter.data.source.bean.KvStore;
import com.huobi.view.roundimg.RoundedDrawable;
import i6.d;
import pro.huobi.R;

public class TradingBotIndexView extends View {

    /* renamed from: b  reason: collision with root package name */
    public Paint f83641b = new Paint();

    /* renamed from: c  reason: collision with root package name */
    public int f83642c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f83643d = RoundedDrawable.DEFAULT_BORDER_COLOR;

    /* renamed from: e  reason: collision with root package name */
    public int f83644e;

    /* renamed from: f  reason: collision with root package name */
    public int f83645f = PixelUtils.a(16.0f);

    /* renamed from: g  reason: collision with root package name */
    public boolean f83646g;

    /* renamed from: h  reason: collision with root package name */
    public int f83647h;

    /* renamed from: i  reason: collision with root package name */
    public a f83648i;

    /* renamed from: j  reason: collision with root package name */
    public String[] f83649j = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", KvStore.N, "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", KvStore.Y, "Z"};

    public interface a {
        void J3(boolean z11, String str, float f11);
    }

    public TradingBotIndexView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        this.f83647h = PixelUtils.a(10.0f);
        this.f83643d = ContextCompat.getColor(context, R.color.baseColorSecondaryTextNew);
        this.f83644e = ContextCompat.getColor(context, R.color.baseColorPrimaryText);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003d, code lost:
        if (r3 != 3) goto L_0x0077;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r6.getHeight()
            int r1 = r6.f83645f
            java.lang.String[] r2 = r6.f83649j
            int r2 = r2.length
            int r1 = r1 * r2
            int r0 = r0 - r1
            r1 = 2
            int r0 = r0 / r1
            float r2 = r7.getY()
            float r3 = (float) r0
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            r4 = 0
            if (r2 < 0) goto L_0x0078
            float r2 = r7.getY()
            int r5 = r6.getHeight()
            int r5 = r5 - r0
            float r0 = (float) r5
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0026
            goto L_0x0078
        L_0x0026:
            float r0 = r7.getY()
            float r0 = r0 - r3
            int r0 = (int) r0
            int r2 = r6.f83645f
            int r0 = r0 / r2
            int r2 = r6.f83642c
            int r3 = r7.getAction()
            r5 = 1
            if (r3 == 0) goto L_0x005a
            if (r3 == r5) goto L_0x0040
            if (r3 == r1) goto L_0x005a
            r1 = 3
            if (r3 == r1) goto L_0x0040
            goto L_0x0077
        L_0x0040:
            r6.f83646g = r4
            if (r0 < 0) goto L_0x0056
            java.lang.String[] r1 = r6.f83649j
            int r2 = r1.length
            if (r0 >= r2) goto L_0x0056
            com.huobi.tradingbot.widget.TradingBotIndexView$a r2 = r6.f83648i
            if (r2 == 0) goto L_0x0056
            r0 = r1[r0]
            float r7 = r7.getY()
            r2.J3(r4, r0, r7)
        L_0x0056:
            r6.invalidate()
            goto L_0x0077
        L_0x005a:
            r6.f83646g = r5
            if (r0 == r2) goto L_0x0077
            if (r0 < 0) goto L_0x0077
            java.lang.String[] r1 = r6.f83649j
            int r2 = r1.length
            if (r0 >= r2) goto L_0x0077
            r6.f83642c = r0
            com.huobi.tradingbot.widget.TradingBotIndexView$a r2 = r6.f83648i
            if (r2 == 0) goto L_0x0074
            r0 = r1[r0]
            float r7 = r7.getY()
            r2.J3(r5, r0, r7)
        L_0x0074:
            r6.invalidate()
        L_0x0077:
            return r5
        L_0x0078:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.tradingbot.widget.TradingBotIndexView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = (getHeight() - (this.f83645f * this.f83649j.length)) / 2;
        for (int i11 = 0; i11 < this.f83649j.length; i11++) {
            this.f83641b.setTypeface(Typeface.DEFAULT);
            this.f83641b.setTextAlign(Paint.Align.CENTER);
            this.f83641b.setAntiAlias(true);
            this.f83641b.setTextSize((float) this.f83647h);
            if (i11 == this.f83642c) {
                this.f83641b.setColor(this.f83644e);
            } else {
                this.f83641b.setColor(this.f83643d);
            }
            if (i11 == this.f83642c) {
                this.f83641b.setFakeBoldText(true);
            } else {
                this.f83641b.setFakeBoldText(false);
            }
            int i12 = this.f83645f;
            canvas.drawText(this.f83649j[i11], ((float) width) / 2.0f, (float) ((i12 * i11) + height + (i12 / 2)), this.f83641b);
            this.f83641b.reset();
        }
    }

    public void onMeasure(int i11, int i12) {
        int length = this.f83645f * this.f83649j.length;
        int size = View.MeasureSpec.getSize(i12);
        d.d("TradingBotNavigationView onMeasure heightSpecSize:" + size + " minHeight:" + length);
        if (size < length) {
            i12 = View.MeasureSpec.makeMeasureSpec(length, 1073741824);
        }
        super.onMeasure(i11, i12);
    }

    public void setChooseColor(int i11) {
        this.f83644e = i11;
    }

    public void setDefaultColor(int i11) {
        this.f83643d = i11;
    }

    public void setHighlight(String str) {
        int i11 = 0;
        while (true) {
            String[] strArr = this.f83649j;
            if (i11 >= strArr.length) {
                return;
            }
            if (strArr[i11].equals(str)) {
                this.f83642c = i11;
                invalidate();
                return;
            }
            i11++;
        }
    }

    public void setOnTouchLetterChangeListenner(a aVar) {
        this.f83648i = aVar;
    }

    public void setSingleHeight(int i11) {
        this.f83645f = i11;
        requestLayout();
    }

    public void setTextSize(int i11) {
        this.f83647h = i11;
    }

    public TradingBotIndexView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context, attributeSet);
    }
}
