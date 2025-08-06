package com.sensorsdata.analytics.android.sdk.visual.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.sensorsdata.analytics.android.sdk.visual.view.IPairingCodeInterface;
import java.util.Timer;
import java.util.TimerTask;

class PairingCodeEditText extends EditText implements IPairingCodeInterface, TextWatcher {
    private static final int DEFAULT_CURSOR_DURATION = 400;
    /* access modifiers changed from: private */
    public boolean isCursorShowing;
    private float mBottomLineHeight;
    private int mBottomNormalColor;
    private Paint mBottomNormalPaint;
    private int mBottomSelectedColor;
    private Paint mBottomSelectedPaint;
    private int mCurrentPosition;
    private int mCursorColor;
    private int mCursorDuration;
    private Paint mCursorPaint;
    private Timer mCursorTimer;
    private TimerTask mCursorTimerTask;
    private int mCursorWidth;
    private int mEachRectLength;
    private int mFigures;
    private Paint mNormalBackgroundPaint;
    private int mPairingCodeMargin;
    private int mSelectedBackgroundColor;
    private Paint mSelectedBackgroundPaint;
    private IPairingCodeInterface.OnPairingCodeChangedListener onCodeChangedListener;

    public PairingCodeEditText(Context context) {
        this(context, (AttributeSet) null);
    }

    private int dp2px(int i11) {
        return (int) TypedValue.applyDimension(1, (float) i11, getResources().getDisplayMetrics());
    }

    private int getColor(int i11) {
        return getContext().getResources().getColor(i11);
    }

    public static int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.widthPixels;
    }

    private void initAttrs() {
        this.mFigures = 4;
        this.mPairingCodeMargin = dp2px(10);
        this.mBottomSelectedColor = Color.parseColor("#00c48e");
        this.mBottomNormalColor = getColor(17170432);
        this.mBottomLineHeight = (float) dp2px(2);
        this.mSelectedBackgroundColor = getColor(17170445);
        this.mCursorWidth = dp2px(1);
        this.mCursorColor = Color.parseColor("#00c48e");
        this.mCursorDuration = 400;
        if (Build.VERSION.SDK_INT >= 17) {
            setLayoutDirection(0);
        }
    }

    private void initCursorTimer() {
        this.mCursorTimerTask = new TimerTask() {
            public void run() {
                PairingCodeEditText pairingCodeEditText = PairingCodeEditText.this;
                boolean unused = pairingCodeEditText.isCursorShowing = !pairingCodeEditText.isCursorShowing;
                PairingCodeEditText.this.postInvalidate();
            }
        };
        this.mCursorTimer = new Timer();
    }

    private void initPaint() {
        Paint paint = new Paint();
        this.mSelectedBackgroundPaint = paint;
        paint.setColor(this.mSelectedBackgroundColor);
        Paint paint2 = new Paint();
        this.mNormalBackgroundPaint = paint2;
        paint2.setColor(getColor(17170445));
        this.mBottomSelectedPaint = new Paint();
        this.mBottomNormalPaint = new Paint();
        this.mBottomSelectedPaint.setColor(this.mBottomSelectedColor);
        this.mBottomNormalPaint.setColor(this.mBottomNormalColor);
        this.mBottomSelectedPaint.setStrokeWidth(this.mBottomLineHeight);
        this.mBottomNormalPaint.setStrokeWidth(this.mBottomLineHeight);
        Paint paint3 = new Paint();
        this.mCursorPaint = paint3;
        paint3.setAntiAlias(true);
        this.mCursorPaint.setColor(this.mCursorColor);
        this.mCursorPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mCursorPaint.setStrokeWidth((float) this.mCursorWidth);
    }

    public void afterTextChanged(Editable editable) {
        this.mCurrentPosition = getText().length();
        postInvalidate();
        if (getText().length() == this.mFigures) {
            IPairingCodeInterface.OnPairingCodeChangedListener onPairingCodeChangedListener = this.onCodeChangedListener;
            if (onPairingCodeChangedListener != null) {
                onPairingCodeChangedListener.onInputCompleted(getText());
            }
        } else if (getText().length() > this.mFigures) {
            getText().delete(this.mFigures, getText().length());
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        this.mCurrentPosition = getText().length();
        postInvalidate();
    }

    public void clearText() {
        getText().delete(0, getText().length());
    }

    public void hiddenKeyBord() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mCursorTimer.scheduleAtFixedRate(this.mCursorTimerTask, 0, (long) this.mCursorDuration);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mCursorTimer.cancel();
    }

    public void onDraw(Canvas canvas) {
        this.mCurrentPosition = getText().length();
        int paddingLeft = (this.mEachRectLength - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        for (int i11 = 0; i11 < this.mFigures; i11++) {
            canvas.save();
            int i12 = (paddingLeft * i11) + (this.mPairingCodeMargin * i11);
            int i13 = paddingLeft + i12;
            if (i11 == this.mCurrentPosition) {
                canvas.drawRect((float) i12, 0.0f, (float) i13, (float) measuredHeight, this.mSelectedBackgroundPaint);
            } else {
                canvas.drawRect((float) i12, 0.0f, (float) i13, (float) measuredHeight, this.mNormalBackgroundPaint);
            }
            canvas.restore();
        }
        String obj = getText().toString();
        for (int i14 = 0; i14 < obj.length(); i14++) {
            canvas.save();
            TextPaint paint = getPaint();
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setColor(getCurrentTextColor());
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            float f11 = fontMetrics.top;
            canvas.drawText(String.valueOf(obj.charAt(i14)), (float) ((paddingLeft * i14) + (this.mPairingCodeMargin * i14) + (paddingLeft / 2)), (((((float) measuredHeight) - fontMetrics.bottom) + f11) / 2.0f) - f11, paint);
            canvas.restore();
        }
        Canvas canvas2 = canvas;
        for (int i15 = 0; i15 < this.mFigures; i15++) {
            canvas.save();
            float f12 = ((float) measuredHeight) - (this.mBottomLineHeight / 2.0f);
            int i16 = (paddingLeft * i15) + (this.mPairingCodeMargin * i15);
            int i17 = paddingLeft + i16;
            if (i15 < this.mCurrentPosition) {
                canvas.drawLine((float) i16, f12, (float) i17, f12, this.mBottomSelectedPaint);
            } else {
                canvas.drawLine((float) i16, f12, (float) i17, f12, this.mBottomNormalPaint);
            }
            canvas.restore();
        }
        boolean isCursorVisible = Build.VERSION.SDK_INT >= 16 ? isCursorVisible() : true;
        if (!this.isCursorShowing && isCursorVisible && this.mCurrentPosition < this.mFigures && hasFocus()) {
            canvas.save();
            int i18 = (this.mCurrentPosition * (this.mPairingCodeMargin + paddingLeft)) + (paddingLeft / 2);
            int i19 = measuredHeight / 4;
            float f13 = (float) i18;
            canvas.drawLine(f13, (float) i19, f13, (float) (measuredHeight - i19), this.mCursorPaint);
            canvas.restore();
        }
    }

    public void onMeasure(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode != 1073741824) {
            size = getScreenWidth(getContext());
        }
        int i13 = this.mPairingCodeMargin;
        int i14 = this.mFigures;
        this.mEachRectLength = (size - (i13 * (i14 - 1))) / i14;
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        if (mode2 != 1073741824) {
            size2 = this.mEachRectLength;
        }
        setMeasuredDimension(size, size2);
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        this.mCurrentPosition = getText().length();
        postInvalidate();
        IPairingCodeInterface.OnPairingCodeChangedListener onPairingCodeChangedListener = this.onCodeChangedListener;
        if (onPairingCodeChangedListener != null) {
            onPairingCodeChangedListener.onPairingCodeChanged(getText(), i11, i12, i13);
        }
    }

    public void setBottomLineHeight(int i11) {
        this.mBottomLineHeight = (float) i11;
        postInvalidate();
    }

    public void setBottomNormalColor(int i11) {
        this.mBottomSelectedColor = getColor(i11);
        postInvalidate();
    }

    public void setBottomSelectedColor(int i11) {
        this.mBottomSelectedColor = getColor(i11);
        postInvalidate();
    }

    public final void setCursorVisible(boolean z11) {
        super.setCursorVisible(z11);
    }

    public void setFigures(int i11) {
        this.mFigures = i11;
        postInvalidate();
    }

    public void setOnPairingCodeChangedListener(IPairingCodeInterface.OnPairingCodeChangedListener onPairingCodeChangedListener) {
        this.onCodeChangedListener = onPairingCodeChangedListener;
    }

    public void setPairingCodeMargin(int i11) {
        this.mPairingCodeMargin = i11;
        postInvalidate();
    }

    public void setSelectedBackgroundColor(int i11) {
        this.mSelectedBackgroundColor = getColor(i11);
        postInvalidate();
    }

    public void showKeyBoard(Context context) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this, 2);
        }
    }

    public PairingCodeEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PairingCodeEditText(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mCurrentPosition = 0;
        this.mEachRectLength = 0;
        initAttrs();
        setBackgroundColor(getColor(17170445));
        initPaint();
        initCursorTimer();
        setFocusableInTouchMode(true);
        setSelection(getText().length());
        requestFocus();
        super.addTextChangedListener(this);
    }
}
