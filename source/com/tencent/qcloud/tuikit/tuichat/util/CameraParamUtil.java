package com.tencent.qcloud.tuikit.tuichat.util;

import android.content.Context;
import android.hardware.Camera;
import android.view.WindowManager;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class CameraParamUtil {
    private static final String TAG = "CameraParamUtil";
    private static CameraParamUtil cameraParamUtil;
    private CameraSizeComparator sizeComparator = new CameraSizeComparator();

    public class CameraSizeComparator implements Comparator<Camera.Size> {
        private CameraSizeComparator() {
        }

        public int compare(Camera.Size size, Camera.Size size2) {
            int i11 = size.width;
            int i12 = size2.width;
            if (i11 == i12) {
                return 0;
            }
            return i11 > i12 ? 1 : -1;
        }
    }

    private CameraParamUtil() {
    }

    private boolean equalRate(Camera.Size size, float f11) {
        return ((double) Math.abs((((float) size.width) / ((float) size.height)) - f11)) <= 0.2d;
    }

    private Camera.Size getBestSize(List<Camera.Size> list, float f11) {
        float f12 = 100.0f;
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            Camera.Size size = list.get(i12);
            float f13 = f11 - (((float) size.width) / ((float) size.height));
            if (Math.abs(f13) < f12) {
                f12 = Math.abs(f13);
                i11 = i12;
            }
        }
        return list.get(i11);
    }

    public static CameraParamUtil getInstance() {
        CameraParamUtil cameraParamUtil2 = cameraParamUtil;
        if (cameraParamUtil2 != null) {
            return cameraParamUtil2;
        }
        CameraParamUtil cameraParamUtil3 = new CameraParamUtil();
        cameraParamUtil = cameraParamUtil3;
        return cameraParamUtil3;
    }

    public int getCameraDisplayOrientation(Context context, int i11) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i11, cameraInfo);
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        int i12 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i12 = 90;
            } else if (rotation == 2) {
                i12 = 180;
            } else if (rotation == 3) {
                i12 = 270;
            }
        }
        if (cameraInfo.facing == 1) {
            return (360 - ((cameraInfo.orientation + i12) % 360)) % 360;
        }
        return ((cameraInfo.orientation - i12) + 360) % 360;
    }

    public Camera.Size getPictureSize(List<Camera.Size> list, int i11, float f11) {
        Collections.sort(list, this.sizeComparator);
        Iterator<Camera.Size> it2 = list.iterator();
        int i12 = 0;
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Camera.Size next = it2.next();
            if (next.width > i11 && equalRate(next, f11)) {
                String str = TAG;
                TUIChatLog.i(str, "MakeSure Picture :w = " + next.width + " h = " + next.height);
                break;
            }
            i12++;
        }
        if (i12 == list.size()) {
            return getBestSize(list, f11);
        }
        return list.get(i12);
    }

    public Camera.Size getPreviewSize(List<Camera.Size> list, int i11, float f11) {
        Collections.sort(list, this.sizeComparator);
        Iterator<Camera.Size> it2 = list.iterator();
        int i12 = 0;
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Camera.Size next = it2.next();
            if (next.width > i11 && equalRate(next, f11)) {
                String str = TAG;
                TUIChatLog.i(str, "MakeSure Preview :w = " + next.width + " h = " + next.height);
                break;
            }
            i12++;
        }
        if (i12 == list.size()) {
            return getBestSize(list, f11);
        }
        return list.get(i12);
    }

    public boolean isSupportedFocusMode(List<String> list, String str) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (str.equals(list.get(i11))) {
                TUIChatLog.i(TAG, "FocusMode supported " + str);
                return true;
            }
        }
        TUIChatLog.i(TAG, "FocusMode not supported " + str);
        return false;
    }

    public boolean isSupportedPictureFormats(List<Integer> list, int i11) {
        for (int i12 = 0; i12 < list.size(); i12++) {
            if (i11 == list.get(i12).intValue()) {
                TUIChatLog.i(TAG, "Formats supported " + i11);
                return true;
            }
        }
        TUIChatLog.i(TAG, "Formats not supported " + i11);
        return false;
    }
}
