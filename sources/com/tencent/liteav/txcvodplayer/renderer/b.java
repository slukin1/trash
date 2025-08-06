package com.tencent.liteav.txcvodplayer.renderer;

import android.view.View;
import java.lang.ref.WeakReference;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public int f22007a;

    /* renamed from: b  reason: collision with root package name */
    public int f22008b;

    /* renamed from: c  reason: collision with root package name */
    public int f22009c;

    /* renamed from: d  reason: collision with root package name */
    public int f22010d = 0;

    /* renamed from: e  reason: collision with root package name */
    private WeakReference<View> f22011e;

    /* renamed from: f  reason: collision with root package name */
    private int f22012f;

    /* renamed from: g  reason: collision with root package name */
    private int f22013g;

    /* renamed from: h  reason: collision with root package name */
    private int f22014h;

    /* renamed from: i  reason: collision with root package name */
    private int f22015i;

    public b(View view) {
        this.f22011e = new WeakReference<>(view);
    }

    public final void a(int i11, int i12) {
        this.f22012f = i11;
        this.f22013g = i12;
    }

    public final void b(int i11, int i12) {
        this.f22014h = i11;
        this.f22015i = i12;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(int r10, int r11) {
        /*
            r9 = this;
            int r0 = r9.f22007a
            r1 = 270(0x10e, float:3.78E-43)
            r2 = 90
            if (r0 == r2) goto L_0x000a
            if (r0 != r1) goto L_0x000d
        L_0x000a:
            r8 = r11
            r11 = r10
            r10 = r8
        L_0x000d:
            int r0 = r9.f22012f
            int r0 = android.view.View.getDefaultSize(r0, r10)
            int r3 = r9.f22013g
            int r3 = android.view.View.getDefaultSize(r3, r11)
            int r4 = r9.f22010d
            r5 = 3
            if (r4 != r5) goto L_0x0020
            goto L_0x011f
        L_0x0020:
            int r4 = r9.f22012f
            if (r4 <= 0) goto L_0x011d
            int r4 = r9.f22013g
            if (r4 <= 0) goto L_0x011d
            int r0 = android.view.View.MeasureSpec.getMode(r10)
            int r10 = android.view.View.MeasureSpec.getSize(r10)
            int r3 = android.view.View.MeasureSpec.getMode(r11)
            int r11 = android.view.View.MeasureSpec.getSize(r11)
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r4) goto L_0x00c9
            if (r3 != r4) goto L_0x00c9
            float r0 = (float) r10
            float r3 = (float) r11
            float r0 = r0 / r3
            int r3 = r9.f22010d
            r4 = 5
            r5 = 4
            if (r3 == r5) goto L_0x0069
            if (r3 == r4) goto L_0x005d
            int r1 = r9.f22012f
            float r1 = (float) r1
            int r2 = r9.f22013g
            float r2 = (float) r2
            float r1 = r1 / r2
            int r2 = r9.f22014h
            if (r2 <= 0) goto L_0x0077
            int r6 = r9.f22015i
            if (r6 <= 0) goto L_0x0077
            float r2 = (float) r2
            float r1 = r1 * r2
            float r2 = (float) r6
            float r1 = r1 / r2
            goto L_0x0077
        L_0x005d:
            r6 = 1068149419(0x3faaaaab, float:1.3333334)
            int r7 = r9.f22007a
            if (r7 == r2) goto L_0x0066
            if (r7 != r1) goto L_0x0073
        L_0x0066:
            r1 = 1061158912(0x3f400000, float:0.75)
            goto L_0x0077
        L_0x0069:
            r6 = 1071877689(0x3fe38e39, float:1.7777778)
            int r7 = r9.f22007a
            if (r7 == r2) goto L_0x0075
            if (r7 != r1) goto L_0x0073
            goto L_0x0075
        L_0x0073:
            r1 = r6
            goto L_0x0077
        L_0x0075:
            r1 = 1058013184(0x3f100000, float:0.5625)
        L_0x0077:
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            r2 = 1
            if (r0 <= 0) goto L_0x007e
            r0 = r2
            goto L_0x007f
        L_0x007e:
            r0 = 0
        L_0x007f:
            if (r3 == 0) goto L_0x00b7
            if (r3 == r2) goto L_0x00a5
            if (r3 == r5) goto L_0x00b7
            if (r3 == r4) goto L_0x00b7
            if (r0 == 0) goto L_0x0097
            int r11 = r9.f22012f
            int r10 = java.lang.Math.min(r11, r10)
            r9.f22008b = r10
            float r10 = (float) r10
            float r10 = r10 / r1
            int r10 = (int) r10
            r9.f22009c = r10
            return
        L_0x0097:
            int r10 = r9.f22013g
            int r10 = java.lang.Math.min(r10, r11)
            r9.f22009c = r10
            float r10 = (float) r10
            float r10 = r10 * r1
            int r10 = (int) r10
            r9.f22008b = r10
            return
        L_0x00a5:
            if (r0 == 0) goto L_0x00af
            r9.f22009c = r11
            float r10 = (float) r11
            float r10 = r10 * r1
            int r10 = (int) r10
            r9.f22008b = r10
            return
        L_0x00af:
            r9.f22008b = r10
            float r10 = (float) r10
            float r10 = r10 / r1
            int r10 = (int) r10
            r9.f22009c = r10
            return
        L_0x00b7:
            if (r0 == 0) goto L_0x00c1
            r9.f22008b = r10
            float r10 = (float) r10
            float r10 = r10 / r1
            int r10 = (int) r10
            r9.f22009c = r10
            return
        L_0x00c1:
            r9.f22009c = r11
            float r10 = (float) r11
            float r10 = r10 * r1
            int r10 = (int) r10
            r9.f22008b = r10
            return
        L_0x00c9:
            r1 = 1073741824(0x40000000, float:2.0)
            if (r0 != r1) goto L_0x00e7
            if (r3 != r1) goto L_0x00e7
            int r0 = r9.f22012f
            int r1 = r0 * r11
            int r2 = r9.f22013g
            int r3 = r10 * r2
            if (r1 >= r3) goto L_0x00dd
            int r0 = r0 * r11
            int r10 = r0 / r2
            goto L_0x011f
        L_0x00dd:
            int r1 = r0 * r11
            int r3 = r10 * r2
            if (r1 <= r3) goto L_0x011f
            int r2 = r2 * r10
            int r11 = r2 / r0
            goto L_0x011f
        L_0x00e7:
            if (r0 != r1) goto L_0x00f6
            int r0 = r9.f22013g
            int r0 = r0 * r10
            int r1 = r9.f22012f
            int r0 = r0 / r1
            if (r3 != r4) goto L_0x00f4
            if (r0 <= r11) goto L_0x00f4
            goto L_0x011f
        L_0x00f4:
            r11 = r0
            goto L_0x011f
        L_0x00f6:
            if (r3 != r1) goto L_0x0105
            int r1 = r9.f22012f
            int r1 = r1 * r11
            int r2 = r9.f22013g
            int r1 = r1 / r2
            if (r0 != r4) goto L_0x0103
            if (r1 <= r10) goto L_0x0103
            goto L_0x011f
        L_0x0103:
            r10 = r1
            goto L_0x011f
        L_0x0105:
            int r1 = r9.f22012f
            int r2 = r9.f22013g
            if (r3 != r4) goto L_0x0111
            if (r2 <= r11) goto L_0x0111
            int r3 = r11 * r1
            int r3 = r3 / r2
            goto L_0x0113
        L_0x0111:
            r3 = r1
            r11 = r2
        L_0x0113:
            if (r0 != r4) goto L_0x011b
            if (r3 <= r10) goto L_0x011b
            int r2 = r2 * r10
            int r11 = r2 / r1
            goto L_0x011f
        L_0x011b:
            r10 = r3
            goto L_0x011f
        L_0x011d:
            r10 = r0
            r11 = r3
        L_0x011f:
            r9.f22008b = r10
            r9.f22009c = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.txcvodplayer.renderer.b.c(int, int):void");
    }
}
