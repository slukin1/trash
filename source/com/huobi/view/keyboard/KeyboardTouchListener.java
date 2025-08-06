package com.huobi.view.keyboard;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.hbg.lib.common.utils.SoftInputUtils;

public class KeyboardTouchListener implements View.OnTouchListener {
    private CustomBoardView keyBoardView;
    private int keyboardType = 1;
    private View.OnTouchListener onTouchListener;
    private int scrollTo = -1;

    public KeyboardTouchListener(CustomBoardView customBoardView, int i11, int i12) {
        this.keyBoardView = customBoardView;
        this.keyboardType = i11;
        this.scrollTo = i12;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener2;
        if (motionEvent.getAction() != 1 || ((onTouchListener2 = this.onTouchListener) != null && onTouchListener2.onTouch(view, motionEvent))) {
            return false;
        }
        if (view instanceof EditText) {
            CustomBoardView customBoardView = this.keyBoardView;
            if (customBoardView != null) {
                customBoardView.showKeyBoardLayout((EditText) view, this.keyboardType);
            }
        } else {
            SoftInputUtils.l((EditText) view, view.getContext());
        }
        return false;
    }

    public KeyboardTouchListener(CustomBoardView customBoardView, int i11, int i12, View.OnTouchListener onTouchListener2) {
        this.keyBoardView = customBoardView;
        this.keyboardType = i11;
        this.scrollTo = i12;
        this.onTouchListener = onTouchListener2;
    }
}
