package com.sensorsdata.analytics.android.sdk.util;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.sensorsdata.analytics.android.sdk.SALog;
import java.lang.reflect.Field;

public class ToastUtil {
    private static final String TAG = "ToastUtil";
    private static final Handler mToastMainHandler = new Handler(Looper.getMainLooper());

    public static class HandlerProxy extends Handler {
        private Handler mHandler;

        public HandlerProxy(Handler handler) {
            this.mHandler = handler;
        }

        public void handleMessage(Message message) {
            try {
                this.mHandler.handleMessage(message);
            } catch (Exception unused) {
            }
        }
    }

    private static void hookToast(Toast toast) {
        Field findFieldObj;
        int i11 = Build.VERSION.SDK_INT;
        if (26 > i11 || (isHuaWei() && 26 == i11)) {
            try {
                Object findFieldRecur = ReflectUtil.findFieldRecur(toast, "mTN");
                if (findFieldRecur != null && (findFieldObj = ReflectUtil.findFieldObj(findFieldRecur.getClass(), "mHandler")) != null) {
                    findFieldObj.setAccessible(true);
                    findFieldObj.set(findFieldRecur, new HandlerProxy((Handler) findFieldObj.get(findFieldRecur)));
                }
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    private static boolean isHuaWei() {
        String manufacturer = DeviceUtils.getManufacturer();
        if (manufacturer == null) {
            return false;
        }
        if (manufacturer.equalsIgnoreCase(MTPushConstants.Manufacturer.HONOR) || manufacturer.equalsIgnoreCase(MTPushConstants.Manufacturer.HUAWEI)) {
            return true;
        }
        return false;
    }

    public static void showLong(Context context, String str) {
        if (context == null) {
            SALog.i(TAG, "context is null");
        } else if (!TextUtils.isEmpty(str)) {
            showToastToMain(context.getApplicationContext(), str, 1);
        }
    }

    public static void showShort(Context context, String str) {
        if (context == null) {
            SALog.i(TAG, "context is null");
        } else if (!TextUtils.isEmpty(str)) {
            showToastToMain(context.getApplicationContext(), str, 0);
        }
    }

    /* access modifiers changed from: private */
    public static void showToast(Context context, String str, int i11) {
        Toast makeText = Toast.makeText(context, str, i11);
        hookToast(makeText);
        makeText.show();
    }

    private static void showToastToMain(final Context context, final String str, final int i11) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            showToast(context, str, i11);
        } else {
            mToastMainHandler.post(new Runnable() {
                public void run() {
                    ToastUtil.showToast(context, str, i11);
                }
            });
        }
    }
}
