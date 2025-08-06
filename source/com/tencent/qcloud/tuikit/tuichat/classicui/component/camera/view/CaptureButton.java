package com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.listener.CaptureListener;
import com.tencent.qcloud.tuikit.tuichat.util.CheckPermission;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;

public class CaptureButton extends View {
    public static final int STATE_BAN = 5;
    public static final int STATE_IDLE = 1;
    public static final int STATE_LONG_PRESS = 3;
    public static final int STATE_PRESS = 2;
    public static final int STATE_RECORDERING = 4;
    private static final String TAG = CaptureButton.class.getSimpleName();
    /* access modifiers changed from: private */
    public float button_inside_radius;
    /* access modifiers changed from: private */
    public float button_outside_radius;
    private float button_radius;
    private int button_size;
    private int button_state;
    /* access modifiers changed from: private */
    public CaptureListener captureLisenter;
    private float center_X;
    private float center_Y;
    private int duration;
    private float event_Y;
    private int inside_color = -1;
    /* access modifiers changed from: private */
    public int inside_reduce_size;
    private LongPressRunnable longPressRunnable;
    private Paint mPaint;
    private int min_duration;
    /* access modifiers changed from: private */
    public int outside_add_size;
    private int outside_color = -287515428;
    private float progress;
    private int progress_color = -300503530;
    private int recorded_time;
    private RectF rectF;
    /* access modifiers changed from: private */
    public int state;
    private float strokeWidth;
    /* access modifiers changed from: private */
    public RecordCountDownTimer timer;

    public class LongPressRunnable implements Runnable {
        private LongPressRunnable() {
        }

        public void run() {
            int unused = CaptureButton.this.state = 3;
            if (CheckPermission.getRecordState() != 1) {
                int unused2 = CaptureButton.this.state = 1;
                if (CaptureButton.this.captureLisenter != null) {
                    CaptureButton.this.captureLisenter.recordError();
                    return;
                }
            }
            CaptureButton captureButton = CaptureButton.this;
            captureButton.startRecordAnimation(captureButton.button_outside_radius, CaptureButton.this.button_outside_radius + ((float) CaptureButton.this.outside_add_size), CaptureButton.this.button_inside_radius, CaptureButton.this.button_inside_radius - ((float) CaptureButton.this.inside_reduce_size));
        }
    }

    public class RecordCountDownTimer extends CountDownTimer {
        public RecordCountDownTimer(long j11, long j12) {
            super(j11, j12);
        }

        public void onFinish() {
            CaptureButton.this.updateProgress(0);
            CaptureButton.this.recordEnd();
        }

        public void onTick(long j11) {
            CaptureButton.this.updateProgress(j11);
        }
    }

    public CaptureButton(Context context) {
        super(context);
    }

    private void handlerUnpressByState() {
        int i11;
        removeCallbacks(this.longPressRunnable);
        int i12 = this.state;
        if (i12 != 2) {
            if (i12 == 4) {
                this.timer.cancel();
                recordEnd();
            }
        } else if (this.captureLisenter == null || !((i11 = this.button_state) == 257 || i11 == 259)) {
            this.state = 1;
        } else {
            startCaptureAnimation(this.button_inside_radius);
        }
    }

    /* access modifiers changed from: private */
    public void recordEnd() {
        CaptureListener captureListener = this.captureLisenter;
        if (captureListener != null) {
            int i11 = this.recorded_time;
            if (i11 < this.min_duration) {
                captureListener.recordShort((long) i11);
            } else {
                captureListener.recordEnd((long) i11);
            }
        }
        resetRecordAnim();
    }

    private void resetRecordAnim() {
        this.state = 5;
        this.progress = 0.0f;
        invalidate();
        float f11 = this.button_outside_radius;
        float f12 = this.button_radius;
        startRecordAnimation(f11, f12, this.button_inside_radius, 0.75f * f12);
    }

    private void startCaptureAnimation(float f11) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f11, 0.75f * f11, f11});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = CaptureButton.this.button_inside_radius = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CaptureButton.this.invalidate();
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                CaptureButton.this.captureLisenter.takePictures();
                int unused = CaptureButton.this.state = 5;
            }
        });
        ofFloat.setDuration(100);
        ofFloat.start();
    }

    /* access modifiers changed from: private */
    public void startRecordAnimation(float f11, float f12, float f13, float f14) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f11, f12});
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{f13, f14});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = CaptureButton.this.button_outside_radius = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CaptureButton.this.invalidate();
            }
        });
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = CaptureButton.this.button_inside_radius = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CaptureButton.this.invalidate();
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (CaptureButton.this.state == 3) {
                    if (CaptureButton.this.captureLisenter != null) {
                        CaptureButton.this.captureLisenter.recordStart();
                    }
                    int unused = CaptureButton.this.state = 4;
                    CaptureButton.this.timer.start();
                }
            }
        });
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.setDuration(100);
        animatorSet.start();
    }

    /* access modifiers changed from: private */
    public void updateProgress(long j11) {
        int i11 = this.duration;
        this.recorded_time = (int) (((long) i11) - j11);
        this.progress = 360.0f - ((((float) j11) / ((float) i11)) * 360.0f);
        invalidate();
    }

    public boolean isIdle() {
        return this.state == 1;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.outside_color);
        canvas.drawCircle(this.center_X, this.center_Y, this.button_outside_radius, this.mPaint);
        this.mPaint.setColor(this.inside_color);
        canvas.drawCircle(this.center_X, this.center_Y, this.button_inside_radius, this.mPaint);
        if (this.state == 4) {
            this.mPaint.setColor(this.progress_color);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.strokeWidth);
            canvas.drawArc(this.rectF, -90.0f, this.progress, false, this.mPaint);
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int i13 = this.button_size;
        int i14 = this.outside_add_size;
        setMeasuredDimension((i14 * 2) + i13, i13 + (i14 * 2));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        CaptureListener captureListener;
        int i11;
        int action = motionEvent.getAction();
        if (action == 0) {
            String str = TAG;
            TUIChatLog.i(str, "state = " + this.state);
            if (motionEvent.getPointerCount() <= 1 && this.state == 1) {
                this.event_Y = motionEvent.getY();
                this.state = 2;
                int i12 = this.button_state;
                if (i12 == 258 || i12 == 259) {
                    postDelayed(this.longPressRunnable, 500);
                }
            }
        } else if (action == 1) {
            handlerUnpressByState();
        } else if (action == 2 && (captureListener = this.captureLisenter) != null && this.state == 4 && ((i11 = this.button_state) == 258 || i11 == 259)) {
            captureListener.recordZoom(this.event_Y - motionEvent.getY());
        }
        return true;
    }

    public void resetState() {
        this.state = 1;
    }

    public void setButtonFeatures(int i11) {
        this.button_state = i11;
    }

    public void setCaptureLisenter(CaptureListener captureListener) {
        this.captureLisenter = captureListener;
    }

    public void setDuration(int i11) {
        this.duration = i11;
        this.timer = new RecordCountDownTimer((long) i11, (long) (i11 / 360));
    }

    public void setMinDuration(int i11) {
        this.min_duration = i11;
    }

    public CaptureButton(Context context, int i11) {
        super(context);
        this.button_size = i11;
        float f11 = ((float) i11) / 2.0f;
        this.button_radius = f11;
        this.button_outside_radius = f11;
        this.button_inside_radius = f11 * 0.75f;
        this.strokeWidth = (float) (i11 / 15);
        this.outside_add_size = i11 / 5;
        this.inside_reduce_size = i11 / 8;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.progress = 0.0f;
        this.longPressRunnable = new LongPressRunnable();
        this.state = 1;
        this.button_state = 259;
        String str = TAG;
        TUIChatLog.i(str, "CaptureButtom start");
        this.duration = 10000;
        TUIChatLog.i(str, "CaptureButtom end");
        this.min_duration = 1500;
        int i12 = this.button_size;
        int i13 = this.outside_add_size;
        this.center_X = (float) (((i13 * 2) + i12) / 2);
        this.center_Y = (float) ((i12 + (i13 * 2)) / 2);
        float f12 = this.center_X;
        float f13 = this.button_radius;
        int i14 = this.outside_add_size;
        float f14 = this.strokeWidth;
        float f15 = this.center_Y;
        this.rectF = new RectF(f12 - ((((float) i14) + f13) - (f14 / 2.0f)), f15 - ((((float) i14) + f13) - (f14 / 2.0f)), f12 + ((((float) i14) + f13) - (f14 / 2.0f)), f15 + ((f13 + ((float) i14)) - (f14 / 2.0f)));
        int i15 = this.duration;
        this.timer = new RecordCountDownTimer((long) i15, (long) (i15 / 360));
    }
}
