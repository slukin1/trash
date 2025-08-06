package com.jumio.defaultui.view;

import android.content.Context;
import android.content.DialogInterface;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.jumio.commons.log.Log;
import pw.m;
import pw.n;

public final class JumioDialog {
    public static final JumioDialog INSTANCE = new JumioDialog();

    public interface DialogAction {
        int getCaption();

        void onAction();
    }

    private JumioDialog() {
    }

    public static /* synthetic */ AlertDialog create$default(JumioDialog jumioDialog, Context context, int i11, int i12, String str, String str2, DialogAction dialogAction, DialogAction dialogAction2, int i13, Object obj) {
        int i14 = 0;
        int i15 = (i13 & 2) != 0 ? 0 : i11;
        if ((i13 & 4) == 0) {
            i14 = i12;
        }
        DialogAction dialogAction3 = null;
        String str3 = (i13 & 8) != 0 ? null : str;
        String str4 = (i13 & 16) != 0 ? null : str2;
        DialogAction dialogAction4 = (i13 & 32) != 0 ? null : dialogAction;
        if ((i13 & 64) == 0) {
            dialogAction3 = dialogAction2;
        }
        return jumioDialog.create(context, i15, i14, str3, str4, dialogAction4, dialogAction3);
    }

    /* access modifiers changed from: private */
    public static final void create$lambda$0(DialogAction dialogAction, DialogInterface dialogInterface, int i11) {
        dialogAction.onAction();
    }

    /* access modifiers changed from: private */
    public static final void create$lambda$1(DialogAction dialogAction, DialogInterface dialogInterface, int i11) {
        dialogAction.onAction();
    }

    public final AlertDialog create(Context context, int i11, int i12, String str, String str2, DialogAction dialogAction, DialogAction dialogAction2) {
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(context);
        if (i11 != 0) {
            materialAlertDialogBuilder.setTitle(i11);
        } else if (str != null) {
            materialAlertDialogBuilder.setTitle((CharSequence) str);
        }
        if (i12 != 0) {
            materialAlertDialogBuilder.setMessage(i12);
        } else if (str2 != null) {
            materialAlertDialogBuilder.setMessage((CharSequence) str2);
        }
        materialAlertDialogBuilder.setCancelable(false);
        if (dialogAction != null) {
            materialAlertDialogBuilder.setPositiveButton(dialogAction.getCaption(), (DialogInterface.OnClickListener) new m(dialogAction));
        }
        if (dialogAction2 != null) {
            materialAlertDialogBuilder.setNegativeButton(dialogAction2.getCaption(), (DialogInterface.OnClickListener) new n(dialogAction2));
        }
        AlertDialog show = materialAlertDialogBuilder.show();
        try {
            TextView textView = (TextView) show.findViewById(16908299);
            if (textView != null) {
                textView.setLinkTextColor(textView.getTextColors());
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        } catch (Exception e11) {
            Log.printStackTrace(e11);
        }
        return show;
    }
}
