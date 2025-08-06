package com.huobi.view.keyboard;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;

public class HuobiKeyboardHelper {
    public CustomBoardView boardView;

    public HuobiKeyboardHelper attach(Activity activity) {
        return attach(activity, (FrameLayout) activity.findViewById(16908290));
    }

    public CustomBoardView findKeyboard(ViewGroup viewGroup) {
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if (childAt instanceof CustomBoardView) {
                return (CustomBoardView) childAt;
            }
        }
        return null;
    }

    public CustomBoardView getBoardView() {
        return this.boardView;
    }

    public void hideKeyboard() {
        CustomBoardView customBoardView = this.boardView;
        if (customBoardView != null) {
            customBoardView.hideKeyboardLayout();
        }
    }

    public boolean isKeyboardShowing() {
        CustomBoardView customBoardView = this.boardView;
        if (customBoardView != null) {
            return customBoardView.keyboardVisible();
        }
        return false;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public HuobiKeyboardHelper registerInput(EditText... editTextArr) {
        for (EditText onTouchListener : editTextArr) {
            onTouchListener.setOnTouchListener(new KeyboardTouchListener(this.boardView, 3, -1));
        }
        return this;
    }

    public void showKeyboard(EditText editText) {
        CustomBoardView customBoardView = this.boardView;
        if (customBoardView != null) {
            customBoardView.showKeyBoardLayout(editText, 3);
        }
    }

    public HuobiKeyboardHelper attach(Activity activity, ViewGroup viewGroup) {
        CustomBoardView findKeyboard = findKeyboard(viewGroup);
        this.boardView = findKeyboard;
        if (findKeyboard == null) {
            CustomBoardView customBoardView = new CustomBoardView(activity);
            this.boardView = customBoardView;
            customBoardView.setGravity(80);
            this.boardView.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            viewGroup.addView(this.boardView, layoutParams);
        }
        return this;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public HuobiKeyboardHelper registerInput(EditText editText, View.OnTouchListener onTouchListener) {
        editText.setOnTouchListener(new KeyboardTouchListener(this.boardView, 3, -1, onTouchListener));
        return this;
    }
}
