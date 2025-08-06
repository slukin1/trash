package com.tencent.qcloud.tuicore.permission;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.permission.PermissionRequester;
import com.tencent.qcloud.tuicore.util.TUIBuild;
import java.util.HashMap;

public class PermissionActivity extends Activity {
    private static final int PERMISSION_REQUEST_CODE = 100;
    private static final String TAG = "PermissionActivity";
    private boolean mIsGranted = false;
    private ImageView mPermissionIconIv;
    private TextView mRationaleDescriptionTv;
    private TextView mRationaleTitleTv;
    private PermissionRequester.RequestData mRequestData;

    private void finishWithResult(boolean z11) {
        Log.i(TAG, "finishWithResult : " + z11);
        this.mIsGranted = z11;
        finish();
    }

    private PermissionRequester.RequestData getPermissionRequest() {
        Intent intent = getIntent();
        if (intent == null) {
            return null;
        }
        return (PermissionRequester.RequestData) intent.getParcelableExtra(PermissionRequester.PERMISSION_REQUEST_KEY);
    }

    private void hidePermissionRationale() {
        this.mRationaleTitleTv.setVisibility(4);
        this.mRationaleDescriptionTv.setVisibility(4);
        this.mPermissionIconIv.setVisibility(4);
    }

    private void initView() {
        setContentView(R.layout.permission_activity_layout);
        this.mRationaleTitleTv = (TextView) findViewById(R.id.permission_reason_title);
        this.mRationaleDescriptionTv = (TextView) findViewById(R.id.permission_reason);
        this.mPermissionIconIv = (ImageView) findViewById(R.id.permission_icon);
    }

    private boolean isAllPermissionsGranted(int[] iArr) {
        for (int i11 : iArr) {
            if (i11 != 0) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showSettingsTip$0(DialogInterface dialogInterface) {
        finishWithResult(false);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$showSettingsTip$1(Dialog dialog, View view) {
        dialog.dismiss();
        launchAppDetailsSettings();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static /* synthetic */ void lambda$showSettingsTip$2(Dialog dialog, View view) {
        dialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$showSettingsTip$3(Dialog dialog, DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
        if (i11 == 4 && keyEvent.getAction() == 1) {
            dialog.dismiss();
        }
        return true;
    }

    private void launchAppDetailsSettings() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + getPackageName()));
        intent.addFlags(268435456);
        if (getPackageManager().queryIntentActivities(intent, 65536).size() <= 0) {
            Log.e(TAG, "launchAppDetailsSettings can not find system settings");
        } else {
            startActivity(intent);
        }
    }

    @SuppressLint({"NewApi"})
    private void makeBackGroundTransparent() {
        if (TUIBuild.getVersionInt() >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(1280);
            getWindow().setStatusBarColor(0);
            getWindow().setNavigationBarColor(0);
        }
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    private void showPermissionRationale() {
        PermissionRequester.RequestData requestData = this.mRequestData;
        if (requestData != null) {
            this.mRationaleTitleTv.setText(requestData.getTitle());
            this.mRationaleDescriptionTv.setText(this.mRequestData.getDescription());
            this.mPermissionIconIv.setBackgroundResource(this.mRequestData.getPermissionIconId());
            this.mRationaleTitleTv.setVisibility(0);
            this.mRationaleDescriptionTv.setVisibility(0);
            this.mPermissionIconIv.setVisibility(0);
        }
    }

    private void showSettingsTip() {
        if (this.mRequestData != null) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.permission_tip_layout, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tips)).setText(this.mRequestData.getSettingsTip());
            AlertDialog create = new AlertDialog.Builder(this).setView(inflate).setCancelable(false).setOnDismissListener(new a(this)).create();
            ((TextView) inflate.findViewById(R.id.positive_btn)).setOnClickListener(new d(this, create));
            ((TextView) inflate.findViewById(R.id.negative_btn)).setOnClickListener(new c(create));
            create.setOnKeyListener(new b(create));
            Window window = create.getWindow();
            window.setBackgroundDrawable(new ColorDrawable());
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -2;
            attributes.height = -2;
            window.setAttributes(attributes);
            create.show();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PermissionRequester.RequestData permissionRequest = getPermissionRequest();
        this.mRequestData = permissionRequest;
        if (permissionRequest == null || permissionRequest.isPermissionsExistEmpty()) {
            Log.e(TAG, "onCreate mRequestData exist empty permission");
            finishWithResult(false);
            return;
        }
        Log.i(TAG, "onCreate : " + this.mRequestData.toString());
        if (TUIBuild.getVersionInt() < 23) {
            finishWithResult(true);
            return;
        }
        makeBackGroundTransparent();
        initView();
        showPermissionRationale();
        requestPermissions(this.mRequestData.getPermissions(), 100);
    }

    public void onDestroy() {
        super.onDestroy();
        HashMap hashMap = new HashMap(1);
        hashMap.put(PermissionRequester.PERMISSION_RESULT, Boolean.valueOf(this.mIsGranted));
        TUICore.notifyEvent(PermissionRequester.PERMISSION_NOTIFY_EVENT_KEY, PermissionRequester.PERMISSION_NOTIFY_EVENT_SUB_KEY, hashMap);
    }

    @SensorsDataInstrumented
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        PushAutoTrackHelper.onNewIntent(this, intent);
    }

    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i11, strArr, iArr);
        hidePermissionRationale();
        if (isAllPermissionsGranted(iArr)) {
            finishWithResult(true);
        } else {
            showSettingsTip();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
