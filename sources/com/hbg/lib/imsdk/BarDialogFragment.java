package com.hbg.lib.imsdk;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;

public abstract class BarDialogFragment extends BaseDialogFragment {
    public void afterInit() {
        setCanDismissOnBackPress(false);
        setCanceledOnTouchOutside(false);
    }

    public boolean isFullScreen() {
        return false;
    }

    public boolean isTransparent() {
        return true;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.flags = 8;
            attributes.y = sh();
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public int sh() {
        return 0;
    }
}
