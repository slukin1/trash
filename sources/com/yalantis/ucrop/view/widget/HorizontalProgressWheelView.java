package com.yalantis.ucrop.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.yalantis.ucrop.R;

public class HorizontalProgressWheelView extends View {
    private final Rect mCanvasClipBounds;
    private float mLastTouchedPosition;
    private int mMiddleLineColor;
    private int mProgressLineHeight;
    private int mProgressLineMargin;
    private Paint mProgressLinePaint;
    private int mProgressLineWidth;
    private Paint mProgressMiddleLinePaint;
    private boolean mScrollStarted;
    private ScrollingListener mScrollingListener;
    private float mTotalScrollDistance;

    public interface ScrollingListener {
        void onScroll(float f11, float f12);

        void onScrollEnd();

        void onScrollStart();
    }

    public HorizontalProgressWheelView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void init() {
        this.mMiddleLineColor = ContextCompat.getColor(getContext(), R.color.ucrop_color_widget_rotate_mid_line);
        this.mProgressLineWidth = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_horizontal_wheel_progress_line);
        this.mProgressLineHeight = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_height_horizontal_wheel_progress_line);
        this.mProgressLineMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_margin_horizontal_wheel_progress_line);
        Paint paint = new Paint(1);
        this.mProgressLinePaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mProgressLinePaint.setStrokeWidth((float) this.mProgressLineWidth);
        this.mProgressLinePaint.setColor(getResources().getColor(R.color.ucrop_color_progress_wheel_line));
        Paint paint2 = new Paint(this.mProgressLinePaint);
        this.mProgressMiddleLinePaint = paint2;
        paint2.setColor(this.mMiddleLineColor);
        this.mProgressMiddleLinePaint.setStrokeCap(Paint.Cap.ROUND);
        this.mProgressMiddleLinePaint.setStrokeWidth((float) getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_middle_wheel_progress_line));
    }

    private void onScrollEvent(MotionEvent motionEvent, float f11) {
        this.mTotalScrollDistance -= f11;
        postInvalidate();
        this.mLastTouchedPosition = motionEvent.getX();
        ScrollingListener scrollingListener = this.mScrollingListener;
        if (scrollingListener != null) {
            scrollingListener.onScroll(-f11, this.mTotalScrollDistance);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.mCanvasClipBounds);
        int width = this.mCanvasClipBounds.width();
        int i11 = this.mProgressLineWidth;
        int i12 = this.mProgressLineMargin;
        int i13 = width / (i11 + i12);
        float f11 = this.mTotalScrollDistance % ((float) (i12 + i11));
        for (int i14 = 0; i14 < i13; i14++) {
            int i15 = i13 / 4;
            if (i14 < i15) {
                this.mProgressLinePaint.setAlpha((int) ((((float) i14) / ((float) i15)) * 255.0f));
            } else if (i14 > (i13 * 3) / 4) {
                this.mProgressLinePaint.setAlpha((int) ((((float) (i13 - i14)) / ((float) i15)) * 255.0f));
            } else {
                this.mProgressLinePaint.setAlpha(255);
            }
            float f12 = -f11;
            Rect rect = this.mCanvasClipBounds;
            float f13 = ((float) rect.left) + f12 + ((float) ((this.mProgressLineWidth + this.mProgressLineMargin) * i14));
            float centerY = ((float) rect.centerY()) - (((float) this.mProgressLineHeight) / 4.0f);
            Rect rect2 = this.mCanvasClipBounds;
            canvas.drawLine(f13, centerY, f12 + ((float) rect2.left) + ((float) ((this.mProgressLineWidth + this.mProgressLineMargin) * i14)), ((float) rect2.centerY()) + (((float) this.mProgressLineHeight) / 4.0f), this.mProgressLinePaint);
        }
        float centerX = (float) this.mCanvasClipBounds.centerX();
        float centerY2 = ((float) this.mCanvasClipBounds.centerY()) - (((float) this.mProgressLineHeight) / 2.0f);
        Canvas canvas2 = canvas;
        float f14 = centerY2;
        canvas2.drawLine(centerX, f14, (float) this.mCanvasClipBounds.centerX(), (((float) this.mProgressLineHeight) / 2.0f) + ((float) this.mCanvasClipBounds.centerY()), this.mProgressMiddleLinePaint);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mLastTouchedPosition = motionEvent.getX();
        } else if (action == 1) {
            ScrollingListener scrollingListener = this.mScrollingListener;
            if (scrollingListener != null) {
                this.mScrollStarted = false;
                scrollingListener.onScrollEnd();
            }
        } else if (action == 2) {
            float x11 = motionEvent.getX() - this.mLastTouchedPosition;
            if (x11 != 0.0f) {
                if (!this.mScrollStarted) {
                    this.mScrollStarted = true;
                    ScrollingListener scrollingListener2 = this.mScrollingListener;
                    if (scrollingListener2 != null) {
                        scrollingListener2.onScrollStart();
                    }
                }
                onScrollEvent(motionEvent, x11);
            }
        }
        return true;
    }

    public void setMiddleLineColor(int i11) {
        this.mMiddleLineColor = i11;
        this.mProgressMiddleLinePaint.setColor(i11);
        invalidate();
    }

    public void setScrollingListener(ScrollingListener scrollingListener) {
        this.mScrollingListener = scrollingListener;
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mCanvasClipBounds = new Rect();
        init();
    }

    @TargetApi(21)
    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.mCanvasClipBounds = new Rect();
    }
}
