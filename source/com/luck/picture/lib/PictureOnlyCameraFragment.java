package com.luck.picture.lib;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.luck.picture.lib.basic.PictureCommonFragment;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnPermissionsInterceptListener;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.luck.picture.lib.permissions.PermissionResultCallback;
import com.luck.picture.lib.utils.SdkVersionUtils;
import com.luck.picture.lib.utils.ToastUtils;

public class PictureOnlyCameraFragment extends PictureCommonFragment {
    public static final String TAG = PictureOnlyCameraFragment.class.getSimpleName();

    public static PictureOnlyCameraFragment newInstance() {
        return new PictureOnlyCameraFragment();
    }

    public void dispatchCameraMediaResult(LocalMedia localMedia) {
        if (confirmSelect(localMedia, false) == 0) {
            dispatchTransformResult();
        } else {
            onKeyBackFragmentFinish();
        }
    }

    public String getFragmentTag() {
        return TAG;
    }

    public int getResourceId() {
        return R.layout.ps_empty;
    }

    public void handlePermissionSettingResult(String[] strArr) {
        boolean z11;
        onPermissionExplainEvent(false, (String[]) null);
        OnPermissionsInterceptListener onPermissionsInterceptListener = this.selectorConfig.onPermissionsEventListener;
        if (onPermissionsInterceptListener != null) {
            z11 = onPermissionsInterceptListener.hasPermissions(this, strArr);
        } else {
            z11 = PermissionChecker.isCheckCamera(getContext());
            if (!SdkVersionUtils.isQ()) {
                z11 = PermissionChecker.isCheckWriteExternalStorage(getContext());
            }
        }
        if (z11) {
            openSelectedCamera();
        } else {
            if (!PermissionChecker.isCheckCamera(getContext())) {
                ToastUtils.showToast(getContext(), getString(R.string.ps_camera));
            } else if (!PermissionChecker.isCheckWriteExternalStorage(getContext())) {
                ToastUtils.showToast(getContext(), getString(R.string.ps_jurisdiction));
            }
            onKeyBackFragmentFinish();
        }
        PermissionConfig.CURRENT_REQUEST_PERMISSION = new String[0];
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == 0) {
            onKeyBackFragmentFinish();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (bundle != null) {
            return;
        }
        if (SdkVersionUtils.isQ()) {
            openSelectedCamera();
            return;
        }
        final String[] strArr = {PermissionConfig.WRITE_EXTERNAL_STORAGE};
        PermissionChecker.getInstance().requestPermissions((Fragment) this, strArr, (PermissionResultCallback) new PermissionResultCallback() {
            public void onDenied() {
                PictureOnlyCameraFragment.this.handlePermissionDenied(strArr);
            }

            public void onGranted() {
                PictureOnlyCameraFragment.this.openSelectedCamera();
            }
        });
    }
}
