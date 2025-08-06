package com.huobi.view;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import i6.j;

public class BasePopupWindow extends PopupWindow {
    private Drawable mBackgroundDrawable;
    private Context mContext;
    private float mShowAlpha = 0.88f;
    private PopupWindowBeforeListener popupWindowBeforeListener;
    private PopupWindowListener popupWindowListener;

    public interface PopupWindowBeforeListener {
        void popupWindowBeforeDismiss(PopupWindow popupWindow);
    }

    public interface PopupWindowListener {
        void popupWindowDismiss();

        void popupWindowShow();
    }

    public BasePopupWindow(Context context) {
        this.mContext = context;
        initBasePopupWindow();
    }

    private void addKeyListener(View view) {
        if (view != null) {
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.setOnKeyListener(new View.OnKeyListener() {
                public boolean onKey(View view, int i11, KeyEvent keyEvent) {
                    if (i11 != 4) {
                        return false;
                    }
                    BasePopupWindow.this.dismiss();
                    return true;
                }
            });
        }
    }

    private ValueAnimator dismissAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.mShowAlpha, 1.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BasePopupWindow.this.setWindowBackgroundAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.setDuration(320);
        return ofFloat;
    }

    private void initBasePopupWindow() {
        setAnimationStyle(16973826);
        setHeight(-2);
        setWidth(-2);
        setOutsideTouchable(true);
        setFocusable(true);
    }

    /* access modifiers changed from: private */
    public void setWindowBackgroundAlpha(float f11) {
        Window window = ((Activity) getContext()).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = f11;
        window.setAttributes(attributes);
    }

    private ValueAnimator showAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, this.mShowAlpha});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BasePopupWindow.this.setWindowBackgroundAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.setDuration(360);
        return ofFloat;
    }

    public void dismiss() {
        PopupWindowBeforeListener popupWindowBeforeListener2 = this.popupWindowBeforeListener;
        if (popupWindowBeforeListener2 != null) {
            popupWindowBeforeListener2.popupWindowBeforeDismiss(this);
            return;
        }
        super.dismiss();
        PopupWindowListener popupWindowListener2 = this.popupWindowListener;
        if (popupWindowListener2 != null) {
            popupWindowListener2.popupWindowDismiss();
        }
        j.c(this);
    }

    public Context getContext() {
        return this.mContext;
    }

    public PopupWindowListener getPopupWindowListener() {
        return this.popupWindowListener;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.mBackgroundDrawable = drawable;
        setOutsideTouchable(isOutsideTouchable());
    }

    public void setContentView(View view) {
        if (view != null) {
            view.measure(0, 0);
            super.setContentView(view);
            addKeyListener(view);
        }
    }

    public void setOutsideTouchable(boolean z11) {
        super.setOutsideTouchable(z11);
        if (z11) {
            if (this.mBackgroundDrawable == null) {
                this.mBackgroundDrawable = new ColorDrawable(0);
            }
            super.setBackgroundDrawable(this.mBackgroundDrawable);
            return;
        }
        super.setBackgroundDrawable((Drawable) null);
    }

    public void setPopupWindowBeforeListener(PopupWindowBeforeListener popupWindowBeforeListener2) {
        this.popupWindowBeforeListener = popupWindowBeforeListener2;
    }

    public void setPopupWindowListener(PopupWindowListener popupWindowListener2) {
        this.popupWindowListener = popupWindowListener2;
    }

    public void showAsDropDown(View view) {
        super.showAsDropDown(view);
        PopupWindowListener popupWindowListener2 = this.popupWindowListener;
        if (popupWindowListener2 != null) {
            popupWindowListener2.popupWindowShow();
        }
        j.a(this);
    }

    public void showAtLocation(View view, int i11, int i12, int i13) {
        super.showAtLocation(view, i11, i12, i13);
        PopupWindowListener popupWindowListener2 = this.popupWindowListener;
        if (popupWindowListener2 != null) {
            popupWindowListener2.popupWindowShow();
        }
        j.a(this);
    }

    public void showAsDropDown(View view, int i11, int i12) {
        super.showAsDropDown(view, i11, i12);
        PopupWindowListener popupWindowListener2 = this.popupWindowListener;
        if (popupWindowListener2 != null) {
            popupWindowListener2.popupWindowShow();
        }
        j.a(this);
    }

    public void showAsDropDown(View view, int i11, int i12, int i13) {
        super.showAsDropDown(view, i11, i12, i13);
        PopupWindowListener popupWindowListener2 = this.popupWindowListener;
        if (popupWindowListener2 != null) {
            popupWindowListener2.popupWindowShow();
        }
        j.a(this);
    }
}
