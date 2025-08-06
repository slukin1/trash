package com.sumsub.sns.core.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.sumsub.sns.core.presentation.helper.a;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.theme.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSAlertDialogBuilder;", "Lcom/google/android/material/dialog/MaterialAlertDialogBuilder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "create", "Landroidx/appcompat/app/AlertDialog;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSAlertDialogBuilder extends MaterialAlertDialogBuilder {
    public SNSAlertDialogBuilder(Context context) {
        super(context);
    }

    public AlertDialog create() {
        Integer a11;
        a aVar = a.f31095a;
        d a12 = aVar.a();
        if (!(a12 == null || (a11 = aVar.a(a12, SNSColorElement.ALERT_TINT, i.a(getContext().getResources().getConfiguration()))) == null)) {
            int intValue = a11.intValue();
            Drawable background = getBackground();
            if (background != null) {
                background.setTintMode(PorterDuff.Mode.SRC_ATOP);
            }
            Drawable background2 = getBackground();
            if (background2 != null) {
                background2.setTint(intValue);
            }
        }
        return super.create();
    }
}
