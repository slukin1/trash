package com.huobi.view.wheelpicker;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.hbg.lib.common.utils.PixelUtils;

public abstract class BasicPopup<V extends View> implements DialogInterface.OnKeyListener, DialogInterface.OnDismissListener {
    public static final int MATCH_PARENT = -1;
    public static final int WRAP_CONTENT = -2;
    public Activity activity;
    private FrameLayout contentLayout;
    private Dialog dialog;
    private boolean isPrepared = false;
    public int screenHeightPixels;
    public int screenWidthPixels;

    public BasicPopup(Activity activity2) {
        this.activity = activity2;
        this.screenWidthPixels = PixelUtils.g();
        this.screenHeightPixels = PixelUtils.f();
        initDialog();
    }

    private void initDialog() {
        FrameLayout frameLayout = new FrameLayout(this.activity);
        this.contentLayout = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.contentLayout.setFocusable(true);
        this.contentLayout.setFocusableInTouchMode(true);
        Dialog dialog2 = new Dialog(this.activity);
        this.dialog = dialog2;
        dialog2.setCanceledOnTouchOutside(true);
        this.dialog.setCancelable(true);
        this.dialog.setOnKeyListener(this);
        this.dialog.setOnDismissListener(this);
        Window window = this.dialog.getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.requestFeature(1);
            window.setContentView(this.contentLayout);
        }
        setSize(this.screenWidthPixels, -2);
    }

    public void dismiss() {
        this.dialog.dismiss();
    }

    public View getContentView() {
        return this.contentLayout.getChildAt(0);
    }

    public Context getContext() {
        return this.dialog.getContext();
    }

    public ViewGroup getRootView() {
        return this.contentLayout;
    }

    public int getScreenHeightPixels() {
        return this.screenHeightPixels;
    }

    public int getScreenWidthPixels() {
        return this.screenWidthPixels;
    }

    public Window getWindow() {
        return this.dialog.getWindow();
    }

    public boolean isShowing() {
        return this.dialog.isShowing();
    }

    public abstract V makeContentView();

    public void onDismiss(DialogInterface dialogInterface) {
        dismiss();
    }

    public final boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            return onKeyDown(i11, keyEvent);
        }
        return false;
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        return false;
    }

    public void setAnimationStyle(int i11) {
        Window window = this.dialog.getWindow();
        if (window != null) {
            window.setWindowAnimations(i11);
        }
    }

    public void setContentView(View view) {
        this.contentLayout.removeAllViews();
        this.contentLayout.addView(view);
    }

    public void setContentViewAfter(V v11) {
    }

    public void setContentViewBefore() {
    }

    public void setFillScreen(boolean z11) {
        if (z11) {
            setSize(this.screenWidthPixels, (int) (((float) this.screenHeightPixels) * 0.85f));
        }
    }

    public void setGravity(int i11) {
        Window window = this.dialog.getWindow();
        if (window != null) {
            window.setGravity(i11);
        }
        if (i11 == 17) {
            setWidth((int) (((float) this.screenWidthPixels) * 0.7f));
        }
    }

    public void setHalfScreen(boolean z11) {
        if (z11) {
            setSize(this.screenWidthPixels, this.screenHeightPixels / 2);
        }
    }

    public void setHeight(int i11) {
        setSize(0, i11);
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.dialog.setOnDismissListener(onDismissListener);
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.dialog.setOnKeyListener(onKeyListener);
    }

    public void setPrepared(boolean z11) {
        this.isPrepared = z11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
        if (r3 == 0) goto L_0x000c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setSize(int r2, int r3) {
        /*
            r1 = this;
            r0 = -1
            if (r2 != r0) goto L_0x0005
            int r2 = r1.screenWidthPixels
        L_0x0005:
            r0 = -2
            if (r2 != 0) goto L_0x000e
            if (r3 != 0) goto L_0x000e
            int r2 = r1.screenWidthPixels
        L_0x000c:
            r3 = r0
            goto L_0x0016
        L_0x000e:
            if (r2 != 0) goto L_0x0013
            int r2 = r1.screenWidthPixels
            goto L_0x0016
        L_0x0013:
            if (r3 != 0) goto L_0x0016
            goto L_0x000c
        L_0x0016:
            android.widget.FrameLayout r0 = r1.contentLayout
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            if (r0 != 0) goto L_0x0024
            android.view.ViewGroup$LayoutParams r0 = new android.view.ViewGroup$LayoutParams
            r0.<init>(r2, r3)
            goto L_0x0028
        L_0x0024:
            r0.width = r2
            r0.height = r3
        L_0x0028:
            android.widget.FrameLayout r2 = r1.contentLayout
            r2.setLayoutParams(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.view.wheelpicker.BasicPopup.setSize(int, int):void");
    }

    public void setWidth(int i11) {
        setSize(i11, 0);
    }

    public void show() {
        if (this.isPrepared) {
            this.dialog.show();
            return;
        }
        setContentViewBefore();
        View makeContentView = makeContentView();
        setContentView(makeContentView);
        setContentViewAfter(makeContentView);
        this.isPrepared = true;
        this.dialog.show();
    }
}
