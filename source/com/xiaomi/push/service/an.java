package com.xiaomi.push.service;

public abstract class an {
    public static String A = "ext_token";
    public static String B = "ext_auth_method";
    public static String C = "ext_security";
    public static String D = "ext_kick";
    public static String E = "ext_client_attr";
    public static String F = "ext_cloud_attr";
    public static String G = "ext_pkg_name";
    public static String H = "ext_notify_id";
    public static String I = "ext_clicked_button";
    public static String J = "ext_notify_type";
    public static String K = "ext_session";
    public static String L = "sig";
    public static String M = "ext_notify_title";
    public static String N = "ext_notify_description";
    public static String O = "ext_messenger";
    public static String P = "title";
    public static String Q = "description";
    public static String R = "notifyId";
    public static String S = "dump";

    /* renamed from: a  reason: collision with root package name */
    public static String f52484a = "1";

    /* renamed from: b  reason: collision with root package name */
    public static String f52485b = "2";

    /* renamed from: c  reason: collision with root package name */
    public static String f52486c = "3";

    /* renamed from: d  reason: collision with root package name */
    public static String f52487d = "com.xiaomi.push.OPEN_CHANNEL";

    /* renamed from: e  reason: collision with root package name */
    public static String f52488e = "com.xiaomi.push.SEND_MESSAGE";

    /* renamed from: f  reason: collision with root package name */
    public static String f52489f = "com.xiaomi.push.SEND_IQ";

    /* renamed from: g  reason: collision with root package name */
    public static String f52490g = "com.xiaomi.push.BATCH_SEND_MESSAGE";

    /* renamed from: h  reason: collision with root package name */
    public static String f52491h = "com.xiaomi.push.SEND_PRES";

    /* renamed from: i  reason: collision with root package name */
    public static String f52492i = "com.xiaomi.push.CLOSE_CHANNEL";

    /* renamed from: j  reason: collision with root package name */
    public static String f52493j = "com.xiaomi.push.FORCE_RECONN";

    /* renamed from: k  reason: collision with root package name */
    public static String f52494k = "com.xiaomi.push.RESET_CONN";

    /* renamed from: l  reason: collision with root package name */
    public static String f52495l = "com.xiaomi.push.UPDATE_CHANNEL_INFO";

    /* renamed from: m  reason: collision with root package name */
    public static String f52496m = "com.xiaomi.push.SEND_STATS";

    /* renamed from: n  reason: collision with root package name */
    public static String f52497n = "com.xiaomi.push.HANDLE_FCM_MSG";

    /* renamed from: o  reason: collision with root package name */
    public static String f52498o = "com.xiaomi.push.APP_NOTIFY_MSG";

    /* renamed from: p  reason: collision with root package name */
    public static String f52499p = "com.xiaomi.push.SDK_START_ACTIVITY_EVENT_MSG";

    /* renamed from: q  reason: collision with root package name */
    public static String f52500q = "com.xiaomi.push.CHANGE_HOST";

    /* renamed from: r  reason: collision with root package name */
    public static String f52501r = "com.xiaomi.push.PING_TIMER";

    /* renamed from: s  reason: collision with root package name */
    public static String f52502s = "com.xiaomi.push.APP_CHANNEL_SWITCH";

    /* renamed from: t  reason: collision with root package name */
    public static String f52503t = "ext_user_id";

    /* renamed from: u  reason: collision with root package name */
    public static String f52504u = "ext_user_server";

    /* renamed from: v  reason: collision with root package name */
    public static String f52505v = "ext_user_res";

    /* renamed from: w  reason: collision with root package name */
    public static String f52506w = "ext_chid";

    /* renamed from: x  reason: collision with root package name */
    public static String f52507x = "ext_receive_time";

    /* renamed from: y  reason: collision with root package name */
    public static String f52508y = "ext_broadcast_time";

    /* renamed from: z  reason: collision with root package name */
    public static String f52509z = "ext_sid";

    public static String a(int i11) {
        switch (i11) {
            case 0:
                return "ERROR_OK";
            case 1:
                return "ERROR_SERVICE_NOT_INSTALLED";
            case 2:
                return "ERROR_NETWORK_NOT_AVAILABLE";
            case 3:
                return "ERROR_NETWORK_FAILED";
            case 4:
                return "ERROR_ACCESS_DENIED";
            case 5:
                return "ERROR_AUTH_FAILED";
            case 6:
                return "ERROR_MULTI_LOGIN";
            case 7:
                return "ERROR_SERVER_ERROR";
            case 8:
                return "ERROR_RECEIVE_TIMEOUT";
            case 9:
                return "ERROR_READ_ERROR";
            case 10:
                return "ERROR_SEND_ERROR";
            case 11:
                return "ERROR_RESET";
            case 12:
                return "ERROR_NO_CLIENT";
            case 13:
                return "ERROR_SERVER_STREAM";
            case 14:
                return "ERROR_THREAD_BLOCK";
            case 15:
                return "ERROR_SERVICE_DESTROY";
            case 16:
                return "ERROR_SESSION_CHANGED";
            case 17:
                return "ERROR_READ_TIMEOUT";
            case 18:
                return "ERROR_CONNECTIING_TIMEOUT";
            case 19:
                return "ERROR_USER_BLOCKED";
            case 20:
                return "ERROR_REDIRECT";
            case 21:
                return "ERROR_BIND_TIMEOUT";
            case 22:
                return "ERROR_PING_TIMEOUT";
            default:
                return String.valueOf(i11);
        }
    }
}
