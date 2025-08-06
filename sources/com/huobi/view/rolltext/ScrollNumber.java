package com.huobi.view.rolltext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.huobi.view.roundimg.RoundedDrawable;

public class ScrollNumber extends View {
    private Context mContext;
    /* access modifiers changed from: private */
    public int mCurNum;
    /* access modifiers changed from: private */
    public int mDeltaNum;
    /* access modifiers changed from: private */
    public Interpolator mInterpolator;
    private int mNextNum;
    private float mOffset;
    private Paint mPaint;
    private Runnable mScrollRunnable;
    /* access modifiers changed from: private */
    public int mTargetNum;
    private Rect mTextBounds;
    private int mTextCenterX;
    private int mTextColor;
    private int mTextHeight;
    private int mTextSize;
    private Typeface mTypeface;

    public ScrollNumber(Context context) {
        this(context, (AttributeSet) null);
    }

    public static /* synthetic */ float access$426(ScrollNumber scrollNumber, double d11) {
        float f11 = (float) (((double) scrollNumber.mOffset) - d11);
        scrollNumber.mOffset = f11;
        return f11;
    }

    private void calNum(int i11) {
        if (i11 == -1) {
            i11 = 9;
        }
        int i12 = 0;
        if (i11 == 10) {
            i11 = 0;
        }
        this.mCurNum = i11;
        int i13 = i11 + 1;
        if (i13 != 10) {
            i12 = i13;
        }
        this.mNextNum = i12;
    }

    private int dp2px(float f11) {
        return (int) TypedValue.applyDimension(1, f11, getResources().getDisplayMetrics());
    }

    private void drawNext(Canvas canvas) {
        canvas.drawText(this.mNextNum + "", (float) this.mTextCenterX, (float) (((getMeasuredHeight() * 3) / 2) + (this.mTextHeight / 2)), this.mPaint);
    }

    private void drawSelf(Canvas canvas) {
        canvas.drawText(this.mCurNum + "", (float) this.mTextCenterX, (float) ((getMeasuredHeight() / 2) + (this.mTextHeight / 2)), this.mPaint);
    }

    private int measureHeight(int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int i12 = 0;
        if (mode == Integer.MIN_VALUE || mode == 0) {
            this.mPaint.getTextBounds("0", 0, 1, this.mTextBounds);
            i12 = this.mTextBounds.height();
        } else if (mode == 1073741824) {
            i12 = size;
        }
        if (mode == Integer.MIN_VALUE) {
            i12 = Math.min(i12, size);
        }
        return i12 + getPaddingTop() + getPaddingBottom() + dp2px(40.0f);
    }

    private void measureTextHeight() {
        Paint paint = this.mPaint;
        paint.getTextBounds(this.mCurNum + "", 0, 1, this.mTextBounds);
        this.mTextHeight = this.mTextBounds.height();
    }

    private int measureWidth(int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int i12 = 0;
        if (mode == Integer.MIN_VALUE || mode == 0) {
            this.mPaint.getTextBounds("0", 0, 1, this.mTextBounds);
            i12 = this.mTextBounds.width();
        } else if (mode == 1073741824) {
            i12 = size;
        }
        if (mode == Integer.MIN_VALUE) {
            i12 = Math.min(i12, size);
        }
        return i12 + getPaddingLeft() + getPaddingRight() + 15;
    }

    /* access modifiers changed from: private */
    public void setFromNumber(int i11) {
        if (i11 < 0 || i11 > 9) {
            throw new RuntimeException("invalidate number , should in [0,9]");
        }
        calNum(i11);
        this.mOffset = 0.0f;
        invalidate();
    }

    private int sp2px(float f11) {
        return (int) TypedValue.applyDimension(2, f11, getResources().getDisplayMetrics());
    }

    public void onDraw(Canvas canvas) {
        if (this.mCurNum != this.mTargetNum) {
            postDelayed(this.mScrollRunnable, 0);
            if (this.mOffset <= -1.0f) {
                this.mOffset = 0.0f;
                calNum(this.mCurNum + 1);
            }
        }
        canvas.translate(0.0f, this.mOffset * ((float) getMeasuredHeight()));
        drawSelf(canvas);
        drawNext(canvas);
    }

    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(measureWidth(i11), measureHeight(i12));
        this.mTextCenterX = ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) / 2;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public void setNumber(final int i11, final int i12, long j11) {
        postDelayed(new Runnable() {
            public void run() {
                ScrollNumber.this.setFromNumber(i11);
                ScrollNumber.this.setTargetNumber(i12);
                int unused = ScrollNumber.this.mDeltaNum = i12 - i11;
            }
        }, j11);
    }

    public void setTargetNumber(int i11) {
        this.mTargetNum = i11;
        invalidate();
    }

    public void setTextColor(int i11) {
        this.mTextColor = i11;
        this.mPaint.setColor(i11);
        invalidate();
    }

    public void setTextFont(String str) {
        if (!TextUtils.isEmpty(str)) {
            Typeface createFromAsset = Typeface.createFromAsset(this.mContext.getAssets(), str);
            this.mTypeface = createFromAsset;
            if (createFromAsset != null) {
                this.mPaint.setTypeface(createFromAsset);
                requestLayout();
                invalidate();
                return;
            }
            throw new RuntimeException("please check your font!");
        }
        throw new IllegalArgumentException("please check file name end with '.ttf' or '.otf'");
    }

    public void setTextSize(int i11) {
        int sp2px = sp2px((float) i11);
        this.mTextSize = sp2px;
        this.mPaint.setTextSize((float) sp2px);
        measureTextHeight();
        requestLayout();
        invalidate();
    }

    public ScrollNumber(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrollNumber(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mInterpolator = new AccelerateDecelerateInterpolator();
        this.mTextBounds = new Rect();
        this.mTextSize = sp2px(130.0f);
        this.mTextColor = RoundedDrawable.DEFAULT_BORDER_COLOR;
        this.mScrollRunnable = new Runnable() {
            public void run() {
                float access$200 = (float) (1.0d - ((((double) (ScrollNumber.this.mTargetNum - ScrollNumber.this.mCurNum)) * 1.0d) / ((double) ScrollNumber.this.mDeltaNum)));
                ScrollNumber scrollNumber = ScrollNumber.this;
                ScrollNumber.access$426(scrollNumber, (((double) (1.0f - scrollNumber.mInterpolator.getInterpolation(access$200))) + 0.1d) * 0.15000000596046448d);
                ScrollNumber.this.invalidate();
            }
        };
        this.mContext = context;
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setTextSize((float) this.mTextSize);
        this.mPaint.setColor(this.mTextColor);
        Typeface typeface = this.mTypeface;
        if (typeface != null) {
            this.mPaint.setTypeface(typeface);
        }
        measureTextHeight();
    }
}
