package com.huobi.view.rolltext;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import java.text.DecimalFormat;
import pro.huobi.R;

public class NumberScrollTextView extends TextView implements IRiseNumber {
    private static final int RUNNING = 1;
    private static final int STOPPED = 0;
    public static final int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
    private long duration = 1000;
    /* access modifiers changed from: private */
    public DecimalFormat fnum;
    private float fromNumber;
    /* access modifiers changed from: private */
    public EndListener mEndListener = null;
    /* access modifiers changed from: private */
    public int mPlayingState = 0;
    private float number;
    private int numberType = 2;

    public interface EndListener {
        void onEndFinish();
    }

    public NumberScrollTextView(Context context) {
        super(context);
    }

    private void runFloat() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.fromNumber, this.number});
        ofFloat.setDuration(this.duration);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NumberScrollTextView numberScrollTextView = NumberScrollTextView.this;
                numberScrollTextView.setText(numberScrollTextView.fnum.format((double) Float.parseFloat(valueAnimator.getAnimatedValue().toString())));
                if (valueAnimator.getAnimatedFraction() >= 1.0f) {
                    int unused = NumberScrollTextView.this.mPlayingState = 0;
                    if (NumberScrollTextView.this.mEndListener != null) {
                        NumberScrollTextView.this.mEndListener.onEndFinish();
                    }
                }
            }
        });
        ofFloat.start();
    }

    private void runInt() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) ((int) this.fromNumber), (float) ((int) this.number)});
        ofFloat.setDuration(this.duration);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NumberScrollTextView.this.setText(valueAnimator.getAnimatedValue().toString());
                if (valueAnimator.getAnimatedFraction() >= 1.0f) {
                    int unused = NumberScrollTextView.this.mPlayingState = 0;
                    if (NumberScrollTextView.this.mEndListener != null) {
                        NumberScrollTextView.this.mEndListener.onEndFinish();
                    }
                }
            }
        });
        ofFloat.start();
    }

    public static int sizeOfInt(int i11) {
        int i12 = 0;
        while (i11 > sizeTable[i12]) {
            i12++;
        }
        return i12 + 1;
    }

    public boolean isRunning() {
        return this.mPlayingState == 1;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.fnum = new DecimalFormat("##0.00");
    }

    public void setDuration(long j11) {
        this.duration = j11;
    }

    public void setFromAndEndNumber(int i11, int i12) {
        this.fromNumber = (float) i11;
        this.number = (float) i12;
        this.numberType = 1;
    }

    public void setOnEndListener(EndListener endListener) {
        this.mEndListener = endListener;
    }

    public void start() {
        if (!isRunning()) {
            this.mPlayingState = 1;
            if (this.numberType == 1) {
                runInt();
            } else {
                runFloat();
            }
        }
    }

    public void withNumber(int i11) {
        float f11 = (float) i11;
        this.number = f11;
        this.numberType = 1;
        if (i11 > 1000) {
            this.fromNumber = f11 - ((float) Math.pow(10.0d, ((double) sizeOfInt(i11)) - 2.0d));
        } else {
            this.fromNumber = f11 / 2.0f;
        }
    }

    public void setFromAndEndNumber(float f11, float f12) {
        this.fromNumber = f11;
        this.number = f12;
        this.numberType = 2;
    }

    public void withNumber(float f11) {
        this.number = f11;
        this.numberType = 2;
        if (f11 > 1000.0f) {
            this.fromNumber = f11 - ((float) Math.pow(10.0d, ((double) sizeOfInt((int) f11)) - 1.0d));
        } else {
            this.fromNumber = f11 / 2.0f;
        }
    }

    public NumberScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setTextColor(context.getResources().getColor(R.color.baseTextColor));
        setTextSize(30.0f);
    }

    public NumberScrollTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
