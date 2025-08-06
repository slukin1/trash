package com.huawei.hms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import com.huawei.hms.common.internal.Preconditions;

public class ErrDlgFragmentForSupport extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    private Dialog f37842a = null;

    /* renamed from: b  reason: collision with root package name */
    private DialogInterface.OnCancelListener f37843b = null;

    public static ErrDlgFragmentForSupport newInstance(Dialog dialog) {
        return newInstance(dialog, (DialogInterface.OnCancelListener) null);
    }

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f37843b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f37842a == null) {
            setShowsDialog(false);
        }
        return this.f37842a;
    }

    public void show(FragmentManager fragmentManager, String str) {
        Preconditions.checkNotNull(fragmentManager, "FragmentManager cannot be null!");
        super.show(fragmentManager, str);
    }

    public static ErrDlgFragmentForSupport newInstance(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        Preconditions.checkNotNull(dialog, "Dialog cannot be null!");
        ErrDlgFragmentForSupport errDlgFragmentForSupport = new ErrDlgFragmentForSupport();
        errDlgFragmentForSupport.f37842a = dialog;
        dialog.setOnCancelListener((DialogInterface.OnCancelListener) null);
        errDlgFragmentForSupport.f37842a.setOnDismissListener((DialogInterface.OnDismissListener) null);
        errDlgFragmentForSupport.f37843b = onCancelListener;
        return errDlgFragmentForSupport;
    }
}
