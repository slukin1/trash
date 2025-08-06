package com.hbg.lib.core.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.hbg.lib.common.mvp.ActivityPresenter;
import u6.g;

public abstract class BaseEditActivity<P extends ActivityPresenter<V>, V extends g> extends BaseActivity<P, V> {

    /* renamed from: b  reason: collision with root package name */
    public EditText f68530b = null;

    public boolean Xf(View view, MotionEvent motionEvent) {
        if (view == null || !(view instanceof EditText)) {
            return false;
        }
        this.f68530b = (EditText) view;
        int[] iArr = {0, 0};
        view.getLocationInWindow(iArr);
        int i11 = iArr[0];
        int i12 = iArr[1];
        int height = view.getHeight() + i12;
        int width = view.getWidth() + i11;
        if (motionEvent.getX() <= ((float) i11) || motionEvent.getX() >= ((float) width) || motionEvent.getY() <= ((float) i12) || motionEvent.getY() >= ((float) height)) {
            return true;
        }
        return false;
    }

    public void closeKeyboard(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return getWindow().superDispatchTouchEvent(motionEvent) || onTouchEvent(motionEvent);
        }
        View currentFocus = getCurrentFocus();
        if (Xf(currentFocus, motionEvent) && ((InputMethodManager) getSystemService("input_method")) != null) {
            closeKeyboard(currentFocus);
            EditText editText = this.f68530b;
            if (editText != null) {
                editText.clearFocus();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
