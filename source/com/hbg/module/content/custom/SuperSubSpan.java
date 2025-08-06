package com.hbg.module.content.custom;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.hbg.module.content.R$color;
import com.hbg.module.libkt.base.ext.b;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.r;

public final class SuperSubSpan extends ReplacementSpan {

    /* renamed from: b  reason: collision with root package name */
    public final SubSpanType f18080b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f18081c;

    /* renamed from: d  reason: collision with root package name */
    public int f18082d;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f18083a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.hbg.module.content.custom.SubSpanType[] r0 = com.hbg.module.content.custom.SubSpanType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.hbg.module.content.custom.SubSpanType r1 = com.hbg.module.content.custom.SubSpanType.CENTER     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.hbg.module.content.custom.SubSpanType r1 = com.hbg.module.content.custom.SubSpanType.TOP     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.hbg.module.content.custom.SubSpanType r1 = com.hbg.module.content.custom.SubSpanType.DEFAULT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f18083a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.content.custom.SuperSubSpan.a.<clinit>():void");
        }
    }

    public SuperSubSpan() {
        this((SubSpanType) null, 1, (r) null);
    }

    public SuperSubSpan(SubSpanType subSpanType) {
        this.f18080b = subSpanType;
        this.f18081c = new Paint();
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i11, int i12, float f11, int i13, int i14, int i15, Paint paint) {
        CharSequence subSequence = charSequence.subSequence(i11, i12);
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i16 = a.f18083a[this.f18080b.ordinal()];
        if (i16 == 1) {
            int i17 = fontMetricsInt.descent;
            int i18 = fontMetricsInt.ascent;
            i14 = ((i14 - (i17 - i18)) / 2) + (i17 - i18);
        } else if (i16 == 2) {
            i14 = fontMetricsInt.descent - fontMetricsInt.ascent;
        } else if (i16 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        this.f18081c.setAntiAlias(true);
        this.f18081c.setColor(b.h(R$color.baseColorMajorTheme006));
        this.f18081c.setStyle(Paint.Style.FILL);
        canvas.drawRoundRect(new RectF(f11, 0.0f, ((float) this.f18082d) + f11, ((((float) fontMetricsInt.descent) - ((float) fontMetricsInt.top)) * ((float) 3)) / ((float) 2)), 3.0f, 3.0f, this.f18081c);
        paint.setColor(b.h(R$color.baseColorMajorTheme100));
        canvas.drawText(subSequence.toString(), f11, (float) i14, paint);
    }

    public int getSize(Paint paint, CharSequence charSequence, int i11, int i12, Paint.FontMetricsInt fontMetricsInt) {
        int measureText = (int) paint.measureText(charSequence.subSequence(i11, i12).toString());
        this.f18082d = measureText;
        return measureText;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SuperSubSpan(SubSpanType subSpanType, int i11, r rVar) {
        this((i11 & 1) != 0 ? SubSpanType.DEFAULT : subSpanType);
    }
}
