package com.cpiz.android.bubbleview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.cpiz.android.bubbleview.BubbleStyle;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.widgets.R$drawable;
import com.hbg.lib.widgets.R$style;
import com.huobi.view.HbgPopupWindow;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.Objects;

@SuppressLint({"RtlHardcoded"})
public class c extends HbgPopupWindow {
    private static final String TAG = "BubblePopupWindow";
    private int mArrowPosDelta = 0;
    private BubbleStyle mBubbleView;
    private long mDelayMillis = 0;
    private Runnable mDismissRunnable = new a();
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private int mPadding = Utils.b(2);

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            c.this.dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            c.this.dismiss();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.cpiz.android.bubbleview.c$c  reason: collision with other inner class name */
    public static /* synthetic */ class C0711c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f64804a;

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
                f64804a = r0
                com.cpiz.android.bubbleview.BubbleStyle$ArrowDirection r1 = com.cpiz.android.bubbleview.BubbleStyle.ArrowDirection.Up     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f64804a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.cpiz.android.bubbleview.BubbleStyle$ArrowDirection r1 = com.cpiz.android.bubbleview.BubbleStyle.ArrowDirection.Down     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f64804a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.cpiz.android.bubbleview.BubbleStyle$ArrowDirection r1 = com.cpiz.android.bubbleview.BubbleStyle.ArrowDirection.Left     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f64804a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.cpiz.android.bubbleview.BubbleStyle$ArrowDirection r1 = com.cpiz.android.bubbleview.BubbleStyle.ArrowDirection.Right     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cpiz.android.bubbleview.c.C0711c.<clinit>():void");
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public BubbleStyle.ArrowDirection f64805a;

        /* renamed from: b  reason: collision with root package name */
        public BubbleStyle.ArrowPosPolicy f64806b;

        /* renamed from: c  reason: collision with root package name */
        public int f64807c;

        /* renamed from: d  reason: collision with root package name */
        public int f64808d;

        /* renamed from: e  reason: collision with root package name */
        public int f64809e;

        /* renamed from: f  reason: collision with root package name */
        public int f64810f;

        /* renamed from: g  reason: collision with root package name */
        public int f64811g;

        public d() {
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    public c(View view, BubbleStyle bubbleStyle) {
        super(view, -2, -2);
        Objects.requireNonNull(bubbleStyle, "Bubble can not be null");
        this.mBubbleView = bubbleStyle;
        setBackgroundDrawable((GradientDrawable) ContextCompat.getDrawable(view.getContext(), R$drawable.common_bg_bubble_corner_bg));
        setCancelOnTouchOutside(true);
        setCancelOnTouch(true);
    }

    private static int getAnimationStyle(d dVar) {
        int b11 = dVar.b();
        dVar.c();
        int i11 = C0711c.f64804a[dVar.a().ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 4) {
                        return R$style.AnimationArrowNone;
                    }
                    if (b11 == 3) {
                        return R$style.LightBubbleAnimArrowUpRight;
                    }
                    if (b11 == 4) {
                        return R$style.LightAnimArrowDownRight;
                    }
                    return R$style.LightAnimationArrowRight;
                } else if (b11 == 3) {
                    return R$style.LightBubbleAnimArrowUpLeft;
                } else {
                    if (b11 == 4) {
                        return R$style.LightAnimArrowDownLeft;
                    }
                    return R$style.LightAnimationArrowLeft;
                }
            } else if (b11 == 4) {
                return R$style.LightAnimArrowDownRight;
            } else {
                if (b11 == 3) {
                    return R$style.LightAnimArrowDownLeft;
                }
                return R$style.LightAnimationArrowDown;
            }
        } else if (b11 == 4) {
            return R$style.LightBubbleAnimArrowUpRight;
        } else {
            if (b11 == 3) {
                return R$style.LightBubbleAnimArrowUpLeft;
            }
            return R$style.LightAnimationArrowUp;
        }
    }

    private static int getNavigationBarHeightDelta(View view) {
        return Utils.d(view);
    }

    private static void getPopupProp(int i11, int i12, int i13, Rect rect, int i14, int i15, d dVar, int i16, int i17, int i18, d dVar2, int i19) {
        d dVar3 = dVar2;
        dVar3.f64805a = dVar.a();
        dVar3.f64807c = getAnimationStyle(dVar);
        dVar3.f64809e = 0;
        int i21 = i11;
        Rect rect2 = rect;
        getPopupPropOfX(i21, rect2, i14, dVar, i16, i18, dVar2, i19, i13);
        d dVar4 = dVar2;
        getPopupPropOfMaxWidth(i21, rect2, dVar, i16, i18, dVar4);
        getPopupPropOfY(i12, i13, rect, dVar, i17, dVar4, i19);
        int i22 = C0711c.f64804a[dVar3.f64805a.ordinal()];
        if (i22 == 1 || i22 == 2) {
            int b11 = dVar.b();
            if (b11 == 0) {
                dVar3.f64806b = BubbleStyle.ArrowPosPolicy.TargetCenter;
            } else if (b11 == 3) {
                dVar3.f64806b = BubbleStyle.ArrowPosPolicy.SelfBegin;
            } else if (b11 != 4) {
                dVar3.f64806b = BubbleStyle.ArrowPosPolicy.TargetCenter;
            } else {
                dVar3.f64806b = BubbleStyle.ArrowPosPolicy.SelfEnd;
            }
        } else if (i22 == 3 || i22 == 4) {
            int c11 = dVar.c();
            if (c11 == 0) {
                dVar3.f64806b = BubbleStyle.ArrowPosPolicy.TargetCenter;
            } else if (c11 == 3) {
                dVar3.f64806b = BubbleStyle.ArrowPosPolicy.SelfBegin;
            } else if (c11 != 4) {
                dVar3.f64806b = BubbleStyle.ArrowPosPolicy.TargetCenter;
            } else {
                dVar3.f64806b = BubbleStyle.ArrowPosPolicy.SelfEnd;
            }
        } else {
            dVar3.f64806b = BubbleStyle.ArrowPosPolicy.TargetCenter;
        }
    }

    private static void getPopupPropOfMaxWidth(int i11, Rect rect, d dVar, int i12, int i13, d dVar2) {
        int b11 = dVar.b();
        if (b11 == 0) {
            dVar2.f64808d = i11 - (i13 * 2);
        } else if (b11 == 1) {
            dVar2.f64808d = (rect.left - i12) - i13;
        } else if (b11 == 2) {
            dVar2.f64808d = ((i11 - rect.right) - i12) - i13;
        } else if (b11 == 3) {
            dVar2.f64808d = ((i11 - rect.left) - i12) - i13;
        } else if (b11 == 4) {
            dVar2.f64808d = (rect.right - i12) - i13;
        }
    }

    private static void getPopupPropOfX(int i11, Rect rect, int i12, d dVar, int i13, int i14, d dVar2, int i15, int i16) {
        int b11 = dVar.b();
        if (b11 == 0) {
            int i17 = (i12 / 2) + i14;
            if (rect.centerX() < i17) {
                dVar2.f64809e |= 3;
                dVar2.f64810f = i14;
            } else if (i11 - rect.centerX() < i17) {
                dVar2.f64809e |= 5;
                dVar2.f64810f = i14;
            } else {
                dVar2.f64809e = 1;
                dVar2.f64810f = rect.centerX() - (i11 / 2);
            }
        } else if (b11 == 1) {
            dVar2.f64809e |= 5;
            dVar2.f64810f = (i11 - rect.left) + i13;
        } else if (b11 == 2) {
            dVar2.f64809e |= 3;
            dVar2.f64810f = rect.right + i13;
        } else if (b11 == 3) {
            dVar2.f64809e |= 3;
            dVar2.f64810f = rect.left + i13;
        } else if (b11 == 4) {
            dVar2.f64809e |= 5;
            dVar2.f64810f = (i11 - rect.right) + i13;
        }
    }

    private static void getPopupPropOfY(int i11, int i12, Rect rect, d dVar, int i13, d dVar2, int i14) {
        if (i14 != 1) {
            i12 = 0;
        }
        int c11 = dVar.c();
        if (c11 == 0) {
            dVar2.f64809e |= 16;
            dVar2.f64811g = (rect.centerY() - (i12 / 2)) - (i11 / 2);
        } else if (c11 == 1) {
            dVar2.f64809e |= 80;
            dVar2.f64811g = (i11 - rect.top) + i13;
        } else if (c11 == 2) {
            dVar2.f64809e |= 48;
            dVar2.f64811g = rect.bottom + i13;
        } else if (c11 == 3) {
            dVar2.f64809e |= 48;
            dVar2.f64811g = rect.top + i13;
        } else if (c11 == 4) {
            dVar2.f64809e |= 80;
            dVar2.f64811g = (i11 - rect.bottom) + i13;
        }
    }

    private static Rect getRectInWindow(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    public void dismiss() {
        this.mHandler.removeCallbacks(this.mDismissRunnable);
        super.dismiss();
    }

    public void setArrowPosDelta(int i11) {
        this.mArrowPosDelta = i11;
    }

    public void setCancelOnLater(long j11) {
        this.mHandler.removeCallbacks(this.mDismissRunnable);
        this.mDelayMillis = j11;
        if (j11 > 0) {
            this.mHandler.postDelayed(this.mDismissRunnable, j11);
        }
    }

    public void setCancelOnTouch(boolean z11) {
        getContentView().setOnClickListener(z11 ? new b() : null);
    }

    public void setCancelOnTouchOutside(boolean z11) {
        setOutsideTouchable(z11);
        setFocusable(false);
    }

    public void setPadding(int i11) {
        this.mPadding = i11;
    }

    public void showArrowTo(View view, BubbleStyle.ArrowDirection arrowDirection) {
        showArrowTo(view, arrowDirection, 0);
    }

    public void showArrowToNoAnim(View view, d dVar, int i11, int i12) {
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
        int navigationBarHeightDelta = getNavigationBarHeightDelta(view);
        Rect rectInWindow = getRectInWindow(view);
        int i18 = view.getResources().getConfiguration().orientation;
        getContentView().measure(View.MeasureSpec.makeMeasureSpec(i14 - (this.mPadding * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i13 - (this.mPadding * 2), Integer.MIN_VALUE));
        int measuredWidth = getContentView().getMeasuredWidth();
        int measuredHeight = getContentView().getMeasuredHeight();
        d dVar2 = new d((a) null);
        getPopupProp(i14, i13, navigationBarHeightDelta, rectInWindow, measuredWidth, measuredHeight, dVar, i11, i12, this.mPadding, dVar2, i18);
        setWidth(-2);
        setHeight(-2);
        int i19 = dVar2.f64808d;
        if (measuredWidth > i19) {
            setWidth(i19);
        }
        this.mBubbleView.setArrowDirection(dVar2.f64805a);
        this.mBubbleView.setArrowPosPolicy(dVar2.f64806b);
        this.mBubbleView.setArrowTo(view2);
        this.mBubbleView.setArrowPosDelta((float) this.mArrowPosDelta);
        showAtLocation(view2, dVar2.f64809e, dVar2.f64810f, dVar2.f64811g);
        long j11 = this.mDelayMillis;
        if (j11 > 0) {
            setCancelOnLater(j11);
        }
    }

    public void showArrowTo(View view, BubbleStyle.ArrowDirection arrowDirection, int i11) {
        d dVar;
        int i12 = C0711c.f64804a[arrowDirection.ordinal()];
        if (i12 == 1) {
            dVar = new d(0, 2);
        } else if (i12 == 2) {
            dVar = new d(0, 1);
        } else if (i12 == 3) {
            dVar = new d(2, 0);
        } else if (i12 != 4) {
            dVar = new d(0, 0);
        } else {
            dVar = new d(1, 0);
        }
        showArrowTo(view, dVar, i11, i11);
    }

    public void showArrowTo(View view, d dVar, int i11, int i12) {
        int i13;
        int i14;
        View view2 = view;
        dismiss();
        if (!(view.getContext() instanceof BaseCoreActivity) || ((BaseCoreActivity) view.getContext()).isAlive()) {
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
            int navigationBarHeightDelta = getNavigationBarHeightDelta(view);
            int i18 = view.getResources().getConfiguration().orientation;
            Rect rectInWindow = getRectInWindow(view);
            getContentView().measure(View.MeasureSpec.makeMeasureSpec(i14 - (this.mPadding * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i13 - (this.mPadding * 2), Integer.MIN_VALUE));
            int measuredWidth = getContentView().getMeasuredWidth();
            int measuredHeight = getContentView().getMeasuredHeight();
            d dVar2 = new d((a) null);
            getPopupProp(i14, i13, navigationBarHeightDelta, rectInWindow, measuredWidth, measuredHeight, dVar, i11, i12, this.mPadding, dVar2, i18);
            setWidth(-2);
            setHeight(-2);
            setAnimationStyle(dVar2.f64807c);
            int i19 = dVar2.f64808d;
            if (measuredWidth > i19) {
                setWidth(i19);
            }
            this.mBubbleView.setArrowDirection(dVar2.f64805a);
            this.mBubbleView.setArrowPosPolicy(dVar2.f64806b);
            this.mBubbleView.setArrowTo(view2);
            this.mBubbleView.setArrowPosDelta((float) this.mArrowPosDelta);
            try {
                showAtLocation(view2, dVar2.f64809e, dVar2.f64810f, dVar2.f64811g);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            long j11 = this.mDelayMillis;
            if (j11 > 0) {
                setCancelOnLater(j11);
            }
        }
    }
}
