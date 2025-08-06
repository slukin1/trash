package com.luck.picture.lib.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.luck.picture.lib.R;
import com.luck.picture.lib.interfaces.OnItemClickListener;
import com.luck.picture.lib.utils.DensityUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;

public class PhotoItemSelectedDialog extends DialogFragment implements View.OnClickListener {
    public static final int IMAGE_CAMERA = 0;
    public static final int VIDEO_CAMERA = 1;
    private boolean isCancel = true;
    private OnDismissListener onDismissListener;
    private OnItemClickListener onItemClickListener;

    public interface OnDismissListener {
        void onDismiss(boolean z11, DialogInterface dialogInterface);
    }

    private void initDialogStyle() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(DensityUtil.getRealScreenWidth(getContext()), -2);
            window.setGravity(80);
            window.setWindowAnimations(R.style.PictureThemeDialogFragmentAnim);
        }
    }

    public static PhotoItemSelectedDialog newInstance() {
        return new PhotoItemSelectedDialog();
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        int id2 = view.getId();
        OnItemClickListener onItemClickListener2 = this.onItemClickListener;
        if (onItemClickListener2 != null) {
            if (id2 == R.id.ps_tv_photo) {
                onItemClickListener2.onItemClick(view, 0);
                this.isCancel = false;
            } else if (id2 == R.id.ps_tv_video) {
                onItemClickListener2.onItemClick(view, 1);
                this.isCancel = false;
            }
        }
        dismissAllowingStateLoss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (getDialog() != null) {
            getDialog().requestWindowFeature(1);
            if (getDialog().getWindow() != null) {
                getDialog().getWindow().setBackgroundDrawableResource(17170445);
            }
        }
        return layoutInflater.inflate(R.layout.ps_dialog_camera_selected, viewGroup);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        OnDismissListener onDismissListener2 = this.onDismissListener;
        if (onDismissListener2 != null) {
            onDismissListener2.onDismiss(this.isCancel, dialogInterface);
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
        initDialogStyle();
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((TextView) view.findViewById(R.id.ps_tv_video)).setOnClickListener(this);
        ((TextView) view.findViewById(R.id.ps_tv_photo)).setOnClickListener(this);
        ((TextView) view.findViewById(R.id.ps_tv_cancel)).setOnClickListener(this);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void setOnDismissListener(OnDismissListener onDismissListener2) {
        this.onDismissListener = onDismissListener2;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener2) {
        this.onItemClickListener = onItemClickListener2;
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public void show(FragmentManager fragmentManager, String str) {
        FragmentTransaction q11 = fragmentManager.q();
        q11.e(this, str);
        q11.k();
    }
}
