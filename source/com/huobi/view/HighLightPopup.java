package com.huobi.view;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.google.android.material.badge.BadgeDrawable;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.R$style;
import i6.k;

public class HighLightPopup extends PopupWindow {
    private View flContainer;
    public ImageView ivMirror;
    private View target;

    public HighLightPopup(View view) {
        super(view.getContext());
        this.target = view;
        setBackgroundDrawable((Drawable) null);
        setContentView(onCreateView());
        setAnimationStyle(R$style.AnimationGuideLight);
        setFocusable(false);
        setOutsideTouchable(false);
    }

    private View onCreateView() {
        View inflate = LayoutInflater.from(this.target.getContext()).inflate(R$layout.view_bubble_target_mirror, (ViewGroup) null);
        this.flContainer = inflate.findViewById(R$id.fl_container);
        this.ivMirror = (ImageView) inflate.findViewById(R$id.iv_mirror);
        if (this.target.getHeight() == 0 && this.target.getWidth() == 0) {
            k.d("STATE", "target:" + this.target.toString() + " visible:" + this.target.getVisibility());
        } else {
            this.ivMirror.setImageBitmap(ViewUtils.obtainCaptureBitmap(this.target));
        }
        return inflate;
    }

    public void setContainerBg(Drawable drawable) {
        this.flContainer.setBackground(drawable);
    }

    public void setContainerPadding(int i11, int i12, int i13, int i14) {
        this.flContainer.setPadding(i11, i12, i13, i14);
    }

    public void setSizeAndShow(int i11, int i12, int i13, int i14) {
        this.ivMirror.setPadding(i11, i12, i13, i14);
        int[] iArr = new int[2];
        this.target.getLocationInWindow(iArr);
        Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + this.target.getWidth(), iArr[1] + this.target.getHeight());
        showAtLocation(this.target, BadgeDrawable.TOP_START, rect.left - i11, rect.top - i12);
    }

    public void show() {
        int[] iArr = new int[2];
        this.target.getLocationInWindow(iArr);
        Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + this.target.getWidth(), iArr[1] + this.target.getHeight());
        showAtLocation(this.target, BadgeDrawable.TOP_START, rect.left - ((this.flContainer.getPaddingLeft() + this.flContainer.getPaddingRight()) / 2), rect.top - ((this.flContainer.getPaddingTop() + this.flContainer.getPaddingBottom()) / 2));
    }
}
