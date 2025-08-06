package com.hbg.module.libkt.common;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.hbg.module.libkt.R$color;
import com.hbg.module.libkt.R$drawable;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.libkt.base.ext.c;
import kotlin.jvm.internal.r;

public final class LiveRecommendPkProgressView extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public int f24590b;

    /* renamed from: c  reason: collision with root package name */
    public int f24591c;

    /* renamed from: d  reason: collision with root package name */
    public float f24592d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f24593e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f24594f;

    /* renamed from: g  reason: collision with root package name */
    public int f24595g;

    /* renamed from: h  reason: collision with root package name */
    public int f24596h;

    /* renamed from: i  reason: collision with root package name */
    public int f24597i;

    /* renamed from: j  reason: collision with root package name */
    public int f24598j;

    public LiveRecommendPkProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LiveRecommendPkProgressView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public final void a() {
        this.f24594f = b.p(getContext(), R$drawable.icon_live_pk_middle_light);
        this.f24595g = ContextCompat.getColor(getContext(), R$color.pk_green);
        this.f24596h = ContextCompat.getColor(getContext(), R$color.color_rise_fall_red);
        this.f24598j = c.d(Float.valueOf(11.0f));
        this.f24597i = c.d(Float.valueOf(14.0f));
    }

    public final void b() {
        int i11 = this.f24591c;
        if (i11 == 0 && this.f24590b == 0) {
            this.f24592d = 0.5f;
        } else {
            this.f24592d = ((float) i11) / ((float) (this.f24590b + i11));
        }
        invalidate();
    }

    public final int getAgreeColor() {
        return this.f24595g;
    }

    public final int getAgreeCount() {
        return this.f24591c;
    }

    public final int getDisAgreeColor() {
        return this.f24596h;
    }

    public final int getDisAgreeCount() {
        return this.f24590b;
    }

    public final Drawable getMIcon() {
        return this.f24594f;
    }

    public final int getMIconHeight() {
        return this.f24597i;
    }

    public final int getMIconWidth() {
        return this.f24598j;
    }

    public final Paint getMPaint() {
        return this.f24593e;
    }

    public final float getProgress() {
        return this.f24592d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r12) {
        /*
            r11 = this;
            super.onDraw(r12)
            android.graphics.Paint r0 = r11.f24593e
            r0.reset()
            android.graphics.Paint r0 = r11.f24593e
            android.graphics.Paint$Cap r1 = android.graphics.Paint.Cap.ROUND
            r0.setStrokeCap(r1)
            android.graphics.Paint r0 = r11.f24593e
            r1 = 1
            r0.setAntiAlias(r1)
            android.graphics.Paint r0 = r11.f24593e
            int r2 = r11.getHeight()
            float r2 = (float) r2
            r0.setStrokeWidth(r2)
            android.graphics.Paint r0 = r11.f24593e
            int r2 = r11.f24596h
            r0.setColor(r2)
            int r0 = r11.getHeight()
            float r0 = (float) r0
            r2 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r2
            int r3 = r11.getWidth()
            float r6 = (float) r3
            android.graphics.Paint r8 = r11.f24593e
            r4 = 0
            r3 = r12
            r5 = r0
            r7 = r0
            r3.drawLine(r4, r5, r6, r7, r8)
            int r3 = r11.f24598j
            float r3 = (float) r3
            float r2 = r3 / r2
            int r3 = r11.getWidth()
            int r4 = r11.f24598j
            int r3 = r3 - r4
            float r3 = (float) r3
            float r4 = r11.f24592d
            float r9 = r3 * r4
            android.graphics.Paint r3 = r11.f24593e
            r3.reset()
            android.graphics.Paint r3 = r11.f24593e
            android.graphics.Paint$Cap r4 = android.graphics.Paint.Cap.ROUND
            r3.setStrokeCap(r4)
            android.graphics.Paint r3 = r11.f24593e
            r3.setAntiAlias(r1)
            android.graphics.Paint r3 = r11.f24593e
            int r4 = r11.getHeight()
            float r4 = (float) r4
            r3.setStrokeWidth(r4)
            android.graphics.Paint r3 = r11.f24593e
            int r4 = r11.f24595g
            r3.setColor(r4)
            float r3 = r11.f24592d
            r4 = 0
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            r10 = 0
            if (r4 != 0) goto L_0x0079
            r4 = r1
            goto L_0x007a
        L_0x0079:
            r4 = r10
        L_0x007a:
            if (r4 != 0) goto L_0x0096
            r4 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x0083
            goto L_0x0084
        L_0x0083:
            r1 = r10
        L_0x0084:
            if (r1 == 0) goto L_0x0087
            goto L_0x0096
        L_0x0087:
            float r1 = r9 + r2
            r3 = 1077936128(0x40400000, float:3.0)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            int r3 = com.hbg.module.libkt.base.ext.c.d(r3)
            float r3 = (float) r3
            float r1 = r1 - r3
            goto L_0x0098
        L_0x0096:
            float r1 = r9 + r2
        L_0x0098:
            r6 = r1
            r4 = 0
            android.graphics.Paint r8 = r11.f24593e
            r3 = r12
            r5 = r0
            r7 = r0
            r3.drawLine(r4, r5, r6, r7, r8)
            float r9 = r9 - r2
            int r0 = r11.f24598j
            float r0 = (float) r0
            float r0 = r0 + r9
            int r1 = r11.getWidth()
            float r1 = (float) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x00ba
            int r0 = r11.getWidth()
            float r0 = (float) r0
            int r1 = r11.f24598j
            float r1 = (float) r1
            float r9 = r0 - r1
        L_0x00ba:
            float r9 = r9 + r2
            android.graphics.drawable.Drawable r0 = r11.f24594f
            if (r0 == 0) goto L_0x00c8
            int r1 = (int) r9
            int r2 = r11.f24598j
            int r2 = r2 + r1
            int r3 = r11.f24597i
            r0.setBounds(r1, r10, r2, r3)
        L_0x00c8:
            android.graphics.drawable.Drawable r0 = r11.f24594f
            if (r0 == 0) goto L_0x00cf
            r0.draw(r12)
        L_0x00cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.libkt.common.LiveRecommendPkProgressView.onDraw(android.graphics.Canvas):void");
    }

    public final void setAgreeColor(int i11) {
        this.f24595g = i11;
    }

    public final void setAgreeCount(int i11) {
        this.f24591c = i11;
    }

    public final void setDisAgreeColor(int i11) {
        this.f24596h = i11;
    }

    public final void setDisAgreeCount(int i11) {
        this.f24590b = i11;
    }

    public final void setMIcon(Drawable drawable) {
        this.f24594f = drawable;
    }

    public final void setMIconHeight(int i11) {
        this.f24597i = i11;
    }

    public final void setMIconWidth(int i11) {
        this.f24598j = i11;
    }

    public final void setProgress(float f11) {
        this.f24592d = f11;
    }

    public LiveRecommendPkProgressView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f24593e = new Paint();
        a();
    }
}
