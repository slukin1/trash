package com.huobi.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.core.content.res.ResourcesCompat;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.hbg.lib.common.utils.PixelUtils;
import com.huobi.R$styleable;
import java.util.Timer;
import java.util.TimerTask;
import pro.huobi.R;

public class PasswordView extends View {
    private static String CIPHER_TEXT = "*";
    private int borderColor;
    private int borderWidth;
    private boolean cipherEnable;
    private int cipherTextSize;
    private int cursorColor;
    private long cursorFlashTime;
    private int cursorHeight;
    private int cursorPosition;
    private int cursorWidth;
    private InputMethodManager inputManager;
    private boolean isCursorEnable;
    /* access modifiers changed from: private */
    public boolean isCursorShowing;
    /* access modifiers changed from: private */
    public boolean isInputComplete;
    private OnClickedListener mClickedListener;
    private Mode mode;
    private Paint paint;
    /* access modifiers changed from: private */
    public String[] password;
    private int passwordLength;
    /* access modifiers changed from: private */
    public PasswordListener passwordListener;
    private int passwordPadding;
    private int passwordSize;
    private float rectfRadius;
    private Timer timer;
    private TimerTask timerTask;

    public enum Mode {
        UNDERLINE(0),
        RECT(1);
        
        private int mode;

        private Mode(int i11) {
            this.mode = i11;
        }

        public static Mode formMode(int i11) {
            for (Mode mode2 : values()) {
                if (i11 == mode2.mode) {
                    return mode2;
                }
            }
            throw new IllegalArgumentException();
        }

        public int getMode() {
            return this.mode;
        }
    }

    public class MyKeyListener implements View.OnKeyListener {
        public MyKeyListener() {
        }

        public boolean onKey(View view, int i11, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                if (i11 == 67) {
                    if (TextUtils.isEmpty(PasswordView.this.password[0])) {
                        return true;
                    }
                    String access$200 = PasswordView.this.delete();
                    if (PasswordView.this.passwordListener != null && !TextUtils.isEmpty(access$200)) {
                        PasswordView.this.passwordListener.passwordChange(access$200);
                    }
                    PasswordView.this.postInvalidate();
                    return true;
                } else if (i11 < 7 || i11 > 16) {
                    if (i11 == 66) {
                        if (PasswordView.this.passwordListener != null) {
                            PasswordView.this.passwordListener.keyEnterPress(PasswordView.this.getPassword(), PasswordView.this.isInputComplete);
                        }
                        return true;
                    }
                } else if (PasswordView.this.isInputComplete) {
                    return true;
                } else {
                    PasswordView passwordView = PasswordView.this;
                    String access$500 = passwordView.add((i11 - 7) + "");
                    if (PasswordView.this.passwordListener != null && !TextUtils.isEmpty(access$500)) {
                        PasswordView.this.passwordListener.passwordChange(access$500);
                    }
                    PasswordView.this.postInvalidate();
                    return true;
                }
            }
            return false;
        }
    }

    public interface OnClickedListener {
        void onClick();
    }

    public interface PasswordListener {
        void keyEnterPress(String str, boolean z11);

        void passwordChange(String str);

        void passwordComplete(String str);
    }

    public PasswordView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public String add(String str) {
        int i11 = this.cursorPosition;
        int i12 = this.passwordLength;
        if (i11 >= i12) {
            return null;
        }
        this.password[i11] = str;
        int i13 = i11 + 1;
        this.cursorPosition = i13;
        if (i13 != i12) {
            return str;
        }
        this.isInputComplete = true;
        PasswordListener passwordListener2 = this.passwordListener;
        if (passwordListener2 == null) {
            return str;
        }
        passwordListener2.passwordComplete(getPassword());
        return str;
    }

    /* access modifiers changed from: private */
    public String delete() {
        String str;
        int i11 = this.cursorPosition;
        String str2 = null;
        if (i11 > 0) {
            String[] strArr = this.password;
            str = strArr[i11 - 1];
            strArr[i11 - 1] = null;
            this.cursorPosition = i11 - 1;
        } else {
            if (i11 == 0) {
                String[] strArr2 = this.password;
                str = strArr2[i11];
                strArr2[i11] = null;
            }
            this.isInputComplete = false;
            return str2;
        }
        str2 = str;
        this.isInputComplete = false;
        return str2;
    }

    private int dp2px(float f11) {
        return (int) ((f11 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void drawCipherText(Canvas canvas, Paint paint2) {
        paint2.setColor(getResources().getColor(R.color.global_main_text_color));
        paint2.setTextSize((float) this.cipherTextSize);
        paint2.setTypeface(ResourcesCompat.h(getContext(), R.font.roboto_medium));
        paint2.setTextAlign(Paint.Align.CENTER);
        paint2.setStyle(Paint.Style.FILL);
        Rect rect = new Rect();
        canvas.getClipBounds(rect);
        int height = rect.height();
        String str = CIPHER_TEXT;
        int i11 = 0;
        paint2.getTextBounds(str, 0, str.length(), rect);
        float height2 = (((((float) height) / 2.0f) + (((float) rect.height()) / 2.0f)) - ((float) rect.bottom)) - 10.0f;
        while (true) {
            String[] strArr = this.password;
            if (i11 < strArr.length) {
                if (!TextUtils.isEmpty(strArr[i11])) {
                    if (this.cipherEnable) {
                        String str2 = CIPHER_TEXT;
                        int paddingLeft = getPaddingLeft();
                        int i12 = this.passwordSize;
                        canvas.drawText(str2, (float) (paddingLeft + (i12 / 2) + ((i12 + this.passwordPadding) * i11)), ((float) getPaddingTop()) + height2, paint2);
                    } else {
                        String str3 = this.password[i11];
                        int paddingLeft2 = getPaddingLeft();
                        int i13 = this.passwordSize;
                        canvas.drawText(str3, (float) (paddingLeft2 + (i13 / 2) + ((i13 + this.passwordPadding) * i11)), ((float) getPaddingTop()) + height2, paint2);
                    }
                }
                i11++;
            } else {
                return;
            }
        }
    }

    private void drawCursor(Canvas canvas, Paint paint2) {
        paint2.setColor(this.cursorColor);
        paint2.setStrokeWidth((float) this.cursorWidth);
        paint2.setStyle(Paint.Style.FILL);
        if (!this.isCursorShowing && this.isCursorEnable && !this.isInputComplete && hasFocus()) {
            int paddingLeft = getPaddingLeft();
            int i11 = this.passwordSize;
            float f11 = (float) (paddingLeft + (i11 / 2) + ((i11 + this.passwordPadding) * this.cursorPosition));
            float paddingTop = (float) (getPaddingTop() + ((this.passwordSize - this.cursorHeight) / 2));
            int paddingLeft2 = getPaddingLeft();
            int i12 = this.passwordSize;
            canvas.drawLine(f11, paddingTop, (float) (paddingLeft2 + (i12 / 2) + ((i12 + this.passwordPadding) * this.cursorPosition)), (float) (getPaddingTop() + ((this.passwordSize + this.cursorHeight) / 2)), paint2);
        }
        paint2.setColor(getResources().getColor(R.color.global_small_area_bg_color));
        paint2.setStrokeWidth((float) dp2px(4.0f));
        paint2.setStyle(Paint.Style.FILL);
        float paddingLeft3 = (float) (getPaddingLeft() + ((this.passwordSize + this.passwordPadding) * this.cursorPosition));
        float paddingTop2 = (float) (getPaddingTop() + this.passwordSize);
        int paddingLeft4 = getPaddingLeft();
        int i13 = this.passwordSize;
        canvas.drawLine(paddingLeft3, paddingTop2, (float) (paddingLeft4 + ((this.passwordPadding + i13) * this.cursorPosition) + i13), (float) (getPaddingTop() + this.passwordSize), paint2);
    }

    private void drawRect(Canvas canvas, Paint paint2) {
        paint2.setColor(this.borderColor);
        paint2.setStrokeWidth(0.0f);
        paint2.setStyle(Paint.Style.STROKE);
        RectF rectF = new RectF();
        for (int i11 = 0; i11 < this.passwordLength; i11++) {
            int paddingLeft = getPaddingLeft() + ((this.passwordSize + this.passwordPadding) * i11);
            int paddingTop = getPaddingTop();
            int paddingLeft2 = getPaddingLeft();
            int i12 = this.passwordSize;
            rectF.set((float) paddingLeft, (float) paddingTop, (float) (paddingLeft2 + ((this.passwordPadding + i12) * i11) + i12), (float) (getPaddingTop() + this.passwordSize));
            float f11 = this.rectfRadius;
            canvas.drawRoundRect(rectF, f11, f11, paint2);
        }
    }

    private void drawUnderLine(Canvas canvas, Paint paint2) {
        paint2.setColor(this.borderColor);
        paint2.setStrokeWidth((float) this.borderWidth);
        paint2.setStyle(Paint.Style.FILL);
        for (int i11 = 0; i11 < this.passwordLength; i11++) {
            float paddingLeft = (float) (getPaddingLeft() + ((this.passwordSize + this.passwordPadding) * i11));
            float paddingTop = (float) (getPaddingTop() + this.passwordSize);
            int paddingLeft2 = getPaddingLeft();
            int i12 = this.passwordSize;
            canvas.drawLine(paddingLeft, paddingTop, (float) (paddingLeft2 + ((this.passwordPadding + i12) * i11) + i12), (float) (getPaddingTop() + this.passwordSize), paint2);
        }
    }

    private void init() {
        setFocusable(true);
        setFocusableInTouchMode(true);
        setOnKeyListener(new MyKeyListener());
        this.inputManager = (InputMethodManager) getContext().getSystemService("input_method");
        Paint paint2 = new Paint();
        this.paint = paint2;
        paint2.setAntiAlias(true);
        this.timerTask = new TimerTask() {
            public void run() {
                PasswordView passwordView = PasswordView.this;
                boolean unused = passwordView.isCursorShowing = !passwordView.isCursorShowing;
                PasswordView.this.postInvalidate();
            }
        };
        this.timer = new Timer();
    }

    private void readAttribute(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.PasswordView);
            Mode mode2 = Mode.UNDERLINE;
            this.mode = Mode.formMode(obtainStyledAttributes.getInteger(6, mode2.getMode()));
            this.passwordLength = obtainStyledAttributes.getInteger(7, 6);
            this.cursorFlashTime = (long) obtainStyledAttributes.getInteger(4, 500);
            this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(1, dp2px(2.0f));
            this.borderColor = obtainStyledAttributes.getColor(0, getResources().getColor(R.color.eButtonUnenabledBgColor));
            this.cursorColor = obtainStyledAttributes.getColor(3, getResources().getColor(R.color.baseColorMajorTheme100));
            this.isCursorEnable = obtainStyledAttributes.getBoolean(5, true);
            if (this.mode == mode2) {
                this.passwordPadding = obtainStyledAttributes.getDimensionPixelSize(8, dp2px(15.0f));
            } else {
                this.passwordPadding = obtainStyledAttributes.getDimensionPixelSize(8, dp2px(0.0f));
            }
            this.cipherEnable = obtainStyledAttributes.getBoolean(2, false);
            obtainStyledAttributes.recycle();
        } else {
            this.mode = Mode.UNDERLINE;
            this.passwordLength = 6;
            this.cursorFlashTime = 500;
            this.borderWidth = dp2px(2.0f);
            this.borderColor = getResources().getColor(R.color.eButtonUnenabledBgColor);
            this.cursorColor = getResources().getColor(R.color.baseColorMajorTheme100);
            this.isCursorEnable = true;
            this.passwordPadding = dp2px(15.0f);
            this.cipherEnable = false;
        }
        this.password = new String[this.passwordLength];
        this.rectfRadius = (float) PixelUtils.a(2.0f);
        init();
    }

    private int sp2px(float f11) {
        return (int) ((f11 * getContext().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public void clearPassword() {
        this.isInputComplete = false;
        this.password = new String[this.passwordLength];
        this.cursorPosition = 0;
        postInvalidate();
    }

    public Mode getMode() {
        return this.mode;
    }

    public String getPassword() {
        StringBuilder sb2 = new StringBuilder();
        for (String str : this.password) {
            if (!TextUtils.isEmpty(str)) {
                sb2.append(str);
            }
        }
        return sb2.toString();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.timer == null) {
            this.timer = new Timer();
        }
        this.timer.scheduleAtFixedRate(this.timerTask, 0, this.cursorFlashTime);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        editorInfo.inputType = 2;
        return super.onCreateInputConnection(editorInfo);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.timer.purge();
        this.timer = null;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mode == Mode.UNDERLINE) {
            drawUnderLine(canvas, this.paint);
        } else {
            drawRect(canvas, this.paint);
        }
        drawCursor(canvas, this.paint);
        drawCipherText(canvas, this.paint);
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        int mode2 = View.MeasureSpec.getMode(i11);
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            int i14 = this.passwordSize;
            int i15 = this.passwordLength;
            i13 = (i14 * i15) + (this.passwordPadding * (i15 - 1));
        } else if (mode2 != 1073741824) {
            i13 = 0;
        } else {
            i13 = View.MeasureSpec.getSize(i11);
            int i16 = this.passwordPadding;
            int i17 = this.passwordLength;
            this.passwordSize = (i13 - (i16 * (i17 - 1))) / i17;
        }
        setMeasuredDimension(i13, this.passwordSize);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.password = bundle.getStringArray(MTCoreConstants.Register.KEY_PASSWORD);
            this.cursorPosition = bundle.getInt("cursorPosition");
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        bundle.putStringArray(MTCoreConstants.Register.KEY_PASSWORD, this.password);
        bundle.putInt("cursorPosition", this.cursorPosition);
        return bundle;
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.cipherTextSize = dp2px(30.0f);
        this.cursorWidth = dp2px(4.0f);
        this.cursorHeight = dp2px(31.0f);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return super.onTouchEvent(motionEvent);
        }
        requestFocus();
        this.inputManager.showSoftInput(this, 2);
        return true;
    }

    public void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
        if (!z11) {
            this.inputManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    public void setCipherEnable(boolean z11) {
        this.cipherEnable = z11;
        postInvalidate();
    }

    public void setCursorColor(int i11) {
        this.cursorColor = i11;
        postInvalidate();
    }

    public void setCursorEnable(boolean z11) {
        this.isCursorEnable = z11;
        postInvalidate();
    }

    public void setMode(Mode mode2) {
        this.mode = mode2;
        postInvalidate();
    }

    public void setOnClickListener(final OnClickedListener onClickedListener) {
        setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 1) {
                    return false;
                }
                onClickedListener.onClick();
                return false;
            }
        });
    }

    public void setPasswordLength(int i11) {
        this.passwordLength = i11;
        postInvalidate();
    }

    public void setPasswordListener(PasswordListener passwordListener2) {
        this.passwordListener = passwordListener2;
    }

    public void setPasswordSize(int i11) {
        this.passwordSize = i11;
        postInvalidate();
    }

    public PasswordView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.passwordSize = dp2px(44.0f);
        readAttribute(attributeSet);
    }

    public PasswordView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.passwordSize = dp2px(44.0f);
        readAttribute(attributeSet);
    }

    public PasswordView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.passwordSize = dp2px(44.0f);
        readAttribute(attributeSet);
    }
}
