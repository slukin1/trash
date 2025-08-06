package com.tencent.qcloud.tuikit.timcommon.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.qcloud.tuikit.timcommon.R;

public class PopWindowUtil {
    public static AlertDialog buildFullScreenDialog(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            return null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.TUIKit_AlertDialogStyle);
        builder.setTitle("");
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        create.getWindow().setDimAmount(0.0f);
        create.setCanceledOnTouchOutside(true);
        create.show();
        create.getWindow().setLayout(-1, -1);
        create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return create;
    }

    public static PopupWindow popupWindow(View view, View view2, int i11, int i12) {
        PopupWindow popupWindow = new PopupWindow(view, -2, -2);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(-1360073216));
        popupWindow.showAtLocation(view, 49, i11, i12);
        return popupWindow;
    }
}
