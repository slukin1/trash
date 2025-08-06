package com.huobi.view;

import android.view.View;
import android.widget.PopupWindow;
import i6.j;

public class HbgPopupWindow extends PopupWindow {
    public HbgPopupWindow() {
    }

    public void dismiss() {
        super.dismiss();
        j.c(this);
    }

    public void showAsDropDown(View view) {
        super.showAsDropDown(view);
        j.a(this);
    }

    public void showAtLocation(View view, int i11, int i12, int i13) {
        super.showAtLocation(view, i11, i12, i13);
        j.a(this);
    }

    public HbgPopupWindow(View view, int i11, int i12) {
        super(view, i11, i12);
    }

    public void showAsDropDown(View view, int i11, int i12) {
        super.showAsDropDown(view, i11, i12);
        j.a(this);
    }

    public void showAsDropDown(View view, int i11, int i12, int i13) {
        super.showAsDropDown(view, i11, i12, i13);
        j.a(this);
    }
}
