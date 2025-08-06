package com.hbg.module.content.utls.comment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Window;
import android.view.WindowManager;
import com.hbg.module.content.R$style;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f18904a = new f();

    public static /* synthetic */ Dialog d(f fVar, Context context, int i11, int i12, int i13, boolean z11, int i14, boolean z12, boolean z13, boolean z14, int i15, int i16, Object obj) {
        int i17 = i16;
        return fVar.c(context, i11, i12, i13, (i17 & 16) != 0 ? false : z11, (i17 & 32) != 0 ? 0 : i14, (i17 & 64) != 0 ? false : z12, (i17 & 128) != 0 ? false : z13, (i17 & 256) != 0 ? false : z14, (i17 & 512) != 0 ? R$style.inputDialog : i15);
    }

    public static final void e(Context context, DialogInterface dialogInterface) {
        if ((context instanceof Activity) && StringsKt__StringsKt.R(context.toString(), "UniAppJumpActivity", false, 2, (Object) null)) {
            ((Activity) context).finish();
        }
    }

    public static final void f(Context context, DialogInterface dialogInterface) {
        if ((context instanceof Activity) && StringsKt__StringsKt.R(context.toString(), "UniAppJumpActivity", false, 2, (Object) null)) {
            ((Activity) context).finish();
        }
    }

    public final Dialog c(Context context, int i11, int i12, int i13, boolean z11, int i14, boolean z12, boolean z13, boolean z14, int i15) {
        Dialog dialog = new Dialog(context, i15);
        dialog.requestWindowFeature(1);
        dialog.setContentView(i11);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
        int i16 = -1;
        if (attributes != null) {
            attributes.width = z13 ? -1 : -2;
        }
        if (attributes != null) {
            if (!z14) {
                i16 = -2;
            }
            attributes.height = i16;
        }
        if (window != null) {
            window.setAttributes(attributes);
        }
        if (window != null) {
            window.setGravity(i12);
        }
        if (!(i14 == 0 || window == null)) {
            window.setWindowAnimations(i14);
        }
        if (z11 && window != null) {
            window.clearFlags(2);
        }
        if (window != null) {
            window.setBackgroundDrawableResource(i13);
        }
        dialog.setCanceledOnTouchOutside(z12);
        dialog.setOnDismissListener(new e(context));
        dialog.setOnCancelListener(new d(context));
        return dialog;
    }
}
