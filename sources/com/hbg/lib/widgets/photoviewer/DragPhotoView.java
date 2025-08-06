package com.hbg.lib.widgets.photoviewer;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView;
import com.huobi.view.roundimg.RoundedDrawable;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class DragPhotoView extends SubsamplingScaleImageView {
    public float J0;
    public Paint K0;
    public int L0;
    public final int M0 = 50;
    public float N0;
    public final float O0 = 0.5f;
    public float P0;
    public float Q0;
    public float R0;
    public float S0;
    public final int T0;
    public final int U0;
    public boolean V0;
    public boolean W0;
    public ValueAnimator X0;
    public f Y0;
    public int Z0;

    /* renamed from: a1  reason: collision with root package name */
    public int f72119a1;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        public void onGlobalLayout() {
            if (DragPhotoView.this.j0() && DragPhotoView.this.J0 <= 0.0f && DragPhotoView.this.getScale() > 0.0f) {
                DragPhotoView dragPhotoView = DragPhotoView.this;
                float unused = dragPhotoView.J0 = dragPhotoView.getScale();
                DragPhotoView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (DragPhotoView.this.getSHeight() <= 0 || DragPhotoView.this.getSHeight() < DragPhotoView.this.f72119a1) {
                    DragPhotoView.this.F0(((float) DragPhotoView.this.Z0) / (((float) DragPhotoView.this.getSWidth()) * 1.0f), new PointF(((float) DragPhotoView.this.getSWidth()) / 2.0f, ((float) DragPhotoView.this.getSHeight()) / 2.0f));
                    return;
                }
                float e12 = ((float) DragPhotoView.this.Z0) / (((float) DragPhotoView.this.getSWidth()) * 1.0f);
                DragPhotoView.this.F0(e12, new PointF(0.0f, 0.0f));
                DragPhotoView.this.setDoubleTapZoomScale(e12);
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (DragPhotoView.this.Y0 != null) {
                DragPhotoView.this.Y0.onClick(view);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements View.OnLongClickListener {
        public c() {
        }

        public boolean onLongClick(View view) {
            boolean z11 = !DragPhotoView.this.V0 && DragPhotoView.this.Y0 != null && DragPhotoView.this.Y0.onLongClick(view);
            boolean unused = DragPhotoView.this.W0 = !z11;
            return z11;
        }
    }

    public class d implements View.OnTouchListener {
        public d() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (DragPhotoView.this.t1()) {
                return true;
            }
            if (DragPhotoView.this.j0() && DragPhotoView.this.J0 == DragPhotoView.this.getScale()) {
                int action = motionEvent.getAction() & 255;
                if (action != 0) {
                    if (action != 1) {
                        if (action != 2) {
                            if (action != 3) {
                                if (action == 5 || action == 6) {
                                    DragPhotoView dragPhotoView = DragPhotoView.this;
                                    boolean unused = dragPhotoView.W0 = dragPhotoView.V0;
                                }
                            }
                        } else if (DragPhotoView.this.W0) {
                            float abs = Math.abs(DragPhotoView.this.Q0 - motionEvent.getY());
                            if (DragPhotoView.this.J0 == DragPhotoView.this.getScale() && abs > ((float) DragPhotoView.this.T0)) {
                                boolean unused2 = DragPhotoView.this.V0 = true;
                                float unused3 = DragPhotoView.this.R0 = motionEvent.getX() - DragPhotoView.this.P0;
                                float unused4 = DragPhotoView.this.S0 = motionEvent.getY() - DragPhotoView.this.Q0;
                                float Y0 = abs / ((float) DragPhotoView.this.U0);
                                if (Y0 > 1.0f) {
                                    Y0 = 1.0f;
                                }
                                int unused5 = DragPhotoView.this.L0 = (int) ((1.0f - Y0) * 255.0f);
                                DragPhotoView dragPhotoView2 = DragPhotoView.this;
                                int i11 = 50;
                                if (dragPhotoView2.L0 >= 50) {
                                    i11 = DragPhotoView.this.L0;
                                }
                                int unused6 = dragPhotoView2.L0 = i11;
                                float unused7 = DragPhotoView.this.N0 = 1.0f - (abs / ((float) DragPhotoView.this.getHeight()));
                                DragPhotoView dragPhotoView3 = DragPhotoView.this;
                                float f11 = 0.5f;
                                if (dragPhotoView3.N0 >= 0.5f) {
                                    f11 = DragPhotoView.this.N0;
                                }
                                float unused8 = dragPhotoView3.N0 = f11;
                                DragPhotoView.this.invalidate();
                            }
                        }
                    }
                    if (DragPhotoView.this.V0) {
                        if (Math.abs(DragPhotoView.this.S0) < ((float) DragPhotoView.this.U0) || DragPhotoView.this.Y0 == null) {
                            DragPhotoView.this.v1();
                        } else {
                            DragPhotoView.this.Y0.onDismiss();
                        }
                        boolean unused9 = DragPhotoView.this.V0 = false;
                    }
                } else {
                    float unused10 = DragPhotoView.this.P0 = motionEvent.getX();
                    float unused11 = DragPhotoView.this.Q0 = motionEvent.getY();
                    boolean unused12 = DragPhotoView.this.W0 = true;
                }
            }
            return DragPhotoView.this.V0;
        }
    }

    public class e implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f72124b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f72125c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ float f72126d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f72127e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ float f72128f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ float f72129g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ float f72130h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ float f72131i;

        public e(int i11, int i12, float f11, float f12, float f13, float f14, float f15, float f16) {
            this.f72124b = i11;
            this.f72125c = i12;
            this.f72126d = f11;
            this.f72127e = f12;
            this.f72128f = f13;
            this.f72129g = f14;
            this.f72130h = f15;
            this.f72131i = f16;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int unused = DragPhotoView.this.L0 = (int) (((float) this.f72124b) + (((float) this.f72125c) * floatValue));
            float unused2 = DragPhotoView.this.R0 = this.f72126d + (this.f72127e * floatValue);
            float unused3 = DragPhotoView.this.S0 = this.f72128f + (this.f72129g * floatValue);
            float unused4 = DragPhotoView.this.N0 = this.f72130h + (this.f72131i * floatValue);
            DragPhotoView.this.invalidate();
        }
    }

    public interface f extends View.OnClickListener, View.OnLongClickListener {
        void onDismiss();
    }

    public DragPhotoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.T0 = ViewConfiguration.get(context).getScaledTouchSlop();
        this.U0 = r1(context, 500.0f);
        this.L0 = 255;
        this.N0 = 1.0f;
        this.Z0 = getResources().getDisplayMetrics().widthPixels;
        this.f72119a1 = getResources().getDisplayMetrics().heightPixels;
        s1(context);
    }

    public static int r1(Context context, float f11) {
        return (int) ((f11 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void onDraw(Canvas canvas) {
        q1();
        this.K0.setAlpha(this.L0);
        canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.K0);
        canvas.translate(this.R0, this.S0);
        float f11 = this.N0;
        canvas.scale(f11, f11, (float) (getWidth() / 2), (float) (getHeight() / 2));
        super.onDraw(canvas);
    }

    public final void q1() {
        if (this.K0 == null) {
            Paint paint = new Paint();
            this.K0 = paint;
            paint.setColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        }
    }

    public final void s1(Context context) {
        setDebug(false);
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
        setOnClickListener(new b());
        super.setOnLongClickListener(new c());
        setOnTouchListener(new d());
    }

    public void setDismissListener(f fVar) {
        this.Y0 = fVar;
    }

    public final boolean t1() {
        ValueAnimator valueAnimator = this.X0;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public void u1() {
        this.Y0 = null;
        setOnLongClickListener((View.OnLongClickListener) null);
        setOnClickListener((View.OnClickListener) null);
        setDismissListener((f) null);
        setOnImageEventListener((SubsamplingScaleImageView.h) null);
    }

    public final void v1() {
        if (this.X0 == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.X0 = ofFloat;
            ofFloat.setDuration(150);
        }
        int i11 = this.L0;
        float f11 = this.R0;
        float f12 = this.S0;
        float f13 = this.N0;
        this.X0.addUpdateListener(new e(i11, 255 - i11, f11, 0.0f - f11, f12, 0.0f - f12, f13, 1.0f - f13));
        this.X0.start();
    }
}
