package com.huochat.community.util;

import android.app.Application;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.hbg.lib.common.BaseApplication;
import com.huochat.community.R;

public class ToastTool {
    public static Toast iconToast;
    public static Toast toast;

    public static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static Toast shToastLong(int i11) {
        return show(BaseApplication.b().getResources().getString(i11), 1);
    }

    public static Toast show(String str, int i11) {
        if (TextUtils.isEmpty(str) || !isMainThread()) {
            return null;
        }
        try {
            if (toast == null) {
                Application b11 = BaseApplication.b();
                View inflate = View.inflate(b11, R.layout.community_toast_layout, (ViewGroup) null);
                Toast toast2 = new Toast(b11);
                toast = toast2;
                toast2.setGravity(17, 0, 0);
                toast.setDuration(i11);
                toast.setView(inflate);
            }
            ((TextView) toast.getView().findViewById(R.id.tv_toast)).setText(str);
            toast.show();
            return toast;
        } catch (Exception unused) {
            return new Toast(BaseApplication.b());
        }
    }

    public static Toast showIcon(String str, int i11, int i12) {
        if (TextUtils.isEmpty(str) || !isMainThread()) {
            return null;
        }
        Application b11 = BaseApplication.b();
        if (iconToast == null) {
            View inflate = View.inflate(b11, R.layout.community_toast_text_icon_layout, (ViewGroup) null);
            Toast toast2 = new Toast(b11);
            iconToast = toast2;
            toast2.setGravity(17, 0, 0);
            iconToast.setDuration(i12);
            iconToast.setView(inflate);
        }
        ((TextView) iconToast.getView().findViewById(R.id.toast_tv_status)).setText(str + "");
        ((ImageView) iconToast.getView().findViewById(R.id.toast_iv_status)).setImageResource(i11);
        iconToast.show();
        return iconToast;
    }

    public static void showLargeAlert(String str) {
        if (isMainThread() && !TextUtils.isEmpty(str)) {
            try {
                Application b11 = BaseApplication.b();
                View inflate = View.inflate(b11, R.layout.layout_community_large_toast, (ViewGroup) null);
                Toast toast2 = new Toast(b11);
                toast2.setGravity(17, 0, 0);
                toast2.setDuration(1);
                toast2.setView(inflate);
                ((TextView) toast2.getView().findViewById(R.id.tv_toast)).setText(str);
                toast2.show();
            } catch (Exception unused) {
                Toast.makeText(BaseApplication.b(), str, 1).show();
            }
        }
    }

    public static Toast showLong(String str) {
        return show(str, 1);
    }

    public static Toast showShort(String str) {
        return show(str, 0);
    }

    public static Toast showIcon(String str, String str2, int i11, int i12) {
        if (TextUtils.isEmpty(str) || !isMainThread()) {
            return null;
        }
        Application b11 = BaseApplication.b();
        if (iconToast == null) {
            View inflate = View.inflate(b11, R.layout.community_toast_double_text_icon_layout, (ViewGroup) null);
            Toast toast2 = new Toast(b11);
            iconToast = toast2;
            toast2.setGravity(17, 0, 0);
            iconToast.setDuration(i12);
            iconToast.setView(inflate);
        }
        ((ImageView) iconToast.getView().findViewById(R.id.toast_iv_status)).setImageResource(i11);
        ((TextView) iconToast.getView().findViewById(R.id.toast_tv_message)).setText(str + "");
        ((TextView) iconToast.getView().findViewById(R.id.toast_tv_sub_message)).setText(str2 + "");
        iconToast.show();
        return iconToast;
    }
}
