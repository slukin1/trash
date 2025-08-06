package com.huobi.edgeengine.template.widget.pop;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.huobi.edgeengine.R$style;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;

public class EngineDialogFragment extends DialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public View f44305b;

    /* renamed from: c  reason: collision with root package name */
    public int f44306c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f44307d;

    /* renamed from: e  reason: collision with root package name */
    public PopupWindow.OnDismissListener f44308e;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().requestWindowFeature(1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().setCanceledOnTouchOutside(this.f44307d);
        return this.f44305b;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        PopupWindow.OnDismissListener onDismissListener = this.f44308e;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
    }

    public void onStart() {
        super.onStart();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
        int i11 = this.f44306c;
        if (i11 == 0) {
            attributes.gravity = 80;
            attributes.width = displayMetrics.widthPixels;
            attributes.windowAnimations = R$style.bottom_animation;
        } else if (i11 == 1) {
            attributes.gravity = 17;
        } else if (i11 == 2) {
            attributes.gravity = 3;
            attributes.height = displayMetrics.heightPixels;
            attributes.windowAnimations = R$style.left_animation;
        } else if (i11 == 3) {
            attributes.gravity = 5;
            attributes.height = displayMetrics.heightPixels;
            attributes.windowAnimations = R$style.right_animation;
        }
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setAttributes(attributes);
        }
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public void show(FragmentManager fragmentManager, String str) {
        try {
            fragmentManager.beginTransaction().remove(this).commit();
            super.show(fragmentManager, str);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
