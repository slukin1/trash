package ke;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.hbg.module.libkt.R$color;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.libkt.custom.SubSpanType;
import kotlin.NoWhenBranchMatchedException;

public final class f extends ReplacementSpan {

    /* renamed from: b  reason: collision with root package name */
    public final Context f25285b;

    /* renamed from: c  reason: collision with root package name */
    public final SubSpanType f25286c;

    /* renamed from: d  reason: collision with root package name */
    public final Paint f25287d = new Paint();

    /* renamed from: e  reason: collision with root package name */
    public int f25288e;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25289a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.hbg.module.libkt.custom.SubSpanType[] r0 = com.hbg.module.libkt.custom.SubSpanType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.hbg.module.libkt.custom.SubSpanType r1 = com.hbg.module.libkt.custom.SubSpanType.CENTER     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.hbg.module.libkt.custom.SubSpanType r1 = com.hbg.module.libkt.custom.SubSpanType.TOP     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.hbg.module.libkt.custom.SubSpanType r1 = com.hbg.module.libkt.custom.SubSpanType.DEFAULT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f25289a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ke.f.a.<clinit>():void");
        }
    }

    public f(Context context, SubSpanType subSpanType) {
        this.f25285b = context;
        this.f25286c = subSpanType;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i11, int i12, float f11, int i13, int i14, int i15, Paint paint) {
        int i16;
        int i17;
        Resources resources;
        Resources resources2;
        CharSequence subSequence = charSequence.subSequence(i11, i12);
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i18 = a.f25289a[this.f25286c.ordinal()];
        if (i18 == 1) {
            int i19 = fontMetricsInt.descent;
            int i21 = fontMetricsInt.ascent;
            i14 = ((i14 - (i19 - i21)) / 2) + (i19 - i21);
        } else if (i18 == 2) {
            i14 = fontMetricsInt.descent - fontMetricsInt.ascent;
        } else if (i18 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        this.f25287d.setAntiAlias(true);
        Paint paint2 = this.f25287d;
        Context context = this.f25285b;
        if (context == null || (resources2 = context.getResources()) == null) {
            i16 = b.h(R$color.KBaseColorDeepestBackground);
        } else {
            i16 = resources2.getColor(R$color.KBaseColorDeepestBackground);
        }
        paint2.setColor(i16);
        this.f25287d.setStyle(Paint.Style.FILL);
        canvas.drawRoundRect(new RectF(f11, 0.0f, ((float) this.f25288e) + f11, ((((float) fontMetricsInt.descent) - ((float) fontMetricsInt.top)) * ((float) 3)) / ((float) 2)), 3.0f, 3.0f, this.f25287d);
        Context context2 = this.f25285b;
        if (context2 == null || (resources = context2.getResources()) == null) {
            i17 = b.h(R$color.baseColorContentText);
        } else {
            i17 = resources.getColor(R$color.baseColorContentText);
        }
        paint.setColor(i17);
        canvas.drawText(subSequence.toString(), f11, (float) i14, paint);
    }

    public int getSize(Paint paint, CharSequence charSequence, int i11, int i12, Paint.FontMetricsInt fontMetricsInt) {
        int measureText = (int) paint.measureText(charSequence.subSequence(i11, i12).toString());
        this.f25288e = measureText;
        return measureText;
    }
}
