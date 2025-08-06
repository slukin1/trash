package cn.sharesdk.framework;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import cn.sharesdk.framework.a.a.e;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.ResHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class AgreementDialog extends FakeActivity {
    /* access modifiers changed from: private */
    public Dialog dialog;
    /* access modifiers changed from: private */
    public OnDialogDismiss onDialogDismiss;

    public interface OnDialogDismiss {
        void consent();

        void refuse();
    }

    /* access modifiers changed from: private */
    public void refuse() {
        Dialog dialog2 = this.dialog;
        if (dialog2 != null && dialog2.isShowing()) {
            this.dialog.dismiss();
            OnDialogDismiss onDialogDismiss2 = this.onDialogDismiss;
            if (onDialogDismiss2 != null) {
                onDialogDismiss2.refuse();
            }
        }
        this.activity.finish();
    }

    public void setActivity(final Activity activity) {
        super.setActivity(activity);
        try {
            this.dialog = new Dialog(activity, ResHelper.getStyleRes(activity, "mobcommon_DialogStyle"));
            View inflate = LayoutInflater.from(activity).inflate(ResHelper.getLayoutRes(activity, "sharesdk_agreement_dialog"), (ViewGroup) null);
            this.dialog.setCanceledOnTouchOutside(false);
            this.dialog.setContentView(inflate);
            Window window = this.dialog.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            window.setGravity(17);
            window.setAttributes(attributes);
            this.dialog.setCancelable(true);
            inflate.findViewById(ResHelper.getIdRes(activity, "sharesdk_agreement_dialog_reject_tv")).setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    AgreementDialog.this.refuse();
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
            inflate.findViewById(ResHelper.getIdRes(activity, "sharesdk_agreement_dialog_accept_tv")).setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    if (AgreementDialog.this.dialog != null && AgreementDialog.this.dialog.isShowing()) {
                        AgreementDialog.this.dialog.dismiss();
                        if (AgreementDialog.this.onDialogDismiss != null) {
                            AgreementDialog.this.onDialogDismiss.consent();
                        }
                        e.a().a(true);
                    }
                    activity.finish();
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
            this.dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                public boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
                    if (i11 != 4) {
                        return false;
                    }
                    AgreementDialog.this.refuse();
                    return false;
                }
            });
            this.dialog.show();
        } catch (Throwable unused) {
        }
    }

    public void setShareParam(OnDialogDismiss onDialogDismiss2) {
        this.onDialogDismiss = onDialogDismiss2;
    }
}
