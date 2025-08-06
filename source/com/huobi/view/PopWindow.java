package com.huobi.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;

public class PopWindow {
    private PopupWindow mPopupWindow;

    public PopWindow(Context context, View view, int i11) {
        PopupWindow popupWindow = new PopupWindow(view, -1, -1);
        this.mPopupWindow = popupWindow;
        popupWindow.setOutsideTouchable(true);
        this.mPopupWindow.setFocusable(true);
        this.mPopupWindow.update();
        this.mPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
        this.mPopupWindow.setAnimationStyle(16973826);
    }

    public void dismiss() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.mPopupWindow.dismiss();
        }
    }

    public int getWidth() {
        return this.mPopupWindow.getWidth();
    }

    public boolean isShow() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            return popupWindow.isShowing();
        }
        return false;
    }

    public void showAsDropDown(View view) {
        this.mPopupWindow.showAsDropDown(view);
    }

    public void showAtLocation(View view, int i11, int i12, int i13) {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null && !popupWindow.isShowing()) {
            this.mPopupWindow.showAtLocation(view, i11, i12, i13);
        }
    }

    public void showAsDropDown(View view, int i11, int i12) {
        this.mPopupWindow.showAsDropDown(view, i11, i12);
    }

    public PopWindow(Context context, View view) {
        PopupWindow popupWindow = new PopupWindow(view, -2, -2);
        this.mPopupWindow = popupWindow;
        popupWindow.setOutsideTouchable(true);
        this.mPopupWindow.setFocusable(false);
        this.mPopupWindow.update();
        this.mPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
        this.mPopupWindow.setAnimationStyle(16973826);
    }

    public PopWindow(Context context, View view, int i11, int i12) {
        PopupWindow popupWindow = new PopupWindow(view, i11, i12);
        this.mPopupWindow = popupWindow;
        popupWindow.setOutsideTouchable(true);
        this.mPopupWindow.setFocusable(true);
        this.mPopupWindow.update();
        this.mPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
        this.mPopupWindow.setAnimationStyle(16973826);
    }
}
