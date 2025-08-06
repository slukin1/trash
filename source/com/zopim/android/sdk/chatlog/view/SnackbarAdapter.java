package com.zopim.android.sdk.chatlog.view;

import android.view.View;
import com.google.android.material.snackbar.Snackbar;

public class SnackbarAdapter {
    public static Snackbar make(View view, int i11, int i12) {
        if (view == null) {
            return null;
        }
        Snackbar make = Snackbar.make(view, i11, i12);
        make.getView().getLayoutParams().width = -1;
        return make;
    }
}
