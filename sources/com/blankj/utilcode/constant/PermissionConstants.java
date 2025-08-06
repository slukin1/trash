package com.blankj.utilcode.constant;

import android.annotation.SuppressLint;
import android.os.Build;
import com.google.android.gms.stats.CodePackage;
import com.luck.picture.lib.permissions.PermissionConfig;

@SuppressLint({"InlinedApi"})
public final class PermissionConstants {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f63290a = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f63291b = {"android.permission.CAMERA"};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f63292c = {"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS"};

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f63293d = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION"};

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f63294e = {"android.permission.RECORD_AUDIO"};

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f63295f = {"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS", "android.permission.ANSWER_PHONE_CALLS"};

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f63296g = {"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS"};

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f63297h = {"android.permission.BODY_SENSORS"};

    /* renamed from: i  reason: collision with root package name */
    public static final String[] f63298i = {"android.permission.SEND_SMS", "android.permission.RECEIVE_SMS", "android.permission.READ_SMS", "android.permission.RECEIVE_WAP_PUSH", "android.permission.RECEIVE_MMS"};

    /* renamed from: j  reason: collision with root package name */
    public static final String[] f63299j = {PermissionConfig.READ_EXTERNAL_STORAGE, PermissionConfig.WRITE_EXTERNAL_STORAGE};

    /* renamed from: k  reason: collision with root package name */
    public static final String[] f63300k = {"android.permission.ACTIVITY_RECOGNITION"};

    public static String[] a(String str) {
        if (str == null) {
            return new String[0];
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1611296843:
                if (str.equals(CodePackage.LOCATION)) {
                    c11 = 0;
                    break;
                }
                break;
            case -1596608551:
                if (str.equals("SENSORS")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1166291365:
                if (str.equals("STORAGE")) {
                    c11 = 2;
                    break;
                }
                break;
            case 82233:
                if (str.equals("SMS")) {
                    c11 = 3;
                    break;
                }
                break;
            case 76105038:
                if (str.equals("PHONE")) {
                    c11 = 4;
                    break;
                }
                break;
            case 140654183:
                if (str.equals("ACTIVITY_RECOGNITION")) {
                    c11 = 5;
                    break;
                }
                break;
            case 215175251:
                if (str.equals("CONTACTS")) {
                    c11 = 6;
                    break;
                }
                break;
            case 604302142:
                if (str.equals("CALENDAR")) {
                    c11 = 7;
                    break;
                }
                break;
            case 1856013610:
                if (str.equals("MICROPHONE")) {
                    c11 = 8;
                    break;
                }
                break;
            case 1980544805:
                if (str.equals("CAMERA")) {
                    c11 = 9;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return f63293d;
            case 1:
                return f63297h;
            case 2:
                return f63299j;
            case 3:
                return f63298i;
            case 4:
                if (Build.VERSION.SDK_INT < 26) {
                    return f63296g;
                }
                return f63295f;
            case 5:
                return f63300k;
            case 6:
                return f63292c;
            case 7:
                return f63290a;
            case 8:
                return f63294e;
            case 9:
                return f63291b;
            default:
                return new String[]{str};
        }
    }
}
