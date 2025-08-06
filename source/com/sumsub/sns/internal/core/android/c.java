package com.sumsub.sns.internal.core.android;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.sumsub.sns.core.widget.SNSAlertDialogBuilder;
import com.sumsub.sns.internal.core.common.i;
import d10.a;
import kotlin.Unit;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f31946a = new c();

    /* renamed from: b  reason: collision with root package name */
    public static final String f31947b = "sns_alert_lackOfMicrophonePermissions";

    /* renamed from: c  reason: collision with root package name */
    public static final String f31948c = "sns_alert_lackOfCameraPermissions";

    /* renamed from: d  reason: collision with root package name */
    public static final String f31949d = "sns_alert_lackOfLocationPermissions";

    /* renamed from: e  reason: collision with root package name */
    public static final String f31950e = "sns_alert_action_cancel";

    /* renamed from: f  reason: collision with root package name */
    public static final String f31951f = "sns_alert_action_settings";

    public static /* synthetic */ AlertDialog a(c cVar, Activity activity, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, a aVar, a aVar2, int i11, Object obj) {
        return cVar.a(activity, charSequence, charSequence2, charSequence3, (i11 & 16) != 0 ? null : aVar, (i11 & 32) != 0 ? null : aVar2);
    }

    public final AlertDialog a(Activity activity, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, a<Unit> aVar, a<Unit> aVar2) {
        return new SNSAlertDialogBuilder(activity).setMessage(charSequence).setNegativeButton(charSequence3, (DialogInterface.OnClickListener) new h(aVar)).setPositiveButton(charSequence2, (DialogInterface.OnClickListener) new i(aVar2, activity)).setOnCancelListener((DialogInterface.OnCancelListener) new g(aVar)).create();
    }

    public static final void a(a aVar, DialogInterface dialogInterface, int i11) {
        dialogInterface.dismiss();
        if (aVar != null) {
            aVar.invoke();
        }
    }

    public static final void a(a aVar, Activity activity, DialogInterface dialogInterface, int i11) {
        dialogInterface.dismiss();
        if (aVar != null) {
            aVar.invoke();
        } else {
            i.a(activity);
        }
    }

    public static final void a(a aVar, DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        if (aVar != null) {
            aVar.invoke();
        }
    }
}
