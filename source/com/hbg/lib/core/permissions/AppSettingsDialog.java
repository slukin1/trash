package com.hbg.lib.core.permissions;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import com.hbg.lib.core.R$style;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class AppSettingsDialog {
    public static final int DEFAULT_SETTINGS_REQ_CODE = 16061;
    private AlertDialog mAlertDialog;

    /* access modifiers changed from: private */
    @TargetApi(11)
    public void startForResult(Object obj, Intent intent, int i11) {
        if (obj instanceof Activity) {
            ((Activity) obj).startActivityForResult(intent, i11);
        } else if (obj instanceof Fragment) {
            ((Fragment) obj).startActivityForResult(intent, i11);
        } else if (obj instanceof android.app.Fragment) {
            ((android.app.Fragment) obj).startActivityForResult(intent, i11);
        }
    }

    public void show() {
        this.mAlertDialog.show();
    }

    private AppSettingsDialog(final Object obj, final Context context, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, final int i11) {
        AlertDialog.a aVar = new AlertDialog.a(context, R$style.Core_CustomDialog_DayTheme);
        aVar.setMessage((CharSequence) str);
        aVar.setTitle((CharSequence) str2);
        String string = TextUtils.isEmpty(str3) ? context.getString(17039370) : str3;
        str4 = TextUtils.isEmpty(str3) ? context.getString(17039360) : str4;
        i11 = i11 <= 0 ? DEFAULT_SETTINGS_REQ_CODE : i11;
        aVar.setPositiveButton((CharSequence) string, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(DialogInterface dialogInterface, int i11) {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", context.getPackageName(), (String) null));
                AppSettingsDialog.this.startForResult(obj, intent, i11);
                SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
            }
        });
        aVar.setNegativeButton((CharSequence) str4, onClickListener);
        AlertDialog create = aVar.create();
        this.mAlertDialog = create;
        create.setCanceledOnTouchOutside(false);
    }

    public static class Builder {
        private Object mActivityOrFragment;
        private Context mContext;
        private String mNegativeButton;
        private DialogInterface.OnClickListener mNegativeListener;
        private String mPositiveButton;
        private String mRationale;
        private int mRequestCode = -1;
        private String mTitle;

        public Builder(Activity activity, String str) {
            this.mActivityOrFragment = activity;
            this.mContext = activity;
            this.mRationale = str;
        }

        public AppSettingsDialog build() {
            return new AppSettingsDialog(this.mActivityOrFragment, this.mContext, this.mRationale, this.mTitle, this.mPositiveButton, this.mNegativeButton, this.mNegativeListener, this.mRequestCode);
        }

        public Builder setNegativeButton(String str, DialogInterface.OnClickListener onClickListener) {
            this.mNegativeButton = str;
            this.mNegativeListener = onClickListener;
            return this;
        }

        public Builder setPositiveButton(String str) {
            this.mPositiveButton = str;
            return this;
        }

        public Builder setRequestCode(int i11) {
            this.mRequestCode = i11;
            return this;
        }

        public Builder setTitle(String str) {
            this.mTitle = str;
            return this;
        }

        public Builder(Fragment fragment, String str) {
            this.mActivityOrFragment = fragment;
            this.mContext = fragment.getContext();
            this.mRationale = str;
        }

        @TargetApi(11)
        public Builder(android.app.Fragment fragment, String str) {
            this.mActivityOrFragment = fragment;
            this.mContext = fragment.getActivity();
            this.mRationale = str;
        }
    }
}
