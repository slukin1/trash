package androidx.test.espresso.action;

import androidx.test.espresso.UiController;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.lang.reflect.Array;

public enum Swipe {
    FAST {
        public Swiper$Status sendSwipe(UiController uiController, float[] fArr, float[] fArr2, float[] fArr3) {
            return Swipe.sendLinearSwipe(uiController, fArr, fArr2, fArr3, 150);
        }
    },
    SLOW {
        public Swiper$Status sendSwipe(UiController uiController, float[] fArr, float[] fArr2, float[] fArr3) {
            return Swipe.sendLinearSwipe(uiController, fArr, fArr2, fArr3, 1500);
        }
    };
    
    private static final int SWIPE_EVENT_COUNT = 10;
    private static final int SWIPE_FAST_DURATION_MS = 150;
    private static final int SWIPE_SLOW_DURATION_MS = 1500;
    private static final String TAG = null;

    /* access modifiers changed from: public */
    static {
        TAG = Swipe.class.getSimpleName();
    }

    private static float[][] interpolate(float[] fArr, float[] fArr2, int i11) {
        Preconditions.g(1, fArr.length);
        Preconditions.g(1, fArr2.length);
        int[] iArr = new int[2];
        iArr[1] = 2;
        iArr[0] = i11;
        float[][] fArr3 = (float[][]) Array.newInstance(float.class, iArr);
        for (int i12 = 1; i12 < i11 + 1; i12++) {
            int i13 = i12 - 1;
            float f11 = (float) i12;
            float f12 = ((float) i11) + 2.0f;
            fArr3[i13][0] = fArr[0] + (((fArr2[0] - fArr[0]) * f11) / f12);
            fArr3[i13][1] = fArr[1] + (((fArr2[1] - fArr[1]) * f11) / f12);
        }
        return fArr3;
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public static androidx.test.espresso.action.Swiper$Status sendLinearSwipe(androidx.test.espresso.UiController r10, float[] r11, float[] r12, float[] r13, int r14) {
        /*
            androidx.test.espresso.core.internal.deps.guava.base.Preconditions.i(r10)
            androidx.test.espresso.core.internal.deps.guava.base.Preconditions.i(r11)
            androidx.test.espresso.core.internal.deps.guava.base.Preconditions.i(r12)
            androidx.test.espresso.core.internal.deps.guava.base.Preconditions.i(r13)
            r0 = 10
            float[][] r0 = interpolate(r11, r12, r0)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            android.view.MotionEvent r11 = androidx.test.espresso.action.MotionEvents.d(r11, r13)
            r1.add(r11)
            int r13 = r0.length     // Catch:{ Exception -> 0x006b }
            int r14 = r14 / r13
            long r13 = (long) r14     // Catch:{ Exception -> 0x006b }
            long r2 = r11.getDownTime()     // Catch:{ Exception -> 0x006b }
            int r4 = r0.length     // Catch:{ Exception -> 0x006b }
            r5 = 0
            r6 = r5
        L_0x0028:
            if (r6 >= r4) goto L_0x003b
            r7 = r0[r6]     // Catch:{ Exception -> 0x006b }
            long r2 = r2 + r13
            long r8 = r11.getDownTime()     // Catch:{ Exception -> 0x006b }
            android.view.MotionEvent r7 = androidx.test.espresso.action.MotionEvents.f(r8, r2, r7)     // Catch:{ Exception -> 0x006b }
            r1.add(r7)     // Catch:{ Exception -> 0x006b }
            int r6 = r6 + 1
            goto L_0x0028
        L_0x003b:
            long r13 = r13 + r2
            long r2 = r11.getDownTime()     // Catch:{ Exception -> 0x006b }
            r6 = 1
            r7 = r12[r5]     // Catch:{ Exception -> 0x006b }
            r11 = 1
            r8 = r12[r11]     // Catch:{ Exception -> 0x006b }
            r9 = 0
            r4 = r13
            android.view.MotionEvent r11 = android.view.MotionEvent.obtain(r2, r4, r6, r7, r8, r9)     // Catch:{ Exception -> 0x006b }
            r1.add(r11)     // Catch:{ Exception -> 0x006b }
            r10.b(r1)     // Catch:{ Exception -> 0x006b }
            java.util.Iterator r10 = r1.iterator()
        L_0x0056:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0066
            java.lang.Object r11 = r10.next()
            android.view.MotionEvent r11 = (android.view.MotionEvent) r11
            r11.recycle()
            goto L_0x0056
        L_0x0066:
            androidx.test.espresso.action.Swiper$Status r10 = androidx.test.espresso.action.Swiper$Status.SUCCESS
            return r10
        L_0x0069:
            r10 = move-exception
            goto L_0x0082
        L_0x006b:
            androidx.test.espresso.action.Swiper$Status r10 = androidx.test.espresso.action.Swiper$Status.FAILURE     // Catch:{ all -> 0x0069 }
            java.util.Iterator r11 = r1.iterator()
        L_0x0071:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x0081
            java.lang.Object r12 = r11.next()
            android.view.MotionEvent r12 = (android.view.MotionEvent) r12
            r12.recycle()
            goto L_0x0071
        L_0x0081:
            return r10
        L_0x0082:
            java.util.Iterator r11 = r1.iterator()
        L_0x0086:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x0096
            java.lang.Object r12 = r11.next()
            android.view.MotionEvent r12 = (android.view.MotionEvent) r12
            r12.recycle()
            goto L_0x0086
        L_0x0096:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.test.espresso.action.Swipe.sendLinearSwipe(androidx.test.espresso.UiController, float[], float[], float[], int):androidx.test.espresso.action.Swiper$Status");
    }
}
