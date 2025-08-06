package com.huobi.permission.runtime;

import android.os.Build;
import com.luck.picture.lib.permissions.PermissionConfig;

public class Permission {

    public static final class Group {

        /* renamed from: a  reason: collision with root package name */
        public static final String[] f80322a = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};

        /* renamed from: b  reason: collision with root package name */
        public static final String[] f80323b = {"android.permission.CAMERA"};

        /* renamed from: c  reason: collision with root package name */
        public static final String[] f80324c = {"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS"};

        /* renamed from: d  reason: collision with root package name */
        public static final String[] f80325d = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};

        /* renamed from: e  reason: collision with root package name */
        public static final String[] f80326e = {"android.permission.RECORD_AUDIO"};

        /* renamed from: f  reason: collision with root package name */
        public static final String[] f80327f;

        /* renamed from: g  reason: collision with root package name */
        public static final String[] f80328g = {"android.permission.BODY_SENSORS"};

        /* renamed from: h  reason: collision with root package name */
        public static final String[] f80329h = {"android.permission.SEND_SMS", "android.permission.RECEIVE_SMS", "android.permission.READ_SMS", "android.permission.RECEIVE_WAP_PUSH", "android.permission.RECEIVE_MMS"};

        /* renamed from: i  reason: collision with root package name */
        public static final String[] f80330i = {PermissionConfig.READ_EXTERNAL_STORAGE, PermissionConfig.WRITE_EXTERNAL_STORAGE};

        static {
            if (Build.VERSION.SDK_INT >= 26) {
                f80327f = new String[]{"android.permission.READ_PHONE_STATE", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS", "android.permission.READ_PHONE_NUMBERS", "android.permission.ANSWER_PHONE_CALLS"};
            } else {
                f80327f = new String[]{"android.permission.READ_PHONE_STATE", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS"};
            }
        }
    }
}
