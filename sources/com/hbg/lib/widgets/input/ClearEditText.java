package com.hbg.lib.widgets.input;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import com.hbg.lib.widgets.R$drawable;
import com.hbg.lib.widgets.R$string;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.utils.EditTextUtil;

public class ClearEditText extends EditText implements View.OnFocusChangeListener, TextWatcher {
    private a clearEditTextOnFocusChangeListener;
    private boolean copyStatus;
    private boolean hasFoucs;
    private Drawable mClearDrawable;
    private b mOnTextChangedListener;

    public interface a {
        void a(View view, boolean z11);
    }

    public interface b {
        void a(CharSequence charSequence, int i11, int i12, int i13);
    }

    public ClearEditText(Context context) {
        this(context, (AttributeSet) null);
    }

    private void init() {
        Drawable drawable = getCompoundDrawables()[2];
        this.mClearDrawable = drawable;
        if (drawable == null) {
            this.mClearDrawable = getResources().getDrawable(R$drawable.btn_clear_input_selector);
        }
        Drawable drawable2 = this.mClearDrawable;
        drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.mClearDrawable.getIntrinsicHeight());
        setClearIconVisible(false);
        setOnFocusChangeListener(this);
        addTextChangedListener(this);
    }

    public static Animation shakeAnimation(int i11) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 10.0f, 0.0f, 0.0f);
        translateAnimation.setInterpolator(new CycleInterpolator((float) i11));
        translateAnimation.setDuration(1000);
        return translateAnimation;
    }

    public void afterTextChanged(Editable editable) {
        EditTextUtil.a(this);
    }

    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }

    public void onFocusChange(View view, boolean z11) {
        this.hasFoucs = z11;
        boolean z12 = false;
        if (z11) {
            if (getText().length() > 0) {
                z12 = true;
            }
            setClearIconVisible(z12);
        } else {
            setClearIconVisible(false);
        }
        a aVar = this.clearEditTextOnFocusChangeListener;
        if (aVar != null) {
            aVar.a(view, z11);
        }
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        if (this.hasFoucs) {
            setClearIconVisible(charSequence.length() > 0);
        }
        b bVar = this.mOnTextChangedListener;
        if (bVar != null) {
            bVar.a(charSequence, i11, i12, i13);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z11 = true;
        if (motionEvent.getAction() == 1 && getCompoundDrawables()[2] != null) {
            if (motionEvent.getX() <= ((float) (getWidth() - getTotalPaddingRight())) || motionEvent.getX() >= ((float) (getWidth() - getPaddingRight()))) {
                z11 = false;
            }
            if (z11) {
                if (this.copyStatus) {
                    String obj = getText().toString();
                    ((ClipboardManager) getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(obj, obj));
                    HuobiToastUtil.s(R$string.security_ga_key_already_copy);
                } else {
                    setText("");
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setClearEditTextOnFocusChangeListener(a aVar) {
        this.clearEditTextOnFocusChangeListener = aVar;
    }

    public void setClearIcon(boolean z11) {
        if (z11) {
            this.mClearDrawable = getResources().getDrawable(R$drawable.btn_clear_input_copy);
        } else {
            this.mClearDrawable = getResources().getDrawable(R$drawable.btn_clear_input_selector);
        }
        Drawable drawable = this.mClearDrawable;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.mClearDrawable.getIntrinsicHeight());
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.mClearDrawable, getCompoundDrawables()[3]);
        if (this.copyStatus) {
            setClearIconVisible(true);
        } else {
            setClearIconVisible(false);
        }
    }

    public void setClearIconVisible(boolean z11) {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], z11 ? this.mClearDrawable : null, getCompoundDrawables()[3]);
    }

    public void setCopyStatus(boolean z11) {
        this.copyStatus = z11;
        setClearIcon(z11);
    }

    public void setOnTextChangedListener(b bVar) {
        this.mOnTextChangedListener = bVar;
    }

    public void setShakeAnimation() {
        setAnimation(shakeAnimation(5));
    }

    public ClearEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842862);
    }

    public ClearEditText(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.copyStatus = false;
        init();
    }
}
