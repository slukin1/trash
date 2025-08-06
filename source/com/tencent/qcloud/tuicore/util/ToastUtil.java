package com.tencent.qcloud.tuicore.util;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.qcloud.tuicore.ServiceInitializer;

public class ToastUtil {
    private static final Handler handler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public static Toast toast;

    public static void toastLongMessage(String str) {
        toastMessage(str, true);
    }

    private static void toastMessage(final String str, final boolean z11) {
        handler.post(new Runnable() {
            public void run() {
                TextView textView;
                if (ToastUtil.toast != null) {
                    ToastUtil.toast.cancel();
                    Toast unused = ToastUtil.toast = null;
                }
                Toast unused2 = ToastUtil.toast = Toast.makeText(ServiceInitializer.getAppContext(), str, z11 ? 1 : 0);
                View view = ToastUtil.toast.getView();
                if (!(view == null || (textView = (TextView) view.findViewById(16908299)) == null)) {
                    textView.setGravity(17);
                }
                ToastUtil.toast.show();
            }
        });
    }

    public static void toastShortMessage(String str) {
        toastMessage(str, false);
    }
}
