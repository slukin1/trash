package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;

public abstract class DialogRedirect implements DialogInterface.OnClickListener {
    public static DialogRedirect getInstance(Activity activity, Intent intent, int i11) {
        return new DialogRedirectImpl(intent, activity, i11);
    }

    public void onClick(DialogInterface dialogInterface, int i11) {
        try {
            redirect();
            if (dialogInterface == null) {
                return;
            }
        } catch (Throwable th2) {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            throw th2;
        }
        dialogInterface.dismiss();
    }

    public abstract void redirect();
}
