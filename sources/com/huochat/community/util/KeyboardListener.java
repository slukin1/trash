package com.huochat.community.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;

public class KeyboardListener {
    /* access modifiers changed from: private */
    public OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener;
    /* access modifiers changed from: private */
    public View rootView;
    public int rootViewVisibleHeight;

    public interface OnSoftKeyBoardChangeListener {
        void keyBoardHide(int i11);

        void keyBoardShow(int i11);
    }

    public KeyboardListener(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        this.rootView = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                Rect rect = new Rect();
                KeyboardListener.this.rootView.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                KeyboardListener keyboardListener = KeyboardListener.this;
                int i11 = keyboardListener.rootViewVisibleHeight;
                if (i11 == 0) {
                    keyboardListener.rootViewVisibleHeight = height;
                } else if (i11 != height) {
                    if (i11 - height > 200) {
                        if (keyboardListener.onSoftKeyBoardChangeListener != null) {
                            KeyboardListener.this.onSoftKeyBoardChangeListener.keyBoardShow(KeyboardListener.this.rootViewVisibleHeight - height);
                        }
                        KeyboardListener.this.rootViewVisibleHeight = height;
                    } else if (height - i11 > 200) {
                        if (keyboardListener.onSoftKeyBoardChangeListener != null) {
                            KeyboardListener.this.onSoftKeyBoardChangeListener.keyBoardHide(height - KeyboardListener.this.rootViewVisibleHeight);
                        }
                        KeyboardListener.this.rootViewVisibleHeight = height;
                    }
                }
            }
        });
    }

    public static void setListener(Activity activity, OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener2) {
        new KeyboardListener(activity).setOnSoftKeyBoardChangeListener(onSoftKeyBoardChangeListener2);
    }

    private void setOnSoftKeyBoardChangeListener(OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener2) {
        this.onSoftKeyBoardChangeListener = onSoftKeyBoardChangeListener2;
    }
}
