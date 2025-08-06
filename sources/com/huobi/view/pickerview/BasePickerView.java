package com.huobi.view.pickerview;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.huobi.view.pickerview.listener.OnDismissListener;
import com.huobi.view.pickerview.util.PickerViewAnimateUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;

public class BasePickerView {
    public int animGravity = 80;
    public View clickView;
    public ViewGroup contentContainer;
    private Context context;
    private ViewGroup dialogView;
    private boolean dismissing;
    private Animation inAnim;
    private boolean isAnim = true;
    private boolean isShowing;
    private Dialog mDialog;
    public PickerOptions mPickerOptions;
    private final View.OnTouchListener onCancelableTouchListener = new d(this);
    private OnDismissListener onDismissListener;
    private View.OnKeyListener onKeyBackListener = new c(this);
    private Animation outAnim;
    private ViewGroup rootView;

    public BasePickerView(Context context2) {
        this.context = context2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$createDialog$4(DialogInterface dialogInterface) {
        OnDismissListener onDismissListener2 = this.onDismissListener;
        if (onDismissListener2 != null) {
            onDismissListener2.onDismiss(this);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$dismissImmediately$1() {
        this.mPickerOptions.decorView.removeView(this.rootView);
        this.isShowing = false;
        this.dismissing = false;
        OnDismissListener onDismissListener2 = this.onDismissListener;
        if (onDismissListener2 != null) {
            onDismissListener2.onDismiss(this);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initViews$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$2(View view, int i11, KeyEvent keyEvent) {
        if (i11 != 4 || keyEvent.getAction() != 0 || !isShowing()) {
            return false;
        }
        dismiss();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$3(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        dismiss();
        return false;
    }

    private void onAttached(View view) {
        this.mPickerOptions.decorView.addView(view);
        if (this.isAnim) {
            this.contentContainer.startAnimation(this.inAnim);
        }
    }

    public void createDialog() {
        if (this.dialogView != null) {
            Dialog dialog = new Dialog(this.context, R.style.dialog_btg_progress);
            this.mDialog = dialog;
            dialog.setCancelable(this.mPickerOptions.cancelable);
            this.mDialog.setContentView(this.dialogView);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(2132083305);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new a(this));
        }
    }

    public void dismiss() {
        if (isDialog()) {
            dismissDialog();
        } else if (!this.dismissing) {
            if (this.isAnim) {
                this.outAnim.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationEnd(Animation animation) {
                        BasePickerView.this.dismissImmediately();
                    }

                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }
                });
                this.contentContainer.startAnimation(this.outAnim);
            } else {
                dismissImmediately();
            }
            this.dismissing = true;
        }
    }

    public void dismissDialog() {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void dismissImmediately() {
        this.mPickerOptions.decorView.post(new e(this));
    }

    public View findViewById(int i11) {
        return this.contentContainer.findViewById(i11);
    }

    public Animation getInAnimation() {
        return AnimationUtils.loadAnimation(this.context, PickerViewAnimateUtil.getAnimationResource(this.animGravity, true));
    }

    public Animation getOutAnimation() {
        return AnimationUtils.loadAnimation(this.context, PickerViewAnimateUtil.getAnimationResource(this.animGravity, false));
    }

    public void initAnim() {
        this.inAnim = getInAnimation();
        this.outAnim = getOutAnimation();
    }

    public void initEvents() {
    }

    public void initViews() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        LayoutInflater from = LayoutInflater.from(this.context);
        if (isDialog()) {
            ViewGroup viewGroup = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.dialogView = viewGroup;
            viewGroup.setBackgroundColor(0);
            ViewGroup viewGroup2 = (ViewGroup) this.dialogView.findViewById(R.id.content_container);
            this.contentContainer = viewGroup2;
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            viewGroup2.setLayoutParams(layoutParams);
            createDialog();
            this.dialogView.setOnClickListener(new b(this));
        } else {
            PickerOptions pickerOptions = this.mPickerOptions;
            if (pickerOptions.decorView == null) {
                pickerOptions.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            ViewGroup viewGroup3 = (ViewGroup) from.inflate(R.layout.layout_basepickerview, this.mPickerOptions.decorView, false);
            this.rootView = viewGroup3;
            viewGroup3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            int i11 = this.mPickerOptions.backgroundId;
            if (i11 != -1) {
                this.rootView.setBackgroundColor(i11);
            }
            ViewGroup viewGroup4 = (ViewGroup) this.rootView.findViewById(R.id.content_container);
            this.contentContainer = viewGroup4;
            viewGroup4.setLayoutParams(layoutParams);
        }
        setKeyBackCancelable(true);
    }

    public boolean isDialog() {
        return false;
    }

    public boolean isShowing() {
        if (isDialog()) {
            return false;
        }
        if (this.rootView.getParent() != null || this.isShowing) {
            return true;
        }
        return false;
    }

    public void setDialogOutSideCancelable() {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.setCancelable(this.mPickerOptions.cancelable);
        }
    }

    public void setKeyBackCancelable(boolean z11) {
        ViewGroup viewGroup;
        if (isDialog()) {
            viewGroup = this.dialogView;
        } else {
            viewGroup = this.rootView;
        }
        viewGroup.setFocusable(z11);
        viewGroup.setFocusableInTouchMode(z11);
        if (z11) {
            viewGroup.setOnKeyListener(this.onKeyBackListener);
        } else {
            viewGroup.setOnKeyListener((View.OnKeyListener) null);
        }
    }

    public BasePickerView setOnDismissListener(OnDismissListener onDismissListener2) {
        this.onDismissListener = onDismissListener2;
        return this;
    }

    public BasePickerView setOutSideCancelable(boolean z11) {
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            View findViewById = viewGroup.findViewById(R.id.outmost_container);
            if (z11) {
                findViewById.setOnTouchListener(this.onCancelableTouchListener);
            } else {
                findViewById.setOnTouchListener((View.OnTouchListener) null);
            }
        }
        return this;
    }

    public void show(View view, boolean z11) {
        this.clickView = view;
        this.isAnim = z11;
        show();
    }

    public void showDialog() {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.show();
        }
    }

    public void show(boolean z11) {
        this.isAnim = z11;
        show();
    }

    public void show(View view) {
        this.clickView = view;
        show();
    }

    public void show() {
        if (isDialog()) {
            showDialog();
        } else if (!isShowing()) {
            this.isShowing = true;
            onAttached(this.rootView);
            this.rootView.requestFocus();
        }
    }
}
