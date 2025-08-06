package com.iproov.sdk.core;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import com.iproov.sdk.utils.Cfor;

/* renamed from: com.iproov.sdk.core.super  reason: invalid class name */
class Csuper {

    /* renamed from: try  reason: not valid java name */
    private static final Cif[] f336try = {Cif.MIDDLE_RIGHT, Cif.BOTTOM_RIGHT, Cif.BOTTOM_MIDDLE, Cif.BOTTOM_LEFT, Cif.MIDDLE_LEFT, Cif.TOP_LEFT, Cif.TOP_MIDDLE, Cif.TOP_RIGHT};

    /* renamed from: do  reason: not valid java name */
    private final float f337do;

    /* renamed from: for  reason: not valid java name */
    private final Rect f338for;

    /* renamed from: if  reason: not valid java name */
    private final Cif f339if;

    /* renamed from: new  reason: not valid java name */
    private final Celse f340new;

    /* renamed from: com.iproov.sdk.core.super$do  reason: invalid class name */
    public static /* synthetic */ class Cdo {

        /* renamed from: do  reason: not valid java name */
        public static final /* synthetic */ int[] f341do;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.iproov.sdk.core.super$if[] r0 = com.iproov.sdk.core.Csuper.Cif.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f341do = r0
                com.iproov.sdk.core.super$if r1 = com.iproov.sdk.core.Csuper.Cif.TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f341do     // Catch:{ NoSuchFieldError -> 0x001d }
                com.iproov.sdk.core.super$if r1 = com.iproov.sdk.core.Csuper.Cif.TOP_MIDDLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f341do     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.iproov.sdk.core.super$if r1 = com.iproov.sdk.core.Csuper.Cif.TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f341do     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.iproov.sdk.core.super$if r1 = com.iproov.sdk.core.Csuper.Cif.MIDDLE_LEFT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f341do     // Catch:{ NoSuchFieldError -> 0x003e }
                com.iproov.sdk.core.super$if r1 = com.iproov.sdk.core.Csuper.Cif.MIDDLE_RIGHT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f341do     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.iproov.sdk.core.super$if r1 = com.iproov.sdk.core.Csuper.Cif.BOTTOM_LEFT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f341do     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.iproov.sdk.core.super$if r1 = com.iproov.sdk.core.Csuper.Cif.BOTTOM_MIDDLE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f341do     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.iproov.sdk.core.super$if r1 = com.iproov.sdk.core.Csuper.Cif.BOTTOM_RIGHT     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.core.Csuper.Cdo.<clinit>():void");
        }
    }

    /* renamed from: com.iproov.sdk.core.super$if  reason: invalid class name */
    public enum Cif {
        TOP_RIGHT,
        TOP_MIDDLE,
        TOP_LEFT,
        MIDDLE_LEFT,
        MIDDLE_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_MIDDLE,
        BOTTOM_RIGHT
    }

    public Csuper(Rect rect, Rect rect2, Celse elseR, RectF rectF) {
        this.f340new = elseR;
        this.f338for = rect2;
        this.f337do = ((double) rectF.width()) <= elseR.m379this() ? (float) Math.max(((double) rectF.width()) + elseR.m374for(), elseR.m370const()) : (float) Math.min(((double) rectF.width()) - elseR.m374for(), elseR.m368catch());
        this.f339if = f336try[(int) (((Cfor.m2232do(Cfor.m2241for(rect), Cfor.m2241for(rect2)) + 0.39269908169872414d) % 6.283185307179586d) / 0.7853981633974483d)];
    }

    /* renamed from: do  reason: not valid java name */
    public Rect m442do(Rect rect) {
        Point point;
        float width = (((float) this.f338for.width()) * this.f337do) / ((float) this.f340new.m371do());
        int i11 = (int) width;
        int i12 = (int) (width / 0.75f);
        float f11 = (float) i11;
        Size size = new Size(i11, (int) (f11 / (((float) this.f338for.width()) / ((float) this.f338for.height()))));
        switch (Cdo.f341do[this.f339if.ordinal()]) {
            case 1:
                point = new Point(0, 0);
                break;
            case 2:
                point = new Point((this.f338for.width() / 2) - (size.getWidth() / 2), 0);
                break;
            case 3:
                point = new Point(this.f338for.width() - size.getWidth(), 0);
                break;
            case 4:
                point = new Point(0, (this.f338for.height() / 2) - (size.getHeight() / 2));
                break;
            case 5:
                point = new Point(this.f338for.width() - size.getWidth(), (this.f338for.height() / 2) - (size.getHeight() / 2));
                break;
            case 6:
                point = new Point(0, this.f338for.height() - size.getHeight());
                break;
            case 7:
                point = new Point((this.f338for.width() / 2) - (size.getWidth() / 2), this.f338for.height() - size.getHeight());
                break;
            case 8:
                point = new Point(this.f338for.width() - size.getWidth(), this.f338for.height() - size.getHeight());
                break;
            default:
                point = null;
                break;
        }
        float width2 = ((float) rect.width()) / ((float) rect.height());
        if (0.75f > width2) {
            Size size2 = new Size(i11, (int) (f11 / width2));
            int height = point.y - ((int) ((((float) size2.getHeight()) / 2.0f) - (((float) size.getHeight()) / 2.0f)));
            int i13 = point.x;
            return new Rect(i13, height, size.getWidth() + i13, size2.getHeight() + height);
        }
        Size size3 = new Size((int) (((float) i12) * width2), i12);
        int width3 = point.x - ((int) ((((float) size3.getWidth()) / 2.0f) - (((float) size.getWidth()) / 2.0f)));
        int i14 = point.y;
        return new Rect(width3, i14, size3.getWidth() + width3, size.getHeight() + i14);
    }
}
