package com.luck.picture.lib.permissions;

import android.content.Context;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.luck.picture.lib.basic.PictureCommonFragment;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.utils.ActivityCompatHelper;
import com.luck.picture.lib.utils.SdkVersionUtils;
import java.util.ArrayList;
import java.util.List;

public class PermissionChecker {
    private static final int REQUEST_CODE = 10086;
    private static PermissionChecker mInstance;

    private PermissionChecker() {
    }

    public static boolean checkSelfPermission(Context context, String[] strArr) {
        if (strArr != null) {
            for (String checkSelfPermission : strArr) {
                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), checkSelfPermission) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static PermissionChecker getInstance() {
        if (mInstance == null) {
            synchronized (PermissionChecker.class) {
                if (mInstance == null) {
                    mInstance = new PermissionChecker();
                }
            }
        }
        return mInstance;
    }

    public static boolean isCheckCamera(Context context) {
        return checkSelfPermission(context, new String[]{"android.permission.CAMERA"});
    }

    public static boolean isCheckReadAudio(Context context) {
        return checkSelfPermission(context, new String[]{PermissionConfig.READ_MEDIA_AUDIO});
    }

    public static boolean isCheckReadExternalStorage(Context context) {
        return checkSelfPermission(context, new String[]{PermissionConfig.READ_EXTERNAL_STORAGE});
    }

    public static boolean isCheckReadImages(Context context) {
        return checkSelfPermission(context, new String[]{PermissionConfig.READ_MEDIA_IMAGES});
    }

    public static boolean isCheckReadStorage(int i11, Context context) {
        if (!SdkVersionUtils.isTIRAMISU()) {
            return isCheckReadExternalStorage(context);
        }
        if (i11 == SelectMimeType.ofImage()) {
            return isCheckReadImages(context);
        }
        if (i11 == SelectMimeType.ofVideo()) {
            return isCheckReadVideo(context);
        }
        if (i11 == SelectMimeType.ofAudio()) {
            return isCheckReadAudio(context);
        }
        return isCheckReadImages(context) && isCheckReadVideo(context);
    }

    public static boolean isCheckReadVideo(Context context) {
        return checkSelfPermission(context, new String[]{PermissionConfig.READ_MEDIA_VIDEO});
    }

    public static boolean isCheckSelfPermission(Context context, String[] strArr) {
        return checkSelfPermission(context, strArr);
    }

    public static boolean isCheckWriteExternalStorage(Context context) {
        return checkSelfPermission(context, new String[]{PermissionConfig.WRITE_EXTERNAL_STORAGE});
    }

    public void onRequestPermissionsResult(int[] iArr, PermissionResultCallback permissionResultCallback) {
        if (PermissionUtil.isAllGranted(iArr)) {
            permissionResultCallback.onGranted();
        } else {
            permissionResultCallback.onDenied();
        }
    }

    public void requestPermissions(Fragment fragment, String[] strArr, PermissionResultCallback permissionResultCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(strArr);
        requestPermissions(fragment, arrayList, REQUEST_CODE, permissionResultCallback);
    }

    public void requestPermissions(Fragment fragment, List<String[]> list, PermissionResultCallback permissionResultCallback) {
        requestPermissions(fragment, list, REQUEST_CODE, permissionResultCallback);
    }

    private void requestPermissions(Fragment fragment, List<String[]> list, int i11, PermissionResultCallback permissionResultCallback) {
        if (ActivityCompatHelper.isDestroy(fragment.getActivity()) || !(fragment instanceof PictureCommonFragment)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            FragmentActivity activity = fragment.getActivity();
            ArrayList arrayList = new ArrayList();
            for (String[] next : list) {
                for (String str : r9.next()) {
                    if (ContextCompat.checkSelfPermission(activity, str) != 0) {
                        arrayList.add(str);
                    }
                }
            }
            if (arrayList.size() > 0) {
                ((PictureCommonFragment) fragment).setPermissionsResultAction(permissionResultCallback);
                String[] strArr = new String[arrayList.size()];
                arrayList.toArray(strArr);
                fragment.requestPermissions(strArr, i11);
                ActivityCompat.requestPermissions(activity, strArr, i11);
            } else if (permissionResultCallback != null) {
                permissionResultCallback.onGranted();
            }
        } else if (permissionResultCallback != null) {
            permissionResultCallback.onGranted();
        }
    }
}
