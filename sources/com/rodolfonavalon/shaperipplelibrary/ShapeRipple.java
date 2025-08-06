package com.rodolfonavalon.shaperipplelibrary;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import by.b;
import com.rodolfonavalon.shaperipplelibrary.model.BaseShape;
import com.rodolfonavalon.shaperipplelibrary.model.Circle;
import com.rodolfonavalon.shaperipplelibrary.util.ShapePulseUtil;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class ShapeRipple extends View {
    public static boolean DEBUG = false;
    private static final int DEFAULT_RIPPLE_COLOR = Color.parseColor("#FFF44336");
    private static final int DEFAULT_RIPPLE_DURATION = 1500;
    private static final int DEFAULT_RIPPLE_FROM_COLOR = Color.parseColor("#FFF44336");
    private static final float DEFAULT_RIPPLE_INTERVAL_FACTOR = 1.0f;
    private static final int DEFAULT_RIPPLE_TO_COLOR = Color.parseColor("#00FFFFFF");
    private static final int NO_VALUE = 0;
    public static final String TAG = ShapeRipple.class.getSimpleName();
    private boolean enableColorTransition = true;
    private boolean enableRandomColor = false;
    private boolean enableRandomPosition = false;
    private boolean enableSingleRipple = false;
    private boolean enableStrokeStyle = false;
    private boolean isStopped;
    private float lastMultiplierValue = 0.0f;
    private b lifeCycleManager;
    private int maxRippleRadius;
    private Random random;
    private int rippleColor;
    private int rippleCount;
    private int rippleDuration;
    private int rippleFromColor;
    private Interpolator rippleInterpolator;
    private float rippleInterval;
    private float rippleIntervalFactor;
    private float rippleMaximumRadius;
    private List<Integer> rippleRandomColors;
    private BaseShape rippleShape;
    private int rippleStrokeWidth;
    private int rippleToColor;
    private ValueAnimator rippleValueAnimator;
    public Paint shapePaint;
    private Deque<cy.a> shapeRippleEntries;
    private int viewHeight;
    private int viewWidth;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ShapeRipple.this.render((Float) valueAnimator.getAnimatedValue());
        }
    }

    public ShapeRipple(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    public static void enableDebugging() {
        DEBUG = true;
    }

    private void init(Context context, AttributeSet attributeSet) {
        Paint paint = new Paint();
        this.shapePaint = paint;
        paint.setAntiAlias(true);
        this.shapePaint.setDither(true);
        this.shapePaint.setStyle(Paint.Style.FILL);
        this.shapeRippleEntries = new LinkedList();
        this.random = new Random();
        Circle circle = new Circle();
        this.rippleShape = circle;
        circle.b(context, this.shapePaint);
        int i11 = DEFAULT_RIPPLE_COLOR;
        this.rippleColor = i11;
        int i12 = DEFAULT_RIPPLE_FROM_COLOR;
        this.rippleFromColor = i12;
        int i13 = DEFAULT_RIPPLE_TO_COLOR;
        this.rippleToColor = i13;
        Resources resources = getResources();
        int i14 = R$dimen.default_stroke_width;
        this.rippleStrokeWidth = resources.getDimensionPixelSize(i14);
        this.rippleRandomColors = ShapePulseUtil.b(getContext());
        this.rippleDuration = 1500;
        this.rippleIntervalFactor = 1.0f;
        this.rippleInterpolator = new LinearInterpolator();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ConnectingRipple, 0, 0);
            try {
                this.rippleColor = obtainStyledAttributes.getColor(R$styleable.ConnectingRipple_ripple_color, i11);
                this.rippleFromColor = obtainStyledAttributes.getColor(R$styleable.ConnectingRipple_ripple_from_color, i12);
                this.rippleToColor = obtainStyledAttributes.getColor(R$styleable.ConnectingRipple_ripple_to_color, i13);
                setRippleDuration(obtainStyledAttributes.getInteger(R$styleable.ConnectingRipple_ripple_duration, 1500));
                this.enableColorTransition = obtainStyledAttributes.getBoolean(R$styleable.ConnectingRipple_enable_color_transition, true);
                this.enableSingleRipple = obtainStyledAttributes.getBoolean(R$styleable.ConnectingRipple_enable_single_ripple, false);
                this.enableRandomPosition = obtainStyledAttributes.getBoolean(R$styleable.ConnectingRipple_enable_random_position, false);
                this.rippleMaximumRadius = (float) obtainStyledAttributes.getDimensionPixelSize(R$styleable.ConnectingRipple_ripple_maximum_radius, 0);
                this.rippleCount = obtainStyledAttributes.getInteger(R$styleable.ConnectingRipple_ripple_count, 0);
                setEnableStrokeStyle(obtainStyledAttributes.getBoolean(R$styleable.ConnectingRipple_enable_stroke_style, false));
                setEnableRandomColor(obtainStyledAttributes.getBoolean(R$styleable.ConnectingRipple_enable_random_color, false));
                setRippleStrokeWidth(obtainStyledAttributes.getDimensionPixelSize(R$styleable.ConnectingRipple_ripple_stroke_width, getResources().getDimensionPixelSize(i14)));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        start(this.rippleDuration);
        if (Build.VERSION.SDK_INT >= 14) {
            b bVar = new b(this);
            this.lifeCycleManager = bVar;
            bVar.a();
        }
    }

    private void initializeEntries(BaseShape baseShape) {
        int i11;
        this.shapePaint.setStrokeWidth((float) this.rippleStrokeWidth);
        if (this.viewWidth != 0 || this.viewHeight != 0) {
            this.shapeRippleEntries.clear();
            float f11 = this.rippleMaximumRadius;
            if (f11 != 0.0f) {
                i11 = (int) f11;
            } else {
                i11 = (Math.min(this.viewWidth, this.viewHeight) / 2) - (this.rippleStrokeWidth / 2);
            }
            this.maxRippleRadius = i11;
            int i12 = this.rippleCount;
            if (i12 <= 0) {
                i12 = i11 / this.rippleStrokeWidth;
            }
            this.rippleCount = i12;
            this.rippleInterval = 1.0f / ((float) i12);
            int i13 = 0;
            while (i13 < this.rippleCount) {
                cy.a aVar = new cy.a(baseShape);
                aVar.r(this.enableRandomPosition ? this.random.nextInt(this.viewWidth) : this.viewWidth / 2);
                aVar.s(this.enableRandomPosition ? this.random.nextInt(this.viewHeight) : this.viewHeight / 2);
                aVar.m(-(this.rippleInterval * ((float) i13)));
                aVar.q(i13);
                if (this.enableRandomColor) {
                    List<Integer> list = this.rippleRandomColors;
                    aVar.n(list.get(this.random.nextInt(list.size())).intValue());
                } else {
                    aVar.n(this.rippleColor);
                }
                this.shapeRippleEntries.add(aVar);
                if (!this.enableSingleRipple) {
                    i13++;
                } else {
                    return;
                }
            }
        }
    }

    private void reconfigureEntries() {
        Deque<cy.a> deque;
        if (this.viewWidth == 0 && this.viewHeight == 0 && ((deque = this.shapeRippleEntries) == null || deque.size() == 0)) {
            by.a.b("The view dimensions was not calculated!!");
            return;
        }
        this.shapePaint.setStrokeWidth((float) this.rippleStrokeWidth);
        for (cy.a next : this.shapeRippleEntries) {
            if (this.enableRandomColor) {
                List<Integer> list = this.rippleRandomColors;
                next.n(list.get(this.random.nextInt(list.size())).intValue());
            } else {
                next.n(this.rippleColor);
            }
            next.k(this.rippleShape);
        }
    }

    /* access modifiers changed from: private */
    public void render(Float f11) {
        int i11;
        if (this.shapeRippleEntries.size() == 0) {
            by.a.a("There are no ripple entries that was created!!");
            return;
        }
        float c11 = this.shapeRippleEntries.peekFirst().c() + Math.max(f11.floatValue() - this.lastMultiplierValue, 0.0f);
        if (c11 >= 1.0f) {
            cy.a pop = this.shapeRippleEntries.pop();
            pop.j();
            if (this.enableRandomColor) {
                List<Integer> list = this.rippleRandomColors;
                i11 = list.get(this.random.nextInt(list.size())).intValue();
            } else {
                i11 = this.rippleColor;
            }
            pop.n(i11);
            this.shapeRippleEntries.addLast(pop);
            cy.a peekFirst = this.shapeRippleEntries.peekFirst();
            float c12 = peekFirst.c() + Math.max(f11.floatValue() - this.lastMultiplierValue, 0.0f);
            peekFirst.r(this.enableRandomPosition ? this.random.nextInt(this.viewWidth) : this.viewWidth / 2);
            peekFirst.s(this.enableRandomPosition ? this.random.nextInt(this.viewHeight) : this.viewHeight / 2);
            c11 = this.enableSingleRipple ? 0.0f : c12;
        }
        int i12 = 0;
        for (cy.a next : this.shapeRippleEntries) {
            next.q(i12);
            float f12 = c11 - (this.rippleInterval * ((float) i12));
            if (f12 >= 0.0f) {
                next.p(true);
                if (i12 == 0) {
                    next.m(c11);
                } else {
                    next.m(f12);
                }
                next.l(this.enableColorTransition ? ShapePulseUtil.a(f12, next.d(), this.rippleToColor) : this.rippleColor);
                next.o(((float) this.maxRippleRadius) * f12);
                i12++;
            } else {
                next.p(false);
            }
        }
        this.lastMultiplierValue = f11.floatValue();
        invalidate();
    }

    public int getRippleColor() {
        return this.rippleColor;
    }

    public int getRippleCount() {
        return this.rippleCount;
    }

    public int getRippleDuration() {
        return this.rippleDuration;
    }

    public int getRippleFromColor() {
        return this.rippleFromColor;
    }

    public Interpolator getRippleInterpolator() {
        return this.rippleInterpolator;
    }

    public float getRippleMaximumRadius() {
        return (float) this.maxRippleRadius;
    }

    public List<Integer> getRippleRandomColors() {
        return this.rippleRandomColors;
    }

    public BaseShape getRippleShape() {
        return this.rippleShape;
    }

    public int getRippleStrokeWidth() {
        return this.rippleStrokeWidth;
    }

    public int getRippleToColor() {
        return this.rippleToColor;
    }

    public boolean isEnableColorTransition() {
        return this.enableColorTransition;
    }

    public boolean isEnableRandomColor() {
        return this.enableRandomColor;
    }

    public boolean isEnableRandomPosition() {
        return this.enableRandomPosition;
    }

    public boolean isEnableSingleRipple() {
        return this.enableSingleRipple;
    }

    public boolean isEnableStrokeStyle() {
        return this.enableStrokeStyle;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        stop();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (cy.a next : this.shapeRippleEntries) {
            if (next.i()) {
                next.a().a(canvas, next.g(), next.h(), next.e(), next.b(), next.f(), this.shapePaint);
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        this.viewWidth = View.MeasureSpec.getSize(i11);
        this.viewHeight = View.MeasureSpec.getSize(i12);
        initializeEntries(this.rippleShape);
        this.rippleShape.d(this.viewWidth);
        this.rippleShape.c(this.viewHeight);
    }

    public void restartRipple() {
        if (this.isStopped) {
            by.a.a("Restarted from stopped ripple!!");
        } else {
            startRipple();
        }
    }

    public void setEnableColorTransition(boolean z11) {
        this.enableColorTransition = z11;
    }

    public void setEnableRandomColor(boolean z11) {
        this.enableRandomColor = z11;
        reconfigureEntries();
    }

    public void setEnableRandomPosition(boolean z11) {
        this.enableRandomPosition = z11;
        initializeEntries(this.rippleShape);
    }

    public void setEnableSingleRipple(boolean z11) {
        this.enableSingleRipple = z11;
        initializeEntries(this.rippleShape);
    }

    public void setEnableStrokeStyle(boolean z11) {
        this.enableStrokeStyle = z11;
        if (z11) {
            this.shapePaint.setStyle(Paint.Style.STROKE);
        } else {
            this.shapePaint.setStyle(Paint.Style.FILL);
        }
    }

    public void setRippleColor(int i11) {
        setRippleColor(i11, true);
    }

    public void setRippleCount(int i11) {
        if (i11 > 0) {
            this.rippleCount = i11;
            requestLayout();
            return;
        }
        throw new NullPointerException("Invalid ripple count");
    }

    public void setRippleDuration(int i11) {
        if (this.rippleDuration > 0) {
            this.rippleDuration = i11;
            ValueAnimator valueAnimator = this.rippleValueAnimator;
            if (valueAnimator != null) {
                valueAnimator.setDuration((long) i11);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Ripple duration must be > 0");
    }

    public void setRippleFromColor(int i11) {
        setRippleFromColor(i11, true);
    }

    public void setRippleInterpolator(Interpolator interpolator) {
        Objects.requireNonNull(interpolator, "Ripple interpolator in null");
        this.rippleInterpolator = interpolator;
    }

    public void setRippleMaximumRadius(float f11) {
        if (f11 > 0.0f) {
            this.rippleMaximumRadius = f11;
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Ripple max radius must be greater than 0");
    }

    public void setRippleRandomColors(List<Integer> list) {
        Objects.requireNonNull(list, "List of colors cannot be null");
        if (list.size() != 0) {
            this.rippleRandomColors.clear();
            this.rippleRandomColors = list;
            reconfigureEntries();
            return;
        }
        throw new IllegalArgumentException("List of color cannot be empty");
    }

    public void setRippleShape(BaseShape baseShape) {
        this.rippleShape = baseShape;
        baseShape.b(getContext(), this.shapePaint);
        reconfigureEntries();
    }

    public void setRippleStrokeWidth(int i11) {
        if (i11 > 0) {
            this.rippleStrokeWidth = i11;
            return;
        }
        throw new IllegalArgumentException("Ripple duration must be > 0");
    }

    public void setRippleToColor(int i11) {
        setRippleToColor(i11, true);
    }

    public void start(int i11) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.rippleValueAnimator = ofFloat;
        ofFloat.setDuration((long) i11);
        this.rippleValueAnimator.setRepeatMode(1);
        this.rippleValueAnimator.setRepeatCount(-1);
        this.rippleValueAnimator.setInterpolator(this.rippleInterpolator);
        this.rippleValueAnimator.addUpdateListener(new a());
        this.rippleValueAnimator.start();
    }

    public void startRipple() {
        stop();
        initializeEntries(this.rippleShape);
        start(this.rippleDuration);
        this.isStopped = false;
    }

    public void stop() {
        ValueAnimator valueAnimator = this.rippleValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.rippleValueAnimator.end();
            this.rippleValueAnimator.removeAllUpdateListeners();
            this.rippleValueAnimator.removeAllListeners();
            this.rippleValueAnimator = null;
        }
        Deque<cy.a> deque = this.shapeRippleEntries;
        if (deque != null) {
            deque.clear();
            invalidate();
        }
    }

    public void stopRipple() {
        stop();
        this.isStopped = true;
    }

    public void setRippleColor(int i11, boolean z11) {
        this.rippleColor = i11;
        if (z11) {
            reconfigureEntries();
        }
    }

    public void setRippleFromColor(int i11, boolean z11) {
        this.rippleFromColor = i11;
        if (z11) {
            reconfigureEntries();
        }
    }

    public void setRippleToColor(int i11, boolean z11) {
        this.rippleToColor = i11;
        if (z11) {
            reconfigureEntries();
        }
    }

    public ShapeRipple(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public ShapeRipple(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context, attributeSet);
    }
}
