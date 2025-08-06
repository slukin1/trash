package com.tencent.qcloud.tuicore.util;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuicore.TUIConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class PermissionRequester {
    private static final List<String> PERMISSIONS = getPermissions();
    private static Context applicationContext;
    /* access modifiers changed from: private */
    public static PermissionRequester instance;
    /* access modifiers changed from: private */
    public static boolean isRequesting = false;
    /* access modifiers changed from: private */
    public static final Map<String, PermissionRequestContent> permissionRequestContentMap = new HashMap();
    /* access modifiers changed from: private */
    public String mCurrentRequestPermission;
    private String mDeniedAlert;
    /* access modifiers changed from: private */
    public PermissionDialogCallback mDialogCallback;
    private FullCallback mFullCallback;
    /* access modifiers changed from: private */
    public int mIconId;
    private Set<String> mPermissions = new LinkedHashSet();
    private List<String> mPermissionsDenied;
    private List<String> mPermissionsGranted;
    /* access modifiers changed from: private */
    public List<String> mPermissionsRequest;
    /* access modifiers changed from: private */
    public String mReason;
    /* access modifiers changed from: private */
    public String mReasonTitle;
    private SimpleCallback mSimpleCallback;

    public interface FullCallback {
        void onDenied(List<String> list);

        void onGranted(List<String> list);
    }

    public static class PermissionActivity extends Activity {
        private View mContentView;

        private void fillContentView() {
            PermissionRequestContent permissionRequestContent = (PermissionRequestContent) PermissionRequester.permissionRequestContentMap.get(PermissionRequester.instance.mCurrentRequestPermission);
            int access$600 = PermissionRequester.instance.mIconId;
            String access$700 = PermissionRequester.instance.mReasonTitle;
            String access$800 = PermissionRequester.instance.mReason;
            if (permissionRequestContent != null) {
                int i11 = permissionRequestContent.iconResId;
                if (i11 != 0) {
                    access$600 = i11;
                }
                if (!TextUtils.isEmpty(permissionRequestContent.reasonTitle)) {
                    access$700 = permissionRequestContent.reasonTitle;
                }
                if (!TextUtils.isEmpty(permissionRequestContent.reason)) {
                    access$800 = permissionRequestContent.reason;
                }
            }
            if (!TextUtils.isEmpty(access$800)) {
                setContentView(R.layout.permission_activity_layout);
                this.mContentView = findViewById(R.id.tuicore_permission_layout);
                ImageView imageView = (ImageView) findViewById(R.id.permission_icon);
                ((TextView) findViewById(R.id.permission_reason_title)).setText(access$700);
                ((TextView) findViewById(R.id.permission_reason)).setText(access$800);
                if (access$600 != 0) {
                    imageView.setBackgroundResource(access$600);
                }
            }
        }

        private void hideContentView() {
            View view = this.mContentView;
            if (view != null) {
                view.setVisibility(4);
            }
        }

        private void requestPermission() {
            if (PermissionRequester.instance.mPermissionsRequest != null) {
                int size = PermissionRequester.instance.mPermissionsRequest.size();
                if (size <= 0) {
                    PermissionRequester.instance.onRequestPermissionsResult(this);
                    return;
                }
                fillContentView();
                requestPermissions((String[]) PermissionRequester.instance.mPermissionsRequest.toArray(new String[size]), 1);
            }
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return super.dispatchTouchEvent(motionEvent);
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            if (TUIBuild.getVersionInt() >= 21) {
                getWindow().getDecorView().setSystemUiVisibility(1280);
                getWindow().setStatusBarColor(0);
                getWindow().setNavigationBarColor(0);
            }
            ActionBar actionBar = getActionBar();
            if (actionBar != null) {
                actionBar.hide();
            }
            requestPermission();
        }

        public void onDestroy() {
            super.onDestroy();
            boolean unused = PermissionRequester.isRequesting = false;
        }

        @SensorsDataInstrumented
        public void onNewIntent(Intent intent) {
            super.onNewIntent(intent);
            PushAutoTrackHelper.onNewIntent(this, intent);
        }

        public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
            if (PermissionRequester.instance.mPermissionsRequest != null) {
                hideContentView();
                PermissionRequester.instance.onRequestPermissionsResult(this);
            }
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    public static final class PermissionConstants {
        public static final String CALENDAR = "android.permission-group.CALENDAR";
        public static final String CAMERA = "android.permission-group.CAMERA";
        private static final String[] GROUP_CALENDAR = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};
        private static final String[] GROUP_CAMERA = {"android.permission.CAMERA"};
        private static final String[] GROUP_LOCATION = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
        private static final String[] GROUP_MICROPHONE = {"android.permission.RECORD_AUDIO"};
        private static final String[] GROUP_PHONE = {"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS", "android.permission.ANSWER_PHONE_CALLS"};
        private static final String[] GROUP_PHONE_BELOW_O = {"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS"};
        private static final String[] GROUP_SENSORS = {"android.permission.BODY_SENSORS"};
        private static final String[] GROUP_SMS = {"android.permission.SEND_SMS", "android.permission.RECEIVE_SMS", "android.permission.READ_SMS", "android.permission.RECEIVE_WAP_PUSH", "android.permission.RECEIVE_MMS"};
        private static final String[] GROUP_STORAGE;
        public static final String LOCATION = "android.permission-group.LOCATION";
        public static final String MICROPHONE = "android.permission-group.MICROPHONE";
        public static final String PHONE = "android.permission-group.PHONE";
        public static final String SENSORS = "android.permission-group.SENSORS";
        public static final String SMS = "android.permission-group.SMS";
        public static final String STORAGE = "android.permission-group.STORAGE";

        @Retention(RetentionPolicy.SOURCE)
        public @interface Permission {
        }

        static {
            String[] strArr;
            if (Build.VERSION.SDK_INT >= 33) {
                strArr = new String[]{PermissionConfig.READ_MEDIA_IMAGES};
            } else {
                strArr = new String[]{PermissionConfig.READ_EXTERNAL_STORAGE, PermissionConfig.WRITE_EXTERNAL_STORAGE};
            }
            GROUP_STORAGE = strArr;
        }

        public static String[] getPermissions(String str) {
            str.hashCode();
            char c11 = 65535;
            switch (str.hashCode()) {
                case -1410061184:
                    if (str.equals(PHONE)) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -1250730292:
                    if (str.equals(CALENDAR)) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -1140935117:
                    if (str.equals(CAMERA)) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 421761675:
                    if (str.equals(SENSORS)) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 828638019:
                    if (str.equals(LOCATION)) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 852078861:
                    if (str.equals(STORAGE)) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 1581272376:
                    if (str.equals(MICROPHONE)) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 1795181803:
                    if (str.equals(SMS)) {
                        c11 = 7;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    if (TUIBuild.getVersionInt() < 26) {
                        return GROUP_PHONE_BELOW_O;
                    }
                    return GROUP_PHONE;
                case 1:
                    return GROUP_CALENDAR;
                case 2:
                    return GROUP_CAMERA;
                case 3:
                    return GROUP_SENSORS;
                case 4:
                    return GROUP_LOCATION;
                case 5:
                    return GROUP_STORAGE;
                case 6:
                    return GROUP_MICROPHONE;
                case 7:
                    return GROUP_SMS;
                default:
                    return new String[]{str};
            }
        }
    }

    public interface PermissionDialogCallback {
        void onApproved();

        void onRefused();
    }

    public static class PermissionRequestContent {
        public String deniedAlert;
        public int iconResId;
        public String reason;
        public String reasonTitle;

        public void setDeniedAlert(String str) {
            this.deniedAlert = str;
        }

        public void setIconResId(int i11) {
            this.iconResId = i11;
        }

        public void setReason(String str) {
            this.reason = str;
        }

        public void setReasonTitle(String str) {
            this.reasonTitle = str;
        }
    }

    public interface SimpleCallback {
        void onDenied();

        void onGranted();
    }

    private PermissionRequester(String str) {
        this.mCurrentRequestPermission = str;
        for (String str2 : PermissionConstants.getPermissions(str)) {
            if (PERMISSIONS.contains(str2)) {
                this.mPermissions.add(str2);
            }
        }
    }

    private static Context getApplicationContext() {
        if (applicationContext == null) {
            applicationContext = TUIConfig.getAppContext();
        }
        return applicationContext;
    }

    public static List<String> getPermissions() {
        return getPermissions(getApplicationContext().getPackageName());
    }

    private void getPermissionsStatus() {
        for (String next : this.mPermissionsRequest) {
            if (isGranted(next)) {
                this.mPermissionsGranted.add(next);
            } else {
                this.mPermissionsDenied.add(next);
            }
        }
    }

    public static boolean isGranted(String... strArr) {
        for (String isGranted : strArr) {
            if (!isGranted(isGranted)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isIntentAvailable(Intent intent) {
        return getApplicationContext().getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static void launchAppDetailsSettings() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + getApplicationContext().getPackageName()));
        if (isIntentAvailable(intent)) {
            getApplicationContext().startActivity(intent.addFlags(268435456));
        }
    }

    /* access modifiers changed from: private */
    public void onRequestPermissionsResult(Activity activity) {
        getPermissionsStatus();
        if (!this.mPermissionsDenied.isEmpty()) {
            showPermissionDialog(activity, new PermissionDialogCallback() {
                public void onApproved() {
                    if (PermissionRequester.this.mDialogCallback != null) {
                        PermissionRequester.this.mDialogCallback.onApproved();
                    }
                    PermissionDialogCallback unused = PermissionRequester.this.mDialogCallback = null;
                    PermissionRequester.launchAppDetailsSettings();
                }

                public void onRefused() {
                    if (PermissionRequester.this.mDialogCallback != null) {
                        PermissionRequester.this.mDialogCallback.onRefused();
                    }
                    PermissionDialogCallback unused = PermissionRequester.this.mDialogCallback = null;
                }
            });
        } else {
            isRequesting = false;
            this.mDialogCallback = null;
            activity.finish();
        }
        requestCallback();
    }

    public static PermissionRequester permission(String str) {
        return new PermissionRequester(str);
    }

    private void requestCallback() {
        if (this.mSimpleCallback != null) {
            if (this.mPermissionsRequest.size() == 0 || this.mPermissions.size() == this.mPermissionsGranted.size()) {
                this.mSimpleCallback.onGranted();
            } else if (!this.mPermissionsDenied.isEmpty()) {
                this.mSimpleCallback.onDenied();
            }
            this.mSimpleCallback = null;
        }
        if (this.mFullCallback != null) {
            if (this.mPermissionsRequest.size() == 0 || this.mPermissions.size() == this.mPermissionsGranted.size()) {
                this.mFullCallback.onGranted(this.mPermissionsGranted);
            } else if (!this.mPermissionsDenied.isEmpty()) {
                this.mFullCallback.onDenied(this.mPermissionsDenied);
            }
            this.mFullCallback = null;
        }
    }

    public static void setPermissionRequestContent(String str, PermissionRequestContent permissionRequestContent) {
        permissionRequestContentMap.put(str, permissionRequestContent);
    }

    private void startPermissionActivity() {
        this.mPermissionsDenied = new ArrayList();
        Context applicationContext2 = getApplicationContext();
        if (applicationContext2 != null) {
            Intent intent = new Intent(applicationContext2, PermissionActivity.class);
            intent.addFlags(268435456);
            applicationContext2.startActivity(intent);
        }
    }

    public PermissionRequester callback(SimpleCallback simpleCallback) {
        this.mSimpleCallback = simpleCallback;
        return this;
    }

    public PermissionRequester deniedAlert(String str) {
        this.mDeniedAlert = str;
        return this;
    }

    public PermissionRequester permissionDialogCallback(PermissionDialogCallback permissionDialogCallback) {
        this.mDialogCallback = permissionDialogCallback;
        return this;
    }

    public PermissionRequester reason(String str) {
        this.mReason = str;
        return this;
    }

    public PermissionRequester reasonIcon(int i11) {
        this.mIconId = i11;
        return this;
    }

    public PermissionRequester reasonTitle(String str) {
        this.mReasonTitle = str;
        return this;
    }

    public void request() {
        if (!isRequesting) {
            isRequesting = true;
            instance = this;
            this.mPermissionsGranted = new ArrayList();
            this.mPermissionsRequest = new ArrayList();
            if (TUIBuild.getVersionInt() < 23) {
                this.mPermissionsGranted.addAll(this.mPermissions);
                isRequesting = false;
                requestCallback();
                this.mDialogCallback = null;
                return;
            }
            for (String next : this.mPermissions) {
                if (isGranted(next)) {
                    this.mPermissionsGranted.add(next);
                } else {
                    this.mPermissionsRequest.add(next);
                }
            }
            if (this.mPermissionsRequest.isEmpty()) {
                isRequesting = false;
                requestCallback();
                this.mDialogCallback = null;
                return;
            }
            startPermissionActivity();
        }
    }

    public void showPermissionDialog(final Activity activity, final PermissionDialogCallback permissionDialogCallback) {
        PermissionRequestContent permissionRequestContent = permissionRequestContentMap.get(instance.mCurrentRequestPermission);
        String str = this.mDeniedAlert;
        if (permissionRequestContent != null && !TextUtils.isEmpty(permissionRequestContent.deniedAlert)) {
            str = permissionRequestContent.deniedAlert;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.mReason;
        }
        if (TextUtils.isEmpty(str)) {
            isRequesting = false;
            activity.finish();
            permissionDialogCallback.onRefused();
            return;
        }
        activity.setContentView(R.layout.permission_activity_layout);
        View inflate = LayoutInflater.from(activity).inflate(R.layout.permission_tip_layout, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tips)).setText(str);
        final AlertDialog create = new AlertDialog.Builder(activity).setView(inflate).setCancelable(false).setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                boolean unused = PermissionRequester.isRequesting = false;
            }
        }).create();
        ((TextView) inflate.findViewById(R.id.positive_btn)).setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                boolean unused = PermissionRequester.isRequesting = false;
                create.cancel();
                activity.finish();
                permissionDialogCallback.onApproved();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        ((TextView) inflate.findViewById(R.id.negative_btn)).setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                boolean unused = PermissionRequester.isRequesting = false;
                create.cancel();
                activity.finish();
                permissionDialogCallback.onRefused();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        create.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
                if (i11 == 4 && keyEvent.getAction() == 0) {
                    boolean unused = PermissionRequester.isRequesting = false;
                    create.cancel();
                    activity.finish();
                    permissionDialogCallback.onRefused();
                }
                return false;
            }
        });
        create.show();
        Window window = create.getWindow();
        window.setBackgroundDrawable(new ColorDrawable());
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        window.setAttributes(attributes);
    }

    public static List<String> getPermissions(String str) {
        try {
            String[] strArr = getApplicationContext().getPackageManager().getPackageInfo(str, 4096).requestedPermissions;
            if (strArr == null) {
                return Collections.emptyList();
            }
            return Arrays.asList(strArr);
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
            return Collections.emptyList();
        }
    }

    public PermissionRequester callback(FullCallback fullCallback) {
        this.mFullCallback = fullCallback;
        return this;
    }

    private static boolean isGranted(String str) {
        return TUIBuild.getVersionInt() < 23 || ContextCompat.checkSelfPermission(getApplicationContext(), str) == 0;
    }
}
