package com.tencent.qcloud.tuicore.permission;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.interfaces.ITUINotification;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class PermissionRequester {
    public static final String PERMISSION_NOTIFY_EVENT_KEY = "PERMISSION_NOTIFY_EVENT_KEY";
    public static final String PERMISSION_NOTIFY_EVENT_SUB_KEY = "PERMISSION_NOTIFY_EVENT_SUB_KEY";
    public static final String PERMISSION_REQUEST_KEY = "PERMISSION_REQUEST_KEY";
    public static final String PERMISSION_RESULT = "PERMISSION_RESULT";
    private static final String TAG = "PermissionRequester";
    private static AtomicBoolean sIsRequesting = new AtomicBoolean(false);
    private static final Object sLock = new Object();
    private String mDescription;
    private PermissionCallback mPermissionCallback;
    private ITUINotification mPermissionNotification = new e(this);
    private String[] mPermissions;
    private String mSettingsTip;
    private String mTitle;

    private PermissionRequester(String... strArr) {
        this.mPermissions = strArr;
    }

    private void afterPermissionDenied() {
        TUICore.unRegisterEvent(PERMISSION_NOTIFY_EVENT_KEY, PERMISSION_NOTIFY_EVENT_SUB_KEY, this.mPermissionNotification);
        sIsRequesting.set(false);
        PermissionCallback permissionCallback = this.mPermissionCallback;
        if (permissionCallback != null) {
            permissionCallback.onDenied();
            this.mPermissionCallback = null;
        }
    }

    private void afterPermissionGranted() {
        TUICore.unRegisterEvent(PERMISSION_NOTIFY_EVENT_KEY, PERMISSION_NOTIFY_EVENT_SUB_KEY, this.mPermissionNotification);
        sIsRequesting.set(false);
        PermissionCallback permissionCallback = this.mPermissionCallback;
        if (permissionCallback != null) {
            permissionCallback.onGranted();
            this.mPermissionCallback = null;
        }
    }

    private String[] findUnauthorizedPermissions(String[] strArr) {
        Context appContext = TUIConfig.getAppContext();
        if (appContext == null) {
            Log.e(TAG, "findUnauthorizedPermissions appContext is null");
            return strArr;
        }
        LinkedList linkedList = new LinkedList();
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(appContext, str) != 0) {
                linkedList.add(str);
            }
        }
        return (String[]) linkedList.toArray(new String[0]);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(String str, String str2, Map map) {
        Object obj;
        if (map != null && (obj = map.get(PERMISSION_RESULT)) != null && (obj instanceof Boolean)) {
            if (((Boolean) obj).booleanValue()) {
                afterPermissionGranted();
            } else {
                afterPermissionDenied();
            }
        }
    }

    public static PermissionRequester newInstance(String... strArr) {
        return new PermissionRequester(strArr);
    }

    private void startPermissionActivity(RequestData requestData) {
        Context appContext = TUIConfig.getAppContext();
        if (appContext != null) {
            Intent intent = new Intent(appContext, PermissionActivity.class);
            intent.putExtra(PERMISSION_REQUEST_KEY, requestData);
            intent.addFlags(268435456);
            appContext.startActivity(intent);
        }
    }

    public PermissionRequester callback(PermissionCallback permissionCallback) {
        this.mPermissionCallback = permissionCallback;
        return this;
    }

    public PermissionRequester description(String str) {
        this.mDescription = str;
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        com.tencent.qcloud.tuicore.TUICore.registerEvent(PERMISSION_NOTIFY_EVENT_KEY, PERMISSION_NOTIFY_EVENT_SUB_KEY, r5.mPermissionNotification);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002f, code lost:
        if (com.tencent.qcloud.tuicore.util.TUIBuild.getVersionInt() >= 23) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
        android.util.Log.i(TAG, "current version is lower than 23");
        afterPermissionGranted();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
        r0 = findUnauthorizedPermissions(r5.mPermissions);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        if (r0.length > 0) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0045, code lost:
        afterPermissionGranted();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0048, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        startPermissionActivity(new com.tencent.qcloud.tuicore.permission.PermissionRequester.RequestData(r5.mTitle, r5.mDescription, r5.mSettingsTip, r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0057, code lost:
        return;
     */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void request() {
        /*
            r5 = this;
            java.lang.Object r0 = sLock
            monitor-enter(r0)
            java.util.concurrent.atomic.AtomicBoolean r1 = sIsRequesting     // Catch:{ all -> 0x0058 }
            boolean r1 = r1.get()     // Catch:{ all -> 0x0058 }
            if (r1 == 0) goto L_0x0019
            java.lang.String r1 = "PermissionRequester"
            java.lang.String r2 = "can not request during requesting"
            android.util.Log.e(r1, r2)     // Catch:{ all -> 0x0058 }
            com.tencent.qcloud.tuicore.permission.PermissionCallback r1 = r5.mPermissionCallback     // Catch:{ all -> 0x0058 }
            r1.onDenied()     // Catch:{ all -> 0x0058 }
            monitor-exit(r0)     // Catch:{ all -> 0x0058 }
            return
        L_0x0019:
            java.util.concurrent.atomic.AtomicBoolean r1 = sIsRequesting     // Catch:{ all -> 0x0058 }
            r2 = 1
            r1.set(r2)     // Catch:{ all -> 0x0058 }
            monitor-exit(r0)     // Catch:{ all -> 0x0058 }
            java.lang.String r0 = "PERMISSION_NOTIFY_EVENT_KEY"
            java.lang.String r1 = "PERMISSION_NOTIFY_EVENT_SUB_KEY"
            com.tencent.qcloud.tuicore.interfaces.ITUINotification r2 = r5.mPermissionNotification
            com.tencent.qcloud.tuicore.TUICore.registerEvent(r0, r1, r2)
            int r0 = com.tencent.qcloud.tuicore.util.TUIBuild.getVersionInt()
            r1 = 23
            if (r0 >= r1) goto L_0x003c
            java.lang.String r0 = "PermissionRequester"
            java.lang.String r1 = "current version is lower than 23"
            android.util.Log.i(r0, r1)
            r5.afterPermissionGranted()
            return
        L_0x003c:
            java.lang.String[] r0 = r5.mPermissions
            java.lang.String[] r0 = r5.findUnauthorizedPermissions(r0)
            int r1 = r0.length
            if (r1 > 0) goto L_0x0049
            r5.afterPermissionGranted()
            return
        L_0x0049:
            com.tencent.qcloud.tuicore.permission.PermissionRequester$RequestData r1 = new com.tencent.qcloud.tuicore.permission.PermissionRequester$RequestData
            java.lang.String r2 = r5.mTitle
            java.lang.String r3 = r5.mDescription
            java.lang.String r4 = r5.mSettingsTip
            r1.<init>(r2, r3, r4, r0)
            r5.startPermissionActivity(r1)
            return
        L_0x0058:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0058 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuicore.permission.PermissionRequester.request():void");
    }

    public PermissionRequester settingsTip(String str) {
        this.mSettingsTip = str;
        return this;
    }

    public PermissionRequester title(String str) {
        this.mTitle = str;
        return this;
    }

    public static class RequestData implements Parcelable {
        public static final Parcelable.Creator<RequestData> CREATOR = new Parcelable.Creator<RequestData>() {
            public RequestData createFromParcel(Parcel parcel) {
                return new RequestData(parcel);
            }

            public RequestData[] newArray(int i11) {
                return new RequestData[i11];
            }
        };
        private final String mDescription;
        private int mPermissionIconId;
        private final String[] mPermissions;
        private final String mSettingsTip;
        private final String mTitle;

        public RequestData(String str, String str2, String str3, String... strArr) {
            this.mTitle = str;
            this.mDescription = str2;
            this.mSettingsTip = str3;
            this.mPermissions = (String[]) strArr.clone();
        }

        public int describeContents() {
            return 0;
        }

        public String getDescription() {
            return this.mDescription;
        }

        public int getPermissionIconId() {
            return this.mPermissionIconId;
        }

        public String[] getPermissions() {
            return (String[]) this.mPermissions.clone();
        }

        public String getSettingsTip() {
            return this.mSettingsTip;
        }

        public String getTitle() {
            return this.mTitle;
        }

        public boolean isPermissionsExistEmpty() {
            String[] strArr = this.mPermissions;
            if (strArr == null || strArr.length <= 0) {
                return true;
            }
            for (String isEmpty : strArr) {
                if (TextUtils.isEmpty(isEmpty)) {
                    return true;
                }
            }
            return false;
        }

        public void setPermissionIconId(int i11) {
            this.mPermissionIconId = i11;
        }

        public String toString() {
            return "PermissionRequest{mPermissions=" + Arrays.toString(this.mPermissions) + ", mTitle=" + this.mTitle + ", mDescription='" + this.mDescription + ", mSettingsTip='" + this.mSettingsTip + '}';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeStringArray(this.mPermissions);
            parcel.writeString(this.mTitle);
            parcel.writeString(this.mDescription);
            parcel.writeString(this.mSettingsTip);
            parcel.writeInt(this.mPermissionIconId);
        }

        public RequestData(Parcel parcel) {
            this.mPermissions = parcel.createStringArray();
            this.mTitle = parcel.readString();
            this.mDescription = parcel.readString();
            this.mSettingsTip = parcel.readString();
            this.mPermissionIconId = parcel.readInt();
        }
    }
}
