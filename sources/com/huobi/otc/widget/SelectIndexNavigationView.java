package com.huobi.otc.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$dimen;
import com.hbg.module.otc.R$drawable;
import com.huobi.login.usercenter.data.source.bean.KvStore;
import com.huobi.view.roundimg.RoundedDrawable;
import jp.v1;

public class SelectIndexNavigationView extends View {

    /* renamed from: b  reason: collision with root package name */
    public Paint f80143b = new Paint();

    /* renamed from: c  reason: collision with root package name */
    public int f80144c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f80145d = RoundedDrawable.DEFAULT_BORDER_COLOR;

    /* renamed from: e  reason: collision with root package name */
    public int f80146e = -65281;

    /* renamed from: f  reason: collision with root package name */
    public int f80147f = -16776961;

    /* renamed from: g  reason: collision with root package name */
    public boolean f80148g;

    /* renamed from: h  reason: collision with root package name */
    public int f80149h;

    /* renamed from: i  reason: collision with root package name */
    public a f80150i;

    /* renamed from: j  reason: collision with root package name */
    public String[] f80151j = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", KvStore.N, "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", KvStore.Y, "Z"};

    /* renamed from: k  reason: collision with root package name */
    public STYLE f80152k = STYLE.CIRCLE;

    /* renamed from: l  reason: collision with root package name */
    public Bitmap f80153l;

    public enum STYLE {
        DEFAULT,
        NONE,
        CIRCLE,
        STRETCH
    }

    public interface a {
        void J3(boolean z11, String str, float f11);
    }

    public SelectIndexNavigationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        this.f80149h = PixelUtils.a(10.0f);
        this.f80145d = ContextCompat.getColor(context, R$color.baseColorPrimaryText);
        this.f80146e = ContextCompat.getColor(context, R$color.baseColorMajorTheme100);
        this.f80153l = BitmapFactory.decodeResource(context.getResources(), R$drawable.otc_select_currency_popue_old);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003a, code lost:
        if (r2 != 3) goto L_0x0094;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            float r0 = r8.getY()
            int r1 = r7.getHeight()
            float r1 = (float) r1
            float r0 = r0 / r1
            java.lang.String[] r1 = r7.f80151j
            int r1 = r1.length
            float r1 = (float) r1
            float r0 = r0 * r1
            int r0 = (int) r0
            int r1 = r7.f80144c
            float r2 = r8.getX()
            android.graphics.Bitmap r3 = r7.f80153l
            r4 = -1
            r5 = 0
            if (r3 == 0) goto L_0x002d
            int r3 = r3.getWidth()
            float r3 = (float) r3
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x002d
            r7.f80148g = r5
            r7.f80144c = r4
            r7.invalidate()
            return r5
        L_0x002d:
            int r2 = r8.getAction()
            r3 = 1
            if (r2 == 0) goto L_0x0077
            if (r2 == r3) goto L_0x005b
            r6 = 2
            if (r2 == r6) goto L_0x003d
            r1 = 3
            if (r2 == r1) goto L_0x005b
            goto L_0x0094
        L_0x003d:
            r7.f80148g = r3
            if (r0 == r1) goto L_0x0094
            if (r0 < 0) goto L_0x0094
            java.lang.String[] r1 = r7.f80151j
            int r2 = r1.length
            if (r0 >= r2) goto L_0x0094
            r7.f80144c = r0
            com.huobi.otc.widget.SelectIndexNavigationView$a r2 = r7.f80150i
            if (r2 == 0) goto L_0x0057
            r0 = r1[r0]
            float r8 = r8.getY()
            r2.J3(r3, r0, r8)
        L_0x0057:
            r7.invalidate()
            goto L_0x0094
        L_0x005b:
            r7.f80148g = r5
            if (r0 < 0) goto L_0x0071
            java.lang.String[] r1 = r7.f80151j
            int r2 = r1.length
            if (r0 >= r2) goto L_0x0071
            com.huobi.otc.widget.SelectIndexNavigationView$a r2 = r7.f80150i
            if (r2 == 0) goto L_0x0071
            r0 = r1[r0]
            float r8 = r8.getY()
            r2.J3(r5, r0, r8)
        L_0x0071:
            r7.f80144c = r4
            r7.invalidate()
            goto L_0x0094
        L_0x0077:
            r7.f80148g = r3
            if (r0 == r1) goto L_0x0094
            if (r0 < 0) goto L_0x0094
            java.lang.String[] r1 = r7.f80151j
            int r2 = r1.length
            if (r0 >= r2) goto L_0x0094
            r7.f80144c = r0
            com.huobi.otc.widget.SelectIndexNavigationView$a r2 = r7.f80150i
            if (r2 == 0) goto L_0x0091
            r0 = r1[r0]
            float r8 = r8.getY()
            r2.J3(r3, r0, r8)
        L_0x0091:
            r7.invalidate()
        L_0x0094:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.otc.widget.SelectIndexNavigationView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        int height = this.f80153l.getHeight();
        int width = getWidth();
        int height2 = getHeight() - height;
        int length = this.f80151j.length;
        int i11 = height2 / length;
        if (!(!this.f80148g || this.f80147f == 0 || this.f80152k == STYLE.NONE)) {
            this.f80143b.setAntiAlias(true);
            this.f80143b.setColor(this.f80147f);
            STYLE style = this.f80152k;
            if (style == STYLE.CIRCLE) {
                float max = ((float) Math.max(width, i11)) - ((float) Math.min(width, i11));
                int i12 = this.f80144c;
                float f11 = ((float) height) / 2.0f;
                canvas.drawArc(new RectF(max, ((float) (i11 * i12)) + f11, ((float) i11) + max, ((float) ((i12 * i11) + i11)) + f11), 0.0f, 360.0f, true, this.f80143b);
                canvas2.drawBitmap(this.f80153l, 0.0f, ((float) ((this.f80144c - 1) * i11)) + f11, new Paint());
            } else if (style == STYLE.STRETCH) {
                canvas.drawArc(new RectF(0.0f, 0.0f, (float) width, (float) (this.f80144c * i11)), 0.0f, 360.0f, true, this.f80143b);
            } else {
                float f12 = (float) width;
                float f13 = (float) i11;
                float f14 = f12;
                canvas.drawArc(new RectF(0.0f, 0.0f, f12, f13), 180.0f, 180.0f, true, this.f80143b);
                float f15 = f13 / 2.0f;
                float f16 = (float) height2;
                canvas2.drawRect(new RectF(0.0f, f15, f14, f16 - f15), this.f80143b);
                canvas.drawArc(new RectF(0.0f, (float) (height2 - i11), f14, f16), 0.0f, 180.0f, true, this.f80143b);
            }
        }
        int i13 = 0;
        while (i13 < length) {
            this.f80143b.setTypeface(Typeface.DEFAULT);
            this.f80143b.setTextAlign(Paint.Align.CENTER);
            this.f80143b.setAntiAlias(true);
            this.f80143b.setTextSize((float) this.f80149h);
            if (i13 == this.f80144c) {
                this.f80143b.setColor(this.f80146e);
            } else {
                this.f80143b.setColor(this.f80145d);
            }
            int i14 = i13 + 1;
            canvas2.drawText(this.f80151j[i13], ((float) width) - (((float) i11) / 2.0f), (((float) (i11 * i14)) - (this.f80143b.measureText(this.f80151j[i13]) / 2.0f)) + (((float) height) / 2.0f), this.f80143b);
            if (this.f80148g && i13 == this.f80144c) {
                this.f80143b.setTextSize((float) getResources().getDimensionPixelSize(R$dimen.global_text_size_28));
                this.f80143b.setColor(v1.b());
                canvas2.drawText(this.f80151j[i13], ((float) this.f80153l.getHeight()) / 2.0f, ((float) (((this.f80144c - 1) * i11) + height)) + (this.f80143b.measureText(this.f80151j[i13]) / 2.0f), this.f80143b);
            }
            this.f80143b.reset();
            i13 = i14;
        }
    }

    public void setChooseBacegroundColor(int i11) {
        this.f80147f = i11;
    }

    public void setChooseColor(int i11) {
        this.f80146e = i11;
    }

    public void setChooseStyle(STYLE style) {
        this.f80152k = style;
    }

    public void setDefaultColor(int i11) {
        this.f80145d = i11;
    }

    public void setOnTouchLetterChangeListenner(a aVar) {
        this.f80150i = aVar;
    }

    public void setTextSize(int i11) {
        this.f80149h = i11;
    }

    public SelectIndexNavigationView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context, attributeSet);
    }
}
