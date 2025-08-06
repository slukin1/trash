package com.cpiz.android.bubbleview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import com.cpiz.android.bubbleview.BubbleStyle;
import com.hbg.lib.widgets.R$style;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.Objects;

@SuppressLint({"RtlHardcoded"})
public class b extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public int f64785a = Utils.b(2);

    /* renamed from: b  reason: collision with root package name */
    public int f64786b = 0;

    /* renamed from: c  reason: collision with root package name */
    public BubbleStyle f64787c;

    /* renamed from: d  reason: collision with root package name */
    public long f64788d = 0;

    /* renamed from: e  reason: collision with root package name */
    public Handler f64789e = new Handler(Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    public Runnable f64790f = new a();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            b.this.dismiss();
        }
    }

    /* renamed from: com.cpiz.android.bubbleview.b$b  reason: collision with other inner class name */
    public class C0710b implements View.OnClickListener {
        public C0710b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            b.this.dismiss();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f64793a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.cpiz.android.bubbleview.BubbleStyle$ArrowDirection[] r0 = com.cpiz.android.bubbleview.BubbleStyle.ArrowDirection.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f64793a = r0
                com.cpiz.android.bubbleview.BubbleStyle$ArrowDirection r1 = com.cpiz.android.bubbleview.BubbleStyle.ArrowDirection.Up     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f64793a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.cpiz.android.bubbleview.BubbleStyle$ArrowDirection r1 = com.cpiz.android.bubbleview.BubbleStyle.ArrowDirection.Down     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f64793a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.cpiz.android.bubbleview.BubbleStyle$ArrowDirection r1 = com.cpiz.android.bubbleview.BubbleStyle.ArrowDirection.Left     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f64793a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.cpiz.android.bubbleview.BubbleStyle$ArrowDirection r1 = com.cpiz.android.bubbleview.BubbleStyle.ArrowDirection.Right     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cpiz.android.bubbleview.b.c.<clinit>():void");
        }
    }

    public class d {

        /* renamed from: a  reason: collision with root package name */
        public BubbleStyle.ArrowDirection f64794a;

        /* renamed from: b  reason: collision with root package name */
        public BubbleStyle.ArrowPosPolicy f64795b;

        /* renamed from: c  reason: collision with root package name */
        public int f64796c;

        /* renamed from: d  reason: collision with root package name */
        public int f64797d;

        /* renamed from: e  reason: collision with root package name */
        public int f64798e;

        /* renamed from: f  reason: collision with root package name */
        public int f64799f;

        /* renamed from: g  reason: collision with root package name */
        public int f64800g;

        public d() {
        }

        public /* synthetic */ d(b bVar, a aVar) {
            this();
        }
    }

    public b(View view, BubbleStyle bubbleStyle) {
        super(view, -2, -2);
        Objects.requireNonNull(bubbleStyle, "Bubble can not be null");
        this.f64787c = bubbleStyle;
        setBackgroundDrawable(new ColorDrawable(0));
        k(true);
        j(true);
    }

    public static int a(BubbleStyle.ArrowDirection arrowDirection) {
        int i11 = c.f64793a[arrowDirection.ordinal()];
        if (i11 == 1) {
            return R$style.AnimationArrowUp;
        }
        if (i11 == 2) {
            return R$style.AnimationArrowDown;
        }
        if (i11 == 3) {
            return R$style.AnimationArrowLeft;
        }
        if (i11 != 4) {
            return R$style.AnimationArrowNone;
        }
        return R$style.AnimationArrowRight;
    }

    public static int b(View view) {
        return Utils.d(view);
    }

    public static void c(int i11, int i12, int i13, Rect rect, int i14, int i15, d dVar, int i16, int i17, int i18, d dVar2, int i19) {
        d dVar3 = dVar2;
        BubbleStyle.ArrowDirection a11 = dVar.a();
        dVar3.f64794a = a11;
        dVar3.f64796c = a(a11);
        dVar3.f64798e = 0;
        int i21 = i11;
        Rect rect2 = rect;
        e(i21, rect2, i14, dVar, i16, i18, dVar2, i19, i13);
        d dVar4 = dVar2;
        d(i21, rect2, dVar, i16, i18, dVar4);
        f(i12, i13, rect, dVar, i17, dVar4, i19);
        int i22 = c.f64793a[dVar3.f64794a.ordinal()];
        if (i22 == 1 || i22 == 2) {
            int b11 = dVar.b();
            if (b11 == 0) {
                dVar3.f64795b = BubbleStyle.ArrowPosPolicy.TargetCenter;
            } else if (b11 == 3) {
                dVar3.f64795b = BubbleStyle.ArrowPosPolicy.SelfBegin;
            } else if (b11 != 4) {
                dVar3.f64795b = BubbleStyle.ArrowPosPolicy.TargetCenter;
            } else {
                dVar3.f64795b = BubbleStyle.ArrowPosPolicy.SelfEnd;
            }
        } else if (i22 == 3 || i22 == 4) {
            int c11 = dVar.c();
            if (c11 == 0) {
                dVar3.f64795b = BubbleStyle.ArrowPosPolicy.TargetCenter;
            } else if (c11 == 3) {
                dVar3.f64795b = BubbleStyle.ArrowPosPolicy.SelfBegin;
            } else if (c11 != 4) {
                dVar3.f64795b = BubbleStyle.ArrowPosPolicy.TargetCenter;
            } else {
                dVar3.f64795b = BubbleStyle.ArrowPosPolicy.SelfEnd;
            }
        } else {
            dVar3.f64795b = BubbleStyle.ArrowPosPolicy.TargetCenter;
        }
    }

    public static void d(int i11, Rect rect, d dVar, int i12, int i13, d dVar2) {
        int b11 = dVar.b();
        if (b11 == 0) {
            dVar2.f64797d = i11 - (i13 * 2);
        } else if (b11 == 1) {
            dVar2.f64797d = (rect.left - i12) - i13;
        } else if (b11 == 2) {
            dVar2.f64797d = ((i11 - rect.right) - i12) - i13;
        } else if (b11 == 3) {
            dVar2.f64797d = ((i11 - rect.left) - i12) - i13;
        } else if (b11 == 4) {
            dVar2.f64797d = (rect.right - i12) - i13;
        }
    }

    public static void e(int i11, Rect rect, int i12, d dVar, int i13, int i14, d dVar2, int i15, int i16) {
        int b11 = dVar.b();
        if (b11 == 0) {
            int i17 = (i12 / 2) + i14;
            if (rect.centerX() < i17) {
                dVar2.f64798e |= 3;
                dVar2.f64799f = i14;
            } else if (i11 - rect.centerX() < i17) {
                dVar2.f64798e |= 5;
                dVar2.f64799f = i14;
            } else {
                dVar2.f64798e = 1;
                dVar2.f64799f = rect.centerX() - (i11 / 2);
            }
        } else if (b11 == 1) {
            dVar2.f64798e |= 5;
            dVar2.f64799f = (i11 - rect.left) + i13;
        } else if (b11 == 2) {
            dVar2.f64798e |= 3;
            dVar2.f64799f = rect.right + i13;
        } else if (b11 == 3) {
            dVar2.f64798e |= 3;
            dVar2.f64799f = rect.left + i13;
        } else if (b11 == 4) {
            dVar2.f64798e |= 5;
            dVar2.f64799f = (i11 - rect.right) + i13;
        }
    }

    public static void f(int i11, int i12, Rect rect, d dVar, int i13, d dVar2, int i14) {
        if (i14 != 1) {
            i12 = 0;
        }
        int c11 = dVar.c();
        if (c11 == 0) {
            dVar2.f64798e |= 16;
            dVar2.f64800g = (rect.centerY() - (i12 / 2)) - (i11 / 2);
        } else if (c11 == 1) {
            dVar2.f64798e |= 80;
            dVar2.f64800g = ((i11 + i12) - rect.top) + i13;
        } else if (c11 == 2) {
            dVar2.f64798e |= 48;
            dVar2.f64800g = rect.bottom + i13;
        } else if (c11 == 3) {
            dVar2.f64798e |= 48;
            dVar2.f64800g = rect.top + i13;
        } else if (c11 == 4) {
            dVar2.f64798e |= 80;
            dVar2.f64800g = ((i11 + i12) - rect.bottom) + i13;
        }
    }

    public static Rect g(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    public void dismiss() {
        this.f64789e.removeCallbacks(this.f64790f);
        super.dismiss();
    }

    public void h(int i11) {
        this.f64786b = i11;
    }

    public void i(long j11) {
        this.f64789e.removeCallbacks(this.f64790f);
        this.f64788d = j11;
        if (j11 > 0) {
            this.f64789e.postDelayed(this.f64790f, j11);
        }
    }

    public void j(boolean z11) {
        getContentView().setOnClickListener(z11 ? new C0710b() : null);
    }

    public void k(boolean z11) {
        setOutsideTouchable(z11);
        setFocusable(z11);
    }

    public void l(int i11) {
        this.f64785a = i11;
    }

    public void m(View view, d dVar, int i11, int i12) {
        int i13;
        int i14;
        View view2 = view;
        dismiss();
        int i15 = Resources.getSystem().getDisplayMetrics().widthPixels;
        int i16 = Resources.getSystem().getDisplayMetrics().heightPixels;
        if (view.getContext() instanceof Activity) {
            Rect rect = new Rect();
            ((Activity) view.getContext()).getWindow().getDecorView().getGlobalVisibleRect(rect);
            int i17 = rect.right - rect.left;
            i13 = rect.bottom - rect.top;
            i14 = i17;
        } else {
            i14 = i15;
            i13 = i16;
        }
        int b11 = b(view);
        int i18 = view.getResources().getConfiguration().orientation;
        Rect g11 = g(view);
        getContentView().measure(View.MeasureSpec.makeMeasureSpec(i14 - (this.f64785a * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i13 - (this.f64785a * 2), Integer.MIN_VALUE));
        int measuredWidth = getContentView().getMeasuredWidth();
        int measuredHeight = getContentView().getMeasuredHeight();
        Log.d("BubblePopupWindow", String.format("w:%d, h:%d", new Object[]{Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight)}));
        d dVar2 = new d(this, (a) null);
        c(i14, i13, b11, g11, measuredWidth, measuredHeight, dVar, i11, i12, this.f64785a, dVar2, i18);
        setWidth(-2);
        setHeight(-2);
        setAnimationStyle(dVar2.f64796c);
        int i19 = dVar2.f64797d;
        if (measuredWidth > i19) {
            setWidth(i19);
        }
        this.f64787c.setArrowDirection(dVar2.f64794a);
        this.f64787c.setArrowPosPolicy(dVar2.f64795b);
        this.f64787c.setArrowTo(view2);
        this.f64787c.setArrowPosDelta((float) this.f64786b);
        showAtLocation(view2, dVar2.f64798e, dVar2.f64799f, dVar2.f64800g);
        long j11 = this.f64788d;
        if (j11 > 0) {
            i(j11);
        }
    }

    public void n(View view, d dVar, int i11, int i12) {
        int i13;
        int i14;
        View view2 = view;
        dismiss();
        int i15 = Resources.getSystem().getDisplayMetrics().widthPixels;
        int i16 = Resources.getSystem().getDisplayMetrics().heightPixels;
        if (view.getContext() instanceof Activity) {
            Rect rect = new Rect();
            ((Activity) view.getContext()).getWindow().getDecorView().getGlobalVisibleRect(rect);
            int i17 = rect.right - rect.left;
            i13 = rect.bottom - rect.top;
            i14 = i17;
        } else {
            i14 = i15;
            i13 = i16;
        }
        int b11 = b(view);
        Rect g11 = g(view);
        int i18 = view.getResources().getConfiguration().orientation;
        getContentView().measure(View.MeasureSpec.makeMeasureSpec(i14 - (this.f64785a * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i13 - (this.f64785a * 2), Integer.MIN_VALUE));
        int measuredWidth = getContentView().getMeasuredWidth();
        int measuredHeight = getContentView().getMeasuredHeight();
        Log.d("BubblePopupWindow", String.format("w:%d, h:%d", new Object[]{Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight)}));
        d dVar2 = new d(this, (a) null);
        c(i14, i13, b11, g11, measuredWidth, measuredHeight, dVar, i11, i12, this.f64785a, dVar2, i18);
        setWidth(-2);
        setHeight(-2);
        int i19 = dVar2.f64797d;
        if (measuredWidth > i19) {
            setWidth(i19);
        }
        this.f64787c.setArrowDirection(dVar2.f64794a);
        this.f64787c.setArrowPosPolicy(dVar2.f64795b);
        this.f64787c.setArrowTo(view2);
        this.f64787c.setArrowPosDelta((float) this.f64786b);
        showAtLocation(view2, dVar2.f64798e, dVar2.f64799f, dVar2.f64800g);
        long j11 = this.f64788d;
        if (j11 > 0) {
            i(j11);
        }
    }
}
