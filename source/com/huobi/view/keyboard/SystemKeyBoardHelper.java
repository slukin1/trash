package com.huobi.view.keyboard;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import com.hbg.lib.common.utils.SoftInputUtils;

public class SystemKeyBoardHelper extends HuobiKeyboardHelper {
    private Activity activity;

    public HuobiKeyboardHelper attach(Activity activity2) {
        this.activity = activity2;
        return this;
    }

    public void hideKeyboard() {
        SoftInputUtils.f(this.activity);
    }

    public boolean isKeyboardShowing() {
        return SoftInputUtils.h(this.activity);
    }

    public HuobiKeyboardHelper registerInput(EditText editText, View.OnTouchListener onTouchListener) {
        return this;
    }

    public HuobiKeyboardHelper registerInput(EditText... editTextArr) {
        return this;
    }

    public void showKeyboard(EditText editText) {
        SoftInputUtils.m(this.activity, editText);
    }
}
